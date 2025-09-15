

# DomainerAsyncResultDTO

Results and status information for an asynchronous domain search request (similarity or free-text)

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**requestId** | **UUID** | Unique identifier for the request |  [readonly] |
|**domainName** | **String** | Domain name that was searched |  [optional] [readonly] |
|**similarityType** | **DomainerSimilarityType** |  |  [optional] |
|**queryString** | **String** | Query string used for the search (only for SEARCH requests) |  [optional] [readonly] |
|**operator** | [**OperatorEnum**](#OperatorEnum) | Default operator used between query terms (only for SEARCH requests) |  [optional] [readonly] |
|**level** | [**LevelEnum**](#LevelEnum) | Absolute domain level filter applied (only for SEARCH requests) |  [optional] [readonly] |
|**limit** | **Integer** | Maximum number of results requested |  [readonly] |
|**createdAt** | **OffsetDateTime** | Time when the request was created |  [readonly] |
|**completedAt** | **OffsetDateTime** | Time when the request was completed (null if still processing) |  [optional] [readonly] |
|**status** | [**StatusEnum**](#StatusEnum) | Request status |  [readonly] |
|**results** | **List&lt;String&gt;** | List of similar domains found (null if still processing) |  [optional] [readonly] |
|**resultCount** | **Integer** | Total number of results found |  [optional] [readonly] |
|**processingTimeMs** | **Long** | Time taken to process the request in milliseconds (-1 if still processing) |  [optional] [readonly] |



## Enum: OperatorEnum

| Name | Value |
|---- | -----|
| AND | &quot;AND&quot; |
| OR | &quot;OR&quot; |



## Enum: LevelEnum

| Name | Value |
|---- | -----|
| ALL | &quot;ALL&quot; |
| IMMEDIATE | &quot;IMMEDIATE&quot; |
| MAX_DEPTH | &quot;MAX_DEPTH&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;PROCESSING&quot; |
| COMPLETED | &quot;COMPLETED&quot; |



