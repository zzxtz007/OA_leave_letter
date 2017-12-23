package top.haha233.oa.model.po;

import java.sql.Date;

/**
 * @author Ice_Dod
 */
public class UserPo {

	/**
	 * id	用户id
	 */
	private Long id;

	/**
	 * username	用户名
	 */
	private String username;

	/**
	 * name	姓名
	 */
	private String name;
	/**
	 * password	密码
	 */
	private String password;
	/**
	 * department_id	部门编号
	 */
	private Long departmentId;
	/**
	 * role_id	角色
	 */
	private Long roleId;
	/**
	 * last_login	最后登录时间
	 */
	private Date lastLogin;

	/**
	 * insert_user	创建用户名
	 */
	private Long insertUser;

	/**
	 * insert_time	创建时间
	 */
	private Date insertTime;

	/**
	 * update_user	修改用户名
	 */
	private Long updateUser;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Long getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(Long insertUser) {
		this.insertUser = insertUser;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
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
		return "UserPo{" +
				"id=" + id +
				", username='" + username + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", departmentId=" + departmentId +
				", roleId=" + roleId +
				", lastLogin=" + lastLogin +
				", insertUser=" + insertUser +
				", insertTime=" + insertTime +
				", updateUser=" + updateUser +
				", updateTime=" + updateTime +
				", isDeleted=" + isDeleted +
				'}';
	}
}
