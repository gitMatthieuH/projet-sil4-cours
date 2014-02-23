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
			  <jsp:include page="/napp1/include/menu_admin.jsp"/>
		  </div>
			<div class="col-md-2 col-md-offset-5">
				<form role="form" method="get" action="add_abscence">
				  <div class="form-group">
				    <label for="date">Date</label>
				    <input type="date" class="form-control datepicker" id="date" name="date" placeholder="Date d\'abscence" required>
				  </div>
				  <div class="form-group">
				    <label for="studentId">Etudiant</label>
				    <input type="text" class="form-control" id="studentId" name="studentId" placeholder="Id de l\'étudiant" required>
				  </div>
				  <button type="submit" class="btn btn-default">Ajouter</button>
				</form>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>
