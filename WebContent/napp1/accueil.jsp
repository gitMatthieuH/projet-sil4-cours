<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>
<%-- Directives de page import --%>
<%@ page import="java.util.*"%>
<%@ page import="fr.iut2.sil4.data.Student"%>
<%@ page import="fr.iut2.sil4.data.StudentPeer"%>
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
			  <jsp:include page="/napp1/include/menu.jsp"/>
		  </div>
		  	<%-- Forumulaire de connexion --%>
			<div class="col-md-2 col-md-offset-5">
				<form role="form" method="get" action="note.jsp">
				  <div class="form-group">
				    <label for="user">Email address</label>
				    <input type="text" class="form-control" id="user" name="user"  placeholder="Nom d'utilisateur">
				  </div>
				  <div class="form-group">
				    <label for="passwd">Password</label>
				    <input type="password" class="form-control" id="passwd" name="user" name="passwd" placeholder="Mot de passe">
				  </div>
				  <div class="checkbox">
				    <label>
				      <input type="checkbox"> Se rappeler de moi
				    </label>
				  </div>
				  <button type="submit" class="btn btn-default">Submit</button>
				</form>
				<%
				
				Student student1 = new Student();
				student1.isNew();
				//for (Student student : StudentPeer.doSelectAll()) {
				
				//}
				%>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>
