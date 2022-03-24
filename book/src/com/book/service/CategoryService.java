package com.book.service;

import java.util.List;

import com.book.entity.Category;
import com.book.utils.PageTool;
import com.book.dao.CategoryDao;

public class CategoryService {
	CategoryDao cd = new CategoryDao();
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return cd.findAllCategory();
	}
	public int getTotalCount() {//��ȡ���ݿ��з������������Ŀ
		return cd.getTotalCount();
	}
	public int getTotalCount2(String search) {
		return cd.getTotalCount2(search);
	}
	public List<Category> findcategoryByPage(PageTool p) {//��ȡ���ݿ��з����������Ϣ
		 return cd.findCategoryByPage(p);
	}

	public boolean addcategory(Category category) {//�����Ʒ������
			return cd.addcategory(category)>0?true:false;
		}

	public Category findCategoryByCid(String cid) {//��ȡ������ж�Ӧid�ķ�������Ϣ
		return cd.findCategoryByCid(cid);
	}

	public boolean updatecategory(Category category) {//�޸ĵ�ǰ��Ʒ��������Ϣ
		return cd.updatecategory(category)>0?true:false;
	}

	public boolean deletecategory(String cids) {//ɾ����ǰ�����������Ϣ
		return cd.deletecategory(cids)>0?true:false;
	}

	public boolean deletecategoryById(String cid) {//ɾ����ǰ������������Ϣ
		return cd.deletecategoryById(cid)>0?true:false;
	}

	public List<Category> findTheCategory(String search,PageTool p) {//ģ�������鼮��Ϣ
		// TODO Auto-generated method stub
		return cd.findTheCategory(search,p);
	}
	public List<Category> findcategoryByCondition(int row){
		return cd.findcategoryByCondition(row);
	}
}
