package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.entity.BookInfo;

import java.util.List;

public interface IOrderDetailService {
    /**
     * 通过订单号查询书籍列表信息
     * @param orderId 订单号
     * @return bookInfos
     */
    List<BookInfo> findBooksByOrderId(String orderId);
}
