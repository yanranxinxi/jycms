package com.cms.jycms.controller.admin;

import com.cms.jycms.common.R;
import com.cms.jycms.domain.SystemConfig;
import com.cms.jycms.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/systemConfig")
public class SystemConfigController {
    @Autowired
    private SystemConfigService service;

    @PostMapping("insert")
    public R insert(SystemConfig model) {
        int result = service.insert(model);
        if (result > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("delete")
    public R delete(String key) {
        int result = service.delete(key);
        if (result > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("update")
    public R update(SystemConfig model) {
        int result = service.update(model);
        if (result > 0) {
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("select")
    public R select(String key) {
        String value = service.select(key);
        return R.ok().put("data", value);
    }
}
