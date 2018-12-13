<%--
  Created by IntelliJ IDEA.
  User: chenwei
  Date: 2018/9/28
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
//    String path = request.getContextPath();
//    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//    out.println("basePath:"+basePath);
//    out.println("<br/>");
//    out.println("getContextPath:"+request.getContextPath());
//    out.println("<br/>");
//    out.println("getServletPath:"+request.getServletPath());
//    out.println("<br/>");
//    out.println("getRequestURI:"+request.getRequestURI());
//    out.println("<br/>");
//    out.println("getRequestURL:"+request.getRequestURL());
//    out.println("<br/>");
//    out.println("getRealPath:"+request.getRealPath("/"));
//    out.println("<br/>");
//    out.println("getServletContext().getRealPath:"+request.getServletContext().getRealPath("/"));
//    out.println("<br/>");
//    out.println("getQueryString:"+request.getQueryString());
%>
<body>

<label id="name" onfocus="true"> 测试用例</label>

<br/>

<div id ="fileUp">
    单个文件上传:<br/>

    <form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="提交上传">
    </form>
</div>

</body>
</html>
