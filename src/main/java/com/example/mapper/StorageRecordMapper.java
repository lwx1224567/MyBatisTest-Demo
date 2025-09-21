package com.example.mapper;

import com.example.entity.StorageRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageRecordMapper {
        List<StorageRecord> queryByCondition(
                @Param("goodsName") String goodsName,
                @Param("supplierName") String supplierName,
                @Param("isPaid") Boolean isPaid
        );

}
