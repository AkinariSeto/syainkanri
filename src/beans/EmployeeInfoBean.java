package beans;

/**
 * 社員情報Bean
 * 
 * @author setoakinari
 *
 */
public class EmployeeInfoBean {

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
	/** 削除フラグ */
	private String isDeleted;
	/** 登録日時 */
	private String createdDate;
	/** 更新日時 */
	private String modifiedDate;
	/** 登録者ID */
	private String createdId;
	/** 更新者ID */
	private String modifiedId;

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
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 生年月日格納
	 * 
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 性別を取得
	 * 
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 性別を格納
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * メールアドレスを取得
	 * 
	 * @return mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * メールアドレスを格納
	 * 
	 * @param mailAddress
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * 電話番号を取得
	 * 
	 * @return telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * 電話番号を格納
	 * 
	 * @param telephoneNumber
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * 削除フラグを取得
	 * 
	 * @return isDeleted
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 削除フラグを格納
	 * 
	 * @param isDeleted
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 登録日時を取得
	 * 
	 * @return createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * 登録日時を格納
	 * 
	 * @param createdDate
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 更新日時を取得
	 * 
	 * @return modifiedDate
	 */
	public String getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 更新日時を格納
	 * 
	 * @param modifiedDate
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 登録者IDを取得
	 * 
	 * @return createdId
	 */
	public String getCreatedId() {
		return createdId;
	}

	/**
	 * 登録者IDを格納
	 * 
	 * @param createdId
	 */
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	/**
	 * 更新者IDを取得
	 * 
	 * @return modifiedId
	 */
	public String getModifiedId() {
		return modifiedId;
	}

	/**
	 * 更新者IDを格納
	 * 
	 * @param modifiedId
	 */
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}

}
