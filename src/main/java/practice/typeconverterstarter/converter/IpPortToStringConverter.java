package practice.typeconverterstarter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import practice.typeconverterstarter.type.IpPort;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/11/30
 */
@Slf4j
public class IpPortToStringConverter implements Converter<IpPort, String> {

    @Override
    public String convert(IpPort source) {
        log.info("convert source = {}", source);

        // "127.0.0.1:8080"
        return source.getIp() + ":" + source.getPort();
    }
}
