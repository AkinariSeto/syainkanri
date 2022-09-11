package enums;
/**
 * enumクラス
 * 性別を列挙
 * 
 * @author setoakinari
 *
 */
public class SexEnum {

	/**
	 * 性別のenumクラス
	 * @author setoakinari
	 *
	 */
	public enum sex {
		MALE("男", "0"),
		FEMALE("女", "1");

		//性別の表示文字列
		private String label;
		//性別番号
		private String num;

		/**
		 * 性別の表示文字列、性別を引数としてもたせる
		 * @param label 性別の表示文字列
		 * @param num 性別番号
		 */
		sex(String label, String num) {
			this.label = label;
			this.num = num;
		}

		/**
		 * 性別の表示文字列を取得
		 * @return label 性別の表示文字列
		 */
		public String getLabel() {
			return this.label;
		}

		/**
		 * 性別番号を取得
		 * @return num 性別番号
		 */
		public String getNum() {
			return num;
		}
	}

	/**
	 * 性別の番号から表示文字をかえす
	 * @param num 性別番号
	 * @return sex.getLabel() 性別の表示文字
	 */
	public static String getSexLabelByNum(String num) {
		for (sex sex : sex.values()) {
			if (sex.getNum().equals(num)) {
				return sex.getLabel();
			}
		}
		return null;
	}
}
