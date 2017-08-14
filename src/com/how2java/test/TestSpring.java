package com.how2java.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.how2java.dao.CategoryDao;
import com.how2java.pojo.Category;

public class TestSpring {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[]
				{"applicationContext.xml"});
		CategoryDao dao =(CategoryDao) ac.getBean("dao");
//		//查找所有数据
//		List<Category> list=dao.find("from Category ");
//		System.out.println(list);
//		 Category c = new Category();
//	        c.setName("category yyy");
//	         
//	        //增加
//	        dao.save(c);
//	         
//	        //获取
//	        Category c2 = dao.get(Category.class, 1);
//	         
//	        //修改
//	        c2.setName("category zzz");
//	        dao.update(c2);
//	         
//	        //删除
//	        dao.delete(c2);
		
//		//分页查询
//		DetachedCriteria dc=DetachedCriteria.forClass(Category.class);
//		int start=2;//从多少页开始查询
//		int count=2;//每页数量
//		//对应sql
//		//Hibernate: select this_.id as id0_0_, this_.name as name0_0_ from category this_ limit ?, ?
//		List<Category> lc=dao.findByCriteria(dc,start,count);
//		System.out.println(lc);
		
//		//查询总数
//		List<Long>l=dao.find("select count(*) from Category");
//		Long total = l.get(0);
//		System.out.println(total);
	
		//模糊查询
		List<Category> lc=dao.find("from Category c where c.name like ?","%j%");
		 for (Category c : lc) {
	            System.out.println(c.getName());
	        }
		 DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		 dc.add(Restrictions.like("name", "%f%"));
		 lc=dao.findByCriteria(dc);
		 for (Category c : lc) {
	            System.out.println(c.getName());
	        }
	}

}
