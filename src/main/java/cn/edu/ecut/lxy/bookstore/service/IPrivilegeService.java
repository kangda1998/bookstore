package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.common.pojo.ZTreeNode;
import cn.edu.ecut.lxy.bookstore.entity.Privilege;

import java.util.List;

public interface IPrivilegeService {

    /**
     * 得到权限所有节点
     * @return
     */
    List<ZTreeNode> getZTreeNodes();

    /**
     * 查询单一权限
     * @param privId
     * @return
     */
    BSResult findById(int privId);

    /**
     * 修改单一权限
     * @param privilege
     * @return
     */
    BSResult updatePrivilege(Privilege privilege);

    /**
     * 新增权限
     * @param privilege
     * @return
     */
    BSResult addPrivilege(Privilege privilege);

    /**
     * 删除权限
     * @param privId
     * @return
     */
    BSResult deleteById(int privId);

    /**
     * 角色权限查询
     * @param roleId
     * @return
     */
    List<ZTreeNode> getRolePrivileges(int roleId);
}
