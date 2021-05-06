package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import beans.CompanyInfoBean;

/**
 * 会社情報を検索するクラス
 * 
 * @author setoakinari
 */
public class CompanyInfoDao extends BaseDao {
	/**
	 * 検索した会社情報をcompanyInfoに返す
	 * 
	 * @param companyId
	 * @return companyInfo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public CompanyInfoBean findCompanyInfo(String companyId) throws SQLException, ClassNotFoundException {
		ResultSet companyRs = null;
		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 会社情報Beanを初期化
		CompanyInfoBean companyInfo = null;

		// 会社IDから会社情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" company_id,");
		sql.append(" company_name,");
		sql.append(" abbreviation");
		sql.append(" FROM");
		sql.append(" company_info");
		sql.append(" WHERE");
		sql.append(" company_id = ?");

		try {
			SQLiteConfig config = new SQLiteConfig();
			// 外部キー制約を有効にする
			config.enforceForeignKeys(true);
			// ドライバクラスのロード
			Class.forName(DRIVER_NAME);
			// Connectionを生成
			conn = DriverManager.getConnection(URL, config.toProperties());
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// 1番目のプレースホルダにパラメータを設定
			pstmt.setString(1, companyId);

			// SQLを実行
			companyRs = pstmt.executeQuery();

			// 検索結果が見つかった場合
			if (companyRs.next()) {
				// 会社情報を生成
				companyInfo = new CompanyInfoBean();
				// 会社IDをセット
				companyInfo.setCompanyId(companyRs.getInt("company_id"));
				// 会社名をセット
				companyInfo.setCompanyName(companyRs.getString("company_name"));
				// 会社略称をセット
				companyInfo.setAbbreviation(companyRs.getString("abbreviation"));
			}
		} catch (SQLException e) {
			throw new SQLException("DB接続で失敗しました。");
		} finally {
			// リソースを開放
			if (companyRs != null) {
				try {
					// ResultSetを閉じる
					companyRs.close();
				} catch (SQLException e) {
				}
				companyRs = null;
			}
			if (pstmt != null) {
				try {
					// PreparedStatementを閉じる
					pstmt.close();
				} catch (SQLException e) {
				}
				pstmt = null;
			}
			if (conn != null) {
				try {
					// Connectionを閉じる
					conn.close();
				} catch (SQLException e) {
				}
				conn = null;
			}
		}
		return companyInfo;
	}
}
