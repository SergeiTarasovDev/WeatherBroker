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

            <div class="filter">
                <h3>Фильтр</h3>
                <div>
                    <ul>
                        <li><a href="/cities/0/temp-great">Все пользователи</a></li>
                        <li><a href="/cities/0/temp-great">Пользователи из выбранного города</a></li>
                    </ul>
                </div>
            </div>

            <h2>Список пользователей</h2>
            <table>
                <tr>
                    <th><div class="th">ID</div></th>
                    <th><div class="th">Email</div></th>
                    <th><div class="th">Имя</div></th>
                    <th><div class="th">Фамилия</div></th>
                    <th><div class="th">Город</div></th>
                    <th><div class="th">Права</div></th>
                    <th><div class="th">Действие</div></th>
                </tr>
                <#list users as user>
                    <tr>
                        <td>${user.getId()}</td>
                        <td>${user.getEmail()}</td>
                        <td>${user.getFirstName()}</td>
                        <td>${user.getLastName()}</td>
                        <td>${user.getCity().getCityName()}</td>
                        <td>${user.getRole()}</td>
                        <td>
                            <form method="post" action="/administrator/users/${user.id}/delete">
                                <input type="submit" value="Удалить">
                            </form>
                        </td>
                    </tr>

                </#list>
            </table>
        </div>
    </div>
</div>

<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>