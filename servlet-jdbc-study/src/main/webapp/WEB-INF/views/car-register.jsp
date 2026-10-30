<%--
  Created by IntelliJ IDEA.
  User: rlawl
  Date: 26. 10. 28.
  Time: 오전 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input placeholder="차량명" onkeyup="handleCarNameInputOnKeyUp(event)">
<input placeholder="색상" onkeyup="handleCarColorInputOnKeyUp(event)">
<input placeholder="가격" onkeyup="handlePriceInputOnKeyUp(event)">
<button onclick="handleRegisterButonOnClick(event)">등록</button>

<script>
    let car = {
        carName: "",
        color: "",
        price: 0,
    }

    function handleCarNameInputOnKeyUp(e) {
        console.log(e.target.value);
        car = {
            ...car,
            carName: e.target.value,
        }
    }

    function handleCarColorInputOnKeyUp(e) {
        console.log(e.target.value);
        car = {
            ...car,
            color: e.target.value,
        }
    }

    function handlePriceInputOnKeyUp(e) {
        console.log(e.target.value);
        car = {
            ...car,
            price: e.target.value,
        }
    }

    // 서버의 API(/api/cars)로 데이터를 전송
    async function registerApi(data) {
        // 자바스크립트 객체를 JSON 글자 형식으로 변환
        const jsonData = JSON.stringify(data);

        // 서버에 POST 방식으로 데이터 전송
        const response = await fetch("http://192.168.7.83:8080/api/cars", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: jsonData,
        });

        console.log(response);

        // 서버가 준 데이터(JSON) 확인
        const responseBody = await response.json();
        console.log(responseBody);
        alert(responseBody.message);

        if (response.status !== 200) {
            return;
        }
        location.replace("/car/list");
    }

    function handleRegisterButonOnClick(event) {
        registerApi(car); // 서버에 차량 등록 요청 전송
    }
</script>
</body>
</html>