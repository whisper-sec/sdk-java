

# ChangeTrackingRequest

Request to start or update change tracking for an indicator

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fields** | **List&lt;String&gt;** | Fields to track for changes. Valid values depend on indicator type. |  [optional] |
|**frequency** | [**FrequencyEnum**](#FrequencyEnum) | How often to check for changes |  [optional] |
|**enabled** | **Boolean** | Whether tracking is enabled |  [optional] |



## Enum: FrequencyEnum

| Name | Value |
|---- | -----|
| HOURLY | &quot;hourly&quot; |
| DAILY | &quot;daily&quot; |
| WEEKLY | &quot;weekly&quot; |



