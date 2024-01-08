<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Team</title>
</head>
<body>
	<form action="../validate/add-team.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<thead>
				<tr>
					<th colspan="2">Add a team to IPL</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td><label for="name">Name</label></td>
					<td><input type="text" id="name" name="name" required /></td>
				</tr>

				<tr>
					<td><label for="abbr">Abbreviation</label></td>
					<td><input type="text" id="abbr" name="abbr" required /></td>
				</tr>

				<tr>
					<td><label for="owner">Owner</label></td>
					<td><input type="text" id="owner" name="owner" required /></td>
				</tr>

				<tr>
					<td><label for="maxAge">Max Age</label></td>
					<td><input type="number" id="maxAge" name="maxAge" required /></td>
				</tr>

				<tr>
					<td><label for="minBattingAvg">Min Batting Avg</label></td>
					<td><input type="text" id="minBattingAvg" name="minBattingAvg"
						required /></td>
				</tr>

				<tr>
					<td><label for="minWicketsTaken">Min Wickets Taken</label></td>
					<td><input type="number" id="minWicketsTaken"
						name="minWicketsTaken" required /></td>
				</tr>

				<tr>
					<td align="center" colspan="2"><button type="submit">Add
							Team</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>