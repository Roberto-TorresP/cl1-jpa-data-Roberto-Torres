package pe.edu.i202012157.cl1_jpa_data_Torres_Roberto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.i202012157.cl1_jpa_data_Torres_Roberto.entity.CountryLanguage;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguage.CountryLanguageId> {
}
