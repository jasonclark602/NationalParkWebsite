<%@include file="common/header.jspf"%>

<c:forEach var = "parks" items = "${parks }" >

<div class = "parkOverview">
		<div class ="parkImage">
		<c:url var = "parkImageUrl" value = "/img/parks/${parks.parkCode }.jpg"/>
		<c:url var = "detailPageUrl" value = "/detailPage?parkCode=${parks.parkCode}"/>
		<a href = "${detailPageUrl }"><img src = "${parkImageUrl }"/></a> 
		</div>
		
		<div class = "parkDescription">
		<c:url var = "detailPageUrl" value = "/detailPage?parkCode=${parks.parkCode}"/>
		<h1><a href = "${detailPageUrl}" ><c:out value = "${parks.parkName }"/></a></h1>
		<strong class = "location"><c:out value = "${parks.state }"/></strong>
		<p class = "description"><c:out value = "${parks.parkDescription }"/></p>
		</div>


</div>
</c:forEach>




<%@include file="common/footer.jspf"%>