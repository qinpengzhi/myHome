package com.home.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dw.utils.DateUtil;
import com.home.service.ArticleService;
import com.home.utils.RequestToJson;

/**
 * @author qpz:
 * @version ����ʱ�䣺2017��8��26�� ����9:46:05
 * �������µ����controller
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	//�й������Ӽǵķ���ͳ��
	@RequestMapping("getArticleTypeNums.action")
	public void getArticleTypeNums(HttpServletRequest req,HttpServletResponse res) throws IOException{
		JSONArray returnObject =JSONArray.fromObject(articleService.getArticleTypeNums());
		res.getWriter().println(returnObject.toString());
	}
	//�д���ķ���ͳ��
	@RequestMapping("getCodeArticleTypeNums.action")
	public void getCodeArticleTypeNums(HttpServletRequest req,HttpServletResponse res) throws IOException{
		JSONArray returnObject =JSONArray.fromObject(articleService.getCodeArticleTypeNums());
		res.getWriter().println(returnObject.toString());
	}
	//�����������(�ռ���)
	@RequestMapping("getdariys.action")
	public void getdariys(HttpServletRequest req,HttpServletResponse res) throws IOException{
		JSONObject jsonObject=RequestToJson.phrase(req);
		int currentPage= Integer.parseInt(jsonObject.getString("currentPage"));
		int pageSize= Integer.parseInt(jsonObject.getString("pageSize"));
		String starttime=jsonObject.getString("starttime");
		String endtime=jsonObject.getString("endtime");
		String keyword=jsonObject.getString("keyword");
		if(starttime.equals(""))starttime="2013-01-01";
		if(endtime.equals(""))endtime=DateUtil.formatFromDate(DateUtil.getCurrentDate());
		JSONObject returnObject =JSONObject.fromObject(articleService.getdariys(currentPage, pageSize, starttime,endtime,keyword));
		res.setHeader("Content-Type", "text/html;charset=utf-8");
		res.getWriter().println(returnObject.toString());
	}
	//�����������(�����Ӽ�)
	@RequestMapping("getArticles.action")
	public void getArticles(HttpServletRequest req,HttpServletResponse res) throws IOException{
		JSONObject jsonObject=RequestToJson.phrase(req);
		int currentPage= Integer.parseInt(jsonObject.getString("currentPage"));
		int pageSize= Integer.parseInt(jsonObject.getString("pageSize"));
		int type=Integer.parseInt(jsonObject.getString("type"));
		String keyword=jsonObject.getString("keyword");
		JSONObject returnObject =JSONObject.fromObject(articleService.getArticles(currentPage, pageSize, type,keyword));
		res.setHeader("Content-Type", "text/html;charset=utf-8");
		res.getWriter().println(returnObject.toString());
	}
	//�����������(������)
	@RequestMapping("getCodeArticles.action")
	public void getCodeArticles(HttpServletRequest req,HttpServletResponse res) throws IOException{
		JSONObject jsonObject=RequestToJson.phrase(req);
		int currentPage= Integer.parseInt(jsonObject.getString("currentPage"));
		int pageSize= Integer.parseInt(jsonObject.getString("pageSize"));
		int type=Integer.parseInt(jsonObject.getString("type"));
		String keyword=jsonObject.getString("keyword");
		JSONObject returnObject =JSONObject.fromObject(articleService.getCodeArticles(currentPage, pageSize, type,keyword));
		res.setHeader("Content-Type", "text/html;charset=utf-8");
		res.getWriter().println(returnObject.toString());
	}
	//��������id��������
	@RequestMapping("getArticlesbyId.action")
	public void getArticlesbyId(HttpServletRequest req,HttpServletResponse res) throws IOException{
		JSONObject jsonObject=RequestToJson.phrase(req);
		int id=Integer.parseInt(jsonObject.getString("articleid"));
		JSONArray returnObject =JSONArray.fromObject(articleService.getArticlebyId(id));
		res.setHeader("Content-Type", "text/html;charset=utf-8");
		res.getWriter().println(returnObject.toString());
	}
}
