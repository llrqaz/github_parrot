package forest.ori.parrot.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PCAuthDto {
    @NotBlank(message = "账户名不能为空")
    private String Account;

    @NotBlank(message = "密码不能为空")
    private String Password;

    @NotBlank(message = "异常参数")
    private String CaptchaKey;

    @NotBlank(message = "请提供验证码")
    private String CaptchaData;
}
