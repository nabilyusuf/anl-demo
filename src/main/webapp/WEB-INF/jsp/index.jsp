<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <div class="row">
 
 
<div class="col-lg-4">

<c:forEach items="${personList}" var="person" >

<div class="list-group">
 <a href="<spring:url value="/index/${person.pId}.html"/>">
  <button type="button" class="list-group-item">
  <ul class="list-group">
  <li class="list-group-item"><span class="badge">${person.bCount}</span>${person.pName}</li>
  <li class="list-group-item">${person.pMobile}</li>
  <li class="list-group-item">${person.pEmail}</li>
</ul>
</button>
</a>
  </div>


 </c:forEach>

</div>





<div class="col-lg-8">
	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">Book Name</h3>
	  </div>
	  <div class="panel-body">
	   <table class="table table-striped"> 
<thead> 
<tr> <th>ISBN</th> <th>Name of the Book </th> <th>Author</th></tr> 
</thead> 
<tbody>
<c:forEach items="${bookList}" var="book" > 
<tr> <th scope="row">${book.bISBN}</th> <td>${book.bName}</td> <td>${book.bAuthor}</td> </tr> 
 </c:forEach>
</tbody> 
</table>
	  </div>
</div>
</div>


</div>
