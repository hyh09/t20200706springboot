package com.javatooltest;

import com.demoweb.excelbo.Yun3DetailExcelBO;
import com.demoweb.excelutli.excel4j.binding.Excel2Bean;

import java.io.File;
import java.util.List;

import com.demoweb.excelutli.excel4j.binding.Excel2BeanRowMapper;
import com.demoweb.excelutli.excel4j.binding.impl.DefaultExcel4JavaRowMapper;
import com.demoweb.excelutli.excel4j.binding.impl.Excel4JavaImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * Created by dell on 2020/8/12.
 */
public class Test1 {


    private static final Logger LOGGER = LoggerFactory.getLogger(Test1.class);

    @Test
    public  void Test1(){

        String fileName = this.getClass().getClassLoader().getResource("3ma.xlsx").getPath();//获取文件路径
        //String fileUtl = this.getClass().getResource("3ma.xlsx").getFile();
            File targetFile = new File(fileName);//copyFile(filename, inputStream);
            Excel2Bean e4j = new Excel4JavaImpl();
            e4j.createExcelBook(targetFile);
            Excel2BeanRowMapper<Yun3DetailExcelBO> rowMapper = new AssetDetailExcelBoRowMapperExtendDefault();
            //从excel模板中转化为excelBo
            List<Yun3DetailExcelBO> assetDetailExcelBos = e4j.toBeans("Sheet1", 1, Integer.MAX_VALUE, rowMapper);
        LOGGER.info("assetDetailExcelBos==>"+assetDetailExcelBos);


    }



    class AssetDetailExcelBoRowMapperExtendDefault extends DefaultExcel4JavaRowMapper<Yun3DetailExcelBO> {

        @Override
        protected Yun3DetailExcelBO createBean() {
            return new Yun3DetailExcelBO();
        }

        @Override
        protected Yun3DetailExcelBO postRow2Bean(Yun3DetailExcelBO bean) {
            return bean;
        }
    }




    }

