
<div id="followUsers">


<%--
<input type="checkbox" value="sanket.deshpande" onchange="addFriendToInvite(this)" /> Sanket
<input type="checkbox" value="nitin.karmuse"  onchange="addFriendToInvite(this)"  /> Nitin
--%>

<g:each in="${emoteUsersList}" var="emoteUser">

<div class="user-section">
	<span class="user-image">
	<facebook:picture facebookId="${emoteUser.facebookId}" linkEnabled="true" /> 
	</span>
	
	<span class="user-name">
	${emoteUser.firstName} ${emoteUser.lastName}
	</span>
	
	<span class="followButton" id="${emoteUser.id}">
		<a href="javascript:followUser('${emoteUser.id}');" > follow </a>
	</span>
</div>
</g:each>

<g:each in="${userFriends}" var="friend">
<div class="user-section">
	<span class="user-image">
	<facebook:picture facebookId="${friend.id}" linkEnabled="true" />
	</span>
	
	<span class="user-name">
	${friend.name}
	</span>
	
	<span class="followButton">
		<a href="${createLink(controller:'emote', action:'feed')}" onchange="addFriendToInvite(this)" value="${friend.id}"> invite </a>
	</span>
	

</div>	
</g:each>
