<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String[] names = {"강민재", "강민재2"};
%>

<!DOCTYPE html>
<html>
    <head>
     <title>JSP - Hello World</title>
     </head>
     <body>
        <div>
            <b>Hello World!</b>
            <h1> <%= names[0]%> </h1>
        </div>

        <a href="hello-servlet">Hello Servlet</a>
        <button> 확인 </button>
        <button> 취소 </button>
     </body>
</html>