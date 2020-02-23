package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.entity.Store;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;

import java.util.List;

public interface IStoreService {
    /**
     * 用户Id查询店铺
     * @param userId
     * @return
     */
    Store findStoreByUserId(Integer userId);

    /**
     * 店铺Id查询店铺
     * @param storeId
     * @return
     */
    Store findById(int storeId);

    /**
     * 查询所有店铺
     * @return
     */
    List<Store> findStores();

    /**
     * 修改店铺
     * @param store
     * @return
     */
    BSResult updateStore(Store store);

    /**
     * 删除店铺
     * @param storeId
     * @return
     */
    BSResult deleteStore(int storeId);

    /**
     * 新增店铺
     * @param store
     * @return
     */
    BSResult addStore(Store store);
}
