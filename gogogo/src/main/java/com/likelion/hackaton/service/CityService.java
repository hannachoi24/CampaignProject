package com.likelion.hackaton.service;

import com.likelion.hackaton.entity.City;
import com.likelion.hackaton.entity.Title;
import com.likelion.hackaton.exception.CityNotFoundException;
import com.likelion.hackaton.repository.CityRepository;
import com.likelion.hackaton.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final TitleRepository titleRepository;



    public City createCity(String name){
        Title title = new Title();

        City city = City.builder()
                .name(name)
                .title(title)
                .build();

        cityRepository.save(city);
        titleRepository.save(title);

        return city;
    }

    public boolean isCityEmpty(String name){
        return cityRepository.findByName(name).isEmpty();
    }

    public City getCity(String name){
        return cityRepository.findByName(name)
                .orElseThrow(()-> new CityNotFoundException());
    }

}
