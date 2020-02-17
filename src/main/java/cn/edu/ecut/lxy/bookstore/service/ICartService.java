package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.entity.custom.Cart;
import cn.edu.ecut.lxy.bookstore.entity.BookInfo;

import javax.servlet.http.HttpServletRequest;

public interface ICartService {

    /**
     * 添加到购物车
     * @param bookInfo
     * @param cart
     * @param buyNum
     * @return
     */
    BSResult addToCart(BookInfo bookInfo, Cart cart,int buyNum);

    /**
     * 清空购物车
     * @param request
     * @param sessionName
     * @return
     */
    BSResult clearCart(HttpServletRequest request,String sessionName);

    /**
     * 删除购物项
     * @param bookId
     * @param request
     * @return
     */
    BSResult deleteCartItem(int bookId, HttpServletRequest request);

    /**
     * 更新书本数量
     * @param bookId
     * @param newNum
     * @param request
     * @return
     */
    BSResult updateBuyNum(int bookId, int newNum, HttpServletRequest request);

    /**
     * 校验check，并计算总价格
     * @param cart
     * @param bookId
     * @return
     */
    BSResult checkedOrNot(Cart cart,int bookId);

}
