package kakao.kakaoClone.domain.likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemberLikePostRepository extends JpaRepository<MemberLikePost, Long> {

/*
    @Modifying
    @Query(value ="INSERT INTO likes(board_id,user_id) VALUES(:boardId, :userId)" , nativeQuery=true)
    void likes(long boardId,long userId);

    @Modifying
    @Query(value ="DELETE FROM likes WHERE board_id =:boardId AND user_id=:userId",nativeQuery=true)
    void unLikes(long boardId,long userId);

   */

    /** 유저가 특정 게시물을 좋아요 했는지 확인 **/
    /*
    boolean existsByBoard_IdAndUser_Id(Long board_id, Long user_id);
  */
    /** 좋아요 삭제 **/
     /*
    void deleteByBoard_IdAndUser_Id(Long board_id, Long user_id);
  */
}
