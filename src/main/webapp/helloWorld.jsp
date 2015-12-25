<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%--<script style="text/javascript" src="${ctx}/helloWorld.js" ></script>--%>
<h2>Hello World!</h2>
<input type="button" value="Button1" id="button1"/>
<script>
    $(function() {
        $("#button1").click(function() {
            $.ajax({
                type:"POST", // 提交方式
                url:ctx_global+"/getUser", // 路径
                // 预期服务器返回的数据类型。如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断
//                dataType: "json", //contenttype  类型
                headers:{name:"lov"}, // 设置 header 头信息
                data:{
                    name:"angel",
                    desc:"cat"
                }, // 数据，这里使用Json格式进行传输
                success:function(result){//返回数据根据结果进行相应的处理
                    console.log(result);
                },
                error:function(){
                    console.log("error");
                }
            })
        });
    });
</script>
</body>
</html>
