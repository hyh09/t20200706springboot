package com.demo.dao.daointerface;

import com.demo.dao.entity.Deparment;
import com.demo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2020/7/7.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Deparment,Long>{



}
