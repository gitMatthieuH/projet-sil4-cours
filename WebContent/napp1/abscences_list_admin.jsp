<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><%= getServletContext().getInitParameter("title")%></title>
		<jsp:include page="/napp1/include/libraries.jsp"/>
		<%@ page import="fr.iut2.sil4.data.Abscence"%>
		<%@ page import="fr.iut2.sil4.data.AbscencePeer"%>
		<%@ page import="java.util.Date" %>
		<jsp:useBean id="listAbscences" type="java.util.List<fr.iut2.sil4.data.Abscence>" scope="request"/>
	</head>
	<body>
		<div class="row">
		  <div class="col-md-12">
			  <jsp:include page="/napp1/include/menu_admin.jsp"/>
		  </div>
			<div class="col-md-6 col-md-offset-3">
		  <%-- Liste des utilisateurs --%>
			<table class="table">
				<caption>Absences</caption>
			   <thead>
			      <tr>
			      	 <th>Etudiant</th>
			         <th>Date</th>
			         <th>Motif</th>
			      </tr>
			   </thead>
			   <tbody>
			   
			   	<% for (Abscence absc : listAbscences) { %>
			   		<tr>
			   			<td><%=absc.getStudent().getFirstname()%> <%=absc.getStudent().getName()%></td>
			   			<td><%=absc.getDate()%></td>
			   			<td><%=absc.getMotif()%></td>		
			      	</tr>
					
				<% } %>
			      
			   </tbody>
			</table>
			<a href="abscence_add_admin">Ajouter une absence</a>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>