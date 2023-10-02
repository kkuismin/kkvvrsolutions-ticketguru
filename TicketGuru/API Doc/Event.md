# Get events

List every single event in the database.

**URL** : `/api/events`

**Method** : `GET`

**Authorization** : *NO*

**Permissions** : `NONE`

**Data** : `{}`

OR

List a singular event.

**URL** : `/api/events/{id}`

**Method** : `GET`

**Authorization** : *NO*

**Permissions** : `NONE`

**Data** : `{}`


## Success

**Condition** : Events are not empty.

**Code** : `200 OK`

**Content example**

```json
{
	"event_id": 1,
	"name": "Funny things!",
	"date": "September 6th",
	"time": "19:15"
}
```

## Error

**Condition** : No event entity exists within the database.

**Code** : `404 NOT FOUND`

**Content** : `{}`

## Notes

Not final. Proof of concept and the first iteration.

```

# Post an event

Post a singular event with its contents.

**URL** : `/api/events`

**Method** : `POST`

**Authorization** : *NO*

**Permissions** : `NONE`

**Data constraints**

Provide the name, date, and time of the event.

```json
{
	"name": "Hooplah!",
	"date": "July 3rd",
	"time": "19:15"
}
```

## Success

**Condition** : Correct json body sent. Empty or unmentioned fields will become null.

**Code** : `201 CREATED`

**Content example**

```json
{
	"event_id": 5,
	"name": "Hooplah!",
	"date": "July 3rd",
	"time": "19:15"
}
```

## Error

**Condition** : Faulty JSON body.

**Code** : `400 BAD REQUEST`

**Content** : `{}`

## Notes

Deletion currently has no real error outside of a faulty body composition. Fields can be null at the moment.

```

# Update an event.

Update the fields within an event.

**URL** : `/api/events/{id}`

**Method** : `POST`

**Authorization** : *NO*

**Permissions** : `NONE`

**Data constraints**

Provide the name, date, and time of the event.

```json
{
	"name": "Hooplah!",
	"date": "July 3rd",
	"time": "19:15"
}
```

## Success

**Condition** : Correct json body sent. Empty or unmentioned fields will become null.

**Code** : `201 CREATED`

**Content example**

```json
{
	"event_id": 5,
	"name": "Hooplah!",
	"date": "July 3rd",
	"time": "19:15"
}
```

## Error

**Condition** : Faulty JSON body.

**Code** : `400 BAD REQUEST`

**Content** : `{}`

## Notes

Same notes as deletion. PUT has no real error codes outside of a bad request at the moment. Fields can be null if left omitted.

```

# Delete an event

Delete a specific event or delete all events within the database.

**URL** : `/api/events`

**Method** : `DELETE`

**Authorization** : *NO*

**Permissions** : `NONE`

**Data** : `{}`

## Success

**Condition** : If the event exists for singular deletion, otherwise if any event exists for complete deletion.

**Code** : `204 NO CONTENT`

**Content** : `{}`

## Error

**Condition** : Event not found

**Code** : `404 NOT FOUND`

**Content** : `{}`

## Notes

No authorization or permissions implemented yet.