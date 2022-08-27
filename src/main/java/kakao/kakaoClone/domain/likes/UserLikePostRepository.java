package kakao.kakaoClone.domain.likes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikePostRepository extends JpaRepository<UserLikePost, Long> {

    /** 유저가 특정 게시물을 좋아요 했는지 확인 **/

    boolean existsByPost_IdAndUser_Id(Long post_id, Long user_id);

    /** 좋아요 삭제 **/

    void deleteByPost_IdAndUser_Id(Long post_id, Long user_id);

}
