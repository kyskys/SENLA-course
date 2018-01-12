<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>${pageTitle}</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	Menu:
	<a href="/webapps/masters">Master</a>
	<a href="/webapps/orders">Order</a>
	<a href="/webapps/sits">Sit</a>
	<a href="/webapps/garages">Garage</a>
	<table>
		<tbody>
			<tr>
				<c:forEach var="column" items="${columns}">
					<td>${column}</td>
				</c:forEach>
			</tr>
			<c:forEach var="row" items="${content}">
				<tr>
					<c:forEach var="value" items="${row}">
						<td>${value}</td>
					</c:forEach>
					<c:if test="${hasDeleteLink}">
						<td><a href="${deleteLinkValue}">delete</a></td>
					</c:if>
					<c:if test="${hasEditLink}">
						<td><a href="${editLinkValue}">edit</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>