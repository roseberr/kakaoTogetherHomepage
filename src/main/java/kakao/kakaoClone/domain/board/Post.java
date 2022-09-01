package kakao.kakaoClone.domain.board;

import kakao.kakaoClone.domain.BaseTimeEntity;
import kakao.kakaoClone.domain.comment.Comment;
import kakao.kakaoClone.domain.likes.UserLikePost;
import kakao.kakaoClone.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */

public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="post_id")
    private long id;

    //@ManyToOne
    //@JoinColumn(name="MEMBER_ID")
    //private User user;

    /**  form 받는 값들   */
    @Column(length=50, nullable = false)
    private String bigCategory;     //같이기부 프로모션

    @Column
    private String smallCategory;  // 카테고리선택

    @Column
    private String topic;  //같이기부시 카테고리선택

    @Column(length=500, nullable = false)
    private String title;
    @Column(length=500, nullable = false)
    private String subTitle;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;


    @Column(length=500, nullable = false)
    private String author;


    //  @Column(length=500)
    //private String filename;

    @Column(length=500)
    private String filepath;

    @Column(length=500, nullable = false)
    private String tag1;

    private String tag2;

    private String tag3;


    @Column(length=500, nullable = false)
    private String endDate;

    //현재 모금액

    @Column(length=500,nullable = false)
    private Long currentPrice;

    //최종모금액
    @Column(length=500,nullable = false)
    private Long endPrice;



    /**     form 값 받는것 end     */

    /**     view 개수 count       */
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int viewCount;

    /**      like 개수 Count       */
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int likeCount;


    /**     comment list 입력      */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comment;

    /**     User연결               */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**     User의 모든 post                    */

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    private List<Post> post;
    /**     User의 좋아요 표시한 post입력        */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLikePost> userLikePost;

    @Builder
    public Post(String topic, String bigCategory , String smallCategory, String title, String subTitle,
                String content, String author, String tag1, String tag2, String tag3,
                String endDate, Long endPrice, Long currentPrice, String filepath) {
        this.title = title;
        this.author = author;

        this.bigCategory=bigCategory;
        this.smallCategory=smallCategory;
        this.topic = topic;
        this.endDate = endDate;
        this.subTitle=subTitle;
       // this.image = image;
        this.content = content;

        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;

        this.endPrice = endPrice;
        this.currentPrice=currentPrice;

        //this.filename=filename;
        this.filepath=filepath;

    }
    public void update(String topic, String bigCategory , String smallCategory,String subTitle, String title,
                       String content, String author, String tag1, String tag2, String tag3,
                       String endDate, Long endPrice,Long currentPrice,String filepath) {
        this.subTitle=subTitle;
        this.title = title;
        this.author = author;

        this.bigCategory=bigCategory;
        this.smallCategory=smallCategory;
        this.topic = topic;
        this.endDate = endDate;

        // this.image = image;
        this.content = content;

        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.endPrice = endPrice;
        this.currentPrice=currentPrice;
        this.filepath=filepath;
    }
}