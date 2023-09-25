# Event REST API Doc example

## Get all events

List every single event in the database.

**URL** : /api/events

**Method** : `GET`

**Auth** : *NO*

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