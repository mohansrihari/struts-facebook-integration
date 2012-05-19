<%@page import="com.prokarma.common.Context"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="pu" uri="ProkarmaUtil"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html:xhtml />

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml">
    <head>
        <title></title>
        <link type="text/css" rel="stylesheet" href="styles.css" />
         <script type="text/javascript" src="common/js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="http://connect.facebook.net/en_US/all.js"></script>
	</head>

    <body>
    
    	<div id="fb-root"></div>
		<script>
	          var appId      = '<pu:contextProperty name="facebookAppId" />';
	         
	          FB.init({
	            appId      : appId,
	            status     : true, // check login status
	            cookie     : true, // enable cookies to allow the server to access the session
	            xfbml      : true, // parse XFBML
	            oauth      : true // enable OAuth 2.0
	          });
		</script>
		
         <c:if test="${ ! empty modalMsg }">
            <div id="overlay"></div>
            <div id="modal" style="display: none;">
                <div id="modal-inner">
                    <p>
                        <c:out value="${modalMsg}" />
                    </p>
                    <p style="text-align: center;">
                        <input type="button" class="blue" id="removeModal" value="OK" />
                    </p>
                </div>
            </div>
            <script type="text/javascript">
                $(document).ready(function(){
                	$("#modal").show("slow");
                });
            </script>
        </c:if>

       <div id="container">
            <div id="header" style="padding-bottom:10px;">
                <img src="images/prokarma_logo.png"/>
            </div>
            <div id="topNav">
                <ul>
                    <li>
                        <html:link action="enter">Home</html:link>
                    </li>
                    <li>
                        <html:link action="activities?command=findMyDetails">Personal Profile</html:link>
                    </li>
                      <li>
                        <html:link action="activities?command=myFriends">Friends</html:link>
                    </li>
                 </ul>
            </div>  
             <div style="clear:both;"></div>          
            <div id="mainBody">
                <div id="mainBody-inner">
                
                <tiles:insert attribute="body"/>

                </div>
            </div>
            <br class="clear" />
            <br/>
            
            <div align="center" style="font-size: 9px;">
                 <a href="#" style="color: #000000;">Prokarma Softech</a>                 
            </div>
            
        </div>
        
        <div style="clear:both;"></div>
        <div style="clear:both;"></div>
         <c:if test="${! empty FeedDialogType}">
            <pu:feedDialog dialogType="${FeedDialogType}" />
        </c:if>
      	</body>
</html>