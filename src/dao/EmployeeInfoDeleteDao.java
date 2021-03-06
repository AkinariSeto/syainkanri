package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import beans.ListInfoBean;

public class EmployeeInfoDeleteDao extends BaseDao {

	public void EmployeeInfoDelete(String employeeId) {

		/** PreparedStatementを初期化 */
		PreparedStatement pstmtInfo = null;
		PreparedStatement pstmtState = null;
		
		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 一覧情報Bean
		ListInfoBean listInfoBean = null;
//		Connection con = null;
		// ログインIDとパスワードからユーザー情報を取得するSQL
		StringBuilder deleteEmployeeInfo = new StringBuilder();
		deleteEmployeeInfo.append("DELETE");
		deleteEmployeeInfo.append(" FROM");
		deleteEmployeeInfo.append(" employee_info");
		deleteEmployeeInfo.append(" WHERE");
		deleteEmployeeInfo.append(" employee_id = ?");
		
		StringBuilder deleteEmployeeState = new StringBuilder();
		deleteEmployeeState.append("DELETE");
		deleteEmployeeState.append(" FROM");
		deleteEmployeeState.append(" employee_state");
		deleteEmployeeState.append(" WHERE");
		deleteEmployeeState.append(" employee_info_id = ?");
		try {
			SQLiteConfig config = new SQLiteConfig();
			// 外部キー制約を有効にする
			config.enforceForeignKeys(true);
			// Connectionを生成
			conn = DriverManager.getConnection(URL, config.toProperties());
			// 送信すべきSQL文の雛形
			pstmtInfo = conn.prepareStatement(deleteEmployeeInfo.toString());
			pstmtInfo.setString(1, employeeId);
			pstmtState = conn.prepareStatement(deleteEmployeeState.toString());
			pstmtState.setString(1, employeeId);

			pstmtState.executeUpdate();
			pstmtInfo.executeUpdate();

			
//			conn.commit();
			
		} catch (SQLException e) {
			// 接続や、SQL処理失敗時の処理
			e.printStackTrace();
		} finally {
			// データベース接続の切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// 接続失敗時の処理
					e.printStackTrace();
				}
			}
			if (pstmtInfo != null) {
				try {
					// PreparedStatementを閉じる
					pstmtInfo.close();
				} catch (SQLException e) {
				}
				pstmtInfo = null;
			}
			if (pstmtState != null) {
				try {
					// PreparedStatementを閉じる
					pstmtState.close();
				} catch (SQLException e) {
				}
				pstmtState = null;
			}
		}
	}
}
