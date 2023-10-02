## **TicketType**

- **URL**

  /api/tickettypes | /api/tickettypes/{ticketTypeId}

- **Method:**

  `GET` /tickettypes for all | /tickettypes/{ticketTypeId} for single ticket type
  `POST` /tickettypes
  `DELETE` /tickettypes/{ticketTypeId}
  `PUT` /tickettypes/{ticketTypeId}

- **URL Params**

  `ticketTypeId`: id for TicketType entity, a primary key

- **Data Params**

  All columns in table are nullable, none are required
  "price": int
  "customerType": String
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
    "typeId": 1,
    "price": 50,
    "customerType": "Opiskelija",
    "description": "Alennus opiskelijoille"
}
```

- **POST**

```
{
    "price": 10,
    "customerType": "Työtön",
    "description": "Alennus työttömille"
}
```
