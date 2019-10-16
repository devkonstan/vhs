package com.example.demo.api;

import com.example.demo.entity.VideoTape;
import com.example.demo.manager.VideoTapeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //komunikuje sie z uzyciem protokolu htttp
@RequestMapping("/api/tapes")
public class VideoTapeApi {

//    private List<VideoTape> videoTapeList;
//
//    public VideoTapeApi() {
//        videoTapeList = new ArrayList<>();
//        videoTapeList.add(new VideoTape(1L, "Titanic", LocalDate.of(1997, 1, 1)));
//        videoTapeList.add(new VideoTape(2L, "Rambo", LocalDate.of(1985, 2, 16)));
//    }

    private VideoTapeManager videoTapeList;

    @Autowired
    public VideoTapeApi(VideoTapeManager videoTapeList) {
        this.videoTapeList = videoTapeList;
    }

    @GetMapping("/all")
    public Iterable<VideoTape> getAll() {
        return videoTapeList.findAll();
    }

    @GetMapping
    public Optional<VideoTape> getById(@RequestParam Long index) { // odwoluje sie do indexu (Long, bo zgodne z interfejsem)
        return videoTapeList.findById(index);
    }

    @PostMapping
    public VideoTape addTape(@RequestBody VideoTape videoTape) {
        return videoTapeList.addTape(videoTape);
    }

    @PutMapping
    public VideoTape updateTape(@RequestBody VideoTape videoTape) {
        return videoTapeList.addTape(videoTape);
    }

    @DeleteMapping
    public void deleteTape(@RequestParam Long index) {
        videoTapeList.removeTape(index);
    }
}
