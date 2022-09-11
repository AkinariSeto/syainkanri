package enums;
/**
 * enumクラス
 * ステータスを列挙
 * 
 * @author setoakinari
 *
 */
public class StatusEnum {

	/**
	 * ステータスのenumクラス
	 * @author setoakinari
	 *
	 */
	public enum status {
		STATUSEMPTY("", ""),
		ENROLLMENT("在籍", "0"),
		RETIREMENT("退職", "1"),
		JOINED_WAIT("入社待", "2"),
		JOINED_CANCELLATION("入社取り消し", "3");

		//ステータスの表示文字列
		private String label;
		//ステータス番号
		private String num;

		/**
		 * ステータスの表示文字列、ステータスを引数としてもたせる
		 * @param label ステータスの表示文字列
		 * @param num ステータス番号
		 */
		status(String label, String num) {
			this.label = label;
			this.num = num;
		}

		/**
		 * ステータスの表示文字列を取得
		 * @return label ステータスの表示文字列
		 */
		public String getLabel() {
			return this.label;
		}

		/**
		 * ステータス番号を取得
		 * @return num ステータス番号
		 */
		public String getNum() {
			return num;
		}
	}

	/**
	 * ステータスの番号から表示文字をかえす
	 * @param num ステータス番号
	 * @return status.getLabel() ステータスの表示文字
	 */
	public static String getStatusLabelByNum(String num) {
		for (status status : status.values()) {
			if (status.getNum().equals(num)) {
				return status.getLabel();
			}
		}
		return null;
	}
}
