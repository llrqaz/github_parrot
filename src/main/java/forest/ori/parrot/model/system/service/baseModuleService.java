package forest.ori.parrot.model.system.service;

import java.util.Set;

public interface baseModuleService {
    Set<String> getAllModulesPermissions();
    Set<String> findUserPermissions(String uid);
}
