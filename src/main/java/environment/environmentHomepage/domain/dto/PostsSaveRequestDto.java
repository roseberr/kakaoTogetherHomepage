package environment.environmentHomepage.domain.dto;


import environment.environmentHomepage.domain.board.Posts;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor

public class PostsSaveRequestDto {
    private long topic;

    private long title;

    private String author;

    public String category;



    private Long pricestate;


    private String image;

    private String content;

    private String tag1;

    private String tag2;

    private String tag3;

    private String enddate;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    @Builder
    public PostsSaveRequestDto(long topic, long title, String content, String author, String image,
                               String tag1, String tag2, String tag3, String enddate, Long pricestate, LocalDateTime createdDate, LocalDateTime modifiedDate) {
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
        this.createdDate=createdDate;
        this.modifiedDate=modifiedDate;
    }


    public Posts toEntity() {
        return Posts.builder()
                .topic(topic)
                .title(title)
                .content(content)
                .author(author)
                .image(image)
                .tag1(tag1)
                .tag2(tag2)
                .tag3(tag3)
                .enddate(enddate)
                .pricestate(pricestate)
                .build();
    }
}
