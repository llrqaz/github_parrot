package forest.ori.parrot.pojo.systemModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.CallNode;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
/**
 * 用户关系表
 */
@Data
@ApiModel(" 用户关系表 ")
@TableName("base_userrelation")
public class baseUserrelation implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "用户关系主键")
    @TableField(value = "id")
    private String id;

    @ApiModelProperty(value = "用户主键")
    @TableField(value = "UserId")
    private String userId;

    @ApiModelProperty(value = "分类:1-角色2-岗位")
    @TableField(value = "Category")
    private Integer category;

    @ApiModelProperty(value = "对象主键")
    @TableField(value = "ObjectId")
    private String objectId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CreateDate")
    private Date createDate;

    @ApiModelProperty(value = "创建用户主键")
    @TableField(value = "CreateUserId")
    private String createUserId;

    @ApiModelProperty(value = "创建用户")
    @TableField(value = "CreateUserName")
    private String createUserName;
}
