package kakao.kakaoClone.domain.likes;

import kakao.kakaoClone.domain.BaseTimeEntity;
import kakao.kakaoClone.domain.board.Post;
import kakao.kakaoClone.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Getter

@AllArgsConstructor
@Builder

@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
public class UserLikePost extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;



    @JoinColumn(name="user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @JoinColumn(name="board_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;


    @Builder
    public UserLikePost( User user,Post post){
        this.post = post;
        this.user = user;
    }

}
