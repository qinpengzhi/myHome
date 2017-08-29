package com.home.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.dao.ArticleDao;

/**
 * @author qpz:
 * @version ����ʱ�䣺2017��8��26�� ����9:47:32
 * �й����µ�service��
 */
@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;
	//�й������Ӽǵķ���ͳ��
	public  List<Map<String, Object>> getArticleTypeNums(){
		return articleDao.getArticleTypeNums();
	}
	//�йش���ķ���ͳ��
	public  List<Map<String, Object>> getCodeArticleTypeNums(){
		return articleDao.getCodeArticleTypeNums();
	}
	//�����������(�ռ�)
	public Map<String,Object> getdariys(int currentPage,int pageSize,String starttime,String endtime,String keyword){
		return articleDao.getdariys(currentPage, pageSize, starttime,endtime,keyword);
	}
	//�����������(�����Ӽ�)
	public Map<String,Object> getArticles(int currentPage,int pageSize,int type,String keyword){
		return articleDao.getArticles(currentPage, pageSize, type,keyword);
	}
	//�����������(������)
	public Map<String,Object> getCodeArticles(int currentPage,int pageSize,int type,String keyword){
		return articleDao.getCodeArticles(currentPage, pageSize, type,keyword);
	}
	//��������id��������
	public List<Map<String,Object>> getArticlebyId(int id){
		return articleDao.getArticlesbyId(id);
	}
}
