package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * データベース接続で使うスーパークラス
 * 
 * @author setoakinari
 */
public class BaseDao {

	/** DBの接続先URL */
	public final String URL = "jdbc:sqlite:/Users/setoakinari/Documents/会社関係/初級認定試験/初級認定試験/ninteishiken.sqlite";
	/** JDBCドライバ名 */
	public final String DRIVER_NAME = "org.sqlite.JDBC";
	/** Connectionを初期化 */
	public static Connection conn = null;
	/** PreparedStatementを初期化 */
	public static PreparedStatement pstmt = null;
	/** ResultSetを初期化 */
	public static ResultSet rs = null;
}
