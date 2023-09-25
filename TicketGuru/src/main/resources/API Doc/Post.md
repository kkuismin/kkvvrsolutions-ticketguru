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