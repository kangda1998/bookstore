package cn.edu.ecut.lxy.bookstore.pay;


import cn.edu.ecut.lxy.bookstore.common.utils.BSResultUtil;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;

public abstract class AbstractPay implements IPayService {

    @Override
    public BSResult pay(PayContext payContext) throws Exception {
        prepareAndPay(payContext);
        afterPay(payContext);
        return BSResultUtil.success();
    }


}
