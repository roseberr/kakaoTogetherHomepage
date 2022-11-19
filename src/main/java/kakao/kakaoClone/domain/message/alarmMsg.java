package kakao.kakaoClone.domain.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class alarmMsg {
    String message = "";
    String href = "";

    public alarmMsg(String message, String href) {
        this.message = message;
        this.href = href;
    }
}