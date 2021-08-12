package com.example.casemd4teamwork.service.status;

import com.example.casemd4teamwork.model.Status;
import com.example.casemd4teamwork.service.IGeneralService;

import java.util.Optional;

public interface IStatusService extends IGeneralService<Status> {
    Optional<Status> findByStatus(Status status);
}
