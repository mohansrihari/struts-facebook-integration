<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
  <head><title>Personal Information</title></head>
 <body>
     <html:form action="enter">
     <Table background="${picture}">
        <caption>Personal Information</caption>
       <tbody>
          <TR>
            <TD colspan="2"><b>First Name:</b><bean:write name="personalInformation" property="first_name"/></TD>
          </TR>
           <TR>
           <TD colspan="2"><b>Last Name :</b><bean:write name="personalInformation" property="last_name"/></TD>
           </TR>
          <TR>
           <TD colspan="2"><b>Gender :</b><bean:write name="personalInformation" property="gender"/></TD>
           </TR>
           
            <TR>
           <TD colspan="2"><b>Home Town:</b><bean:write name="personalInformation" property="hometown"/></TD>
           </TR>
            <TR>
           <TD colspan="2"><b>Current Location :</b><bean:write name="personalInformation" property="location"/></TD>
           </TR>
       
            <TR>
           <TD colspan="2"><b>Work Exp: </b></TD></TR>
		   <TR>
		   <TD></TD>
		   <TD>	<c:choose>
					<c:when test="${ isWorking }">
						<c:forEach items="${ work }" var="exp">
							<p><c:out value="${ exp.employer.name }" />  from  <c:out value="${ exp.start_date}" /> to 	<c:choose>
					              <c:when test="${empty exp.end_date }"> Till Date </c:when>
								  <c:otherwise><c:out value="${ exp.end_date }"/></c:otherwise>
								</c:choose>
							</p>
						</c:forEach>
						
					</c:when>
					<c:otherwise>
						No friends have installed the your application!
						
					</c:otherwise>
				</c:choose></TD>
           </TR>
       </tbody>
       <tfoot></tfoot>
     </Table>
        
     </html:form>
 </body>
</html>


