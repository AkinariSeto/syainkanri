package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

import beans.CompanyInfoBean;
import beans.ListInfoBean;


public class EmployeeListDao extends BaseDao {

	public List<ListInfoBean> EmployeeListInfo() throws SQLException, ClassNotFoundException {

		List<ListInfoBean> detailList = new ArrayList<ListInfoBean>();

		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 社員情報Bean
		ListInfoBean listInfoBean = null;

		//会社情報Bean
		CompanyInfoBean companyInfoBean = null;
		
		// 社員一覧情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT");
		// sql.append(" a.employee_id,");
		// sql.append(" b.company_info_id,");
		sql.append(" employee_id,");
		sql.append(" company_info_id,");
		sql.append(" department,");
		sql.append(" name,");
		sql.append(" name_hiragana,");
//		sql.append(" TIMESTAMPDIFF(YEAR, `birthday`, CURDATE()),");
//		sql.append(" (YEAR(CURDATE()) - YEAR(birthday)) - (RIGHT(CURDATE(), 5) < RIGHT(birthday, 5)),");
		sql.append(" birthday,");
		sql.append(" business_manager,");
		sql.append(" hire_date,");
		sql.append(" commissioning_status");
		// sql.append(" employee_id AS 'No.',");
		// sql.append(" company_info_id AS '会社',");
		// sql.append(" department AS '事業部',");
		// sql.append(" name AS '氏名',");
		// sql.append(" name_hiragana AS '氏名(ひらがな)',");
		// sql.append(" birthday AS '生年月日(誕生日)',");
		// sql.append(" business_manager AS '担当管理営業',");
		// sql.append(" hire_date AS '入社日',");
		// sql.append(" commissioning_status AS '稼働状況'");
		sql.append(" FROM");
		// sql.append(" employee_info a");
		sql.append(" employee_info");
		sql.append(" INNER JOIN");
		// sql.append(" employee_state b");
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
			// 1番目のプレースホルダにパラメータを設定
			// pstmt.setString(1, employeeId);
			// SQLを実行
			rs = pstmt.executeQuery();

			// 検索結果が見つかった場合
			while (rs.next()) {
				// ユーザー情報に取得
				listInfoBean = new ListInfoBean();
				listInfoBean.setEmployeeId(rs.getInt("employee_id"));// 社員ID
				CompanyInfoDao companyInfoDao = new CompanyInfoDao();
				companyInfoBean = new CompanyInfoBean();
				companyInfoBean = companyInfoDao.findCompanyInfo(rs.getString("company_info_id"));
				String companySql = companyInfoBean.getAbbreviation();
				listInfoBean.setAbbreviation(companySql);
				
				switch(rs.getInt("department")){
				case 0:
					listInfoBean.setDepartment("開発");
					break;
				case 1:
					listInfoBean.setDepartment("NW");
					break;
				case 2:
					listInfoBean.setDepartment("検証");
					break;
				case 3:
					listInfoBean.setDepartment("オフィス");
					break;
				case 4:
					listInfoBean.setDepartment("管理");
					break;
				}
				
				listInfoBean.setName(rs.getString("name"));
				listInfoBean.setNameHiragana(rs.getString("name_hiragana"));
				  // 生年月日
		        String birthdate = rs.getString("birthday");

		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		        // 生年月日を表す文字列から、LocalDateを生成
		        LocalDate localBirdhdate = LocalDate.parse(birthdate, formatter);

		        // 現在の日付を取得
		        LocalDate nowDate = LocalDate.now();

		        // 現在と生年月日の差分を年単位で算出することによって、年齢を計算する
		        long age = ChronoUnit.YEARS.between(localBirdhdate, nowDate);
				
		        listInfoBean.setBirthday(age);
		        
				listInfoBean.setBusinessManager(rs.getString("business_manager"));//
				listInfoBean.setHireDate(rs.getString("hire_date"));//
				listInfoBean.setCommissioningStatus(rs.getString("commissioning_status"));//
				if(rs.getInt("commissioning_status") == 0){
					listInfoBean.setCommissioningStatus("未稼働");
				}else{
					listInfoBean.setCommissioningStatus("稼働");
				}
				detailList.add(listInfoBean);
			}
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
		return detailList;
	}
}
