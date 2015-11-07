<%@include file="../common/header.jsp"%>
<section class="success">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 text-center">
                <c:forEach items="${ teamList}" var="team" varStatus="plHandle">
                    <div id="teamrow-panel-wrap-${team.teamId}" class="panel panel-info">
                        <div class="panel-heading text-left">
                            ${team.teamName}
                            <a href="javascript:void(0);" class="expandTime" style="float: right; margin-top: ">
                            <span class="glyphicon glyphicon-circle-arrow-down icon-big"></span></a>
                        </div>
                        <div class="panel-body" style="display: none">
                            <div class="row" style="border-bottom: 1px solid blue">
                                <div class="col-lg-1 text-right">Sr.No.</div>
                                <div class="col-lg-4 text-left">Player Name</div>
                                <div class="col-lg-3">Chase Number</div>
                            </div>
                            <c:forEach items="${ team.playersList}" var="player" varStatus="plHandle">
                                <c:if test="${player.role ne 'COACH' && player.role ne 'MANAGER'}">
	                                <div class="row" style="border-bottom: 1px solid white">
	                                    <div class="col-lg-1 text-right">${plHandle.count }.</div>
	                                    <div class="col-lg-4 text-left">${player.firstName} ${player.lastName}</div>
	                                    <div class="col-lg-3">${plHandle.count }</div>
	                                </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<style>
.panel-body{background-color: #BCC4CA;}
.panel-body .row {margin: 0 -10px 0 -10px;}
</style>
<script type="text/javascript">
(function(window, document) {
        $(".expandTime").click(function() {
            if($(this).parent().parent().find('.panel-body').is(':visible')) {
                $(this).parent().parent().find('.panel-body').slideUp('slow');
                $(this).find('span').removeClass('glyphicon-circle-arrow-up').addClass('glyphicon-circle-arrow-down');
            } else {
                $(this).parent().parent().find('.panel-body').slideDown('slow');
                $(this).find('span').removeClass('glyphicon-circle-arrow-down').addClass('glyphicon-circle-arrow-up');
            }
        });
})(window, document);
</script>
<%@include file="../common/footer.jsp"%>