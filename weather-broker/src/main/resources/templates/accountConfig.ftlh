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
       <form method="post" action="/account/${user.getId()}/update">
           <p><div style="width: 100px;">Имя:</div>
           <input name="firstName" value="${user.getFirstName()}">
           </p>
           <p><div style="width: 100px;">Фамилия:</div>
           <input name="lastName" value="${user.getLastName()}">
           </p>
           <p><div style="width: 100px;">Email:</div>
           <input type="email" name="email" value="${user.getEmail()}">
           </p>
           <p><div style="width: 100px;">Пароль:</div>
           <input type="password" name="password" placeholder="Введите новый пароль...">
           </p>
           <p><div style="width: 100px;">Город:</div>
           <select name="city">
               <#list cities as city>
                   <#if city.getId() == user.getCity().getId()>
                       <option value="${city.id}" selected>${city.cityName}</option>
                   <#else>
                       <option value="${city.id}">${city.cityName}</option>
                   </#if>
               </#list>
           </select>
           </p>
           <input type="submit" value="Сохранить">
       </form>
    </div>
</div>



<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>