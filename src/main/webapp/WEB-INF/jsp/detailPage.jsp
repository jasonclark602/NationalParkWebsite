<%@include file="common/header.jspf"%>

<div class="detailContainer">
	<div class="parkInfo">
		<div class="detailImg">
		<c:url var="parkDetailImgUrl" value="/img/parks/${park.parkCode}.jpg" />
		<img src="${parkDetailImgUrl}" />
		</div>
		<div class="parkDetails">
		<h2><c:out value="${park.parkName}" /><span class="est"><c:out value=" est. ${park.yearFounded}" /></span></h2>
		<h3><c:out value="Location: " /><strong><c:out value="${park.state}" /></strong></h3>
		<h6><c:out value="'${park.inspirationalQuote}' - ${park.inspirationalQuoteSource}" /></h6>
		<br>
		<table class="parkInfo">
			<tr>
				<th><c:out value="Acreage" /></th>
				<th><c:out value="Ann. Visitor Count" /></th>
				<th><c:out value="Climate" /></th>
				<th><c:out value="Elevation" /></th>
				<th><c:out value="Entry Fee" /></th>
				<th><c:out value="Miles of Trail" /></th>
				<th><c:out value="# of Species" /></th>
				<th><c:out value="# of Campsites" /></th>
			</tr>
			<tr>
				<td><c:out value="${park.acreage}" /></td>
				<td><c:out value="${park.annualVisitorCount}" /></td>
				<td><c:out value="${park.climate}" /></td>
				<td><c:out value="${park.elevationInFeet}" /></td>
				<td><c:out value="$${park.entryFee}" /></td>
				<td><c:out value="${park.milesOfTrail}" /></td>
				<td><c:out value="${park.numberOfAnimalSpecies}" /></td>
				<td><c:out value="${park.numberOfCampsites}" /></td>
			</tr>
		
		</table>
		<h3><c:out value="Description:" /></h3>
		<p><c:out value="${park.parkDescription}" /></p>
		</div>
	</div>
	<div class="weatherDiv">
		<div class="todayWeather">
			<c:forEach var="todayForecast" items="${todayWeather}">
				
			</c:forEach>
		</div>
	</div>
</div>
<%@include file="common/footer.jspf"%>