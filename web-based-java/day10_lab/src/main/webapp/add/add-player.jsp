<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add player</title>
</head>
<jsp:useBean id="player" scope="session" class="beans.PlayerBean" />
<body>
	<form action="../validate/add-player.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">

			<thead>
				<tr>
					<th colspan="2">Add a player to IPL team</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td><label for="teams">Choose a Team</label></td>
					<td><select id="teams" name="teamId">
							<c:forEach var="t" items="${sessionScope.team.allTeams}">
								<option value="${t.id}">${t.abbreviation}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td><label for="firstName">First Name</label></td>
					<td><input type="text" id="firstNname" name="firstName"
						required /></td>
				</tr>

				<tr>
					<td><label for="lastName">Last Name</label></td>
					<td><input type="text" id="lastName" name="lastName" required /></td>
				</tr>

				<tr>
					<td><label for="dob">DoB</label></td>
					<td><input type="date" id="dob" name="dob" required /></td>
				</tr>

				<tr>
					<td><label for="bAvg">Batting Average</label></td>
					<td><input type="text" id="bAvg" name="batting_avg" required /></td>
				</tr>

				<tr>
					<td><label for="wTaken">Wickets Taken</label></td>
					<td><input type="number" id="wTaken" name="wickets_taken"
						required /></td>
				</tr>

				<tr>
					<td align="center" colspan="2"><button type="submit">Add
							Player</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>