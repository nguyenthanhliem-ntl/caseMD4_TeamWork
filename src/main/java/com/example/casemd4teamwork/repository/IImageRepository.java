package com.example.casemd4teamwork.repository;


import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends PagingAndSortingRepository<Image, Long> {
    @Query("select i from Image i where i.home.address like ?1")
    Iterable<Image> findAllByImageAddress(String address);

    @Query("select i from Image i where i.home.price > ?1 and i.home.price <?2")
    Iterable<Image> findAllByImagePrice(Long price1, Long price2);

    @Query("select i from Image i where i.home.price > ?1 and i.home.price <?2 and i.home.address like ?3 and i.home.num_Bedroom = ?4 and i.home.num_Bathroom = ?5")
    Iterable<Image> findByImageHome(Long price1, Long price2, String address, int num_Bedroom, int num_Bathroom);

    @Query("select i from Image i where i.home.id =?1")
    Iterable<Image> findAllImageByHomeId(Long id);
}
