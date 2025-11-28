

# MonitorDashboardResponse

Monitoring dashboard summary

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**totalChecks** | **Integer** | Total number of checks |  [optional] |
|**passingChecks** | **Integer** | Number of passing checks |  [optional] |
|**failingChecks** | **Integer** | Number of failing checks |  [optional] |
|**degradedChecks** | **Integer** | Number of degraded checks |  [optional] |
|**overallStatus** | [**OverallStatusEnum**](#OverallStatusEnum) | Overall status |  [optional] |
|**avgUptime24Hours** | **Double** | Average uptime percentage over the last 24 hours |  [optional] |
|**avgUptime7Days** | **Double** | Average uptime percentage over the last 7 days |  [optional] |
|**avgUptime30Days** | **Double** | Average uptime percentage over the last 30 days |  [optional] |
|**avgResponseTime** | **Long** | Average response time across all checks in milliseconds |  [optional] |
|**checksByType** | **Map&lt;String, Integer&gt;** | Count of checks by type |  [optional] |
|**checksByStatus** | **Map&lt;String, Integer&gt;** | Count of checks by status |  [optional] |
|**lastUpdated** | **OffsetDateTime** | When this dashboard data was last updated |  [optional] |



## Enum: OverallStatusEnum

| Name | Value |
|---- | -----|
| PASSING | &quot;passing&quot; |
| FAILING | &quot;failing&quot; |
| DEGRADED | &quot;degraded&quot; |



