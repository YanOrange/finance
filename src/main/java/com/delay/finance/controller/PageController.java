package com.delay.finance.controller;

import com.delay.finance.entity.Company;
import com.delay.finance.entity.User;
import com.delay.finance.repository.CompanyRepository;
import com.delay.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面控制器
 */
@Controller
@RequestMapping("page")
public class PageController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyRepository companyRepository;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    /**
     *欢迎页面
     * @return
     */
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     *首页
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }


    /**
     * 个人界面
     * @return
     */
    @RequestMapping("person")
    public String person(){
        User user = getUser();

        return "member/person";
    }

    /**
     * 个人工资条
     * @return
     */
    @RequestMapping("personWages")
    public String wages(){
        return "wages/wages-person";
    }

    /**
     * 本人收支记录
     * @return
     */
    @RequestMapping("projectApply")
    public String projectApply(){
        return "project/project-apply";
    }


    /**
     * 账户余额，公司信息
     * @param model
     * @return
     */
    @RequestMapping("companyInfo")
    public String companyInfo(Model model){
        Company company = companyRepository.findAll().get(0);
        model.addAttribute("company",company);
        return "company/info";
    }

    /**
     * 业务项目类别管理
     * @return
     */
    @RequestMapping("typeList")
    public String typeList(){
        return "type/type-list";
    }

    /**
     * 报表管理
     * @return
     */
    @RequestMapping("reportList")
    public String reportList(){
        return "project/report-list";
    }

    /**
     * 业务收支审批
     * @return
     */
    @RequestMapping("essayList")
    public String essayList(){
        return "member/essay-list";
    }

    /**
     * 待审核稿件
     * @return
     */
    @RequestMapping("masterEssayList")
    public String masterEssayList(){
        return "master/master-essay-list";
    }

    /**
     * 获取全部管理员
     * @return
     */
    @RequestMapping("toAdmin")
    public String toAdmin(){
        return "admin/admin-list";
    }

    /**
     * 新增用户
     * @return
     */
    @RequestMapping("add")
    public String add(Integer status, Model model){
        model.addAttribute("status",status);
        return "member/person-add";
    }





}
