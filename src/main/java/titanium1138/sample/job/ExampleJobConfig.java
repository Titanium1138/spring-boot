package titanium1138.sample.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import titanium1138.sample.tasklet.HelloWorldTasklet;

@Configuration
@EnableBatchProcessing
public class ExampleJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private HelloWorldTasklet helloWorldTasklet;

    @Bean
    public Job exampleJob() {
        return jobBuilderFactory.get("exampleJob")
            .incrementer(new RunIdIncrementer())
                .start(exampleJobStep01())
                .build();
    }

    @Bean
    public Step exampleJobStep01() {
        return stepBuilderFactory.get("exampleJobStep01")
                .tasklet(helloWorldTasklet)
                .build();
    }    
}
