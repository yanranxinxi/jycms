package com.cms.jycms.controller.web;

import com.cms.jycms.component.NavComponent;
import com.cms.jycms.domain.NewsInfo;
import com.cms.jycms.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExclusiveController {
    @Autowired
    private NavComponent navComponent;
    @Autowired
    private NewsInfoService newsInfoService;

    @RequestMapping("exclusive")
    public String exclusive(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        int pageSize = 10;
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("classId", 23);
        List<NewsInfo> newsList = newsInfoService.selectAll(map);
        int total = newsInfoService.selectCount(map);
        int totalPages = total / pageSize;
        if ((total % pageSize) > 0) {
            totalPages++;
        }
        model.addAttribute("newsList", newsList);
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageIndex", pageIndex);
        return "web/exclusive";
    }
    @RequestMapping("/exclusive/parenting")
    public String parenting(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model)
    {
        int pageSize = 10;
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("classId", 24);
        List<NewsInfo> newsList = newsInfoService.selectAll(map);
        int total = newsInfoService.selectCount(map);
        int totalPages = total / pageSize;
        if ((total % pageSize) > 0) {
            totalPages++;
        }
        model.addAttribute("newsList", newsList);
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageIndex", pageIndex);
        return "web/exclusive";
    }
    @RequestMapping("/exclusive/goodArticle")
    public String goodArticle(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model)
    {
        int pageSize = 10;
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("classId", 25);
        List<NewsInfo> newsList = newsInfoService.selectAll(map);
        int total = newsInfoService.selectCount(map);
        int totalPages = total / pageSize;
        if ((total % pageSize) > 0) {
            totalPages++;
        }
        model.addAttribute("newsList", newsList);
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageIndex", pageIndex);
        return "web/exclusive";
    }
}
