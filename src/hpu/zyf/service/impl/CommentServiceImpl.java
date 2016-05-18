package hpu.zyf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hpu.zyf.entity.Comment;
import hpu.zyf.entity.vo.CommentCustom;
import hpu.zyf.mapper.CommentMapper;
import hpu.zyf.service.CommentService;
/**
 * 商品评论的实现类
 * 添加评论，删除评论和查询评论
 * @author admin
 *
 */
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper cm;
	@Override
	public boolean addComment(Comment comment) throws Exception {
		if(cm.insert(comment)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteComment(String commentid) throws Exception {
		if(cm.deleteByPrimaryKey(commentid)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<CommentCustom> selectCommentBypdid(String pdid) throws Exception {
		return cm.selectBypdid(pdid);
	}

}
