package com.itlizesession.Service.Implements;

import com.itlizesession.Entity.Description;
import com.itlizesession.Repository.DescriptionRepository;
import com.itlizesession.Service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class DescriptionServiceImplements implements DescriptionService {
    @Autowired
    private DescriptionRepository descriptionRepository;

    @Override
    public boolean createDescription(Description description) {
        if (description == null) {
            System.out.println("null input");
            return false;
        }
        Description target = getDescription(description.getDescriptionId());
        if (target != null) {
            System.out.println("Description already exists");
            return false;
        }
        try {
            descriptionRepository.save(description);
        } catch (Exception e) {
            System.out.println("something wrong when creating: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Description getDescription(Integer descriptionId) {
        if (descriptionId == null) return null;
        Optional<Description> res = descriptionRepository.findById(descriptionId);
        return res.orElse(null);
    }

    @Override
    public boolean updateDescription(Description description, Integer descriptionId) {
        return false;
    }
}