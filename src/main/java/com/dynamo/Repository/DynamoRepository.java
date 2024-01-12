package com.dynamo.Repository;

import com.dynamo.Model.User;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface DynamoRepository extends CrudRepository<User,String> {
}
