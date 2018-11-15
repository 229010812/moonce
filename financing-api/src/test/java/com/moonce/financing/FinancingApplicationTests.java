package com.moonce.financing;

import com.moonce.financing.entity.Record;
import com.moonce.financing.repository.RecordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinancingApplicationTests {
    @Autowired
    private RecordRepository recordRepository;

    @Test
    public void contextLoads() {
        Record record1 = new Record();
        Example<Record> e = Example.of(record1);
        Sort s = new Sort(Sort.Direction.DESC,"id");
        List<Record> all = recordRepository.findAll(e,s);
        for (Record record : all) {
            System.out.println(record.toString());
        }

    }

}
