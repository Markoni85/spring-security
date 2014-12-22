<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
 
     <form id='logoutForm'
		  action="<c:url value='logout' />" method='POST'> 
     </form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
	
	<ul>
	  <li>  <a href="<%="edit_account"%>">Edit accounts </a>
	 </li>
	  <li><a href="/secured/edit_config">Edit Config</li>
	</ul>
 
</body>
</html>