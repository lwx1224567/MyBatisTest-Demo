package com.example.test;

import com.example.entity.StorageRecord;
import com.example.service.StorageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        StorageService service = context.getBean(StorageService.class);

        // 查询苹果记录
        service.findRecords("苹果", "供货商A", true);
        // 删除 ID 为 5 的记录
        service.deleteRecord(5);

    }
}
