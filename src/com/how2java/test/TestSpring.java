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
//		//������������
//		List<Category> list=dao.find("from Category ");
//		System.out.println(list);
//		 Category c = new Category();
//	        c.setName("category yyy");
//	         
//	        //����
//	        dao.save(c);
//	         
//	        //��ȡ
//	        Category c2 = dao.get(Category.class, 1);
//	         
//	        //�޸�
//	        c2.setName("category zzz");
//	        dao.update(c2);
//	         
//	        //ɾ��
//	        dao.delete(c2);
		
//		//��ҳ��ѯ
//		DetachedCriteria dc=DetachedCriteria.forClass(Category.class);
//		int start=2;//�Ӷ���ҳ��ʼ��ѯ
//		int count=2;//ÿҳ����
//		//��Ӧsql
//		//Hibernate: select this_.id as id0_0_, this_.name as name0_0_ from category this_ limit ?, ?
//		List<Category> lc=dao.findByCriteria(dc,start,count);
//		System.out.println(lc);
		
//		//��ѯ����
//		List<Long>l=dao.find("select count(*) from Category");
//		Long total = l.get(0);
//		System.out.println(total);
	
		//ģ����ѯ
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
