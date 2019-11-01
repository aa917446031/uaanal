package com.ucloud.uaanal.service;

import com.ucloud.common.utils.web.domain.Menu;

import java.util.List;

public interface IMenuService {
  List<Menu> selectMenuList(String type);
}
