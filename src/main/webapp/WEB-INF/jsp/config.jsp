<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <div class="row">
 
 





<div class="col-lg-8">
	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">Configure Database</h3>
	  </div>
	  <div class="panel-body">
	 <form:form commandName="databaseInfo" class="form-horizontal">
	 
	 
	 <div class="form-group">
    <label  class="col-sm-2 control-label">JDBC URL:</label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" path="dbpath" placeholder="jdbc:h2:C:/test"/>
    </div>
  </div>
  
  
  <div class="form-group">
    <label class="col-sm-2 control-label">User:</label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" path="dbuser" placeholder="sa"/>
    </div>
  </div>
  
  
  
  <div class="form-group">
    <label  class="col-sm-2 control-label">Password:</label>
    <div class="col-sm-10">
      <form:password class="form-control" path="dbPassword" placeholder="sa"/>
    </div>
  </div>
  <!-- <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Add sample data
        </label>
      </div>
    </div>
  </div> -->
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" class="btn btn-default" value="Submit"/>
    </div>
  </div>
</form:form>
	  </div>
</div>
</div>

<div class="col-lg-4">

<div class="panel panel-primary">
 <div class="panel-heading"> 
<h3 class="panel-title">Configuration</h3> 
</div> 
<div class="panel-body"> 
<strong>-</strong>&nbsp;This is a sample application which runs using H2 data base
<br>
<font color="red">Please Run H2 database before starting the application</font>
<br><br>
<strong>-</strong>&nbsp;Enter the path of the data base file in the format 
<i>jdbc:h2:D:/DataBase/DBFlie</i>
Where <b>DBFlie</b> being the database file name
And  <b>D:/DataBase</b> being the path 
<br><br>
<strong>-</strong>&nbsp;Enter the user name and password for the database 
<br>

<sub>You can contact me at 0404401454 if you need any specific enhancements.</sub>
 </div> </div>

</div>

</div>
