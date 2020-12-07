package com.example.demo;

//import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;


@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@CucumberContextConfiguration
public class DemoApplicationTests {

	//private static WireMockServer wireMockServer;


	private static final Logger LOG = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Before
	public void setUp() {
		LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");

		//wireMockServer = new WireMockServer();
		//wireMockServer.start();
	}

	@After
	public void stop(){
		LOG.info("-------------- Spring Context finishing the Execution of Cucumber Tests --------------");
		//wireMockServer.stop();
	}

}
