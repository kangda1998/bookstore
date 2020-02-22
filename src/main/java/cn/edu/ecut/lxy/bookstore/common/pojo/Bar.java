package cn.edu.ecut.lxy.bookstore.common.pojo;

import java.util.List;

/**
 * 销售图poji
 */
public class Bar {

    /**
     * 书籍列表
     */
    private List<String> bookNames;
    /**
     * 销量列表
     */
    private List<Integer> sales;

    public List<String> getBookNames() {
        return bookNames;
    }

    public void setBookNames(List<String> bookNames) {
        this.bookNames = bookNames;
    }

    public List<Integer> getSales() {
        return sales;
    }

    public void setSales(List<Integer> sales) {
        this.sales = sales;
    }
}
