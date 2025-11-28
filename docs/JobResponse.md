

# JobResponse

Response returned when an asynchronous job is created. Contains the job ID and status URL for polling.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**jobId** | **String** | Unique identifier for the job. Use this ID to poll for job status and results. |  |
|**status** | [**StatusEnum**](#StatusEnum) | Current status of the job |  |
|**statusUrl** | **String** | URL endpoint to poll for job status and results. Typically &#x60;/v1/ops/jobs/{jobId}&#x60;. |  |
|**message** | **String** | Human-readable message describing the job acceptance or current state |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;PENDING&quot; |
| RUNNING | &quot;RUNNING&quot; |
| COMPLETED | &quot;COMPLETED&quot; |
| FAILED | &quot;FAILED&quot; |
| CANCELLED | &quot;CANCELLED&quot; |



