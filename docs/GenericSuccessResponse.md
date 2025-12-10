

# GenericSuccessResponse

Generic success response for operations that don't return specific data

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) | Status of the operation |  [optional] |
|**message** | **String** | Human-readable message describing the operation result |  [optional] |
|**id** | **String** | ID of the related resource (if applicable) |  [optional] |
|**deleted** | **Boolean** | Whether the operation was successful (for delete operations) |  [optional] |
|**cleared** | **Boolean** | Whether the operation was successful (for clear operations) |  [optional] |
|**scheduleId** | **String** | Schedule ID (for schedule-related operations) |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| TRIGGERED | &quot;triggered&quot; |
| DELETED | &quot;deleted&quot; |
| CLEARED | &quot;cleared&quot; |
| SUCCESS | &quot;success&quot; |



