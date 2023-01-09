package com.service.fcm_server.service;

import com.google.firebase.messaging.*;
import com.service.fcm_server.dto.FirebaseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


/**
 * FirebaseServiceImpl
 * @author kim
 * @version 1.0.0
 * @date 2023-01-09
 * Description
 *
**/
@Service
public class FirebaseServiceImpl implements FirebaseService{


/**
 *
 * send
 * @author dev
 * @version 1.0.0
 * @date 2023-01-09
 * Description Send Single Message To Application User
 *             For Send Detailed Object, see below.
 *             https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#Notification
 *
**/
    @Override
    public Mono send(FirebaseDTO request) throws FirebaseMessagingException {
        Message message = Message.builder()
                .setToken(request.getToken().get(0))
                .setNotification(
                        Notification.builder()
                                .setTitle(request.getNotification().getTitle())
                                .setBody(request.getNotification().getBody())
                                .setImage(request.getNotification().getImage())
                                .build()
                )
                .putAllData(request.getData())
                .build();

        return Mono.just(FirebaseMessaging.getInstance().send(message));
    }

    /**
     *
     * sendAll
     * @author dev
     * @version 1.0.0
     * @date 2023-01-09
     * Description Send Message To Multiple Application Users
     *
    **/
    @Override
    public Mono sendAll(FirebaseDTO request) throws FirebaseMessagingException {
        MulticastMessage message = MulticastMessage.builder()
                .addAllTokens(request.getToken())
                .setNotification(
                        Notification.builder()
                                .setTitle(request.getNotification().getTitle())
                                .setBody(request.getNotification().getBody())
                                .setImage(request.getNotification().getImage())
                                .build()
                )
                .putAllData(request.getData())
                .build();

        return Mono.just(FirebaseMessaging.getInstance().sendMulticast(message).getResponses());
    }
}
