package top.haha233.oa.dal;

import org.apache.ibatis.annotations.Param;
import top.haha233.oa.model.bo.LeaveLetterBo;
import top.haha233.oa.model.po.LeaveLetterPo;

import java.util.List;

/**
 * @author Ice_Dog
 */
public interface LeaveLetterMapper {
	/**
	 * 增加假条
	 * @param leaveLetter 假条模型
	 * @return 操作的返回值
	 */
	int insert(@Param("leaveLetter")LeaveLetterPo leaveLetter);

	/**
	 * 修改假条
	 * @param leaveLetter 假条模型
	 * @return 操作的返回值
	 */
	int update(@Param("leaveLetter")LeaveLetterPo leaveLetter);

	/**
	 * 删除假条
	 * @param leaveLetter 假条模型
	 * @return 操作的返回值
	 */
	int delete(@Param("leaveLetter")LeaveLetterPo leaveLetter);

	/**
	 * 根据假条模型查询假条
	 * @param leaveLetter 假条模型
	 * @return 查询到的假条模型集合
	 */
	List<LeaveLetterBo> query(@Param("leaveLetter") LeaveLetterPo leaveLetter);
}
