package beans;

import java.io.Serializable;

/**
 * ログインBean
 * 
 * @author setoakinari
 */
public class LoginInfoBean implements Serializable {
	/** ログインID */
	private String loginId;

	/**
	 * ログインIDを取得
	 * 
	 * @return loginId ログインID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * ログインIDを格納
	 * 
	 * @param loginId ログインID
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
