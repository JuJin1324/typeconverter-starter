package practice.typeconverterstarter.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/12/01
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public enum UserStatus {
    NEW("N"),
    PLAIN("P"),
    FAVORITE("F")
    ;

    private String value;

    public static UserStatus getFromValue(String value) {
        switch (value) {
            case "N":
                return UserStatus.NEW;
            case "P":
                return UserStatus.PLAIN;
            case "F":
                return UserStatus.FAVORITE;
            default:
                throw new IllegalArgumentException();
        }
    }
}
