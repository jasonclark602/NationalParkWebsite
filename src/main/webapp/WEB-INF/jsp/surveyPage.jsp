<%@include file="common/header.jspf"%>

<c:url var="surveyActionUrl" value="/surveyPage" />
<form method="POST" action="${surveyActionUrl}">
	<label for="email"><c:out value="Email: " /></label>
		<input type="email" id="emailAddress" name="emailAddress" required />
	<label for="parkCode"><c:out value="Favorite Park:" /></label>
		<select name="parkCode" id="parkCode" required>
			<c:forEach var="park" items="${parks}">
				<option value="${park.parkCode}"><c:out value="${park.parkName}" /></option>
			</c:forEach>
		</select> 
	<label for="state"><c:out value="State of Residence:" /></label>
		<select name="state" id="state" required>
			<option value="Alabama"><c:out value="Alabama" /></option>
			<option value="Alaska"><c:out value="Alaska" /></option>
			<option value="Arizona"><c:out value="Arizona" /></option>
			<option value="Arkansas"><c:out value="Arkansas" /></option>
			<option value="California"><c:out value="California" /></option>
			<option value="Colorado"><c:out value="Colorado" /></option>
			<option value="Connecticut"><c:out value="Connecticut" /></option>
			<option value="Delaware"><c:out value="Delaware" /></option>
			<option value="District of Columbia"><c:out value="District Of Columbia" /></option>
			<option value="Florida"><c:out value="Florida" /></option>
			<option value="Georgia"><c:out value="Georgia" /></option>
			<option value="Hawaii"><c:out value="Hawaii" /></option>
			<option value="Idaho"><c:out value="Idaho" /></option>
			<option value="Illinois"><c:out value="Illinois" /></option>
			<option value="Indiana"><c:out value="Indiana" /></option>
			<option value="Iowa"><c:out value="Iowa" /></option>
			<option value="Kansas"><c:out value="Kansas" /></option>
			<option value="Kentucky"><c:out value="Kentucky" /></option>
			<option value="Louisiana"><c:out value="Louisiana" /></option>
			<option value="Maine"><c:out value="Maine" /></option>
			<option value="Maryland"><c:out value="Maryland" /></option>
			<option value="Massachusetts"><c:out value="Massachusetts" /></option>
			<option value="Michigan"><c:out value="Michigan" /></option>
			<option value="Minnesota"><c:out value="Minnesota" /></option>
			<option value="Mississippi"><c:out value="Mississippi" /></option>
			<option value="Missouri"><c:out value="Missouri" /></option>
			<option value="Montana"><c:out value="Montana" /></option>
			<option value="Nebraska"><c:out value="Nebraska" /></option>
			<option value="Nevada"><c:out value="Nevada" /></option>
			<option value="New Hampshire"><c:out value="New Hampshire" /></option>
			<option value="New Jersey"><c:out value="New Jersey" /></option>
			<option value="New Mexico"><c:out value="New Mexico" /></option>
			<option value="New York"><c:out value="New York" /></option>
			<option value="North Carolina"><c:out value="North Carolina" /></option>
			<option value="North Dakota"><c:out value="North Dakota" /></option>
			<option value="Ohio"><c:out value="Ohio" /></option>
			<option value="Oklahoma"><c:out value="Oklahoma" /></option>
			<option value="Oregon"><c:out value="Oregon" /></option>
			<option value="Pennsylvania"><c:out value="Pennsylvania" /></option>
			<option value="Rhode Island"><c:out value="Rhode Island" /></option>
			<option value="South Carolina"><c:out value="South Carolina" /></option>
			<option value="South Dakota"><c:out value="South Dakota" /></option>
			<option value="Tennessee"><c:out value="Tennessee" /></option>
			<option value="Texas"><c:out value="Texas" /></option>
			<option value="Utah"><c:out value="Utah" /></option>
			<option value="Vermont"><c:out value="Vermont" /></option>
			<option value="Virginia"><c:out value="Virginia" /></option>
			<option value="Washington"><c:out value="Washington" /></option>
			<option value="West Virginia"><c:out value="West Virginia" /></option>
			<option value="Wisconsin"><c:out value="Wisconsin" /></option>
			<option value="Wyoming"><c:out value="Wyoming" /></option>
		</select>
	<label for="activityLevel"><c:out value="Activity Level:" /></label>
		<select name="activityLevel" id="activityLevel" required>
			<option value="Inactive"><c:out value="Inactive" /></option>
			<option value="Sedentary"><c:out value="Sedentary" /></option>
			<option value="Active"><c:out value="Active" /></option>
			<option value="Extremely Active"><c:out value="Extremely Active" /></option>
		</select>
	<input type="submit" value="Submit Survey!" />
</form>

<%@include file="common/footer.jspf"%>