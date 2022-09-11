package validation;

import java.util.ArrayList;
import java.util.List;

import beans.DetailBean;

/**
 * 詳細画面のバリデーションチェックを行うクラス
 * @author setoakinari
 *
 */
public class Validation {
	/**
	 * errorMessageにバリデーションチェックを入れていく。
	 * @param detailvalidationBean 氏名、氏名(ふりがな)、生年月日、性別、メールアドレス、電話番号、所属会社ID、担当管理営業、事業部、稼働状況、入社日、退職日、ステータス
	 * @return errorMessage
	 */
	public List<String> validation(DetailBean detailvalidationBean) {

		/*バリデーションチェック*/
		//errorMessageに表示する文字を入れていく
		List<String> errorMessage = new ArrayList<String>();
		//氏名のバリデーション
		if (detailvalidationBean.getName().equals("")) {
			errorMessage.add("氏名を入力してください");
		} else if (detailvalidationBean.getName().length() > 20) {
			errorMessage.add("氏名は20文字以内で入力して下さい。");
		} else if (!detailvalidationBean.getName().matches("^[^-~｡-ﾟ]*$")) {
			errorMessage.add("氏名は全角で入力して下さい。");
		} else if (detailvalidationBean.getName().matches("^[0-9a-zA-Z]+$")) {
			errorMessage.add("氏名は全角で入力して下さい。");
		}

		//氏名(ひらがな)のバリデーション
		if (detailvalidationBean.getNameHiragana().equals("")) {
			errorMessage.add("氏名(ひらがな)を入力して下さい。");
		} else if (detailvalidationBean.getNameHiragana().length() > 20) {
			errorMessage.add("氏名は20文字以内で入力して下さい。");
		} else if (!detailvalidationBean.getNameHiragana().matches("^[\\u3040-\\u309F]+$")) {
			errorMessage.add("氏名(ひらがな)は全角ひらがなで入力して下さい。");
		}

		//生年月日のバリデーション
		if (detailvalidationBean.getBirthday().equals("")) {
			errorMessage.add("生年月日を入力して下さい。");
		} else if (detailvalidationBean.getBirthday().length() > 10) {
			errorMessage.add("生年月日は10文字以内で入力して下さい。");
		} else if (!detailvalidationBean.getBirthday().matches("^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$")) {
			errorMessage.add("生年月日はYYYY/MM/DDの書式で入力して下さい。");
		}

		//性別のバリデーション
		if ("".equals(detailvalidationBean.getSex()) || detailvalidationBean.getSex() == null) {
			errorMessage.add("性別を選択して下さい。");
		}

		//メールアドレスのバリデーション
		if (detailvalidationBean.getMailAddress().equals("")) {
			errorMessage.add("メールアドレスを入力して下さい。");
		} else if (detailvalidationBean.getMailAddress().length() > 50) {
			errorMessage.add("メールアドレスは50文字以内で入力して下さい。");
		} else if (!detailvalidationBean.getMailAddress().matches("^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]+$")) {
			errorMessage.add("メールアドレスは半角英数字記号で入力して下さい。");
		}

		//電話番号のバリデーション
		if (detailvalidationBean.getTelephoneNumber().equals("")) {
			errorMessage.add("電話番号を入力して下さい。");
		} else if (detailvalidationBean.getTelephoneNumber().length() > 11) {
			errorMessage.add("電話番号は11文字以内で入力して下さい。");
		} else if (!detailvalidationBean.getTelephoneNumber().matches("^[0-9]+$")) {
			errorMessage.add("電話番号は半角数字で入力して下さい。");
		}

		//所属会社のバリデーション
		if (String.valueOf(detailvalidationBean.getCompanyInfoId()).equals("")
				|| detailvalidationBean.getCompanyInfoId() == 0) {
			errorMessage.add("所属会社を選択して下さい。");
		}

		//担当管理営業のバリデーション
		if (detailvalidationBean.getBusinessManager().equals("")) {
			errorMessage.add("担当管理営業を入力して下さい。");
		} else if (detailvalidationBean.getBusinessManager().length() > 20) {
			errorMessage.add("担当管理営業は20文字以内で入力して下さい。");
		} else if (!detailvalidationBean.getBusinessManager().matches("^[^-~｡-ﾟ]*$")) {
			errorMessage.add("担当管理営業は全角で入力して下さい。");
		} else if (detailvalidationBean.getBusinessManager().matches("^[0-9a-zA-Z]+$")) {
			errorMessage.add("担当管理営業は全角で入力して下さい。");
		}

		//事業部のバリデーション
		if (detailvalidationBean.getDepartment().equals("")) {
			errorMessage.add("事業部を選択して下さい。");
		}

		//稼働状況のバリデーション
		if ("".equals(detailvalidationBean.getCommissioningStatus())
				|| detailvalidationBean.getCommissioningStatus() == null) {
			errorMessage.add("稼働状況を選択して下さい。");
		}

		//入社日のバリデーション
		if (detailvalidationBean.getEnterDate().equals("")) {
			errorMessage.add("入社日を入力して下さい。");
		} else if (detailvalidationBean.getEnterDate().length() > 10) {
			errorMessage.add("入社日は10文字以内で入力して下さい。");
		} else if (!detailvalidationBean.getEnterDate().matches("^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$")) {
			errorMessage.add("入社日はYYYY/MM/DDの書式で入力して下さい。");
		}

		//退職日のバリデーション
		if (!detailvalidationBean.getRetireDate().equals("")) {
			if (detailvalidationBean.getRetireDate().length() > 10) {
				errorMessage.add("退職日は10文字以内で入力して下さい。");
			} else if (!detailvalidationBean.getRetireDate().matches("^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$")) {
				errorMessage.add("退職日はYYYY/MM/DDの書式で入力して下さい。");
			}
		}

		//ステータスのバリデーション
		if (detailvalidationBean.getStatus().equals("")) {
			errorMessage.add("ステータスを選択して下さい。");
		}
		return errorMessage;
	}
}
