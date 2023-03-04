# notes-with-SpringBoot
Приложение Заметки с применением Spring Boot

Приложение использует фреймворк Spring Boot и сериализацию и десериализацию сохраненных данных из JSON.
Так же дополнительно реализовал REST сервис для работы с данными через Postman.
Реализованы GET, POST, DELETE запросы.

Функционал приложения состоит из:

Добавление заметки
Просмотр всех заметок
Удаление заметки
Редактирование заметки
Приложение постоянно сохраняет данные в формате JSON и подгружает их при запуске 

В дальнейшем можно улучшить интерфейс и использвать Spring Data для хранения данных
Для доступа к веб версии: http://localhost:8080/notes
Для REST http://localhost:8080/

REST
![image](https://user-images.githubusercontent.com/92898813/222927553-da710407-bc85-4d88-9778-96bc331bcbde.png)

Веб
![image](https://user-images.githubusercontent.com/92898813/222927579-062b2a86-8c37-46c2-bf13-dc75744d3007.png)