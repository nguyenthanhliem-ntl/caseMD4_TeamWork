package com.example.casemd4teamwork.service.home;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.User;
import com.example.casemd4teamwork.repository.IHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public  class HomeService implements IHomeService{

    @Autowired
    IHomeRepository homeRepository;

    @Override
    public Iterable<Home> findAll() {
        return homeRepository.findAll();
    }

    @Override
    public Optional<Home> findById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public Home save(Home home) {
     return homeRepository.save(home);
    }

    @Override
    public void remove(Long id) {
        homeRepository.deleteById(id);
    }

<<<<<<< HEAD


=======
    @Override
    public Iterable<Home> findAllByAddress(String address) {
        return homeRepository.findAllByAddress(address);
    }

    @Override
    public Iterable<Home> findAllByPrice(Long price1, Long price2) {
        return homeRepository.findAllByPrice(price1, price2);
    }

    @Override
    public Iterable<Home> findByHome(Long price1, Long price2, String address, int num_Bedroom, int num_Bathroom) {
        return homeRepository.findByHome(price1, price2, address, num_Bedroom, num_Bathroom);
    }
>>>>>>> 36dc207e7fd75a92d0c74656555ae868e27bff4f
}
