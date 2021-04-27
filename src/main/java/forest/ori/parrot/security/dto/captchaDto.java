package forest.ori.parrot.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class captchaDto {
    private String key;
    private String imgBase64;
}
