import com.imooc.bigdata.hbase.api.HBaseUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

/**
 * Created by dell on 2020/8/10.
 */
public class HBaseUtislTest {


    /**
     * 创建表的操作
     */
    @Test
    public  void createTableTest(){
        HBaseUtil.createTable("FileTable",new String[]{"fileInfo","saveInfo"});
    }

    private    String tableNmae="FileTable";


    /**
     * 添加数据
     */
    @Test
    public  void addFileDetails(){

        /**
         * 插入数据
         * @param tableName 表名
         * @param rowkey  唯一标识
         * @param cfName  列族名
         * @param qualifer  列标识
         * @param data  数据
         * @return  是否插入成功
         *         public static boolean putRow(String tableName,String rowkey,String cfName,String qualifer,String data)

         */
        HBaseUtil.putRow(tableNmae,"rowkey2","fileInfo","name","猪八戒");
        HBaseUtil.putRow(tableNmae,"rowkey1","fileInfo","name","孙悟空");
        HBaseUtil.putRow(tableNmae,"rowkey1","fileInfo","age","500");



    }



    /**
     * 查询单条数据
     * @param tableName
     * @param rowkey
     * @return
     */
    @Test
    public void  getRow(){
        Result  result = HBaseUtil.getRow(tableNmae,"rowkey1");
      //  Result  result1 = HBaseUtil.getRow(tableNmae,"rowkey2");
        System.out.println("rowkey1:"+result);
        if(result !=null){
            System.out.println("rowkey1"+ Bytes.toString(result.getRow()));
            //获取里面的数据
            byte[]  bytes= result.getValue(Bytes.toBytes("fileInfo"),Bytes.toBytes("name"));
            System.out.println(Bytes.toString(bytes));
            byte[]  bytes1= result.getValue(Bytes.toBytes("fileInfo"),Bytes.toBytes("age"));
            System.out.println(Bytes.toString(bytes1));
        }



    }







}
