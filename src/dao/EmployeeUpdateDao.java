package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

/**
 * 更新用のクラス
 *
 * @author setoakinari
 */
public class EmployeeUpdateDao extends BaseDao {
	/**
	 * employee_infoの情報を更新する。
	 * 
	 * @param employeeId 社員ID
	 * @param name 名前
	 * @param nameHiragana ふりがな
	 * @param birthday 誕生日
	 * @param sex 性別
	 * @param mailAddress メールアドレス
	 * @param telephoneNumber 電話番号
	 * @param created_id 作成者ID
	 * @param login_id ログインID
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void EmployeeUpdateInfo(String employeeId, String name, String nameHiragana, String birthday,
			String sex, String mailAddress, String telephoneNumber, String created_id, String login_id)
			throws SQLException, ClassNotFoundException {
		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

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
	}

	/**
	 * employee_stateの情報を更新する。
	 * 
	 * @param employeeId 社員ID
	 * @param companyInfoId 会社ID
	 * @param businessManager 管理営業
	 * @param department 事業部
	 * @param commissioningStatus 稼働状況
	 * @param hireDate 入社日
	 * @param retireDate 退職日
	 * @param status ステータス
	 * @param login_id ログインID
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void EmployeeUpdateState(String employeeId, String companyInfoId, String businessManager,
			String department, String commissioningStatus, String hireDate, String retireDate, String status,
			String login_id) throws SQLException, ClassNotFoundException {

		// 事前準備
		Class.forName(DRIVER_NAME);

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
	}
}
