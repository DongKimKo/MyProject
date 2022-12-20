<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Forum</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<style>
    table {
      border-collapse: collapse;
      border-spacing: 0;
    }
    
    .board-table {
      font-size: 13px;
      width: 100%;
      border-bottom: 1px solid #ccc;
    }
    
    .board-table a {
      color: #333;
      display: inline-block;
      line-height: 1.4;
      word-break: break-all;
      vertical-align: middle;
    }
    .board-table a:hover {
      text-decoration: underline;
      color : black;
    }
    .board-table th {
      text-align: center;
    }
    
    .board-table .th-num {
      width: 70px;
      text-align: center;
    }
    
    .board-table .th-who {
      width: 130px;
      text-align: center;
    }
    
    .board-table .th-date {
      width: 160px;
    }
    
    .board-table th, .board-table td {
      padding: 14px 0;
    }
    
    .board-table tbody td {
      border-top: 1px solid #e7e7e7;
      text-align: center;
    }
    
    .board-table tbody th {
      padding-left: 28px;
      padding-right: 14px;
      border-top: 1px solid #e7e7e7;
      text-align: left;
	  font-weight :normal;
    }
    
    .board-table tbody th p{
      display: none;
    }
    
    .td-plus {
    	 text-align: left;
    }
	button {
	--button-color: white;
	--button-bg-color: gray;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	background: var(--button-bg-color);
	color: var(--button-color);		
	padding: 0.5rem 1rem;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 1rem;
	font-weight: 400;
	text-align: center;
	border: none;
	float : right;
}
</style>
<jsp:include page="top.jsp"/>
<body>

<div class="container">
	<div id="board-list">
        <table class="board-table">
        	<thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-num">분류</th>
                    <th scope="col" class="th-title">제목</th>
                    <th scope="col" class="th-who">글쓴이</th>
                    <th scope="col" class="th-date">등록일</th>
                    <th scope="col" class="th-num">조회수</th>
                <tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="dto">
                <tr>
                    <td>${dto.bId}</td>
                    <td>${dto.bCategory}</td>
                    <th><a href="content_view?bId=${dto.bId}">${dto.bTitle}</a></th>
                    <td>${dto.bName}</td>
                    <td>${dto.bDate}</td>
                    <td>${dto.bHit}</td>
                <tr>
                </c:forEach>
        	</tbody>
        </table>
    </div>
    
    <a href="writeform"><button style="margin-top : 10px; border-radius: 4px;">글쓰기</button></a>
</div>


</body>
</html>