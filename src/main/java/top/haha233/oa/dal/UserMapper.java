package top.haha233.oa.dal;

import org.apache.ibatis.annotations.Param;
import top.haha233.oa.model.bo.UserBo;
import top.haha233.oa.model.po.UserPo;

import java.util.List;

/**
 * @author Ice_Dog
 */
public interface UserMapper {
	/**
	 * 增加用户
	 *
	 * @param user 用户模型
	 * @return 操作返回值
	 */
	int insert(@Param("user")UserPo user);

	/**
	 * 修改用户
	 *
	 * @param user 用户模型
	 * @return 操作返回值
	 */
	int update(@Param("user")UserPo user);

	/**
	 * 删除用户(逻辑删)
	 *
	 * @param user 用户模型
	 * @return 操作返回值
	 */
	int delete(@Param("user")UserPo user);

	/**
	 * 根据用户模型查询用户
	 *
	 * @param user 用户模型
	 * @return 用户模型集合
	 */
	List<UserBo> query(@Param("user") UserPo user);
}
