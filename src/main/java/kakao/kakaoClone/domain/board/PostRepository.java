package kakao.kakaoClone.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {


    Optional<Post>findById(Long id);


   List<Post> findByBigCategoryAndSmallCategory(String bigCategory, String smallCategory);
   List<Post> findByBigCategory(String bigCategory);
}
