package ru.vood.SpringRestClient.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restClient")
public class RESTClientExample {
    @Autowired
    private RestTemplate restTemplate;

    public String getAllEmployees() {
        //System.out.println(restTemplate.getForObject("http://localhost:8070/employees", Emploers.class).size());
        return restTemplate.getForObject("http://localhost:8070/employees", String.class);
    }

    public Emploers getAllEmployeesO() {
        //System.out.println(restTemplate.getForObject("http://localhost:8070/employees", Emploers.class).size());
        return restTemplate.getForObject("http://localhost:8070/employees", Emploers.class);
    }

}
