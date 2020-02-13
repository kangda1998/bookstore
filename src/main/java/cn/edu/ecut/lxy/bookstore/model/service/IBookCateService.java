package cn.edu.ecut.lxy.bookstore.model.service;

import cn.edu.ecut.lxy.bookstore.model.entity.BookCategory;

import java.util.List;

public interface IBookCateService {
    List<BookCategory> getCategoryList();
}
