package com.example.casemd4teamwork.service.image;

import com.example.casemd4teamwork.model.Home;
import com.example.casemd4teamwork.model.Image;
import com.example.casemd4teamwork.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService implements IImageService{

    @Autowired
    IImageRepository imageRepository;

    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Image save(Image image) {
      return imageRepository.save(image);
    }

    @Override
    public void remove(Long id) {
        imageRepository.deleteById(id);

    }

    @Override
    public Iterable<Image> findAllByImageAddress(String address) {
        return imageRepository.findAllByImageAddress(address);
    }

    @Override
    public Iterable<Image> findAllByImagePrice(Long price1, Long price2) {
        return imageRepository.findAllByImagePrice(price1, price2);
    }

    @Override
    public Iterable<Image> findByImageHome(Long price1, Long price2, String address, int num_Bedroom, int num_Bathroom) {
        return imageRepository.findByImageHome(price1, price2, address, num_Bedroom, num_Bathroom);
    }

}
