package enums;

/**
 * enumクラス
 * 稼働状況を列挙
 * 
 * @author setoakinari
 *
 */
public class CommissioningStatusEnum {

	/**
	 * 稼働状況のenumクラス
	 * @author setoakinari
	 *
	 */
	public enum commissioningStatus {
		RUNNING("稼働", "1"),
		NOT_RUNNING("未稼働", "0");

		//稼働状況の表示文字列
		private String label;
		//稼働状況番号
		private String num;

		/**
		 * 稼働状況の表示文字列、稼働状況を引数としてもたせる
		 * @param label 稼働状況の表示文字列
		 * @param num 稼働状況番号
		 */
		commissioningStatus(String label, String num) {
			this.label = label;
			this.num = num;
		}

		/**
		 * 稼働状況の表示文字列を取得
		 * @return label 稼働状況の表示文字列
		 */
		public String getLabel() {
			return this.label;
		}

		/**
		 * 稼働状況番号を取得
		 * @return num 稼働状況番号
		 */
		public String getNum() {
			return num;
		}
	}

	/**
	 * 稼働状況の番号から表示文字をかえす
	 * @param num 稼働状況番号
	 * @return commissioningStatus.getLabel() 稼働状況の表示文字
	 */
	public static String commissioningStatusName(String num) {
		for (commissioningStatus commissioningStatus : commissioningStatus.values()) {
			if (commissioningStatus.getNum().equals(num)) {
				return commissioningStatus.getLabel();
			}
		}
		return null;
	}
}
