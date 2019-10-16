package com.example.demo.manager;

import com.example.demo.dao.VideoTapeRepo;
import com.example.demo.entity.VideoTape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service // warstwa posrednia miedzy api i danymi
public class VideoTapeManager {

    private VideoTapeRepo videoTapeRepo;

    @Autowired
    public VideoTapeManager(VideoTapeRepo videoTapeRepo) {
        this.videoTapeRepo = videoTapeRepo;
    }

    //tworzymy metody nawiazujace do Api

    public Optional<VideoTape> findById(Long id) {
        return videoTapeRepo.findById(id);
    }

    public Iterable<VideoTape> findAll() {
        return videoTapeRepo.findAll();
    }

    public VideoTape addTape(VideoTape videoTape) {
        return videoTapeRepo.save(videoTape);
    }

    public void removeTape(Long id) {
        videoTapeRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        addTape(new VideoTape(4L, "Boom", LocalDate.of(1987, 1, 8)));
        addTape(new VideoTape(5L, "Rest", LocalDate.of(1993, 9, 8)));
    }
}
