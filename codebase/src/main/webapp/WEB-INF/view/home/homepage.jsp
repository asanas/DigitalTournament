<%@include file="../common/common-taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Digital Tournament</title>
<script src="${pageContext.request.contextPath}/static_content/js/common/commonUtils.js"></script>
</head>
<body>
<ul>
    <c:forEach items="${homePageMenus}" var="mainMenu">
        <li><a href="${pageContext.request.contextPath}/${mainMenu.menuURL}" class="${mainMenu.className}" title="${mainMenu.menuDescription}" onclick="javascript:${mainMenu.jsFunctionCall}">${mainMenu.displayText}</a></li>
    </c:forEach>
</ul>
</body>
</html>