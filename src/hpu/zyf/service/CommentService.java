package hpu.zyf.service;

import java.util.List;

import hpu.zyf.entity.Comment;
import hpu.zyf.entity.vo.CommentCustom;

/**
 * 商品的评论
 * 通过商品id查询评论信息
 * 通过评论id删除评论
 * 添加评论信息
 * @author admin
 */
public interface CommentService {
	//发布评论，这里用户支付该商品后才能够去评论
	boolean addComment(Comment comment)throws Exception;
	//删除评论
	boolean deleteComment(String commentid)throws Exception;
	//查询评论
	List<CommentCustom> selectCommentBypdid(String pdid)throws Exception;
}
