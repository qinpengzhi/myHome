package com.home.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.dao.CommentDao;

/**
 * @author qpz:
 * @version ����ʱ�䣺2017��8��24�� ����8:12:30
 * ��˵��
 */
@Service
public class CommentService {
	@Autowired 
	private CommentDao commentDao;
	//��ҳ����comment
	public Map<String,Object> getComment(int currentPage,int pageSize){
		return commentDao.getComment(currentPage, pageSize);
	}
	//����
	public void clickUp(int id){
		commentDao.clickUp(id);
	}
	//��
	public void stepDown(int id){
		commentDao.stepDown(id);
	}
	//��������
	public void addcomment(String comment){
		commentDao.addcomment(comment);
	}
}