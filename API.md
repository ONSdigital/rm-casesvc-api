# Case Service API
This page documents the Case service API endpoints. These endpoints will be secured using HTTP basic authentication initially. All endpoints return an `HTTP 200 OK` status code except where noted otherwise.

## Case Events
For the endpoints that return the details of a case:

* `GET /cases/<case_id>`
* `GET /cases/partyid/<party_id>`
* `GET /cases/iac/<iac>`

&mdash;an optional `caseevents` boolean query parameter can be used to specify that the JSON response include an array of case events associated with the case. For example:

* `GET /cases/partyid/3b136c4b-7a14-4904-9e01-13364dd7b972?caseevents=true`

If this query parameter is omitted these case events **will not** be returned with the case details. In this scenario case events for a case can be retrieved separately using the `GET /cases/<case_id>/events` endpoint. The JSON examples provided for the three endpoints mentioned above include the case events for illustration purposes.

## Get Case Group
* `GET /casegroups/9a5f2be5-f944-41f9-982c-3517cfcfef3c` will return the details of the case group with an ID of `9a5f2be5-f944-41f9-982c-3517cfcfef3c`.

### Example JSON Response
```json
{
  "id": "9a5f2be5-f944-41f9-982c-3517cfcfef3c",
  "collectionExerciseID": "dab9db7f-3aa0-4866-be20-54d72ee185fb",
  "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
  "sampleUnitRef": "0123456789",
  "sampleUnitType": "B"
}
```

An `HTTP 404 Not Found` status code is returned if the case group with the specified ID could not be found.

## List Cases for Case Group
* `GET /cases/casegroupid/9a5f2be5-f944-41f9-982c-3517cfcfef3c` will return a list of cases for the case group with an ID of `9a5f2be5-f944-41f9-982c-3517cfcfef3c`.

### Example JSON Response
```json
[
  {
    "id": "7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb",
    "caseGroupID": "9a5f2be5-f944-41f9-982c-3517cfcfef3c",
    "collectionInstrumentID": "40c7c047-4fb3-4abe-926e-bf19fa2c0a1e",
    "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
    "actionPlanID": "5381731e-e386-41a1-8462-26373744db86",
    "sampleUnitType": "BI",
    "state": "INACTIONABLE",
    "createdBy": "SYSTEM",
    "createdDateTime": "2017-05-15T10:00:00Z",
    "responses": [
      {
        "inboundChannel": "ONLINE",
        "dateTime": "2017-05-17T16:15:20Z"
      }
    ]
  }
]
```

An `HTTP 404 Not Found` status code is returned if the case group with the specified ID could not be found.

## Get Case
* `GET /cases/7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb` will return the details of the case with an ID of `7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb`.

### Example JSON Response
```json
{
  "caseGroup": {
    "id": "9a5f2be5-f944-41f9-982c-3517cfcfef3c",
    "collectionExerciseID": "dab9db7f-3aa0-4866-be20-54d72ee185fb",
    "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
    "sampleUnitRef": "0123456789",
    "sampleUnitType": "B",
  },
  "case": {
    "id": "7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb",
    "collectionInstrumentID": "40c7c047-4fb3-4abe-926e-bf19fa2c0a1e",
    "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
    "actionPlanID": "5381731e-e386-41a1-8462-26373744db86",
    "sampleUnitType": "BI",
    "state": "INACTIONABLE",
    "createdBy": "SYSTEM",
    "createdDateTime": "2017-05-15T10:00:00Z",
    "responses": [
      {
        "inboundChannel": "ONLINE",
        "dateTime": "2017-05-17T16:15:20Z"
      }
    ]
  },
  "caseEvents": [
    {
      "description": "Initial creation of case",
      "category": "CASE_CREATED",
      "subCategory": null,
      "createdBy": "SYSTEM",
      "createdDateTime": "2017-02-22T14:16:50Z"
    },
    {
      "description": "Create Household Visit",
      "category": "ACTION_CREATED",
      "subCategory": "HouseholdCreateVisit",
      "createdBy": "SYSTEM",
      "createdDateTime": "2017-04-10T08:48:49Z"    
    }
  ]
}
```

An `HTTP 404 Not Found` status code is returned if the case with the specified ID could not be found.

## Get Case by Party
* `GET /cases/partyid/3b136c4b-7a14-4904-9e01-13364dd7b972` will return the details of the case with a party ID of `3b136c4b-7a14-4904-9e01-13364dd7b972`.

### Example JSON Response
```json
{
  "caseGroup": {
    "id": "9a5f2be5-f944-41f9-982c-3517cfcfef3c",
    "collectionExerciseID": "dab9db7f-3aa0-4866-be20-54d72ee185fb",
    "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
    "sampleUnitRef": "0123456789",
    "sampleUnitType": "B",
  },
  "case": {
    "id": "7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb",
    "collectionInstrumentID": "40c7c047-4fb3-4abe-926e-bf19fa2c0a1e",
    "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
    "actionPlanID": "5381731e-e386-41a1-8462-26373744db86",
    "sampleUnitType": "BI",
    "state": "INACTIONABLE",
    "createdBy": "SYSTEM",
    "createdDateTime": "2017-05-15T10:00:00Z",
    "responses": [
      {
        "inboundChannel": "ONLINE",
        "dateTime": "2017-05-17T16:15:20Z"
      }
    ]
  },
  "caseEvents": [
    {
      "description": "Initial creation of case",
      "category": "CASE_CREATED",
      "subCategory": null,
      "createdBy": "SYSTEM",
      "createdDateTime": "2017-02-22T14:16:50Z"
    },
    {
      "description": "Create Household Visit",
      "category": "ACTION_CREATED",
      "subCategory": "HouseholdCreateVisit",
      "createdBy": "SYSTEM",
      "createdDateTime": "2017-04-10T08:48:49Z"    
    }
  ]
}
```

An `HTTP 404 Not Found` status code is returned if the case with the specified party ID could not be found.

## Get Case by Unique Access Code
* `GET /cases/iac/fb747cq725lj` will return the details of the case with a unique access code of `fb747cq725lj`.

### Example JSON Response
```json
{
  "caseGroup": {
    "id": "9a5f2be5-f944-41f9-982c-3517cfcfef3c",
    "collectionExerciseID": "dab9db7f-3aa0-4866-be20-54d72ee185fb",
    "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
    "sampleUnitRef": "0123456789",
    "sampleUnitType": "B",
  },
  "case": {
    "id": "7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb",
    "collectionInstrumentID": "40c7c047-4fb3-4abe-926e-bf19fa2c0a1e",
    "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
    "actionPlanID": "5381731e-e386-41a1-8462-26373744db86",
    "sampleUnitType": "BI",
    "state": "INACTIONABLE",
    "createdBy": "SYSTEM",
    "createdDateTime": "2017-05-15T10:00:00Z",
    "responses": [
      {
        "inboundChannel": "ONLINE",
        "dateTime": "2017-05-17T16:15:20Z"
      }
    ]
  },
  "caseEvents": [
    {
      "description": "Initial creation of case",
      "category": "CASE_CREATED",
      "subCategory": null,
      "createdBy": "SYSTEM",
      "createdDateTime": "2017-02-22T14:16:50Z"
    },
    {
      "description": "Create Household Visit",
      "category": "ACTION_CREATED",
      "subCategory": "HouseholdCreateVisit",
      "createdBy": "SYSTEM",
      "createdDateTime": "2017-04-10T08:48:49Z"    
    }
  ]
}
```

An `HTTP 404 Not Found` status code is returned if the case with the specified unique access code could not be found.

## List Case Events for Case
* `GET /cases/7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb/events` will return a list of case events for the case with an ID of `7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb`.

### Example JSON Response
```json
[
  {
    "description": "Initial creation of case",
    "category": "CASE_CREATED",
    "subCategory": null,
    "createdBy": "SYSTEM",
    "createdDateTime": "2017-02-22T14:16:50Z"
  },
  {
    "description": "Create Household Visit",
    "category": "ACTION_CREATED",
    "subCategory": "HouseholdCreateVisit",
    "createdBy": "SYSTEM",
    "createdDateTime": "2017-04-10T08:48:49Z"    
  }
]
```

An `HTTP 404 Not Found` status code is returned if the case with the specified ID could not be found. An `HTTP 204 No Content` status code is returned if there are no case events for the case with the specified ID.

## Create Case Event
* `POST /cases/7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb/events` will create a case event for the case with an ID of `7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb`.

**Required parameters:** `description` as the description of the case event, `category` as the category of the case event and `createdBy` as the creator of the case event.

*Optional parameters:* `subCategory` as additional free text to describe the case event, `partyID` as the ID of the party to create a new case for, as a side effect of a case creation event.


### Example JSON Request
```json
{
  "description": "Initial creation of case",
  "category": "CASE_CREATED",
  "subCategory": null,
  "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
  "createdBy": "Fred Bloggs"
}
```

### Example JSON Response
```json
{
  "caseID": "7bc5d41b-0549-40b3-ba76-42f6d4cf3fdb",
  "description": "Initial creation of case",
  "category": "CASE_CREATED",
  "subCategory": null,
  "partyID": "3b136c4b-7a14-4904-9e01-13364dd7b972",
  "createdBy": "Fred Bloggs",
  "createdDateTime": "2017-04-10T08:48:49Z"  
}
```

An `HTTP 201 Created` status code is returned if the case event creation was a success. An `HTTP 404 Not Found` status code is returned if the case with the specified ID could not be found. An `HTTP 400 Bad Request` is returned if any of the required parameters are missing.

## List Categories
* `GET /categories` will return a list of categories available when creating a case event.

 ### Example JSON Response
```json
[
  {
    "name": "CASE_CREATED",
    "shortDescription": "Case Created",
    "longDescription": "Case Created",
    "manual": false,
    "role": null,
    "group": null
  },
  {
    "name": "GENERAL_ENQUIRY",
    "shortDescription": "General Enquiry",
    "longDescription": "General Enquiry",
    "manual": true,
    "role": "collect-csos, collect-admins",
    "group": "general"
  }
]
```

An `HTTP 204 No Content` status code is returned if there are no available categories.

## Get Category
* `GET /categories/name/case_created` will return the details of the category with the name `case_created`.

### Example JSON Response
```json
{
  "name": "CASE_CREATED",
  "shortDescription": "Case Created",
  "longDescription": "Case Created",
  "manual": false,
  "role": null,
  "group": null
}
```

An `HTTP 404 Not Found` status code is returned if the category with the specified name could not be found.