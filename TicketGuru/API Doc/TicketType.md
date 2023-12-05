# **TicketType**

### Endpoints

- **URL**

  /api/tickettypes | /api/tickettypes/{ticketTypeId}

- **Method:**

  `GET` /tickettypes for all | /tickettypes/{ticketTypeId} for single ticket type<br />
  **Permissions required**: Admin or TicketSeller<br />

  `POST` /tickettypes<br />
  **Permissions required**: Admin<br />

  `DELETE` /tickettypes/{ticketTypeId}<br />
  **Permissions required**: Admin<br />

  `PUT` /tickettypes/{ticketTypeId}<br />
  **Permissions required**: Admin<br />

### Authentication and Permissions

- **Authentication Required**: YES

### URL Params

`ticketTypeId`: id for TicketType entity, a primary key

### Data Params

**`price`**: double (required)<br />
**`ticketName`**: String (required)<br />
**`description`**: String

### Success Responses

- **GET /tickettypes and /tickettypes/{ticketTypeId}**

  - **Code**: 200 OK
  - **Content**: List of `TicketType` or a single `TicketType` instance

- **POST /tickettypes**

  - **Code**: 201 Created
  - **Content**: `TicketType` instance that was created

- **PUT /tickettypes/{ticketTypeId}**

  - **Code**: 200 OK
  - **Content**: Updated `TicketType` instance

- **DELETE /tickettypes/{ticketTypeId} and /tickettypes**
  - **Code**: 204 No Content

### Error Responses

- **General Errors**

  - **Code**: 400 BAD_REQUEST
  - **Content**: None

- **Resource Not Found**
  - **Code**: 404 NOT_FOUND
  - **Content**: None

### Sample Request Bodies

- **GET**

```
{
    "ticketTypeId": 1
    "price": 15.0,
    "ticketName": "Student",
    "description": "Discount for students",
    "event": {},
}
```

- **POST**

```
{
  "price": 5,
  "ticketName": "Children",
  "description": "Childen under 15",
  "event": {
     "eventId": 1
  }
}
```
