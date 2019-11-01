package com.ucloud.uaanal.service.impl;

import com.ucloud.common.utils.web.TreeUtils;
import com.ucloud.common.utils.web.domain.Menu;
import com.ucloud.uaanal.mapper.mysql.MenuMapper;
import com.ucloud.uaanal.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {

  @Autowired
  private MenuMapper menuMapper;
  /**
   * 获取菜单信息
   *
   * @return
   */
  @Override
  public List<Menu> selectMenuList(String type) {
    List<Menu> menus = new ArrayList<>();
    if ("app".equals(type)) {
      menus = menuMapper.selectMenuList(2);
    } else if ("web".equals(type)) {
      menus = menuMapper.selectMenuList(100);
    }
    return TreeUtils.getChildPerms(menus, 0);
  }
}
