package com.example.casemd4teamwork.repository;

import com.example.casemd4teamwork.model.Home;
<<<<<<< HEAD

=======
import org.springframework.data.jpa.repository.Query;
>>>>>>> 36dc207e7fd75a92d0c74656555ae868e27bff4f
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IHomeRepository extends PagingAndSortingRepository<Home, Long> {
    @Query("select h from Home h where h.address like ?1")
    Iterable<Home> findAllByAddress(String address);


    @Query("select h from Home h where h.price > ?1 and h.price <?2")
    Iterable<Home> findAllByPrice(Long price1, Long price2);

    @Query("select h from Home h where h.price > ?1 and h.price <?2 and h.address like ?3 and h.num_Bedroom = ?4 and h.num_Bathroom = ?5")
    Iterable<Home> findByHome(Long price1, Long price2, String address, int num_Bedroom, int num_Bathroom);
}
