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

	<!-- バリデーションメッセージ -->
	<div id="validation">
		<a id="validation_message">${errorMessage}</a>
	</div>

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
				<c:forEach var="gender" items="${gender}">
					<input type="radio" name="sex" value="${gender.getNum()}"<c:if test="${detailBean.sex == gender.getNum()}">checked</c:if>>
					<c:out value="${gender.getLabel()}" />
				</c:forEach>
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
						<option value=""
							<c:if test="${detailBean.companyInfoId == null}">selected</c:if>></option>
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
					<c:forEach var="dep" items="${dep}">
						<option value="${dep.getNum()}"
							<c:if test="${detailBean.department == dep.getNum()}">selected</c:if>>
							<c:out value="${dep.getLabel()}" /></option>
					</c:forEach>
				</select>
			</div>
		</div>
		<!-- 稼働状況を取得 -->
		<div class="form_area">
			<div class="form_detail">
				<label for="commissioningStatus">稼働状況</label>
				<c:forEach var="commissioningStatus" items="${commissioningStatus}">
					<input type="radio" name="commissioningStatus" value="${commissioningStatus.getNum()}"<c:if test="${detailBean.commissioningStatus == commissioningStatus.getNum()}">checked</c:if>>
					<c:out value="${commissioningStatus.getLabel()}" />
				</c:forEach>
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
					<c:forEach var="companyStatus" items="${companyStatus}">
						<option value="${companyStatus.getNum()}"
							<c:if test="${detailBean.status == companyStatus.getNum()}">selected</c:if>>
							<c:out value="${companyStatus.getLabel()}" /></option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="button">
			<!-- 社員IDが空の場合「登録」ボタンを表示
			社員IDが入っている場合「更新」ボタンを表示 -->
			<c:choose>
			    <c:when test="${empty detailBean.employeeId || detailBean.employeeId == null || detailBean.employeeId == ''}">
			        <button name="registerBtn" onclick="return registerCheck()">登録</button>
			    </c:when>
			    <c:otherwise>
			      	<button name="updateBtn" onclick="return updateCheck()">更新</button>
			    </c:otherwise>
			</c:choose>
			<!-- 戻るボタン -->
			<button type="button" onclick='location.href="list"'>戻る</button>
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
	</script>
</body>

</html>