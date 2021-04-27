package forest.ori.parrot.model.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import forest.ori.parrot.pojo.systemModel.baseCompany;
import forest.ori.parrot.pojo.systemModel.baseDepartment;
import forest.ori.parrot.pojo.systemModel.basePost;
import forest.ori.parrot.pojo.systemModel.baseUserrelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface baseUserrelationMapper  extends BaseMapper<baseUserrelation> {

    List<baseCompany> findUserCompany(String userid);

    List<basePost> findUserPost(String userid);

    List<baseDepartment> findUserDepartment(String userid);

}
