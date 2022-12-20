<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>View Content</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style>
.write-title {
	font-size: x-large;
	text-align: center;
	background-color: #cedcdb;
}

button { -
	-button-color: white; -
	-button-bg-color: gray;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	background: var(- -button-bg-color);
	color: var(- -button-color);
	padding: 0.5rem 1rem;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 1rem;
	font-weight: 400;
	text-align: center;
	border: none;
	float: left;
}
.my-hz {
	border: 0;
	height: 1px;
	background: black;
	margin-top : 1px;
	margin-bottom : 5px;
}
.contentinfo {
	margin-right : 13px;
	color : #939c9f;

}

</style>
</head>
<body>
	<jsp:include page="top.jsp" />
	<div class="container">
		<p class="write-title">글읽기</p>
		<div><h4>${content_view.bCategory} | ${content_view.bTitle}</h4></div>
		<span class="contentinfo">작성자</span><span class="contentinfo" style="font-weight : bold; color:black;">${content_view.bName}</span>
		<span class="contentinfo"></span>	<!-- 자리조정을 하기위해 일부로 넣어놓은 아무것도 없는 값 -->
		<span class="contentinfo">작성일자</span>
		<span class="contentinfo">${content_view.bDate}</span>
		<span class="contentinfo">조회 ${content_view.bHit}</span>

		<hr class="my-hz"/>
			<pre>${content_view.bContent}</pre>

		<hr class="my-hz" style="margin-top : 20px;"/>
		<a href="writeform"><button
				style="margin-top: 15px; border-radius: 4px; background: gray; color:white;">글쓰기</button></a>
		<a href="forum"><button
				style="margin-top: 15px; margin-left: 13px; border-radius: 4px; background: #50bcdf; color:white;">목록보기</button></a>
		<a href="modifyform?bId=${content_view.bId}"><button
				style="margin-top: 15px; margin-left: 13px; border-radius: 4px; background: green; color:white;">수정하기</button></a>
	</div>

</body>
</html>