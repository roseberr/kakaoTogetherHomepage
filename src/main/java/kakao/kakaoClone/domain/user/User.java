package kakao.kakaoClone.domain.user;

import kakao.kakaoClone.domain.BaseTimeEntity;
import kakao.kakaoClone.domain.board.Post;
import kakao.kakaoClone.domain.likes.UserLikePost;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity

public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;



    @Column(nullable = false)
    private String name;


    @Column(length=30, nullable = false)
    private String email;

    @Column
    private String picture;


    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    private List<Post> post;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    private List<UserLikePost> like;




    @Builder
    public User(String name, String picture , String email, Role role){
        this.name = name;
        this.picture=picture;
        this.email = email;
        this.role=role;
    }


    public String getRoleKey() {
        return this.role.getKey();
    }

    public User update(String name, String picture) {
        this.name=name;
        this.picture=picture;
        return this;
    }

}
