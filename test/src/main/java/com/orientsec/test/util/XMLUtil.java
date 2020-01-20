package com.orientsec.test.util;

import com.alibaba.fastjson.JSONObject;
import com.orientsec.test.agw.model.xml.DealsQueryXmlModels;
import com.orientsec.test.agw.model.xml.DealsQueryXmlModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author wbwanghaiyang
 */
public class XMLUtil {
    /**
     * 将对象直接转换成String类型的 XML输出
     *
     * @param obj 对象
     * @return String
     */
    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    /**
     * 将对象根据路径写入指定的xml文件里
     *
     * @param obj  对象
     * @param path 路径
     */
    public static void convertToXml(Object obj, String path) {
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 将对象转换成输出流形式的xml
            // 创建输出流
            FileWriter fw = null;
            try {
                fw = new FileWriter(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            marshaller.marshal(obj, fw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将对象根据路径写入指定的xml文件里
     *
     * @param calzz 对象
     * @param path  路径
     */
    public static <T> void convertToXml(Object obj, Class<T> calzz, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(calzz);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 将对象转换成输出流形式的xml
            // 创建输出流
            FileWriter fw = null;
            try {
                fw = new FileWriter(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            jaxbMarshaller.marshal(obj, fw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将String类型的xml转换成对象
     */
    public static Object convertXmlStrToObject(Class<?> clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshal = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshal.unmarshal(sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 将file类型的xml转换成对象
     */
    public static <T> T convertXmlFileToObject( String xmlPath,Class<T> clazz) {
        T xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            try {
                fr = new FileReader(xmlPath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            xmlObject = (T)unmarshaller.unmarshal(fr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlObject;
    }



    public static void main(String[] args) {
        convertToXmlTest();
//        convertXmlFileToObjectTest();
    }

    private static void convertXmlFileToObjectTest() {
        String path = "E:\\xmltest2.xml";
        DealsQueryXmlModels dealsQueryXmlModels = (DealsQueryXmlModels) XMLUtil.convertXmlFileToObject( path,DealsQueryXmlModels.class);
        System.out.println(JSONObject.toJSONString(dealsQueryXmlModels));
    }

    // 通过
    private static void convertToXmlTest() {
        String path = "E:\\xmltest3.xml";
//        convertXmlFileToObject(DealsQueryModel.class,path);
        DealsQueryXmlModels dealsQueryXmlModels = new DealsQueryXmlModels();
        List<DealsQueryXmlModel> dealsQueryModelList = new ArrayList<>();
        DealsQueryXmlModel dealsQueryModel = new DealsQueryXmlModel();
        dealsQueryModel.setCustId("00555010");
        dealsQueryModel.setFundAccountId("00555010");
        dealsQueryModel.setAccountId("11");
        dealsQueryModel.setBusinessType("0");
        dealsQueryModel.setClientFeatureCode("fa");
        dealsQueryModel.setMarket("0");
        dealsQueryModel.setBusinessType("0");
        dealsQueryModel.setQueryIndex(0);
        dealsQueryModel.setReturnNum(0);
        dealsQueryModel.setReturnOrder(1);
        dealsQueryModel.setUserInfo("aaaaaaaaaaaa");
        dealsQueryModel.setPassword("123321");
        dealsQueryModelList.add(dealsQueryModel);
        dealsQueryModelList.add(dealsQueryModel);
        dealsQueryXmlModels.setDealsQueryXmlModel(dealsQueryModelList);
        convertToXml(dealsQueryXmlModels, DealsQueryXmlModels.class, path);
    }

}
