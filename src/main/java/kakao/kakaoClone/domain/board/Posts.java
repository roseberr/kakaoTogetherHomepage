package kakao.kakaoClone.domain.board;

import kakao.kakaoClone.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter

@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */

public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long board_id;

    //@ManyToOne
    //@JoinColumn(name="MEMBER_ID")
    //private User user;


    @Column(length=100, nullable = false)
    private long topic;

    @Column
    private long category;


    @Column(length=500, nullable = false)
    private long title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;


    @Column(length=500, nullable = false)
    private String author;


    @Column(length=500, nullable = false)
    private String image;
    @Column(length=50, nullable = false)
    private String tag1;

    private String tag2;

    private String tag3;


    @Column(length=500, nullable = false)
    private String enddate;

    //최종모금액
    private Long pricestate;

    @Builder
    public Posts( long topic, long category ,long title, String content, String author, String image, String tag1, String tag2, String tag3, String enddate, Long pricestate) {

        this.topic = topic;
        this.category=category;
        this.title = title;
        this.content = content;
        this.author = author;
        this.image = image;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.enddate = enddate;
        this.pricestate = pricestate;
    }
}
