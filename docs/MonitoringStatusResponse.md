

# MonitoringStatusResponse

Monitoring status and metrics for a target domain or IP

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**target** | **String** | The target domain or IP being monitored |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Current monitoring status |  [optional] |
|**metrics** | [**MonitoringMetrics**](MonitoringMetrics.md) | Monitoring metrics and statistics |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;active&quot; |
| INACTIVE | &quot;inactive&quot; |
| ERROR | &quot;error&quot; |



