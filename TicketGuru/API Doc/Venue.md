# **Venue**

### Endpoints

- **URL**

  /api/venues | /api/venues/{venueId}

- **Method:**

  `GET` /venues for all | /venues/{venueId} for single venue<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />

  `POST` /venues<br />
  **Permissions required**: Admin<br />

  `DELETE` /venues/{venueId}<br />
  **Permissions required**: Admin<br />

  `PUT` /venues/{venueId}<br />
  **Permissions required**: Admin<br />

### Authentication and Permissions

- **Authentication Required**: YES

### URL Params

`venueId` : id for Venue entity, a primary key

### Data Params

**`name`**: String (required)<br />
**`address`**: String (required)<br />
**`city`**: String (required)<br />
**`capacity`**: int

### Success Responses

- **GET /venues and /venues/{venueId}**

  - **Code**: 200 OK
  - **Content**: List of `Venue` or a single `Venue` instance

- **POST /venues**

  - **Code**: 201 Created
  - **Content**: `Venue` instance that was created

- **PUT /venues/{venueId}**

  - **Code**: 200 OK
  - **Content**: Updated `Venue` instance

- **DELETE /venues/{venueId} and /venues**
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
