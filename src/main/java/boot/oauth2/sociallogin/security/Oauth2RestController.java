package boot.oauth2.sociallogin.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class Oauth2RestController {

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
