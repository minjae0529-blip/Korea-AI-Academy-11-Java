<%@ page import="com.korai.serveltstudy2.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kangminjae
  Date: 26. 10. 26.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<User> users = (List<User>) request.getAttribute("userList");
%>

<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid #222;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #222;
            width: 300px;
            height: 40px;
        }

    </style>
</head>
<body>
    <button onclick="location.href='http://localhost:8080/user/register'">등록</button><div>
    <table>
        <thead>
        <tr>
            <th>1</th>
            <th>aaa</th>
            <th>1234</th>
            <th>강민재</th>
        </tr>
        </thead>
        <tbody>
        <%
            //스크립 틀릿
            for(User user : users){
            %>
        %>
        <tr>
            <td><%=user.getId() %>></td>
            <td><%=user.getUsername()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getName()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
