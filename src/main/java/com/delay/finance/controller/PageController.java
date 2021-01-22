package com.delay.finance.controller;

import com.delay.finance.entity.Company;
import com.delay.finance.entity.User;
import com.delay.finance.repository.CompanyRepository;
import com.delay.finance.service.UserService;
import com.delay.finance.utils.ExecuteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 新增类别
     * @return
     */
    @RequestMapping("addType")
    public String addType(){
        return "type/type-add";
    }

    /**
     * 部门列表管理
     * @return
     */
    @RequestMapping("deptList")
    public String deptList(){
        return "dept/dept-list";
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
     * 工资管理
     * @return
     */
    @RequestMapping("wagesList")
    public String wagesList(){
        return "wages/wages-list";
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
     * 待审核
     * @return
     */
    @RequestMapping("masterEssayList")
    public String masterEssayList(){
        return "master/master-essay-list";
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

    /**
     * 新增部门
     * @return
     */
    @RequestMapping("addDept")
    public String addDept(){
        return "dept/dept-add";
    }

    /**
     * 项目添加
     * @return
     */
    @RequestMapping("projectAdd")
    public String projectAdd(){
        return "project/project-add";
    }


}
