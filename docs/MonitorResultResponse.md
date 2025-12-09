

# MonitorResultResponse

Result of a single check execution

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timestamp** | **OffsetDateTime** | When the check was executed |  [optional] |
|**success** | **Boolean** | Whether the check passed |  [optional] |
|**location** | **String** | Location where check ran |  [optional] |
|**attempt** | **Integer** | Check attempt number (for retries) |  [optional] |
|**checkId** | **String** | ID of the check this result belongs to |  [optional] |
|**resultId** | **String** | Unique result ID |  [optional] |
|**responseTime** | **Long** | Response time in milliseconds |  [optional] |
|**statusCode** | **Integer** | HTTP status code received |  [optional] |
|**errorMessage** | **String** | Error message if check failed |  [optional] |
|**hasErrors** | **Boolean** | Whether check ran from all locations |  [optional] |



