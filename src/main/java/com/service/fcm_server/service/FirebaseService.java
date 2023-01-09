package com.service.fcm_server.service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.service.fcm_server.dto.FirebaseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

public interface FirebaseService {
    Mono send(@RequestBody FirebaseDTO request) throws FirebaseMessagingException;
    Mono sendAll(@RequestBody FirebaseDTO request) throws FirebaseMessagingException;
}
