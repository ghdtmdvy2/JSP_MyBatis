<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta name="_csrf" content="${_csrf.token}" />
        <meta name="_csrf_header" content="${_csrf.headerName}" />
        <title>문서 제목</title>
    </head>
    <body>
    <a href="/user/signup">회원가입</a>
    <a href="/user/login">로그인</a>
    <a href="/user/logout">로그아웃</a>
    <!-- HTML 문서의 본문 내용 -->
        <c:forEach items="${articleList}" var="article">
            <div id="article_${article.id}">
                <input value="${article.id}" readonly>
                <input value="${article.content}" readonly>
                <input value="${article.subject}" readonly>
                </br>
                <c:if test="${article.usersId == userContext.getId()}">
                    <form id="myForm_${article.id}"  method="patch">
                        <button id="myButton_${article.id}" type="button" onclick="articleModify(${article.id})">수정</button>
                    </form>
                    <form id="myForm_delete_${article.id}"  method="delete">
                        <button id="myButton_delete_${article.id}" type="button" onclick="articleDelete(${article.id})">삭제</button>
                    </form>
                </c:if>
            </div>
        </c:forEach>
        </br>
        <form method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            제목
            <input name="subject">
            내용
            <input name="content">
            <button>작성</button>
        </form>
    </body>

    <script>
        function articleModify(articleId){
            const pathForm = document.getElementById("myForm_"+articleId);
            const button = document.getElementById("myButton_"+articleId);
            const parent = document.querySelector("#article_"+articleId);
            const inputList = parent.querySelectorAll("input");
            const articleContent = inputList[1];
            const articleSubject = inputList[2];
            const newButton = document.createElement('button');
            newButton.setAttribute('id', 'button_' + articleId);
            newButton.setAttribute('type','button');
            console.log(articleSubject);
            newButton.setAttribute('onclick','button_submit('+ articleId + ')');
            newButton.innerHTML = '작성';
            if (button.innerText == "수정 취소") {
                button.innerText = "수정"
                articleContent.readOnly = true;
                articleSubject.readOnly = true;
                const deleteButton = document.getElementById('button_' + articleId);
                deleteButton.remove();
            } else {
                button.innerText = "수정 취소"
                articleContent.readOnly = false;
                articleSubject.readOnly = false;
                pathForm.appendChild(newButton);
            }
        }
        function button_submit(articleId){
            const parent = document.querySelector("#article_"+articleId);
            const inputList = parent.querySelectorAll("input");
            const inputContent = inputList[1];
            const inputSubject = inputList[2];
            const articleContent = inputContent.value;
            const articleSubject = inputSubject.value;
            $.ajax({
                type : 'patch',           // 타입 (get, post, put 등등)
                url : '/article/' ,           // 요청할 서버 url
                async : true,            // 비동기화 여부 (default : true)
                data : {
                    articleId : articleId,
                    articleSubject : articleSubject,
                    articleContent : articleContent
                }
                ,
                beforeSend: function(xhr) {
                    const token = $("meta[name='_csrf']").attr("content");
                    const header = $("meta[name='_csrf_header']").attr("content");
                    xhr.setRequestHeader(header, token);
                }
                ,
                success : function(result) { // 결과 성공 콜백함수
                    console.log(result);
                },
                error : function(request, status, error) { // 결과 에러 콜백함수
                    console.log(error)
                }
            })
        }
        function articleDelete(articleId){
            const parent = document.querySelector("#article_"+articleId);
            parent.remove();
            $.ajax({
                type : 'delete',           // 타입 (get, post, put 등등)
                url : '/article/' ,           // 요청할 서버 url
                async : true,            // 비동기화 여부 (default : true)
                data : {
                    articleId : articleId
                }
                ,
                success : function(result) { // 결과 성공 콜백함수

                    console.log(result);
                },
                error : function(request, status, error) { // 결과 에러 콜백함수
                    console.log(error)
                }
            })
        }
    </script>
</html>

