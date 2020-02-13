package cn.edu.ecut.lxy.bookstore.model.service;

import cn.edu.ecut.lxy.bookstore.model.entity.Store;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;

import java.util.List;

public interface IStoreService {
    Store findStoreByUserId(Integer userId);

    Store findById(int storeId);

    List<Store> findStores();

    BSResult updateStore(Store store);

    BSResult deleteStore(int storeId);

    BSResult addStore(Store store);
}
