<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="empState" class="beans.EmployeeStateBean" />
<jsp:useBean id="empInfo" class="beans.EmployeeInfoBean" />
<jsp:useBean id="listInfo" class="beans.ListInfoBean" /> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/list.css">
<title>社員一覧</title>
</head>

<body>
	<div class="logout">
		<a href="./Logout">ログアウト</a>
	</div>
	<h1>社員一覧</h1>
	<form action="ListRegistServlet" method="get">
		<button type="submit">新規登録</button>
	</form>
	<table border="1">
		<tr>
			<!-- employee_id  通番-->
			<th>No</th>
			<!-- company_info_id 社員状況.所属会社ID -->
			<th>会社</th>
			<!-- department 社員状況.事業部 -->
			<th>事業部</th>
			<!-- name 社員情報.氏名 -->
			<th>氏名</th>
			<!-- name_hiragana 社員情報.氏名(ひらがな) -->
			<th>氏名(ひらがな)</th>
			<!-- birthday 社員情報.生年月日 -->
			<th>年齢</th>
			<!-- business_manager 社員状況.担当管理営業 -->
			<th>担当管理営業</th>
			<!-- hire_date 社員状況.入社日 -->
			<th>入社日</th>
			<!-- commissioning_status 社員情報.稼働状況 -->
			<th>稼働状況</th>
			<!-- 社員情報.社員ID -->
			<th>詳細</th>
			<!-- 社員情報.社員ID -->
			<th>削除</th>
		</tr>
		<c:forEach var="InfoBeanList" items="${InfoBeanList}">
			<tr>
				<td><c:out value="${InfoBeanList.employeeId}" /></td>
				<td><c:out value="${InfoBeanList.abbreviation}" /></td>
				<td><c:out value="${InfoBeanList.department}" /></td>
				<td><c:out value="${InfoBeanList.name}" /></td>
				<td><c:out value="${InfoBeanList.nameHiragana}" /></td>
				<td><c:out value="${InfoBeanList.birthday}" /></td>
				<td><c:out value="${InfoBeanList.businessManager}" /></td>
				<td><c:out value="${InfoBeanList.hireDate}" /></td>
				<td><c:out value="${InfoBeanList.commissioningStatus}" /></td>
				<td><a href="ListDetailServlet">詳細</a></td>
				<td>
					<form action="DeleteServlet" method="post" name="delete_form">
						<!-- <input type="hidden" name="user_name" value="名前"> -->
						<!-- <p><a href="javascript:document.delete_form.submit()">削除</a></p> -->
						<a href="">削除</a>
					</form>
					<!-- <a href="DeleteServlet.java">削除</a> -->
				</td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>