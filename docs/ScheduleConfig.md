

# ScheduleConfig

Configuration for scheduling recurring screenshot captures

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cron** | **String** | Cron expression for scheduling |  [optional] |
|**frequency** | [**FrequencyEnum**](#FrequencyEnum) | Frequency of captures |  [optional] |
|**timezone** | **String** | Timezone for scheduled captures |  [optional] |
|**retentionCount** | **Integer** | Maximum number of captures to retain |  [optional] |
|**enabled** | **Boolean** | Enable/disable the schedule |  [optional] |



## Enum: FrequencyEnum

| Name | Value |
|---- | -----|
| HOURLY | &quot;hourly&quot; |
| DAILY | &quot;daily&quot; |
| WEEKLY | &quot;weekly&quot; |
| MONTHLY | &quot;monthly&quot; |



