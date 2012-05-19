<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
  <head><title>Personal Information</title></head>
 <body>
     <html:form action="enter">
        Welcome  <bean:write name="personalInformation" property="name"/>
     </html:form>
 </body>
</html>


