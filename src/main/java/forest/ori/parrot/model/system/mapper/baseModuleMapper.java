package forest.ori.parrot.model.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import forest.ori.parrot.pojo.systemModel.baseModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;
@Mapper
public interface baseModuleMapper  extends BaseMapper<baseModule> {
    Set<String> findUserPermissions(String userid);
}
