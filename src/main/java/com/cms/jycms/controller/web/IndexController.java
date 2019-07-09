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
import java.util.List;

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

        //长华知识
        List<NewsInfo> topNews = pubComponent.getArtList(32, 0, 1);
        List<NewsInfo> otherNews = pubComponent.getArtList(32, 1, 2);
        //污水泵
        List<NewsInfo> wuShuiBeng = pubComponent.getArtList(62, 0, 5);
        //地暖
        List<NewsInfo> diNuan = pubComponent.getArtList(63, 0, 5);
        //新风
        List<NewsInfo> xinFeng = pubComponent.getArtList(64, 0, 5);
        //空调
        List<NewsInfo> kongTiao = pubComponent.getArtList(65, 0, 5);
        //关于我们
        NewsInfo aboutusContent = newsInfoService.selectByPrimaryKey("55");

        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("topNews", topNews);
        model.addAttribute("otherNews", otherNews);
        model.addAttribute("aboutusContent", aboutusContent);
        model.addAttribute("wuShuiBeng", wuShuiBeng);
        model.addAttribute("diNuan", diNuan);
        model.addAttribute("xinFeng", xinFeng);
        model.addAttribute("kongTiao", kongTiao);
        return "web/index";
    }

    @RequestMapping({"/productCenter"})
    public String productCenter(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        //污水泵
        String wuShuiIds = newsInfoService.selectChild(55);
        List<NewsInfo> wuShuiBeng = newsInfoService.selectArtByClassId(wuShuiIds, 4);

        //地暖
        String diNuanIds = newsInfoService.selectChild(56);
        List<NewsInfo> diNuan = newsInfoService.selectArtByClassId(diNuanIds, 4);

        //新风
        String xinFengIds = newsInfoService.selectChild(57);
        List<NewsInfo> xinFeng = newsInfoService.selectArtByClassId(xinFengIds, 4);

        //空调
        String kongTiaoIds = newsInfoService.selectChild(58);
        List<NewsInfo> kongTiao = newsInfoService.selectArtByClassId(kongTiaoIds, 4);

        model.addAttribute("wushuibeng", wuShuiBeng);
        model.addAttribute("dinuan", diNuan);
        model.addAttribute("xinfeng", xinFeng);
        model.addAttribute("kongtiao", kongTiao);
        model.addAttribute("base", webSiteBaseInfoDTO);
        return "web/class";
    }

    @RequestMapping({"/productCenterSearch"})
    public String productCenterSearch(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, @RequestParam(value = "title", defaultValue = "") String title, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(-1, pageIndex, 12, 31, 5, 0, 1, title, 54);

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
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();

        String wuShuiIds = newsInfoService.selectChild(id);
        ClassInfo classInfo = classInfoService.selectById(id);
        List<NewsInfo> art = newsInfoService.selectArtByClassId(wuShuiIds, (pageIndex - 1) * 8, 8);
        int totalCount = newsInfoService.selectArtByClassIdCount(wuShuiIds);
        int totalPage = totalCount / 8;
        if (totalCount % 8 > 0) {
            totalPage++;
        }
        model.addAttribute("art", art);
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("classInfo", classInfo);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("pageIndex", pageIndex);
        return "web/classSingle";
    }

    @RequestMapping("/casePresentation")
    public String casePresentation(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(31, pageIndex, 8, 31, 5, 0, null, 54);
        ClassInfo classInfo = classInfoService.selectById(31);
        String proClassId = newsInfoService.selectChild(54);
        List<NewsInfo> leftPro = newsInfoService.selectArtByClassId(proClassId, 8);


        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        model.addAttribute("classInfo", classInfo);
        model.addAttribute("leftPro", leftPro);
        model.addAttribute("pageTitle","案例展示");
        model.addAttribute("pageEnTitle","CASE");
        return "web/casePresentation";
    }

    @RequestMapping("/casePresentation/{id}")
    public String casePresentation(@PathVariable("id") int id, @RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(id, pageIndex, 12, 31, 5, 0, null, 54);
        ClassInfo classInfo = classInfoService.selectById(id);
        String proClassId = newsInfoService.selectChild(54);
        List<NewsInfo> leftPro = newsInfoService.selectArtByClassId(proClassId, 8);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        model.addAttribute("classInfo", classInfo);
        model.addAttribute("pageTitle","案例展示");
        model.addAttribute("pageEnTitle","CASE");
        model.addAttribute("leftPro", leftPro);
        return "web/casePresentation";
    }

    @RequestMapping("/honor")
    public String honor(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(80, pageIndex, 12, 31, 5, 0, null, 54);
        ClassInfo classInfo = classInfoService.selectById(80);
        String proClassId = newsInfoService.selectChild(54);
        List<NewsInfo> leftPro = newsInfoService.selectArtByClassId(proClassId, 8);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        model.addAttribute("classInfo", classInfo);
        model.addAttribute("leftPro", leftPro);
        model.addAttribute("classInfo", classInfo);
        model.addAttribute("pageTitle","荣誉资质");
        model.addAttribute("pageEnTitle","HONOR");
        return "web/casePresentation";
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
        return "web/productDetail";
    }

    @RequestMapping({"/news"})
    public String news(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(32, pageIndex, 10, 31, 5, 0, null, 54);

        String proClassId = newsInfoService.selectChild(54);
        List<NewsInfo> art = newsInfoService.selectArtByClassId(proClassId, 8);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        model.addAttribute("art", art);
        return "web/newsClass";
    }

    @RequestMapping({"/carRental"})
    public String carRental(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(53, pageIndex, 10, 31, 5, 0, null, 54);

        model.addAttribute("productList", view.getPaginationDTO().getArtList());
        model.addAttribute("totalPages", view.getPaginationDTO().getTotalPages());
        model.addAttribute("pageIndex", view.getPaginationDTO().getPageIndex());
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", view.getWebSiteBaseInfoDTO());
        model.addAttribute("productTypeList", view.getProductTypeList());
        model.addAttribute("newsList", view.getNewsList());
        return "web/newsClass";
    }

    @RequestMapping({"/guide"})
    public String guide(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, Model model) {
        ViewClassListDTO view = pubComponent.viewClassList(27, pageIndex, 10, 31, 5, 0, null, 54);

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
        ViewClassListDTO view = pubComponent.viewClassList(44, pageIndex, 10, 31, 5, 0, null, 54);

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
        String proClassId = newsInfoService.selectChild(54);
        List<NewsInfo> leftPro = newsInfoService.selectArtByClassId(proClassId, 8);

        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("art", aboutusContent);
        model.addAttribute("leftPro", leftPro);
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
        String proClassId = newsInfoService.selectChild(54);
        List<NewsInfo> leftPro = newsInfoService.selectArtByClassId(proClassId, 8);

        WebSiteBaseInfoDTO webSiteBaseInfoDTO = pubComponent.getBaseInfo();
        NewsInfo aboutusContent = newsInfoService.selectByPrimaryKey("90");
        model.addAttribute("navList", navComponent.getNavList());
        model.addAttribute("base", webSiteBaseInfoDTO);
        model.addAttribute("art", aboutusContent);
        model.addAttribute("leftPro", leftPro);
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
