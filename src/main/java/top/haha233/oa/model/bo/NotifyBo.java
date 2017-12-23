package top.haha233.oa.model.bo;

import top.haha233.oa.model.po.UserPo;

import java.sql.Date;

/**
 * @author Ice_Dog
 */
public class NotifyBo {
	/**
	 * id	通知id
	 */
	private Long id;
	/**
	 * message	通知信息
	 */
	private String message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		return "NotifyBo{" +
				"id=" + id +
				", message='" + message + '\'' +
				", insertUser=" + insertUser +
				", insertTime=" + insertTime +
				", updateUser=" + updateUser +
				", updateTime=" + updateTime +
				", isDeleted=" + isDeleted +
				'}';
	}
}
