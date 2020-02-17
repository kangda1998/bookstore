package cn.edu.ecut.lxy.bookstore.service.impl;

import cn.edu.ecut.lxy.bookstore.dao.BookInfoMapper;
import cn.edu.ecut.lxy.bookstore.dao.OrderDetailMapper;
import cn.edu.ecut.lxy.bookstore.entity.BookInfo;
import cn.edu.ecut.lxy.bookstore.entity.OrderDetail;
import cn.edu.ecut.lxy.bookstore.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单详情服务
 */
@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    /**
     * 通过订单号查询书籍列表信息
     * @param orderId 订单号
     * @return bookInfos
     */
    @Override
    public List<BookInfo> findBooksByOrderId(String orderId) {

        Example example = new Example(OrderDetail.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId", orderId);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(example);
        return orderDetails.stream()
                .map(orderDetail -> bookInfoMapper.selectByPrimaryKey(orderDetail.getBookId()))
                .collect(Collectors.toList());
    }

}
