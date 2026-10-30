<%--
  Created by IntelliJ IDEA.
  User: kangminjae
  Date: 26. 10. 26.
  Time: 오전 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 1. User 클래스 import 추가 --%>
<%@ page import="com.korai.serveltstudy2.model.User" %>

<%
  User user = new User(1, "user1", "1q2w3e4r!", "강민재");
%>

<html>
<head>
  <title>Title</title>
</head>
<body>
<%-- 2. 끝에 %> 를 꼭 닫아주기 --%>
<h1> <%= user.getId() %> </h1>
<h1> <%= user.getUsername() %> </h1>
<h1> <%= user.getPassword() %> </h1>
</body>
</html>