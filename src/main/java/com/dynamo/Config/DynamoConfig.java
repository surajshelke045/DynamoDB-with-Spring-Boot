package com.dynamo.Config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoConfig {

    @Value("${aws.dynamo.endpoint}")
    String enpoint;
    
    @Value("${aws.accessKey}")
    String accessKey;
    
    @Value("${aws.secretKey}")
    String secretKey;
    
    @Value("${aws.region}")
    String region;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(enpoint,region))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(accessKey,secretKey)))
                .build();
    }
}
