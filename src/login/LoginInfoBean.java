package login;

import java.io.Serializable;

public class LoginInfoBean implements Serializable {
	/** ログインID */
	private String loginId;
	/** パスワード */
	private String password;
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
	 * ログインIDを取得
	 * 
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * ログインIDを格納
	 * 
	 * @param loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * パスワードを取得
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを格納
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
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
