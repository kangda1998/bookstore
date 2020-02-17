package cn.edu.ecut.lxy.bookstore.service.impl;

import cn.edu.ecut.lxy.bookstore.dao.BookCategoryMapper;
import cn.edu.ecut.lxy.bookstore.entity.BookCategory;
import cn.edu.ecut.lxy.bookstore.service.IBookCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书籍分类服务
 */
@Service
public class BookCateServiceImpl implements IBookCateService {


    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    /**
     * 查询所有书籍分类信息
     * @return list
     */
    @Override
    public List<BookCategory> getCategoryList() {
        return bookCategoryMapper.selectAll();
    }

}
