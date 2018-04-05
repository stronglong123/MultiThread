package cn.itcast.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.ssm.dao.PersonDao;
import cn.itcast.ssm.domain.Person;
import cn.itcast.ssm.service.PersonService;

/**
 * @Description:
 * @Author:		传智播客 java学院	陈子枢
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年11月17日
 */
@Service
public class PersonServiceImpl implements PersonService {
	@Resource
	PersonDao personDao;
	
	public List<Person> find(Map map){
		return personDao.find(map);
	}
	
	public void insert(Person person){
		//person.setId(id);		id主键生成策略...
		personDao.insert(person);
	}
	
	public Person findPersonBook(Integer id){
		return personDao.findPersonBook(id);
	}
}
