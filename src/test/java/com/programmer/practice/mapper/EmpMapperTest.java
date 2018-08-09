package com.programmer.practice.mapper;

import com.programmer.practice.domain.EmpDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author : Growlithe
 * @Date : 2018/8/9 11:32
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTest {


    @Autowired
    private EmpMapper empMapper;

    @Test
    public void listAllEmp() {
        List<EmpDO> empDOList = empMapper.listAllEmp();
        Assert.assertNotNull(empDOList);
    }

}