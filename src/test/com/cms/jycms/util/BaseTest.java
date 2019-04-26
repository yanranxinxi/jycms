package com.cms.jycms.util;

import com.alibaba.fastjson.JSON;
import com.cms.jycms.dto.ImageNameDTO;
import org.junit.Test;

import java.util.List;

public class BaseTest {

    @Test
    public void test() {

        List<ImageNameDTO> list = JSON.parseArray("[{\"name\":\"Koala\",\"url\":\"/jycms/upload/2019/4/27/201904270209596520.jpg\"},{\"name\":\"Lighthouse\",\"url\":\"/jycms/upload/2019/4/27/201904270209597631.jpg\"}]", ImageNameDTO.class);
        System.out.println(list);

    }
}
