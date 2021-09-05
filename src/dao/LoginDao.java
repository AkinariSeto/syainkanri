package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import beans.LoginInfoBean;

/**
 * ログインIDとパスワードからユーザー情報を取得するクラス
 * 
 * @author setoakinari
 *
 */
public class LoginDao extends BaseDao {

	/**
	 * ログインIDとパスワードを検索してloginInfoに返す
	 * 
	 * @param loginId ログインID
	 * @param password パスワード
	 * @return loginInfo ログインID、パスワード
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public LoginInfoBean findOne(String loginId, String password) throws SQLException, ClassNotFoundException {

		// 事前準備
		Class.forName(DRIVER_NAME);
		// ログイン情報Bean
		LoginInfoBean loginInfo = null;

		// ログインIDとパスワードからユーザー情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" login_id,");
		sql.append(" password");
		sql.append(" FROM");
		sql.append(" login_info");
		sql.append(" WHERE");
		sql.append(" login_id = ?");
		sql.append(" AND password = ?");

		try {
			SQLiteConfig config = new SQLiteConfig();
			// 外部キー制約を有効にする
			config.enforceForeignKeys(true);
			// Connectionを生成
			conn = DriverManager.getConnection(URL, config.toProperties());
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// 1番目のプレースホルダにパラメータを設定
			pstmt.setString(1, loginId);
			// 2番目のプレースホルダにパラメータを設定
			pstmt.setString(2, password);
			// SQLを実行
			rs = pstmt.executeQuery();

			// 検索結果が見つかった場合
			if (rs.next()) {
				// ユーザー情報に取得
				loginInfo = new LoginInfoBean();
				// loginInfoにログインIDをセット
				loginInfo.setLoginId(rs.getString("login_id"));
				// loginInfoにパスワードをセット
				loginInfo.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// リソースを開放
			if (rs != null) {
				try {
					// ResultSetを閉じる
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (pstmt != null) {
				try {
					// PreparedStatementを閉じる
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pstmt = null;
			}
			if (conn != null) {
				try {
					// Connectionを閉じる
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return loginInfo;
	}
}
