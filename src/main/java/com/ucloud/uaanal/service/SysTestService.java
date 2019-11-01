package com.ucloud.uaanal.service;

import com.ucloud.uaanal.entity.SysTest;

import java.util.List;

public interface SysTestService {

    void save(SysTest test);

    List<SysTest> find(SysTest test);

    SysTest findId(Long id);
}
