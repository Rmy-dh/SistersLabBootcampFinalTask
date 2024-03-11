# SistersLab Bootcamp Final Task🎓

-----------------------------------------------------------------

### 🎯 Proje Ödevi:

#### Proje Adı: Film Arkadaşı
***Amaç:***
Bu proje, Spring Boot ve temel CRUD (Create, Read, Update, Delete) işlemlerini anlamanıza yardımcı olacak bir film izleme uygulaması geliştirmelerinizi amaçlamaktadır. Bu proje aynı zamanda ilişkisel veritabanı yönetimi ve RESTful web servisleri konularında da deneyim kazandıracaktır.

***Gereksinimler:***
1. **Kullanıcı Yönetimi:**
   - Kullanıcılar, ad, username, mail ,password gibi özelliklerle birlikte veritabanında saklanabilmelidir.
   - Kullanıcılar yeni kayit olusturabilmeli ve kayitli kullanicilari listeleyebilmeli.
   - Kayıtlı kullanıcılar, parolalarını güncelleyebilmeli ve hesaplarını silebilmelidir.
   - Kayıtlı kullanıcıların hepsi listelene bilmeli.
2. **Film Yönetimi:**
   - Filmler, ad, açıklama, yayın tarihi ve puan gibi özelliklerle birlikte veritabanında saklanabilmelidir.
   - Kullanıcılar, filmleri listeleyebilmeli, yeni film ekleyebilmeli, mevcut filmleri düzenleyebilmeli ve silebilmelidir.
3. **İzleme Listesi (Watchlist):**
   - Kullanıcılar, izlemek istedikleri filmleri bir izleme listesine ekleyebilmeli, bu listeden filmleri kaldırabilmeli ve izlenen filmleri işaretleyebilmelidir.
   - İzleme listesi, kullanıcı ve film arasında Many-to-Many ilişkisiyle oluşturulmalıdır.

***Teknik Detaylar:***
1. **Spring Boot:**
   - Uygulama, Spring Boot kullanılarak geliştirilmelidir.
2. **Veritabanı:**
   - İlişkisel bir veritabanı (örneğin,PostgreSQL, MySQL, H2) kullanılmalıdır.
   - JPA (Java Persistence API) veya Spring Data JPA kullanılarak veritabanı işlemleri gerçekleştirilmelidir.
3. **RESTful Web Servisleri:**
   - Film ve kullanıcı işlemleri için RESTful API'lar oluşturulmalıdır.
   - API'lar, JSON formatında veri döndürmelidir.
4. **Frontend (İsteğe Bağlı):**
   - İsteğe bağlı olarak Angular, React veya Vue.js gibi bir web arayüzü oluşturulabilir.
   - Web arayüzü, kullanıcıların uygulamaya erişimini kolaylaştırmalı ve CRUD işlemlerini gerçekleştirebilmelidir.
     İleri Seviye Özellikler (İsteğe Bağlı)


------------------------------------------

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
Film End Point : http://localhost:8087/api/v1/films
``` 
 ▪️ http://localhost:8087/api/v1/films ->  Save Film ,  Get All Films                                                   -> POST, GET
 ▪️ http://localhost:8087/api/v1/films/{filmName} ->  Get 1 film by film name                                           -> GET                                                                                                
 ▪️ http://localhost:8087/api/v1/films/film/{name} ->  Update film score by film name                                   -> PUT
 ▪️ http://localhost:8087/api/v1/films/film/{filmId}/{userId} ->  Update user list at film entity  table                -> PUT
 ▪️ http://localhost:8087/api/v1/films/score/{score} ->  Get films by score                                             -> GET
 ▪️ http://localhost:8087/api/v1/films/category/{category} -> Get films by film category                                -> GET
 ▪️ http://localhost:8087/api/v1/films/{name} ->  Update film name or explanation by film name,                         -> PUT, DELETE
  Delete film by name 

```


**UserService**

User End Point : http://localhost:8087/api/v1/users
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




