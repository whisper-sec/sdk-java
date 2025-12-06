

# ErrorResponse

Standard error response returned when an API request fails

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | **Integer** | The HTTP status code of the error |  |
|**error** | **String** | A short, machine-readable error code |  |
|**message** | **String** | A human-readable error message providing more detail |  |
|**details** | **Object** | Additional details about the error, including field-specific validation errors |  [optional] |
|**timestamp** | **OffsetDateTime** | The timestamp when the error occurred |  |
|**traceId** | **String** | A unique trace ID for this request, useful for debugging |  [optional] |
|**path** | **String** | The API path that generated this error |  [optional] |



