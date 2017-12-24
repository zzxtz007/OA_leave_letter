package top.haha233.oa.model.dto;

import java.sql.Date;

/**
 * 处理假条的业务逻辑
 *
 * @author Ice_Dog
 */
public class LeaveLetterDto {
	/**
	 * id 假条id
	 */
	private Long id;
	/**
	 * message 假条信息
	 */
	private String message;

	/**
	 * userId 申请假条的人的id
	 */
	private Long userId;
	/**
	 * userId 申请假条的人的名字
	 */
	private String userName;

	/**
	 * start_time 申请开始时间
	 */
	private Date startTime;

	/**
	 * start_time 申请结束时间
	 */
	private Date endTime;

	/**
	 * checkId 处理假条的人的id
	 */
	private Long checkId;

	/**
	 * checkId 处理假条的人的名字
	 */
	private String checkName;

	/**
	 * checkId 假条的状态
	 */
	private Integer status;

	/**
	 * checkId 处理假条的信息
	 */
	private String feedback;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Long getCheckId() {
		return checkId;
	}

	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
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

	@Override
	public String toString() {
		return "LeaveLetterDto{" +
				"id=" + id +
				", message='" + message + '\'' +
				", userId=" + userId +
				", userName='" + userName + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", checkId=" + checkId +
				", checkName='" + checkName + '\'' +
				", status='" + status + '\'' +
				", feedback='" + feedback + '\'' +
				'}';
	}
}
