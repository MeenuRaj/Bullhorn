<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<div class="container">
		<div class="dropdown">
			<button class="btn pull-left btn-info dropdown-toggle" type="button"
				data-toggle="dropdown">
				Login<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="#"></a>
					<div class="container">
						<form  action="post.jsp" >
							
							<div class="form-group">
								<label class="control-label col-sm-5">Username: </label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="username" name="username">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5">Password: </label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="password"
										name="password" placeholder="Enter password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-5">
									<center>
										<button type="submit" class="btn btn-primary btn-lg btn-block"
											value="addstudent">Login</button>
									</center>
								</div>
							</div>
						</form>
					</div></li>
			</ul>
		</div>

	</div>

	<br>
	<br>
	<br>

	<div class="container">
	<form role="form" action="insert" method="post"> 
	<input type="hidden" name="action" value="view"/>
		<div class="form-group">
		<div class="col-sm-offset-2 col-sm-5">
			<center>
				<button type="submit" class="btn btn-primary btn-lg btn-block"
					>View Posts</button>
			</center>
		</div>
	</div>
	</form>
	</div>

	<!-- <div class="container">

  <form role="form" action="insert" method = "post">
 
    <div class="form-group">
      <label for="pwd">Post:</label>
      <input type="text" class="form-control" id="post" name = "post" >
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div> -->

</body>
</html>