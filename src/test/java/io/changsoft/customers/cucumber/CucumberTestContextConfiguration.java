package io.changsoft.customers.cucumber;

import io.changsoft.customers.CustomersApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = CustomersApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
