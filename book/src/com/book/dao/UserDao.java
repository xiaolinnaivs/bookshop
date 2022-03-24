package com.book.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.book.entity.Category;
import com.book.entity.User;
import com.book.utils.PageTool;

public class UserDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());
	
	//Day01
	
	// ��̨��¼��֤
	public User checkAdminUser(String username, String upwd) {
		String sql = "SELECT * FROM USER WHERE username=? AND upwd = ? and manager = 0";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class), username, upwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// ��¼��֤
	public User checkUser(String username, String upwd) {
		String sql = "SELECT * FROM USER WHERE username=? AND upwd =? ";
		try {
			
			return qRunner.query(sql, new BeanHandler<User>(User.class), username, upwd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	//*********
	public User checkPhone(String uphone) {
		String sql = "SELECT * FROM USER WHERE uphone=?";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class), uphone);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// �����û�����ѯ
	public User checkUserName(String username) {
		String sql = "SELECT * FROM USER WHERE username =?";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// ��Ӳ���
	public int addUser(User user) {
		String sql = "INSERT INTO USER (username,email,uphone,upwd,create_time) VALUES(?,?,?,?,?)";
		try {
			return qRunner.update(sql, user.getUsername(), user.getEmail(), user.getUphone(),
					user.getUpwd() ,user.getCreate_time());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//***************************************************************
	
	//day02
	//��ѯȫ��
		public List<User> findAllUsers() {
			String sql = "SELECT * FROM USER";
			try {
				return qRunner.query(sql, new BeanListHandler<User>(User.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		//��ѯ�����ܼ�¼��
		public int getTotalCount() {
			int count=0;
			String sql = "SELECT COUNT(*) FROM USER";
			try {
				Long l = (Long)qRunner.query(sql, new ScalarHandler());
				count = l.intValue();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}

		//��ҳ��ѯ
		public List<User> findUsersByPage(PageTool tool) {
			String sql = "SELECT * FROM USER limit ?,?";
			try {
				return qRunner.query(sql, new BeanListHandler<User>(User.class), 
						tool.getStartIndex(),tool.getPageSize());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//����û�
		public int addUser2(User user) {
			String sql = "INSERT INTO USER (username,email,uphone,upwd,manager,create_time,upic)VALUES(?,?,?,?,?,?,?)";
			try {
				return qRunner.update(sql, user.getUsername(),user.getEmail(),user.getUphone(),
						user.getUpwd(),user.getManager(),user.getCreate_time(),user.getUpic());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		//���ݶ���������ɾ��
		public int deleteManyUsers(String uids) {
			String sql = "DELETE FROM USER WHERE uid IN ("+uids+")";
			try {
				return qRunner.update(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		//���ݱ�Ų�ѯ
		public User findUserByUid(String uid) {
			String sql = "SELECT * FROM USER WHERE uid=?";
			try {
				return qRunner.query(sql, new BeanHandler<User>(User.class), uid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//�޸��û�
		public int updateUser(User user) {
			String sql = "UPDATE USER SET username=?,email=?,uphone=?,upwd=?,manager=?,create_time=?,upic=? WHERE uid=?";
			try {
				return qRunner.update(sql, user.getUsername(),user.getEmail(),user.getUphone(),user.getUpwd(),
						user.getManager(),user.getCreate_time(),user.getUpic(),user.getUid());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}

		//ɾ�������û�
		public int deleteUserByUid(int uid) {
			int r = 0;
			String sql = "DELETE FROM USER WHERE uid=?";
			try {
				r = qRunner.update(sql, uid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return r;
		}

		//��ѯ�����û�
		public User findUserByUid(int uid) {
			String sql = "SELECT * FROM USER WHERE uid=?";
			User user = null;
			try {
				user = qRunner.query(sql, new BeanHandler<User>(User.class), uid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		public int getTotalCount2(String search) {
			String sql = "SELECT COUNT(*) FROM user WHERE username  LIKE \"%\"?\"%\" LIMIT 0,5;";
			int count = 0;
			try {
				Long l = (Long)qRunner.query(sql, new ScalarHandler(),search);
				count = l.intValue();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return count;
		}
		public List<User> findTheUser(String search,PageTool p) {//ģ�������鼮��Ϣ
			String sql = "SELECT * FROM user WHERE username  LIKE \"%\"?\"%\" LIMIT ?,?";
			try {
				return qRunner.query(sql,new BeanListHandler<User>(User.class),search,p.getStartIndex(),p.getPageSize());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public User findUserByUphoneEmail(String uphone, String email) {
			String sql = "SELECT * FROM USER WHERE uphone=? AND email=?";
			try {
				return qRunner.query(sql, new BeanHandler<User>(User.class), uphone,email);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		
		public int updatePwd(String uid, String upwd) {
			String sql = "UPDATE USER SET upwd=? WHERE uid=?";
			try {
				return qRunner.update(sql, upwd,uid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
}