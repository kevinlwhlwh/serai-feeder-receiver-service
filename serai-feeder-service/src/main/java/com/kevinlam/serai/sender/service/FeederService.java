package com.kevinlam.serai.sender.service;

import com.kevinlam.serai.sender.model.Feeder;
import com.kevinlam.serai.sender.model.Receiver;

public interface FeederService {
    Receiver sendFeeder(Feeder feeder);
}
