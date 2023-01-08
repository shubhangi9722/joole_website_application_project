package com.itlizesession.Service;

import com.itlizesession.Entity.TechnicalDetail;
import org.springframework.stereotype.Service;

@Service
public interface TechnicalDetailService {
    boolean createTechnicalDetail(TechnicalDetail technicalDetail);

    // read
    TechnicalDetail getTechnicalDetail(Integer technicalDetailId);

    // update
    boolean updateTechnicalDetail(TechnicalDetail description, Integer technicalDetailId);

    // delete
    boolean deleteTechnicalDetail(Integer technicalDetailId);
}
