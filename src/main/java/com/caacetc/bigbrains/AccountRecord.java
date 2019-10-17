package com.caacetc.bigbrains;

import com.google.gson.Gson;

/**
 * @author dangzhengyang
 * @date 2019/10/17
 * */

public class AccountRecord {
    private String name;
    private AccountCategory accountCategory;
    private String content;
    private String note;
    private double amount;
    private String occurredTime;

    public AccountRecord(String name, AccountCategory accountCategory, String content, String note, double amount, String occurredTime) {
        this.name = name;
        this.accountCategory = accountCategory;
        this.content = content;
        this.note = note;
        this.amount = amount;
        this.occurredTime = occurredTime;
    }

    public String getName() {
        return name;
    }

    public AccountCategory getAccountCategory() {
        return accountCategory;
    }

    public String getContent() {
        return content;
    }

    public String getNote() {
        return note;
    }

    public double getAmount() {
        return amount;
    }

    public String getOccurredTime() {
        return occurredTime;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

