# **AppUser**

- **URL**

  /api/users

  /api/users/{id}

- **Method:**

  `GET` /users for all | /users/{id} for single user<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin<br />

  `POST` /users<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin<br />

  `DELETE` /users/{id}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin<br />

  `PUT` /users/{id}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin<br />

- **URL Params**

  `userId` : id for AppUser entity, a primary key

- **Data Params**

  All columns are required<br />
  "username" : String<br />
  "passwordHash" : String<br />
  "role" : String

- **Success response**

  - **Code:** 200 <br />
    **Content:** `AppUsers or AppUser`

  - **Code** 201 <br />
    **Content:** `Created AppUser`

- **Error Response:**

  - **Code:** 404 NOT_FOUND <br />
    **Content:** `None`

- **Sample Body:**

- **GET**

```
{
    "userId": 1,
    "username": "user",
    "password": "user",
    "role": "ADMIN",
}
```

- **POST**

```
{
    "username": "user",
    "password": "user",
    "role": "ADMIN",
}
```