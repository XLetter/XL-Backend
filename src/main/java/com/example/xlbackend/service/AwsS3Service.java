package com.example.xlbackend.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@NoArgsConstructor
public class AwsS3Service {
    private AmazonS3 s3Client;
    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @PostConstruct
    public void setS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(this.region)
                .build();
    }

    public String upload(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String contentType = file.getContentType();
            String originalFileExtension;
            String awsContentType;

            //확장자명 없을 경우
            if (ObjectUtils.isEmpty(contentType)) {
                return null;
            } else {
                if (contentType.contains("image/jpg")) {
                    originalFileExtension = ".jpg";
                    awsContentType = "image/jpg";
                } else if (contentType.contains("image/png")) {
                    originalFileExtension = ".png";
                    awsContentType = "image/png";
                } else if(contentType.contains("image/jpeg")){
                    originalFileExtension = ".jpeg";
                    awsContentType = "imgae/jpeg";
                }
                // 다른 파일 명이면 아무 일 하지 않는다
                else {
                    return null;
                }
            }
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(awsContentType);
            SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
            String fileName = file.getOriginalFilename();
            fileName = fileName.substring(0, fileName.lastIndexOf(".")) + "-" + date.format(new Date()) + originalFileExtension;

            s3Client.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), metadata));

            return s3Client.getUrl(bucket, fileName).toString();
        }
        else return null;
    }
}
