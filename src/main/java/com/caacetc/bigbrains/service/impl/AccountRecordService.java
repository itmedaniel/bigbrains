package com.caacetc.bigbrains.service.impl;

import com.caacetc.bigbrains.dao.AccountRecordMapper;
import com.caacetc.bigbrains.entity.AccountRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class AccountRecordService {

    @Autowired
    private AccountRecordMapper accountRecordMapper;

    public BigDecimal profitBy(LocalDate date) {
        return accountRecordMapper.getProfitByMonth(date.getMonthValue(), date.getYear());
    }

    public BigDecimal totalIncomeBy(LocalDate date) {
        return accountRecordMapper.getTotalIncomeByMonth(date.getMonthValue(), date.getYear());
    }

    public BigDecimal totalSpendingBy(LocalDate date) {
        return accountRecordMapper.getTotalSpendByMonth(date.getMonthValue(), date.getYear());
    }

    public List<AccountRecord> allAccountBy(LocalDate date) {
        return accountRecordMapper.getAllAmountByMonth(date.getMonthValue(), date.getYear());
    }

    public int insertSelective(AccountRecord record) {
        return accountRecordMapper.insertSelective(record);
    }

    public int delAccountBy(Integer id) {
        return accountRecordMapper.deleteByPrimaryKey(id);
    }
}
