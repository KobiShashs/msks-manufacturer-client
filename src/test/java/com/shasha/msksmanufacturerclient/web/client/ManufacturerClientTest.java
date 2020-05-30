package com.shasha.msksmanufacturerclient.web.client;

import com.shasha.msksmanufacturerclient.web.model.ChocolateDto;
import com.shasha.msksmanufacturerclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kobis on 30 May, 2020
 */
@SpringBootTest
class ManufacturerClientTest {

    @Autowired
    ManufacturerClient client;

    @Test
    void TestGetChocolateById(){
        ChocolateDto dto = client.getChocolateById(UUID.randomUUID());
        assertNotNull(dto);

    }

    @Test
    void TestSaveNewChocolate(){
        ChocolateDto dto = ChocolateDto.builder()
                .id(UUID.randomUUID())
                .chocolateName("Pikkolo")
                .chocolateType("Milk")
                .chocolateSlogan("Crispy pleasure for small gourmets")
                .build();

        URI uri = client.saveNewChocolate(dto);
        assertNotNull(uri);
    }

    @Test
    void TestUpdateChocolate(){

        ChocolateDto dto = ChocolateDto.builder()
                .id(UUID.randomUUID())
                .chocolateName("Pikkolo")
                .chocolateType("Milk")
                .chocolateSlogan("Crispy pleasure for small gourmets")
                .build();

        client.updateChocolate(UUID.randomUUID(),dto);

    }

    @Test
    void TestDeleteChocolate(){
        client.deleteChocolate(UUID.randomUUID());
    }

    @Test
    void TestGetCustomerById(){
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void TestSaveNewCustomer(){
        CustomerDto dto = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Moshe")
                .build();

        URI uri = client.saveNewCustomer(dto);
        assertNotNull(uri);
    }

    @Test
    void TestUpdateCustomer(){

        CustomerDto dto = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Moshe")
                .build();

        client.updateCustomer(UUID.randomUUID(),dto);

    }

    @Test
    void TestDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }




}