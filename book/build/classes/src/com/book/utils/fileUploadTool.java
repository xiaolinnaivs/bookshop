package com.book.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class fileUploadTool {
	//�ļ��ϴ�����
	public static String fileUpload(String errorPage,Part part,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ж��Ƿ�ѡ�����ϴ���ͼƬ
		if(part.getSize()==0) {
			request.setAttribute("msg","��ѡ��Ҫ�ϴ���ͼƬ");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return "";
		}
		//�ϴ�ͼƬ����
		String filename = part.getSubmittedFileName();
		//System.out.println(filename);
		//��ȡ�ļ���ʽ
		String type = filename.substring(filename.lastIndexOf(".")+1);
		//	System.out.println(type);
		//�ж��ļ���ʽ
		if(!"jpg".equals(type)&&!"jpeg".equals(type)&&!"png".equals(type)&&!"gif".equals(type)) {
		request.setAttribute("msg","ͼƬ��ʽ����ȷ");
		request.getRequestDispatcher(errorPage).forward(request, response);
		return "";
		}
		String photo = UUID.randomUUID()+filename;
		//	System.out.println(filename);
		String path = "D:/Users/dell/eclipse-workspace/bookpic";
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		//�ϴ�����fileNameָ�����ϴ�ͼƬ������·��
		part.write(path+"/"+photo);
		return photo;
	}
}
