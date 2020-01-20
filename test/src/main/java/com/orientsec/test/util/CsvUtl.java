package com.orientsec.test.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author wbwanghaiyang
 */
public class CsvUtl {


    /**
     * 解析csv文件并转成bean
     *
     * @param filePath csv文件
     * @param clazz    类
     * @param <T>      泛型
     * @return 泛型bean集合
     */
    public static  <T> List<T> getCsvData(String filePath, Class<T> clazz) {
        InputStreamReader in;

        try {
            InputStream inputStream = new FileInputStream(filePath);
            in = new InputStreamReader(inputStream, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("读取csv文件异常");
        }

        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in)
                .withSeparator(',')
                .withQuoteChar('\'')
                .withMappingStrategy(strategy).build();
        return csvToBean.parse();
    }

}
