package com.caacetc.bigbrains.controller;

import com.caacetc.bigbrains.entity.AccountRecord;
import com.caacetc.bigbrains.service.AccountRecordService;
import com.caacetc.bigbrains.utils.TimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
@Api(value = "AccountRecordController", description = "账单信息的一些接口")
@RequestMapping("account")
public class AccountRecordController {

    @Autowired
    private final AccountRecordService accountRecordService;

    @Autowired
    public AccountRecordController(AccountRecordService accountRecordService) {
        this.accountRecordService = accountRecordService;
    }


    @ApiOperation(value="获取对应年月的利润", notes=" by dzy ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "date", value = "年月", dataType = "string"),
    })
    @RequestMapping(value = "profit",method = RequestMethod.GET)
    @ResponseBody
    public String profitBy(@RequestParam(value = "2019-12-2") String date) {
        BigDecimal profit = accountRecordService.profitBy(TimeUtil.localDateParse(date,TimeUtil.FORMAT_PATTERN3));
        System.out.println(date+"月份的利润是"+profit);
        return date+"月 的利润是："+profit;
    }

    @ApiOperation(value="获取对应年月的总收入", notes=" by dzy ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "date", value = "年月", dataType = "string"),
    })
    @RequestMapping(value = "income",method = RequestMethod.GET)
    @ResponseBody
    public String totalIncomeby(@RequestParam(value = "2019-12-2") String date) {
        BigDecimal totalIncome = accountRecordService.totalIncomeBy(TimeUtil.localDateParse(date,TimeUtil.FORMAT_PATTERN3));
        System.out.println(date+"月份的收入是"+totalIncome);
        return date+"月 的收入是："+totalIncome;
    }

    @ApiOperation(value="获取对应年月的总支出", notes=" by dzy ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "date", value = "年月", dataType = "string"),
    })
    @RequestMapping(value = "spending",method = RequestMethod.GET)
    @ResponseBody
    public String totalSpendingBy(@RequestParam(value = "2019-12-2") String date) {
        BigDecimal totalSpending = accountRecordService.totalSpendingBy(TimeUtil.localDateParse(date,TimeUtil.FORMAT_PATTERN3));
        return date+"月 的支出是："+totalSpending;
    }

    @ApiOperation(value="获取对应年月的总记录", notes=" by dzy ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "date", value = "年月", dataType = "string"),
    })
    @RequestMapping(value = "all",method = RequestMethod.GET)
    @ResponseBody
    public List<AccountRecord> allRecordsBy(@RequestParam(value = "2019-12-2") String date) {
        return accountRecordService.allAccountBy(TimeUtil.localDateParse(date,TimeUtil.FORMAT_PATTERN3));
    }

    @ApiOperation(value="新增账单记录", notes=" by dzy ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id", value = "自动生成，无需输入", dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "name", value = "账目名称", dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "accountCategory", value = "账目类型，1：收入，-1：支出", dataType = "LocalDate"),
            @ApiImplicitParam(paramType = "query",name = "content", value = "内容", dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "note", value = "备注：如购物物品为钢笔、苹果", dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "amount", value = "金额", dataType = "BigDecimal"),
            @ApiImplicitParam(paramType = "query",name = "occurredTime", value = "日期", dataType = "LocalDate")

    })
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public String addBy(AccountRecord accountRecord) {
        accountRecord.setId(null);
        System.out.println("account:"+accountRecord.getAmount()+"date:"+accountRecord.getOccurredTime());
        int result = accountRecordService.insertSelective(accountRecord);
        return result>0?"新增成功":"新增失败";
    }

    @ApiOperation(value="根据主键id，删除记录", notes=" by dzy ")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id", value = "主键", dataType = "int")

    })
    @RequestMapping(value = "del",method = RequestMethod.GET)
    @ResponseBody
    public String delAccountBy(@RequestParam(value = "id") Integer id) {
        int result = accountRecordService.delAccountBy(id);
        return result>0?"删除成功":"删除失败";
    }

}
