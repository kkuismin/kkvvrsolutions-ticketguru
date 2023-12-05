# **SaleEvent**

This API allows you to sell tickets.

### Endpoints

- **URL**

  /api/sales | /api/sales/{saleEventId}

- **Method:**

  `GET` /sales for all | /sales/{saleEventId} for single sale<br />
  **Permissions required**: Admin or TicketSeller<br />

  `POST` /sales<br />
  **Permissions required**: Admin or TicketSeller<br />

  `DELETE` /sales/{saleEventId}<br />
  **Permissions required**: Admin or TicketSeller<br />

  `PUT` /sales/{saleEventId}<br />
  **Permissions required**: Admin or TicketSeller<br />

### Authentication and Permissions

- **Authentication Required**: YES

### URL Params

`saleEventId`: id for SaleEvent entity, a primary key

### Data Params

**`saleDate`**: LocalDate (required)<br />
**`saleTime`**: LocalTime (required)<br />
**`amount`**: int (required)<br />

### Success Responses

- **GET /sales and /sales/{saleEventId}**

  - **Code**: 200 OK
  - **Content**: List of `SaleEvent` or a single `SaleEvent` instance

- **POST /sales**

  - **Code**: 201 Created
  - **Content**: `SaleEvent` instance that was created

- **PUT /sales/{saleEventId}**

  - **Code**: 200 OK
  - **Content**: Updated `SaleEvent` instance

- **DELETE /sales/{saleEventId} and /sales**
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
  "saleEventId": 1,
  "ticketList": [],
  "SaleDate": "2023-10-02",
  "SaleTime": "16:34:00",
  "amount": 30.0
}
```

- **POST**

```
{
  "amount": 30.0,
  "ticketList": [
    {
      "event": {
        "eventId": 1
      },
      "ticketType": {
        "ticketTypeId": 1
      }
    }
  ]
}
```
