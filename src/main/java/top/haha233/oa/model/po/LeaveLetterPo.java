package top.haha233.oa.model.po;


import java.sql.Date;

/**
 * @author Ice_Dog
 */
public class LeaveLetterPo {
	/**
	 * id	假条id
	 */
	private Long id;

	/**
	 * message	假条信息
	 */
	private String message;
	/**
	 * user_id	请假者id
	 */
	private Long userId;
	/**
	 * check_id	审核者id
	 */
	private Long checkId;
	/**
	 * status	假条状态
	 */
	private Integer status;
	/**
	 * feedback	反馈
	 */
	private String feedback;
	/**
	 * start_time	请假开始时间
	 */
	private Date startTime;
	/**
	 * end_time	请假结束时间
	 */
	private Date endTime;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCheckId() {
		return checkId;
	}

	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
		return "LeaveLetterPo{" +
				"id=" + id +
				", message='" + message + '\'' +
				", userId=" + userId +
				", checkId=" + checkId +
				", status=" + status +
				", feedback='" + feedback + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", insertUser=" + insertUser +
				", insertTime=" + insertTime +
				", updateUser=" + updateUser +
				", updateTime=" + updateTime +
				", isDeleted=" + isDeleted +
				'}';
	}
}
