package boot.oauth2.sociallogin.userinfo;

import boot.oauth2.sociallogin.security.SocialType;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(SocialType.GOOGLE.getValue())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(SocialType.GITHUB.getValue())) {
            return new GithubOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(SocialType.FACEBOOK.getValue())) {
            return new FacebookOAuth2UserInfo(attributes);
        }
        return null;
    }
}
