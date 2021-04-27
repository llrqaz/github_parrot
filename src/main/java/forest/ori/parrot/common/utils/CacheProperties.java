package forest.ori.parrot.common.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "cache")
public class CacheProperties {

    /**
     * 登录用户是否缓存
     */
    private boolean loginUserCache;

    /**
     * 字典是否缓存
     */
    private boolean dictChche;

    /**
     * 部门是否缓存
     */
    private boolean deptChache;

    /**
     * 岗位是否缓存
     */
    private boolean post_cache;
}
