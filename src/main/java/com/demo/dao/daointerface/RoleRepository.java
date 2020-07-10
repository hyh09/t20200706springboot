package com.demo.dao.daointerface;

import com.demo.dao.entity.Deparment;
import com.demo.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2020/7/7.
 */
@Repository
//@Service
public interface RoleRepository extends JpaRepository<Role,Long>{



}
