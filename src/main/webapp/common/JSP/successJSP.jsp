
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:html>
<script>
	function disableBackButton(){
		window.history.go(+1);
	}
</script>
<BODY onload="disableBackButton();">

<DIV  >
<%if(request.getAttribute("message") != null) { %>
<center><B><%=request.getAttribute("message") %></B></center>
<% } else { %>
<center><B>Record has been created successfully.</B></center>
<% } %>
</DIV><BR>
	
</BODY>
</html:html>
