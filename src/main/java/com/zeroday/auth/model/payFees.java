package com.zeroday.auth.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payFees")
public class payFees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feesId;

    private String cardNumber;

    private String securityCode;

    private String expireDate;

    private String cardName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Long getPayFees() {
        return feesId;
    }

    public void setPayFees(Long feesId) {
        this.feesId = feesId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDateString(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Long getFeesId() {
        return feesId;
    }

    public void setFeesId(Long feesId) {
        this.feesId = feesId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

}
