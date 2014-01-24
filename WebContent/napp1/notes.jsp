


<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><%= getServletContext().getInitParameter("title")%></title>
		<jsp:include page="/napp1/include/libraries.jsp"/>
		<%@ page import="fr.iut2.sil4.data.Student"%>
		<%@ page import="fr.iut2.sil4.data.StudentPeer"%>
		<jsp:useBean id="listStudents" type="java.util.List<fr.iut2.sil4.data.Student>" scope="request"/>
	</head>
	<body>
		<div class="row">
		  <div class="col-md-12">
			  <jsp:include page="/napp1/include/menu.jsp"/>
		  </div>
			<div class="col-md-6 col-md-offset-3">
		  <%-- Liste des utilisateurs --%>
			<table class="table">
				<caption>Elèves</caption>
			   <thead>
			      <tr>
			         <th>Nom</th>
			         <th>Prenom</th>
			         <th>Groupe</th>
			         <th>Absences</th>
			      </tr>
			   </thead>
			   <tbody>
			   	<% for (Student student : listStudents) { %>
			   		<tr>
			         	<td><%=student.getFirstname()%></td>
		         		<td><%=student.getName()%></td>
			         	<td>yobitch</td>
			         	<th><%=student.getAbsences()%></th>
			      	</tr>
					
				<% } %>
			      
			   </tbody>
			</table>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>