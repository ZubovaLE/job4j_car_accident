<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creation</title>
</head>
<body>
<div class="container">
    <div class="card-header">
        <h3>Создать инцидент</h3>
    </div>
    <div class="card-body">
        <form action="<c:url value='/save'/>" method='POST'>
            <table>
                <tr>
                    <td>Название:</td>
                    <td><input type='text' name='name'></td>
                </tr>
                <tr>
                    <td>Описание:</td>
                    <td><input type='text' name='text'></td>
                </tr>
                <tr>
                    <td>Адрес:</td>
                    <td><input type='text' name='address'></td>
                </tr>
                <tr>
                    <td>Тип:</td>
                    <td>
                        <select name="type.id">
                            <c:forEach var="type" items="${types}" >
                                <option value="${type.id}">${type.name}</option>
                            </c:forEach>
                        </select>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit" value="Сохранить"/></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>