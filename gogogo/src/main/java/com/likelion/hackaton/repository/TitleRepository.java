package com.likelion.hackaton.repository;

import com.likelion.hackaton.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title,Long> {

}
