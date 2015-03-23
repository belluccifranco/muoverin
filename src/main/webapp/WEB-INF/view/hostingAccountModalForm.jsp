<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="newHostingAccountModal" class="reveal-modal tiny" data-reveal>
    <h2>Add new Hosting</h2>  
    <div>
        <form id="hostingAccountForm" data-abide>
            <div class="small-12">
                <div>
                    <label for="hosting-url">Site URL:</label>
                    <input id="hostingAccount-url" type="url" required>
                    <small id="hostingAccount-url-error" class="error"><spring:message code="URL-hostingAccount-url"/></small>
                </div>
                
                <div>                
                    <label for="hosting-username">Username:</label>
                    <input id="hostingAccount-username" type="email" required>
                    <small id="hostingAccount-username-error" class="error"><spring:message code="NotEmpty-hostingAccount-username"/></small>
                </div>
                
                <div>                
                    <label for="hosting-password">Password:</label>
                    <input id="hostingAccount-password" type="password" required>
                    <small id="hostingAccount-password-error" class="error"><spring:message code="NotEmpty-hostingAccount-password"/></small>
                </div>

                <input id="saveHosting-button" class="button radius" type="submit" value="Save!"/>
            </div>
        </form>
    </div>
    <a class="close-reveal-modal">&#215;</a>
</div>