package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

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
	protected Connection conn = null;
	/** PreparedStatementを初期化 */
	protected PreparedStatement pstmt = null;
	/** ResultSetを初期化 */
	protected ResultSet rs = null;

	/**
	 * DBへ接続する
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected void open() throws ClassNotFoundException, SQLException {
		// 事前準備
		Class.forName(DRIVER_NAME);
		SQLiteConfig config = new SQLiteConfig();
		// 外部キー制約を有効にする
		config.enforceForeignKeys(true);
		// Connectionを生成
		conn = DriverManager.getConnection(URL, config.toProperties());
	}
}
