package com.home.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.service.CommentService;
import com.home.utils.RequestToJson;

/**
 * @author qpz:
 * @version ����ʱ�䣺2017��8��24�� ����8:14:40
 * �������۵�action
 */
@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@RequestMapping("getCommentList.action")
	public void getCommentList(HttpServletRequest req,HttpServletResponse res) throws IOException{
		//�����ַ�ʽ�ǿ��Եģ�����ǰ�˴�������dataҪ����JSON.stringify()
		JSONObject jsonObject=RequestToJson.phrase(req);
		int currentPage= Integer.parseInt(jsonObject.getString("currentPage"));
		int pageSize= Integer.parseInt(jsonObject.getString("pageSize"));
		JSONObject returnObject =JSONObject.fromObject(commentService.getComment(currentPage, pageSize));
		res.getWriter().println(returnObject.toString());
	
	}
	@RequestMapping("clickUp.action")
	public void clickUp(HttpServletRequest req,HttpServletResponse res){
		JSONObject jsonObject=RequestToJson.phrase(req);
		int id= Integer.parseInt(jsonObject.get("id").toString());
		commentService.clickUp(id);
	}
	@RequestMapping("stepDown.action")
	public void stepDown(HttpServletRequest req,HttpServletResponse res){
		JSONObject jsonObject=RequestToJson.phrase(req);
		int id= Integer.parseInt(jsonObject.getString("id"));
		commentService.stepDown(id);
	}
	@RequestMapping("addcomment.action")
	public void addcomment(HttpServletRequest req,HttpServletResponse res){
		JSONObject jsonObject=RequestToJson.phrase(req);
		String comment= jsonObject.getString("comment");
		commentService.addcomment(comment);
	}
}
