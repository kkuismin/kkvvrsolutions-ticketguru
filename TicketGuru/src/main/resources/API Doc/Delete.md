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