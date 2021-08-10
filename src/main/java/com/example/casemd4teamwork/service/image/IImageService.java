package com.example.casemd4teamwork.service.image;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Image;
import com.example.casemd4teamwork.service.IGeneralService;

public interface IImageService extends IGeneralService<Image> {
    Iterable<Image> findAllByImageAddress(String address);

    Iterable<Image> findAllByImagePrice(Long price1, Long price2);

    Iterable<Image> findByImageHome(Long price1, Long price2, String address, int num_Bedroom, int num_Bathroom);
}
