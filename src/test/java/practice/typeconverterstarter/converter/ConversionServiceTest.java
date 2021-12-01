package practice.typeconverterstarter.converter;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import practice.typeconverterstarter.type.IpPort;
import practice.typeconverterstarter.type.UserStatus;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/12/01
 */

public class ConversionServiceTest {

    @Test
    void conversionService() {
        /* 등록 */
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        conversionService.addConverter(new UserStatusToStringConverter());
        conversionService.addConverter(new StringToUserStatusConverter());

        /* 사용 */
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");

        String statusString = conversionService.convert(UserStatus.NEW, String.class);
        assertThat(statusString).isEqualTo("N");

        UserStatus userStatus = conversionService.convert("N", UserStatus.class);
        assertThat(userStatus).isEqualTo(UserStatus.NEW);
    }
}
