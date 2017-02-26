<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:import url="/WEB-INF/views/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="New User" />
    <c:param name="body">
        <div class="container" role="main">
            <h1>New User</h1>
            <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/create" class="form">
                <div class="form-group">
                  <label for="name">Name:</label>
                    <form:input path="name" class="form-control" />
                    <form:errors path="name" cssStyle="color: red;" />
                </div>
                <div class="form-group">
                  <label for="age">Age:</label>
                    <form:input path="age" class="form-control" />
                    <form:errors path="age" cssStyle="color: red;" />
                </div>
                <div class="form-group">
                    <label>isAdmin:</label>
                    <form:checkbox path="admin" value="false"/>
                    <form:errors path="admin" cssStyle="color: red;" />
                </div>
                <button type="submit" class="btn btn-default">Create</button>
            </form:form>
        </div>
    </c:param>
</c:import>