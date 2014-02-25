<%-- Directive de page : permet de définir les attributs de la page --%>
<%@page import="fr.iut2.sil4.data.UsergroupPeer"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>
<jsp:include page="/napp1/include/libraries.jsp"/>
<%@ page import="fr.iut2.sil4.data.Student"%>
<%@ page import="fr.iut2.sil4.data.StudentPeer"%>
<%@ page import="fr.iut2.sil4.data.Abscence"%>
<%@ page import="fr.iut2.sil4.data.Usergroup"%>
<jsp:useBean id="listStudents" type="java.util.List<fr.iut2.sil4.data.Student>" scope="request"/>
<jsp:useBean id="listAbscences" type="java.util.List<fr.iut2.sil4.data.Abscence>" scope="request"/>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><%= getServletContext().getInitParameter("title")%></title>
	</head>
	<body>
		<div class="row">
		  <div class="col-md-12">
			  <jsp:include page="/napp1/include/menu_admin.jsp"/>
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
			         <th>Moyenne</th>
			         <th>Absences</th>
			      </tr>
			   </thead>
			   <tbody>
			   
			   	<%int i=0; for (Student student : listStudents) { i++;%>
			   		<tr>
			         	<td><%=student.getFirstname()%></td>
		         		<td><%=student.getName()%></td>
			         	<td><%=UsergroupPeer.retrieveByPK(student.getGroupId()).getGroupName()%></td>
			         	<th><%=student.getMoyenne()%></th>
			         	<th><%=student.getAbscences().size()%></th>
			         	<th><a href="student_edit_admin?studentId=<%=student.getGroupId()%>"><i class="fa fa-pencil-square-o"></i></a></td>
			         	<th><a href="student_remove_admin?studentId=<%=student.getStudentId()%>"><i class="fa fa-times"></i></a></td>
			      	</tr>
					
				<% } %>
			      
			   </tbody>
			</table>
			<a href="student_add_admin"><i class="fa fa-plus"></i>  Ajouter un étudiant</a>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>