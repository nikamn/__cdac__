<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Team</title>
</head>
<body>
	<form action="../validate/rm-team.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">

			<thead>
				<tr>
					<th colspan="2">Remove IPL team</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td><label for="teams">Choose a Team</label></td>
					<td><select id="teams" name="abbr">
							<c:forEach var="t" items="${sessionScope.team.allTeams}">
								<option value="${t.abbreviation}">${t.abbreviation}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td align="center" colspan="2"><button type="submit">Remove
							Team</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>