<%--
  Created by IntelliJ IDEA.
  User: kangminjae
  Date: 26. 10. 26.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" onsubmit="handleOnSubmit(event)">
    <div>
        <input type="text" name="username" placeholder="사용자 이름" onkeyup="handleOnChange(event)">
    </div>
    <div>
        <input type="password" name="password" placeholder="비밀번호" onkeyup="handleOnChange(event)">
    </div>
    <div>
        <input type="text" name="name" placeholder="이름" onkeyup="handleOnChange(event)">
    </div>
    <button>등록하기</button>
</form>

<script>
    let user = {
        username: "",
        password: "",
        name: "",
    }

    function handleOnChange(event) {
        const name = event.target.name;
        const value = event.target.value;
        user ={
            ...user,
            [name] : value,
        };

        console.log(user);
    }
    async function registerApi(data) {
        const jsonData = JSON.stringify(data);

        // fetch(URL, 옵션객체) 형태로 괄호 감싸기
        const response = await fetch("http://localhost:8080/api/users", {
            method: "post",         //create 해주는것임
            headers: {
                "Content-Type": "application/json",
            },
            body: jsonData,     //주데이터, 전송에 사용되는 데이터임.
        });

        console.log(response);
        //status : 200
        const responseBody = await response.json();
        console.log(responseBody);
        alert(responseBody.message);

        //status : 400
        if(response.status !== 200){
            alert(responseBody.message);
            return ;
        }

        location.replace("/user/list");     //replace : 페이지 이동 , 히스토리가 안남고, 뒤로가기가 불가능함

        // 서버가 돌려준 응답 받기 (보통 필요합니다!)
        const result = await response.json();
        return result;
    }

    function handleOnSubmit(event){
        event.preventDefault();     //기존의 디폴트로 있는 이벤트를 제거하는 것임
        registerApi(user);
    }
</script>

</body>
</html>
