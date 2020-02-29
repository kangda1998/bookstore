package cn.edu.ecut.lxy.bookstore.service.impl;

import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.common.utils.BSResultUtil;
import cn.edu.ecut.lxy.bookstore.dao.CommentMapper;
import cn.edu.ecut.lxy.bookstore.entity.Comment;
import cn.edu.ecut.lxy.bookstore.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 用户评论新增
     *
     * @param comment
     * @return
     */
    @Override
    public BSResult addComment(Comment comment) {
        commentMapper.insert(comment);
        return BSResultUtil.success();
    }

    @Override
    public List<Comment> listComment(Integer bookId) {
        Example example = new Example(Comment.class);

        if (!ObjectUtils.isEmpty(bookId)) {
            example.createCriteria().andEqualTo("bookId", bookId);
        }
        List<Comment> comments = commentMapper.selectByExample(example);
        return comments;
    }

    @Override
    public BSResult deleteComment(Integer commentId) {
        commentMapper.deleteByPrimaryKey(commentId);
        return BSResultUtil.success();
    }
}
