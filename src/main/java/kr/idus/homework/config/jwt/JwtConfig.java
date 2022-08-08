package kr.idus.homework.config.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${spring.jwt.secret}")
    private String accessTokenSecret;
    @Value("${spring.jwt.access-token-validity-in-seconds}")
    private Long accessTokenValidityInSeconds;

    @Bean(name = "tokenProvider")
    public TokenProvider tokenProvider() {
        return new TokenProvider(accessTokenSecret, accessTokenValidityInSeconds);
    }
}
