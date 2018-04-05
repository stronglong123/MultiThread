package cn.itcast.ssm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.ssm.dao.PersonDao;
import cn.itcast.ssm.domain.Person;
import cn.itcast.ssm.mapper.PersonMapper;

/**
 * @Description:PersonDao
 * @Author:		传智播客 java学院	陈子枢
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年11月17日
 */
@Repository
public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDao {
	
	/*
	 * mybatis3.0.0+mybatis-psring1.0.0无需，整合包自己注入
	 * mybatis3.2.2+mybatis-spring1.2.0 必须自己注入sqlSessionFactory；
	 */
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public List<Person> find(Map map){
		PersonMapper mapper = this.getSqlSession().getMapper(PersonMapper.class);
		return mapper.find(map);
	}
	
	public void insert(Person person){
		PersonMapper mapper = this.getSqlSession().getMapper(PersonMapper.class);
		mapper.insert(person);
	}
	
	public Person findPersonBook(Integer id){
		PersonMapper mapper = this.getSqlSession().getMapper(PersonMapper.class);
		return mapper.findPersonBook(id);
	}
	
}
