<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MES</title>
</head>
<body>
<script type="text/javascript">
    <c:if test="${message != null}">
    alert("${message}");
    </c:if>

    <c:if test="${target != null}">
    window.location.href = "${target}";
    </c:if>
</script>
</body>
</html>