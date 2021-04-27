package forest.ori.parrot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum wheatherEnum {

    /* 旧邮箱修改邮箱 */
    YES(1, true, "是"),

    /* 通过邮箱修改密码 */
    NO(0, false, "否");

    private final Integer code;
    private final Boolean aBoolean;
    private final String description;


    public static Boolean getBool(wheatherEnum item) {
        for (wheatherEnum value : wheatherEnum.values()) {
            if (item.getCode().equals(value.getCode())) {
                return value.aBoolean;
            }
        }
        return null;
    }
    public static Boolean getBool(Integer code){
        for (wheatherEnum value : wheatherEnum.values()) {
            if (code == value.getCode()) {
                return value.aBoolean;
            }
        }
        return null;
    }

    public static Integer GetCode(wheatherEnum item) {
        for (wheatherEnum value : wheatherEnum.values()) {
            if (item.getCode().equals(value.getCode())) {
                return value.getCode();
            }
        }
        return null;
    }

    public static String GetDescription(wheatherEnum item) {
        for (wheatherEnum value : wheatherEnum.values()) {
            if (item.getCode().equals(value.getCode())) {
                return value.getDescription();
            }
        }
        return null;
    }


}