<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="CRUD User Manager" />
    <c:param name="body">
    	<div class="container" role="main">
			<h1>
				Welcome
			</h1>
			<p>The time on the server is ${serverTime}</p>
		</div>
	</c:param>
</c:import>
