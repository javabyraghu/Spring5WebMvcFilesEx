<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Document</title>
  </head>
  <body>
      <div class="container">
        <div class="card">
           
            <div class="card-header bg-primary text-white text-center">
                <h1>DOCUMENTS PAGE</h1>
            </div>
            <!-- card header end -->

            <form action="upload" method="POST" enctype="multipart/form-data">
                DOCUMENT ID : <input type="text" name="fileId" class="form-control" /> 
                DOCUMENT    : <input type="file" name="fileOb" class="form-control"/>
                <br/>
                <input type="submit" value="Upload" class="btn btn-success" />
              </form>
        </div>
        <!-- card end -->

        <div class="card-body">
            <table class="table table-hover">
                <tr class="bg-info text-white">
                  <th>FILE NAME</th>
                  <th>LINK</th>
                </tr>
                <c:forEach items="${list}" var="ob">
                  <tr>
                    <td>${ob[1]}</td>
                    <td><a class="btn btn-warning" href="dowload?fileId=${ob[0]}">Download</a></td>
                  </tr>
                </c:forEach>
              </table>
        </div>
        <!-- card footer end -->
      </div>
      <!-- card end -->

  </body>
</html>
