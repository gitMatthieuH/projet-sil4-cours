<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<footer>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=getServletContext().getContextPath() %>/lib/jquery-1.10.2.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=getServletContext().getContextPath() %>/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=getServletContext().getContextPath() %>/lib/datepicker/js/bootstrap-datepicker.js"></script>
	<script>
		$('.datepicker').datepicker({
			format: 'dd/mm/yyyy'
		});
	</script>
</footer>