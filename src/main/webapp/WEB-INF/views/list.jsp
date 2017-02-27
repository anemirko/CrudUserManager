<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="User List" />
    <c:param name="body">
    	<div class="container" role="main">
	    	<h1>User List</h1>
			<p><em>${message}</em></p>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>isAdmin</th>
						<th>Created date</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${page.content}">
						<tr>
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td>${user.age}</td>
                            <td><input type="checkbox" disabled="disabled" name="admin" <c:if test="${user.admin}">checked</c:if>/></td>
							<td>${user.createdDate}</td>
							<td>
								<a href="${pageContext.request.contextPath}/edit/${user.id}">Edit</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/delete/${user.id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
            <div>Viewing page ${page.number + 1} of ${page.totalPages}</div>
            <div>
                <c:forEach var="i" begin="1" end="${page.totalPages}">
                    <c:choose>
                        <c:when test="${i == page.number + 1}">${i}</c:when>
                        <c:otherwise><a href="?page=${i - 1}">${i}</a></c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
		</div> <!-- /container -->
	</c:param>
</c:import>