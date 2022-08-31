package kakao.kakaoClone.domain.comment;


import kakao.kakaoClone.domain.BaseTimeEntity;
import kakao.kakaoClone.domain.board.Post;
import kakao.kakaoClone.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length=500,nullable = false, columnDefinition = "integer default 0")
    private Long donationMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    /** 댓글 내용 수정 **/
    public void update(String content) {
        this.content = content;
    }

}
