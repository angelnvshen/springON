<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
    String path = request.getContextPath();
%>
<script>
    var ctx_global = "${ctx}";
</script>
<html>
<body>
<script style="text/javascript" src="${ctx}/static/js/jquery/jquery-1.7.2.min.js" ></script>
<script style="text/javascript" src="${ctx}/helloWorld.js" ></script>
<h2>Hello World!</h2>
<input type="button" value="Button1" id="button1"/>
</body>
</html>
