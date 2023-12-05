# **AppUser**

### Endpoints

- **URL**

  /api/users | /api/users/{userId}

- **Method:**

  `GET` /users for all | /users/{userId} for single user<br />
  **Permissions required**: Admin<br />

  `POST` /users<br />
  **Permissions required**: Admin<br />

  `DELETE` /users/{userId}<br />
  **Permissions required**: Admin<br />

  `PUT` /users/{userId}<br />
  **Permissions required**: Admin<br />

### Authentication and Permissions

- **Authentication Required**: YES

### URL Params

`userId` : id for AppUser entity, a primary key

### Data Params

**`username`**: String (required)<br />
**`password`**: String (required)<br />
**`role`**: String, must be either "ADMIN" or "TICKETSELLER" (required)

### Success Responses

- **GET /users and /users/{userId}**

  - **Code**: 200 OK
  - **Content**: List of `AppUser` or a single `AppUser` instance

- **POST /users**

  - **Code**: 201 Created
  - **Content**: `AppUser` instance that was created

- **PUT /users/{userId}**

  - **Code**: 200 OK
  - **Content**: Updated `AppUser` instance

- **DELETE /users/{userId}**
  - **Code**: 204 No Content

### Error Responses

- **General Errors**

  - **Code**: 400 BAD_REQUEST
  - **Content**: None (occurs when there's a bad request, such as invalid role)

- **Resource Not Found**

  - **Code**: 404 NOT_FOUND
  - **Content**: None

### Sample Request Bodies

- **GET**

```
{
    "userId": 1,
    "username": "user",
    "passwordHash": "user",
    "role": "ADMIN",
}
```

- **POST**

```
{
    "username": "user",
    "passwordHash": "user",
    "role": "ADMIN",
}
```
