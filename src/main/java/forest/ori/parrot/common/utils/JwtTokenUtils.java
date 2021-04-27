package forest.ori.parrot.common.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import forest.ori.parrot.security.util.JwtSecurityProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.Decoders;

import java.security.Key;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenUtils implements InitializingBean {

    private JwtSecurityProperties jwtSecurityProperties;

    private static final String AUTHORITIES_KEY = "PARROT_USER";
    @Autowired
    private  RedisUtils redisUtils;

    private Key key;

    public JwtTokenUtils(JwtSecurityProperties jwtSecurityProperties) {
        this.jwtSecurityProperties = jwtSecurityProperties;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecurityProperties.getBase64Secret());
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * 创建token
     * @param authentication
     * @return
     */
    public String createToken(Authentication authentication) {
        return  Jwts.builder()
                //设置ID
                .setId(UUID.randomUUID().toString())
                //我需要在Token中签署的信息
                .claim(AUTHORITIES_KEY, authentication.getName())
                //不要时间，丢给Redis去自动过期
                //签发时间
                //  .setIssuedAt(new Date())
                //过期时间
                //  .setExpiration(new Date((new Date()).getTime() + jwtSecurityProperties.getTokenValidityInSeconds()))
                //Token压缩方式
                .compressWith(CompressionCodecs.DEFLATE)
                //设置主题
                .setSubject(authentication.getName())
                .signWith(key,SignatureAlgorithm.HS512)
                .compact();
    }


    /**
     * @param token 需要检查的token
     */
    public void checkRenewal(String token) {
        // 判断是否续期token,计算token的过期时间
        long time = redisUtils.getExpire(token) * 1000;
        Date expireDate = DateUtil.offset(new Date(), DateField.MILLISECOND, (int) time);
      // 判断当前时间与过期时间的时间差
      long differ = expireDate.getTime() - System.currentTimeMillis();
      // 如果在续期检查的范围内，则续费   1800000 == 30分钟左右
      if (differ <= 1800000) {
          long renew = time + 3600000;
          //续费操作，网管再来10块钱的王菲
          redisUtils.expire(token, renew, TimeUnit.MILLISECONDS);
      }
    }
    /**
     * 获取认证
     * @param token
     * @return
     */
    public Authentication getAuthentication(String token) {
        Claims claims = getClaimsFromToken(token);
        if (claims == null ) return  null;
        User principal = new User(claims.getSubject(), "******", new ArrayList<>());
        return new UsernamePasswordAuthenticationToken(principal, token, new ArrayList<>());
    }

    /**
     * 令牌的有效性校验
     * @param authToken
     * @return
     */
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("无效令牌的签名.");
            e.printStackTrace();
        } catch (ExpiredJwtException e) {
            log.info("令牌已过期.");
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            log.info("令牌错误.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            log.info("令牌契约失效.");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取令牌主体
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
