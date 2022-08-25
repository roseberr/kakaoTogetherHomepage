package kakao.kakaoClone.domain.likes;

import kakao.kakaoClone.domain.board.Posts;
import kakao.kakaoClone.domain.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LikesRepository {


    @Modifying
    @Query(value ="INSERT INTO likes(board_id,user_id) VALUES(:boardId,:userId)",nativeQuery=true)
    void likes(long boardId,long userId);

    @Modifying
    @Query(value ="DELETE FROM likes WHERE board_id =:boardId AND user_id=:userId",nativeQuery=true)
    void unLikes(long boardId,long userId);

}