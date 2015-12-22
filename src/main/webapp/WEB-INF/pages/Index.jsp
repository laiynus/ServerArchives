<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Archives of current day</title>
</head>
<body>
<h2>Archives of current day</h2>
<c:if test="${not empty archivesList}">
  <ul>
    <c:forEach var="listValue" items="${archivesList}">
      <li>${listValue.name}</li>
    </c:forEach>
  </ul>
</c:if>
</body>
</html>