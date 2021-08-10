package com.example.casemd4teamwork.service.home_time;

import com.example.casemd4teamwork.model.Home_Time;
import com.example.casemd4teamwork.repository.IHome_TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Home_TimeService implements IHome_TimeService{
    @Autowired
    private IHome_TimeRepository iHome_timeRepository;
    @Override
    public Iterable<Home_Time> findAll() {
        return iHome_timeRepository.findAll();
    }

    @Override
    public Optional<Home_Time> findById(Long id) {
        return iHome_timeRepository.findById(id);
    }

    @Override
    public Home_Time save(Home_Time home_time) {
        return iHome_timeRepository.save(home_time);
    }

    @Override
    public void remove(Long id) {
        iHome_timeRepository.deleteById(id);
    }
}
