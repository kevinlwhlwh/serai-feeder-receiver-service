package com.kevinlam.serai.controller;

import com.kevinlam.serai.model.Feeder;
import com.kevinlam.serai.model.Receiver;
import com.kevinlam.serai.service.ReceiverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
@Controller
public class ReceiverApiController implements ReceiverApi{

    private static final Logger log = LoggerFactory.getLogger(ReceiverApiController.class);

    @Autowired
    public ReceiverService receiverService;

    @Override
    public ResponseEntity<Receiver> createReceiverRecord(Feeder feeder) {
        Receiver receiver = receiverService.receiveFeed(feeder);
        return new ResponseEntity<>(receiver, HttpStatus.ACCEPTED);
    }
}
