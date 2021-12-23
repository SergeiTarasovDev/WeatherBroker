<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/style.css" rel="stylesheet" type="text/css">
    <title>IWB - Города</title>
</head>
<body>

<div class="menu">
    <p><a href="/logout">выход</a></p>
</div>

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">
        <div class="tabs">
            <div class="tab">
                <a href="/administrator/cities">Города</a>
            </div>
            <div class="tab active">
                Пользователи
            </div>
        </div>
        <div class="data">
            <h2>Фильтр</h2>
            <div class="filters">
                <form method="get" action="/administrator/users/filtred" name="filter">
                    <div class="inline" style="border-right: solid 2px green;"><a href="/administrator/users"><div>Все пользователи</div></a></div>
                    <div class="inline" style="margin-left: 10px">По критериям:</div>
                    <div class="inline">
                        <select name="city-id">
                            <#list cities as city>
                                <option value="${city.id}">${city.cityName}</option>
                            </#list>
                        </select>
                    </div>
                    <input type="submit" value="Фильтр" class="inline">
                </form>
            </div>

            <h2>Список пользователей</h2>
            <#if users?has_content>
                <table>
                    <tr>
                        <th><div class="th">ID</div></th>
                        <th><div class="th">Email</div></th>
                        <th><div class="th">Имя</div></th>
                        <th><div class="th">Фамилия</div></th>
                        <th><div class="th">Город</div></th>
                        <th><div class="th">Права</div></th>
                        <th><div class="th" colspan="2">Действие</div></th>
                    </tr>
                    <#list users as user>
                        <tr>
                            <td>${user.getId()}</td>
                            <#if editUser?? && cities?? && editUser.getId() == user.getId()>
                                <form method="post" action="/administrator/users/${user.id}/update">
                                    <td><input name="email" value="${user.getEmail()}"></td>
                                    <td><input name="firstName" value="${user.getFirstName()}"></td>
                                    <td><input name="lastName" value="${user.getLastName()}"></td>
                                    <td>
                                        <select name="city">
                                            <#list cities as city>
                                                <#if city.getId() != user.getCity().getId()>
                                                    <option value="${city.getId()}">${city.getCityName()}</option>
                                                <#else>
                                                    <option value="${city.getId()}" selected>${city.getCityName()}</option>
                                                </#if>
                                            </#list>
                                        </select>
                                    </td>
                                    <td><input name="role" value="${user.getRole()}"></td>
                                    <td>
                                            <input type="submit" value="Сохранить">
                                    </td>
                                </form>
                            <#else>
                                <td>${user.getEmail()}</td>
                                <td>${user.getFirstName()}</td>
                                <td>${user.getLastName()}</td>
                                <td>${user.getCity().getCityName()}</td>
                                <td>${user.getRole()}</td>
                                <td>
                                    <form method="get" action="/administrator/users/${user.id}/edit">
                                        <input type="submit" value="Изменить">
                                    </form>
                                </td>
                            </#if>
                            <td>
                                <form method="post" action="/administrator/users/${user.id}/delete">
                                    <input type="submit" value="Удалить">
                                </form>
                            </td>
                        </tr>

                    </#list>
                </table>
            <#else>
                <div class="empty-list">Пользователи не найдены</div>
            </#if>
        </div>
    </div>
</div>

<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>