package kakao.kakaoClone.domain.likes;

import kakao.kakaoClone.domain.board.Posts;
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

public class MemberLikePost {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int id;

    @JoinColumn(name="board_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Posts posts;


    @JoinColumn(name="user_id")
   // @JsonIgnoreProperties({"PostList"})
    // 이때 User를 보면, User 엔티티에서는 이미 postList로 관련 Post를 참조하고 있다. 그런데 MemberLikePost 엔티티에서 또 Post를 참조한다.
    // 이러한 현상으로 발생할 수 있는 오류를 없애기 위해 JsonIgnoreProperties로 무시해 주었다.

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



    private LocalDateTime localDateTime;


    @Builder
    public MemberLikePost(Posts posts, User user, LocalDateTime localDateTime){
        this.posts=posts;
        this.user=user;
        this.localDateTime=localDateTime;
    }

}
