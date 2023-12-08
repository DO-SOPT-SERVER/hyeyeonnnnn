package com.server.sopt.seminar.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.SystemPropertyCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;



@Configuration
public class AWSConfig {
    private static final String AWS_ACCESS_KEY_ID = "aws.accessKeyId";
    private static final String AWS_SECRET_ACCESS_KEY = "aws.secretAccessKey";

    private final String accessKey;
    private final String secretKey;
    private final String regionString;

    public AWSConfig(@Value("${aws-property.access-key}") final String accessKey,
                     @Value("${aws-property.secret-key}") final String secretKey,
                     @Value("${aws-property.aws-region}") final String regionString) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.regionString = regionString;
    }


    //자격 증명을 얻는 방법
    @Bean
    public SystemPropertyCredentialsProvider systemPropertyCredentialsProvider() {
        System.setProperty(AWS_ACCESS_KEY_ID, accessKey);
        System.setProperty(AWS_SECRET_ACCESS_KEY, secretKey);
        return SystemPropertyCredentialsProvider.create();
    }

    @Bean
    public Region getRegion() {
        return Region.of(regionString);
    }

    @Bean
    S3Client getS3Client() {
        return S3Client.builder()
                .region(getRegion())
                .credentialsProvider(systemPropertyCredentialsProvider())
                .build();
    }
}