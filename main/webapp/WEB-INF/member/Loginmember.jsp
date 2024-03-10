<%--
  Created by IntelliJ IDEA.
  User: choij
  Date: 2024-03-08
  Time: 오후 5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>관리자로그인페이지</title>
  <style>
    body {
      margin: 0;
      text-align: center;
      margin-top: 80px;
    }

    table {
      margin: 0 auto; /* 테이블을 가로 중앙 정렬 */
      text-align: left; /* 테이블 내용은 왼쪽 정렬 유지 */
      border: 2px solid black; /* 테이블에 검은색 테두리 적용 */
    }

    td {
      padding: 10px; /* 각 셀에 패딩을 추가하여 레이아웃 조정 */
    }

    input {
      display: block;
      width: 100%; /* 입력 창을 가득 채우도록 너비 100% 지정 */
      box-sizing: border-box; /* 패딩과 테두리를 포함한 전체 너비를 지정 */
    }

    button {
      display: inline-block; /* 버튼을 인라인 블록 요소로 변경하여 가로로 출력 */
      margin-right: 10px; /* 버튼 사이의 간격을 조정 */
    }

    h1 {
      margin-bottom: 20px; /* "회원가입" 제목 아래 여백 추가 */
    }
  </style>
</head>
<body>
<c:if test="${param.result=='error'}">
  <span style="color: red"><h1>관리자가 아닌 사람은 들어올 수 없습니다.</h1> </span>
  <span style="color: red"><h2>다시입력해주세요</h2> </span>
</c:if>

<form action="/login" method="post">
  <table>
    <thead>
    <tr>
      <th colspan="2"><h1>관리자 로그인</h1></th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>
        아이디
      </td>
      <td>
        <input type="text" placeholder="ID" name="mid">
      </td>
    </tr>
    <tr>
      <td>
        비밀번호
      </td>
      <td>
        <input type="password" placeholder="PASSWORD" name="mpw">
      </td>
    </tr>
      <td colspan="2">
        <button type="submit">로그인</button>
        <button type="reset">다시입력</button>
      </td>
    </tr>
    </tbody>
  </table>
</form>
</body>
</html>
