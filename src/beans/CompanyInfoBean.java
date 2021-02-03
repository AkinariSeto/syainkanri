package beans;

public class CompanyInfoBean {
	/** 会社ID */
	private int companyId;
	/** 会社名 */
	private String companyName;
	/** 略称 */
	private String abbreviation;
	/** 削除フラグ */
	private String isDeleted;
	/** 登録日時 */
	private String createDate;
	/** 更新日時 */
	private String modifiedDate;
	/** 登録者ID */
	private String createId;
	/** 更新者ID */
	private String modifiedId;

	/**
	 * 会社IDを取得
	 * 
	 * @return companyId
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * 会社IDを格納
	 * 
	 * @param companyId
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	/**
	 * 会社名を取得
	 * 
	 * @return companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 会社名を格納
	 * 
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 略称を取得
	 * 
	 * @return abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * 略称を格納
	 * 
	 * @param abbreviation
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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
	 * 
	 * 登録日時を取得
	 * 
	 * @return createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 登録日時を格納
	 * 
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	 * @return createId
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * 登録者IDを格納
	 * 
	 * @param createId
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
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
