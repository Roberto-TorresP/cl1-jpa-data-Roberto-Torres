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
@Table(name = "countrylanguage")
@IdClass(CountryLanguage.CountryLanguageId.class)
public class CountryLanguage {
    @Id
    private String language;

    @Id
    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    private String isOfficial;

    private Float percentage;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class CountryLanguageId implements java.io.Serializable {
        private String language;
        private String country;
    }

}

