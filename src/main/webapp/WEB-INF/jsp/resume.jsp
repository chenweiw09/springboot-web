<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenwei
  Date: 2018/12/12
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <script type="text/javascript">

        // var url="../../app/plugins/web/viewer.html?file=/app/resume/preview"; //获得本窗口属性名
        // newWin=window.open(url,'','fullscreen=1,scrollbars=0');
        // window.opener=null;//出掉关闭时候的提示窗口
        // window.open('','_self'); //ie7
        // window.close();
        window.location.href="<%=request.getContextPath()%>/plugins/web/viewer.html?file=<%=request.getContextPath()%>/resume/preview"

    </script>
</div>

</body>
</html>