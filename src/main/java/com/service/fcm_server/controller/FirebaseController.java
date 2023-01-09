package com.service.fcm_server.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.service.fcm_server.dto.FirebaseDTO;
import com.service.fcm_server.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class FirebaseController {

    @Autowired
    FirebaseService firebaseService;

    /**
     *
     * sendPushMessage
     * @author dev
     * @version 1.0.0
     * @date 2023-01-09
     * Description Send Message To Single User
     *
    **/
    @PostMapping("/send")
    public Mono<?> sendPushMessage(@RequestBody FirebaseDTO request) throws FirebaseMessagingException {
        return firebaseService.send(request);
    }

    /**
     *
     * sendAllPushMessage
     * @author dev
     * @version 1.0.0
     * @date 2023-01-09
     * Description Send Message To Multiple User
     *
    **/
    @PostMapping("/sendAll")
    public Mono<?> sendAllPushMessage(@RequestBody FirebaseDTO request) throws FirebaseMessagingException {
        return firebaseService.sendAll(request);
    }
}
