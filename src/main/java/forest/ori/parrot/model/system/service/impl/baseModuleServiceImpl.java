package forest.ori.parrot.model.system.service.impl;

import forest.ori.parrot.model.system.mapper.baseModuleMapper;
import forest.ori.parrot.model.system.service.baseModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class baseModuleServiceImpl  implements baseModuleService {
    @Autowired
    private baseModuleMapper  mapper;


    @Override
    public Set<String> getAllModulesPermissions() {
         return mapper.selectList(null).stream().map(x ->x.getPermission()).collect(Collectors.toSet());
    }

    @Override
    public Set<String> findUserPermissions(String uid) {
        return mapper.findUserPermissions(uid).stream().collect(Collectors.toSet());
    }
}
