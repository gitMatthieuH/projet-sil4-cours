<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>
<%-- Directives de page import --%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.torque.criteria.Criteria"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><%= getServletContext().getInitParameter("title")%></title>
		<jsp:include page="/napp1/include/libraries.jsp"/>
	</head>
	<body>
		<div class="row">
		  <div class="col-md-12">
			  <jsp:include page="/napp1/include/menu_accueil.jsp"/>
		  </div>
		  	<%-- Forumulaire de connexion --%>
			<div class="col-md-2 col-md-offset-5">
				<form role="form" method="get" action="connect">
				  <div class="form-group">
				    <label for="user">Nom d'utilisateur</label>
				    <input type="text" class="form-control" id="user" name="user"  placeholder="Nom d'utilisateur" required>
				  </div>
				  <div class="form-group">
				    <label for="passwd">Mot de passe</label>
				    <input type="password" class="form-control" id="passwd" name="passwd" placeholder="Mot de passe" required>
				  </div>
				  <button type="submit" class="btn btn-default">Se connecter</button>
				</form>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>
