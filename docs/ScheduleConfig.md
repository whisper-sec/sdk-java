

# ScheduleConfig

Configuration for scheduling recurring screenshot captures

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cron** | **String** | Cron expression for scheduling |  [optional] |
|**frequency** | [**FrequencyEnum**](#FrequencyEnum) | Frequency of captures. Use one of the preset values or provide a cron expression for custom schedules. |  [optional] |
|**timezone** | **String** | Timezone for scheduled captures |  [optional] |
|**retentionCount** | **Integer** | Maximum number of captures to retain |  [optional] |
|**enabled** | **Boolean** | Enable/disable the schedule |  [optional] |



## Enum: FrequencyEnum

| Name | Value |
|---- | -----|
| HOURLY | &quot;hourly&quot; |
| EVERY_6_HOURS | &quot;every_6_hours&quot; |
| EVERY_12_HOURS | &quot;every_12_hours&quot; |
| TWICE_DAILY | &quot;twice_daily&quot; |
| DAILY | &quot;daily&quot; |
| WEEKLY | &quot;weekly&quot; |
| MONTHLY | &quot;monthly&quot; |



