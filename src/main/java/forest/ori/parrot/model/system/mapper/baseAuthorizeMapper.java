package forest.ori.parrot.model.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import forest.ori.parrot.pojo.systemModel.baseAuthorize;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
@Mapper
public interface baseAuthorizeMapper extends BaseMapper<baseAuthorize> {

}
