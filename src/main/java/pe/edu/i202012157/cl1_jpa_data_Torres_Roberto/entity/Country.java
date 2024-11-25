package pe.edu.i202012157.cl1_jpa_data_Torres_Roberto.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"cities", "languages"})
@EqualsAndHashCode(exclude = {"cities", "languages"})
@Entity
@Table(name = "country")
public class Country {
    @Id
    private String code;

    private String name;

    private String continent;

    private String region;

    private Float surfaceArea;

    private Integer population;

    private Float lifeExpectancy;

    private Float gnp;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<CountryLanguage> languages;
}
