<%@include file="common/header.jspf"%>

<h1 class = "favoriteParksHeader">Our Top Parks!</h1>

<c:forEach var = "favoriteParks" items = "${favoriteParks }" >

<div class = "parkOverview">
		<div class ="parkImage">
		<c:url var = "parkImageUrl" value = "/img/parks/${favoriteParks.parkCode }.jpg"/>
		<c:url var = "detailPageUrl" value = "/detailPage?parkCode=${favoriteParks.parkCode}"/>
		<a href = "${detailPageUrl }"><img src = "${parkImageUrl }"/></a> 
		</div>
		
		<div class = "parkDescription">
		<c:url var = "detailPageUrl" value = "/detailPage?parkCode=${favoriteParks.parkCode}"/>
		<h1><a href = "${detailPageUrl}" ><c:out value = "${favoriteParks.parkName }"/></a>
		<span class = "surveyCount"><c:out value = "Recieved ${favoriteParks.numberOfSurveys } Vote(s)!!!"/></span></h1>
		<strong class = "location"><c:out value = "${favoriteParks.state }"/></strong>
		<p class = "description"><c:out value = "${favoriteParks.parkDescription }"/></p>
		</div>


</div>
</c:forEach>









<%@include file="common/footer.jspf"%>