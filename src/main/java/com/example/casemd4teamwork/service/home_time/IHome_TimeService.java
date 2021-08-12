package com.example.casemd4teamwork.service.home_time;

import com.example.casemd4teamwork.model.Home_Time;
import com.example.casemd4teamwork.service.IGeneralService;

public interface IHome_TimeService extends IGeneralService<Home_Time> {
    Iterable<Home_Time> findAllTimeByHomeId(Long id);
}
