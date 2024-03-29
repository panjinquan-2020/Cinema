package com.zxl.controller;

import com.github.pagehelper.PageInfo;
import com.zxl.entity.Msm;
import com.zxl.entity.TMovieorder;
import com.zxl.entity.TSchedule;
import com.zxl.entity.TUserinfo;
import com.zxl.service.TMovieService;
import com.zxl.service.TMovieorderService;
import com.zxl.service.TScheduleService;
import com.zxl.service.TUserinfoService;
import com.zxl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/userorder")
public class UserOrderController {
    @Autowired
    private TMovieorderService tMovieorderService;

    @Autowired
    private TUserinfoService tUserinfoService;

    @RequestMapping("/addajax")
    public @ResponseBody
            Msm addajax(Integer id){
        Msm byId = tMovieorderService.findById(id);

        return byId;
    }
    @RequestMapping("/add")
    public String add(Integer id, ModelMap modelMap, RedirectAttributes as){
        Msm byId = tMovieorderService.findById(id);
        if (byId==null){
            as.addAttribute("message","当前电影没有安排放映,请选择其他电影");
            return "redirect:/movies/home";
        }
        modelMap.addAttribute("msm",byId);
        return "seat";
    }

    @RequestMapping("/buy")
    public String buy(Msm msm){
        tMovieorderService.insert(msm);
        System.out.println(msm);
        return "redirect:/userorder/findorder?page=1&pagesize=2";
    }
    @RequestMapping("/findorder")
    public String findByusername(int page,int pagesize,ModelMap modelMap,@ModelAttribute(value = "message")String message){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        TUserinfo userByname = tUserinfoService.findUserByname(name);
        Integer count = tMovieorderService.count(name);
        Page pagein=new Page();
        pagein.setPageSize(pagesize);
        pagein.setPage(page);
        pagein.setCount(count);
        List<TMovieorder> byUsername = tMovieorderService.findByUsername(name,page,pagesize);
        PageInfo pageInfo=new PageInfo(byUsername);
        modelMap.addAttribute("orders",pageInfo);
        modelMap.addAttribute("pages",pagein);
        modelMap.addAttribute("me",userByname);
        modelMap.addAttribute("message",message);
        return "user_order";
    }
    @RequestMapping("/cancel")
    public String cancel(Integer orderid){
        TMovieorder t=new TMovieorder();
        t.setOrderid(orderid);
        t.setStatus(3);
        tMovieorderService.update(t);
        return "redirect:/userorder/findorder?page=1&pagesize=2";
    }
}
