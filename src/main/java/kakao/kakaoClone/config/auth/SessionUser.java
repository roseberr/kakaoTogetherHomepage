package kakao.kakaoClone.config.auth;

import kakao.kakaoClone.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private final Long id;

    private final String name;
    private final String email;
    private final String picture;
    public SessionUser(User user) {
        this.id=user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
