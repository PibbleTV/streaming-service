package com.pibbletv.streaming_service.business.interfaces;


import com.pibbletv.streaming_service.domain.Stream;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StreamService {

    Flux<Stream> getStreamsPerKeyword(String keyword);

    Flux<Stream> getStreamsPerCategory(Long categoryId);

    Mono<Stream> getStream(Long streamId);

    Flux<Stream> getAllStreams();

    Mono<Void> addStream(Stream stream);

    Mono<Void> updateStream(Stream stream);
}
