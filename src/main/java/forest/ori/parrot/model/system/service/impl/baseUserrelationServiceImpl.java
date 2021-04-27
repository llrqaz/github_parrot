package forest.ori.parrot.model.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import forest.ori.parrot.model.system.mapper.baseUserrelationMapper;
import forest.ori.parrot.model.system.service.*;
import forest.ori.parrot.pojo.systemModel.baseCompany;
import forest.ori.parrot.pojo.systemModel.baseDepartment;
import forest.ori.parrot.pojo.systemModel.basePost;
import forest.ori.parrot.pojo.systemModel.baseUserrelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class baseUserrelationServiceImpl  implements baseUserrelationService {


    @Autowired
    private baseUserrelationMapper mapper;

    @Override
    public List<baseCompany> findUserCompany(String uid) {
        return mapper.findUserCompany(uid);
    }

    @Override
    public List<basePost> findUserPost(String uid) {
        return mapper.findUserPost(uid);
    }

    @Override
    public List<baseDepartment> findUserDepartment(String uid) {
        return mapper.findUserDepartment(uid);
    }

    @Override
    public List<baseUserrelation> findAllListForUser(String uid) {
        return findListForUser(uid, -1);
    }

    @Override
    public List<baseUserrelation> findPostListForUser(String uid) {
        return findListForUser(uid, 2);

    }

    @Override
    public List<baseUserrelation> findRoleListForUser(String uid) {
        return findListForUser(uid, 1);
    }

    private List<baseUserrelation> findListForUser(String uid, int type) {
        QueryWrapper<baseUserrelation> userrelationQueryWrapper = new QueryWrapper<>();
        userrelationQueryWrapper.eq("UserId", uid);
        if (type != -1) {
            userrelationQueryWrapper.eq("Category", type);
        }
        return mapper.selectList(userrelationQueryWrapper);
    }
}
