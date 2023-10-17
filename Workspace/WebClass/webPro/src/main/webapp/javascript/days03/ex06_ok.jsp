<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="shortcut icon" href="http://localhost/webPro/images/SiSt.ico">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- vscode용 css/js 경로 -->
    <link rel="stylesheet" href="/webPro/src/main/webapp/resources/cdn-main/example.css">
    <script src="/webPro/src/main/webapp/resources/cdn-main/example.js"></script>
    <!-- 이클 톰캣 css/js 경로 -->
    <link rel="stylesheet" href="/webPro/resources/cdn-main/example.css">
    <script src="/webPro/resources/cdn-main/example.js"></script>

    <style>
        span.material-symbols-outlined {
            vertical-align: text-bottom;
        }
    </style>
</head>
<body>
<header>
    <h1 class="main">
        <a href="#" style="position: absolute;top:30px;">pilot0311</a>
    </h1>
    <ul>
        <li>
            <a href="#">로그인</a>
        </li>
        <li>
            <a href="#">회원가입</a>
        </li>
    </ul>
</header>
<h3>
    <span class="material-symbols-outlined">view_list</span>
    <a target="_blank" href="https://api.jquery.com/">JSP</a> days03
</h3>
<h1 class="main">ex06_ok<small>.jsp</small></h1>
<div>
      <pre class="code">

      </pre>
    <%
        // jsp 9 내장 객체
        String subejct = request.getParameter("subject");
        // System.out.printf("> subject = %s\n", subject);
    %>


    선택한 과목 : <%= subejct %><br>
    <br>
    <br>
    [ex06.html 선택한 과목] <br>
    <input type="radio" name="subject" value="kor"><label for="">국어</label></input>
    <input type="radio" name="subject" value="eng"><label for="">영어</label></input>
    <input type="radio" name="subject" value="mat"><label for="">수학</label></input>
    <input type="radio" name="subject" value="pe"><label for="">체육</label></input>

    <br>
    <br>
    <!-- BOM : window, document, history.go(-1), go(1) 또는 forward() -->
    <a href="javascript:history.back()">뒤로 가기</a>

</div>

<script>
    let subject = '<%= subejct %>';
    // document.querySelector("input[name=subject][value="+subject+"]").checked=true;
    document.querySelector(`input[name=subject][value=\${subject}]`).checked=true;
    /*[방법 1]
    //js
    // let inputs = document.querySelectorAll("input[name=subject]");
    // for (var i = 0; i < inputs.length; i++) {
    //     if(inputs[i].value === subject) {
    //         inputs[i].checked = true;
    //         break;
    //     }
    // }

    //jquery
    $("input[name=subject]").each(function (i,element) {
        // console.log(element.value);
        // console.log($(element).val());

        if (element.value == subject){
            element.checked=true;
            return
        }
    })
     */
    /* let subjects = document.getElementsByName("subject");
    document.querySelectorAll("input[name=subject]"); */

</script>

</body>
</html>