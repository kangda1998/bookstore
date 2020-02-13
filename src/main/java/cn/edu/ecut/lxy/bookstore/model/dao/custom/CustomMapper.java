package cn.edu.ecut.lxy.bookstore.model.dao.custom;

import cn.edu.ecut.lxy.bookstore.model.entity.Privilege;
import cn.edu.ecut.lxy.bookstore.model.entity.Role;
import cn.edu.ecut.lxy.bookstore.model.entity.User;
import cn.edu.ecut.lxy.bookstore.model.entity.custom.OrderCustom;

import java.util.List;

/**
 * 自定义mapper
 */

public interface CustomMapper {

    List<OrderCustom> findOrdersByUserId(int userId);

    List<OrderCustom> findOrdersByStoreId(int storeId);

    List<Role> findRolesByUserId(int userId);

    List<Privilege> findPrivilegesByRoleId(int roleId);

    List<User> findBusinesses(int roleId);
}
