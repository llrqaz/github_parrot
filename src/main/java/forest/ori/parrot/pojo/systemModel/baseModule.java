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
 * 系统功能表
 */
@Data
@ApiModel(" 系统功能表 ")
@TableName("base_module")
public class baseModule implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "功能主键")
    @TableField(value = "id")
    private String id;

    @ApiModelProperty(value = "父级主键")
    @TableField(value = "ParentId")
    private String parentId;

    @ApiModelProperty(value = "编码")
    @TableField(value = "EnCode")
    private String enCode;

    @ApiModelProperty(value = "名称")
    @TableField(value = "FullName")
    private String fullName;

    @ApiModelProperty(value = "图标")
    @TableField(value = "Icon")
    private String icon;

    @ApiModelProperty(value = "导航地址")
    @TableField(value = "UrlAddress")
    private String urlAddress;

    @ApiModelProperty(value = "导航目标")
    @TableField(value = "Target")
    private String target;

    @ApiModelProperty(value = "菜单选项")
    @TableField(value = "IsMenu")
    private Integer isMenu;

    @ApiModelProperty(value = "允许展开")
    @TableField(value = "AllowExpand")
    private Integer allowExpand;

    @ApiModelProperty(value = "是否公开")
    @TableField(value = "IsPublic")
    private Integer isPublic;

    @ApiModelProperty(value = "菜单类型 1.目录 2.菜单 3.按钮")
    @TableField(value = "MenuType")
    private Integer menuType;

    @ApiModelProperty(value = "是否外联")
    @TableField(value = "IFrame")
    private Integer iFrame;

    @ApiModelProperty(value = "授权标识")
    @TableField(value = "Permission")
    private String permission;

    @ApiModelProperty(value = "允许编辑")
    @TableField(value = "AllowEdit")
    private Integer allowEdit;

    @ApiModelProperty(value = "允许删除")
    @TableField(value = "AllowDelete")
    private Integer allowDelete;

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
