package practice.typeconverterstarter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/11/30
 */

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class IpPort {
    private final String ip;
    private final int    port;
}
