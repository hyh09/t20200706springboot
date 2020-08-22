package com.zk;

/**
 * Created by dell on 2020/8/21.
 */

import com.sinovate.ngrms.gcbscsvr.das.support.Utils.BeanMapUtils;
import com.sinovate.ngrms.gcbscsvr.das.support.Utils.CamelNameUtils;
import com.sinovate.ngrms.gcbscsvr.mdl.db.gcdm.eother.PmAssetMssback;
import com.utltl.Stringtool;
import com.utltl.TxtR;
import com.utltl.exceltool.ExportExcelyunUtils;
import com.utltl.exceltool.beansvc.Conf;
import com.utltl.exceltool.beansvc.FileShow;
import com.utltl.exceltool.beansvc.JsonDateValueProcessor;
import com.utltl.exceltool.excel4j.binding.Excel2Bean;
import com.utltl.exceltool.excel4j.binding.Excel2BeanRowMapper;
import com.utltl.exceltool.excel4j.binding.impl.DefaultExcel4JavaRowMapper;
import com.utltl.exceltool.excel4j.binding.impl.Excel4JavaImpl;
import com.utltl.exceltool.mobansanm.RequestforreferenceBo;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.*;

public class PmAssetMssbackTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmAssetMssbackTest.class);


    /**
     * 交资的明细的入参对象
     * @throws Exception
     */
       @Test
        public  void Test1() throws Exception{
            String mapJson = "";

            List<Map<String, Object>> dateMapList = new ArrayList<Map<String, Object>>();

           // PmAssetMssback pmAssetMssback =new PmAssetMssback();
        List<RequestforreferenceBo> requestforreferenceBoList = new ArrayList<>();

           /**
            *
            */
        PmAssetMssback pmAssetMssback=   getInstance(new PmAssetMssback(),requestforreferenceBoList); //填充这个
        System.out.println("=====>"+pmAssetMssback);
        List<PmAssetMssback> voList =new ArrayList<>();
//       new  ExportExcelyunUtils().write2File("",voList,new PmAssetMssback());
            Map<String, Object> stringObjectMap = new HashMap<String, Object>();
            stringObjectMap = modfyMap(BeanMapUtils.getValue(pmAssetMssback));
            dateMapList.add(stringObjectMap);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jsonConfig.registerJsonValueProcessor(BigInteger.class, new JsonDateValueProcessor());
            mapJson = JSONArray.fromObject(dateMapList, jsonConfig).toString();
           System.out.println("mapJson:"+mapJson);


       new  ExportExcelyunUtils().write2File("交资明细信息同步接口【请求参数列表】",requestforreferenceBoList,new RequestforreferenceBo());
       new TxtR().method3("交资明细信息同步接口",new Stringtool().formatbyFastJson(mapJson));



        }



    /**
     * 反射取值
     * @param bean
     * @param requestforreferenceBoList
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static  <T> T getInstance(T bean,List<RequestforreferenceBo> requestforreferenceBoList) throws IllegalAccessException, InstantiationException {
        Class<?> clz = bean.getClass();
      //  Object obj = bean.getClass().newInstance();

        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            boolean filedHasAnno = field.isAnnotationPresent(Conf.class);
            Class<?> type = field.getType();
            String typeName = type.getSimpleName();


            if (filedHasAnno) {
                field.setAccessible(true);

                Conf annotation = field.getAnnotation(Conf.class);
                Object value = annotation.value();
                System.out.println("====>field"+field+"==>value:"+value+"==typeName:"+typeName+"===>type:"+type);
                if(typeName.equals("BigInteger")){
                    field.set(bean, new BigInteger((String) value));
                }
            }

            boolean fileShow = field.isAnnotationPresent(FileShow.class);
            if(fileShow){

//                if(typeName.equals("Date")){
//                    field.set(bean, new Date());
//                }
                RequestforreferenceBo  bo = new RequestforreferenceBo();
                FileShow fs = field.getAnnotation(FileShow.class);
                bo.setFieldName( fs.fieldName());

                bo.setDatatype(fs.datatype());
                //数据类型 :===>如果数据类型为空 取实体类的数据类型
                if(StringUtils.isEmpty(fs.datatype())){
                    bo.setDatatype(typeName);
                 }
                 //首字母大写
                System.out.println("====>fieldgetName:"+field.getName());
               //bo.setTechnicalfieldName( Stringtool.upperFirstLatter2(field.getName()) );// 和请求的入参一个方法
                bo.setTechnicalfieldName( CamelNameUtils.underscoreName(field.getName()) );// 和请求的入参一个方法

               //
                bo.setSelectType(fs.selectType());
                bo.setFieldSize(fs.fieldSize());
                bo.setNotes(fs.notes());

                requestforreferenceBoList.add(bo);




            }


        }
       return bean;
    }




    private Map<String,Object> modfyMap(Map<String,Object> map){
        Map<String,Object> bakMap = new HashMap<String, Object>();
        if(map.size()==0){
            LOGGER.info("入参的结果集map为空！");
            return bakMap;
        }
        for(Map.Entry<String,Object> map0 : map.entrySet()) {
            String key = CamelNameUtils.underscoreName(map0.getKey());
            LOGGER.debug("驼峰转换前的key为：{}，转换后的key为：{}",map0.getKey(),key);
            bakMap.put(key,map0.getValue());
        }
        return bakMap;
    }




    /**
     *
     * @return
     */
    @Test
    public void   getExcel(){


        String fileName = this.getClass().getClassLoader().getResource("ruexcel/01.xlsx").getPath();//获取文件路径
        //String fileUtl = this.getClass().getResource("3ma.xlsx").getFile();
        File targetFile = new File(fileName);//copyFile(filename, inputStream);
        Excel2Bean e4j = new Excel4JavaImpl();
        e4j.createExcelBook(targetFile);
        Excel2BeanRowMapper<RequestforreferenceBo> rowMapper = new AssetDetailExcelBoRowMapperExtendDefault();
        //从excel模板中转化为excelBo
        List<RequestforreferenceBo> assetDetailExcelBos = e4j.toBeans("Sheet1", 1, Integer.MAX_VALUE, rowMapper);
//        LOGGER.info("assetDetailExcelBos==>"+assetDetailExcelBos);



        for(RequestforreferenceBo bo:assetDetailExcelBos){
//            String fildname= bo.getTechnicalfieldName();
//          String fildname2=   CamelNameUtils.camelName(fildname);
//            System.out.println("====>"+fildname+"=====>"+fildname2);
            tomobang(bo,new PmAssetMssback());

        }



    }
//	@FileShow(fieldName = "出保約定期限（月）",datatype = "CHAR",fieldSize = "8",selectType = "非必填",notes = "02应用类软件选填")
//private String zzCbrq;
    private <T> void tomobang(RequestforreferenceBo bo1,T bean) {



        Class<?> clz = new PmAssetMssback().getClass();
        //  Object obj = bean.getClass().newInstance();

        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
        String str11=    CamelNameUtils.underscoreName(field.getName());



         //   System.out.println("====>"+str11+"====>"+bo1.getTechnicalfieldName());
            if(str11.equals(   bo1.getTechnicalfieldName())) {
                Class<?> type = field.getType();
                String typeName = type.getSimpleName();
                System.out.println("====>field"+field+"==>==typeName:"+typeName+"===>type:"+type);


                String str = " @FileShow(fieldName = \"" +tostring1(bo1.getFieldName())+
                        "\",datatype = \"" +tostring1(bo1.getDatatype())+
                        "\",fieldSize = \"" +tostring1(bo1.getFieldSize())+
                        "\",selectType = \"" +tostring1(bo1.getSelectType())+
                        "\",notes = \"" +tostring1(bo1.getNotes())+
                        "\")\n" +
                        "    private  " + typeName + " " + field.getName() +";";
               System.out.println("类："+str);
                new TxtR().method31("PmAssetMssbacek",str);

            }
        }
    }
    private String tostring1(String str1){
        if(StringUtils.isEmpty(str1)){
            return str1;
        }
        String string1=       str1.replaceAll("\r|\n", "");
        return  string1.replaceAll(" ", "");

    }


    class AssetDetailExcelBoRowMapperExtendDefault extends DefaultExcel4JavaRowMapper<RequestforreferenceBo> {

        @Override
        protected RequestforreferenceBo createBean() {
            return new RequestforreferenceBo();
        }

        @Override
        protected RequestforreferenceBo postRow2Bean(RequestforreferenceBo bean) {
            return bean;
        }
    }





}


