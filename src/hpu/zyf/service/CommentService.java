package hpu.zyf.service;

import java.util.List;

import hpu.zyf.entity.Comment;
import hpu.zyf.entity.vo.CommentCustom;

/**
 * ��Ʒ������
 * ͨ����Ʒid��ѯ������Ϣ
 * ͨ������idɾ������
 * ���������Ϣ
 * @author admin
 */
public interface CommentService {
	//�������ۣ������û�֧������Ʒ����ܹ�ȥ����
	boolean addComment(Comment comment)throws Exception;
	//ɾ������
	boolean deleteComment(String commentid)throws Exception;
	//��ѯ����
	List<CommentCustom> selectCommentBypdid(String pdid)throws Exception;
}
