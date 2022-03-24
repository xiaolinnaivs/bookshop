package com.book.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.book.dao.UserDao;
import com.book.entity.Category;
import com.book.entity.User;
import com.book.utils.PageTool;

public class UserService {
	UserDao ud = new UserDao();

	// ��¼��֤
	public boolean checkAdminUser(String username, String upwd, HttpSession session) {
		User user = ud.checkAdminUser(username, upwd);
		if (user != null) {
			// ����ǰ�û����󱣴浽session����
			session.setAttribute("user", user);
			return true;
		} else {
			return false;
		}
	}

	// ��ӷ���
	public boolean addUser(User user) {
		return ud.addUser(user) > 0 ? true : false;
	}

	// ��֤�ֻ���Ψһ
	public boolean checkPhone(String uphone) {
		User user = ud.checkPhone(uphone);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	// ��֤�˺�Ψһ
	public boolean checkUserName(String username) {
		User user = ud.checkUserName(username);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	// ��¼��֤
	public boolean checkUser(String username, String upwd, HttpSession session) {
		User user = ud.checkUser(username, upwd);
		if (user != null) {
			// ����ǰ�û����󱣴浽session����
			session.setAttribute("loginUser", user);
			return true;
		} else {
			return false;
		}
	}

	// day02
	// ��ѯȫ��
	public List<User> findAllUsers() {
		return ud.findAllUsers();
	}

	// ��ѯ�����ܼ�¼��
	public int getTotalCount() {
		return ud.getTotalCount();
	}

	// ��ҳ��ѯ
	public List<User> findUsersByPage(PageTool tool) {
		return ud.findUsersByPage(tool);
	}

	// ����û�
	public boolean addUser2(User user) {
		return ud.addUser2(user) > 0 ? true : false;
	}

	// ����ɾ��
	public boolean deleteManyUsers(String uids) {
		return ud.deleteManyUsers(uids) > 0 ? true : false;
	}

	// ���ݱ�Ų�ѯ
	public User findUserByUid(String uid) {
		return ud.findUserByUid(uid);
	}

	// �޸��û�
	public boolean updateUser(User user) {
		return ud.updateUser(user) > 0 ? true : false;
	}

	// ɾ�������û�
	public boolean deleteUserByUid(int uid) {
		return ud.deleteUserByUid(uid) > 0 ? true : false;
	}

	// ��ѯ�����û�
	public User findUserByUid(int uid) {
		return ud.findUserByUid(uid);
	}
	public int getTotalCount2(String search) {
		return ud.getTotalCount2(search);
	}
	public List<User> findTheUser(String search,PageTool p) {//ģ�������鼮��Ϣ
		// TODO Auto-generated method stub
		return ud.findTheUser(search,p);
	}
	public User findUserByUphoneEmail(String uphone, String email) {
		return ud.findUserByUphoneEmail(uphone, email);
	}
	
	
	public boolean updatePwd(String uid, String upwd) {
		return ud.updatePwd(uid,upwd)>0?true:false;
	}
}
