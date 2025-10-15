package com.example.service;

import com.example.entity.StorageRecord;
import com.example.mapper.StorageRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StorageService {

    @Autowired
    private StorageRecordMapper storageRecordMapper;

    // 查询记录
    public List<StorageRecord> findRecords(String goods, String supplier, Boolean isPaid) {
        List<StorageRecord> records = storageRecordMapper.queryByCondition(goods, supplier, isPaid);
        System.out.println("[AOP日志] 用户执行了：findRecords 操作");
        System.out.println("查询到的入库记录：");
        for (StorageRecord r : records) {
            System.out.println(r);
        }
        return records;
    }

    // 添加记录
    public void addRecord(StorageRecord record) {
        System.out.println("[AOP日志] 用户执行了：addRecord 操作");
        System.out.println("执行添加入库记录操作：" + record);
        storageRecordMapper.insert(record); // 假设你有 insert 方法
    }

    // 删除记录
    public void deleteRecord(Integer id) {
        System.out.println("[AOP日志] 用户执行了：deleteRecord 操作");
        System.out.println("执行删除入库记录操作，ID=" + id);
        storageRecordMapper.delete(id); // 假设你有 delete 方法
    }
}
