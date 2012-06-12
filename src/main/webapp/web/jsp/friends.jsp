<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="pu" uri="mohansrihariUtil"%>

<html:xhtml />
<script type="text/javascript">
	
$(document).ready(function() {});

    function inviteFriends() {
	
	var appId      = '<pu:contextProperty name="facebookAppId" />';
	 FB.init({
	        appId  : appId,
	        frictionlessRequests: true,
	      });
	FB.ui( {app_id:appId
		   , method : 'apprequests'
		   , title  : 'invitationTitle'
		   , message: 'invitationMessage'
	       },requestCallback);
     }
	    
function requestCallback(response) {
    // Handle callback here
  }
</script>
<div class="fullColumn">
	<div class="fullColumn-inner">
		<h2>
			Share Information with friend's from your Facebook account!
		</h2>
	</div>
</div>

	<div>
		<div>
			<h3>
				Invite A Friend
			</h3>
			<p style="line-height:16px;padding-bottom:10px;">
				Click <a href="#" onclick="inviteFriends();">here</a> to invite friends to use this app.
			</p>
			<h3>
				First 10 Friends from your Facebook Account:
			</h3>
			<p>
				<c:choose>
					<c:when test="${ facebookHasFriends }">
						<c:forEach items="${ facebookFriends }" var="friend">
							<label>
								<c:out value="${ friend.name }" />
							</label>
							<br />
						</c:forEach>
					</c:when>
					<c:otherwise>
						No friends have installed the your application!
						<p />
					</c:otherwise>
				</c:choose>
			</p>
			
		</div>
	</div>
