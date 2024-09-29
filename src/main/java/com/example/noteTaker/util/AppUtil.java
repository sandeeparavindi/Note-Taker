package com.example.noteTaker.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String createNoteId(){
        return "NOTE-" + UUID.randomUUID();
    }

    public static String createUserId(){
        return "USER-"+ UUID.randomUUID().toString();
    }

    public static String toBase64ProfilePic(MultipartFile profilePic) {
        String profilePicBase64 =  null;
        try {
            byte[] proPicBytes = profilePic.getBytes();
            return Base64.getEncoder().encodeToString(proPicBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return profilePicBase64;
    }

}
