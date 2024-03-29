package kakao.kakaoClone.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    // 소셜 로그인으로 반환되는 값중 email을 통해 이미 가입됬는지 처음 가입했는지 판단하기 위한 method
  //  Optional<User> findByID(String id);


}
