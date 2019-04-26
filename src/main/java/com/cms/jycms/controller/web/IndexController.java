package com.cms.jycms.controller.web;

import com.cms.jycms.component.NavComponent;
import com.cms.jycms.domain.NewsInfo;
import com.cms.jycms.service.NewsInfoService;
import com.cms.jycms.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private NavComponent navComponent;

    @Autowired
    private NewsInfoService newsInfoService;

    @Autowired
    private SystemConfigService systemConfigService;

    @RequestMapping({"/", "index"})
    public String index(Model model) {
        String copyright = systemConfigService.select("copyright");
        String title = systemConfigService.select("title");
        String keyword = systemConfigService.select("keyword");
        String description = systemConfigService.select("description");

        Map<String, Object> map = new HashMap<>();
        map.put("offset", 0);
        map.put("pageSize", 3);
        map.put("classId", 4);
        List<NewsInfo> newsList = newsInfoService.selectAll(map);
        model.addAttribute("newsList", newsList);
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("copy", copyright);
        model.addAttribute("title", title);
        model.addAttribute("keyword", keyword);
        model.addAttribute("description", description);
        return "web/index";
    }
}
