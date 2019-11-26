package boot.oauth2.sociallogin.security;

import boot.oauth2.sociallogin.exception.ResourceNotFoundException;
import boot.oauth2.sociallogin.model.User;
import boot.oauth2.sociallogin.model.UserRepository;
import boot.oauth2.sociallogin.user.CurrentUser;
import boot.oauth2.sociallogin.user.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class Oauth2RestController {

    private UserRepository userRepository;

    @GetMapping("/user")
    public User user(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
