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
 * 角色信息表
 */
@Data
@ApiModel(" 角色信息表 ")
@TableName("base_role")
public class baseRole implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "角色主键")
    @TableField(value = "id")
    private String id;

    @ApiModelProperty(value = "分类")
    @TableField(value = "Category")
    private String category;

    @ApiModelProperty(value = "角色编码")
    @TableField(value = "EnCode")
    private String enCode;

    @ApiModelProperty(value = "角色名称")
    @TableField(value = "FullName")
    private String fullName;

    @ApiModelProperty(value = "排序码")
    @TableField(value = "SortCode")
    private Integer sortCode;

    @ApiModelProperty(value = "删除标记")
    @TableField(value = "DeleteMark")
    private Integer deleteMark;

    @ApiModelProperty(value = "有效标志")
    @TableField(value = "EnabledMark")
    private Integer enabledMark;

    @ApiModelProperty(value = "备注")
    @TableField(value = "Description")
    private String description;

    @ApiModelProperty(value = "创建日期")
    @TableField(value = "CreateDate")
    private Date createDate;

    @ApiModelProperty(value = "创建用户主键")
    @TableField(value = "CreateUserId")
    private String createUserId;

    @ApiModelProperty(value = "创建用户")
    @TableField(value = "CreateUserName")
    private String createUserName;

    @ApiModelProperty(value = "修改日期")
    @TableField(value = "ModifyDate")
    private Date modifyDate;

    @ApiModelProperty(value = "修改用户主键")
    @TableField(value = "ModifyUserId")
    private String modifyUserId;

    @ApiModelProperty(value = "修改用户")
    @TableField(value = "ModifyUserName")
    private String modifyUserName;


}
