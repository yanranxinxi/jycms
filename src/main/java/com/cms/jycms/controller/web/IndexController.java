package com.cms.jycms.controller.web;

import com.cms.jycms.component.NavComponent;
import com.cms.jycms.component.PubComponent;
import com.cms.jycms.domain.ClassInfo;
import com.cms.jycms.domain.LeaveMessage;
import com.cms.jycms.domain.NewsInfo;
import com.cms.jycms.dto.ViewClassListDTO;
import com.cms.jycms.dto.WebSiteBaseInfoDTO;
import com.cms.jycms.service.ClassInfoService;
import com.cms.jycms.service.LeaveMessageService;
import com.cms.jycms.service.NewsInfoService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
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
    private ClassInfoService classInfoService;

    @Autowired
    private PubComponent pubComponent;

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @Autowired
    private LeaveMessageService leaveMessageService;

    @RequestMapping({"/", "index"})
    public String index(Model model) {
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        //获取推荐产品
        Map<String, Object> map = new HashMap<>();
        map.put("limit", 9);
        map.put("classId", 30);
        map.put("recommend", "1");
        List<NewsInfo> productRecommendList = newsInfoService.selectByClassId(map);
        //产品分类
        List<ClassInfo> productList = classInfoService.getNavByParentId(30);
        //单类列表
        //合作客户
        List<NewsInfo> cooperationList = pubComponent.getArtList(40, 0, 10);
        //客户见证
        List<NewsInfo> customList = pubComponent.getArtList(41, 0, 4);
        //企业头条
        List<NewsInfo> topNewsList = pubComponent.getArtList(42, 0, 4);
        //公司动态
        List<NewsInfo> companyDynamicsList = pubComponent.getArtList(43, 0, 4);
        //技术答疑
        List<NewsInfo> questionList = pubComponent.getArtList(44, 0, 3);
        //工厂环境
        List<NewsInfo> factoryList = pubComponent.getArtList(46, 0, 10);
        //荣誉资质
        List<NewsInfo> honorList = pubComponent.getArtList(47, 0, 10);
        //单条内容
        //关于我们
        NewsInfo aboutusContent = newsInfoService.selectByPrimaryKey("55");

        model.addAttribute("productList", productList);
        model.addAttribute("productRecommendList", productRecommendList);
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("cooperationList", cooperationList);
        model.addAttribute("customList", customList);
        model.addAttribute("topNewsList", topNewsList);
        model.addAttribute("companyDynamicsList", companyDynamicsList);
        model.addAttribute("questionList", questionList);
        model.addAttribute("aboutusContent", aboutusContent);
        model.addAttribute("factoryList", factoryList);
        model.addAttribute("honorList", honorList);
        return "web/index";
    }

    @RequestMapping({"/corporateImage"})
    public String classShow(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(62, pageIndex, 12, 31, 5, 0, null);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        model.addAttribute("path","corporateImage");
        return "web/staticShow";
    }

    @RequestMapping({"/honor"})
    public String honor(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(73, pageIndex, 12, 31, 5, 0, null);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        model.addAttribute("path","honor");
        return "web/staticShow";
    }

    @RequestMapping({"/productCenter"})
    public String productCenter(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(30, pageIndex, 12, 31, 5, 0, null);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        return "web/class";
    }

    @RequestMapping({"/productCenterSearch"})
    public String productCenterSearch(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, @RequestParam(value = "title", defaultValue = "") String title, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(-1, pageIndex, 12, 31, 5, 0, 1, title);

        model.addAttribute("searchContent", title);
        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        return "web/search";
    }

    @RequestMapping({"/productCenter/{id}"})
    public String productCenter(@PathVariable("id") int id, @RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(id, pageIndex, 10, 31, 5, 0, null);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        return "web/class";
    }

    @RequestMapping({"/corporateImage/detail/{id}"})
    public String staticDetail(@PathVariable("id") String id, Model model) {
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        NewsInfo productDetail = newsInfoService.selectByPrimaryKey(id);
        List<NewsInfo> upDownList = newsInfoService.selectUpDown(productDetail);

        for (NewsInfo item : upDownList) {
            if (item.getId() < productDetail.getId()) {
                model.addAttribute("up", item);
            } else {
                model.addAttribute("down", item);
            }
        }
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("art", productDetail);
        return "web/staticDetail";
    }
    @RequestMapping({"/honor/detail/{id}"})
    public String honorStaticDetail(@PathVariable("id") String id, Model model) {
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        NewsInfo productDetail = newsInfoService.selectByPrimaryKey(id);
        List<NewsInfo> upDownList = newsInfoService.selectUpDown(productDetail);

        for (NewsInfo item : upDownList) {
            if (item.getId() < productDetail.getId()) {
                model.addAttribute("up", item);
            } else {
                model.addAttribute("down", item);
            }
        }
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("art", productDetail);
        return "web/staticDetail";
    }

    @RequestMapping("/productCenter/detail/{id}")
    public String productDetail(@PathVariable("id") String id, Model model) {
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        NewsInfo productDetail = newsInfoService.selectByPrimaryKey(id);
        List<NewsInfo> upDownList = newsInfoService.selectUpDown(productDetail);

        for (NewsInfo item : upDownList) {
            if (item.getId() < productDetail.getId()) {
                model.addAttribute("up", item);
            } else {
                model.addAttribute("down", item);
            }
        }
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("art", productDetail);
        return "web/staticDetail";
    }

    @RequestMapping({"/news"})
    public String news(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(31, pageIndex, 10, 31, 5, 0, null);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        return "web/newsClass";
    }

    @RequestMapping({"/question"})
    public String question(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(44, pageIndex, 10, 31, 5, 0, null);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        return "web/newsClass";
    }

    @RequestMapping({"/news/{id}"})
    public String news(@PathVariable String id, Model model) {
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        NewsInfo aboutusContent = newsInfoService.selectByPrimaryKey(id);
        List<NewsInfo> upDownList = newsInfoService.selectUpDown(aboutusContent);

        for (NewsInfo item : upDownList) {
            if (item.getId() < aboutusContent.getId()) {
                model.addAttribute("up", item);
            } else {
                model.addAttribute("down", item);
            }
        }
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("art", aboutusContent);
        return "web/newsDetail";
    }

    @RequestMapping({"/aboutUs"})
    public String artShow(Model model) {
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        NewsInfo aboutusContent = newsInfoService.selectByPrimaryKey("89");
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("art", aboutusContent);
        return "web/single";
    }

    @RequestMapping({"/contactUs"})
    public String contactUs(Model model) {
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        NewsInfo aboutusContent = newsInfoService.selectByPrimaryKey("90");
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("art", aboutusContent);
        return "web/contactUs";
    }

    @RequestMapping("/leaveMessage")
    public String leaveMessage(Model model) {
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        return "web/leaveMessage";
    }

    @PostMapping("/leaveMsg")
    public String leaveMsg(HttpServletRequest httpServletRequest, String customName, String telNo, String msg, String code, Model model) {
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        if (!captchaId.equals(code)) {
            model.addAttribute("info", "验证码不正确请重新填写");
        } else {
            LeaveMessage leaveMessage = new LeaveMessage();
            leaveMessage.setCustomName(customName);
            leaveMessage.setTelNo(telNo);
            leaveMessage.setMessage(msg);
            int result = leaveMessageService.insert(leaveMessage);
            if (result == 1) {
                model.addAttribute("info", "留言成功，我们会尽快与您取得联系！");
            } else {
                model.addAttribute("info", "留言失败，请直接拨打网页中的联系电话！");
            }
        }
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        return "web/leaveMessage";
    }

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
