package com.zk;

import com.sinovate.ngrms.gcbscsvr.das.support.Utils.BeanMapUtils;
import com.sinovate.ngrms.gcbscsvr.das.support.Utils.CamelNameUtils;
import com.sinovate.ngrms.gcbscsvr.mdl.db.gcdm.eother.PmAssetMssback;
import com.utltl.Stringtool;
import com.utltl.TxtR;
import com.utltl.exceltool.ExportExcelyunUtils;
import com.utltl.exceltool.beansvc.JsonDateValueProcessor;
import com.utltl.exceltool.excel4j.binding.Excel2Bean;
import com.utltl.exceltool.excel4j.binding.Excel2BeanRowMapper;
import com.utltl.exceltool.excel4j.binding.impl.DefaultExcel4JavaRowMapper;
import com.utltl.exceltool.excel4j.binding.impl.Excel4JavaImpl;
import com.utltl.exceltool.mobansanm.AssetCardBo;
import com.utltl.exceltool.mobansanm.RequestforreferenceBo;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by dell on 2020/8/22.
 */
public class AssetCardBoTest {

    private  void init(  AssetCardBo pmAssetMssback){
        pmAssetMssback.setCreateDate(new Date());//初始化创建时间
        pmAssetMssback.setModifyDate(new Date());
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
        AssetCardBo pmAssetMssback=   new PmAssetMssbackTest().getInstance(new AssetCardBo(),requestforreferenceBoList); //填充这个
        System.out.println("=====>"+pmAssetMssback);
        init(pmAssetMssback);


        List<PmAssetMssback> voList =new ArrayList<>();
//       new  ExportExcelyunUtils().write2File("",voList,new PmAssetMssback());
        Map<String, Object> stringObjectMap = new HashMap<String, Object>();
        stringObjectMap = new PmAssetMssbackTest().modfyMap(BeanMapUtils.getValue(pmAssetMssback));
        dateMapList.add(stringObjectMap);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        jsonConfig.registerJsonValueProcessor(BigInteger.class, new JsonDateValueProcessor());
        mapJson = JSONArray.fromObject(dateMapList, jsonConfig).toString();
        System.out.println("mapJson:"+mapJson);


        new ExportExcelyunUtils().write2File("资产卡片信息同步接口【请求参数列表】",requestforreferenceBoList,new RequestforreferenceBo());
        new TxtR().method3("资产卡片信息同步接口",new Stringtool().formatbyFastJson(mapJson));



    }








    /**
     *
     * @return
     */
    @Test
    public void   getExcel(){

           new  PmAssetMssbackTest().Rucan1test("ruexcel/02.xlsx",new AssetCardBo());



    }


}
