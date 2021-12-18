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

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">
        <h1>Список городов</h1>

        <h2>Добавить город</h2>
        <form method="post" action="/cities">
            <label>
                <input name="cityName" placeholder="Введите город...">
            </label>
            <input type="hidden" name="temperature" value="-100.0">
            <input type="hidden" name="pressure" value="-100">
            <input type="hidden" name="humidity" value="-100">
            <input type="hidden" name="windSpeed" value="-100.0">
            <input type="hidden" name="windDeg" value="-100">
            <input type="submit" value="Добавить">
        </form>

        <!--<h2>Фильтр городов</h2>
        <form method="get" action="/cities">
            <p><input type="radio" name="great" value="great">Выше введенной температуры</p>
            <p><input type="radio" name="less" value="less">Ниже введенной температуры</p>
            <p><input name="temperature" placeholder="Введите температуру"></p>
            <input type="submit" value="Фильтровать">
        </form>-->


        <h2>Фильтр</h2>
        <div>
            <ul>
                <li><a href="/cities/0/temp-great">Города, в которых температура выше 0 градусов</a></li>
                <li><a href="/cities/0/temp-less">Города, в которых температура ниже 0 градусов</a></li>
            </ul>
        </div>

        <h2>Список городов</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Температура воздуха</th>
                <th>Атмосферное давление</th>
                <th>Относительная влажность</th>
                <th>Скорость ветра</th>
                <th>Направление ветра</th>
                <th>Действие</th>
            </tr>
            <#list cities as city>
                <tr>
                    <td>${city.id}</td>
                    <td>${city.cityName}</td>
                    <td>${city.temperature}</td>
                    <td>${city.pressure}</td>
                    <td>${city.humidity}</td>
                    <td>${city.windSpeed}</td>
                    <td>${city.windDeg}</td>
                    <td>
                        <form method="post" action="/cities/${city.id}/delete">
                            <input type="submit" value="Удалить">
                        </form>
                        <a href="/cities/${city.id}">Перейти</a>
                    </td>
                </tr>

            </#list>
        </table>
    </div>
</div>

<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>