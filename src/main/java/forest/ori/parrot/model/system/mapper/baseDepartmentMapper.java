package forest.ori.parrot.model.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import forest.ori.parrot.pojo.systemModel.baseDepartment;
import forest.ori.parrot.pojo.systemModel.baseUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface baseDepartmentMapper extends  BaseMapper<baseDepartment> {

}
