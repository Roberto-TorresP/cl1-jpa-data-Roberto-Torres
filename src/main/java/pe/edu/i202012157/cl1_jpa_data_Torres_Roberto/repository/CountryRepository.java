package pe.edu.i202012157.cl1_jpa_data_Torres_Roberto.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202012157.cl1_jpa_data_Torres_Roberto.entity.Country;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, String> {
    Optional<Country> findByCode(String code);
}
