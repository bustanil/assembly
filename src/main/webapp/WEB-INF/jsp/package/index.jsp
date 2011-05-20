<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head><title>Wahoo Package index</title></head>
<body>
Level 1:
    <a href="<%=request.getContextPath()%>/package/index">All</a>
    <a href="<%=request.getContextPath()%>/package/intel/index">Intel</a>
    <a href="<%=request.getContextPath()%>/package/amd/index">AMD</a>
    <a href="<%=request.getContextPath()%>/package/price/index">Price</a>
    <a href="<%=request.getContextPath()%>/package/performance/index">Performance</a>
<br>
Level 2:
<c:forEach var="level2" items="${level2Categories}">
    <a href="<%=request.getContextPath()%>/package/${level1Category.name}/${level2.name}">${level2.label}</a>
</c:forEach>
</body>
</html>