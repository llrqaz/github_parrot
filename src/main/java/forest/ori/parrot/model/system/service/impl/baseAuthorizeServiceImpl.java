package forest.ori.parrot.model.system.service.impl;

import forest.ori.parrot.model.system.mapper.baseAuthorizeMapper;
import forest.ori.parrot.model.system.service.baseAuthorizeService;
import forest.ori.parrot.model.system.service.baseModuleService;
import forest.ori.parrot.pojo.systemModel.baseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class baseAuthorizeServiceImpl implements baseAuthorizeService {

    @Autowired
    private baseModuleService moduleService;

    @Override
    public List<GrantedAuthority> findUserPermission(baseUser user) {
        //如果是超级管理员就给他一个全部授权
        if (user.getAccount().equals("PARROT_ADMIN")) {
            return moduleService.getAllModulesPermissions().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }
        return moduleService.findUserPermissions(user.getId()).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
