package top.haha233.oa.model.dto;

/**
 * @author Ice_Dog
 */
public class SimpleMessageDto {
	/**
	 * id 假条id
	 */
	private Long id;
	/**
	 * userId 申请假条的人的名字
	 */
	private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "SimpleMessageDto{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				'}';
	}
}
