<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/style.css" rel="stylesheet" type="text/css">
    <title>IWB - Регистрация</title>
</head>
<body>

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">
        <div class="sign">
            <form method="post" action="/signUp">
                <p><div style="width: 100px;">Имя:</div>
                    <input name="firstName" placeholder="Введите имя...">
                </p>
                <p><div style="width: 100px;">Фамилия:</div>
                    <input name="lastName" placeholder="Введите фамилию...">
                </p>
                <p><div style="width: 100px;">Email:</div>
                    <input type="email" name="email" placeholder="Введите e-mail...">
                </p>
                <p><div style="width: 100px;">Пароль:</div>
                    <input type="password" name="password" placeholder="Введите пароль...">
                </p>
                <p><div style="width: 100px;">Город:</div>
                    <div class="select">
                        <select name="city">
                            <#list cities as city>
                                <option value="${city.id}">${city.cityName}</option>
                            </#list>
                        </select>
                    </div>
                </p>
                <div class="sign-button"><input type="submit" name="signUp" value="Регистрация"></div>
                <p style="text-align: center; font-size: 14px;"><a href="/signIn">Войти</a></p>
            </form>
        </div>
    </div>
</div>



<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>