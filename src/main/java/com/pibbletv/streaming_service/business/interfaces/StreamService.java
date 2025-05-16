package com.pibbletv.streaming_service.business.interfaces;


import com.pibbletv.streaming_service.domain.Stream;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface StreamService {

    Flux<Stream> getStreamsPerKeyword(String keyword);

    Flux<Stream> getStreamsPerCategory(UUID categoryId);

    Mono<Stream> getStream(UUID streamId);

    Flux<Stream> getAllStreams();

    Mono<Void> addStream(Stream stream);

    Mono<Void> updateStream(Stream stream);
}
