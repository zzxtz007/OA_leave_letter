package top.haha233.oa.dal;

import top.haha233.oa.model.bo.RoleBo;
import top.haha233.oa.model.po.RolePo;

import java.util.List;

/**
 * @author Ice_Dog
 */
public interface RoleMapper {
	/**
	 * 增加角色
	 * @param role 角色模型
	 * @return 操作返回值
	 */
	int insert(RolePo role);

	/**
	 * 修改角色
	 * @param role 角色模型
	 * @return 操作返回值
	 */
	int update(RolePo role);

	/**
	 * 删除角色
	 * @param role 角色模型
	 * @return 操作返回值
	 */
	int delete(RolePo role);

	/**
	 * 根据角色模型查询角色
	 * @param role 角色模型
	 * @return 查询到的角色模型集合
	 */
	List<RoleBo> query(RolePo role);
}
