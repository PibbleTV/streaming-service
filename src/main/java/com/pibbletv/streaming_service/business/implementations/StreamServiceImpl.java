package com.pibbletv.streaming_service.business.implementations;


import com.pibbletv.streaming_service.business.converters.StreamConverter;
import com.pibbletv.streaming_service.business.interfaces.StreamService;
import com.pibbletv.streaming_service.domain.Stream;
import com.pibbletv.streaming_service.persistance.entities.StreamEntity;
import com.pibbletv.streaming_service.persistance.repository.StreamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class StreamServiceImpl implements StreamService {

    private final StreamRepository streamRepository;

    @Override
    public Flux<Stream> getStreamsPerKeyword(String keyword)
    {
        return streamRepository.findByKeyword(keyword).map(StreamConverter::convertToObject);
    }

    @Override
    public Flux<Stream> getStreamsPerCategory(Long categoryId)
    {
        return streamRepository.findByCategoryId(categoryId).map(StreamConverter::convertToObject);
    }


    @Override
    public Mono<Stream> getStream(Long streamId)
    {
        return streamRepository.findById(streamId).map(StreamConverter::convertToObject);
    }

    @Override
    public Flux<Stream> getAllStreams()
    {
        return streamRepository.findAll().map(StreamConverter::convertToObject);
    }

    @Override
    public Mono<Void> addStream(Stream stream) {
        return streamRepository.save(StreamConverter.convertToEntity(stream)).then();
    }

    @Override
    public Mono<Void> updateStream(Stream stream) {
        if (stream.getId() == null) {
            return Mono.error(new IllegalArgumentException("Cannot update stream without ID"));
        }
        return streamRepository.existsById(stream.getId())
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new IllegalArgumentException("Stream does not exist"));
                    }
                    return streamRepository.save(StreamConverter.convertToEntity(stream)).then();
                });
    }

}
