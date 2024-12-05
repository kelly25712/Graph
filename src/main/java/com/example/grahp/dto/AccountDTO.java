package com.example.grahp.dto;

public class AccountDTO {
    private Integer idAccount;
    private Float accountNumber;
    private double balance;
    private Integer keyAccount;
    private Integer pointBBVA;
    private Integer idUser;

    public Integer getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

     // Getter y Setter para idAccount
     public Integer getIdAccount() {
        return idUser;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    // Getter y Setter para accountNumber
    public Float getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Float accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter y Setter para balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter y Setter para keyAccount
    public Integer getKeyAccount() {
        return keyAccount;
    }

    public void setKeyAccount(Integer keyAccount) {
        this.keyAccount = keyAccount;
    }

    // Getter y Setter para pointBBVA
    public Integer getPointBBVA() {
        return pointBBVA;
    }

    public void setPointBBVA(Integer pointBBVA) {
        this.pointBBVA = pointBBVA;
    }

}
