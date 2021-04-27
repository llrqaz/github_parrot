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
 * 用户信息表
 */
@Data
@ApiModel(" 用户信息表 ")
@TableName("base_user")
public class baseUser implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "用户主键")
    @TableField(value = "id")
    private String id;

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

    @ApiModelProperty(value = "工号")
    @TableField(value = "EnCode")
    private String enCode;

    @ApiModelProperty(value = "登录账户")
    @TableField(value = "Account")
    private String account;

    @ApiModelProperty(value = "登录密码")
    @TableField(value = "Password")
    private String password;

    @ApiModelProperty(value = "密码秘钥")
    @TableField(value = "Secretkey")
    private String secretkey;

    @ApiModelProperty(value = "真实姓名")
    @TableField(value = "RealName")
    private String realName;

    @ApiModelProperty(value = "呢称")
    @TableField(value = "NickName")
    private String nickName;

    @ApiModelProperty(value = "头像")
    @TableField(value = "HeadIcon")
    private String headIcon;

    @ApiModelProperty(value = "快速查询")
    @TableField(value = "QuickQuery")
    private String quickQuery;

    @ApiModelProperty(value = "简拼")
    @TableField(value = "SimpleSpelling")
    private String simpleSpelling;

    @ApiModelProperty(value = "性别")
    @TableField(value = "Gender")
    private Integer gender;

    @ApiModelProperty(value = "生日")
    @TableField(value = "Birthday")
    private Date birthday;

    @ApiModelProperty(value = "手机")
    @TableField(value = "Mobile")
    private String mobile;

    @ApiModelProperty(value = "电话")
    @TableField(value = "Telephone")
    private String telephone;

    @ApiModelProperty(value = "电子邮件")
    @TableField(value = "Email")
    private String email;

    @ApiModelProperty(value = "QQ号")
    @TableField(value = "OICQ")
    private String oICQ;

    @ApiModelProperty(value = "微信号")
    @TableField(value = "WeChat")
    private String weChat;

    @ApiModelProperty(value = "MSN")
    @TableField(value = "MSN")
    private String mSN;

    @ApiModelProperty(value = "机构主键")
    @TableField(value = "CompanyId")
    private String companyId;

    @ApiModelProperty(value = "部门主键")
    @TableField(value = "DepartmentId")
    private String departmentId;

    @ApiModelProperty(value = "安全级别")
    @TableField(value = "SecurityLevel")
    private Integer securityLevel;

    @ApiModelProperty(value = "单点登录标识")
    @TableField(value = "OpenId")
    private Integer openId;

    @ApiModelProperty(value = "密码提示问题")
    @TableField(value = "Question")
    private String question;

    @ApiModelProperty(value = "密码提示答案")
    @TableField(value = "AnswerQuestion")
    private String answerQuestion;

    @ApiModelProperty(value = "允许多用户同时登录")
    @TableField(value = "CheckOnLine")
    private Integer checkOnLine;

    @ApiModelProperty(value = "允许登录时间开始")
    @TableField(value = "AllowStartTime")
    private Date allowStartTime;

    @ApiModelProperty(value = "允许登录时间结束")
    @TableField(value = "AllowEndTime")
    private Date allowEndTime;

    @ApiModelProperty(value = "暂停用户开始日期")
    @TableField(value = "LockStartDate")
    private Date lockStartDate;

    @ApiModelProperty(value = "暂停用户结束日期")
    @TableField(value = "LockEndDate")
    private Date lockEndDate;

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


}
