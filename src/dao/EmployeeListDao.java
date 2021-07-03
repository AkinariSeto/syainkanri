package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sqlite.SQLiteConfig;

import beans.CompanyInfoBean;
import beans.Department;
import beans.ListInfoBean;

/**
 * 一覧ページに関する情報を検索するクラス
 *
 * @author setoakinari
 */
public class EmployeeListDao extends BaseDao {

	// 一覧情報Beanを初期化
	ListInfoBean listInfoBean = null;

	// 会社情報Beanを初期化
	CompanyInfoBean companyInfoBean = null;

	/**
	 * 各事業部に振り分ける
	 * 
	 * @param department
	 */
	private void departmentName(Department.dep department) {
		switch (department) {
		case Development:
			listInfoBean.setDepartment("開発");
			break;
		case Network:
			listInfoBean.setDepartment("NW");
			break;
		case Verification:
			listInfoBean.setDepartment("検証");
			break;
		case Office:
			listInfoBean.setDepartment("オフィス");
			break;
		case Management:
			listInfoBean.setDepartment("管理");
			break;
		}
	}

	/**
	 * 検索した一覧情報をdetailListに返す
	 *
	 * @return detailList 社員ID、会社ID、事業部、名前、ふりがな、誕生日、担当管理営業、入社日、稼働状況
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<ListInfoBean> EmployeeListInfo() throws SQLException, ClassNotFoundException {
		// 一覧リストを生成
		List<ListInfoBean> detailList = new ArrayList<ListInfoBean>();

		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

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
			SQLiteConfig config = new SQLiteConfig();
			// 外部キー制約を有効にする
			config.enforceForeignKeys(true);
			// ドライバクラスのロード
			Class.forName(DRIVER_NAME);
			// Connectionを生成
			conn = DriverManager.getConnection(URL, config.toProperties());
			// PreparedStatementを生成
			pstmt = conn.prepareStatement(sql.toString());
			// SQLを実行
			rs = pstmt.executeQuery();
			
			int num = 1;
			// 一覧リストの出力方法を決める
			while (rs.next()) {
				// listInfoBeanを生成
				listInfoBean = new ListInfoBean();
				// listInfoBeanに通番をセット
				listInfoBean.setNumber(num);
				num++;
				// listInfoBeanに社員IDをセット
				listInfoBean.setEmployeeId(rs.getInt("employee_id"));
				// CompanyInfoDaoを生成
				CompanyInfoDao companyInfoDao = new CompanyInfoDao();
				// companyInfoBeanを生成
				companyInfoBean = new CompanyInfoBean();
				// companyInfoBeanに会社IDをセット
				companyInfoBean = companyInfoDao.findCompanyInfo(rs.getString("company_info_id"));
				// 会社略称をlistInfoBeanにセット
				String companyAbbreviation = companyInfoBean.getAbbreviation();
				listInfoBean.setAbbreviation(companyAbbreviation);

				// 事業部を振り分ける
				// SQLからとってきた"department"をdepartmentに代入
				int department = rs.getInt("department");
				// とってきた数値を文字列に変換してdepartmentNameに代入
				Department.dep departmentName = Department.dep.valueOf(department);
				// departmentNameで振り分けて事業部をlistInfoBeanにセット
				this.departmentName(departmentName);

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
				String hireDate = rs.getString("hire_date");
				SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
	            Date normalHireDate = sqlFormat.parse(hireDate);
	            String formatHireDate = new SimpleDateFormat("yyyy/MM/dd").format(normalHireDate);
				listInfoBean.setHireDate(formatHireDate);
				
				// listInfoBeanに稼働状況をセット
				if (rs.getInt("commissioning_status") == 0) {
					listInfoBean.setCommissioningStatus("未稼働");
				} else {
					listInfoBean.setCommissioningStatus("稼働");
				}
				// detailListに情報を追加する
				detailList.add(listInfoBean);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		} catch (ParseException e) {
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
		return detailList;
	}
}
