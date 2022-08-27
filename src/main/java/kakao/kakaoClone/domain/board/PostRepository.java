package kakao.kakaoClone.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    /** id로 Post 찾기**/
    Optional<Post>findById(Long id);

    /** category 로  Post 찾기**/
   List<Post> findByBigCategoryAndSmallCategory(String bigCategory, String smallCategory);
   List<Post> findByBigCategory(String bigCategory);



    /** member_id로 post 찾기 - 유저 본인이 작성한 게시물 반환 **/

    /** 좋아요 추가 **/
    @Modifying
    @Query(value = "update Post post set post.likeCount = post.likeCount + 1 where post.id = :post_id")
    int plusLike(@Param("post_id") Long post_id);

    /** 좋아요 삭제 **/
    @Modifying
    @Query(value = "update Post post set post.likeCount = post.likeCount - 1 where post.id = :post_id")
    int minusLike(@Param("post_id") Long post_id);


    /** 조회수 업데이트 **/
    @Modifying
    @Query(value = "update Post post set post.viewCount = post.viewCount + 1 where post.id = :post_id")
    int updateView(@Param("post_id") Long post_id);

}
