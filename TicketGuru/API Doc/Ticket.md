# Ticket

* **URL**

  /api/tickets | /api/tickets/{ticketId}

* **Method:**

  * `GET` /tickets for all | /tickets/{ticketId} for single ticket
  * `POST` /tickets
  * `DELETE` /tickets/{ticketId}
  * `PUT` /tickets/{ticketId}

* **URL Params**

  * `ticketId`: id for Ticket entity, a primary key

* **Data Params**

  All columns in table are nullable, none are required
    * "barcode": String
    * "type": String

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `All Tickets or Ticket`

  * **Code** 201 <br />
    **Content:** `Created Ticket`
  
* **Error Response:**

  * **Code:** 404 NOT_FOUND <br />
    **Content:** `None`
  
* **Sample Body:**

* **GET**
```
{
    "ticketId": 1,
    "event": {}
    "barcode": "1234",
    "type": "adult"
}
```

* **POST**
```
{
    "ticketId": 1,
    "barcode": "1234",
    "type": "adult"
}
```