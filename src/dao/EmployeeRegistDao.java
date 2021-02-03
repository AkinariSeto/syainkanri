package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import beans.EmployeeRegistBean;

public class EmployeeRegistDao extends BaseDao {
	
	public EmployeeRegistBean EmployeeRegist(String name, String nameHiragana, String birthday, String sex, String mailAddress, String telephoneNumber) throws SQLException, ClassNotFoundException {
		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 社員情報Bean
		EmployeeRegistBean employeeRegist = null;

		// ログインIDとパスワードからユーザー情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT");
		sql.append(" INTO");
		sql.append(" employee_info");
		sql.append(" (");
		sql.append(" name,");
		sql.append(" name_hiragana,");
		sql.append(" birthday,");
		sql.append(" sex,");
		sql.append(" mail_address,");
		sql.append(" telephone_number");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" ?, ?, ?, ?, ?, ?");
		sql.append(" )");
		
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
			 pstmt.setString(4, mailAddress);
			 pstmt.setString(5, telephoneNumber);
			
			// SQLを実行
//			pstmt.executeUpdate();
			rs = pstmt.executeUpdate();

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
		return employeeRegist;
	}
	public EmployeeRegistBean EmployeeRegist2(String companyInfoId, String businessManager, String department, String commissioningStatus, String hireDate, String retireDate, String status) throws SQLException, ClassNotFoundException {
		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 社員情報Bean
		EmployeeRegistBean employeeRegist = null;

		// ログインIDとパスワードからユーザー情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT");
		sql.append(" INTO");
		sql.append(" employee_state");
		sql.append(" (");
		sql.append(" company_info_id,");
		sql.append(" business_manager,");
		sql.append(" department,");
		sql.append(" commissioning_status,");
		sql.append(" hire_date,");
		sql.append(" retire_date,");
		sql.append(" status");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" ?, ?, ?, ?, ?, ?, ?");
		sql.append(" )");
		
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
			 pstmt.setString(1, companyInfoId);
			 pstmt.setString(2, businessManager);
			 pstmt.setString(3, department);
			 pstmt.setString(4, commissioningStatus);
			 pstmt.setString(5, hireDate);
			 pstmt.setString(6, retireDate);
			 pstmt.setString(7, status);
			
			// SQLを実行
			pstmt.executeUpdate();
//			rs = pstmt.executeUpdate();

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
		return employeeRegist;
	}
}
