package boot.oauth2.sociallogin.model;

import boot.oauth2.sociallogin.security.SocialType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email
    private String email;

    private String imageUrl;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String providerId;
}
