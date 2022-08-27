package kakao.kakaoClone.domain.board;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@Setter
public class PostSaveRequestDto {

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
    public PostSaveRequestDto(String topic, String title, String subTitle, String author, String bigCategory,
                              String smallCategory, Long currentPrice, Long endPrice, String content, String tag1,
                              String tag2, String tag3, String endDate, LocalDateTime createdDate, LocalDateTime modifiedDate
                              ) {

        System.out.println(" PostSaveRequestDto start");
        this.title = title;
        this.subTitle=subTitle;
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
        //this.filename=filename;
        this.filepath=filepath;
        System.out.println(" PostSaveRequestDto 생성자 end");

    }

    public Post toEntity() {

        System.out.println(" PostSaveRequestDto to entity start");
        Post post = Post.builder()
                .title(title)
                .subTitle(subTitle)
                .author(author)
                .bigCategory(bigCategory)
                .smallCategory(smallCategory)
                .topic(topic)
                .currentPrice(currentPrice)
                .endPrice(endPrice)
                //   .image(image)
                .content(content)
                .tag1(tag1)
                .tag2(tag2)
                .tag3(tag3)
                .endDate(endDate)
               // .filename(filename)
                .filepath(filepath)
                .build();
        return post;
    }
}
