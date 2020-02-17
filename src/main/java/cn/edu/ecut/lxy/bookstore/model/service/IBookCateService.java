package cn.edu.ecut.lxy.bookstore.model.service;

import cn.edu.ecut.lxy.bookstore.model.entity.BookCategory;

import java.util.List;

public interface IBookCateService {
    /**
     * 查询所有书籍分类信息
     * @return list
     */
    List<BookCategory> getCategoryList();
}
