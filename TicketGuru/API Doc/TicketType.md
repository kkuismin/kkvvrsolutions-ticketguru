# **TicketType**

- **URL**

  /api/tickettypes | /api/tickettypes/{ticketTypeId}

- **Method:**

  `GET` /tickettypes for all | /tickettypes/{ticketTypeId} for single ticket type<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `POST` /tickettypes<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `DELETE` /tickettypes/{ticketTypeId}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `PUT` /tickettypes/{ticketTypeId}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

- **URL Params**

  `ticketTypeId`: id for TicketType entity, a primary key

- **Data Params**

  Price and ticketName are required<br />
  "price": double<br />
  "ticketName": String<br />
  "description": String

- **Success Response:**

  - **Code:** 200 <br />
    **Content:** `All TicketTypes or single TicketType`

  - **Code:** 201 <br />
    **Content:** `Created TicketType`

- **Error Response:**

  - **Code:** 404 NOT_FOUND <br />
    **Content:** `None`

- **Sample Body:**

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
