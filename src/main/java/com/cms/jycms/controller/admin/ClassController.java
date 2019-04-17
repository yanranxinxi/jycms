package com.cms.jycms.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.cms.jycms.domain.ClassInfo;
import com.cms.jycms.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class ClassController {
    @Autowired
    private ClassInfoService service;

    @GetMapping("classSelectAll")
    public List<ClassInfo> selectAll()
    {
        List<ClassInfo> list= service.selectAll();
        return list;
    }
}
