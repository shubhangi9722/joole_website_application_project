package com.itlizesession.Service.Implements;

import com.itlizesession.Entity.Description;
import com.itlizesession.Service.DescriptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DescriptionServiceImplementsTest {
    @Autowired
    private DescriptionService descriptionService;

//    @Test
//    void createDescription() {
//        Description newDescription = new Description("Big ass", "Haiku H",
//                "S3150-S0-BC-04-01-C-01");
//        boolean isSuccess = descriptionService.createDescription(newDescription);
//        Assertions.assertTrue(isSuccess);
//    }

    @Test
    void getDescription() {
        Description description = descriptionService.getDescription(18);
        Assertions.assertTrue(description != null);
    }

    @Test
    void updateDescription() {
        Description toUpdate = descriptionService.getDescription(42);
        toUpdate.setModel("CF860");
//        System.out.println(toUpdate);
        boolean isSuccessful = descriptionService.updateDescription(toUpdate, 42);
//        System.out.println(isSuccessful);
        Assertions.assertTrue(isSuccessful);
    }

//    @Test
//    void deleteDescription() {
//        boolean isSuccessful = descriptionService.deleteDescription(18);
//        Assertions.assertTrue(isSuccessful);
//    }
}