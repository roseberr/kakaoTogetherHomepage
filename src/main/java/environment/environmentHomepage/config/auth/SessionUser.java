package environment.environmentHomepage.config.auth;

import environment.environmentHomepage.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {


    private String name;
    private String email;
    private String picture;
    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmailGoogle();
        this.picture = user.getPicture();
    }
}
