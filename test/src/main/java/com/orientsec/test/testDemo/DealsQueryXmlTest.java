package com.orientsec.test.testDemo;

import com.alibaba.fastjson.JSONObject;
import com.orientsec.test.agw.model.DealsQuery;
import com.orientsec.test.agw.model.xml.DealsQueryXmlModel;
import com.orientsec.test.agw.model.xml.DealsQueryXmlModels;
import com.orientsec.test.util.DataType;
import com.orientsec.test.util.ToJavaBeanUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class DealsQueryXmlTest {

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
        String path = "E:\\testNg\\xmltest2.xml";
        DealsQueryXmlModels dealsQueryXmlModels =ToJavaBeanUtil.toJavaBean(path, DealsQueryXmlModels.class,DataType.XML);

        List<DealsQuery> dealsQueries = dealsQueryXmlModels.getDealsQueryXmlModel().stream().map(p -> {
            DealsQuery dealsQuery = converter(p);
            return dealsQuery;
        }).collect(Collectors.toList());
        return dealsQueries.toArray();
    }

    /**
     * 对象转换
     *
     * @param dealsQueryXmlModel csv转换对象
     * @return 查询对象
     */
    protected static DealsQuery converter(DealsQueryXmlModel dealsQueryXmlModel) {
        DealsQuery dealsQuery = new DealsQuery();
        dealsQuery.setCustId(dealsQueryXmlModel.getCustId());
        dealsQuery.setFundAccountId(dealsQueryXmlModel.getFundAccountId());
        dealsQuery.setAccountId(dealsQueryXmlModel.getAccountId());
        dealsQuery.setSecurityId(dealsQueryXmlModel.getSecurityId());
        dealsQuery.setClientFeatureCode(dealsQueryXmlModel.getClientFeatureCode());
        dealsQuery.setMarket(dealsQueryXmlModel.getMarket());
        dealsQuery.setClientSeqId(System.nanoTime());
        dealsQuery.setBusinessType(dealsQueryXmlModel.getBusinessType());
        dealsQuery.setQueryIndex(dealsQueryXmlModel.getQueryIndex());
        dealsQuery.setReturnNum(dealsQueryXmlModel.getReturnNum());
        dealsQuery.setReturnOrder(dealsQueryXmlModel.getReturnOrder());
        return dealsQuery;
    }


}
