package cn.zgys.wifi.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.zgys.wifi.entity.EmployeeBean;
import cn.zgys.wifi.entity.Messager;
import cn.zgys.wifi.entity.PageBean;
import cn.zgys.wifi.entity.UserBean;
import cn.zgys.wifi.service.EmployeeBeanService;
import cn.zgys.wifi.service.UserBeanService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class EmployeeController {

    private final EmployeeBeanService employeeBeanService;
    private final UserBeanService userBeanService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeController(EmployeeBeanService employeeBeanService, UserBeanService userBeanService) {
        this.employeeBeanService = employeeBeanService;
        this.userBeanService = userBeanService;
    }

    //审批人员分页展示
    @RequestMapping(value = "/employee/page", method = {RequestMethod.GET})
    public PageBean getUsersByQueryParams(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber, EmployeeBean emp) {
        PageBean pager = new PageBean();
        if (pageNumber < 1) {
            pager.setPageNumber(1);
        } else {
            pager.setPageNumber(pageNumber);
        }
        //设置每页条数
        pager.setPageSize(8);
        System.out.println(pager.getPageNumber());

        try {
            pager = employeeBeanService.findAllByPage(pager, emp);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("EmployeeController----getUsersByQueryParams()", e);
            e.printStackTrace();
        }

//		System.err.println(pager.getRows());
        logger.info("EmployeeController----" + pager);
        return pager;
    }

    //删除审批人员
    @RequestMapping(value = "/employee/delete", method = {RequestMethod.DELETE})
    public Messager deleteEmployee(
            @RequestParam(value = "id") long id) {
        System.err.println(id);
        Messager msg = new Messager(true, "删除成功!");
        try {
            employeeBeanService.deleteEmployee(id);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("EmployeeController-----deleteEmployee()----" + id, e);
            msg.setStatus(false);
            msg.setInformation("系统繁忙，请稍后再试!");
        }
        logger.info("EmployeeController---deleteEmployee()---success" + id);
        return msg;
    }

    //添加审批人员
    @RequestMapping(value = "/employee/add", method = {RequestMethod.POST})
    public Messager addEmployee(EmployeeBean emp) {
        Messager msg = new Messager(true, "添加成功!");
        EmployeeBean test = employeeBeanService.findByAccount(emp.getAccount());
        if (!(test == null)) {
            msg.setStatus(false);
            msg.setInformation("该工号已经存在！");
            return msg;
        }
        System.err.println(emp);
        emp.setCreateTime(new Date());
        try {
            employeeBeanService.addEmployee(emp);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("EmployeeController-------addEmployee()----" + emp, e);
            msg.setStatus(false);
            msg.setInformation("系统繁忙，请稍后再试!");
        }
        logger.info("EmployeeController---addEmployee()--success" + emp);
        return msg;
    }

    //修改审批人员
    @RequestMapping(value = "/employee/update", method = {RequestMethod.PUT})
    public Messager updateEmployee(EmployeeBean emp) {
        emp.setCreateTime(new Date());
        Messager msg = new Messager(true, "修改成功!");
        try {
            employeeBeanService.updateEmployee(emp);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("EmployeeController-------updateEmployee()----" + emp, e);
            msg.setStatus(false);
            msg.setInformation("系统繁忙，请稍后再试!");
        }
        logger.info("EmployeeController---updateEmployee()--success" + emp);
        return msg;
    }


    //登录后台系统
    @RequestMapping(value = "/employee/login", method = {RequestMethod.POST})
    public Messager login(
            @RequestParam(value = "account") String account,
            @RequestParam(value = "pwd") String pwd,
            HttpServletRequest request) {
        Messager msg = new Messager(true, "登录成功@");
        try {
            //帐号密码验证成功后将用户信息存入session
            UserBean user = userBeanService.findUserBean(account, pwd);
            if (null == user) {
                msg.setStatus(false);
                msg.setInformation("帐号或密码错误!");
            } else {
                request.getSession().setAttribute("user", user);
            }
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("EmployeeController-----login", e);
            msg.setStatus(false);
            msg.setInformation("系统繁忙，请稍后再试!");
        }
        logger.info("EmployeeController-----login---success");
        return msg;
    }

    //根据职级查询审批人员
    @RequestMapping(value = "/approve/findAll", method = {RequestMethod.GET})
    public List<EmployeeBean> findAll(String level) {
        List<EmployeeBean> list = null;
        try {
            list = employeeBeanService.findByLevelEquals(level);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("EmployeeController------findAll()", e);
        }
        logger.info("EmployeeController------findAll()");
        return list;
    }

    //根据工号查询审批人员
    @RequestMapping(value = "/approve/findByAccount", method = {RequestMethod.GET})
    public EmployeeBean findByAccount(String account) {
        EmployeeBean emp = null;
        try {
            emp = employeeBeanService.findByAccount(account);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("EmployeeController------findByAccount()", e);
        }
        logger.info("EmployeeController------findByAccount()");
        return emp;
    }

}
