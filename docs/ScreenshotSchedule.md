

# ScreenshotSchedule

A scheduled screenshot configuration

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier for this schedule |  [optional] |
|**url** | **String** | The URL to capture screenshots of |  [optional] |
|**username** | **String** | Username/API key owner of this schedule |  [optional] |
|**cron** | **String** | Cron expression for scheduling (mutually exclusive with frequency) |  [optional] |
|**frequency** | [**FrequencyEnum**](#FrequencyEnum) | Frequency preset (mutually exclusive with cron). Use one of the preset values for simplified scheduling. |  [optional] |
|**timezone** | **String** | Timezone for the schedule |  [optional] |
|**enabled** | **Boolean** | Whether this schedule is currently active |  [optional] |
|**options** | [**ScreenshotOptions**](ScreenshotOptions.md) | Screenshot options (width, height, format, etc.) |  [optional] |
|**createdAt** | **OffsetDateTime** | When this schedule was created |  [optional] |
|**updatedAt** | **OffsetDateTime** | When this schedule was last updated |  [optional] |
|**lastCaptureAt** | **OffsetDateTime** | When the last screenshot was captured |  [optional] |
|**nextCaptureAt** | **OffsetDateTime** | When the next screenshot is scheduled |  [optional] |
|**captureCount** | **Integer** | Total number of screenshots captured by this schedule |  [optional] |



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



