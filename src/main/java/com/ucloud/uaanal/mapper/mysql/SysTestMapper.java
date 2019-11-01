package com.ucloud.uaanal.mapper.mysql;

import com.ucloud.uaanal.entity.SysTest;


public interface SysTestMapper {

    void save(SysTest test);

    SysTest findId(Long id);
}
