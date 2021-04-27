package forest.ori.parrot.model.system.service;

import forest.ori.parrot.pojo.systemModel.baseUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface baseAuthorizeService {
    List<GrantedAuthority> findUserPermission(baseUser user);
}
