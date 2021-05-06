<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/detail.css">
	<title>社員詳細</title>
</head>

<body>
<!-- 画面タイトル -->
	<h1>社員詳細</h1>
	<!-- 新規登録、更新のフォーム -->
	<form action="NewRegisterServlet" method="post" name="registerForm" onSubmit="return funcConfirm()">
		<!-- employeeIdの情報を取得 -->
		<input type="hidden" name="empId" value="${detailBean.employeeId}">
		<!-- 氏名の情報を取得 -->
		<div class="form_area">
			<div class="form_top">
				<label for="name">氏名</label>
				<input type="text" id="name" name="name" value="${detailBean.name}">
			</div>
		</div>
		<!-- ふりがなの情報を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="name_hiragana">氏名(ひらがな)</label>
				<input type="text" id="name_hiragana" name="nameHiragana" value="${detailBean.nameHiragana}">
			</div>
		</div>
		<!-- 生年月日の情報を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="birthday">生年月日</label>
				<input type="text" id="birthday" name="birthday" value="${detailBean.birthday}">
			</div>
		</div>
		<!-- 性別の情報を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label>性別</label>
				<input type="radio" name="sex" value="0"
					<c:if test="${detailBean.sex == 0}">checked</c:if>>男
				<input type="radio" name="sex" value="1"
					<c:if test="${detailBean.sex == 1}">checked</c:if>>女
			</div>
		</div>
		<!-- メールアドレスを取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="email">メールアドレス</label>
				<input type="email" id="email" name="mailAddress" value="${detailBean.mailAddress}">
			</div>
		</div>
		<!-- 電話番号を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="tel">電話番号</label>
				<input type="tel" id="tel" name="telephoneNumber" value="${detailBean.telephoneNumber}">
			</div>
		</div>
		<!-- 会社情報を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="company">所属会社</label>
				<select name="companyInfoId" id="company">
					<c:forEach var="companyInfoBeanList" items="${companyInfoBeanList}">
						<option value="${companyInfoBeanList.companyId}"
							<c:if test="${detailBean.companyInfoId == companyInfoBeanList.companyId}">selected</c:if>>${companyInfoBeanList.abbreviation}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<!-- 担当管理営業を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="business_manager">担当管理営業</label>
				<input type="text" id="business_manager" name="businessManager" value="${detailBean.businessManager}">
			</div>
		</div>
		<!-- 事業部を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="division">事業部</label>
				<select name="department" id="division">
					<option value="0"
						<c:if test="${detailBean.department == 0}">selected</c:if>>開発</option>
					<option value="1"
						<c:if test="${detailBean.department == 1}">selected</c:if>>NW</option>
					<option value="2"
						<c:if test="${detailBean.department == 2}">selected</c:if>>検証</option>
					<option value="3"
						<c:if test="${detailBean.department == 3}">selected</c:if>>オフィス</option>
					<option value="4"
						<c:if test="${detailBean.department == 4}">selected</c:if>>管理</option>
				</select>
			</div>
		</div>
		<!-- 稼働状況を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="commissioningStatus">稼働状況</label>
				<input type="radio" id="commissioningStatus" name="commissioningStatus" value="1"
					<c:if test="${detailBean.commissioningStatus == 1}">checked</c:if>>稼働
				<input type="radio" id="commissioningStatus" name="commissioningStatus" value="0"
					<c:if test="${detailBean.commissioningStatus == 0}">checked</c:if>>未稼働
			</div>
		</div>
		<!-- 入社日を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="hire_date">入社日</label>
				<input type="text" id="hire_date" name="enterDate" value="${detailBean.hireDate}">
			</div>
		</div>
		<!-- 退職日を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="retire_date">退職日</label>
				<input type="text" id="retire_date" name="retireDate" value="${detailBean.retireDate}">
			</div>
		</div>
		<!-- ステータスを取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="status">ステータス</label>
				<select name="status" id="status">
					<option value="0"
						<c:if test="${detailBean.status == 0}">selected</c:if>>在籍</option>
					<option value="1"
						<c:if test="${detailBean.status == 1}">selected</c:if>>退職</option>
					<option value="2"
						<c:if test="${detailBean.status == 2}">selected</c:if>>入社待</option>
					<option value="3"
						<c:if test="${detailBean.status == 3}">selected</c:if>>入社取り消し</option>
				</select>
			</div>
		</div>
		<div class="button">
			<!-- 社員IDが空の場合「登録」ボタンを表示 -->
			<c:if test="${empty detailBean.employeeId}">
				<button name="registerBtn" onclick="return registerCheck()">登録</button>
			</c:if>
			<!-- 社員IDが入っている場合「更新」ボタンを表示 -->
			<c:if test="${!empty detailBean.employeeId}">
				<button name="updateBtn" onclick="return updateCheck()">更新</button>
			</c:if>
			<!-- 戻るボタン -->
			<button type="button" onclick="history.back()">戻る</button>
		</div>
	</form>

	<script type="text/javascript">
		/* 登録・更新のバリデーション */
		function registerCheck() {
			//登録のバリデーション
			if (window.confirm('登録しますか？')) {
				//「true」の処理
				return true;
			} else {
				//「false」の処理
				return false;
			}
		}
		//更新のバリデーション
		function updateCheck() {
			if (window.confirm('更新しますか？')) {
				//「true」の処理
				return true;
			} else {
				//「false」の処理
				return false;
			}
		}
		/* 各入力のバリデーション */
		function funcConfirm() {
			/* 氏名のバリデーション */
			if (document.registerForm.name.value == "") {
				alert("氏名を入力して下さい。");
				return false;
			} else if (document.registerForm.name.value.length > 20) {
				alert("氏名は20文字以内で入力して下さい。");
				return false;
			} else if (document.registerForm.name.value
					.match(/[\x01-\x7E\uFF65-\uFF9F]/)) {
				alert("氏名は全角で入力して下さい。");
				return false;
			}

			/* 氏名(ひらがな)のバリデーション */
			if (document.registerForm.nameHiragana.value == "") {
				alert("氏名(ひらがな)を入力して下さい。");
				return false;
			}
			if (document.registerForm.nameHiragana.value.length > 20) {
				alert("氏名(ひらがな)は20文字以内で入力して下さい。");
				return false;
			}
			if (!document.registerForm.nameHiragana.value.match(/^[ぁ-んー　]*$/)) {
				alert("氏名(ひらがな)は全角ひらがなで入力して下さい。");
				return false;
			}

			/* 生年月日のバリデーション */
			if (document.registerForm.birthday.value == "") {
				alert("生年月日を入力して下さい。");
				return false;
			} else if (document.registerForm.birthday.value.length > 10) {
				alert("生年月日は10文字以内で入力して下さい。");
				return false;
			} else if (!document.registerForm.birthday.value.match(/^\d{4}\-\d{2}\-\d{2}$/)) {
				alert("生年月日はYYYY/MM/DDの書式で入力して下さい。");
				return false;
			}

			/* 性別のバリデーション */
			if (document.registerForm.sex.value == "") {
				alert("性別を選択して下さい。");
				return false;
			}

			/* メールアドレスのバリデーション */
			if (document.registerForm.mailAddress.value == "") {
				alert("メールアドレスを入力して下さい。");
				return false;
			} else if (document.registerForm.mailAddress.value.length > 50) {
				alert("メールアドレスは50文字以内で入力して下さい。");
				return false;
			} else if (!document.registerForm.mailAddress.value.match(/^[a-zA-Z0-9!-/:-@¥[-`{-~]*$/)) {
				alert("メールアドレスは半角英数字記号で入力して下さい。");
				return false;
			}

			/* 電話番号のバリデーション */
			if (document.registerForm.telephoneNumber.value == "") {
				alert("電話番号を入力して下さい。");
				return false;
			} else if (document.registerForm.telephoneNumber.value.length > 11) {
				alert("電話番号は11文字以内で入力して下さい。");
				return false;
			} else if (!document.registerForm.telephoneNumber.value
					.match(/^[0-9]+$/)) {
				alert("電話番号は半角数字で入力して下さい。");
				return false;
			}

			/* 所属会社のバリデーション */
			if (document.registerForm.companyInfoId.value == "") {
				alert("所属会社を選択して下さい。");
				return false;
			}

			/* 担当管理営業のバリデーション */
			if (document.registerForm.businessManager.value == "") {
				alert("担当管理営業を入力して下さい。");
				return false;
			} else if (document.registerForm.businessManager.value.length > 20) {
				alert("担当管理営業は20文字以内で入力して下さい。");
				return false;
			} else if (document.registerForm.businessManager.value
					.match(/[\x01-\x7E\uFF65-\uFF9F]/)) {
				alert("担当管理営業は全角で入力して下さい。");
				return false;
			}

			/* 事業部のバリデーション */
			if (document.registerForm.department.value == "") {
				alert("事業部を選択して下さい。");
				return false;
			}

			/* 稼働状況のバリデーション */
			if (document.registerForm.commissioningStatus.value == "") {
				alert("稼働状況を選択して下さい。");
				return false;
			}

			/* 入社日のバリデーション */
			if (document.registerForm.enterDate.value == "") {
				alert("入社日を入力して下さい。");
				return false;
			} else if (document.registerForm.enterDate.value.length > 10) {
				alert("入社日は10文字以内で入力して下さい。");
				return false;
			} else if (!document.registerForm.enterDate.value
					.match(/^\d{4}\-\d{2}\-\d{2}$/)) {
				alert("入社日はYYYY/MM/DDの書式で入力して下さい。");
				return false;
			}


		/* 退職日のバリデーション */
			if (document.registerForm.retireDate.value != "") {
				if (document.registerForm.retireDate.value.length == 10) {
					if (!document.registerForm.retireDate.value
							.match(/^\d{4}\-\d{2}\-\d{2}$/)) {
						alert("退職日はYYYY/MM/DDの書式で入力して下さい。");
						return false;
					}
				} else if (document.registerForm.retireDate.value.length > 10) {
					alert("退職日は10文字以内で入力して下さい。");
					return false;
				} else if (document.registerForm.retireDate.value.length < 10) {
					alert("退職日はYYYY/MM/DDの書式で入力して下さい。");
					return false;
				}
			}

			/* ステータスのバリデーション */
			if (document.registerForm.status.value == "") {
				alert("ステータスを選択して下さい。");
				return false;
			}
		}
	</script>
</body>

</html>