<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Maven Demo</title>
</head>
<body>
<h1>所有的演示例子</h1>
<h3><a href="exDao?id=1">Dao正常错误</a></h3>
<h3><a href="exDao?id=10">Dao参数错误</a></h3>
<h3><a href="exDao?id=">Dao未知错误</a></h3>
<br />
<h3><a href="exService?id=1">Service正常错误</a></h3>
<h3><a href="exService?id=10">Service参数错误</a></h3>
<h3><a href="exService?id=">Service未知错误</a></h3>
<br />
<h3><a href="exController?id=1">Controller正常错误</a></h3>
<h3><a href="exController?id=10">Controller参数错误</a></h3>
<h3><a href="exController?id=">Controller未知错误</a></h3>
<br />
<h3><a href="./404?id=1">404错误</a></h3>
</body>
</html>
