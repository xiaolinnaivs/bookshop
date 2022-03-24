package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Book;
import com.book.entity.Order_detail;
import com.book.entity.Order_list;
import com.book.entity.Trolley;
import com.book.service.BookService;
import com.book.service.TrolleyService;

/**
 * Servlet implementation class TrolleyServlet
 */
@WebServlet("/trolley")
public class TrolleyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	TrolleyService ts=new TrolleyService();
	BookService bs=new BookService();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		switch (method) {
		case "addTro"://���ﳵ������Ʒ
			addTro(request,response);
			break;
		case "delTro"://���ﳵɾ����Ʒ
			delTro(request,response);
			break;
		
		case "showTro"://չʾ���ﳵ����goods.jsp
			showTro(request,response);
			break;
			
		
		case "makeOrder"://ȥ������ת����������
			makeOrder(request,response);
			break;
			
		
		case "showOrder"://չʾ��������
			showOrder(request,response);
			break;	
			
		
		case "delOrder"://����ɾ��
			delOrder(request,response);
			break;
			
		case "settleOrd"://��������
			settleOrd(request,response);
			break;
		
		default:
			break;
		}
	}
	
	
	/*
	 * private void checkTro(HttpServletRequest request, HttpServletResponse
	 * response) { // TODO Auto-generated method stub String bid =
	 * request.getParameter("bid"); String uid = request.getParameter("uid");
	 * boolean flag1 = ts.checkTro(Integer.valueOf(uid),Integer.valueOf(bid)); }
	 */


	private void settleOrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.valueOf(request.getParameter("uid"));
		int oid = Integer.valueOf(request.getParameter("oid"));
		boolean tag=ts.setState(oid);
		if (tag) {
			request.getRequestDispatcher("trolley?method=showOrder&uid="+uid).forward(request, response);
		}else {
			response.getWriter().print("fail");
		}
		
	}


	//Detial������ã����ӹ��ﳵ
	private void addTro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uid = request.getParameter("uid");
		String bid = request.getParameter("bid");
		Book book = bs.findBookByBid(bid);
		
		Trolley trolley=ts.checkTro(Integer.valueOf(uid),Integer.valueOf(bid));
		if (trolley != null) {
			int number = trolley.getNumber();
			Trolley trolley2 = new Trolley(trolley.getTid(),trolley.getUid(),trolley.getBid(),number+1,book.getPrice()*Double.valueOf(number+1));
			boolean flag = ts.updateTro(trolley2);
			response.setContentType("text/html;charset=utf-8");
			if(flag) {
				response.getWriter().write("<script>alert('���ͼ�������ﳵ�ɹ�'); window.location.href='index?method=showInformation'; window.close();</script>");
				response.getWriter().flush();
			}else {
				response.getWriter().write("<script>alert('���ͼ�������ﳵʧ��');window.location.href='index?method=showInformation'; window.close();</script>");
				response.getWriter().flush();
			}
		}else {
			Trolley trolley3 = new Trolley(Integer.valueOf(uid),Integer.valueOf(bid),1,book.getPrice());
			boolean flag = ts.addTro(trolley3);
			if(flag) {
				response.getWriter().write("<script>alert('���ͼ�������ﳵ�ɹ�');window.location.href='index?method=showInformation'; window.close();</script>");
				response.getWriter().flush();
			}else {
				response.getWriter().write("<script>alert('���ͼ�������ﳵʧ��');window.location.href='index?method=showInformation'; window.close();</script>");
				response.getWriter().flush();
			}
		}
	}
	//����tidɾ�����ﳵ�ڵ�ĳ����Ʒ
	private void delTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tid = Integer.valueOf(request.getParameter("tid"));
		int uid=ts.deleteByT(tid);
		if (uid>0) {//�ҵ��û�,ɾ���ɹ�
			request.getRequestDispatcher("trolley?method=showTro&uid="+uid).forward(request, response);
		}else {
			response.getWriter().print("fail");
		}
	}
	
	/*
	 չʾ���ﳵ����
	 ������빺�ﳵ
	 ����uidչʾ��ǰ���ﳵ�ڵ���Ʒ
	 ��ת��goods.jsp
	 * */
	private void showTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.valueOf(request.getParameter("uid"));
		//System.out.println(uid);
		List<Trolley> trolley= ts.findAllTro(uid);
		/*
		 * List<Book> books=new ArrayList<Book>(); books.add(new
		 * Book(1,1,"�㷨���ۣ�ԭ���3�棩","[��]Thomas H.Cormen",128,"��Ӣ���α�������ʽ����",
		 * "s25648004.jpg",0,new Date())); books.add(new
		 * Book(2,1,"�������ѧ����","[��]����³�ȡ�������",69,"����������ѧ�Ļ���֪ʶ","s28418968.jpg",0,new
		 * Date()));
		 */
		//System.out.println(trolley.size());
		
		Map<Integer, Book> bookMap=new HashMap<Integer, Book>();
		/*
		 * bookMap.put(1, books.get(0)); bookMap.put(2, books.get(1));
		 */
		
		
		  for (Trolley t : trolley) {
					Book book=bs.findBookByBid(String.valueOf(t.getBid()));
					bookMap.put(t.getTid(),book);
		  }
		 
		request.setAttribute("trolist",trolley);
		request.setAttribute("Map",bookMap);
		request.getRequestDispatcher("trolley.jsp").forward(request, response);
	}
	
	/*
	 ��������
	 ���ﳵ����goods.jsp���ȥ����
	 ������ѡ��Ʒ��Ӷ���\DB��order_list��order_detial
	 ��ת��trolley?method=showOrder&uid=
	 * */
	private void makeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.valueOf(request.getParameter("uid"));
		String bids = request.getParameter("bids");
		String numbers = request.getParameter("numbers");
		double sum = Double.parseDouble(request.getParameter("sum"));
		//System.out.println(uid+"\t"+bids+"\t"+numbers+"\t"+sum);
		int oid= ts.addOrd(new Order_list(uid,sum,new Date()));
		if(oid>0) {
			boolean flag =ts.addDetial(oid, bids, numbers);
			if (flag) {
				ts.deleteBybids(bids.substring(0,bids.length()-1), uid);
				
		        request.getRequestDispatcher("trolley?method=showOrder&uid="+uid).forward(request, response);//�ȴ���������
			}
		}
	}
	

	/*
	 չʾ���ж���
	 ����uidչʾ�û���ǰ�Ķ���
	 ת��order.jsp
	 */
	private void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.valueOf(request.getParameter("uid"));
		
		
		List<Order_list> order_lists=ts.findOrd(uid);
		Map<Integer, Order_detail> ordmap = new HashMap<Integer, Order_detail>();
		for (Order_list o : order_lists) {
			Order_detail od=ts.findDetailByO(o.getOid());
			ordmap.put(o.getOid(), od);
		}
		request.setAttribute("oList", order_lists);
		request.setAttribute("oMap", ordmap);
		
		request.getRequestDispatcher("Order.jsp").forward(request, response);
	}
	
	
	
	/*
	  ɾ������
	 order.jsp������ȥ������ 
	  ������ѡ��Ʒ��oid��DB��ɾ����Ӧ��Ŀ
	  ��ת��trolley?method=showOrder&uid=
	*/
	private void delOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oid = Integer.valueOf(request.getParameter("oid"));
		int uid = Integer.valueOf(request.getParameter("uid"));
		boolean tag= ts.delOrd(oid);
		if (tag) {
			request.getRequestDispatcher("trolley?method=showOrder&uid="+uid).forward(request, response);//�ȴ���������
		}else {
			PrintWriter out=response.getWriter();
			out.println("alert('ɾ��ʧ�ܣ�');");
		}
	}
	


}
