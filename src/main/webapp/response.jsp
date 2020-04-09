<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/9
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        //页面加载
        $(function () {
            $("#btn").click(function () {
                // alert("hello");
                $.ajax({
                    url:"/user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"userName":"张三","password":"123465","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data.userName);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            })
        });
    </script>
</head>
<body>
    <a href="/user/testString">testString</a>   <br>
    <a href="/user/testVoid">testVoid</a>   <br>
    <a href="/user/testModelAndView">testModelAndView</a>   <br>
    <a href="/user/testForwardOrRedirect">testForwardOrRedirect</a>   <br>
    <button id="btn">发送Ajax请求</button>
</body>
</html>
