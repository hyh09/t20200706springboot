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
import com.utltl.exceltool.mobansanm.MsgExcelBo;
import com.utltl.exceltool.mobansanm.RequestforreferenceBo;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PmAssetMssbackTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmAssetMssbackTest.class);


    @Test
    public void  Test1111() throws Exception {


        StringBuffer  buffer = new StringBuffer("");
        for(int i=0;i<100;i++){
            String  num=   "400000004050"+i;
            String id="10000010000000000000290"+i;
            String msg = "公司代码[" + "A001" + "]、卡片编码[" + num + "]对应的卡片为在途状态，所在工单的单据号为["+id+"]，不能用来发起卡实流程!";
            buffer.append(msg);

        }
        System.out.println("===>"+buffer);
        List<MsgExcelBo> msgExcelBos=  getMsgExcelBo(buffer.toString());
        new  ExportExcelyunUtils().write2File("Test",msgExcelBos,new MsgExcelBo());



    }


//
    //是否低效变更发起失败的原因是： js前台拼接的
    //公司代码[" + assetIamItem.getBukrs() + "]、卡片编码[" + assetIamItem.getAssetsCardCode() + "]对应的卡片为在途状态，不能用来发起卡实流程!

    private  List<MsgExcelBo>  getMsgExcelBo(String str){
         List<MsgExcelBo>  msgExcelBos = new ArrayList<>();
         if(StringUtils.isEmpty(str)){
             return  msgExcelBos;
         }
        String[] Str1Array = str.split("!");
       List<String> stringList=  Arrays.asList(Str1Array);
         for(String st1:stringList){
             MsgExcelBo  msgExcelBo = new MsgExcelBo();
             msgExcelBo.setBurk(subString(st1,"公司代码[","]、卡片编码"));
             msgExcelBo.setAsseCode(subString(st1,"卡片编码[","]对应的"));
           String str111=  subString(st1,"]对应的","卡实流程")+"卡实流程";
           System.out.println("=str111===>"+str111);
           msgExcelBo.setNotes(str111);
             msgExcelBos.add(msgExcelBo);
         }

        return  msgExcelBos;
    }


    @Test
    public  void Test09(){
        String  st1="公司代码[A001]、卡片编码[400000004050]对应的卡片为在途状态，不能用来发起卡实流程!";
     String burks=   subString(st1,"公司代码[","]、卡片编码");
     System.out.println("公司代码"+burks);
    }


    private String subString(String str, String strStart, String strEnd) {
        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);
        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            LOGGER.info("字符串 :----><---- 中不存在 " + strStart + ", 无法截取目标字符串");
            return "";
        }
        if (strEndIndex < 0) {
            LOGGER.info("字符串 :----><---- 中不存在 " + strStart + ", 无法截取目标字符串");
            return "";
        }
            /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;
    }





    public static String StringStartTrim(String stream, String trim) {
        // null或者空字符串的时候不处理
        if (stream == null || stream.length() == 0 || trim == null || trim.length() == 0) {
            return stream;
        }
        // 要删除的字符串结束位置
        int end;
        // 正规表达式
        String regPattern = "[" + trim + "]*+";
        Pattern pattern = Pattern.compile(regPattern, Pattern.CASE_INSENSITIVE);
        // 去掉原始字符串开头位置的指定字符
        Matcher matcher = pattern.matcher(stream);
        if (matcher.lookingAt()) {
            end = matcher.end();
            stream = stream.substring(end);
        }
        // 返回处理后的字符串
        return stream;
    }


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

                bo.setFieldSize(fs.fieldSize());
                if(StringUtils.isEmpty(fs.fieldSize()) ||fs.fieldSize().equals("null")){
                    bo.setFieldSize("");//长度
                }
                bo.setNotes(fs.notes());

                bo.setSelectType(fs.selectType());
                System.out.println("必填的项目："+fs.selectType());
                if(StringUtils.isEmpty(fs.selectType()) || fs.selectType().equals("null")){
                    bo.setSelectType("");
                }

                requestforreferenceBoList.add(bo);




            }


        }
       return bean;
    }




    public Map<String,Object> modfyMap(Map<String,Object> map){
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
          this.Rucan1test("ruexcel/01.xlsx", new PmAssetMssback());
    }





    public   <T> void Rucan1test(String path1,T bean){

        String fileName = this.getClass().getClassLoader().getResource(path1).getPath();//获取文件路径
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
            tomobang(bo,bean);

        }
    }
//	@FileShow(fieldName = "出保約定期限（月）",datatype = "CHAR",fieldSize = "8",selectType = "非必填",notes = "02应用类软件选填")
//private String zzCbrq;
    private <T> void tomobang(RequestforreferenceBo bo1,T bean) {



        Class<?> clz =bean.getClass();
       String fileName= clz.getSimpleName();
       System.out.println("文件的名字："+fileName);
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

                new TxtR().method31(fileName,str);

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


