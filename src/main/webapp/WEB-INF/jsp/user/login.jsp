<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>문서 제목</title>
    </head>
    <body>
        <a href="/user/signup">회원가입</a>
        <a href="/user/login">로그인</a>
        <a href="/user/logout">로그아웃</a>
        <form method="post" action="/user/login">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <span>아이디</span>
            <input name="username">
            <span>비밀번호</span>
            <input name="password">
            <button type="submit">로그인</button>
        </form>
    </body>
</html>