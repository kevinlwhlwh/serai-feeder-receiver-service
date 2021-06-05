package com.kevinlam.serai.sender.controller;

import com.kevinlam.serai.sender.Service.FeederService;
import com.kevinlam.serai.sender.model.Feeder;
import com.kevinlam.serai.sender.model.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class FeederApiController implements FeederApi {

    private static final Logger log = LoggerFactory.getLogger(FeederApiController.class);

    @Autowired
    FeederService feederService;

    @Override
    public ResponseEntity<Receiver> createReceiverRecord(Feeder feeder) {

        Receiver receiver = feederService.sendFeeder(feeder);

        return new ResponseEntity<>(receiver, HttpStatus.ACCEPTED);
    }
}
