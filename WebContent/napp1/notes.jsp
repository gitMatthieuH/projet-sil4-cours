<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><%= getServletContext().getInitParameter("title")%></title>
		<jsp:include page="/napp1/include/libraries.jsp"/>
		<%@ page import="fr.iut2.sil4.data.Note"%>
		<%@ page import="fr.iut2.sil4.data.NotePeer"%>
		<%@ page import="java.util.Date" %>
		<jsp:useBean id="myNotes" type="java.util.List<fr.iut2.sil4.data.Note>" scope="request"/>
	</head>
	<body>
		<div class="row">
		  <div class="col-md-12">
			  <jsp:include page="/napp1/include/menu.jsp"/>
		  </div>
			<div class="col-md-6 col-md-offset-3">
		  <%-- Liste des utilisateurs --%>
			<table class="table">
				<caption>Abscences</caption>
			   <thead>
			      <tr>
			         <th>Contrôle</th>
			         <th>Points</th>
			         <th>Etudiant</th>
			      </tr>
			   </thead>
			   <tbody>
			   
			   	<% for (Note note : myNotes) { %>
			   		<tr>
			   			<td><%=note.getControleId()%></td>
			   			<td><%=note.getPoints()%></td>
			   			<td><%=note.getStudentId()%></td>
			      	</tr>
					
				<% } %>
			      
			   </tbody>
			</table>
			<a href="abscence_add_admin">Ajouter une abscence</a>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>