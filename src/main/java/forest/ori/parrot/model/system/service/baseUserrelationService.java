package forest.ori.parrot.model.system.service;

import forest.ori.parrot.pojo.systemModel.baseCompany;
import forest.ori.parrot.pojo.systemModel.baseDepartment;
import forest.ori.parrot.pojo.systemModel.basePost;
import forest.ori.parrot.pojo.systemModel.baseUserrelation;

import java.util.List;

public interface baseUserrelationService {

    List<baseCompany> findUserCompany(String uid);

    List<basePost> findUserPost(String uid);

    List<baseDepartment> findUserDepartment(String uid);

    List<baseUserrelation> findAllListForUser(String uid);

    List<baseUserrelation> findPostListForUser(String uid);

    List<baseUserrelation> findRoleListForUser(String uid);
}
