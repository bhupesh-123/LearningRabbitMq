set rabbitmq:
docker run -d --hostname rabbit --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management

start docker:
sudo docker start rabbitmq

local host url:
Access RabbitMQ UI at http://localhost:15672/ (username: guest, password: guest).

jwt security implemetation:

1.  Project Dependencies
Add the following dependencies to your pom.xml:


2.  Database Configuration
Configure application.properties for your SQL database connection and JWT settings:

3.  User Entity
Define a User entity that maps to your database table.

4. User Repository
Define a UserRepository interface for data access.

5. JWT Utility
Create a utility class for generating and validating JWT tokens.

6. Custom UserDetailsService
Implement UserDetailsService to load user data from the database.

7. JWT Authentication Filter
Create a JWT filter to validate tokens for incoming requests.

8. Security Configuration
Configure Spring Security to use JWT for stateless authentication.

9. Authentication Controller
Create a controller to handle login requests and issue JWT tokens.

Create a DTO for the login request:

10. Testing
1. Run your Spring Boot application.
2. Test /auth/login by sending a POST request with username and password in the body.
3. Use the received JWT token in the Authorization header for accessing protected endpoints.
