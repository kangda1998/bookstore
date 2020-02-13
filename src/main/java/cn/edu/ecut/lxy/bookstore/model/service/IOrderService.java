package cn.edu.ecut.lxy.bookstore.model.service;

import cn.edu.ecut.lxy.bookstore.model.entity.User;
import cn.edu.ecut.lxy.bookstore.model.entity.custom.Cart;
import cn.edu.ecut.lxy.bookstore.model.entity.custom.OrderCustom;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.pay.PayContext;

import java.util.List;

public interface IOrderService {

    List<OrderCustom> findOrdersByUserId(int userId);

    List<OrderCustom> findOrdersByStoreId(int storeId);

    BSResult createOrder(Cart cart, User user, String express, int payMethod);

    BSResult findOrderById(String orderId);

    BSResult deleteOrder(String orderId);

    void updateOrderAfterPay(PayContext payContext);

    BSResult postOrder(String orderId);

    OrderCustom findOrderCustomById(String orderId);

    BSResult updateOrder(OrderCustom orderCustom);

    BSResult confirmReceiving(String orderId);
}
