## Счетчик уникальных слов
Приложение, которое сохраняет web-страницу 
в HTML формате на жесткий диск, подсчитывает количество 
уникальных слов на странице и выводит статистику в консоль 
## Использование
Приложение поставляется в виде zip-архива. В архиве имеется 2 папки:
src - папка с исходным кодом и target - папка с готовым к исполнению модулем TestTask.jar
и файлом examples.txt, где расположено 2 примера для запуска приложения на примере
английского и русского сайтов.
 
Для запуска приложения вам необходимо иметь установленную Java 8+. 
Для запуска приложения предварительно скачайте архив с программой,
откройте консоль и перейдите в папку target, где расположен архив
TestTask.jar.   

#### Параметры для запуска
При запуске приложения Вам необходимо указать адрес web-страницы 
которую Вы хотите скачать. Без данного параметра приложение выведет
 сообщение о его необходимости. Дополнительно Вы можете указать путь до папки
на жестком диске, куда Вы хотите сохранить HTML файл. 

#### Запуск
Приложение запускается с помощью команды `java -jar TestTask.jar <URL> <filepath>`,
где URL - адрес web-страницы, а filepath (необязательный параметр) - путь до папки на жестком диске.
Без данного параметра приложение по умолчанию сохраняет файл в папку где находится архив.
Пример java -jar TestTask.jar https://www.simbirsoft.com/

