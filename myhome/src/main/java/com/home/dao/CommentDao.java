package com.home.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author qpz:
 * @version ����ʱ�䣺2017��8��24�� ����7:54:35
 * �й����۵���صײ����
 */
@Repository
public class CommentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//��ҳ����comment
	public Map<String,Object> getComment(int currentPage,int pageSize){
		Map<String,Object> map=new HashMap<String, Object>();
		String sql="select *from comment order by createtime desc limit "+currentPage*pageSize+","+pageSize;
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		map.put("list", list);
		sql="select count(*) from comment";
		int count=jdbcTemplate.queryForInt(sql);
		map.put("total", count);
		return map;
	}
	//����
	public void clickUp(int id){
		String sql="update comment set clicktimes=clicktimes+1 where id="+id;
		jdbcTemplate.update(sql);
	}
	//��
	public void stepDown(int id){
		String sql="update comment set steptimes=steptimes+1 where id="+id;
		jdbcTemplate.update(sql);
	}
	//��������
	public void addcomment(String comment){
		String sql="insert into comment(content) values('"+comment+"')";
		jdbcTemplate.update(sql);
	}
}
