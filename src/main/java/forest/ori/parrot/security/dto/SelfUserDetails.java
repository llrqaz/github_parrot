package forest.ori.parrot.security.dto;

import com.alibaba.fastjson.annotation.JSONField;
import forest.ori.parrot.common.enums.wheatherEnum;
import forest.ori.parrot.pojo.systemModel.baseCompany;
import forest.ori.parrot.pojo.systemModel.baseDepartment;
import forest.ori.parrot.pojo.systemModel.basePost;
import forest.ori.parrot.pojo.systemModel.baseUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  ① 定义 user 对象
 */
@Getter
@AllArgsConstructor
public class SelfUserDetails implements UserDetails, Serializable {
    /**
     * 用户基础信息
     */
    private final baseUser user;
    /**
     * 用户部门信息
     */
    private final List<baseDepartment> department;
    /**
     * 用户企业信息
     */
    private final List<baseCompany> company;
    /**
     * 用户岗位信息
     */
    private final List<basePost> post;

    @JSONField(serialize = false)
    private final List<GrantedAuthority> authorities;

    public Set<String> getRoles() {
        return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    }

    @Override
    @JSONField(serialize = false)
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    @JSONField(serialize = false)
    public String getUsername() {
        return user.getAccount();
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JSONField(serialize = false)
    public boolean isEnabled() {
        return wheatherEnum.getBool(user.getEnabledMark());
    }
}
