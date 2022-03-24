package com.book.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.book.entity.Order_detail;
import com.book.entity.Order_list;
import com.book.entity.Trolley;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TrolleyDao {
	
	QueryRunner qRunner=new QueryRunner(new ComboPooledDataSource());
	//trolley
	//1���ӹ��ﳵ����
	public int addTro(Trolley tro) {
		String sql = "INSERT INTO trolley (uid,bid,number,price) VALUES(?,?,?,?)";
		try {
			return qRunner.update(sql, tro.getUid(), 
										tro.getBid(), 
										tro.getNumber(),
										tro.getPrice());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateTro(Trolley tro) {
		String sql = "UPDATE trolley SET number=?,price=? WHERE tid=?";
		try {
			return qRunner.update(sql, tro.getNumber(),tro.getPrice(),tro.getTid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//����Ƿ����
	public Trolley checkTro(int uid,int bid) {
		String sql = "select * from trolley where uid = ? and bid = ?";
		
		try {
			 return qRunner.query(sql, new BeanHandler<Trolley>(Trolley.class), uid, bid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
        return null;
	}
	//����egbids=��1��2��3��ɾ��
	public int deleteBybids(String bids,int uid) {
		String sql="DELETE FROM trolley WHERE bid IN("+bids+") AND uid =?";
		int r=0;
		try {
			r=qRunner.update(sql,uid);
			//System.out.println(r);
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}
	public int deleteByT(int tid) {
		String find="select * from trolley where tid = ?";
		String sql="DELETE FROM trolley WHERE tid =?;";
		Trolley tro=null;
		int r=0;
		try {
			tro= qRunner.query(find, new BeanHandler<Trolley>(Trolley.class), tid);
			r=qRunner.update(sql,tid);
			//System.out.println(r);
		
		} catch (Exception e) {
			System.out.println(e);
		}
		if (r>0) {
			return tro.getUid();
		}
		return r;
	}
	public List<Trolley> findAllTro(int uid) {
		String sql="SELECT * FROM trolley WHERE uid = ?";
		try {
			
			return qRunner.query(sql, new BeanListHandler<Trolley>(Trolley.class),uid);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}	
	
	
	//order_list
	//��������,����Order_list���oid
	public Order_list addOrd(Order_list oList) {
		String sql = "INSERT INTO order_list (uid,sum_price,create_time) VALUES(?,?,?)";
		String deSql="select * from order_list WHERE uid = ? AND create_time=?";
		int ord=0;
		Order_list oid=null;
		try {
			ord= qRunner.update(sql, oList.getUid(), 
										oList.getSum_price(), 
										oList.getCreate_time());
			
			if (ord>0) {
				oid=qRunner.query(deSql,new BeanHandler<Order_list>(Order_list.class),oList.getUid(),oList.getCreate_time());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oid;
	}
	//�����û�ȫ������
	public List<Order_list> findOrd(int uid) {
		String sql="SELECT * FROM order_list WHERE uid = ?";
		List<Order_list> li=null;
		try {
			
			li= qRunner.query(sql, new BeanListHandler<Order_list>(Order_list.class),uid);
		} catch (Exception e) {
			System.out.println(e);
		}
		return li;
	}
	//����Ϊ��֧��״̬
	public int setState(int oid) {
		String sql="UPDATEorder_list SET state=? WHERE oid=?";
		try {
			return qRunner.update(sql,1,oid);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	
	//detial
	//���Ӷ�����ϸ
	public int addDetial(int oid,String bids,String numbers) {
		String sql = "INSERT INTO order_detial (oid,bids,numbers) VALUES(?,?,?)";
		try {
			return qRunner.update(sql,oid, bids,numbers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//������ϸ:����oid
	public Order_detail findDetailByO(int oid) {
		String sql="SELECT * FROM order_detial WHERE oid = ?";
		Order_detail li=null;
		try {
			
			li= qRunner.query(sql, new BeanHandler<Order_detail>(Order_detail.class),oid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	//������ϸ������uid
	public List<Order_detail> findDetailByU(int uid){
		String sql="SELECT * FROM order_detial WHERE uid = ?";
		List<Order_detail> li=null;
		try {
			
			li= qRunner.query(sql, new BeanListHandler<Order_detail>(Order_detail.class),uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	//����oidɾ��
	public int delOrd(int oid) {
		String listsql="DELETE FROM order_list WHERE oid =?";
		String desql="DELETE FROM order_detial WHERE oid =?";
		int l=0;
		int d=0;
		try {
			l=qRunner.update(listsql,oid);
			if (l>0) {
				d=qRunner.update(desql,oid);
			}
			//System.out.println(r);
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return d;
	}
	
	
}
