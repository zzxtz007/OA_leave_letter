package top.haha233.oa.model.bo;

import top.haha233.oa.model.po.UserPo;

import java.sql.Date;

/**
 * @author Ice_Dod
 */
public class RoleBo {
	/**
	 * id	角色id
	 */
	private Long id;

	/**
	 * name	角色名
	 */
	private String name;

	/**
	 * insert_user	创建用户名
	 */
	private UserPo insertUser;

	/**
	 * insert_time	创建时间
	 */
	private Date insertTime;

	/**
	 * update_user	修改用户名
	 */
	private UserPo updateUser;

	/**
	 * update_time	修改时间
	 */
	private Date updateTime;

	/**
	 * is_deleted	删除标记
	 */
	private Long isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserPo getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(UserPo insertUser) {
		this.insertUser = insertUser;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public UserPo getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(UserPo updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Long isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "RoleBo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", insertUser=" + insertUser +
				", insertTime=" + insertTime +
				", updateUser=" + updateUser +
				", updateTime=" + updateTime +
				", isDeleted=" + isDeleted +
				'}';
	}
}
