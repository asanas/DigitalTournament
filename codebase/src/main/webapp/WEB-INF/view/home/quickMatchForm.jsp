<%@include file="../common/common-taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fill details to start a quick match</title>
<script src="${pageContext.request.contextPath}/static_content/js/common/commonUtils.js"></script>
</head>
<body>
<h1>Fill in below details to start quick match</h1>
<ul>
    <c:forEach items="${cities}" var="cityName">
        <li>cityName</li>
    </c:forEach>
</ul>
</body>
</html>