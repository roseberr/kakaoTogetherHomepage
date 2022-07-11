package environment.environmentHomepage.domain.board;

import environment.environmentHomepage.domain.BaseTimeEntity;
import environment.environmentHomepage.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter

@NoArgsConstructor
@Entity

public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long board_id;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private User user;

    @Column(length=100, nullable = false)
    private long topic;


    @Column(length=500, nullable = false)
    private long title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;


    @Column(length=500, nullable = false)
    private String author;


    @Column(length=500, nullable = false)
    private String image;

    private String tag1;

    private String tag2;

    private String tag3;


    @Column(length=500, nullable = false)
    private String enddate;


    private Long pricestate;

    @Builder
    public Board(User user, long topic, long title, String content, String author, String image, String tag1, String tag2, String tag3, String enddate, Long pricestate) {
        this.user = user;
        this.topic = topic;
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
