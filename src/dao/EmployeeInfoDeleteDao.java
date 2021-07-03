package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

/**
 * 
 * 削除を行うクラス
 * 
 * @author setoakinari
 */
public class EmployeeInfoDeleteDao extends BaseDao {
	/**
	 * employee_info、employee_stateの会社IDをそれぞれ削除する
	 * 
	 * @param employeeId 社員ID
	 */
	public void EmployeeInfoDelete(String employeeId) {

		// PreparedStatementを初期化
		PreparedStatement pstmtInfo = null;
		PreparedStatement pstmtState = null;

		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 主キーのIDを削除するSQL
		StringBuilder deleteEmployeeInfo = new StringBuilder();
		deleteEmployeeInfo.append("DELETE");
		deleteEmployeeInfo.append(" FROM");
		deleteEmployeeInfo.append(" employee_info");
		deleteEmployeeInfo.append(" WHERE");
		deleteEmployeeInfo.append(" employee_id = ?");

		// 子キーのIDを削除するSQL
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
			// 子キーのIDを削除
			pstmtState.executeUpdate();
			// 親キーのIDを削除
			pstmtInfo.executeUpdate();

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
