<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<link href="resources/css/signin.css" rel="stylesheet">

<c:set var="context" value="${pageContext.request.contextPath}"/>

<div class="container">
      <form class="form-signin" action="${context}/login" method="POST">
        <h2 class="form-signin-heading"><s:message code="login.header.label"/></h2>
        <label for="inputEmail" class="sr-only"><s:message code="login.username.label" var="username"/></label>
        <input type="email" id="inputEmail" class="form-control" placeholder="${username}" required autofocus>
        <label for="inputPassword" class="sr-only"><s:message code="login.password.label" var="password"/></label>
        <input type="password" id="inputPassword" class="form-control" placeholder="${password}" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> <s:message code="login.rememberme.label"/>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><s:message code="login.signin.label"/></button>
      </form>
</div>
