package beans;

/**
 * 
 * 社員状況ビーンズ
 */
public class EmployeeStateBean {
	/** 社員ID */
	private int employeeInfoId;
	/** 所属会社ID */
	private int companyInfoId;
	/** 担当管理営業 */
	private String businessManager;
	/** 事業部 */
	private String department;
	/** 稼働状況 */
	private String commissioningStatus;
	/** ステータス */
	private String status;
	/** 入社日 */
	private String hireDate;
	/** 退職日 */
	private String retireDate;
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
	 * @return employeeInfoId
	 */
	public int getEmployeeInfoId() {
		return employeeInfoId;
	}

	/**
	 * 社員IDを格納
	 * 
	 * @param employeeInfoId
	 */
	public void setEmployeeInfoId(int employeeInfoId) {
		this.employeeInfoId = employeeInfoId;
	}

	/**
	 * 所属会社IDを取得
	 * 
	 * @return companyInfoId
	 */
	public int getCompanyInfoId() {
		return companyInfoId;
	}

	/**
	 * 所属会社IDを格納
	 * 
	 * @param companyInfoId
	 */
	public void setCompanyInfoId(int companyInfoId) {
		this.companyInfoId = companyInfoId;
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

	/**
	 * ステータスを取得
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ステータスを格納
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * 退職日を取得
	 * 
	 * @return retireDate
	 */
	public String getRetireDate() {
		return retireDate;
	}

	/**
	 * 退職日を格納
	 * 
	 * @param retireDate
	 */
	public void setRetireDate(String retireDate) {
		this.retireDate = retireDate;
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
