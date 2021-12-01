package practice.typeconverterstarter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import practice.typeconverterstarter.type.UserStatus;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/11/30
 */

@Slf4j
public class UserStatusToStringConverter implements Converter<UserStatus, String> {

    @Override
    public String convert(UserStatus source) {
        log.info("convert source = {}", source);
        return source.getValue();
    }
}
