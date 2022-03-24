package com.book.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.book.entity.Category;
import com.book.utils.PageTool;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class CategoryDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());
	public Category findCategoryByCid(String cid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM category WHERE cid = ?";
		try {
			return qRunner.query(sql, new BeanHandler<Category>(Category.class),cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM category";
		try {
			return qRunner.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int getTotalCount() {//��ȡ���ݿ��з������������Ŀ
		String sql = "SELECT COUNT(*) FROM category;";
		int count = 0;
		try {
			Long l = (Long)qRunner.query(sql, new ScalarHandler());
			count = l.intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public int getTotalCount2(String search) {
		String sql = "SELECT COUNT(*) FROM category WHERE cname  LIKE \"%\"?\"%\" LIMIT 0,5;";
		int count = 0;
		try {
			Long l = (Long)qRunner.query(sql, new ScalarHandler(),search);
			count = l.intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Category> findCategoryByPage(PageTool p) {//��ȡ���ݿ��з����������Ϣ
		  String sql = "SELECT * FROM category LIMIT ?,?;";
			try {
				return qRunner.query(sql, new BeanListHandler<Category>(Category.class),p.getStartIndex(),p.getPageSize());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	public int addcategory(Category category) {//�����Ʒ������
		String sql = "INSERT INTO category (cname,state,order_number,create_time)VALUES(?,?,?,?);";
		try {
			return qRunner.update(sql,category.getCname(),category.getState(),category.getOrder_number(),category.getCreate_time());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	

	public int updatecategory(Category category) {//�޸ĵ�ǰ��Ʒ��������Ϣ
		String sql = "UPDATE category SET cname = ?,state=?,order_number=?,create_time= ? WHERE cid = ?;";
		try {
			return qRunner.update(sql,category.getCname(),category.getState(),category.getOrder_number(),category.getCreate_time(),category.getCid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deletecategory(String cids) {//ɾ����ǰ�����������Ϣ
		String sql = "DELETE FROM category WHERE cid IN ("+cids+");";
		try {
			return qRunner.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deletecategoryById(String cid) {//ɾ����ǰ������������Ϣ
		String sql = "DELETE FROM category WHERE cid =?;";
		try {
			return qRunner.update(sql,cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Category> findTheCategory(String search,PageTool p) {//ģ�������鼮��Ϣ
		String sql = "SELECT * FROM category WHERE cname  LIKE \"%\"?\"%\" LIMIT ?,?";
		try {
			return qRunner.query(sql,new BeanListHandler<Category>(Category.class),search,p.getStartIndex(),p.getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Category> findcategoryByCondition(int row){
		String sql = "SELECT * FROM category WHERE state = 1 ORDER BY order_number LIMIT ?";
		try {
			return qRunner.query(sql, new BeanListHandler<Category>(Category.class),row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
