<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>
<%-- Directives de page import --%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.torque.criteria.Criteria"%>
<%@ page import="fr.iut2.sil4.data.Student"%>
<jsp:useBean id="listStudents" type="java.util.List<fr.iut2.sil4.data.Student>" scope="request"/>
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
				<form role="form" method="get" action="add_note">
				  <div class="form-group">
				    <label for="controleId">Contrôle</label>
				    <input type="text" class="form-control" id="controleId" name="controleId" placeholder="id du contrôle" required>
				  </div>
				  <div class="form-group">
				    <label for="points">Points</label>
				    <input type="text" class="form-control" id="points" name="points" placeholder="Points" required>
				  </div>
				  <div class="form-group">
				    <label for="studentId">Etudiant</label>
				    <select name="studentId" class="form-control" required>
						<% for (Student student : listStudents) { %>
						<option value="<%=student.getGroupId()%>"><%=student.getFirstname()%> <%=student.getName()%></option>
						<% } %>
					</select>
				  </div>
				  <button type="submit" class="btn btn-default">Ajouter</button>
				</form>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>
