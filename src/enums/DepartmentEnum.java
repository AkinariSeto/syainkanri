package enums;

/**
 * enumクラス
 * 事業部を列挙
 * 
 * @author setoakinari
 *
 */
public class DepartmentEnum {
	/**
	 * 事業部のenumクラス
	 * 
	 * @author setoakinari
	 *
	 */
	public enum dep {
		EMPTYDEP("", ""),
		DEVELOPMENT("開発", "0"),
		NETWORK("NW", "1"),
		VERIFICATION("検証", "2"),
		OFFICE("オフィス","3"),
		MANAGEMENT("管理", "4");

		//事業部の表示文字列
		private String label;
		//事業部番号
		private String num;

		/**
		 * 事業部の表示文字列、事業部番号を引数としてもたせる
		 * @param label 事業部の表示文字列
		 * @param num 事業部番号
		 */
		dep(String label, String num) {
			this.label = label;
			this.num = num;
		}

		/**
		 * 事業部の表示文字列を取得
		 * @return label 事業部の表示文字列
		 */
		public String getLabel() {
			return this.label;
		}

		/**
		 * 事業部番号を取得
		 * @return num 事業部番号
		 */
		public String getNum() {
			return num;
		}
	}

	/**
	 * 事業部の番号から表示文字をかえす
	 * @param num 事業部番号
	 * @return department.getLabel() 事業部の表示文字
	 */
	public static String departmentName(String num) {
		for (dep department : dep.values()) {
			if (department.getNum().equals(num)) {
				return department.getLabel();
			}
		}
		return null;
	}
}
