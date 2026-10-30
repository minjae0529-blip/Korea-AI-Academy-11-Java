<%--
  Created by IntelliJ IDEA.
  User: rlawl
  Date: 26. 10. 28.
  Time: 오후 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            width: 200px;
        }
    </style>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>일련번호</th>
        <th>책이름</th>
        <th>가격</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
<button onclick="location.href='http://192.168.7.83:8080/book/register'">등록</button>
<script>

    async function getBookList() {
        const response = await fetch("http://192.168.7.83:8080/api/books", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            }
        });
        if (response.status === 200) {
            const responseJson = await response.json();
            console.log(response);
            console.log(responseJson);
            const tbody = document.querySelector("tbody");
            tbody.innerHTML = responseJson.map((car, index) => (
                "<tr><td>" + (index + 1) + "</td><td>" + car.bookName + "</td><td>" + car.price + "</td></tr>"
            )).join("");
        } else {
            console.error("책 목록 조회 실패:", response.status);
        }
    }

    getBookList();

</script>
</body>
</html>