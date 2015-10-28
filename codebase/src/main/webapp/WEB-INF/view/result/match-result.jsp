<%@include file="../common/common-taglibs.jsp"%>
    <div class="modal-dialog modal-lg">
        <!-- Modal content-->
        <div class="modal-content ${modalClass }">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title text-center">${resultTitle }</h2>
            </div>
            <div class="modal-body ${modalClass }">
                <div class="row">
                    <div class="col-lg-6 text-center"><h3>${team1Name }</h3></div>
                    <div class="col-lg-6 text-center"><h3>${team2Name }</h3></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-center"><h3>${team1Score }</h3></div>
                    <div class="col-lg-6 text-center"><h3>${team2Score }</h3></div>
                </div>
                <div class="row">
                    <div class="col-lg-12 text-center"><hr class="star-light results"></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-left">
                        <div class="row">
                            <table class="table table-condensed" style="width: 100%;">
                                <tr>
                                  <td style="width: 50%"><span class="performanceLabel">Defence <img src="${pageContext.request.contextPath}/static_content/images/defenceIcon.png" height="20px" ></span></td>
                                  <td><span class="performanceLabel">Attack <img src="${pageContext.request.contextPath}/static_content/images/chasingIcon.png" height="22px" style="margin-top: -12px;"></span></td>
                                </tr>
                                <tr>
                                  <td class="defenders">
                                    <ul class="list-group">
                                        <c:choose>
                                            <c:when test="${ not empty team1Defenders}">
                                                <c:forEach items="${team1Defenders }" var="topDefender" varStatus="tdHandle">
                                                    <li class="list-group-item"><span class="badge">${topDefender.formattedPerTime }</span> ${topDefender.playerName }</li>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                    <li class="list-group-item">--</li>
                                            </c:otherwise>
                                        </c:choose>
                                    </ul>
                                  </td>
                                  <td class="attackers">
                                    <ul class="list-group">
                                        <c:choose>
                                            <c:when test="${ not empty team1Attackers}">
                                                <c:forEach items="${team1Attackers }" var="topAttacker" varStatus="tdHandle">
                                                    <li class="list-group-item"><span class="badge">${topAttacker.count }</span> ${topAttacker.playerName }</li>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                    <li class="list-group-item">--</li>
                                            </c:otherwise>
                                        </c:choose>
                                    </ul>
                                  </td>
                                </tr>
                             </table>
                        </div>
                    </div>
                    <div class="col-lg-6 text-left">
                        <div class="row">
                            <table class="table table-condensed" style="width: 100%;">
                                <tr>
                                  <td style="width: 50%"><span class="performanceLabel">Defence <img src="${pageContext.request.contextPath}/static_content/images/defenceIcon.png" height="20px" ></span></td>
                                  <td><span class="performanceLabel">Attack <img src="${pageContext.request.contextPath}/static_content/images/chasingIcon.png" height="22px" style="margin-top: -12px;"></span></td>
                                </tr>
                                <tr>
                                  <td class="defenders">
                                    <c:choose>
                                        <c:when test="${ not empty team2Defenders}">
                                            <c:forEach items="${team2Defenders }" var="topDefender" varStatus="tdHandle">
                                                <li class="list-group-item"><span class="badge">${topDefender.formattedPerTime }</span> ${topDefender.playerName }</li>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                                <li class="list-group-item">--</li>
                                        </c:otherwise>
                                    </c:choose>
                                  </td>
                                  <td class="attackers">
                                    <ul class="list-group">
                                        <c:choose>
                                            <c:when test="${ not empty team2Attackers}">
                                                <c:forEach items="${team2Attackers }" var="topAttacker" varStatus="tdHandle">
                                                    <li class="list-group-item"><span class="badge">${topAttacker.count }</span> ${topAttacker.playerName }</li>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                    <li class="list-group-item">--</li>
                                            </c:otherwise>
                                        </c:choose>
                                    </ul>
                                  </td>
                                </tr>
                             </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 text-center"><h3 style="font-size: 25px;">${ resultDescription}</h3></div>
                </div>
            </div>
            <div class="modal-footer">
                &nbsp;
            </div>
        </div>
    </div>