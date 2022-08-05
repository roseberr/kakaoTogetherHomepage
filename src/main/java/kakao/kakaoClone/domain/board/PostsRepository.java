package kakao.kakaoClone.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts,Long> {


    Optional<Posts>findById(Long id);


   List<Posts> findByBigCategoryAndSmallCategory(String bigCategory, String smallCategory);
   List<Posts> findByBigCategory(String bigCategory);
}
