package com.cms.jycms.component;

import com.cms.jycms.domain.ClassInfo;
import com.cms.jycms.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NavComponent {
    @Autowired
    private ClassInfoService classInfoService;
    private List<ClassInfo> navList;

    public List<ClassInfo> getNavList() {
        return classInfoService.getNav();
    }
}
