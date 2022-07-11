package environment.environmentHomepage.domain.user;

import environment.environmentHomepage.domain.BaseTimeEntity;
import environment.environmentHomepage.domain.user.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Setter
@Entity

public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private String name;


    @Column(length=30, nullable = false)
    private String email;

    @Column
    private String picture;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(Long id,  String name,String picture ,String email,Role role) {
        this.id = id;
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
