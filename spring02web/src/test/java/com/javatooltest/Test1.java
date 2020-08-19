package com.javatooltest;

import com.demoweb.excelbo.Yun3DetailExcelBO;
import com.demoweb.excelutli.excel4j.TxtR;
import com.demoweb.excelutli.excel4j.binding.Excel2Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demoweb.excelutli.excel4j.binding.Excel2BeanRowMapper;
import com.demoweb.excelutli.excel4j.binding.impl.DefaultExcel4JavaRowMapper;
import com.demoweb.excelutli.excel4j.binding.impl.Excel4JavaImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Created by dell on 2020/8/12.
 */
public class Test1 {


    private static final Logger LOGGER = LoggerFactory.getLogger(Test1.class);

    @Test
    public  void  Test1111(){
        String  str="shdx056";
        int int1 = Integer.parseInt(str.substring(4,7));
        LOGGER.info("三码密码为bo1:"+int1);
    }



    @Test
    public  void  Test10(){
        String fileName1 = "E:\\workhome\\Test\\t20200706\\spring02web\\src\\main\\resources\\logsanma.txt";//his.getClass().getClassLoader().getResource("log1.txt").getPath();//获取文件路径

        String fileName = "E:\\workhome\\Test\\t20200706\\spring02web\\src\\main\\resources\\log1.txt";//his.getClass().getClassLoader().getResource("log1.txt").getPath();//获取文件路径
        LOGGER.info("log1.txt："+fileName);
        List<BoExcelBo>  excelBos =   reditxt();
        LOGGER.info("最后的结果："+excelBos);
        for(BoExcelBo bo1:excelBos) {
            TxtR.method2(fileName,bo1.toString());
            String ace=  bo1.getActive();//shdx056
            int int1 = Integer.parseInt(ace.substring(4,7));
            LOGGER.info("三码密码为bo1:"+int1);

            if (int1>49 && int1<96){
                LOGGER.info("三码密码为bo1:"+bo1);
                Yun3DetailExcelBO yun = getExcel("三码");
               // ssh  hbase44@10.128.109.10
                String str1="ssh "+yun.getUserName()+"@"+bo1.getHost()+"     ###三码密码为"+yun.getPassword();
                TxtR.method2(fileName1,str1);

            }

            List<String>  stringList=   bo1.getStringList();
            for(int i=0;i<stringList.size();i++) {
                Yun3DetailExcelBO yu2 = getExcel(stringList.get(i));
                if(yu2==null){
                    LOGGER.info("bo1====》"+bo1);
                }
                String str1="ssh "+yu2.getUserName()+"@"+bo1.getHost()+"     ###密码为"+yu2.getPassword();
                TxtR.method2(fileName,str1);
            }
        }


    }

    /**
     *d读取原文件
     */
    private   List<BoExcelBo> reditxt(){
        List<BoExcelBo> excelBos = new ArrayList<>();

        String fileName = this.getClass().getClassLoader().getResource("1.txt").getPath();//获取文件路径
        List<String>  list =  TxtR.readTxtFile(fileName);
        LOGGER.info("===>"+list);
        if(!CollectionUtils.isEmpty(list)){
            for(int i=0;i<list.size();i++){
                String[] split = list.get(i).split("#");
                LOGGER.info("每个的棘突===>"+ Arrays.toString(split));
                excelBos.add(getBoExcelBo(split));
            }
        }

        return  excelBos;
    }


//    private


    /**
     * 获取当前的省份
     * @param spliterr
     * @return
     */
    private  BoExcelBo getBoExcelBo(String[] spliterr){
        BoExcelBo  excelBo = new BoExcelBo();
        List<String> stringList  =new ArrayList<>();
        LOGGER.info("spliterr大小"+spliterr.length);
        for(int i=0;i<spliterr.length;i++){
//            BoExcelBo  excelBo = new BoExcelBo();
            if(i==0){
                String[] strings1 = spliterr[0].split("\t");
                LOGGER.info("===>"+ Arrays.toString(strings1));
                LOGGER.info("===>"+ strings1.length);
                excelBo.setActive(strings1[0].trim());
                excelBo.setHost(strings1[1].trim());
            }else {
                //宁夏Hregionserver , 海南Hregionserver , 新疆Hregionserver  , 陕西Hmaster
                //截取前2位
                LOGGER.info("当前省份"+ spliterr[i]+"====>"+i);

                String str =   spliterr[i].substring(0,2).trim();
                LOGGER.info("当前省份"+ str);
                stringList.add(str);
            }

        }
        LOGGER.debug("最后的省份"+stringList);
        excelBo.setStringList(stringList);
        excelBo.setSsh("#注意启的节点格为："+Arrays.toString(spliterr));
        LOGGER.info("excelBo"+excelBo);

        return  excelBo;

    }




    /**
     *
     * @return
     */
    public Yun3DetailExcelBO   getExcel(String province){
        if(StringUtils.isEmpty(province)){
            return  null;
        }

        String fileName = this.getClass().getClassLoader().getResource("3ma.xlsx").getPath();//获取文件路径
        //String fileUtl = this.getClass().getResource("3ma.xlsx").getFile();
            File targetFile = new File(fileName);//copyFile(filename, inputStream);
            Excel2Bean e4j = new Excel4JavaImpl();
            e4j.createExcelBook(targetFile);
            Excel2BeanRowMapper<Yun3DetailExcelBO> rowMapper = new AssetDetailExcelBoRowMapperExtendDefault();
            //从excel模板中转化为excelBo
            List<Yun3DetailExcelBO> assetDetailExcelBos = e4j.toBeans("Sheet1", 1, Integer.MAX_VALUE, rowMapper);
        LOGGER.info("assetDetailExcelBos==>"+assetDetailExcelBos);

        for(Yun3DetailExcelBO bo:assetDetailExcelBos){
            if(bo.getProvince().trim().equals(province.trim())){
                return  bo;
            }
        }


    return  null;

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


    @Test
    public  void Test199sh (){
        String ip="10.128.109.110";
        Yun3DetailExcelBO bo=    getExcelshh("湖南");
        System.out.println("ssh "+bo.getUserName()+"@"+ip+"     =====|"+bo.getPassword()+"|====");
    }


    public Yun3DetailExcelBO   getExcelshh(String province){
        if(StringUtils.isEmpty(province)){
            return  null;
        }

        String fileName = this.getClass().getClassLoader().getResource("3ma.xlsx").getPath();//获取文件路径
        //String fileUtl = this.getClass().getResource("3ma.xlsx").getFile();
        File targetFile = new File(fileName);//copyFile(filename, inputStream);
        Excel2Bean e4j = new Excel4JavaImpl();
        e4j.createExcelBook(targetFile);
        Excel2BeanRowMapper<Yun3DetailExcelBO> rowMapper = new AssetDetailExcelBoRowMapperExtendDefault();
        //从excel模板中转化为excelBo
        List<Yun3DetailExcelBO> assetDetailExcelBos = e4j.toBeans("Sheet1", 1, Integer.MAX_VALUE, rowMapper);
        LOGGER.info("assetDetailExcelBos==>"+assetDetailExcelBos);

        for(Yun3DetailExcelBO bo:assetDetailExcelBos){
            if(bo.getProvince().trim().equals(province.trim())){
                return  bo;
            }
        }


        return  null;

    }




    }







