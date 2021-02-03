package beans;

public class EmployeeRegistBean {

	/** 氏名 */
	private String name;
	/** 氏名(ひらがな) */
	private String nameHiragana;
	/** 誕生日 */
	private String birthday;
	/** 性別 */
	private String sex;
	/** メールアドレス */
	private String mailAddress;
	/** 電話番号 */
	private String telephoneNumber;
	/** 所属会社ID */
	private int companyInfoId;
	/** 担当管理営業 */
	private String businessManager;
	/** 事業部 */
	private String department;
	/** 稼働状況 */
	private String commissioningStatus;
	/** 入社日 */
	private String hireDate;
	/** 退職日 */
	private String retireDate;
	/** ステータス */
	private String status;

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public int getCompanyInfoId() {
		return companyInfoId;
	}

	public void setCompanyInfoId(int companyInfoId) {
		this.companyInfoId = companyInfoId;
	}

	public String getBusinessManager() {
		return businessManager;
	}

	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCommissioningStatus() {
		return commissioningStatus;
	}

	public void setCommissioningStatus(String commissioningStatus) {
		this.commissioningStatus = commissioningStatus;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getRetireDate() {
		return retireDate;
	}

	public void setRetireDate(String retireDate) {
		this.retireDate = retireDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
