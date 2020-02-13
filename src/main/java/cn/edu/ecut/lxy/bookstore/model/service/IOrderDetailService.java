package cn.edu.ecut.lxy.bookstore.model.service;

import cn.edu.ecut.lxy.bookstore.model.entity.BookInfo;

import java.util.List;

public interface IOrderDetailService {

    List<BookInfo> findBooksByOrderId(String orderId);
}
