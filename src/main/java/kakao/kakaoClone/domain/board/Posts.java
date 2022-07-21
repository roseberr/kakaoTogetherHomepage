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
    private long board_id;

    //@ManyToOne
    //@JoinColumn(name="MEMBER_ID")
    //private User user;

    @Column(length=100, nullable = false)
    private String bigCategory;     //같이기부 프로모션

    @Column
    private String smallCategory;  // 카테고리선택

    @Column
    private String topic;  //같이기부시 카테고리선택

    @Column(length=500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;


    @Column(length=500, nullable = false)
    private String author;


    @Column(length=500)
    private String filename;

    @Column(length=500)
    private String filepath;



    @Column(length=50, nullable = false)
    private String tag1;

    private String tag2;

    private String tag3;


    @Column(length=500, nullable = false)
    private String endDate;

    //최종모금액
    private Long priceState;

    @Builder
    public Posts(String topic, String bigCategory , String smallCategory, String title,
                 String content, String author,  String tag1, String tag2, String tag3,
                 String endDate, Long priceState, String filename,String filepath) {
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

        this.priceState = priceState;

        this.filename=filename;
        this.filepath=filepath;

    }
}
