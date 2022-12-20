<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Modify Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<style>
.write-title {
    font-size :x-large;
    text-align: center;
    background-color: #cedcdb;
}
table {
    border : soild;
}
table, tr, td {
  border : 1px solid black;
  border-collapse : collapse;
  
}
input {
    width : 600px;
    height : 25px;
}
.headline {
    text-align: center;
    font-size : normal;
    font-weight : bold;
    width : 100px;
    height : 50px;
    background-color: gray;
    table-layout:fixed;
    
}
textarea {
    width : 600px;
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
	float : left;
}

</style>
<body>
<jsp:include page="top.jsp"/>
<div class="container">
<p class="write-title">글수정</p>
    <form action="modify" method="post">
    <input type="hidden" name="bId" value="${content_view.bId}">
        <table>
            <tr>
              <td class="headline">말머리</td>
              <td>
				<select name="bCategory" size="1" onChange="move()" style="margin:10px">
			        <option value="일반">일반</option>
			        <option value="잡담">잡담</option>
			        <option value="유머">유머</option>
			        <option value="질문">질문</option>
			        <option value="소식">소식</option>
			        <option value="정보">정보</option>
				</select>
              </td>
            </tr>
            <tr>
            <td class="headline">제목</td>
            <td><input type="text" name="bTitle" style="margin:10px" value="${content_view.bTitle}"></td>
            </tr>
            <tr>
              <td class="headline">닉네임</td>
              <td><input type="text" name="bName" style="margin:10px; width : 80px;" value="${content_view.bName}"></td>
            </tr>
        </table>
        <table>
            <tr>
                <td class="headline">내용</td>
                <td><textarea name ="bContent" rows=15 style="margin:10px;">${content_view.bContent}</textarea></td>	
            </tr>
        </table>
        <table>
            <tr>
                <td class="headline">계정</td>
                <td><input type="text" name="bAccount" style="margin:10px; width : 80px;" value="${content_view.bAccount}"></td>
              </tr>
        </table>         
    <button type="submit" style="margin-top : 15px; border-radius: 4px;">수정완료</button>
    </form>
    
    <a href="forum"><button style="margin-top : 15px; margin-left : 13px; border-radius: 4px; background:#50bcdf;">목록보기</button></a>
    <a href="delete?bId=${content_view.bId}"><button style="margin-top : 15px; margin-left : 13px; border-radius: 4px; background:red;">삭제하기</button></a>

</div>
</body>
</html>