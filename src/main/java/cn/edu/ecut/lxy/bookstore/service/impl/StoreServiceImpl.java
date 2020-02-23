package cn.edu.ecut.lxy.bookstore.service.impl;

import cn.edu.ecut.lxy.bookstore.common.utils.BSResultUtil;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.dao.StoreMapper;
import cn.edu.ecut.lxy.bookstore.dao.UserMapper;
import cn.edu.ecut.lxy.bookstore.entity.Store;
import cn.edu.ecut.lxy.bookstore.entity.User;
import cn.edu.ecut.lxy.bookstore.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 店铺服务
 */
@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 店铺Id查询店铺
     * @param storeId
     * @return
     */
    @Override
    public Store findById(int storeId) {
        Store store = storeMapper.selectByPrimaryKey(storeId);
        User user = userMapper.selectByPrimaryKey(store.getStoreManagerId());
        store.setStoreManagerName(user.getUsername());
        return store;
    }
    /**
     * 用户Id查询店铺
     * @param userId
     * @return
     */
    @Override
    public Store findStoreByUserId(Integer userId) {

        Example example = new Example(Store.class);
        example.createCriteria().andEqualTo("storeManagerId", userId);
        List<Store> stores = storeMapper.selectByExample(example);
        if(stores !=null && stores.size() > 0){
            return stores.get(0);
        }
        return null;
    }

    @Override
    /**
     * 查询所有店铺
     * @return
     */
    public List<Store> findStores() {
        List<Store> stores = storeMapper.selectAll();
        stores.forEach(store -> {
            User user = userMapper.selectByPrimaryKey(store.getStoreManagerId());
            if(user != null){
                store.setStoreManagerName(user.getUsername());
            }
        });
        return stores;
    }
    /**
     * 修改店铺
     * @param store
     * @return
     */
    @Override
    @Transactional
    public BSResult updateStore(Store store) {
        store.setUpdated(new Date());
        storeMapper.updateByPrimaryKeySelective(store);
        return BSResultUtil.success();
    }
    /**
     * 删除店铺
     * @param storeId
     * @return
     */
    @Override
    @Transactional
    public BSResult deleteStore(int storeId) {
        storeMapper.deleteByPrimaryKey(storeId);
        return BSResultUtil.success();
    }
    /**
     * 新增店铺
     * @param store
     * @return
     */
    @Override
    public BSResult addStore(Store store) {
        store.setCreated(new Date());
        store.setUpdated(new Date());
        storeMapper.insert(store);
        return BSResultUtil.success();
    }

}
