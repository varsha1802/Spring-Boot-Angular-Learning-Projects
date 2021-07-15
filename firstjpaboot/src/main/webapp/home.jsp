<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD</title>
<style>
         fieldset {
            width: 50%;
            margin-right: 10%;
        }
           
        
		.first{
		margin-left: 30%;
		}
		
		.first label{
		width : 250px;
		display : inline-block;
		}
		
		.but{
		margin-left: 45%;
		}   
</style>
</head>
<body>

	<div class="first">
	<form action="addAlien">
		
		<fieldset name="CREATE">
		<legend>CREATE</legend>
		<label>Id  </label>	
		<input type="text" name="aid"></input><br><br>
		<label>Name </label>
		<input type="text" name="aname"></input><br><br>
		<label>Tech </label>
		<input type="text" name="tech"></input><br><br>
		<label>City </label>
		<input type="text" name="zname"></input><br><br>
		<div class="but"><input type="submit"></div>
		</fieldset><br><br>
			
	</form>
	
	<fieldset name="READ">
	<legend>READ</legend>
	<form action="getAlien">
		
		<label>Id  </label>	
		<input type="text" name="aid"></input><br><br>
		<div class="but"><input type="submit"></div>
	
	</form>
	</fieldset><br><br>
	
	<fieldset name="UPDATE">
	<legend>UPDATE</legend>
	<form action="updateAlien">
		
		<label>Id  </label>	
		<input type="text" name="aid"></input><br><br>
		<label>Name </label>
		<input type="text" name="aname"></input><br><br>
		<label>Tech </label>
		<input type="text" name="tech"></input><br><br>
		<label>City </label>
		<input type="text" name="zname"></input><br><br>
		<div class="but"><input type="submit"></div>
	
	</form>
	</fieldset><br><br>
	
	<fieldset name="DELETE">
	<legend>DELETE</legend>
	<form action="delAlien">
		
		<label>Id  </label>	
		<input type="text" name="aid"></input><br><br>
		<div class="but"><input type="submit"></div>
	
	</form>
	</fieldset><br><br>
	
	<fieldset name="FIND-BY-TECH">
	<legend>FIND-BY-TECH</legend>
	<form action="findByTechAlien">
		
		<label>Tech  </label>	
		<input type="text" name="tech"></input><br><br>
		<div class="but"><input type="submit"></div>
	
	</form>
	</fieldset><br><br>
	
	<fieldset name="FIND-GREATER-THAN-ID">
	<legend>FIND-GREATER-THAN-ID</legend>
	<form action="findByGreater">
		
		<label>Id  </label>	
		<input type="text" name="aid"></input><br><br>
		<div class="but"><input type="submit"></div>
	
	</form>
	</fieldset><br><br>
		
	<fieldset name="FIND-BY-TECH-SOSRTED">
	<legend>NAME-BASED-SORTING</legend>
	<form action="findByTechSorted">
		
		<label>Tech  </label>	
		<input type="text" name="tech"></input><br><br>
		<label>City </label>
		<input type="text" name="zname"></input><br><br>
		<div class="but"><input type="submit"></div>
	
	</form>
	</fieldset><br><br>
	</div>
	
</body>
</html>