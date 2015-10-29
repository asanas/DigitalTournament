<%@include file="../common/header.jsp"%>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-4">&nbsp;</div>
            <div class="col-lg-4">
                <ul class="nav nav-pills nav-stacked">
                    <c:forEach items="${homePageMenus}" var="mainMenu">
                        <li><a
                            href="${pageContext.request.contextPath}/${mainMenu.menuURL}"
                            class="${mainMenu.className}" title="${mainMenu.menuDescription}"
                            onclick="javascript:${mainMenu.jsFunctionCall}">${mainMenu.displayText}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-lg-4">&nbsp;</div>
        </div>
    </div>
</header>
<%@include file="../common/footer.jsp"%>
