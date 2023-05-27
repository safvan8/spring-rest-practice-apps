<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Error Page</title>
</head>
<body>
	<h1>Customized Error Page</h1>
	<p>${errorMessage}:: is the reason for the Exception</p>
</body>
</html>

<!-- In the above code, ${errorMessage} retrieves 
the value of the errorMessage attribute from the model and displays it in the <p> element. -->