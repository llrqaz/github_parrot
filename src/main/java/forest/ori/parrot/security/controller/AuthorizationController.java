package forest.ori.parrot.security.controller;

import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.SpecCaptcha;
import forest.ori.parrot.common.annotation.AnonymousAccess;
import forest.ori.parrot.common.exception.BusinessException;
import forest.ori.parrot.common.utils.JwtTokenUtils;
import forest.ori.parrot.common.utils.RedisUtils;
import forest.ori.parrot.common.utils.RsaUtils;
import forest.ori.parrot.security.dto.PCAuthDto;
import forest.ori.parrot.security.dto.captchaDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Api(tags = "系统：系统授权接口")
public class AuthorizationController {
    @Autowired
    private RedisUtils redisUtil;
    @Value("${RSA.PRIVATEKEY}")
    private  String privateKey;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    private JwtTokenUtils tokenUtils;
    @ApiOperation("获取验证码")
    @AnonymousAccess
    @GetMapping("/captcha")
    public ResponseEntity<Object>  captcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha (130, 48, 4);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        // 存入redis并设置过期时间为5分钟
        redisUtil.set(key, verCode, 60 * 5);
        // 将key和base64返回给前端
        return ResponseEntity.ok(new captchaDto(key, specCaptcha.toBase64()));
    }


    @ApiOperation("PC登录授权")
    @AnonymousAccess
    @PostMapping("login")
    public ResponseEntity<Object> login(@Validated @RequestBody PCAuthDto authUser, HttpServletRequest request) throws Exception {
        // 密码解密 这个要Try起来, 要报错.
//        String password = RsaUtils.decryptByPrivateKey(privateKey, authUser.getPassword());
        String password = authUser.getPassword();
//        // 根据KEY 获取缓存中的验证码
//        String captchaData =  redisUtil.get(authUser.getCaptchaKey());
//        // 验证码一旦被使用就立即销毁。不管成功不成功,在不在
//        redisUtil.delete(authUser.getCaptchaKey());
//
//        if (StringUtils.isBlank(captchaData)){
//            throw new BusinessException("验证码不存在或已过期");
//        }else if (! captchaData.equals(authUser.getCaptchaData())){
//            throw  new BusinessException("验证码错误");
//        }
        //为了Spring Security  颁发凭证 数据，必须按照它的方式 将用户名密码 进行包装1次，
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authUser.getAccount(), password);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenUtils.createToken(authentication);
       // final JwtUserDto jwtUserDto = (JwtUserDto) authentication.getPrincipal();
        return  ResponseEntity.ok(null);
    }
}
