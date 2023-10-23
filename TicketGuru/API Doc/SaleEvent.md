## **SaleEvent**

- **URL**

  /api/sales | /api/sales/{saleEventId}

- **Method:**

  `GET` /sales for all | /sales/{saleEventId} for single sale

  `POST` /sales

  `DELETE` /sales/{saleEventId}

  `PUT` /sales/{saleEventId}

- **URL Params**

  `saleEventId`: id for SaleEvent entity, a primary key

- **Data Params**

  All columns in table are nullable, none are required
  "date": LocalDate
  "time": LocalTime
  "amount": double

- **Success Response:**

  - **Code:** 200 <br />
    **Content:** `All SaleEvents or SaleEvent`

    **Code:** 201 <br />
    **Content:** `Created SaleEvent`

- **Error Response:**

  - **Code:** 404 NOT_FOUND <br />
    **Content:** `None`

- **Sample Body:**

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
