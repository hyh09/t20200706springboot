package com.demo.dao.daointerface.neo4jsvc;

import com.demo.dao.entity.neo4jentity.base.UserNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dell on 2020/7/16.
 */
@Repository(value = "UserNeo4jRepository")
public interface UserRepository extends Neo4jRepository<UserNode,Long> {



}
