
>### 📌Technologies
* Java 17
* Spring Boot 3.0
* Spring Data JPA
* H2 In Memory Database
* Postgre Sql
* Restful API
* Maven

>Base End Point : http://localhost:8087/api/v1


**Film Service**<br>
User End Point : http://localhost:8087/api/v1/films
``` 
 ▪️ http://localhost:8087/api/v1/films ->  Save Film ,  Get All Films                                                   -> POST, GET
 ▪️ http://localhost:8087/api/v1/films/{filmName} ->  Get 1 film by film name                                           -> GET                                                                                                -> DELETE
 ▪️ http://localhost:8087/api/v1/films/film/{name} ->  Update film score by film name                                   -> PUT
 ▪️ http://localhost:8087/api/v1/films/film/{filmId}/{userId} ->  Update user list at film entity  table                -> PUT
 ▪️ http://localhost:8087/api/v1/films/score/{score} ->  Get films by score                                             -> GET
 ▪️ http://localhost:8087/api/v1/films/category/{category} -> Get films by film category                                -> GET
 ▪️ http://localhost:8087/api/v1/films/{name} ->  Update film name or explanation by film name,                         -> PUT
  Delete film by name 

```




**UserService**

Film End Point : http://localhost:8087/api/v1/users
``` 
▪️ http://localhost:8087/api/v1/users -> Save User , Get All Users                                                     -> POST, GET
▪️ http://localhost:8087/api/v1/users/{name}/{surName} -> Delete user by user name and surname                         -> DELETE
▪️ http://localhost:8087/api/v1/users/{name} -> Get user by user name                                                  -> GET
▪️ http://localhost:8087/api/v1/users/user/{userId}/{filmId} -> Update film list at user entity table                  -> PUT
▪️ http://localhost:8087/api/v1/users/user/{userId}/film/{filmId} -> Delete film from film list at user entity table   -> DELETE                                                                               
▪️ http://localhost:8087/api/v1/users/{name}/{surName}?password=123 -> Update user password by user name and surname   -> PUT
▪️ http://localhost:8087/api/v1/users?userId=1&filmId=1 -> if Film1  exist in User1's film list ,                      -> PUT
 film mark attibute changed to close  

```