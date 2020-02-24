package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.entity.User;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;

import java.util.List;

public interface IUserService {
    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    BSResult login(String username, String password);
    /**
     * 检查用户名是否存在
     *
     * @param username
     * @return
     */
    BSResult checkUserExistByUsername(String username);
    /**
     * 注册用户,向数据库插入一条记录
     *
     * @param user
     * @return
     */
    BSResult saveUser(User user);
    /**
     * 激活用户
     *
     * @param activeCode
     * @return
     */
    BSResult activeUser(String activeCode);

    /**
     * 用户新增
     * @param user
     * @return
     */
    User addUser(User user);

    /**
     * 用户信息修改
     * @param user
     * @return
     */
    BSResult updateUser(User user);

    /**
     * 用户删除
     * @param userId
     */
    void delUser(int userId);

    /**
     * 查询该角色Id的所有用户
     * @param roleId
     * @return
     */
    List<User> findBusinesses(int roleId);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 用户查询
     * @param userId
     * @return
     */
    User findById(int userId);
    /**
     * 修改密码
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    BSResult compareAndChange(int userId, String oldPassword, String newPassword);
}
