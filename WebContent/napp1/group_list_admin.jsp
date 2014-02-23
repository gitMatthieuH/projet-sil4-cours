


<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><%= getServletContext().getInitParameter("title")%></title>
		<jsp:include page="/napp1/include/libraries.jsp"/>
		<%@ page import="fr.iut2.sil4.data.Usergroup"%>
		<%@ page import="fr.iut2.sil4.data.UsergroupPeer"%>
		<jsp:useBean id="listGroups" type="java.util.List<fr.iut2.sil4.data.Usergroup>" scope="request"/>
	</head>
	<body>
		<div class="row">
		  <div class="col-md-12">
			  <jsp:include page="/napp1/include/menu_admin.jsp"/>
		  </div>
			<div class="col-md-6 col-md-offset-3">
		  <%-- Liste des utilisateurs --%>
			<table class="table">
				<caption>Groupes</caption>
			   <thead>
			      <tr>
			         <th>Id</th>
			         <th>Nom du groupe</th>
			      </tr>
			   </thead>
			   <tbody>
			   
			   	<% for (Usergroup group : listGroups) { %>
			   		<tr>
			   			<td><%=group.getGroupId()%></td>
		         		<td><%=group.getGroupName()%></td>
			      	</tr>
					
				<% } %>
			      
			   </tbody>
			</table>
			<a href="group_add_admin">Ajouter un groupe</a>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>