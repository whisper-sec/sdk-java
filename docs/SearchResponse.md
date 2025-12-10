

# SearchResponse

Result returned when a WHOIS search job completes. Access this via GET /v1/ops/jobs/{jobId} after the job status becomes COMPLETED.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**source** | [**SourceEnum**](#SourceEnum) | The data source that was searched |  |
|**queryType** | [**QueryTypeEnum**](#QueryTypeEnum) | The type of query that was performed |  |
|**items** | [**List&lt;DomainItem&gt;**](DomainItem.md) | List of matching domains |  |
|**total** | **Integer** | Total number of matching records across all pages |  |
|**pageNumber** | **Integer** | Current page number (0-indexed) |  |
|**pageSize** | **Integer** | Number of results per page |  |
|**totalPages** | **Integer** | Total number of pages available |  |
|**error** | **Boolean** | Error flag, present only when the search failed |  [optional] |
|**message** | **String** | Error message, present only when the search failed |  [optional] |



## Enum: SourceEnum

| Name | Value |
|---- | -----|
| WHOIS | &quot;whois&quot; |
| DOMAINER | &quot;domainer&quot; |
| GEOGRAPH | &quot;geograph&quot; |



## Enum: QueryTypeEnum

| Name | Value |
|---- | -----|
| REGISTRATION_DATA | &quot;registration_data&quot; |
| DOMAIN_SEARCH | &quot;domain_search&quot; |
| LOCATION_SEARCH | &quot;location_search&quot; |



