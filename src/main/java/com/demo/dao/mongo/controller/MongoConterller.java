package com.demo.dao.mongo.controller;

import java.util.Date;
import java.util.List;

import com.demo.dao.entity.mondoentity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.demo.dao.serviceImp.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by dell on 2020/7/13.
 */
@RestController
public class MongoConterller {

    private static final Logger logger = LoggerFactory.getLogger(MongoDbService.class);

    @Autowired
    private MongoDbService mongoDbService;


    //localhost:8089/mongo/save
    @GetMapping("/mongo/save")
    public String saveObj( ) {
        Book book =new  Book();//[]
        logger.info("====user===："+book);
        //if(book==null){
            book.setId("1");
            book.setName("孙悟空");
            book.setCreateTime(new Date());
       // }
        logger.info("===========================");
        return mongoDbService.saveObj(book);
    }

    @GetMapping("/mongo/findAll")
    public List<Book> findAll() {
        return mongoDbService.findAll();
    }

    @GetMapping("/mongo/findOne")
    public Book findOne(@RequestParam String id) {
        return mongoDbService.getBookById(id);
    }

    @GetMapping("/mongo/findOneByName")
    public Book findOneByName(@RequestParam String name) {
        return mongoDbService.getBookByName(name);
    }

    @PostMapping("/mongo/update")
    public String update(@RequestBody Book book) {
        return mongoDbService.updateBook(book);
    }

    @PostMapping("/mongo/delOne")
    public String delOne(@RequestBody Book book) {
        return mongoDbService.deleteBook(book);
    }

    @GetMapping("/mongo/delById")
    public String delById(@RequestParam String id) {
        return mongoDbService.deleteBookById(id);
    }

    @GetMapping("/mongo/findlikes")
    public List<Book> findByLikes(@RequestParam String search) {
        return mongoDbService.findByLikes(search);
    }

}
