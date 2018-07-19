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
		<br>
		<a class = "button btn btn-default" href = "" >Change To Celsius</a>
	</div>
	<div class="weatherDiv">
		<div class="todayWeather">
			<c:forEach var="todayForecast" items="${todayWeather}">
			<br>
			<h4 class = "title"><c:out value = " Today"/></h4>
			<c:url var = "forecastImageUrl" value = "/img/weather/${todayForecast.forecast }.png"/>
			<img src = "${forecastImageUrl }"/>
			<div class = "highLow"><c:out value = "Low: ${todayForecast.low }   High: ${todayForecast.high }"/></div>
			<div class = "forecast"><c:out value = "Forecast: ${todayForecast.forecast }"/></div>
			<c:choose>
				<c:when test = "${todayForecast.forecast.equals('snow') }">
				<div class = "reccomendation"><c:out value = "Pack Snow Shoes!"/></div>
				</c:when>
				
				<c:when test = "${todayForecast.forecast.equals('rain') }">
				<div class = "reccomendation"><c:out value = "Pack Rain Gear and Waterproof Shoes!"/></div>
				</c:when>
				
				<c:when test = "${todayForecast.forecast.equals('thunderstorms') }">
				<div class = "reccomendation"><c:out value = "Seek Shelter and Avoid Hiking on Exposed Ridges!"/></div>
				</c:when>
				
				<c:when test = "${todayForecast.forecast.equals('sunny') }">
				<div class = "reccomendation"><c:out value = "Pack Sunblock!"/></div>
				</c:when>
			
			
			</c:choose>
			
			<c:choose>
				<c:when test = "${todayForecast.high > 75 }">
				<div class = "reccomendation"><c:out value = "Bring an Extra Gallon of Water!"/></div>
				</c:when>
				
				<c:when test = "${todayForecast.low < 20 }">
				<div class = "reccomendation"><c:out value = "Be Careful of Frigid Temperatures, Stay Warm!"/></div>
				</c:when>
				
				<c:when test = "${todayForecast.high - todayForecast.low > 20}">
				<div class = "reccomendation"><c:out value = "Wear Breathable Layers!"/></div>
				</c:when>
			
			
			</c:choose>
			
				
			</c:forEach>
		</div>
		
		
		
		<div class = "weekWeather">
		
				<c:forEach var = "weekWeather" items = "${weekWeather }">
					<div class = "weatherDay"><c:url var = "forecastImageUrl" value = "/img/weather/${weekWeather.forecast }.png"/>
					<div class = "weeklyImages"><img src = "${forecastImageUrl }"/></div>
					<div class = "highLow2"><c:out value = "Low: ${weekWeather.low }"/></div>
					<div class = "highLow2"><c:out value = "High: ${weekWeather.high }"/></div>
					</div>
				
				
				</c:forEach>
		
		
		
		</div>
	</div>
</div>
<%@include file="common/footer.jspf"%>