# Venue

* **URL**
  
  /api/venues
  
  /api/venues/{id}

* **Method:**

  `GET` /venues
  
  `GET` /venues/{id} 

  `POST` /venues

  `DELETE` /venues/{id}

  `PUT` /venues/{id}

*  **URL Params**

   `id` : id for Venue entity, a primary key

*  **Data Params**

   "name" : String

   "address" : String

   "city" : String

   "capacity" : int

*  **Success response**

   * **Code:** 200 <br />
     **Content:** `Venues or Venue`

   * **Code** 201 <br />
     **Content:** `Created Venue`
  
*  **Error Response:**

   * **Code:** 404 NOT_FOUND <br />
     **Content:** `None`

* **Sample Body:**

* **GET**
```
{
    "id": 1,
    "name": "Nokia Arena"
    "address": "Kansikatu 3",
    "city": "Tampere"
    "capacity": "15000"
}
```

* **POST**
```
{
    "name": "Nokia Arena"
    "address": "Kansikatu 3",
    "city": "Tampere"
    "capacity": "15000"
}
```
