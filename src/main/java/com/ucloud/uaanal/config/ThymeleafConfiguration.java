package com.ucloud.uaanal.config;

import com.ucloud.common.utils.web.domain.Menu;
import com.ucloud.uaanal.service.IMenuService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ThymeleafConfiguration {

    @Resource
    private Environment env;

    @Resource
    private IMenuService iMenuService;

    @Resource
    private WebApplicationContext context;

    @Resource
    public void configThymeleafEnvs(ThymeleafViewResolver viewResolver) {
        // TODO 注意这里不能使用 @Value 的方式来进行注入数据，因为 @value加载
        // TODO 在 @Resource 之后，所以这里使用 Environment 进行获取参数
        // 参考 https://blog.csdn.net/bear_lam/article/details/80278590
        //获取左边菜单栏
        List<Menu> appMenus = iMenuService.selectMenuList("app");
        Menu menu = new Menu();
        menu.setMenuName("实时概况");
        menu.setParentName(null);
        menu.setParentId(Long.valueOf(0));
        menu.setOrderNum("1");
        menu.setUrl("/app/realInfo");
        menu.setMenuType("C");
        menu.setIcon("fa fa-home");
        menu.setChildren(new ArrayList());
        appMenus.add(menu);

        List<Menu> webMenus = iMenuService.selectMenuList("web");
        List<Map> list = new ArrayList<>();
        Map appCenter = new HashMap();
        Map report = new HashMap();
        Map manage = new HashMap();
        appCenter.put("type", "appCenter");
        appCenter.put("name", "应用中心");
        appCenter.put("url", "/index");
        report.put("type", "report");
        report.put("name", "报表");
        report.put("url", "/index/report?type=app");
        manage.put("type", "manage");
        manage.put("name", "管理");
        manage.put("url", "/app/manage");
        list.add(appCenter);
        list.add(report);
        list.add(manage);

        if (viewResolver != null) {
            Map<String, Object> vars = new HashMap<>();
            vars.put("copyrightYear", env.getProperty("project.copyrightYear"));
            vars.put("companyName", env.getProperty("project.company.name"));
            vars.put("version", env.getProperty("project.version"));
            vars.put("title", env.getProperty("project.home.title"));
            vars.put("language", env.getProperty("locale.language"));
            vars.put("nickname", "用户昵称");
            vars.put("list", list);
            vars.put("appMenus", appMenus);
            vars.put("webMenus", webMenus);
            viewResolver.setStaticVariables(vars);
        }

        /*List<ModelConfig> models = iModelService.getAllModel();
        try {
            for (int i = 0; i < models.size(); i++) {
                RequestMappingUtil.addRequestMapping(models.get(i).getPyModelName(), context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
