# **Event**

### Endpoints

- **URL**

  /api/events | /api/events/{eventId}

- **Method:**

  `GET` /events for all | /events/{eventId} for single event<br />
  **Permissions required**: Admin or TicketSeller<br />

  `POST` /events<br />
  **Permissions required**: Admin<br />

  `DELETE` /events/{eventId}<br />
  **Permissions required**: Admin<br />

  `PUT` /events/{eventId}<br />
  **Permissions required**: Admin<br />

### Authentication and Permissions

- **Authentication Required**: YES

### URL Params

`eventId`: id for Event entity, a primary key

### Data Params

**`name`**: String (required)<br />
**`date`**: LocalDate (required)<br />
**`time`**: LocalTime (required)<br />
**`venue`**: Object containing `venueId`

### Success Responses

- **GET /events and /events/{eventId}**

  - **Code**: 200 OK
  - **Content**: List of `Event` or a single `Event` instance

- **POST /events**

  - **Code**: 201 Created
  - **Content**: `Event` instance that was created

- **PUT /events/{eventId}**

  - **Code**: 200 OK
  - **Content**: Updated `Event` instance

- **DELETE /events/{eventId}**
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
	"eventId": 1,
	"name": "Concert",
	"date": "2023-12-20",
	"time": "19:15",
	"venue": {}
}
```

- **POST**

```
{
	"name": "Concert",
	"date": "2023-12-20",
	"time": "19:15",
	"venue": {
        "venueId": 1
	}
}
```
