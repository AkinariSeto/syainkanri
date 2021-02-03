package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

import beans.EmployeeInfoStateBean;

public class EmployeeInfoStateDao extends BaseDao {

	public EmployeeInfoStateBean findEmployeeInfoState(String employeeId) throws SQLException, ClassNotFoundException {

		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 社員情報Bean
		EmployeeInfoStateBean EmployeeInfoState = null;

		// ログインIDとパスワードからユーザー情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" employee_id,");
		sql.append(" FROM");
		sql.append(" employee_info");
		// sql.append(" WHERE");
		// sql.append(" login_id = ?");
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
			pstmt.setString(1, employeeId);
			// SQLを実行
			rs = pstmt.executeQuery();

			// 検索結果が見つかった場合
			if (rs.next()) {
				// ユーザー情報に取得
				EmployeeInfoState = new EmployeeInfoStateBean();
				EmployeeInfoState.setEmployeeId(rs.getInt("employee_id"));// 会社ID。
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
		return null;
	}

	public List<EmployeeInfoStateBean> findAll() {
		List<EmployeeInfoStateBean> EmployeeInfoStateBean = new ArrayList<EmployeeInfoStateBean>();

		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Connection、PreparedStatement、ResultSetを初期化
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// データベース接続、外部キー制約を有効にする
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);

			// JDBC URLを指定
			con = DriverManager.getConnection(URL, config.toProperties());
			// 送信すべきSQL文の雛形を準備
			// String sql = "SELECT * FROM employee_info AND employee_state";
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT");
			sql.append(" CompanyInfoBean,");
			sql.append(" EmployeeInfoState");
			sql.append(" FROM");
			sql.append(" employee_info");
			sql.append(" AND");
			sql.append(" employee_state");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			// 行が見つかればtrueが返る 取った情報を積み上げる。
			while (rs.next()) {
				EmployeeInfoStateBean employeeInfoStateBean = new EmployeeInfoStateBean();
				employeeInfoStateBean.setEmployeeId(rs.getInt("employee_id"));
				employeeInfoStateBean.setName(rs.getString("name"));
				employeeInfoStateBean.setNameHiragana(rs.getString("name_hiragana"));
				employeeInfoStateBean.setBirthday(rs.getString("birthday"));
				employeeInfoStateBean.setSex(rs.getString("sex"));
				employeeInfoStateBean.setMailAddress(rs.getString("mail_address"));
				employeeInfoStateBean.setTelephoneNumber(rs.getString("telephone_number"));
				employeeInfoStateBean.setIsDeleted(rs.getString("is_deleted"));
				employeeInfoStateBean.setCreatedDate(rs.getString("created_date"));
				employeeInfoStateBean.setModifiedDate(rs.getString("modified_date"));
				employeeInfoStateBean.setCreatedId(rs.getString("created_id"));
				employeeInfoStateBean.setModifiedId(rs.getString("modified_id"));
				employeeInfoStateBean.setEmployeeInfoId(rs.getInt("employee_info_id"));
				employeeInfoStateBean.setCompanyInfoId(rs.getInt("company_info_id"));
				employeeInfoStateBean.setBusinessManager(rs.getString("business_manager"));
				employeeInfoStateBean.setDepartment(rs.getString("department"));
				employeeInfoStateBean.setCommissioningStatus(rs.getString("commissioning_status"));
				employeeInfoStateBean.setStatus(rs.getString("status"));
				employeeInfoStateBean.setHireDate(rs.getString("hire_date"));
				employeeInfoStateBean.setRetireDate(rs.getString("retire_date"));
				EmployeeInfoStateBean.add(employeeInfoStateBean);
			}
		} catch (SQLException e) {
			// 接続や失敗時の処理
			e.printStackTrace();
		} finally {
			// PreparedStatement、ResultSetを閉じる
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			// データベース接続の切断
			if (con != null) {
				// Connectionを閉じる
				try {
					con.close();
				} catch (SQLException e) {
					// 切断失敗時の処理
					e.printStackTrace();
				}
			}
		}
		return EmployeeInfoStateBean;
	}
}
