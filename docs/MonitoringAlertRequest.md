

# MonitoringAlertRequest

Configuration for creating monitoring alert rules with notification channels

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Type of alert condition to monitor |  |
|**thresholdDays** | **Integer** | Threshold in days (for ssl_expiring alerts). Alert triggers when SSL cert expires within this many days. |  [optional] |
|**channels** | **Set&lt;String&gt;** | Notification channels to use for alerts |  [optional] |
|**email** | **String** | Email address for alert notifications |  [optional] |
|**slackWebhook** | **String** | Slack webhook URL for notifications |  [optional] |
|**webhookUrl** | **String** | Custom webhook URL for notifications (will receive POST with alert data) |  [optional] |
|**pagerdutyKey** | **String** | PagerDuty integration key for incident creation |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| DOWNTIME | &quot;downtime&quot; |
| DNS_CHANGE | &quot;dns_change&quot; |
| WHOIS_CHANGE | &quot;whois_change&quot; |
| SSL_EXPIRING | &quot;ssl_expiring&quot; |
| CONTENT_CHANGE | &quot;content_change&quot; |
| TECHNOLOGY_CHANGE | &quot;technology_change&quot; |



