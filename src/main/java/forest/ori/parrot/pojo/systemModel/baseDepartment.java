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
 * 部门信息表
 */
@Data
@ApiModel(" 部门信息表 ")
@TableName("base_department")
public class baseDepartment implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "部门主键")
    @TableField(value = "id")
    private String id;

    @ApiModelProperty(value = "公司主键")
    @TableField(value = "CompanyId")
    private String companyId;

    @ApiModelProperty(value = "父级主键")
    @TableField(value = "ParentId")
    private String parentId;

    @ApiModelProperty(value = "部门代码")
    @TableField(value = "EnCode")
    private String enCode;

    @ApiModelProperty(value = "部门名称")
    @TableField(value = "FullName")
    private String fullName;

    @ApiModelProperty(value = "部门简称")
    @TableField(value = "ShortName")
    private String shortName;

    @ApiModelProperty(value = "部门类型")
    @TableField(value = "Nature")
    private String nature;

    @ApiModelProperty(value = "负责人")
    @TableField(value = "Manager")
    private String manager;

    @ApiModelProperty(value = "外线电话")
    @TableField(value = "OuterPhone")
    private String outerPhone;

    @ApiModelProperty(value = "内线电话")
    @TableField(value = "InnerPhone")
    private String innerPhone;

    @ApiModelProperty(value = "电子邮件")
    @TableField(value = "Email")
    private String email;

    @ApiModelProperty(value = "部门传真")
    @TableField(value = "Fax")
    private String fax;

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
