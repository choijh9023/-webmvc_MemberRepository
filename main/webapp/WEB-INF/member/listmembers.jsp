<%--
  Created by IntelliJ IDEA.
  User: choij
  Date: 2024-03-08
  Time: 오후 5:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MemberList</title>
    <style>
        body {
            margin: 0;
            margin-top: 80px;
            text-align: center; /* 전체 body 내용을 중앙 정렬 */

        }

        table {
            margin: 0 auto; /* 테이블을 가로 중앙 정렬 */
            text-align: center; /* 테이블 내용은 왼쪽 정렬 유지 */


        /*    border-collapse: collapse;*/

        }

        span {
            display: block; /* span 태그를 블록 수준 요소로 변경하여 중앙 정렬 적용 */
            margin: 20px 0; /* 상단 여백과 하단 여백을 추가하여 가운데 정렬 시 더 보기 좋게 설정 */
        }
    </style>
</head>
<script>
    function deleteMember(mid){

        if(confirm("정말로 삭제하시겠습니까?")){
         window.location.href="/member/delMember.do?mid="+mid;
        }

    }
    function modifyMember(mid){
        if(confirm("회원정보를 수정하시겠습니까?")){
            window.location.href="/member/modMember.do?mid="+mid;
        }
    }
</script>
<body>
<span></span>
<table>
    <thead>

    <tr>
        <th><h1>회원목록</h1></th>
    </tr>

    </thead>
</table>
<table border="1">
    <thead style="border-color: burlywood">
    <tr style="background-color: lemonchiffon">
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${memberDTOList}" var="dto">
        <tr>
            <td>${dto.mid}</td>
            <td>${dto.mpw}</td>
            <td>${dto.mname}</td>
            <td>${dto.email}</td>
            <td>${dto.signdate}</td>
            <td><a href="javascript:modifyMember('${dto.mid}')">수정</a></td>
<%--            <td><a href="/member/member/modifyMember.do?mid=${dto.mid}">수정</a></td>--%>
            <td><a href="javascript:deleteMember('${dto.mid}')">삭제</a></td>

        </tr>
    </c:forEach>

    </tbody>
</table>
<table>
    <thead>

    <tr>
        <th><a href="/member/addMember.do" >회원 가입하기</a></th>
    </tr>

    </thead>
</table>
</body>
</html>