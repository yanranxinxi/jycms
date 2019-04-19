package com.cms.jycms.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.cms.jycms.common.R;
import com.cms.jycms.domain.ClassInfo;
import com.cms.jycms.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api/class")
public class ClassController {
    @Autowired
    private ClassInfoService service;

    @GetMapping("selectAll")
    public List<ClassInfo> selectAll() {
        List<ClassInfo> list = service.selectAll();
        return list;
    }

    @PostMapping("insert")
    public R insert(ClassInfo model) {
        int i = service.insert(model);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("update")
    public R update(ClassInfo model) {
        int i = service.update(model);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("delete")
    public R delete(int id) {
        int i = service.delete(id);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }
}
