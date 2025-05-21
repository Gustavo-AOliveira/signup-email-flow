package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMAILS")
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private UUID userId;
    private String emailTo;
    private String emailFrom;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private StatusEmail status;
    private LocalDateTime sendDateEmail;

    public Email() {
    }
    public Email(UUID emailId, UUID userId, String emailTo, String emailFrom, String subject, String text, StatusEmail status, LocalDateTime sendDateEmail) {
        this.emailId = emailId;
        this.userId = userId;
        this.emailTo = emailTo;
        this.emailFrom = emailFrom;
        this.subject = subject;
        this.text = text;
        this.status = status;
        this.sendDateEmail = sendDateEmail;
    }

    public String getEmailTo() {
        return emailTo;
    }
    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }
    public String getEmailFrom() {
        return emailFrom;
    }
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public StatusEmail getStatus() {
        return status;
    }
    public void setStatus(StatusEmail status) {
        this.status = status;
    }
    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }
    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }
}
