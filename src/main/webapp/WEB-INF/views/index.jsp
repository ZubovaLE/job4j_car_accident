<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <title>Accidents</title>
</head>
<body>
<div class="container">
    <div class="card-header" style="text-align: right">
        <a href="<c:url value='/create'/>">Добавить инцидент</a>
    </div>
    <div class="card-body>">
        <table class="table table-bordered">
            <div class="table-header" style="text-align: center">
                <h3>Information</h3>
            </div>
            <thead>
            <th scope="col">Name</th>
            <th scope="col">Text</th>
            <th scope="col">Address</th>
            <th scope="col">Type</th>
            </thead>
            <tbody>
            <c:forEach items="${accidents}" var="accident">
                <tr>
                    <td><a href="<c:url value='/update?id=${accident.key}'/>">${accident.value.name}</a></td>
                    <td><c:out value="${accident.value.text}"/></td>
                    <td><c:out value="${accident.value.address}"/></td>
                    <td><c:out value="${accident.value.type.name}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>