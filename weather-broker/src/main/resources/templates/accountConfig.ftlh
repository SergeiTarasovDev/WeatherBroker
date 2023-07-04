<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/style.css" rel="stylesheet" type="text/css">
    <title>IWB - Настройки пользователя</title>
</head>
<body>

<div class="menu">
    <p style="font-size: 20px; border-bottom: solid 2px green; padding: 0 10px; margin-bottom: 7px;">
        <a href="/account">${user.getFirstName()} ${user.getLastName()}</a></p>
    <p><a href="/account/config">настройки</a></p>
    <p><a href="/logout">выход</a></p>
</div>

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">
        <div class="user-edit">
            <form method="post" action="/account/${user.getId()}/update">
                <table>
                    <tr>
                        <td>Имя:</td>
                        <td><input name="firstName" value="${user.getFirstName()}"></td>
                    </tr>
                    <tr>
                        <td>Фамилия:</td>
                        <td><input name="lastName" value="${user.getLastName()}"></td>
                    </tr>
                <tr>
                        <td>Email:</td>
                        <td><input type="email" name="email" value="${user.getEmail()}"></td>
                    </tr>
                <tr>
                        <td>Пароль:</td>
                        <td><input type="password" name="password" placeholder="Новый пароль..."></td>
                    </tr>
                <tr>
                        <td>Город:</td>
                        <td>
                            <div class="select">
                                <select name="city">
                                    <#list cities as city>
                                        <#if city.getId() == user.getCity().getId()>
                                            <option value="${city.id}" selected>${city.cityName}</option>
                                        <#else>
                                            <option value="${city.id}">${city.cityName}</option>
                                        </#if>
                                    </#list>
                                </select>
                            </div>
                        </td>
                    </tr>
                <tr>
                        <td>Telegram ID:</td>
                        <td><input name="telegramId" value="${user.getTelegramId()}"></td>
                    </tr>
                </table>
                <div class="user-edit-button"><input type="submit" value="Изменить"></div>
                <p style="text-align: center; font-size: 14px;"><a href="/account">Отмена</a></p>
            </form>
        </div>
    </div>
</div>

<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>