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
    <title>회원가입</title>
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


    </style>
</head>
<script>
    function confirmModification() {
        return confirm("회원정보를 수정하시겠습니까?");
    }
</script>
<body>
<form action="/member/modMember.do" method="post" onsubmit="return confirmModification();">
    <script>
        confirm("개발자의 능력부족으로 인하여 입력창을 빈칸으로 처리시 어떤 일이 발생할지 모릅니다." +
            "그 사태에 대해서 이 사이트는 어떠한 책임도 지지 않습니다. 하지만 추후 업데이트 예정이니 양해부탁드립니다.")

    </script>
    <table>
        <thead>
        <tr>
            <th colspan="2"><h3 style="color: darkkhaki; text-align: center;">${requestScope.dto.mid}님정보수정</h3></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>

                <input type="hidden" name="mid" value="${requestScope.dto.mid}">
                <%-- request로 받아온 데이터를 jsp에 뿌린다. --%>
            </td>
        </tr>
        <tr>
            <td>
                비밀번호
            </td>
            <td>
                <input type="text" placeholder="PASSWORD" name="mpw"
                       value="${not empty param.mpw ? param.mpw : (not empty requestScope.dto.mpw ? requestScope.dto.mpw : '')}">
            </td>
        </tr>
        <tr>
            <td>
                이름
            </td>
            <td>
                <input type="text" placeholder="NAME" name="mname"
                       value="${not empty param.mname ? param.mname : (not empty requestScope.dto.mname ? requestScope.dto.mname : '')}">
            </td>
        </tr>
        <tr>
            <td>
                이메일
            </td>
            <td>
                <input type="email" placeholder="EMAIL" name="email"
                       value="${not empty param.email ? param.email : (not empty requestScope.dto.email ? requestScope.dto.email : '')}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">수정하기</button>
                <button type="reset">다시입력</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>

<%--<form action="/member/modMember.do" method="post">--%>
<%--    <table>--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th colspan="2"><h1>회원정보수정</h1></th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--       <tr>--%>

<%--            <td>--%>
<%--                <input type="hidden" name="mid" value="${requestScope.dto.mid}">--%>
<%--                &lt;%&ndash;request로 받아온 데이터를 jsp에 뿌린다.  &ndash;%&gt;--%>
<%--          </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                비밀번호--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <input type="password" placeholder="PASSWORD" name="mpw">--%>
<%--                <input type="hidden"  name="mpw" value="${requestScope.dto.mpw}">--%>
<%--               --%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                이름--%>
<%--            </td>--%>
<%--            <td>--%>

<%--                <input type="text" placeholder="NAME" name="mname">--%>
<%--                <input type="hidden"  name="mname" value="${requestScope.dto.mname}">--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                이메일--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <input type="email" placeholder="EMAIL" name="email">--%>
<%--                <input type="hidden"  name="email" value="${requestScope.dto.email}">--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan="2">--%>
<%--                <button type="submit">수정하기</button>--%>
<%--                <button type="reset">다시입력</button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</form>--%>
</body>
</html>
