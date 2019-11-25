package boot.oauth2.sociallogin.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Oauth2Controller {
    @GetMapping({"","/"})
    public String getAuthorizationMessage() {
        return "home";
    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "hello";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }
}
