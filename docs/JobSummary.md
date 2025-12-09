

# JobSummary

Summary of a job

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**jobId** | **String** | Unique job identifier |  [optional] |
|**type** | **String** | Type of job |  [optional] |
|**status** | **String** | Current job status |  [optional] |
|**createdAt** | **String** | Job creation timestamp |  [optional] |
|**completedAt** | **String** | Job completion timestamp (if completed) |  [optional] |
|**progress** | [**ProgressInfo**](ProgressInfo.md) | Job progress information |  [optional] |
|**error** | [**ErrorInfo**](ErrorInfo.md) | Error information (if failed) |  [optional] |



