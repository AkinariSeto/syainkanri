package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import beans.EmployeeRegisterBean;

public class EmployeeUpdateDao extends BaseDao{

	public EmployeeRegisterBean EmployeeUpdate(String employeeId, String name, String nameHiragana, String birthday, String sex,
			String mailAddress, String telephoneNumber, String created_id, String login_id)
			throws SQLException, ClassNotFoundException {
		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 社員情報Bean
		EmployeeRegisterBean employeeUpdate = null;

		// ログインIDとパスワードからユーザー情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE");
		sql.append(" employee_info");
		sql.append(" SET");
		sql.append(" name = ?,");
		sql.append(" name_hiragana = ?,");
		sql.append(" birthday = ?,");
		sql.append(" sex = ?,");
		sql.append(" mail_address = ?,");
		sql.append(" telephone_number = ?,");
//		sql.append(" created_id = ?,");
		sql.append(" modified_id = ?");
		sql.append(" WHERE");
		sql.append(" employee_id");
		sql.append(" =");
		sql.append(" ?");

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
			pstmt.setString(1, name);
			pstmt.setString(2, nameHiragana);
			pstmt.setString(3, birthday);
			pstmt.setString(4, sex);
			pstmt.setString(5, mailAddress);
			pstmt.setString(6, telephoneNumber);
//			pstmt.setString(7, login_id);
			pstmt.setString(7, login_id);
			pstmt.setString(8, employeeId);
			// pstmt.setString(7, loginInfoBean.getLoginId());
			// pstmt.setString(8, loginInfoBean.getLoginId());

			// SQLを実行
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new SQLException(e);
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
		return employeeUpdate;
	}
	public EmployeeRegisterBean EmployeeUpdate2(String employeeId, String companyInfoId, String businessManager, String department,
			String commissioningStatus, String hireDate, String retireDate, String status, String login_id)
			throws SQLException, ClassNotFoundException {

		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//		EmployeeRegisterDao findEmpId =  new EmployeeRegisterDao();

//		EmployeeRegisterBean findEmpId2 = findEmpId.findOne();
		// 社員情報Bean
		EmployeeRegisterBean employeeUpdate2 = null;

		// ログインIDとパスワードからユーザー情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE");
		sql.append(" employee_state");
		sql.append(" SET");
//		sql.append(" employee_info_id,");
		sql.append(" company_info_id = ?,");
		sql.append(" business_manager = ?,");
		sql.append(" department = ?,");
		sql.append(" commissioning_status = ?,");
		sql.append(" status = ?,");
		sql.append(" hire_date = ?,");
		sql.append(" retire_date = ?,");
//		sql.append(" created_id = ?,");
		sql.append(" modified_id = ?");
		sql.append(" WHERE");
		sql.append(" employee_info_id");
		sql.append(" =");
		sql.append(" ?");

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
//			pstmt.setString(1, String.valueOf(findEmpId.getEmployeeId()));
//			pstmt.setInt(1, findEmpId2.getEmployeeId());
//			pstmt.setString(2, companyInfoId);
			pstmt.setInt(1, Integer.parseInt(companyInfoId));
//			pstmt.setInt(1, 1);
			pstmt.setString(2, businessManager);
			pstmt.setString(3, department);
			pstmt.setString(4, commissioningStatus);
			pstmt.setString(5, status);
			pstmt.setString(6, hireDate);
			pstmt.setString(7, retireDate);
//			pstmt.setInt(8, 88);
//			pstmt.setString(8, login_id);
			pstmt.setString(8, login_id);
			pstmt.setString(9, employeeId);

			// SQLを実行
			pstmt.executeUpdate();

		} catch (SQLException e) {
//			throw new SQLException("DB接続で失敗しました。");
			e.printStackTrace();
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
		return employeeUpdate2;
	}


}
