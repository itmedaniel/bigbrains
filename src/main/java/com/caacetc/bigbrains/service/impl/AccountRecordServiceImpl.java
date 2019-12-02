package com.caacetc.bigbrains.service.impl;

import com.caacetc.bigbrains.dao.AccountRecordMapper;
import com.caacetc.bigbrains.entity.AccountRecord;
import com.caacetc.bigbrains.service.AccountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class AccountRecordServiceImpl implements AccountRecordService {

    @Autowired
    private AccountRecordMapper accountRecordMapper;

    @Override
    public BigDecimal profitBy(LocalDate date) {
        return accountRecordMapper.getProfitByMonth(date.getMonthValue(), date.getYear());
    }

    @Override
    public BigDecimal totalIncomeBy(LocalDate date) {
        return accountRecordMapper.getTotalIncomeByMonth(date.getMonthValue(), date.getYear());
    }

    @Override
    public BigDecimal totalSpendingBy(LocalDate date) {
        return accountRecordMapper.getTotalSpendByMonth(date.getMonthValue(), date.getYear());
    }

    @Override
    public List<AccountRecord> allAccountBy(LocalDate date) {
        return accountRecordMapper.getAllAmountByMonth(date.getMonthValue(), date.getYear());
    }

    @Override
    public int insertSelective(AccountRecord record) {
        return accountRecordMapper.insertSelective(record);
    }

    @Override
    public int delAccountBy(Integer id) {
        return accountRecordMapper.deleteByPrimaryKey(id);
    }
}
