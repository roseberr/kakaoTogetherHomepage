package environment.environmentHomepage.domain.user;

import environment.environmentHomepage.domain.user.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Setter
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=10,nullable=false)
    private String userId;

    @Column(length=100, nullable = false)
    private String password;

    @Column(length=100, nullable = true)
    private String picture;

    @Column(length=100, nullable = false)
    private String name;

    @Column(length=20, nullable = true)
    private String phone1;

    @Column(length=20, nullable = true)
    private String phone2;

    @Column(length=20, nullable = true)
    private String phone3;

    @Column(length=100, nullable = false)
    private String emailGoogle;

    private String email2;

    @Column(length=5,nullable=false)
    private String post;

    private String address1;

    private String address2;

    @Column(nullable=false)
    private LocalDateTime joinDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Builder
    public User(Long id, String userId, String password, String name,String picture ,String phone1, String phone2, String phone3,
                String emailGoogle, String email2, String post, String address1,
                String address2, LocalDateTime joinDate,Role role) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.picture=picture;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.emailGoogle = emailGoogle;
        this.email2 = email2;
        this.post = post;
        this.address1 = address1;
        this.address2 = address2;
        this.joinDate = joinDate;
        this.role=role;
    }


    public String getRoleKey() {
        return this.role.getKey();
    }

    public User update(String name, String picture) {
        this.name=name;
        this.picture=picture;
    }
}
