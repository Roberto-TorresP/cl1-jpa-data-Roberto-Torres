package pe.edu.i202012157.cl1_jpa_data_Torres_Roberto.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class ConexionesConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        // Configuración desde variables de entorno
        config.setJdbcUrl(System.getenv("DB_WORLD_URL"));
        config.setUsername(System.getenv("DB_WORLD_USER"));
        config.setPassword(System.getenv("DB_WORLD_PASS"));
        config.setDriverClassName(System.getenv("DB_WORLD_DRIVER"));

        // Configuración del pool de conexiones
        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000); // 4 minutos en millisegundos
        config.setConnectionTimeout(45000); // 45 segundos en millisegundos

        return new HikariDataSource(config);
    }
}
