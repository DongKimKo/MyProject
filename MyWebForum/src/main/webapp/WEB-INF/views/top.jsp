<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>top</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<style>
.sitelogo {
	margin-top : 10px;
    width: auto; height: auto;
    max-width: 200px;
    max-height: 200px;
}
.my-hr {
	border: 0;
	height: 5px;
	background: black;
	margin-bottom : 0px;
}
.meunbar {
	margin-right : 13px;
	float: right;
	margin-top : 70px;
	color : #939c9f;
}
</style>
<body>

<div class="container">
<a href="forum"><img class="sitelogo" src="resources/SiteLogo.jpg" ></a>
<!--  
	<a href="#" style="text-decoration-line : none;"><span class="meunbar">개인정보</span></a>
	<a href="#" style="text-decoration-line : none;"><span class="meunbar">로그아웃</span></a>
	<a href="#" style="text-decoration-line : none;"><span class="meunbar">로그인</span></a>
	<span class="meunbar">닉네임</span>
-->
	<a href="MyGame" style="text-decoration-line : none;"><span class="meunbar">▶ 게임하러 가기</span></a>
<hr class="my-hr"/>
</div>

</body>
</html>