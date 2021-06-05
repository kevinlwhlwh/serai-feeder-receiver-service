package com.kevinlam.serai.controller;

import com.kevinlam.serai.model.Feeder;
import com.kevinlam.serai.model.Receiver;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ReceiverApi {
    @RequestMapping(value = "/receive",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Receiver> createReceiverRecord(@RequestBody Feeder feeder);
}
