<%@page session="false"%>

<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>


	<p>
		<authz:authorize access="!isAuthenticated()">
	 You can login to app  <a href="<%="login.do"%>"> here ! </a>
		</authz:authorize>
	</p>
	
		<p>
		<authz:authorize access="isAuthenticated()">
	      Go to admin page <a href="<%="admin.do"%>"> admin >> </a>
		</authz:authorize>
	</p>
</body>
</html>