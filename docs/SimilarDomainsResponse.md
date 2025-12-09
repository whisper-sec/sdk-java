

# SimilarDomainsResponse

Result returned when a similar domains job completes. Access this via GET /v1/ops/jobs/{jobId} after the job status becomes COMPLETED.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domain** | **String** | The input domain that was analyzed |  |
|**status** | [**StatusEnum**](#StatusEnum) | Job completion status |  |
|**similarDomains** | [**List&lt;SimilarDomainEntry&gt;**](SimilarDomainEntry.md) | List of similar domains found |  |
|**totalCount** | **Integer** | Total number of similar domains found |  |
|**analysis** | [**AnalysisMetadata**](AnalysisMetadata.md) | Analysis metadata about the search |  |
|**error** | **Boolean** | Error flag, present only when status is &#39;failed&#39; |  [optional] |
|**message** | **String** | Error message, present only when status is &#39;failed&#39; |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |



