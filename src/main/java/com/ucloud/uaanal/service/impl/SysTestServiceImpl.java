package com.ucloud.uaanal.service.impl;

import com.ucloud.uaanal.entity.SysTest;
import com.ucloud.uaanal.mapper.mysql.SysTestMapper;
import com.ucloud.uaanal.service.SysTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SysTestServiceImpl implements SysTestService {

    @Autowired
    SysTestMapper sysTestMapper;

    @Override
    public void save(SysTest test) {
        sysTestMapper.save(test);
    }

    @Override
    public List<SysTest> find(SysTest test) {
        return null;
    }

    @Override
    public SysTest findId(Long id) {
        return sysTestMapper.findId(id);
    }
}
