package com.sgcc.user.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sgcc.user.pojo.User;
import com.sgcc.user.service.UserService;

import net.sf.json.JSONArray;

@Controller
public class UserController {
	
	
	@Resource
	private UserService userService;
	/*
	 * @RequestMapping("/jump") public ModelAndView modelAndView() { ModelAndView
	 * modelAndView = new ModelAndView(); modelAndView.addObject("user", "用户信息！");
	 * modelAndView.setViewName("regUser"); return modelAndView; }
	 */
	//登录跳转
	@RequestMapping("/register")
	public String jump(Model model) {
		return "regUser";
	}
	
	//登陆验证
	@RequestMapping("/login")
	public String login(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password, Model model) {
		
		User user = userService.getUserByName(userName);
		//从数据库中查询用户，返回为空时提示用户不存在;返回不为空时，判断密码是否相同，相同则验证通过，跳转到主页，不相同提示密码错误
		if (user == null) {
			model.addAttribute("msg","用户不存在！");
			return "../../login";
		}else if(password.equals(user.getPassword())){
			model.addAttribute("user", user); //用于主页右上角欢迎提示
			return "welcome";
		}else {
			model.addAttribute("msg","密码错误！");
			return "../../login";
		}
	}
	
	//注册页面
	@RequestMapping("/regUser")
	public String regUser(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password, @RequestParam(value = "password") Integer age,
			Model model) throws Exception {
		//如果用户名已存在，往前端传一段信息。
		User userTemp = userService.getUserByName(userName);
		if (userTemp != null) {
			model.addAttribute("user",userTemp);
			model.addAttribute("msg", "用户已存在！");
		}else {
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setAge(age);
			userService.insert(user);
			
			model.addAttribute("msg", "用户注册成功！");
			System.out.println("注册成功！");
		}
		return "regUser";
	}
	
	
	@RequestMapping("/getUserById" )
	public String testShowUser(@RequestParam(value = "id") String id ,Model model)  {
		System.out.println("id:"+id);
		User user = userService.getUserById(id);
		model.addAttribute("user",user);
		return "showUser";
	}
	
	@RequestMapping("/getAllUser")
	public String testShowAllUser(Model model) {
		List<User> userList = userService.getAll();
		Map map = new HashMap();
		model.addAttribute("user", userList.get(0));
		model.addAttribute("userList",userList);
		return "showUser";
		
	}
	
	@RequestMapping(value="/getAllUserTable")
    public void query(HttpServletResponse resp) {
        try {
            /*list集合中存放的是好多student对象*/
            List<User> users = userService.getAll();
            /*将list集合装换成json对象*/
            JSONArray data = JSONArray.fromObject(users);
            //接下来发送数据
            /*设置编码，防止出现乱码问题*/
            resp.setCharacterEncoding("utf-8");
            /*得到输出流*/
            PrintWriter respWritter = resp.getWriter();
            /*将JSON格式的对象toString()后发送*/
            respWritter.append(data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
