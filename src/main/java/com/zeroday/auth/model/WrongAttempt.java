package com.zeroday.auth.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "wrong_attempt_audit")
public class WrongAttempt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attempt_id")
    private Long attemptId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "attempt_date")
    private LocalDate attemptDate;

    @Column(name = "attempt_date_time")
    private LocalDateTime attemptDateTime;

    @Column(name = "attempt_msg")
    private String attemptMessage;

    @Column(name = "remote_id")
    private String remoteIp;

    @Column(name = "status")
    private String status;

    public WrongAttempt() {
    }

    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getAttemptDate() {
        return attemptDate;
    }

    public void setAttemptDate(LocalDate attemptDate) {
        this.attemptDate = attemptDate;
    }

    public LocalDateTime getAttemptDateTime() {
        return attemptDateTime;
    }

    public void setAttemptDateTime(LocalDateTime attemptDateTime) {
        this.attemptDateTime = attemptDateTime;
    }

    public String getAttemptMessage() {
        return attemptMessage;
    }

    public void setAttemptMessage(String attemptMessage) {
        this.attemptMessage = attemptMessage;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WrongAttempt{" +
                "attemptId=" + attemptId +
                ", user=" + user +
                ", userName='" + userName + '\'' +
                ", attemptDate=" + attemptDate +
                ", attemptDateTime=" + attemptDateTime +
                ", attemptMessage='" + attemptMessage + '\'' +
                ", remoteIp='" + remoteIp + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
