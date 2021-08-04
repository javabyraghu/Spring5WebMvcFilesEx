<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <head>
  <title>Document</title>
 </head>
<body>
<h1> DOCUMENTS PAGE </h1>
<form action="upload" method="POST" enctype="multipart/form-data">
<pre>
ID   : <input type="text" name="fileId"/>
DOC  : <input type="file" name="fileOb"/>
	<input type="submit" value="Upload"/>
</pre>
</form>
<hr/>
<table border="1">
 <tr>	
 	<th>FILE NAME</th>
 	<th> LINK </th>
 </tr>
 <c:forEach items="${list}" var="ob">
 	<tr>
 		<td>${ob[1]}</td>
 		<td> <a href="dowload?fileId=${ob[0]}">Download</a></td>
 	</tr>
 </c:forEach>
</table>
</body>
</html>
