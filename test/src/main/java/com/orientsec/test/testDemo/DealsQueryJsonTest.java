package com.orientsec.test.testDemo;

import com.alibaba.fastjson.JSONObject;
import com.orientsec.test.agw.model.DealsQuery;
import com.orientsec.test.agw.model.json.DealsQueryJsonModel;
import com.orientsec.test.util.DataType;
import com.orientsec.test.util.ToJavaBeanUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class DealsQueryJsonTest {

    @Test(dataProvider = "dealsQueryData")
    public void getDealsQuery(DealsQuery dealsQuery) {
        System.out.println("getDealsQuery");
        System.out.println(JSONObject.toJSONString(dealsQuery));
        if (!"00555010".equals(dealsQuery.getCustId())) {
            throw new RuntimeException("错误的测试用例");
        }
    }

    @DataProvider(name = "dealsQueryData")
    public Object[] ProviderData() {
        String path = "E:\\testNg\\jsontest.json";
        List<DealsQueryJsonModel> dealsQueryXmlModelList = ToJavaBeanUtil.toJavaBeans(path, DealsQueryJsonModel.class, DataType.JSON);

        List<DealsQuery> dealsQueries = dealsQueryXmlModelList.stream().map(p -> {
            DealsQuery dealsQuery = converter(p);
            return dealsQuery;
        }).collect(Collectors.toList());
        return dealsQueries.toArray();
    }

    /**
     * 对象转换
     *
     * @param dealsQueryJsonModel csv转换对象
     * @return 查询对象
     */
    protected static DealsQuery converter(DealsQueryJsonModel dealsQueryJsonModel) {
        DealsQuery dealsQuery = new DealsQuery();
        dealsQuery.setCustId(dealsQueryJsonModel.getCustId());
        dealsQuery.setFundAccountId(dealsQueryJsonModel.getFundAccountId());
        dealsQuery.setAccountId(dealsQueryJsonModel.getAccountId());
        dealsQuery.setSecurityId(dealsQueryJsonModel.getSecurityId());
        dealsQuery.setClientFeatureCode(dealsQueryJsonModel.getClientFeatureCode());
        dealsQuery.setMarket(dealsQueryJsonModel.getMarket());
        dealsQuery.setBusinessType(dealsQueryJsonModel.getBusinessType());
        dealsQuery.setQueryIndex(dealsQueryJsonModel.getQueryIndex());
        dealsQuery.setReturnNum(dealsQueryJsonModel.getReturnNum());
        dealsQuery.setReturnOrder(dealsQueryJsonModel.getReturnOrder());
        return dealsQuery;
    }
}
