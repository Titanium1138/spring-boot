package titanium1138.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		int exitCode = SpringApplication.exit(SpringApplication.run(SampleApplication.class, args));
		if(exitCode != 0) {
			log.error("exitcode:{}", exitCode);
		} 
		System.exit(exitCode);
	}
}
