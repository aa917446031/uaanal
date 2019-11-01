package com.ucloud.uaanal.mapper.mysql;

import com.ucloud.common.utils.web.domain.Menu;

import java.util.List;

public interface MenuMapper {
  List<Menu> selectMenuList(Integer role_id);
}
