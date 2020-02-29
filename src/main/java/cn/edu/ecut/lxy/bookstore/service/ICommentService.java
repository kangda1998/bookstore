package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论功能 只有购买了书籍才能评论该书籍
 */
@Service
public interface ICommentService {
    /**
     * 用户评论新增
     *
     * @param comment
     * @return
     */
    BSResult addComment(Comment comment);

    /**
     * 查询该书籍的所有评论
     * @return
     */
    List<Comment> listComment(Integer bookId);

    /**
     * 删除该条评论
     * @param commentId
     * @return
     */
    BSResult deleteComment(Integer commentId);
}