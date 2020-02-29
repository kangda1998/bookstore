package cn.edu.ecut.lxy.bookstore.service.impl;

import cn.edu.ecut.lxy.bookstore.common.utils.BSResultUtil;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.dao.RoleMapper;
import cn.edu.ecut.lxy.bookstore.dao.RolePrivilegeMapper;
import cn.edu.ecut.lxy.bookstore.dao.UserRoleMapper;
import cn.edu.ecut.lxy.bookstore.entity.Role;
import cn.edu.ecut.lxy.bookstore.entity.RolePrivilege;
import cn.edu.ecut.lxy.bookstore.entity.UserRole;
import cn.edu.ecut.lxy.bookstore.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 角色与角色权限服务
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RolePrivilegeMapper rolePrivilegeMapper;
    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> findAllRoles() {
        return roleMapper.selectAll();
    }

    /**
     * 修改用户的角色
     * @param userId
     * @param roleIds
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(cacheNames="authorizationCache",allEntries = true)
    public BSResult updateUserRoleRelationship(Integer userId, int[] roleIds) {

        if(userId != null && roleIds != null && roleIds.length != 0 ){
            Example example = new Example(UserRole.class);
            example.createCriteria().andEqualTo("userId", userId);
            userRoleMapper.deleteByExample(example);

            for (int roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(roleId);
                userRole.setCreated(new Date());
                userRole.setUpdated(new Date());
                userRoleMapper.insert(userRole);
            }
        }
        return BSResultUtil.success();
    }

    @Override
    public Role findById(int roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
    /**
     * 单一角色删除
     * @param roleId
     * @return
     */
    @Override
    @CacheEvict(cacheNames="authorizationCache",allEntries = true)
    public BSResult deleteById(int roleId) {
        //删除之前查询是否有店铺
        
        roleMapper.deleteByPrimaryKey(roleId);
        return BSResultUtil.success();
    }
    /**
     * 单一角色新增
     * @param role
     * @return
     */
    @Override
    @Transactional
    public BSResult addRole(Role role) {
        role.setCreated(new Date());
        role.setUpdated(new Date());
        roleMapper.insert(role);
        return BSResultUtil.success();
    }
    /**
     * 单一角色修改
     * @param role
     * @return
     */
    @Override
    @Transactional
    public BSResult updateRole(Role role) {
        role.setUpdated(new Date());
        roleMapper.updateByPrimaryKeySelective(role);
        return BSResultUtil.success();
    }
    /**
     * 修改角色的权限
     * @param ids
     * @param roleId
     * @return
     */
    @Override
    @CacheEvict(cacheNames="authorizationCache",allEntries = true)
    public BSResult updateRolesPrivilege(int[] ids, int roleId) {

        //先删了这个角色所对应的权限，然后再把权限树选中的权限重新写入数据库
        Example example = new Example(RolePrivilege.class);
        example.createCriteria().andEqualTo("roleId", roleId);
        rolePrivilegeMapper.deleteByExample(example);

        for (int privilegeId : ids) {
            RolePrivilege rolePrivilege = new RolePrivilege();
            rolePrivilege.setPrivilegeId(privilegeId);
            rolePrivilege.setRoleId(roleId);
            rolePrivilege.setCreated(new Date());
            rolePrivilege.setUpdated(new Date());
            rolePrivilegeMapper.insert(rolePrivilege);
        }
        return BSResultUtil.success(roleId);
    }
}
