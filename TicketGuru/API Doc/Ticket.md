# **Ticket**

- **URL**

  /api/tickets | /api/tickets/{ticketId}

- **Method:**

  `GET` /tickets for all | /tickets/{ticketId} for single ticket<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />
  
  `POST` /tickets<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />
  
  `DELETE` /tickets/{ticketId}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />
  
  `PUT` /tickets/{ticketId}<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />
  
  `PATCH` /tickets/barcode/{barcode}/checked"<br />
  **Auth required**: YES<br />
  **Permissions required**: Admin or TicketSeller<br />
  
- **URL Params**

  `ticketId`: id for Ticket entity, a primary key

- **Data Params**

  All columns in table are nullable, none are required
  "barcode": String
  "isChecked": Boolean

- **Success Response:**

  - **Code:** 200 <br />
    **Content:** `All Tickets or Ticket`

  - **Code** 201 <br />
    **Content:** `Created Ticket`

- **Error Response:**

  - **Code:** 404 NOT_FOUND <br />
    **Content:** `None`

- **Sample Body:**

- **GET**

```
{
   "ticketId": 1,
   "event": {},
   "ticketType": {},
   "saleEvent": {},
   "barcode": "16980692908420002"
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
   "barcode": "16980692908420002"
}
```
