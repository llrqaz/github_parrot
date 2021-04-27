package forest.ori.parrot.security.service;

import forest.ori.parrot.common.enums.wheatherEnum;
import forest.ori.parrot.common.exception.BusinessException;
import forest.ori.parrot.common.utils.CacheProperties;
import forest.ori.parrot.model.system.service.baseAuthorizeService;
import forest.ori.parrot.model.system.service.baseUserService;
import forest.ori.parrot.model.system.service.baseUserrelationService;
import forest.ori.parrot.pojo.systemModel.baseUser;
import forest.ori.parrot.security.dto.SelfUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class SelfUserDetailsService implements UserDetailsService {

    private final CacheProperties cacheProperties;

    /**
     * 用户基础
     */
    private final baseUserService userService;
    /**
     * 用户关系
     */
    private final baseUserrelationService userrelationService;

    /**
     * 用户权限
     */
    private final baseAuthorizeService authorizeService;

    /**
     * 用户缓存对象
     */
    static Map<String, SelfUserDetails> userDtoCache = new ConcurrentHashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SelfUserDetails userDetails = null;
        baseUser user = null;
        //构建用户信息的逻辑(取数据库/LDAP等用户信息)
        if (cacheProperties.isLoginUserCache() && userDtoCache.containsKey(username)) {
            userDetails = userDtoCache.get(username);
            return userDetails;
        }
        user = userService.findUserByAccount(username);
        if (!wheatherEnum.getBool(user.getEnabledMark())) {
            throw new BusinessException("账号未启用");
        }
        userDetails = new SelfUserDetails(
                user,
                userrelationService.findUserDepartment(userDetails.getUser().getId()),
                userrelationService.findUserCompany(userDetails.getUser().getId()),
                userrelationService.findUserPost(userDetails.getUser().getId()),
                authorizeService.findUserPermission(userDetails.getUser())
        );
        userDtoCache.put(username, userDetails);
        return userDetails;
    }

}