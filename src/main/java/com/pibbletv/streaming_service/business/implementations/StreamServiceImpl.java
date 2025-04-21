package com.pibbletv.streaming_service.business.implementations;


import com.pibbletv.streaming_service.business.interfaces.StreamService;
import com.pibbletv.streaming_service.persistance.repository.StreamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StreamServiceImpl implements StreamService {

    private final StreamRepository streamRepository;

}
