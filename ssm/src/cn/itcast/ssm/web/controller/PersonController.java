package cn.itcast.ssm.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.ssm.domain.Person;
import cn.itcast.ssm.service.PersonService;

/**
 * @Description:
 * @Author:		传智播客 java学院	陈子枢
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年11月17日
 */
@Controller
public class PersonController {
	@Resource
	PersonService personService;
	
	//查询，将查询结果传递到页面
	@RequestMapping("/person/list.action")	//Controller加载时会自动创建访问路径 /person/list;/person/list.action
	public String list(Model model){
		List<Person> personList = personService.find(null);
		model.addAttribute("personList", personList);		//传递到页面
		
		return "/person/jPersonList.jsp";
	}
	
	//转向新增页面
	@RequestMapping("/person/tocreate.action")
	public String tocreate(){
		return "/person/jPersonCreate.jsp";
	}
	
	//新增保存
	@RequestMapping("/person/insert.action")
	public String insert(Person person){
		personService.insert(person);
		
		return "redirect:/person/list.action";
	}
	
	//转向书籍展示的页面
	@RequestMapping("/person/tobook.action")
	public String tobook(Integer id, Model model){
		Person person = personService.findPersonBook(id);
		
		model.addAttribute("person", person);
		
		return "/person/jPersonBooks.jsp";
	}
	
}
