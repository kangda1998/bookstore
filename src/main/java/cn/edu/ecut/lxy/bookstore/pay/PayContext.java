package cn.edu.ecut.lxy.bookstore.pay;

import cn.edu.ecut.lxy.bookstore.model.entity.BookInfo;
import cn.edu.ecut.lxy.bookstore.model.entity.Orders;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PayContext {

    private Orders orders;

    private List<BookInfo> bookInfos;

    private HttpServletResponse response;

    public List<BookInfo> getBookInfos() {
        return bookInfos;
    }

    public void setBookInfos(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
