


<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><%= getServletContext().getInitParameter("title")%></title>
		<jsp:include page="/napp1/include/libraries.jsp"/>
	</head>
	<body>
		<div class="row">
		  <div class="col-md-12">
			  <jsp:include page="/napp1/include/menu.jsp"/>
		  </div>
		  <%-- Liste des utilisateurs --%>
			<table class="table">
				<caption>Elèves</caption>
			   <thead>
			      <tr>
			         <th>Nom</th>
			         <th>Prenom</th>
			         <th>Groupe</th>
			      </tr>
			   </thead>
			   <tbody>
			      <tr>
			         <td>Anthony</td>
			         <td>Grassano</td>
			         <td>yobitch</td>
			      </tr>
			   </tbody>
			</table>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>