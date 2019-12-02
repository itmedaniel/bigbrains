package com.caacetc.bigbrains.entity;

import com.caacetc.bigbrains.utils.TimeUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author dangzhengyang
 * @date 2019/10/17
 * */

public class AccountRecord {

    private Integer id;
    private String name;
    private Integer accountCategory;
    private String content;
    private String note;
    private BigDecimal amount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate occurredTime;

    public AccountRecord() {

    }


    public AccountRecord(String name, Integer accountCategory, String content, String note, BigDecimal amount, String occurredTime) {
        this.name = name;
        this.accountCategory = accountCategory;
        this.content = content;
        this.note = note;
        this.amount = amount;
        this.occurredTime = TimeUtil.localDateParse(occurredTime,TimeUtil.FORMAT_PATTERN3);
    }


    public AccountRecord(String name, Integer accountCategory, String content, String note, BigDecimal amount, LocalDate occurredTime) {
        this.name = name;
        this.accountCategory = accountCategory;
        this.content = content;
        this.note = note;
        this.amount = amount;
        this.occurredTime = occurredTime;
    }

    public AccountRecord(Integer id, String name, Integer accountCategory, String content, String note, BigDecimal amount, LocalDate occurredTime) {
        this.id = id;
        this.name = name;
        this.accountCategory = accountCategory;
        this.content = content;
        this.note = note;
        this.amount = amount;
        this.occurredTime = occurredTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(Integer accountCategory) {
        this.accountCategory = accountCategory;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getOccurredTime() {
        return occurredTime;
    }

    public void setOccurredTime(String occurredTime) {
        this.occurredTime = TimeUtil.localDateParse(occurredTime,TimeUtil.FORMAT_PATTERN3);
    }

    public void setOccurredTime(LocalDate occurredTime) {
        this.occurredTime = occurredTime;
    }

    public boolean isIncome() {
        return accountCategory == 1;
    }

    public boolean isSpending() {
        return accountCategory == -1;
    }

    @Override
    public String toString() {
        return  "name :" + name + " type :" + accountCategory
                +" content :" + content + " note :" + note
                +" amount :" + amount + " occurredTime :" + occurredTime;
    }
}

