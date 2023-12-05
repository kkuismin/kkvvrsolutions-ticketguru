# **Ticket**

### Endpoints

- **URL**

  /api/tickets | /api/tickets/{ticketId}

- **Method:**

  `GET` /tickets for all | /tickets/{ticketId} for single ticket<br />
  **Permissions required**: Admin or TicketSeller<br />

  `POST` /tickets<br />
  **Permissions required**: Admin<br />

  `DELETE` /tickets/{ticketId}<br />
  **Permissions required**: Admin<br />

  `PUT` /tickets/{ticketId}<br />
  **Permissions required**: Admin<br />

  `PATCH` /tickets/barcode/{barcode}/checked<br />
  **Permissions required**: Admin<br />

### Authentication and Permissions

- **Authentication Required**: YES

### URL Params

`ticketId`: id for Ticket entity, a primary key

### Data Params

**`barcode`**: String (nullable)<br />
**`isChecked`**: Boolean (nullable)

### Success Responses

- **GET /tickets and /tickets/{ticketId}**

  - **Code**: 200 OK
  - **Content**: List of `Ticket` or a single `Ticket` instance

- **POST /tickets**

  - **Code**: 201 Created
  - **Content**: `Ticket` instance that was created

- **PUT /tickets/{ticketId}**

  - **Code**: 200 OK
  - **Content**: Updated `Ticket` instance

- **DELETE /tickets/{ticketId}**

  - **Code**: 204 No Content

- **PATCH /tickets/barcode/{barcode}/checked**
  - **Code**: 200 OK
  - **Content**: Updated `Ticket` instance

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
   "ticketId": 1,
   "event": {},
   "ticketType": {},
   "saleEvent": {},
   "barcode": "16980692908420002",
   "isChecked": "false"
}
```

- **POST**

```
{
    "event": {
        "eventId": 1
	},
    "ticketType": {
        "ticketTypeId": 1
	},
    "saleEvent": {
        "saleEventId": 1
    },
}
```
