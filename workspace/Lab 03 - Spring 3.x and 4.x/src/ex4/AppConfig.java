package ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("ex2")
@Import(DBConfig.class)
public class AppConfig {

	@Autowired
	private DBConfig dbConfig;
	
	@Bean
	public FlightRepository flightRepo() {
		FlightRepositoryImpl flightRepository = new FlightRepositoryImpl();
		flightRepository.setDataSource(dbConfig.dataSource());
		return flightRepository;
	}
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }

}
