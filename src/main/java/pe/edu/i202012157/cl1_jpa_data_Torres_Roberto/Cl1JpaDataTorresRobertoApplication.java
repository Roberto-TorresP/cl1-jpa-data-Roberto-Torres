package pe.edu.i202012157.cl1_jpa_data_Torres_Roberto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202012157.cl1_jpa_data_Torres_Roberto.repository.CountryRepository;
import pe.edu.i202012157.cl1_jpa_data_Torres_Roberto.repository.CountryLanguageRepository;
import java.util.Arrays;



import java.util.Arrays;

@SpringBootApplication
public class Cl1JpaDataTorresRobertoApplication implements CommandLineRunner {

	@Autowired
	private CountryLanguageRepository countryLanguageRepository;

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataTorresRobertoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Primera consulta usando ifPresentOrElse()
		System.out.println("\nConsulta 1: Lenguajes de Argentina o Perú");
		countryRepository.findById("ARG").ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes de Argentina:");
					country.getLanguages().forEach(lang ->
							System.out.println("- " + lang.getLanguage())
					);
				},
				() -> {
					System.out.println("Argentina no encontrada, mostrando lenguajes de Perú:");
					countryRepository.findById("PER").ifPresent(peru ->
							peru.getLanguages().forEach(lang ->
									System.out.println("- " + lang.getLanguage())
							)
					);
				}
		);

		// Segunda consulta usando deleteAllById()
		System.out.println("\nConsulta 2: Eliminando países");
		countryRepository.deleteAllById(Arrays.asList("COL", "ARG"));
		System.out.println("Países eliminados: Colombia y Argentina");

		// Tercera consulta: repetir la primera consulta
		System.out.println("\nConsulta 3: Verificando eliminación de Argentina");
		countryRepository.findById("ARG").ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes de Argentina:");
					country.getLanguages().forEach(lang ->
							System.out.println("- " + lang.getLanguage())
					);
				},
				() -> {
					System.out.println("Argentina no encontrada, mostrando lenguajes de Perú:");
					countryRepository.findById("PER").ifPresent(peru ->
							peru.getLanguages().forEach(lang ->
									System.out.println("- " + lang.getLanguage())
							)
					);
				}
		);
	}
}

