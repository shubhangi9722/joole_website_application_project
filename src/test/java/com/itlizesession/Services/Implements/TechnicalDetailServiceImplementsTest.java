package com.itlizesession.Service.Implements;

import com.itlizesession.Entity.TechnicalDetail;
import com.itlizesession.Service.TechnicalDetailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TechnicalDetailServiceImplementsTest {
    @Autowired
    private TechnicalDetailService technicalDetailService;

//    @Test
//    void createTechnicalDetail() {
//        TechnicalDetail newTechnicalDetail = new TechnicalDetail(6604, 25, 240, 240, 48,
//        56, 60);
//        boolean isSuccess = technicalDetailService.createTechnicalDetail(newTechnicalDetail);
//        Assertions.assertTrue(isSuccess);
//    }

    @Test
    void getTechnicalDetail() {
        TechnicalDetail technicalDetail = technicalDetailService.getTechnicalDetail(16);
//        System.out.println(technicalDetail);
        Assertions.assertTrue(technicalDetail != null);
    }

    @Test
    void updateTechnicalDetail() {
        TechnicalDetail toUpdate = technicalDetailService.getTechnicalDetail(40);
        toUpdate.setHeight(66);
        boolean isSuccess = technicalDetailService.updateTechnicalDetail(toUpdate, 40);
        Assertions.assertTrue(isSuccess);
    }

//    @Test
//    void deleteTechnicalDetail() {
//        boolean isSuccess = technicalDetailService.deleteTechnicalDetail(5);
//        Assertions.assertTrue(isSuccess);
//    }
}