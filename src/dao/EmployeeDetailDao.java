package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.CompanyInfoBean;
import beans.DetailBean;
import beans.EmployeeRegisterBean;

/**
 * 新規登録のSQLを実行するクラス
 * 
 * @author setoakinari
 */
public class EmployeeDetailDao extends BaseDao {
	/**
	 * employee_infoに情報を登録する。
	 * 
	 * @param name 氏名
	 * @param nameHiragana 氏名(ふりがな)
	 * @param birthday 生年月日
	 * @param sex 性別
	 * @param mailAddress メールアドレス
	 * @param telephoneNumber 電話番号
	 * @param created_id 作成者ID
	 * @param login_id ログインID
	 * @throws ClassNotFoundException
	 */
	public void employeeRegisterInfo(String name, String nameHiragana, String birthday, String sex,
			String mailAddress, String telephoneNumber, String created_id, String login_id)
			throws ClassNotFoundException {

		// employee_infoに情報を登録するSQL
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
		sql.append(" telephone_number,");
		sql.append(" created_id,");
		sql.append(" modified_id");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" ?, ?, ?, ?, ?, ?, ?, ?");
		sql.append(" )");

		try {
			// DBへ接続
			open();
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// オートコミット機能を無効化
			conn.setAutoCommit(false);

			// 各プレースホルダにパラメータを設定
			pstmt.setString(1, name);
			pstmt.setString(2, nameHiragana);
			pstmt.setString(3, birthday);
			pstmt.setString(4, sex);
			pstmt.setString(5, mailAddress);
			pstmt.setString(6, telephoneNumber);
			pstmt.setString(7, login_id);
			pstmt.setString(8, login_id);

			// SQLを実行
			pstmt.executeUpdate();
			// トランザクションのコミット
			conn.commit();

		} catch (SQLException e) {
			try {
				// トランザクションのロールバック
				conn.rollback();
			} catch (SQLException e2) {
				// 接続や、SQL処理失敗時の処理
				e2.printStackTrace();
			}
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
					// オートコミット有効化
					conn.setAutoCommit(true);
					// Connectionを閉じる
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}

	/**
	 * employee_stateに情報を登録する。
	 * 
	 * @param companyInfoId 所属会社ID
	 * @param businessManager 担当管理営業
	 * @param department 事業部
	 * @param commissioningStatus 稼働状況
	 * @param hireDate 入社日
	 * @param retireDate 退職日
	 * @param status ステータス
	 * @param login_id ログインID
	 * @throws ClassNotFoundException
	 */
	public void employeeRegisterState(String companyInfoId, String businessManager, String department,
			String commissioningStatus, String hireDate, String retireDate, String status, String login_id)
			throws ClassNotFoundException {

		// 登録してある中で1番大きな社員IDをとってきて代入。
		EmployeeRegisterBean findEmpId = this.findOne();

		// employee_stateに情報を登録するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT");
		sql.append(" INTO");
		sql.append(" employee_state");
		sql.append(" (");
		sql.append(" employee_info_id,");
		sql.append(" company_info_id,");
		sql.append(" business_manager,");
		sql.append(" department,");
		sql.append(" commissioning_status,");
		sql.append(" status,");
		sql.append(" hire_date,");
		sql.append(" retire_date,");
		sql.append(" created_id,");
		sql.append(" modified_id");
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
		sql.append(" )");

		try {
			// DBへ接続
			open();
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// オートコミット機能を無効化
			conn.setAutoCommit(false);

			// 各プレースホルダにパラメータを設定
			pstmt.setInt(1, findEmpId.getEmployeeId());
			pstmt.setInt(2, Integer.parseInt(companyInfoId));
			pstmt.setString(3, businessManager);
			pstmt.setString(4, department);
			pstmt.setString(5, commissioningStatus);
			pstmt.setString(6, status);
			pstmt.setString(7, hireDate);
			pstmt.setString(8, retireDate);
			pstmt.setString(9, login_id);
			pstmt.setString(10, login_id);

			// SQLを実行
			pstmt.executeUpdate();
			// トランザクションのコミット
			conn.commit();

		} catch (SQLException e) {
			try {
				// トランザクションのロールバック
				conn.rollback();
			} catch (SQLException e2) {
				// 接続や、SQL処理失敗時の処理
				e2.printStackTrace();
			}
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
				}
				pstmt = null;
			}
			if (conn != null) {
				try {
					// オートコミット有効化
					conn.setAutoCommit(true);
					// Connectionを閉じる
					conn.close();
				} catch (SQLException e) {
				}
				conn = null;
			}
		}
	}

	/**
	 * 登録してある中で1番大きな社員IDをとってきてemployeeRegisterFindに返す
	 * 
	 * @return employeeRegisterFind
	 * @throws ClassNotFoundException
	 * 
	 */
	private EmployeeRegisterBean findOne() throws ClassNotFoundException {

		// 社員登録用Beanを初期化
		EmployeeRegisterBean employeeRegisterFind = null;

		// 登録してある中で1番大きな社員IDを取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" employee_id");
		sql.append(" FROM");
		sql.append(" employee_info");
		sql.append(" WHERE");
		sql.append(" employee_id");
		sql.append(" =");
		sql.append(" (");
		sql.append(" SELECT");
		sql.append(" MAX");
		sql.append(" (employee_id)");
		sql.append(" FROM");
		sql.append(" employee_info)");

		try {
			// DBへ接続
			open();
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());

			// SQLを実行
			rs = pstmt.executeQuery();

			// 検索結果が見つかった場合
			if (rs.next()) {
				// 社員登録用Beanを生成
				employeeRegisterFind = new EmployeeRegisterBean();
				// 社員登録用Beanに社員IDをセット
				employeeRegisterFind.setEmployeeId(rs.getInt("employee_id"));
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
		return employeeRegisterFind;
	}
	/**
	 * employee_infoの情報を更新する。
	 * 
	 * @param employeeId 社員ID
	 * @param name 名前
	 * @param nameHiragana 氏名(ふりがな)
	 * @param birthday 生年月日
	 * @param sex 性別
	 * @param mailAddress メールアドレス
	 * @param telephoneNumber 電話番号
	 * @param created_id 作成者ID
	 * @param login_id ログインID
	 * @throws ClassNotFoundException
	 */
	public void employeeUpdateInfo(String employeeId, String name, String nameHiragana, String birthday,
			String sex, String mailAddress, String telephoneNumber, String created_id, String login_id)
			throws ClassNotFoundException {

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
			// DBへ接続
			open();
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// オートコミット機能を無効化
			conn.setAutoCommit(false);

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
			// トランザクションのコミット
			conn.commit();

		} catch (SQLException e) {
			try {
				// トランザクションのロールバック
				conn.rollback();
			} catch (SQLException e2) {
				// 接続や、SQL処理失敗時の処理
				e2.printStackTrace();
			}
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
					// オートコミット有効化
					conn.setAutoCommit(true);
					// Connectionを閉じる
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
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
	 * @throws ClassNotFoundException
	 */
	public void employeeUpdateState(String employeeId, String companyInfoId, String businessManager,
			String department, String commissioningStatus, String hireDate, String retireDate, String status,
			String login_id) throws ClassNotFoundException {

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
			// DBへ接続
			open();
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
					e.printStackTrace();
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
	 * 検索した詳細情報をdetailBeanに返す
	 * 
	 * @param employeeId 社員ID
	 * @return detailBean 社員ID、氏名、氏名(ふりがな)、生年月日、性別、メールアドレス、電話番号、所属会社ID、担当管理営業、事業部、稼働状況、入社日、退職日、ステータス
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DetailBean detail(String employeeId) throws SQLException, ClassNotFoundException {

		// 詳細Beanを初期化
		DetailBean detailBean = null;

		// 詳細情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" employee_id,");
		sql.append(" name,");
		sql.append(" name_hiragana,");
		sql.append(" birthday,");
		sql.append(" sex,");
		sql.append(" mail_address,");
		sql.append(" telephone_number,");
		sql.append(" company_info_id,");
		sql.append(" business_manager,");
		sql.append(" department,");
		sql.append(" commissioning_status,");
		sql.append(" hire_date,");
		sql.append(" retire_date,");
		sql.append(" status");
		sql.append(" FROM");
		sql.append(" employee_info");
		sql.append(" INNER JOIN");
		sql.append(" employee_state");
		sql.append(" ON");
		sql.append(" employee_info.employee_id");
		sql.append(" =");
		sql.append(" employee_state.employee_info_id");
		sql.append(" WHERE");
		sql.append(" employee_id");
		sql.append(" =");
		sql.append(" ?");

		try {
			// DBへ接続
			open();
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// 1番目のプレースホルダにパラメータを設定
			pstmt.setString(1, employeeId);
			// SQLを実行
			rs = pstmt.executeQuery();

			// 検索結果が見つかった場合Beanにセットしていく。
			if (rs.next()) {
				SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");

				detailBean = new DetailBean();
				detailBean.setEmployeeId(rs.getInt("employee_id"));
				detailBean.setName(rs.getString("name"));
				detailBean.setNameHiragana(rs.getString("name_hiragana"));

				//detailBeanにフォーマットされた誕生日をセット
				String birthday = rs.getString("birthday");
				Date normalBirthday = sqlFormat.parse(birthday);
				String formatBirthday = new SimpleDateFormat("yyyy/MM/dd").format(normalBirthday);
				detailBean.setBirthday(formatBirthday);
				detailBean.setSex(rs.getString("sex"));
				detailBean.setMailAddress(rs.getString("mail_address"));
				detailBean.setTelephoneNumber(rs.getString("telephone_number"));
				detailBean.setCompanyInfoId(rs.getInt("company_info_id"));
				detailBean.setBusinessManager(rs.getString("business_manager"));
				detailBean.setDepartment(rs.getString("department"));
				detailBean.setCommissioningStatus(rs.getString("commissioning_status"));

				//detailBeanにフォーマットされた入社日をセット
				String enterDate = rs.getString("hire_date");
				Date normalEnterDate = sqlFormat.parse(enterDate);
				String formatEnterDate = new SimpleDateFormat("yyyy/MM/dd").format(normalEnterDate);
				detailBean.setEnterDate(formatEnterDate);

				//detailBeanにフォーマットされた退社日をセット
				String retireDate = rs.getString("retire_date");
				if (retireDate != null && !retireDate.equals("")) {
					Date normalRetireDate = sqlFormat.parse(retireDate);
					String formatRetireDate = new SimpleDateFormat("yyyy/MM/dd").format(normalRetireDate);
					detailBean.setRetireDate(formatRetireDate);
				} else {
					detailBean.setRetireDate(retireDate);
				}

				//detailBeanにステータスをセット
				detailBean.setStatus(rs.getString("status"));
			}
		} catch (ParseException e) {
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
		return detailBean;
	}
	/**
	 * 検索した会社IDと会社略称をcompanyInfoBeanListに返す
	 * 
	 * @return companyInfoBeanList 会社ID、会社略称
	 * @throws ClassNotFoundException
	 */
	public List<CompanyInfoBean> findCompany() throws ClassNotFoundException {
		List<CompanyInfoBean> companyInfoBeanList = new ArrayList<CompanyInfoBean>();

		// 会社情報Beanを初期化
		CompanyInfoBean companyInfoBean = null;

		// 会社IDと会社略称を情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" company_id,");
		sql.append(" abbreviation");
		sql.append(" FROM");
		sql.append(" company_info");

		try {
			// DBへ接続
			open();
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// SQLを実行
			rs = pstmt.executeQuery();

			// 検索結果が見つかった場合
			while (rs.next()) {
				// ユーザー情報に取得
				companyInfoBean = new CompanyInfoBean();
				// 会社IDをセット
				companyInfoBean.setCompanyId(rs.getInt("company_id"));
				// 会社略称をセット
				companyInfoBean.setAbbreviation(rs.getString("abbreviation"));
				// 会社IDと会社略称をリストに追加
				companyInfoBeanList.add(companyInfoBean);
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
		return companyInfoBeanList;
	}
}
