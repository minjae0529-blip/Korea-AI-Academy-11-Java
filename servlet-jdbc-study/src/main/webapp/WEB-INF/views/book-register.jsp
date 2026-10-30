<%--
  Created by IntelliJ IDEA.
  User: rlawl
  Date: 26. 10. 28.
  Time: 오후 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input placeholder="책이름" onkeyup="handleBookNameInputOnKeyUp(event)">
<input placeholder="가격" onkeyup="handlePriceInputOnKeyUp(event)">
<button onclick="handleRegisterButonOnClick(event)">등록</button>

<script>
    let book = {
        bookName: "",
        price: 0,
    }

    function handleBookNameInputOnKeyUp(e) {
        console.log(e.target.value);
        book = {
            ...book,
            bookName: e.target.value,
        }
    }

    function handlePriceInputOnKeyUp(e) {
        console.log(e.target.value);
        book = {
            ...book,
            price: e.target.value,
        }
    }

    function handleRegisterButonOnClick(e) {
        console.log(e);
        console.log("호출!");

        fetch("http://localhost:8080/api/books", {
            method: "POST",
            body: JSON.stringify(book),
            headers: {
                "Content-Type": "application/json",
            }
        });
    }
</script>
</body>
</html>