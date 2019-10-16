package com.example.demo.dao;

import com.example.demo.entity.VideoTape;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VideoTapeRepo extends CrudRepository<VideoTape, Long> {
}
