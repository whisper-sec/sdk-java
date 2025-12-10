

# TrackedIndicator

A tracked indicator with its configuration and status

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | Indicator type: ip or domain |  [optional] |
|**value** | **String** | Indicator value |  [optional] |
|**enabled** | **Boolean** | Whether tracking is currently enabled |  [optional] |
|**frequency** | **String** | Check frequency: hourly, daily, weekly |  [optional] |
|**fields** | **Set&lt;String&gt;** | Fields being tracked |  [optional] |
|**createdAt** | **OffsetDateTime** | When tracking was started |  [optional] |
|**lastCheckAt** | **OffsetDateTime** | When the last check was performed |  [optional] |
|**nextCheckAt** | **OffsetDateTime** | When the next check is scheduled |  [optional] |
|**totalChanges** | **Integer** | Total number of changes detected |  [optional] |



