package environment.environmentHomepage.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts,Long> {


    Optional<Posts>findByMember_ID(String id);


}
