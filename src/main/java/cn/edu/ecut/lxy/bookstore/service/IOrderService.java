package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.entity.User;
import cn.edu.ecut.lxy.bookstore.entity.custom.Cart;
import cn.edu.ecut.lxy.bookstore.entity.custom.OrderCustom;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.pay.PayContext;

import java.util.List;

public interface IOrderService {
    /**
     * 用户查询订单
     * @param userId
     * @return
     */
    List<OrderCustom> findOrdersByUserId(int userId);
    /**
     * 店铺查询订单
     * @param storeId
     * @return
     */
    List<OrderCustom> findOrdersByStoreId(int storeId);

    /**
     * 创建订单
     * @param cart
     * @param user
     * @param express
     * @param payMethod
     * @return
     */
    BSResult createOrder(Cart cart, User user, String express, int payMethod);
    /**
     * 通过订单号查询订单
     * @param orderId
     * @return
     */
    BSResult findOrderById(String orderId);
    /**
     * 通过订单号删除订单
     * @param orderId
     * @return
     */
    BSResult deleteOrder(String orderId);
    /**
     * 支付后更新订单
     * @param payContext
     */
    void updateOrderAfterPay(PayContext payContext);
    /**
     * 订单发货
     * @param orderId
     * @return
     */
    BSResult postOrder(String orderId);

    /**
     * 获得自定义Order实体，包括订单物流信息，订单详情
     * @param orderId
     * @return
     */
    OrderCustom findOrderCustomById(String orderId);

    /**
     * 根据自定义Order实体更新订单
     * @param orderCustom
     * @return
     */
    BSResult updateOrder(OrderCustom orderCustom);

    /**
     * 确认收货
     * @param orderId
     * @return
     */
    BSResult confirmReceiving(String orderId);
}
