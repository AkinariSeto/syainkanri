package beans;

/**
 * 一覧用Bean
 *
 * @author setoakinari
 *
 */
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
	private String enterDate;
	/** 稼働状況 */
	private String commissioningStatus;

	/**
	 * 社員IDを取得
	 *
	 * @return employeeId 社員ID
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * 社員IDを格納
	 *
	 * @param employeeId 社員ID
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * 所属会社IDを取得
	 *
	 * @return abbreviation 所属会社ID
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * 所属会社IDを格納
	 *
	 * @param abbreviation 所属会社ID
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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
	public long getBirthday() {
		return birthday;
	}

	/**
	 * 生年月日格納
	 *
	 * @param birthday 生年月日
	 */
	public void setBirthday(long birthday) {
		this.birthday = birthday;
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
}
