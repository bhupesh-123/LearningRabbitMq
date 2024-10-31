set rabbitmq:
docker run -d --hostname rabbit --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management


local host url:
Access RabbitMQ UI at http://localhost:15672/ (username: guest, password: guest).