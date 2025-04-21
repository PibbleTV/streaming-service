package com.pibbletv.streaming_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pibbletv.streaming_service.business.interfaces.StreamService;


@RestController
@AllArgsConstructor
@RequestMapping("/stream")
public class StreamController {

    private final StreamService streamService;

}
