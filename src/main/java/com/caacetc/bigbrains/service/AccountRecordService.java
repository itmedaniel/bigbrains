package com.caacetc.bigbrains.service;

import com.caacetc.bigbrains.entity.AccountRecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AccountRecordService {
    BigDecimal profitBy(LocalDate date);
    BigDecimal totalIncomeBy(LocalDate date);
    BigDecimal totalSpendingBy(LocalDate date);
    List<AccountRecord> allAccountBy(LocalDate date);

    int insertSelective(AccountRecord record);

    int delAccountBy(Integer id);
}
