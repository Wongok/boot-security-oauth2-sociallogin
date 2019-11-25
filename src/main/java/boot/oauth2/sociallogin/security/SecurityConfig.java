package boot.oauth2.sociallogin.security;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/oauth2/**", "/login/**", "/css/**", "/images/**", "/js/**", "/console/**")
                .permitAll()
                .antMatchers("/google").hasAuthority(SocialType.GOOGLE.getRoleType())
                .antMatchers("/github").hasAuthority(SocialType.GITHUB.getRoleType())
                .antMatchers("/facebook").hasAuthority(SocialType.FACEBOOK.getRoleType())
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/loginSuccess")
                .failureUrl("/loginFailure")
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
    }

    private ClientRegistration getRegistration(OAuth2ClientProperties clientProperties, String client) {
        if("google".equals(client)) {
            OAuth2ClientProperties.Registration registration = clientProperties.getRegistration().get("google");
            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope("email", "profile")
                    .build();
        }
        if("github".equals(client)) {
            OAuth2ClientProperties.Registration registration = clientProperties.getRegistration().get("github");
            return CommonOAuth2Provider.GITHUB.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope("user:email", "read:user")
                    .build();
        }
        if("facebook".equals(client)) {
            OAuth2ClientProperties.Registration registration = clientProperties.getRegistration().get("facebook");
            return CommonOAuth2Provider.FACEBOOK.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope("email", "public_profile")
                    .build();
        }
        return null;
    }
}