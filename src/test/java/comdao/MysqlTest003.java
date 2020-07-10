//package comdao;
//
////import com.demo.dao.config.JpaConfiguration;
//import com.demo.dao.entity.Deparment;
//import com.demo.dao.entity.Role;
//import com.demo.dao.entity.User;
//import com.sun.istack.internal.logging.Logger;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by dell on 2020/7/7.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@TestPropertySource(locations = {"classpath:application.yml"})
//@SpringBootTest
////@ContextConfiguration(classes = {JpaConfiguration.class})
//public class MysqlTest003 {
//
//    private  static  Logger logger = Logger.getLogger(MysqlTest003.class);
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//
//    @Test
//    public  void Test1(){
//        Deparment  deparment = new Deparment();
//        deparment.setName("孙悟空");
//        departmentRepository.save(deparment);
//    }
//
//
//
//
//
//
//
//
//}
