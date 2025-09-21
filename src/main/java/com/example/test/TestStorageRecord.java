package com.example.test;
import com.example.entity.StorageRecord;
import com.example.mapper.StorageRecordMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream; import java.util.List;
public class TestStorageRecord {
        public static void main(String[] args) throws IOException {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();

            StorageRecordMapper mapper = session.getMapper(StorageRecordMapper.class);

            // 测试多条件查询
            List<StorageRecord> list = mapper.queryByCondition("苹果", "供货商A", true);

            for (StorageRecord sr : list) {
                System.out.println(
                        sr.getStorageId() + " | " +
                                sr.getGoodsName() + " | " +
                                sr.getSupplier().getSupplierName() + " | " +
                                sr.getSupplier().getContactName() + " | " +
                                sr.getSupplier().getPhone() + " | " +
                                sr.getTotalAmount() + " | " +
                                (sr.getIsPaid() ? "已付款" : "未付款")
                );
            }
            session.close();
        }
    }

