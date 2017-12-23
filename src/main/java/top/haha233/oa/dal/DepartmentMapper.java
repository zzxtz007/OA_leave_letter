package top.haha233.oa.dal;

import org.apache.ibatis.annotations.Param;
import top.haha233.oa.model.bo.DepartmentBo;
import top.haha233.oa.model.bo.RoleBo;
import top.haha233.oa.model.po.DepartmentPo;
import top.haha233.oa.model.po.RolePo;

import java.util.List;

/**
 * @author Ice_Dog
 */
public interface DepartmentMapper {
	/**
	 * 增加部门
	 * @param department 部门模型
	 * @return 操作返回值
	 */
	int insert(DepartmentPo department);

	/**
	 * 修改部门
	 * @param department 部门模型
	 * @return 操作返回值
	 */
	int update(DepartmentPo department);

	/**
	 * 删除部门
	 * @param department 部门模型
	 * @return 操作返回值
	 */
	int delete(DepartmentPo department);

	/**
	 * 根据部门模型查询部门
	 * @param department 部门模型
	 * @return 查询到的部门模型集合
	 */
	List<DepartmentBo> query(@Param("department") DepartmentPo department);
}
