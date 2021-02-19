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
	<h1>社員詳細</h1>

	<form action="NewRegisterServlet" method="post">
		<div class="form_area">
			<div class="form_top">
				<label for="name">氏名</label>
				<%--  <c:forEach var="detailBean" items="${detailBean}"> --%>
				<input type="text" id="name" name="name" maxlength='20'value="${detailBean.name}">
				<%-- </c:forEach> --%>
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="name_hiragana">氏名(ひらがな)</label>
				
				<input type="text" id="name_hiragana" name="name_hiragana" maxlength='20'value="${detailBean.nameHiragana}">
				
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="birthday">生年月日</label>
				<input type="text" id="birthday" name="birthday" value="${detailBean.birthday}">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="gender">性別</label>
				<input type="radio" id="gender" name="sex" value="value="${detailBean.sex}">男
				<input type="radio" id="gender" name="sex" value="${detailBean.sex}">女
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="email">メールアドレス</label>
				<input type="email" id="email" name="mail_address" maxlength='50' value="${detailBean.mailAddress}">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="tel">電話番号</label>
				<input type="tel" id="tel" name="telephone_number" maxlength='11' value="${detailBean.telephoneNumber}">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="company">所属会社</label>
				<select name="company_info_id" id="company">
				<c:forEach var="companyInfoBeanList" items="${companyInfoBeanList}">
					<option value="${companyInfoBeanList.companyId}">${companyInfoBeanList.abbreviation}</option>
				</c:forEach>
				<%-- <c:forEach var="detailBean" items="${detailBean}">
					<option value="${detailBean.companyId}">${detailBean.abbreviation}</option>
				</c:forEach> --%>
				</select>
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="business_manager">担当管理営業</label>
				<input type="text" id="business_manager" name="business_manager" maxlength='20' value="${detailBean.businessManager}">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="division">事業部</label>
<%--  				<c:forEach var="companyInfoBeanList" items="${companyInfoBeanList}">
					<option value="${detailBeanList.department}">${detailBeanList.department}</option>
				</c:forEach> --%>
				<select name="department" id="division">
				 <%-- <c:forEach var="detailBean" items="${detailBean}">
					<option value="${detailBean.department}"></option> --%>
					<!-- <option value="1">NW</option>
					<option value="2">検証</option>
					<option value="3">オフィス</option>
					<option value="4">管理</option> -->
					<option value="0">開発</option>
					<option value="1">NW</option>
					<option value="2">検証</option>
					<option value="3">オフィス</option>
					<option value="4">管理</option>
					<%-- </c:forEach> --%>
				</select>
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="commissioningStatus">稼働状況</label>
				<input type="radio" id="commissioningStatus" name="commissioning_status" value="${detailBean.commissioningStatus}">稼働
				<input type="radio" id="commissioningStatus" name="commissioning_status" value="${detailBean.commissioningStatus}">未稼働
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="hire_date">入社日</label>
				<input type="text" id="hire_date" name="hire_date" maxlength='10' pattern="\d{4}-\d{2}-\d{2}" value="${detailBean.hireDate}">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="retire_date">退職日</label>
				<input type="text" id="retire_date" name="retire_date" maxlength='10' pattern="\d{4}-\d{2}-\d{2}" value="${detailBean.retireDate}">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="status">ステータス</label>
				<select name="status" id="status">
					<option value="0">在籍</option>
					<option value="1">退職</option>
					<option value="2">入社待</option>
					<option value="3">入社取り消し</option>
				</select>
			</div>
		</div>
			<div class="button">
				<button>更新</button>
			<button type="button" onclick="history.back()">戻る</button>
			</div>
	</form>
</body>

</html>