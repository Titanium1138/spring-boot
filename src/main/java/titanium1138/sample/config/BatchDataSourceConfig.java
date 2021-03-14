package titanium1138.sample.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class BatchDataSourceConfig {
    @Bean
    @BatchDataSource
    public DataSource springBatchDs() {
        return (new EmbeddedDatabaseBuilder())
            .setType(EmbeddedDatabaseType.H2)
            .setName("batch-admin")
            .build();
    }
}
