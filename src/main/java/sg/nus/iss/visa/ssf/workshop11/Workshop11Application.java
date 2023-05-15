package sg.nus.iss.visa.ssf.workshop11;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop11Application {
	private static final Logger logger = LoggerFactory.getLogger(Workshop11Application.class);

	//default port-number
	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
	 logger.info("main method started ...... ");

	 //initialize the spring app
	 SpringApplication app = new SpringApplication(Workshop11Application.class);

	 //read args array and check for "port" parameter

	 DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

	 List opsValues = appArgs.getOptionValues("port");

	 String portNumebr = null;

		// if port numebr is not in argument
		if(opsValues == null || opsValues.get(0) == null){

			//read port number fromm env variables
			portNumebr = System.getenv("PORT");

			if(portNumebr == null){
				portNumebr = DEFAULT_PORT;
			}

		} else{
		//passing port number from CLI
		portNumebr = (String) opsValues.get(0);
		}

		if(portNumebr != null){
			//setting port number in the spring-boot config
			app.setDefaultProperties(Collections.singletonMap("server.port", portNumebr));
		}

		logger.info("Port number is : " +portNumebr);	
	//launch spring boot app	
	app.run(args);
	}

}
