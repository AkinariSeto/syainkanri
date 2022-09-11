package beans;

/**
 * 
 * 詳細Bean
 * 
 * @author setoakinari
 */
public class DetailBean {

	/** 社員ID */
	private int employeeId;
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
	private int companyId;
	/** 所属会社ID */
	private int companyInfoId;
	/** 担当管理営業 */
	private String businessManager;
	/** 事業部 */
	private String department;
	/** 稼働状況 */
	private String commissioningStatus;
	/** 入社日 */
	private String enterDate;
	/** 退職日 */
	private String retireDate;
	/** ステータス */
	private String status;

	/**
	 * 会社IDを取得
	 * 
	 * @return companyId 会社ID
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * 会社IDを格納
	 * 
	 * @param companyId 会社ID
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * 氏名を取得
	 * 
	 * @return name 氏名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 氏名を格納
	 * 
	 * @param name 氏名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 氏名(ひらがな)を取得
	 * 
	 * @return nameHiragana 氏名(ひらがな)
	 */
	public String getNameHiragana() {
		return nameHiragana;
	}

	/**
	 * 氏名(ひらがな)を格納
	 * 
	 * @param nameHiragana 氏名(ひらがな)
	 */
	public void setNameHiragana(String nameHiragana) {
		this.nameHiragana = nameHiragana;
	}

	/**
	 * 生年月日を取得
	 * 
	 * @return birthday 生年月日
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 生年月日格納
	 * 
	 * @param birthday 生年月日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 性別を取得
	 * 
	 * @return sex 性別
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 性別を格納
	 * 
	 * @param sex 性別
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * メールアドレスを取得
	 * 
	 * @return mailAddress メールアドレス
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * メールアドレスを格納
	 * 
	 * @param mailAddress メールアドレス
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * 電話番号を取得
	 * 
	 * @return telephoneNumber 電話番号
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * 電話番号を格納
	 * 
	 * @param telephoneNumber 電話番号
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * 社員IDを取得
	 * 
	 * @return employeeInfoId 社員ID
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * 社員IDを格納
	 * 
	 * @param employeeInfoId 社員ID
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	/**
	 * 所属会社IDを取得
	 * 
	 * @return companyInfoId 所属会社ID
	 */
	public int getCompanyInfoId() {
		return companyInfoId;
	}

	/**
	 * 所属会社IDを格納
	 * 
	 * @param companyInfoId 所属会社ID
	 */
	public void setCompanyInfoId(int companyInfoId) {
		this.companyInfoId = companyInfoId;
	}

	/**
	 * 担当管理営業を取得
	 * 
	 * @return businessManager 担当管理営業
	 */
	public String getBusinessManager() {
		return businessManager;
	}

	/**
	 * 担当管理営業を格納
	 * 
	 * @param businessManager 担当管理営業
	 */
	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	/**
	 * 事業部を取得
	 * 
	 * @return department 事業部
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 事業部を格納
	 * 
	 * @param department 事業部
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 稼働状況を取得
	 * 
	 * @return commissioningStatus 稼働状況
	 */
	public String getCommissioningStatus() {
		return commissioningStatus;
	}

	/**
	 * 稼働状況を格納
	 * 
	 * @param commissioningStatus 稼働状況
	 */
	public void setCommissioningStatus(String commissioningStatus) {
		this.commissioningStatus = commissioningStatus;
	}

	/**
	 * 入社日を取得
	 * 
	 * @return enterDate 入社日
	 */
	public String getEnterDate() {
		return enterDate;
	}

	/**
	 * 入社日を格納
	 * 
	 * @param enterDate 入社日
	 */
	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}

	/**
	 * 退職日を取得
	 * 
	 * @return retireDate 退職日
	 */
	public String getRetireDate() {
		return retireDate;
	}

	/**
	 * 退職日を格納
	 * 
	 * @param retireDate 退職日
	 */
	public void setRetireDate(String retireDate) {
		this.retireDate = retireDate;
	}

	/**
	 * ステータスを取得
	 * 
	 * @return status ステータス
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ステータスを格納
	 * 
	 * @param status ステータス
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
