# us
us is an attempt to perform SSO via OAuth and using incredible Spring framework. This is the client implementation on same, As a complete package there is a client called User Service (https://github.com/CODINGSAINT//OAuthSpringSSO) Which can be looked as complete implementation.

It uses

  - Spring Boot
  - Maven
  - Spring OAuth 2.0
  - MySQL 

In order to use it , install sql files inside src/resources/sql:

 -  schema.sql
 -  data.sql

# Installation
```
git clone https://github.com/CODINGSAINT/us.git
cd us
mvn package
cd target
java -java us-0.0.1-SNAPSHOT.jar
```


> This is just for tutorial . We don't take any responsibility for security
.

### Version
0.0.1

### How to Use
As first step you need to get OAuth id Access Token . Install OAuthSpringSSO
as mentioned in https://github.com/CODINGSAINT//OAuthSpringSSO


```
Method : GET/POST
URL:  http://localhost:9191/cds/auth/v1/oauth/token?username=admin&password=admin&grant_type=password
Basic Security Parameters
Username : coding_saint_client
password : coding_saint_client_secret
```
# Response 
```
{
  "access_token": "361c248d-d47c-4292-85ec-6791fcd61d27",
  "token_type": "bearer",
  "refresh_token": "5413ef08-91c0-4b9b-ab0b-bb0b2f47ef79",
  "expires_in": 43199,
  "scope": "read write"
}
```
From above access token we can invoke request at User services
```
Method : GET
URL : http://localhost:1111/cds/us/v1/users
Header
Authorization
Value
Bearer 361c248d-d47c-4292-85ec-6791fcd61d27
```

# Response
```
[
    {
        "username": "admin",
        "password": "b8f57d6d6ec0a60dfe2e20182d4615b12e321cad9e2979e0b9f81e0d6eda78ad9b6dcfe53e4e22d1",
        "email": "admin@codingsaint.com",
        "activated": true,
        "activationKey": null,
        "resetPasswordKey": null,
        "authorities": [
            {
                "name": "ROLE_USER"
            },
            {
                "name": "ROLE_ADMIN"
            }
        ]
    },
    {
        "username": "pallav",
        "password": "e92803f6694086bd9f88e23a62b694acaaa81e295aadde9c9126444c2196d995b37ab7e2386c225e",
        "email": "kumarpallav@kumarpallav.in",
        "activated": true,
        "activationKey": null,
        "resetPasswordKey": null,
        "authorities": [
            {
                "name": "ROLE_USER"
            },
            {
                "name": "ROLE_ADMIN"
            }
        ]
    }
]
```

##### Similarly You can check request for User Creation , Get User Details and User Update
