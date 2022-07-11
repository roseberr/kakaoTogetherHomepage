package environment.environmentHomepage.domain.board;

import environment.environmentHomepage.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository  extends JpaRepository<Board,Long> {


    Optional<Board>findByMember_ID(String id);


}
