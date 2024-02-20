<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container">
    <div class="card-header">
        <h3>Редактировать инцидент</h3>
    </div>
    <div class="card-body">
        <form action="<c:url value='/save?id=${accident.id}'/>" method='POST'>
            <table>
                <tr>
                    <td>Название:</td>
                    <td><input type='text' name='name' value="${accident.name}"></td>
                </tr>
                <tr>
                    <td>Описание:</td>
                    <td><input type='text' name='text' value="${accident.text}"></td>
                </tr>
                <tr>
                    <td>Адрес:</td>
                    <td><input type='text' name='address' value="${accident.address}"></td>
                </tr>
                <tr>
                    <td>Тип:</td>
                    <td>
                        <select name="type.id">
                            <c:forEach var="type" items="${types}">
                                <c:if test="${type.id == accident.type.id}">
                                    <option value="${type.id}" selected>${type.name}</option>
                                </c:if>
                                <c:if test="${type.id != accident.type.id}">
                                    <option value="${type.id}">${type.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                </tr>
                <tr>
                    <td>Статьи:</td>
                    <td>
                        <select name="rIds" multiple>
                            <c:forEach var="rule" items="${rules}">
                                <c:if test="${selectedRules.contains(rule)}">
                                    <option value="${rule.id}" selected>${rule.name}</option>
                                </c:if>
                                <c:if test="${!selectedRules.contains(rule)}">
                                    <option value="${rule.id}">${rule.name}</option>
                                </c:if>
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