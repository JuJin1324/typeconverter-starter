package practice.typeconverterstarter.converter;

import org.junit.jupiter.api.Test;
import practice.typeconverterstarter.type.IpPort;
import practice.typeconverterstarter.type.UserStatus;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/11/30
 */
class ConverterTest {

    @Test
    void stringToIpPort() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort result = converter.convert("127.0.0.1:8080");
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    @Test
    void ipPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        String result = converter.convert(new IpPort("127.0.0.1", 8080));
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void stringToUserStatus() {
        StringToUserStatusConverter converter = new StringToUserStatusConverter();
        UserStatus result = converter.convert("F");
        assertThat(result).isEqualTo(UserStatus.FAVORITE);
    }

    @Test
    void userStatusToString() {
        UserStatusToStringConverter converter = new UserStatusToStringConverter();
        String result = converter.convert(UserStatus.PLAIN);
        assertThat(result).isEqualTo("P");
    }
}
