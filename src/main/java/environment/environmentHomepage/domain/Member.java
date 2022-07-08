package environment.environmentHomepage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=10,nullable=false)
    private String userId;

    @Column(length=100, nullable = false)
    private String password;

    @Column(length=100, nullable = false)
    private String name;

    @Column(length=20, nullable = true)
    private String phone1;

    @Column(length=20, nullable = true)
    private String phone2;

    @Column(length=20, nullable = true)
    private String phone3;

    @Column(length=100, nullable = false)
    private String email1;

    private String email2;

    @Column(length=5,nullable=false)
    private String post;

    private String address1;

    private String address2;

    @Column(nullable=false)
    private LocalDateTime joinDate;

    @Builder
    public Member(Long id, String userId, String password, String name, String phone1, String phone2, String phone3, String email1, String email2, String post, String address1, String address2, LocalDateTime joinDate) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.email1 = email1;
        this.email2 = email2;
        this.post = post;
        this.address1 = address1;
        this.address2 = address2;
        this.joinDate = joinDate;
    }


}
