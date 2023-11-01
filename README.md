## Проект Spring Server создание персонажа в DnD

![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Pstgres](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

Простое CRUD приложение с созданием персонажа для DnD.

### Описание

Для двух таблиц race и character_class  настроены миграции для удобства создания персонажа, но так же можно добавить
свои расу или класс посредством методов 

```
POST http://localhost:8080/api/class/create //добавить новый класс
POST http://localhost:8080/api/race/create //добавить новую расу
GET http://localhost:8080/api/class //получить список всех классов
GET http://localhost:8080/api/race //получить список всех рас
PUT http://localhost:8080/api/class/update/{id} //изменить класс персонажа по id
PUT http://localhost:8080/api/race/update/{id} //изменить расу персонажа по id
DELETE http://localhost:8080/api/class/delete/{id} // удалить класс по id
DELETE http://localhost:8080/api/race/delete/{id} // удалить расу по id
```
Создание/изменение/удаление персонажа :

```
POST http://localhost:8080/api/character/create //добавить нового персонажа
PUT http://localhost:8080/api/character/update/{id} //изменить персонажа персонажа по id
DELETE http://localhost:8080/api/character/delete/{id} // удалить персонажа по id
GET http://localhost:8080/api/character //получить список всех персонажей
```
JSON's :

```
Персонаж :
{
    "name": "Test",
    "race": {
        "id" : 3,
        "raceName" : ""
    },
    "characterClass": {
        "id" : 6,
        "className" : ""
    }
}

Класс :
{
    "id": 10,
    "className": "Шаман"
}

Раса :
{
    "id": 2,
    "raceName": "Гнолл"
}
```

Проект поднимается с помощью команды docker compose up и работает из коробки, 
доступ к апи по адресу http://localhost:8080/api/ 

