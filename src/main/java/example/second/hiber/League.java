package example.second.hiber;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "league")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_id", nullable = false)
    @Getter
    @Setter
    private int league_id;

    @Column(name = "name", length = 255, nullable = false)
    @Getter
    @Setter
    private String name;

    @OneToOne(mappedBy ="league")
    @Getter
    @Setter
    private City city;


}
