<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="resources/scripts/public/touchscroll.js" var="JSTouchScroll"/>
<script src="${JSTouchScroll}"></script>
<spring:url value="resources/scripts/public/jquery-2.1.1.min.js" var="JSjQuery"/>
<script src="${JSjQuery}"></script>
<spring:url value="resources/scripts/public/foundation/foundation.min.js" var="JSFoundation"/>
<script src="${JSFoundation}"></script>
<spring:url value="resources/scripts/public/jquery-ui.min.js" var="JSjQueryUI"/>
<script src="${JSjQueryUI}"></script>
<spring:url value="resources/scripts/public/jquery.ui.touch-punch.min.js" var="JSjQueryUITouchPunch"/>
<script src="${JSjQueryUITouchPunch}"></script>
<spring:url value="resources/scripts/public/soundmanager2/soundmanager2-nodebug-jsmin.js" var="JSsoundManager2" />
<script src="${JSsoundManager2}"></script>