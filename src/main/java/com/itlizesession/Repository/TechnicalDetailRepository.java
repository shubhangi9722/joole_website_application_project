package com.itlizesession.Repository;

import com.itlizesession.Entity.TechnicalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface TechnicalDetailRepository extends JpaRepository<TechnicalDetail, Integer> {
//    Optional<List<TechnicalDetail>> findTechnicalDetailsByAirflowBetween(Integer min, Integer max);
//
//    Optional<List<TechnicalDetail>> findTechnicalDetailsByPowerBetween(Integer min, Integer max);
//
//    Optional<List<TechnicalDetail>> findTechnicalDetailsBySoundAtMaxSpeedBetween(Integer min, Integer max);
//
//    Optional<List<TechnicalDetail>> findTechnicalDetailsByFanSweepDiameterBetween(Integer min, Integer max);
//
//    Optional<List<TechnicalDetail>> findTechnicalDetailsByHeightBetween(Integer min, Integer max);
}
