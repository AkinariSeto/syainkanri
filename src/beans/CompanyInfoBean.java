package beans;

/**
 * 会社情報Bean
 * 
 * @author setoakinari
 *
 */
public class CompanyInfoBean {
	/** 会社ID */
	private int companyId;
	/** 会社名 */
	private String companyName;
	/** 略称 */
	private String abbreviation;

	/**
	 * 会社IDを取得
	 * 
	 * @return companyId 会社ID
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * 会社IDを格納
	 * 
	 * @param companyId 会社ID
	 *            
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	/**
	 * 会社名を取得
	 * 
	 * @return companyName 会社名
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 会社名を格納
	 * 
	 * @param companyName 会社名
	 *            
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 略称を取得
	 * 
	 * @return abbreviation 略称
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * 略称を格納
	 * 
	 * @param abbreviation 略称
	 *            
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}
