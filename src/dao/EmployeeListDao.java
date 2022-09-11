package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.CompanyInfoBean;
import beans.ListInfoBean;
import enums.CommissioningStatusEnum;
import enums.DepartmentEnum;

/**
 * 一覧ページに関する情報を検索するクラス
 *
 * @author setoakinari
 */
public class EmployeeListDao extends BaseDao {

	ListInfoBean listInfoBean = null;

	CompanyInfoBean companyInfoBean = null;

	/**
	 * 検索した一覧情報をdetailListに返す
	 *
	 * @return detailList 社員ID、会社ID、事業部、氏名、氏名(ふりがな)、生年月日、担当管理営業、入社日、稼働状況
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<ListInfoBean> employeeListInfo() throws SQLException, ClassNotFoundException {

		List<ListInfoBean> detailList = new ArrayList<ListInfoBean>();

		// 社員一覧情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" employee_id,");
		sql.append(" company_info_id,");
		sql.append(" department,");
		sql.append(" name,");
		sql.append(" name_hiragana,");
		sql.append(" birthday,");
		sql.append(" business_manager,");
		sql.append(" hire_date,");
		sql.append(" commissioning_status");
		sql.append(" FROM");
		sql.append(" employee_info");
		sql.append(" INNER JOIN");
		sql.append(" employee_state");
		sql.append(" ON");
		sql.append(" employee_info.employee_id");
		sql.append(" =");
		sql.append(" employee_state.employee_info_id;");

		try {
			// DBへ接続
			open();
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// SQLを実行
			rs = pstmt.executeQuery();
			// 一覧リストの出力方法を決める
			while (rs.next()) {
				listInfoBean = new ListInfoBean();
				// listInfoBeanに社員IDをセット
				listInfoBean.setEmployeeId(rs.getInt("employee_id"));
				companyInfoBean = new CompanyInfoBean();
				// companyInfoBeanに会社IDをセット
				companyInfoBean = this.findCompanyInfo(rs.getString("company_info_id"));
				// 会社略称をlistInfoBeanにセット
				String companyAbbreviation = companyInfoBean.getAbbreviation();
				listInfoBean.setAbbreviation(companyAbbreviation);

				// listInfoBeanに事業部をセット
				listInfoBean.setDepartment(DepartmentEnum.departmentName(rs.getString("department")));

				// listInfoBeanに名前をセット
				listInfoBean.setName(rs.getString("name"));
				// listInfoBeanにふりがなをセット
				listInfoBean.setNameHiragana(rs.getString("name_hiragana"));

				// 生年月日
				String birthdate = rs.getString("birthday");
				// 生年月日のフォーマットを決める
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				// 生年月日を表す文字列から、LocalDateを生成
				LocalDate localBirthDate = LocalDate.parse(birthdate, formatter);
				// 現在の日付を取得
				LocalDate nowDate = LocalDate.now();
				// 現在と生年月日の差分を年単位で算出することによって、年齢を計算する
				long age = ChronoUnit.YEARS.between(localBirthDate, nowDate);
				// listInfoBeanに年齢をセット
				listInfoBean.setBirthday(age);

				// listInfoBeanに担当営業をセット
				listInfoBean.setBusinessManager(rs.getString("business_manager"));

				// listInfoBeanに入社日をセット
				String enterDate = rs.getString("hire_date");
				SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date normalEnterDate = sqlFormat.parse(enterDate);
				String formatEnterDate = new SimpleDateFormat("yyyy/MM/dd").format(normalEnterDate);
				listInfoBean.setEnterDate(formatEnterDate);

				// listInfoBeanに稼働状況をセット
				listInfoBean.setCommissioningStatus(CommissioningStatusEnum.commissioningStatusName(rs.getString("commissioning_status")));

				// detailListに情報を追加する
				detailList.add(listInfoBean);
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
		return detailList;
	}
	/**
	 * employee_info、employee_stateの会社IDをそれぞれ削除する
	 *
	 * @param employeeId 社員ID
	 * @throws ClassNotFoundException
	 *
	 */
	public void employeeInfoDelete(String employeeId) throws ClassNotFoundException {

		// PreparedStatementを初期化
		PreparedStatement pstmtInfo = null;
		PreparedStatement pstmtState = null;

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
			// DBへ接続
			open();
			// オートコミット機能を無効化
			conn.setAutoCommit(false);
			// 送信すべきSQL文の雛形
			pstmtInfo = conn.prepareStatement(deleteEmployeeInfo.toString());
			pstmtInfo.setString(1, employeeId);
			pstmtState = conn.prepareStatement(deleteEmployeeState.toString());
			pstmtState.setString(1, employeeId);
			// 子キーのIDを削除
			pstmtState.executeUpdate();
			// 親キーのIDを削除
			pstmtInfo.executeUpdate();
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
			if (pstmtInfo != null) {
				try {
					// PreparedStatementを閉じる
					pstmtInfo.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pstmtInfo = null;
			}
			if (pstmtState != null) {
				try {
					// PreparedStatementを閉じる
					pstmtState.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pstmtState = null;
			}
			// データベース接続の切断
			if (conn != null) {
				try {
					// オートコミット有効化
					conn.setAutoCommit(true);
					// データベース接続の切断
					conn.close();
				} catch (SQLException e) {
					// 接続失敗時の処理
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 検索した会社情報をcompanyInfoに返す
	 *
	 * @param companyId 会社ID
	 * @return companyInfo 所属会社ID、会社名、略称
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public CompanyInfoBean findCompanyInfo(String companyId) throws SQLException, ClassNotFoundException {
		ResultSet companyRs = null;

		// 会社情報Beanを初期化
		CompanyInfoBean companyInfo = null;

		// 会社IDから会社情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		sql.append(" company_id,");
		sql.append(" company_name,");
		sql.append(" abbreviation");
		sql.append(" FROM");
		sql.append(" company_info");
		sql.append(" WHERE");
		sql.append(" company_id = ?");

		try {
			// DBへ接続
			open();
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// 1番目のプレースホルダにパラメータを設定
			pstmt.setString(1, companyId);

			// SQLを実行
			companyRs = pstmt.executeQuery();

			// 検索結果が見つかった場合
			if (companyRs.next()) {
				companyInfo = new CompanyInfoBean();
				// 会社IDをセット
				companyInfo.setCompanyId(companyRs.getInt("company_id"));
				// 会社名をセット
				companyInfo.setCompanyName(companyRs.getString("company_name"));
				// 会社略称をセット
				companyInfo.setAbbreviation(companyRs.getString("abbreviation"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// リソースを開放
			if (companyRs != null) {
				try {
					// ResultSetを閉じる
					companyRs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				companyRs = null;
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
		return companyInfo;
	}
}
