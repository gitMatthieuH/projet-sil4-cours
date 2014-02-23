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
		<jsp:useBean id="listNotes" type="java.util.List<fr.iut2.sil4.data.Note>" scope="request"/>
	</head>
	<body>
		<div class="row">
		  <div class="col-md-12">
			  <jsp:include page="/napp1/include/menu_admin.jsp"/>
		  </div>
			<div class="col-md-6 col-md-offset-3">
		  <%-- Liste des utilisateurs --%>
			<table class="table">
				<caption>Notes</caption>
			   <thead>
			      <tr>
			         <th>Contrôle</th>
			         <th>Point</th>
			         <th>Etudiant</th>
			      </tr>
			   </thead>
			   <tbody>
			   	<% for (Note note : listNotes) { %>
			   		<tr>
			         	<td><%=note.getControleId()%></td>
		         		<td><%=note.getPoints()%></td>
			         	<th><%=note.getStudentId()%></th>
			      	</tr>
					
				<% } %>
			      
			   </tbody>
			</table>
			<a href="note_add_admin">Ajouter une note</a>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>