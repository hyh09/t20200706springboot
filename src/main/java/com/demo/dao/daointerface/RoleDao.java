package com.demo.dao.daointerface;

import com.demo.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dell on 2020/7/7.
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
}
