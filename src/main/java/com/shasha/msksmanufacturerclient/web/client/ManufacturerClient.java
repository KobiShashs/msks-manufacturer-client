package com.shasha.msksmanufacturerclient.web.client;

import com.shasha.msksmanufacturerclient.web.model.ChocolateDto;
import com.shasha.msksmanufacturerclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created by kobis on 30 May, 2020
 */
@Component
@ConfigurationProperties(value = "my.manufacturer", ignoreInvalidFields = false)
public class ManufacturerClient {

    public final String CHOCOLATE_PATH_V1 = "/api/v1/chocolate/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    private String apihost;
    private final RestTemplate restTemplate;

    public ManufacturerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public ChocolateDto getChocolateById(UUID uuid) {
        return restTemplate.getForObject(apihost + CHOCOLATE_PATH_V1 + uuid.toString(), ChocolateDto.class);
    }

    public URI saveNewChocolate(ChocolateDto dto) {
        return restTemplate.postForLocation(apihost + CHOCOLATE_PATH_V1, dto);
    }

    public void updateChocolate(UUID uuid, ChocolateDto dto) {
        restTemplate.put(apihost + CHOCOLATE_PATH_V1 + "/" + uuid.toString(), dto);
    }

    public void deleteChocolate(UUID uuid) {
        restTemplate.delete(apihost+CHOCOLATE_PATH_V1+ "/" + uuid.toString());
    }


    public CustomerDto getCustomerById(UUID uuid) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto dto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, dto);
    }

    public void updateCustomer(UUID uuid, CustomerDto dto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), dto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apihost+CUSTOMER_PATH_V1+ "/" + uuid.toString());
    }
}
