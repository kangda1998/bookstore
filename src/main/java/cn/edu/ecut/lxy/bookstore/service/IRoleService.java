package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.entity.Role;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;

import java.util.List;

public interface IRoleService {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAllRoles();

    /**
     * 修改用户的角色
     * @param userId
     * @param roleIds
     * @return
     */
    BSResult updateUserRoleRelationship(Integer userId, int[] roleIds);

    /**
     * 单一角色查询
     * @param roleId
     * @return
     */
    Role findById(int roleId);

    /**
     * 单一角色删除
     * @param roleId
     * @return
     */
    BSResult deleteById(int roleId);

    /**
     * 单一角色新增
     * @param role
     * @return
     */
    BSResult addRole(Role role);

    /**
     * 单一角色修改
     * @param role
     * @return
     */
    BSResult updateRole(Role role);

    /**
     * 修改角色的权限
     * @param ids
     * @param roleId
     * @return
     */
    BSResult updateRolesPrivilege(int[] ids, int roleId);
}

