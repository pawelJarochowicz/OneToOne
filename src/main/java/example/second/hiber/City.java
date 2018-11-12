package example.second.hiber;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    @Getter
    @Setter
    private int city_id;

    @Column(name = "name", length = 255, nullable = false)
    @Getter
    @Setter
    private String name;

    @OneToOne
    @JoinColumn(name = "league_id")
    @Getter
    @Setter
    private League league;
}
