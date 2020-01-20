package com.orientsec.test.testDemo;

import com.alibaba.fastjson.JSONObject;
import com.orientsec.test.agw.model.DealsQuery;
import com.orientsec.test.agw.model.csv.DealsQueryModel;
import com.orientsec.test.util.DataType;
import com.orientsec.test.util.ToJavaBeanUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;


public class DealsQueryCsvTest {


    @Test(dataProvider = "dealsQueryData",threadPoolSize = 5,invocationCount=5)
    public void getDealsQuery(DealsQuery dealsQuery) {
        System.out.println("thread id :"+Thread.currentThread().getId());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getDealsQuery");
        System.out.println(JSONObject.toJSONString(dealsQuery));
        if (!"00555010".equals(dealsQuery.getCustId())){
            throw new RuntimeException("错误的测试用例");
        }
    }

    @DataProvider(name = "dealsQueryData")
    public Object[] ProviderData() {
        String path = "E:\\testNg\\csvtest.csv";
        List<DealsQueryModel> dealsQueryModels = ToJavaBeanUtil.toJavaBeans(path, DealsQueryModel.class, DataType.CSV);
        List<DealsQuery> dealsQueries = dealsQueryModels.stream().map(p -> {
            DealsQuery dealsQuery = converter(p);
            return dealsQuery;
        }).collect(Collectors.toList());
        return dealsQueries.toArray();
    }

    /**
     * 对象转换
     *
     * @param dealsQueryModel csv转换对象
     * @return 查询对象
     */
    protected static DealsQuery converter(DealsQueryModel dealsQueryModel) {
        DealsQuery dealsQuery = new DealsQuery();
        dealsQuery.setCustId(dealsQueryModel.getCustId());
        dealsQuery.setFundAccountId(dealsQueryModel.getFundAccountId());
        dealsQuery.setAccountId(dealsQueryModel.getAccountId());
        dealsQuery.setSecurityId(dealsQueryModel.getSecurityId());
        dealsQuery.setClientFeatureCode(dealsQueryModel.getClientFeatureCode());
        dealsQuery.setMarket(dealsQueryModel.getMarket());
        dealsQuery.setBusinessType(dealsQueryModel.getBusinessType());
        dealsQuery.setQueryIndex(dealsQueryModel.getQueryIndex());
        dealsQuery.setReturnNum(dealsQueryModel.getReturnNum());
        dealsQuery.setReturnOrder(dealsQueryModel.getReturnOrder());
        return dealsQuery;
    }


}
