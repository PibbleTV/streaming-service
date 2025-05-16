package com.pibbletv.streaming_service.controller;

import com.pibbletv.streaming_service.domain.Stream;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.pibbletv.streaming_service.business.interfaces.StreamService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/stream")
public class StreamController {

    private final StreamService streamService;

    @GetMapping(value = "/getPerKeyword")
    public Flux<Stream> getStreamsPerKeyword(@RequestParam String keyword) {
        return streamService.getStreamsPerKeyword(keyword);
    }

    @GetMapping(value = "/getPerCategory")
    public Flux<Stream> getStreamsPerCategory(@RequestParam UUID categoryId) {
        return streamService.getStreamsPerCategory(categoryId);
    }

    @GetMapping(value = "/getStream")
    public Mono<Stream> getStream(@RequestParam UUID streamId) {
        return streamService.getStream(streamId);
    }

    @GetMapping(value = "/getAll")
    public Flux<Stream> getAllStreams() {
        return streamService.getAllStreams();
    }

    @PostMapping(value = "/addStream")
    public Mono<Void> addStream(@RequestBody Stream stream) {
        return streamService.addStream(stream);
    }

    @PutMapping(value = "/updateStream")
    public Mono<Void> updateStream(@RequestBody Stream stream) {
        return streamService.updateStream(stream);
    }


}
