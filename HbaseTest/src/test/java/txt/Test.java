package txt;

import com.imooc.txtutl.CollectionUtil;
import com.imooc.txtutl.TxtR;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2020/8/11.
 */
public class Test {

    private  String path ="E:\\workhome\\Test\\t20200706\\HbaseTest\\src\\main\\resources\\66.log";

    @org.junit.Test
    public  void Test(){
        //46
     String str1="REP_STAT_EM_ORDER_STRONG,REP_STAT_IAM_ASSET_MU,STAT_ASSET_COUNT,STAT_IAM_ASSET_COUNT,REP_STAT_UNCONFIRMED_ASSET,REP_STAT_IAM_ASSET,REP_STAT_AUTO_ARTI_IAM,DTT_ZGLIST_REPORT,DTT_ADDNUM_SYNC_REPORT,DTT_CARD_ENTITY_REPORT,DTT_ZGLIST_DAYSTAT,DTT_ZGLIST_STATUS,DTTWEEK_ZGLIST_REPORT,DTTWEEK_CARD_ENTITY_REPORT,DTTWEEK_ORDER_COMPLETE_RATE,DTT_OPERATION_SITUATION,DTT_DEAL_NETPROJECT,DTT_ZGCOMP_REPORT,DTT_ZGCOMPLE_TIME_REPORT,DTT_PROJECT_RESOURCE_SIT,STT_ASSETDETAIL_CHECK,STT_CARDENTITY_CHECK,STT_PROJECT_CHECK,REP_STAT_EM_ORDER_WEAK,REP_STAT_IAM_ASSET_MU_ZJ";
        String[] split = str1.split(",");
        System.out.println("===>"+split);
        System.out.println("===>"+ Arrays.toString(split));
        List<String> list46 = Arrays.asList(split);//原来的不含总部的

        List<String> list = TxtR.readTxtFile(path);//本次需要添加的
        System.out.println("=本次需要含总部的==>"+list);
      List<String>  sno46 =  CollectionUtil.getDifferenceSet(list46,list);
        System.out.println("=不含总部的==>"+sno46);

        StringBuffer  stringBuffer  = new StringBuffer("");
        for(int i=0;i<sno46.size();i++){
            stringBuffer.append(","+sno46.get(i));
        }
        System.out.println("=最后结果不含总部的==>"+stringBuffer.toString());


        //REP_STAT_EM_ORDER_STRONG, REP_STAT_AUTO_ARTI_IAM, DTT_ZGLIST_REPORT, DTT_ADDNUM_SYNC_REPORT, DTT_CARD_ENTITY_REPORT, DTT_ZGLIST_DAYSTAT, DTT_ZGLIST_STATUS, DTTWEEK_ZGLIST_REPORT, DTTWEEK_CARD_ENTITY_REPORT, DTTWEEK_ORDER_COMPLETE_RATE, DTT_OPERATION_SITUATION, DTT_DEAL_NETPROJECT, DTT_ZGCOMP_REPORT, DTT_ZGCOMPLE_TIME_REPORT, DTT_PROJECT_RESOURCE_SIT, STT_ASSETDETAIL_CHECK, STT_CARDENTITY_CHECK, STT_PROJECT_CHECK, REP_STAT_EM_ORDER_WEAK, REP_STAT_IAM_ASSET_MU_ZJ]





    }

    /**
     * 交集
     */
    @org.junit.Test
    public  void Test11(){
        //46
       String str1 ="REP_STAT_IAM_ASSET_MU,RM_ASSET_IAM_REPORT,RM_ASSET_COUNT,REP_STAT_ASSET_DJZC,REP_STAT_RJZC_ASSET,REP_STAT_ASSET_2G3G,REP_DETAIL_ASSET_IAM_PUBLIC,STAT_ASSETCARD_BASESTATION_REL,REP_STAT_ASSET_MATERIAL,REP_STAT_ASSET_MATERIAL_SUB";
        String[] split = str1.split(",");
        System.out.println("===>"+split);
        System.out.println("===>"+ Arrays.toString(split));
        List<String> list46 = Arrays.asList(split);//原来的不含总部的

        List<String> list = TxtR.readTxtFile(path);//本次需要添加的
        System.out.println("=本次需要含总部的==>"+list);
        List<String>  sno46 =  CollectionUtil.getUnionSet(list46,list);//两个集合的并集
        System.out.println("=两个集合的并集==>"+sno46);

        StringBuffer  stringBuffer  = new StringBuffer("");
        for(int i=0;i<sno46.size();i++){
            stringBuffer.append(","+sno46.get(i));
        }
        System.out.println("=两个集合的并集==>"+stringBuffer.toString());







    }
}
