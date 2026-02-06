package com.green.boardauth.configuration.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix="constants.jwt")
//BoardAuthApplication파일에서 @ConfigurationPropertiesScan 애노테이션을 사용해주어야 빨간줄이 안뜸.
@ToString
public class ConstJwt {
    private final String issuer;
    private final String bearerFormat;
    private final String claimKey;
    private final String secretKey;
    private final String accessTokenCookieName;
    private final String accessTokenCookiePath;
    private final int accessTokenCookieValiditySeconds;
    private final long accessTokenValidityMilliseconds;
    private final String refreshTokenCookieName;
    private final String refreshTokenCookiePath;
    private final int refreshTokenCookieValiditySeconds;
    private final long refreshTokenValidityMilliseconds;
}
