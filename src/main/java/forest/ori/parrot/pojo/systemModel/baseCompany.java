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
 * 机构单位表
 */
@Data
@ApiModel(" 机构单位表 ")
@TableName("base_company")
public class baseCompany implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "公司主键")
    @TableField(value = "id")
    private String id;

    @ApiModelProperty(value = "公司分类")
    @TableField(value = "Category")
    private Integer category;

    @ApiModelProperty(value = "父级主键")
    @TableField(value = "ParentId")
    private String parentId;

    @ApiModelProperty(value = "公司代码")
    @TableField(value = "EnCode")
    private String enCode;

    @ApiModelProperty(value = "公司简称")
    @TableField(value = "ShortName")
    private String shortName;

    @ApiModelProperty(value = "公司名称")
    @TableField(value = "FullName")
    private String fullName;

    @ApiModelProperty(value = "公司性质")
    @TableField(value = "Nature")
    private String nature;

    @ApiModelProperty(value = "外线电话")
    @TableField(value = "OuterPhone")
    private String outerPhone;

    @ApiModelProperty(value = "内线电话")
    @TableField(value = "InnerPhone")
    private String innerPhone;

    @ApiModelProperty(value = "传真")
    @TableField(value = "Fax")
    private String fax;

    @ApiModelProperty(value = "邮编")
    @TableField(value = "Postalcode")
    private String postalcode;

    @ApiModelProperty(value = "电子邮箱")
    @TableField(value = "Email")
    private String email;

    @ApiModelProperty(value = "负责人")
    @TableField(value = "Manager")
    private String manager;

    @ApiModelProperty(value = "省主键")
    @TableField(value = "ProvinceId")
    private String provinceId;

    @ApiModelProperty(value = "市主键")
    @TableField(value = "CityId")
    private String cityId;

    @ApiModelProperty(value = "县/区主键")
    @TableField(value = "CountyId")
    private String countyId;

    @ApiModelProperty(value = "详细地址")
    @TableField(value = "Address")
    private String address;

    @ApiModelProperty(value = "公司主页")
    @TableField(value = "WebAddress")
    private String webAddress;

    @ApiModelProperty(value = "成立时间")
    @TableField(value = "FoundedTime")
    private Date foundedTime;

    @ApiModelProperty(value = "经营范围")
    @TableField(value = "BusinessScope")
    private String businessScope;

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
