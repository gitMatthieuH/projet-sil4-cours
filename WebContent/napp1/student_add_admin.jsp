<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>
<%-- Directives de page import --%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.torque.criteria.Criteria"%>
<%@ page import="fr.iut2.sil4.data.Usergroup"%>
<jsp:include page="/napp1/include/libraries.jsp"/>
<jsp:useBean id="listGroups" type="java.util.List<fr.iut2.sil4.data.Usergroup>" scope="request"/>
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
			<div class="col-md-2 col-md-offset-5">
				<form role="form" method="get" action="add_student">
				  <div class="form-group">Prénom</label>
				    <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Nom" required>
				  </div>
				  <div class="form-group">
				    <label for="name">Nom</label>
				    <input type="text" class="form-control" id="name" name="name" placeholder="Prénom" required>
				  </div>
				  <div class="form-group">
				    <label for="username">Pseudonyme</label>
				    <input type="text" class="form-control" id="username" name="username" placeholder="Pseudo" required>
				  </div>
				  <div class="form-group">
				    <label for="groupid">Groupe</label>
				    <select name="groupid" class="form-control" required>
						<% for (Usergroup group : listGroups) { %>
						<option value="<%=group.getGroupId()%>"><%=group.getGroupName()%></option>
						<% } %>
					</select>
				  </div>
				  <div class="form-group">
				    <label for="passwd">Mot de passe</label>
				    <input type="password" class="form-control" id="passwd" name="passwd" placeholder="Mot de passe" required>
				  </div>
				  <button type="submit" class="btn btn-default">Ajouter</button>
				</form>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>
