<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>IWB - Регистрация</title>
</head>
<body>
    <form method="post" action="/sign_up">
        <label>Имя:
            <input name="firstName" placeholder="Введите имя...">
        </label>
        <label>Фамилия:
            <input name="lastName" placeholder="Введите фамилию...">
        </label>
        <label>E-Mail:
            <input type="email" name="email" placeholder="Введите e-mail...">
        </label>
        <label>Пароль:
            <input type="password" name="password" placeholder="Введите пароль...">
        </label>
        <input type="submit" value="Регистрация">
    </form>
</body>
</html>