package com.caacetc.bigbrains;

import java.math.BigDecimal;

/**
 * @author dangzhengyang
 * @date 2019/10/17
 * */

public class AccountRecord {
    private String name;
    private AccountCategory accountCategory;
    private String content;
    private String note;
    private BigDecimal amount;
    private String occurredTime;

    public AccountRecord(String name, AccountCategory accountCategory, String content, String note, BigDecimal amount, String occurredTime) {
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

    public String getContent() {
        return content;
    }

    public String getNote() {
        return note;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getOccurredTime() {
        return occurredTime;
    }

    public boolean isIncome() {
        return accountCategory == AccountCategory.Income;
    }

    public boolean isSpending() {
        return accountCategory == AccountCategory.Spending;
    }

    @Override
    public String toString() {
        return  "name :" + name + " type :" + accountCategory
                +" content :" + content + " note :" + note
                +" amount :" + amount + " occurredTime :" + occurredTime;
    }
}

