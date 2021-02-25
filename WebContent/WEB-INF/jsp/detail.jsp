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
	 <input type="hidden" name="employee_id" value="${detailBean.employeeId}">
	 <%-- <input type="hidden" name="login_id" value="${detailBean.loginId}"> --%>
		<div class="form_area">
			<div class="form_top">
				<label for="name">氏名</label>
				<input type="text" id="name" name="name" maxlength='20'value="${detailBean.name}">
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
				<input type="radio" id="gender" name="sex" value="0" <c:if test="${detailBean.sex == 0}">checked</c:if>>男
				<input type="radio" id="gender" name="sex" value="1" <c:if test="${detailBean.sex == 1}">checked</c:if>>女
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
						<option value="${companyInfoBeanList.companyId}"  <c:if test="${detailBean.companyInfoId == companyInfoBeanList.companyId}">selected</c:if>>${companyInfoBeanList.abbreviation}</option>
					</c:forEach>
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
					<option value="0" <c:if test="${detailBean.department == 0}">selected</c:if>>開発</option>
					<option value="1" <c:if test="${detailBean.department == 1}">selected</c:if>>NW</option>
					<option value="2" <c:if test="${detailBean.department == 2}">selected</c:if>>検証</option>
					<option value="3" <c:if test="${detailBean.department == 3}">selected</c:if>>オフィス</option>
					<option value="4" <c:if test="${detailBean.department == 4}">selected</c:if>>管理</option>
					<%-- </c:forEach> --%>
				</select>
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="commissioningStatus">稼働状況</label>
				<input type="radio" id="commissioningStatus" name="commissioning_status" value="1" <c:if test="${detailBean.commissioningStatus == 1}">checked</c:if>>稼働
				<input type="radio" id="commissioningStatus" name="commissioning_status" value="0" <c:if test="${detailBean.commissioningStatus == 0}">checked</c:if>>未稼働
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
					<option value="0" <c:if test="${detailBean.status == 0}">selected</c:if>>在籍</option>
					<option value="1" <c:if test="${detailBean.status == 1}">selected</c:if>>退職</option>
					<option value="2" <c:if test="${detailBean.status == 2}">selected</c:if>>入社待</option>
					<option value="3" <c:if test="${detailBean.status == 3}">selected</c:if>>入社取り消し</option>
				</select>
			</div>
		</div>
			<div class="button">
				<c:if test="${empty detailBean.employeeId}"><button>登録</button></c:if>
				<c:if test="${!empty detailBean.employeeId}"><button>更新</button></c:if>
			<button type="button" onclick="history.back()">戻る</button>
			</div>
	</form>
</body>

</html>