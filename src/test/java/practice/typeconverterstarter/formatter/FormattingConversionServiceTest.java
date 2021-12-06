package practice.typeconverterstarter.formatter;

import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import practice.typeconverterstarter.converter.IpPortToStringConverter;
import practice.typeconverterstarter.converter.StringToIpPortConverter;
import practice.typeconverterstarter.type.IpPort;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/12/06
 */
public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        conversionService.addFormatter(new MyNumberFormatter());

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        assertThat(conversionService.convert(10000, String.class)).isEqualTo("10,000");
        assertThat(conversionService.convert("10,000", Long.class)).isEqualTo(10000L);
    }
}
