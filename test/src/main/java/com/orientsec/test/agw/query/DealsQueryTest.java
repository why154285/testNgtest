package com.orientsec.test.agw.query;

import com.alibaba.fastjson.JSONObject;

import com.orientsec.test.agw.model.DealsQuery;
import com.orientsec.test.agw.model.csv.DealsQueryModel;
import com.orientsec.test.util.CsvUtl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class DealsQueryTest {

    @Test(dataProvider = "dealsQueryData")
    public void getDealsQuery(DealsQuery dealsQuery) {
        System.out.println("getDealsQuery");
        System.out.println(JSONObject.toJSONString(dealsQuery));
        if (!"00555010".equals(dealsQuery.getCustId())){
            throw new RuntimeException("错误的测试用例");
        }
    }

    @DataProvider(name = "dealsQueryData")
    public Object[] ProviderData() {
        String path = "E:\\csvtest.csv";
        List<DealsQueryModel> dealsQueryModels = CsvUtl.getCsvData(path, DealsQueryModel.class);
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
    private static DealsQuery converter(DealsQueryModel dealsQueryModel) {
        DealsQuery dealsQuery = new DealsQuery();
        dealsQuery.setCustId(dealsQueryModel.getCustId());
        dealsQuery.setFundAccountId(dealsQueryModel.getFundAccountId());
        dealsQuery.setAccountId(dealsQueryModel.getAccountId());
        dealsQuery.setSecurityId(dealsQueryModel.getSecurityId());
        dealsQuery.setClientFeatureCode(dealsQueryModel.getClientFeatureCode());
        dealsQuery.setMarket(dealsQueryModel.getMarket());
        dealsQuery.setClientSeqId(System.nanoTime());
        dealsQuery.setBusinessType(dealsQueryModel.getBusinessType());
        dealsQuery.setQueryIndex(dealsQueryModel.getQueryIndex());
        dealsQuery.setReturnNum(dealsQueryModel.getReturnNum());
        dealsQuery.setReturnOrder(dealsQueryModel.getReturnOrder());
        return dealsQuery;
    }


}
