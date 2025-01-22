<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Skills</h1>
<div class="row">
  <c:forEach var="skill" items="${skills}">
    <div class="col-md-4 mb-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">${skill.name}</h5>
          <p class="card-text">Description: ${skill.description}</p>
          <p class="card-text">Level: ${skill.level}</p>
        </div>
      </div>
    </div>
  </c:forEach>
</div>
