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
    <p style="font-size: 20px; border-bottom: solid 2px green; padding: 0 10px; margin-bottom: 7px;">
        <a href="/account">${user.getFirstName()} ${user.getLastName()}</a></p>
    <p><a href="/account/config">настройки</a></p>
    <p><a href="/logout">выход</a></p>
</div>

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">
        <div class="tabs">
            <div class="tab active">
                Города
            </div>
            <div class="tab">
                <a href="/administrator/users">Пользователи</a>
            </div>
        </div>
        <div class="data">
            <div class="city-add">
                <form method="post" action="/administrator/cities">
                    <input name="cityName" placeholder="Добавить город...">
                    <input type="hidden" name="temperature" value="-100">
                    <input type="hidden" name="pressure" value="-100">
                    <input type="hidden" name="humidity" value="-100">
                    <input type="hidden" name="windSpeed" value="-100.0">
                    <input type="hidden" name="windDeg" value="-100">
                    <input type="hidden" name="icon" value="03d">
                    <input type="submit" value="Добавить">
                </form>
            </div>

            <div class="filters">
                <h2>Фильтр городов</h2>
                <form method="get" action="/administrator/cities/filtred" name="filter">
                    <div class="inline" style="border-right: solid 2px green;"><a href="/administrator/cities"><div>Все города</div></a></div>
                    <div class="inline" style="margin-left: 10px">По критериям:</div>
                    <div class="inline"><input type="radio" name="side" value="great" checked>выше</div>
                    <div class="inline"><input type="radio" name="side" value="less">ниже</div>
                    <div class="inline"><input name="temperature" placeholder="Введите температуру"></div>
                    <input type="submit" value="Фильтр" class="inline">
                </form>
            </div>

            <h2>Список городов</h2>
            <#if cities?has_content>
                <table class="zebra-table">
                    <tr>
                        <th><div class="th">ID</div></th>
                        <th><div class="th">Название</div></th>
                        <th><div class="th">Температура воздуха</div></th>
                        <th><div class="th">Атмосферное давление</div></th>
                        <th><div class="th">Относительная влажность</div></th>
                        <th><div class="th">Скорость ветра</div></th>
                        <th><div class="th">Направление ветра</div></th>
                        <th><div class="th">Количество пользователей</div></th>
                        <th><div class="th">Действие</div></th>
                    </tr>
                    <#list cities as city, countUsers>
                        <tr class="row">
                            <td><div class="center">${city.getId()}
                                    <div class="icon-img">
                                        <img class="icon" src="http://openweathermap.org/img/wn/${city.getIcon()}@2x.png">
                                    </div>
                                </div></td>
                            <td><div class="left">${city.getCityName()}</div></td>
                            <td><div class="center">${city.getTemperature()} °С</div></td>
                            <td><div class="center">${city.getPressure()} мм</div></td>
                            <td><div class="center">${city.getHumidity()} %</div></td>
                            <td><div class="center">${city.getWindSpeed()} м/сек</div></td>
                            <td><div class="center">${city.getWindDeg()} °</div></td>
                            <td><div class="center">
                                    <#if countUsers == 0>
                                        -
                                    <#else>
                                        <a href="/administrator/users/filtred?city-id=${city.getId()}" style="text-decoration: underline;">${countUsers}</a>
                                    </#if>
                                </div></td>
                            <td>
                                <div class="center">
                                    <form method="post" action="/administrator/cities/${city.id}/delete">
                                        <input type="submit" value="Удалить">
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </#list>
                </table>
            <#else>
                <div class="empty-list">Нет городов с такой погодой</div>
            </#if>
        </div>
    </div>
</div>

<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>