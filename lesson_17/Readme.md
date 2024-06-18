# Практическое задание № 17
Перейдите в сервис Postman.
Войдите в свой аккаунт и скачайте себе коллекцию Postman Echo.
Написать автотесты для каждого метода из папки Request Methods (проверка тела ответа (просто сравнить значения всех полей) и кода ответа).

## Описание коллекции PostmanEcho

### **GetRequest**

--location 'https://postman-echo.com/get?name=Ric&id=15'

### **Post Raw Text**

curl --location 'https://postman-echo.com/post' \
--header 'Content-Type: text/plain' \
--data '{
"test": "value"
}'

### **Post Form Data**

curl --location 'https://postman-echo.com/post' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'foo1=bar1' \
--data-urlencode 'foo2=bar2'


### **Put**

curl --location --request PUT 'https://postman-echo.com/put' \
--header 'Content-Type: text/plain' \
--data 'This is expected to be sent back as part of response body.'


### **Patch**

curl --location --request PATCH 'https://postman-echo.com/patch' \
--header 'Content-Type: text/plain' \
--data 'This is expected to be sent back as part of response body.'

### **Delete**
curl --location --request DELETE 'https://postman-echo.com/delete' \
--header 'Content-Type: text/plain' \
--data 'This is expected to be sent back as part of response body.'