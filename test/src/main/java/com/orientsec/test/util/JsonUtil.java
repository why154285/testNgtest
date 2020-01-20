package com.orientsec.test.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.orientsec.test.agw.model.xml.DealsQueryXmlModel;

import java.util.List;

public class JsonUtil {

    public static <T> List<T> getJsonArray(String path, Class<T> clazz) {
        String jsonContent = FileUtil.ReadFile(path);

        List<T> list = JSON.parseArray(jsonContent, clazz);

        return list;
    }

    public static <T> T getJsonObj(String path, Class<T> clazz) {
        String jsonContent = FileUtil.ReadFile(path);

        T t = JSON.parseObject(jsonContent, clazz);

        return t;
    }

    public static void main(String[] args) {
        String path = "E:\\jsontest.json";
        List<DealsQueryXmlModel> dealsQueryXmlModelList = getJsonArray(path, DealsQueryXmlModel.class);
        dealsQueryXmlModelList.forEach(p -> {
            System.out.println(JSONObject.toJSONString(p));
        });
    }
}
