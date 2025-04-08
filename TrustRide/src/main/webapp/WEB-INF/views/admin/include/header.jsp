<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<c:url value='/resources/css/admin/header.css'/>">
<header class="header">
    <div class="logo">관리자 페이지</div>
    <div class="user-info">
        <c:if test="${not empty sessionScope.adminUser}">
            <span>${sessionScope.adminUser.adminName} 님</span>
            <a href="${pageContext.request.contextPath}/logout"><button class="logout-btn">로그아웃</button></a>
        </c:if>
    </div>
</header>
