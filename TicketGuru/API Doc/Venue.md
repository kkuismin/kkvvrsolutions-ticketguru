# **Venue**

- **URL**

  /api/venues

  /api/venues/{id}

- **Method:**

  `GET` /venues for all | /venues/{id} for single venue<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `POST` /venues<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `DELETE` /venues/{id}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `PUT` /venues/{id}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

- **URL Params**

  `venueId` : id for Venue entity, a primary key

- **Data Params**

  Name, address and city are required
  "name" : String
  "address" : String
  "city" : String
  "capacity" : int

- **Success response**

  - **Code:** 200 <br />
    **Content:** `Venues or Venue`

  - **Code** 201 <br />
    **Content:** `Created Venue`

- **Error Response:**

  - **Code:** 404 NOT_FOUND <br />
    **Content:** `None`

- **Sample Body:**

- **GET**

```
{
    "venueId": 1,
    "name": "Nokia Arena",
    "address": "Kansikatu 3",
    "city": "Tampere",
    "capacity": "15000"
}
```

- **POST**

```
{
    "name": "Nokia Arena",
    "address": "Kansikatu 3",
    "city": "Tampere",
    "capacity": "15000"
}
```
