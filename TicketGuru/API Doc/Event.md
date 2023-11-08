# **Event**

- **URL**

  /api/events | /api/events/{eventId}
  
  **Method:**

  `GET` /events for all | /events/{eventId} for single event<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `POST` /events<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `DELETE` /events/{eventId}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `PUT` /events/{eventId}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

- **URL Params**

  `eventId`: id for Event entity, a primary key
  
- **Data Params**

  All columns are required<br />
  "name": String <br />
  "date": LocalDate<br />
  "time": LocalTime
  
  **Success Response:**

  - **Code:** 200 <br />
    **Content:** `All Events or Event`

    **Code:** 201 <br />
    **Content:** `Created Event`

- **Error Response:**

  - **Code:** 404 NOT_FOUND <br />
    **Content:** `None`

- **Sample Body:**

- **GET**

```
{
	"eventId": 1,
	"name": "Concert",
	"date": "2023-12-20",
	"time": "19:15",
	"venueList": {}
}
```

- **POST**

```
{
	"name": "Concert",
	"date": "2023-12-20",
	"time": "19:15",
	"venueList": {
		"venueId": 1
	}
}
```

