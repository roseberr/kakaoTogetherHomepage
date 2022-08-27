package kakao.kakaoClone.domain.board;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@ToString
@NoArgsConstructor
@Setter
public class PostUpdateRequestDto {

    private String subTitle;
    private String title;

    private String author;

    public String bigCategory;

    public String smallCategory;
    private String topic;

    private Long currentPrice;
    private Long endPrice;


    private String filepath;


    private String content;

    private String tag1;

    private String tag2;

    private String tag3;

    private String endDate;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    @Builder
    public PostUpdateRequestDto(String topic, String title, String subTitle, String author, String bigCategory,
                                String smallCategory, Long currentPrice, Long endPrice, String content, String tag1,
                                String tag2, String tag3, String endDate, LocalDateTime createdDate, LocalDateTime modifiedDate,
                                String filepath) {

        System.out.println(" PostSaveRequestDto start");
        this.subTitle=subTitle;
        this.title = title;
        this.author = author;
        this.bigCategory = bigCategory;
        this.smallCategory = smallCategory;
        this.topic = topic;
        this.currentPrice=currentPrice;
        this.endPrice = endPrice;
        //   this.image = image;
        this.content = content;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.endDate = endDate;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    //    this.filename=filename;
        this.filepath=filepath;
        System.out.println(" PostSaveRequestDto 생성자 end");

    }

    public Post toEntity() {

        System.out.println(" PostSaveRequestDto to entity start");
        Post post = Post.builder()
                .subTitle(subTitle)
                .title(title)
                .author(author)
                .bigCategory(bigCategory)
                .smallCategory(smallCategory)
                .topic(topic)
                .currentPrice(currentPrice)
                .endPrice(endPrice)
                .content(content)
                .tag1(tag1)
                .tag2(tag2)
                .tag3(tag3)
                .endDate(endDate)
                .filepath(filepath)
                .build();
        return post;
    }
}
