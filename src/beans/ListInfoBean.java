package beans;

/**
 * 一覧用Bean
 * 
 * @author setoakinari
 *
 */
public class ListInfoBean {

	/** 通番 */
	private int number;
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

	/**
	 * 通番を取得
	 * 
	 * @return number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 通番を格納
	 * 
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * 社員IDを取得
	 * 
	 * @return employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * 社員IDを格納
	 * 
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * 所属会社IDを取得
	 * 
	 * @return abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * 所属会社IDを格納
	 * 
	 * @param abbreviation
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * 事業部を取得
	 * 
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 事業部を格納
	 * 
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 氏名を取得
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 氏名を格納
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 氏名(ひらがな)を取得
	 * 
	 * @return nameHiragana
	 */
	public String getNameHiragana() {
		return nameHiragana;
	}

	/**
	 * 氏名(ひらがな)を格納
	 * 
	 * @param nameHiragana
	 */
	public void setNameHiragana(String nameHiragana) {
		this.nameHiragana = nameHiragana;
	}

	/**
	 * 生年月日を取得
	 * 
	 * @return birthday
	 */
	public long getBirthday() {
		return birthday;
	}

	/**
	 * 生年月日格納
	 * 
	 * @param birthday
	 */
	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}

	/**
	 * 担当管理営業を取得
	 * 
	 * @return businessManager
	 */
	public String getBusinessManager() {
		return businessManager;
	}

	/**
	 * 担当管理営業を格納
	 * 
	 * @param businessManager
	 */
	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	/**
	 * 入社日を取得
	 * 
	 * @return hireDate
	 */
	public String getHireDate() {
		return hireDate;
	}

	/**
	 * 入社日を格納
	 * 
	 * @param hireDate
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * 稼働状況を取得
	 * 
	 * @return commissioningStatus
	 */
	public String getCommissioningStatus() {
		return commissioningStatus;
	}

	/**
	 * 稼働状況を格納
	 * 
	 * @param commissioningStatus
	 */
	public void setCommissioningStatus(String commissioningStatus) {
		this.commissioningStatus = commissioningStatus;
	}
}
