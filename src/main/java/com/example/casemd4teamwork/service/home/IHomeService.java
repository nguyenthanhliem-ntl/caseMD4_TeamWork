package com.example.casemd4teamwork.service.home;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;

public interface IHomeService extends IGeneralService<Home> {
    Iterable<Home> findAllByAddress(String address);

    Iterable<Home> findAllByPrice(Long price1, Long price2);

    Iterable<Home> findByHome(Long price1, Long price2, String address, int num_Bedroom, int num_Bathroom);
}
