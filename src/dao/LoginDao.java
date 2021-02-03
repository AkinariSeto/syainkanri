package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import login.LoginInfoBean;

public class LoginDao extends BaseDao {

	

//	public LoginInfoBean findAccount(LoginInfoBean loginInfoBean) {
//
//		try {
//			Class.forName(DRIVER_NAME);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		// 戻り値の用意
//		LoginInfoBean returnLb = new LoginInfoBean();
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		// データベースへ接続
//			try{
//			// データベース接続、外部キー制約を有効にする
//			SQLiteConfig config = new SQLiteConfig();
//			config.enforceForeignKeys(true);
//			con = DriverManager.getConnection(URL, config.toProperties());
//
//			String sql = "SELECT login_id, password FROM login_info WHERE login_id = ? AND password = ?";
//			pstmt = con.prepareStatement(sql);
//
//			pstmt.setString(1, loginInfoBean.getLoginId());
//			pstmt.setString(2, loginInfoBean.getPassword());
//
////			ResultSet rs = ps.executeQuery();
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				// 見つかったアカウント情報を戻り値にセット
//				returnLb.setLoginId(rs.getString("loginId"));//ここで落ちる loginIdとpasswordがreturnLbに入っていない(null)
//				returnLb.setPassword(rs.getString("password"));
//				// returnLb.setName(rs.getString("name"));
//				// returnLb.setRole(rs.getInt("roleId"));
//			} else {
//				// アカウントがなければnullを返す
//				return null;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return returnLb;
//	}
//}

	// ログインアカウントを探す
	public LoginInfoBean findOne(String loginId, String password) throws SQLException, ClassNotFoundException {
		
		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

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
			// ドライバクラスのロード
			Class.forName(DRIVER_NAME);
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
				loginInfo.setLoginId(rs.getString("login_id"));// ログインID。
				loginInfo.setPassword(rs.getString("password"));// パスワード
			}
		} catch (SQLException e) {
			throw new SQLException("DB接続で失敗しました。");
		} finally {
			// リソースを開放
			if (rs != null) {
				try {
					// ResultSetを閉じる
					rs.close();
				} catch (SQLException e) {
				}
				rs = null;
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
		return loginInfo;
	}
}
