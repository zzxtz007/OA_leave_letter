package top.haha233.oa.model.dto;

/**
 * 处理登录业务逻辑
 *
 * @author Ice_Dog
 */
public class LoginDto {
	private Long id;
	private String name;
	private Long roleId;
	private String roleName;
	private Long departmentId;
	private String departmentName;

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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "LoginDto{" +
				"id=" + id +
				", name='" + name + '\'' +
				", roleId=" + roleId +
				", roleName='" + roleName + '\'' +
				", departmentId=" + departmentId +
				", departmentName='" + departmentName + '\'' +
				'}';
	}
}
