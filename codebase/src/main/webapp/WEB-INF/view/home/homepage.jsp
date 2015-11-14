<%@include file="../common/header.jsp"%>
<header>
    <div class="container">
        <%@include file="load-tournament-list-modal.jsp"%>
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
<style>
<!--
a.main_menu { border: 1px solid #610956;}
-->
</style>
<%@include file="../common/footer.jsp"%>
<script>
function showLoadTournamentModal() {
    
}
</script>