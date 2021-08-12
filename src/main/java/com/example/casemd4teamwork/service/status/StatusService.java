package com.example.casemd4teamwork.service.status;

import com.example.casemd4teamwork.model.Status;
import com.example.casemd4teamwork.model.User;
import com.example.casemd4teamwork.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StatusService implements IStatusService{

    @Autowired
    private IStatusRepository statusRepository;
    @Override
    public Iterable<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<Status> findById(Long id) {
        return statusRepository.findById(id);
    }

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }

//    @Override
//    public Optional<Status> findByStatus(Status status) {
//        return statusRepository.findByStatus(status);
//    }

    @Override
    public void remove(Long id) {
        statusRepository.deleteById(id);
    }


    @Override
    public Optional<Status> findByStatus(Status status) {
        return Optional.empty();
    }
}
