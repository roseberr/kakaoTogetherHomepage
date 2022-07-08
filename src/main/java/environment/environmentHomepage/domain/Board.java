package environment.environmentHomepage.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter

@NoArgsConstructor
@Entity

public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long board_id;

    @Column
    private long id;





}
