package top.haha233.oa.enums;

/**
 * @author Ice_Dog
 */
public enum StatusEnum {
	/**
	 * 状态码
	 * 0 操作成功
	 * 1 未登录
	 * 2 账号密码错误
	 * 3 类型转换错误
	 * 4 传入值含有空值
	 * 5 传出数据为空
	 * 6 权限错误
	 */
	SUCCESS(0, "操作成功"), NOT_LOGIN(1, "未登录"), PWD_ERROR(2, "账号密码错误"), NUM_CHANGE(3,
			"类型转换错误"),HAVE_NULL(4, "含有空值"),POP_NULL(5, "传出数据为空"), COMP_ERROR(6, "权限错误");

	private int state;

	private String stateInfo;

	StatusEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static StatusEnum stateOf(int index) {
		for (StatusEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
