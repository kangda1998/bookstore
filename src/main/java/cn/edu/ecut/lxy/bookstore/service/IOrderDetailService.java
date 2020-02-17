package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.entity.BookInfo;

import java.util.List;

public interface IOrderDetailService {

    List<BookInfo> findBooksByOrderId(String orderId);
}
