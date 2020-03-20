package com.kubilaycicek.mylib.api;

import com.kubilaycicek.mylib.constant.Mappings;
import com.kubilaycicek.mylib.dto.PublisherDto;
import com.kubilaycicek.mylib.entity.Publisher;
import com.kubilaycicek.mylib.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(Mappings.API_CONTROLLER_URL + Mappings.PUBLISHER_URL)
@RequiredArgsConstructor
@RestController
public class PublisherRestController {
    private final PublisherService publisherService;

    @GetMapping("list")
    public ResponseEntity<List<Publisher>> getPublishers() {
        return ResponseEntity.ok(publisherService.getAllPublisher());
    }

    @PostMapping
    public ResponseEntity<PublisherDto> addPublisher(@RequestBody PublisherDto publisherDTO) {
        return ResponseEntity.ok(publisherService.addPublisher(publisherDTO));
    }

    @PutMapping
    public ResponseEntity<PublisherDto> updatePublisher(@RequestBody PublisherDto publisherDTO) {
        return ResponseEntity.ok(publisherService.updatePublisher(publisherDTO));
    }

    @GetMapping("{publisherID}")
    public ResponseEntity<PublisherDto> getPublisher(@PathVariable(name = "publisherID") long publisherID) {
        return ResponseEntity.ok(publisherService.getByPublisherID(publisherID));
    }

    @DeleteMapping("delete/{publisherID}")
    public void removePublisher(@PathVariable(name = "publisherID") long publisherID) {
        publisherService.removeByPublisherID(publisherID);
    }
}
