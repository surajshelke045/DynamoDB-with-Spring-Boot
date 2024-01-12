package com.dynamo.ServiceImpl;

import com.dynamo.Exception.ResourceNotFoundException;
import com.dynamo.Model.User;
import com.dynamo.Repository.DynamoRepository;
import com.dynamo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


	private final DynamoRepository dynamoRepository;

	@Autowired
	public UserServiceImpl(DynamoRepository dynamoRepository) {
		this.dynamoRepository = dynamoRepository;
	}
    @Override
    public User SaveUser(User user) {
        return dynamoRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return dynamoRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not Found with Id : "+userId));
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) dynamoRepository.findAll();
    }

    @Override
    public User updateUser(User user, String userId) {
    	User user1=dynamoRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not Found with Id : "+userId));
    	user1.setName(user.getName());
    	user1.setEmail(user.getEmail());
    	user1.setPhone(user.getPhone());
    	user1.setAddress(user.getAddress());
        return dynamoRepository.save(user1);
    }

    @Override
    public User deleteUser(String userId) {
        return dynamoRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not Found with Id : "+userId));
    }
}
