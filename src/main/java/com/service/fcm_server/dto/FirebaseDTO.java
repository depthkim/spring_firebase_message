package com.service.fcm_server.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;


/**
 * FirebaseDTO Description
 * @author dev
 * @version 1.0.0
 * @date 2023-01-09
 * Description DTO Class for Firebase Messaging.
 *             For Detail Message DTO Setting, See below.
 *             https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#Notification
 *
**/
@Getter
@Setter
public class FirebaseDTO {
    List<String> token;
    HashMap<String, String> data;
    Notification notification;

    @Getter
    @Setter
    public static class Notification {
        String title;
        String body;
        String image;
    }
}
