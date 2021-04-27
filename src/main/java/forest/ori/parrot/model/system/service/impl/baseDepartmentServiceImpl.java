package forest.ori.parrot.model.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import forest.ori.parrot.common.exception.BusinessException;
import forest.ori.parrot.model.system.mapper.baseDepartmentMapper;
import forest.ori.parrot.model.system.mapper.baseUserMapper;
import forest.ori.parrot.model.system.service.baseDepartmentService;
import forest.ori.parrot.model.system.service.baseUserService;
import forest.ori.parrot.pojo.systemModel.baseDepartment;
import forest.ori.parrot.pojo.systemModel.baseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class baseDepartmentServiceImpl implements baseDepartmentService {
    @Autowired
    private baseDepartmentMapper mapper;
    @Override
    public List<baseDepartment> findAll() {
        return mapper.selectList(null);
    }
}