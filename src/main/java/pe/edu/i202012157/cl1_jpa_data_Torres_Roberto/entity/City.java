package pe.edu.i202012157.cl1_jpa_data_Torres_Roberto.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "country")
@EqualsAndHashCode(exclude = "country")
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    private String district;

    private Integer population;

}
