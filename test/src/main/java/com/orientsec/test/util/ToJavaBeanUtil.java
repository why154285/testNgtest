package com.orientsec.test.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbwanghaiyang
 */
public class ToJavaBeanUtil {

    /**
     * 说明：通过指定路径和数据类型查询数据并转换成java集合。
     * 目前只提供csv和json转集合的功能
     *
     * @param path     文件的绝对路径
     * @param clazz    转换的类型
     * @param dataType 数据类型 csv，json
     * @param <T>      返回的数据类型
     * @return 集合
     */
    public static <T> List<T> toJavaBeans(String path, Class<T> clazz, DataType dataType) {
        if (DataType.CSV.equals(dataType)) {
            return CsvUtl.getCsvData(path, clazz);
        } else if (DataType.JSON.equals(dataType)) {
            return JsonUtil.getJsonArray(path, clazz);
        }
        return new ArrayList<>();
    }

    /**
     * 说明：通过指定路径和数据类型查询数据并转换成java对象
     *
     * @param path     文件的绝对路径
     * @param clazz    转换的类型
     * @param dataType 数据类型 csv，json
     * @param <T>      返回的数据类型
     * @return 对象
     */
    public static <T> T toJavaBean(String path, Class<T> clazz, DataType dataType) {
        if (DataType.CSV.equals(dataType)) {
            List<T> tList = CsvUtl.getCsvData(path, clazz);
            return tList.isEmpty() ? null : tList.get(0);
        } else if (DataType.JSON.equals(dataType)) {
            return JsonUtil.getJsonObj(path, clazz);
        } else if (DataType.XML.equals(dataType)) {
            return XMLUtil.convertXmlFileToObject(path, clazz);
        }
        return null;
    }
}
