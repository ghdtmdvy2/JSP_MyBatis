<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${articleList}" var="article">
    <tr>
        <td>${article.id}</td>
        <td>${article.content}</td>
        <td>${article.subject}</td>
    </tr>
    ${article}
</c:forEach>
