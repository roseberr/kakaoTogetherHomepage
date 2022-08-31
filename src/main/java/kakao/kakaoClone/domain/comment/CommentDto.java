package kakao.kakaoClone.domain.comment;

import kakao.kakaoClone.domain.board.Post;
import kakao.kakaoClone.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CommentDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RequestDto{

        private Long id;
        private String content;
        private String createdDate, modifiedDate;

        private Long donationMoney;

        private Post post;

        private User user;



        public void setPost(Post post){
            this.post = post;
        }

        public void setUser(User user) {
            this.user = user;
        }



        /* Dto -> Entity */
        public Comment toEntity(User user, Post post) {
            Comment comment = Comment.builder()
                    .id(id)
                    .content(content)
                    .user(user)
                    .post(post)
                    .donationMoney(donationMoney)
                    .build();

            return comment;
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDto{
        private Long id;
        private String content;
        private String createdDate, modifiedDate;

        private Long donationMoney;

        private String name;

        private Long memberId;
        private Long postId;

        /* Entity -> Dto */
        public ResponseDto(Comment comment){
            this.id = comment.getId();
            this.content = comment.getContent();
            this.name = comment.getUser().getName();
            this.createdDate = comment.getCreatedDate();
            this.modifiedDate = comment.getModifiedDate();
            this.donationMoney=comment.getDonationMoney();
            this.postId = comment.getPost().getId();
            this.memberId = comment.getUser().getId();
        }

    }




}
