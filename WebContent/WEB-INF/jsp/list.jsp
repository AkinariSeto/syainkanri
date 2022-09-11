<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<!-- ログアウトリンク -->
	<div class="logout">
		<a href="./logout">ログアウト</a>
	</div>
	<!-- 画面タイトル -->
	<h1>社員一覧</h1>
	<!-- 新規登録ボタンフォーム -->
	<form action="detail" method="get">
		<button type="submit">新規登録</button>
	</form>
	<!-- 一覧画面 -->
	<table>
		<!-- 目次 -->
		<tr>
			<!-- 社員ID-->
			<th>No</th>
			<!-- 会社 -->
			<th>会社</th>
			<!-- 事業部 -->
			<th>事業部</th>
			<!-- 氏名 -->
			<th>氏名</th>
			<!-- 氏名(ひらがな) -->
			<th>氏名(ひらがな)</th>
			<!-- 年齢 -->
			<th>年齢</th>
			<!-- 担当管理営業 -->
			<th>担当管理営業</th>
			<!-- 入社日 -->
			<th>入社日</th>
			<!-- 稼働状況 -->
			<th>稼働状況</th>
			<!-- 詳細 -->
			<th>詳細</th>
			<!-- 削除 -->
			<th>削除</th>
		</tr>
		<!-- 一覧を出力 -->
		<c:forEach var="InfoBeanList" items="${InfoBeanList}" varStatus="number">
			<tr>
				<!-- 社員IDを出力 -->
				<td><c:out value="${number.count}" /></td>
				<!-- 会社略称を出力 -->
				<td><c:out value="${InfoBeanList.abbreviation}" /></td>
				<!-- 事業部を出力 -->
				<td><c:out value="${InfoBeanList.department}" /></td>
				<!-- 氏名を出力 -->
				<td><c:out value="${InfoBeanList.name}" /></td>
				<!-- ふりがなを出力 -->
				<td><c:out value="${InfoBeanList.nameHiragana}" /></td>
				<!-- 誕生日を出力 -->
				<td><c:out value="${InfoBeanList.birthday}" /></td>
				<!-- 担当管理営業を出力 -->
				<td><c:out value="${InfoBeanList.businessManager}" /></td>
				<!-- 入社日を出力 -->
				<td><c:out value="${InfoBeanList.enterDate}" /></td>
				<!-- 稼働状況を出力 -->
				<td><c:out value="${InfoBeanList.commissioningStatus}" /></td>
				<!-- 詳細リンク -->
				<td><a href="detail?empId=${InfoBeanList.employeeId}">詳細</a></td>
				<!-- 削除リンク -->
				<td><a href="delete?empId=${InfoBeanList.employeeId}"
					onclick="return deleteCheck('${InfoBeanList.abbreviation}', '${InfoBeanList.name}')">削除</a></td>
			</tr>
		</c:forEach>
	</table>

	<!-- バリデーション -->
	<script type="text/javascript">
		/* 削除バリデーション */
		function deleteCheck(abbreviation, name) {
			if (window.confirm(abbreviation + name + 'を削除しますか？')) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>

</html>