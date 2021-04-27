package forest.ori.parrot.model.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import forest.ori.parrot.common.exception.BusinessException;
import forest.ori.parrot.model.system.mapper.baseUserMapper;
import forest.ori.parrot.model.system.service.baseUserService;
import forest.ori.parrot.pojo.systemModel.baseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class baseUserServiceImpl implements baseUserService {

    @Autowired
    private   baseUserMapper userMapper;
    @Override
    public baseUser findUserByAccount(String Account) {
        QueryWrapper<baseUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("Account",Account);
        List<baseUser> userList =  userMapper.selectList(userQueryWrapper);
        if (userList.size() == 0  || userList.size() > 1 ){
            throw  new BusinessException("找到过多的用户");
        }
        return  userList.get(0);
    }
}
