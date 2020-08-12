import com.imooc.bigdata.hbase.api.HBaseUtil;
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







}
