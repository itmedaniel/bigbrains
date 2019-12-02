package com.caacetc.bigbrains.dao;


import com.caacetc.bigbrains.entity.AccountRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface AccountRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AccountRecord record);

    int insertSelective(AccountRecord record);

    AccountRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountRecord record);

    int updateByPrimaryKey(AccountRecord record);

    BigDecimal getProfitByMonth(@Param("month") Integer month,@Param("year") Integer year);

    BigDecimal getTotalIncomeByMonth(@Param("month") Integer month,@Param("year") Integer year);

    BigDecimal getTotalSpendByMonth(@Param("month") Integer month,@Param("year") Integer year);

    List<AccountRecord> getAllAmountByMonth(@Param("month") Integer month, @Param("year") Integer year);
}