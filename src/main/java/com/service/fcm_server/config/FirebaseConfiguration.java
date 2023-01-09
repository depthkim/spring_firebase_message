package com.service.fcm_server.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 * FirebaseConfiguration
 * @author dev
 * @version 1.0.0
 * @date 2023-01-09
 * Description Configuration Class For Firebase Instance Setting
 *
**/
@Configuration
public class FirebaseConfiguration {
    @Value("${config.firebase.account-path}")
    String account;

    @Bean
    FirebaseApp firebaseApp() throws IOException {

        // Get Firebase Account Configuration File in Resource Folder
        InputStream firebaseAccount = ClassLoader.getSystemResourceAsStream(account);

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(firebaseAccount))
                .build();

        return FirebaseApp.initializeApp(options);
    }
}
