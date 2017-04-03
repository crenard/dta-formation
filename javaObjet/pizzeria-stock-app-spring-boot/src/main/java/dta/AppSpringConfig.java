package dta;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("dta.model")
@SpringBootApplication
public class AppSpringConfig {

}
