package com.example.casemd4teamwork.repository;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Home_Time;
import com.example.casemd4teamwork.model.Image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IHome_TimeRepository extends PagingAndSortingRepository<Home_Time, Long> {

    @Query("select t from Home_Time t where t.home.id = ?1")
    Iterable<Home_Time> findAllTimeByHomeId(Long id);
}
