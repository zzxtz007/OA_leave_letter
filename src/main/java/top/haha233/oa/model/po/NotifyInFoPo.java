package top.haha233.oa.model.po;

import java.sql.Date;

public class NotifyInFoPo {
	/**
	 * id	通知详情id
	 */
	private Long id;
	/**
	 * notify_id	通知id
	 */
	private Long notifyId;
	/**
	 * department_id	通知部门id
	 */
	private Long departmentId;

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

	public Long getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(Long notifyId) {
		this.notifyId = notifyId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
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
		return "NotifyInFoPo{" +
				"id=" + id +
				", notifyId=" + notifyId +
				", departmentId=" + departmentId +
				", insertUser=" + insertUser +
				", insertTime=" + insertTime +
				", updateUser=" + updateUser +
				", updateTime=" + updateTime +
				", isDeleted=" + isDeleted +
				'}';
	}
}
