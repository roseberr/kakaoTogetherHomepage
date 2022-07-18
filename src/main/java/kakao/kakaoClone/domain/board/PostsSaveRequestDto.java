package kakao.kakaoClone.domain.board;


import kakao.kakaoClone.domain.board.Posts;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor

public class PostsSaveRequestDto {




    private String title;

    private String author;

    public String bigCategory;

    public String smallCategory;
    private String topic;

    private Long priceState;


   // private String image;

    private String content;

    private String tag1;

    private String tag2;

    private String tag3;

    private String endDate;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    @Builder
    public PostsSaveRequestDto(String topic, String title, String author, String bigCategory,
                               String smallCategory, Long priceState,  String content, String tag1,
                               String tag2, String tag3, String endDate, LocalDateTime createdDate, LocalDateTime modifiedDate) {

        this.title = title;
        this.author = author;
        this.bigCategory = bigCategory;
        this.smallCategory = smallCategory;
        this.topic = topic;
        this.priceState = priceState;
        //this.image = image;
        this.content = content;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.endDate = endDate;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .author(author)
                .bigCategory(bigCategory)
                .smallCategory(smallCategory)
                .topic(topic)
                .priceState(priceState)
               // .image(image)
                .content(content)
                .tag1(tag1)
                .tag2(tag2)
                .tag3(tag3)
                .endDate(endDate)
                .build();
    }
}
