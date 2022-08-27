package kakao.kakaoClone.domain.likes;

import kakao.kakaoClone.domain.board.Post;
import kakao.kakaoClone.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Getter

@AllArgsConstructor
@Builder

public class UserLikePost {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;



    @JoinColumn(name="user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @JoinColumn(name="board_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    private LocalDateTime localDateTime;

    @Builder
    public UserLikePost( User user,Post post){
        this.post = post;
        this.user = user;
    }

}
