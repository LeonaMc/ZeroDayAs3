package com.zeroday.auth.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "payFees")
public class payFees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Boolean payFees = false;

    private String cardNumber;

    private String securityCode;

    private String expireDate;

    private String cardName;

    public Boolean getPayFees() {
        return payFees;
    }

    public void setPayFees(String cardNumber) {
        this.payFees = (!payFees);
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

    public void setExpireDateString (String expireDate) { this.expireDate = expireDate; }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
