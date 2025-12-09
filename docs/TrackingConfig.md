

# TrackingConfig

Change tracking configuration for an indicator

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**enabled** | **Boolean** | Whether tracking is currently enabled |  [optional] |
|**fields** | **List&lt;String&gt;** | Fields being tracked for changes |  [optional] |
|**frequency** | **String** | Check frequency: hourly, daily, or weekly |  [optional] |
|**createdAt** | **OffsetDateTime** | When tracking was first started |  [optional] |
|**lastCheck** | **OffsetDateTime** | When the last check was performed |  [optional] |
|**nextCheck** | **OffsetDateTime** | When the next check is scheduled |  [optional] |
|**username** | **String** | Username of the owner |  [optional] |
|**type** | **String** | Indicator type: ip or domain |  [optional] |
|**value** | **String** | Indicator value |  [optional] |



