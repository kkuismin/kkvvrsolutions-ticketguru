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