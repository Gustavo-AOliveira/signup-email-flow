package com.ms.user.models;

import lombok.Data;

import java.util.UUID;
@Data
public class Email {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;

}