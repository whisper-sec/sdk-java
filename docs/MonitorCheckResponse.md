

# MonitorCheckResponse

Monitoring check details

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier for the check |  [optional] |
|**name** | **String** | Name of the monitoring check |  [optional] |
|**url** | **String** | URL being monitored |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of check |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Current status |  [optional] |
|**enabled** | **Boolean** | Whether the check is enabled |  [optional] |
|**frequency** | **Integer** | Check frequency in minutes |  [optional] |
|**locations** | **List&lt;String&gt;** | Locations where check runs |  [optional] |
|**muted** | **Boolean** | Whether the check is muted (no alerts) |  [optional] |
|**method** | **String** | HTTP method used for API checks |  [optional] |
|**assertions** | [**MonitorAssertions**](MonitorAssertions.md) | Assertions configured for this check |  [optional] |
|**lastRunAt** | **OffsetDateTime** | Last time the check ran |  [optional] |
|**createdAt** | **OffsetDateTime** | When the check was created |  [optional] |
|**updatedAt** | **OffsetDateTime** | When the check was last updated |  [optional] |
|**uptime24Hours** | **Double** | Uptime percentage over the last 24 hours |  [optional] |
|**uptime7Days** | **Double** | Uptime percentage over the last 7 days |  [optional] |
|**uptime30Days** | **Double** | Uptime percentage over the last 30 days |  [optional] |
|**responseTime** | **Long** | Average response time in milliseconds |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| API | &quot;api&quot; |
| SSL | &quot;ssl&quot; |
| DNS | &quot;dns&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PASSING | &quot;passing&quot; |
| FAILING | &quot;failing&quot; |
| DEGRADED | &quot;degraded&quot; |
| PENDING | &quot;pending&quot; |



