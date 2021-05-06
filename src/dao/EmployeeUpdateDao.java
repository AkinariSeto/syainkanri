package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import beans.EmployeeRegisterBean;

/**
 * 更新用のクラス
 *
 * @author setoakinari
 */
public class EmployeeUpdateDao extends BaseDao {
	/**
	 * employee_infoの情報を更新し、EmployeeUpdateInfoに返す
	 * 
	 * @param employeeId
	 * @param name
	 * @param nameHiragana
	 * @param birthday
	 * @param sex
	 * @param mailAddress
	 * @param telephoneNumber
	 * @param created_id
	 * @param login_id
	 * @return employeeUpdateInfo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public EmployeeRegisterBean EmployeeUpdateInfo(String employeeId, String name, String nameHiragana, String birthday,
			String sex, String mailAddress, String telephoneNumber, String created_id, String login_id)
			throws SQLException, ClassNotFoundException {
		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 社員情報更新用Beanを初期化
		EmployeeRegisterBean employeeUpdateInfo = null;

		// employee_infoの情報を更新するSQL
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

			// 各プレースホルダにパラメータを設定
			pstmt.setString(1, name);
			pstmt.setString(2, nameHiragana);
			pstmt.setString(3, birthday);
			pstmt.setString(4, sex);
			pstmt.setString(5, mailAddress);
			pstmt.setString(6, telephoneNumber);
			pstmt.setString(7, login_id);
			pstmt.setString(8, employeeId);

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
		return employeeUpdateInfo;
	}

	/**
	 * employee_stateの情報を更新し、employeeUpdateStateに返す
	 * 
	 * @param employeeId
	 * @param companyInfoId
	 * @param businessManager
	 * @param department
	 * @param commissioningStatus
	 * @param hireDate
	 * @param retireDate
	 * @param status
	 * @param login_id
	 * @return employeeUpdateState
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public EmployeeRegisterBean EmployeeUpdateState(String employeeId, String companyInfoId, String businessManager,
			String department, String commissioningStatus, String hireDate, String retireDate, String status,
			String login_id) throws SQLException, ClassNotFoundException {

		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 社員情報更新用Beanを初期化
		EmployeeRegisterBean employeeUpdateState = null;

		// employee_stateの情報を更新するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE");
		sql.append(" employee_state");
		sql.append(" SET");
		sql.append(" company_info_id = ?,");
		sql.append(" business_manager = ?,");
		sql.append(" department = ?,");
		sql.append(" commissioning_status = ?,");
		sql.append(" status = ?,");
		sql.append(" hire_date = ?,");
		sql.append(" retire_date = ?,");
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

			// 各プレースホルダにパラメータを設定
			pstmt.setInt(1, Integer.parseInt(companyInfoId));
			pstmt.setString(2, businessManager);
			pstmt.setString(3, department);
			pstmt.setString(4, commissioningStatus);
			pstmt.setString(5, status);
			pstmt.setString(6, hireDate);
			pstmt.setString(7, retireDate);
			pstmt.setString(8, login_id);
			pstmt.setString(9, employeeId);

			// SQLを実行
			pstmt.executeUpdate();

		} catch (SQLException e) {
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
		return employeeUpdateState;
	}
}
