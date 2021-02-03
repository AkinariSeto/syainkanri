package beans;

public class ListInfoBean {
	/** 社員ID */
	private int employeeId;
	/** 所属会社ID */
	private String abbreviation;
	/** 事業部 */
	private String department;
	/** 氏名 */
	private String name;
	/** 氏名(ひらがな) */
	private String nameHiragana;
	/** 誕生日 */
	private long birthday;
	/** 担当管理営業 */
	private String businessManager;
	/** 入社日 */
	private String hireDate;
	/** 稼働状況 */
	private String commissioningStatus;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameHiragana() {
		return nameHiragana;
	}

	public void setNameHiragana(String nameHiragana) {
		this.nameHiragana = nameHiragana;
	}

	public long getBirthday() {
		return birthday;
	}

	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}

	public String getBusinessManager() {
		return businessManager;
	}

	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getCommissioningStatus() {
		return commissioningStatus;
	}

	public void setCommissioningStatus(String commissioningStatus) {
		this.commissioningStatus = commissioningStatus;
	}

}
