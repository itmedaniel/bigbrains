package com.caacetc.bigbrains;

/**
 * @author dangzhengyang
 * @date 2019/10/17
 * */

public enum AccountCategory {
    Spending("Spending"),
    Income("Income");

    private String description;
    AccountCategory(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
