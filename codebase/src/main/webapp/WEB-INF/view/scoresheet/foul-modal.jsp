<button id="loadFoulModal" type="button" class="btn btn-info fixed attach-right" style="padding: 0px 2px 10px;">
    <span class="glyphicon glyphicon-circle-arrow-left icon-big "></span>
</button>

<div class="foul-panel fixed attach-right">
    <table class="table table-condensed">
        <thead>
            <tr>
                <th colspan="2"> ${chasingTeamName }</th>
                <th colspan="2" class="text-right">
			        <span id="hideFoulModal" class="glyphicon glyphicon-circle-arrow-right icon-big" style="color:#D0D0D4; cursor: pointer;"></span>
				</th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${ foulsList}" var="foulDetails" varStatus="fdHandle">
                <tr>
                    <td class="text-left">${fdHandle.count }. ${foulDetails.foulName }:</td>
                    <td class="text-left"><a id="foulMinus${foulDetails.foulId}" href="javascript:void(0);" class="adjustFoulCount"><span class="glyphicon glyphicon-minus icon-small" style="margin-top: 5px; color:#979877;"></span></a></td>
                    <td id="foulCount${foulDetails.foulId}" class="text-center">${foulDetails.foulCount } </td>
                    <td class="text-right"><a id="foulPlus${foulDetails.foulId}" href="javascript:void(0);" class="adjustFoulCount"><span class="glyphicon glyphicon-plus icon-small" style="margin-top: 5px; color:#979877;"></span></a></td>
                </tr>
            </c:forEach>
        </tbody>
  </table>
</div>

