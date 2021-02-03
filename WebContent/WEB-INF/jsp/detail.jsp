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

	<form action="#">
		<div class="form_area">
			<div class="form_top">
				<label for="name">氏名</label> <input type="text" id="name"
					name="emp_name">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="name_hiragana">氏名(ひらがな)</label> <input type="text"
					id="name_hiragana" name="emp_name_hiragana">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="birthday">生年月日</label> <input type="text" id="birthday"
					name="emp_birthday">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="gender">性別</label> <input type="radio" id="gender"
					name="emp_gender" value="male">男 <input type="radio"
					id="gender" name="emp_gender" value="female">女
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="email">メールアドレス</label> <input type="email" id="email"
					name="emp_email">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="tel">電話番号</label> <input type="tel" id="tel"
					name="emp_tel">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="company">所属会社</label>
				<c:forEach var="employeeRegistBean" items="${employeeRegistBean}">
					<select name="emp_company" id="company">
						<%-- <option value=<c:out value="${employeeRegistBean.companyInfoId}" />><c:out value="${employeeRegistBean.companyInfoId}" /></option> --%>
						<option value="株式会社丸">株式会社丸</option>
						<option value="株式会社坂本">株式会社坂本</option>
					</select>
				</c:forEach>
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="management_sales">担当管理営業</label> <input type="text"
					id="management_sales" name="emp_management_sales">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="division">事業部</label> <select name="emp_division"
					id="division">
					<option value="開発事業部">開発事業部</option>
					<option value="検証事業部">検証事業部</option>
				</select>
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="operation_status">稼働状況</label> <input type="radio"
					id="operation_status" name="emp_operation_status" value="operation">稼働
				<input type="radio" id="operation_status"
					name="emp_operation_status" value="not_operation">未稼働
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="hire_date">入社日</label> <input type="text" id="hire_date"
					name="emp_hire_date">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="retire_date">退職日</label> <input type="text"
					id="retire_date" name="emp_retire_date">
			</div>
		</div>
		<div class="form_area">
			<div class="form_detail">
				<label for="status">ステータス</label> <select name="emp_status"
					id="status">
					<option value="在籍">在籍</option>
					<option value="未在籍">未在籍</option>
				</select>
			</div>
		</div>
	</form>
	<div class="button">
		<form action="NewRegistServlet" method="post">
			<button>更新</button>
			<button onclick="history.back()">戻る</button>
		</form>
	</div>
</body>

</html>