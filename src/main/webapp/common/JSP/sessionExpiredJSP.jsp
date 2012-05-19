<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
	<SCRIPT type="text/javascript">
		function redirectLoginPage() {
			window.parent.parent.location.replace("/Struts_FacebookUI");
		}
		function relocate() {
			window.parent.parent.location.replace('/Struts_FacebookUI/common/JSP/sessionExpiredJSP.jsp');
		}
	</SCRIPT>
	<%if(request.getAttribute("errorMessage") != null) { %>
	<BODY onload="relocate();">
	<%} else {%>
	<BODY>
	<%}%>
	<div align="center" class="clsPageHeader">
		Your working session has been expired.		
	</div>
		<P align="center"><INPUT type="button" class="clsButton" value="OK" onclick="redirectLoginPage();"></P>
	</BODY>
</HTML>
