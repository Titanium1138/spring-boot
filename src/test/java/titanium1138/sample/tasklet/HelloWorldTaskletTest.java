package titanium1138.sample.tasklet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
public class HelloWorldTaskletTest {
    @InjectMocks
    HelloWorldTasklet target;

    @BeforeEach
    public void init() {
    }

    @Test
    public void execute_success01() throws Exception {
        StepContribution contribution = Mockito.mock(StepContribution.class);
        ChunkContext chunkContext = Mockito.mock(ChunkContext.class);

        // StepContext stepContext=Mockito.mock(StepContext.class);
        // StepExecution stepExecution=Mockito.mock(StepExecution.class);
        // JobExecution jobExecution = MetaDataInstanceFactory.createJobExecution();
        // jobExecution.getExecutionContext().putString("myValue", "foo,bar,spam");
        // Mockito.when(chunkContext.getStepContext()).thenReturn(stepContext);
        // Mockito.when(stepContext.getStepExecution()).thenReturn(stepExecution);
        // Mockito.when(stepExecution.getJobExecution()).thenReturn(jobExecution);

        RepeatStatus ret = target.execute(contribution, chunkContext);
        assertEquals(ret, RepeatStatus.FINISHED);
    }
}
