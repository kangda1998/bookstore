package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.common.pojo.ZTreeNode;
import cn.edu.ecut.lxy.bookstore.entity.Privilege;

import java.util.List;

public interface IPrivilegeService {


    List<ZTreeNode> getZTreeNodes();

    BSResult findById(int privId);

    BSResult updatePrivilege(Privilege privilege);

    BSResult addPrivilege(Privilege privilege);

    BSResult deleteById(int privId);

    List<ZTreeNode> getRolePrivileges(int roleId);
}
