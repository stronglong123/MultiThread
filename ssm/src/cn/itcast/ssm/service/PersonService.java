package cn.itcast.ssm.service;

import java.util.List;
import java.util.Map;

import cn.itcast.ssm.domain.Person;

/**
 * @Description:
 * @Author:		传智播客 java学院	陈子枢
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年11月17日
 */
public interface PersonService {

	public List<Person> find(Map map);
	public void insert(Person person);
	public Person findPersonBook(Integer id);

}