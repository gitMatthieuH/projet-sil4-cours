<%-- Directive de page : permet de définir les attributs de la page --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>
<%-- Directives de page import --%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.torque.criteria.Criteria"%>
<%@ page import="fr.iut2.sil4.data.Student"%>
<jsp:useBean id="student" type="fr.iut2.sil4.data.Student" scope="request"/>
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
		  <div style="text-align:center;"><h3 style="font-family:'Lobster';font-size:2.5rem;">Bienvenue sur l'espace de consultation</h3></div>
			<div class="col-md-2 col-md-offset-5">
				
				<div class="panel-body">
					<div class="row">
						<div class="col-md-4">
							<a href="#" class="thumbnail"><img src="<%=getServletContext().getContextPath() %>/img/default-user.png" width="350px" height="350px"></a>
						</div>
						<div class="col-md-8">
							<div class="caption">
								<p><b>Moyenne (<a href="notes">détails</a>) : </b><%=student.getMoyenne()%></p>
								<p><b>Absences (<a href="abscences">détails</a>) : </b><%=student.getAbscences().size()%></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<jsp:include page="/napp1/include/footer.jsp"/>
	</body>
</html>
