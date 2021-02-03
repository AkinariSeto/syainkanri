package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import beans.ListInfoBean;

public class EmployeeInfoDeleteDao extends BaseDao {

	public void EmployeeInfoDelete(String employeeId) {

		// 事前準備
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 一覧情報Bean
		ListInfoBean listInfoBean = null;
		Connection con = null;
		// ログインIDとパスワードからユーザー情報を取得するSQL
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE");
		sql.append(" FROM");
		sql.append(" employee_info");
		sql.append(" WHERE");
		sql.append(" employee_id = ?");
		try {
			SQLiteConfig config = new SQLiteConfig();
			// 外部キー制約を有効にする
			config.enforceForeignKeys(true);
			// Connectionを生成
			con = DriverManager.getConnection(URL, config.toProperties());
			// 送信すべきSQL文の雛形
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			// 雛形に値を流し込みSQL文を組み立てて送信する
			pstmt.setString(1, employeeId);
			int r = pstmt.executeUpdate();
//			if (rs.next()) {
//				listInfoBean = new ListInfoBean();
//				listInfoBean.setEmployeeId(rs.getInt("employee_id"));
//			}
//			rs.close();
			
			
			
//			   while(rs.next()){
//	                Bean empBean = new Bean();
//	                empBean.setEmpId(rs.getString("emp_id"));
//	                empBean.setEmpName(rs.getString("emp_name"));
//	                if(rs.getInt("gender") == 1){
//	                    empBean.setGender("男性");
//	                } else {
//	                    empBean.setGender("女性");
//	                }
//
//	                beanList.add(empBean);
//	            }
			
			
			// 処理結果を判定する
//			if (r != 0) {
//				System.out.println(r + "件のデータを削除しました");
//			} else {
//				System.out.println("該当のデータは存在しませんでした");
//			}
			pstmt.close();

		} catch (SQLException e) {
			// 接続や、SQL処理失敗時の処理
			e.printStackTrace();
		} finally {
			// データベース接続の切断
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// 接続失敗時の処理
					e.printStackTrace();
				}
			}
		}
	}
}
