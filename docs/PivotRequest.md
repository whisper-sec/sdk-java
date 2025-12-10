

# PivotRequest

Request for intelligent infrastructure pivoting and relationship discovery

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicator** | **String** | Starting indicator (IP address, domain, or hash) for pivot analysis |  |
|**indicatorType** | [**IndicatorTypeEnum**](#IndicatorTypeEnum) | Type of the starting indicator. Must be one of: ip, domain, hash |  |
|**depth** | **Integer** | Pivot depth - how many hops to traverse from the starting indicator. Higher depth &#x3D; more results but longer processing time. |  [optional] |
|**strategies** | **List&lt;String&gt;** | Pivot strategies to use. Possible values: dns (DNS relationships), whois (WHOIS data), ssl (SSL certificates), infrastructure (hosting), passive_dns (historical DNS) |  [optional] |
|**maxNodes** | **Integer** | Maximum number of related nodes/indicators to discover. Limits result size for performance. |  [optional] |



## Enum: IndicatorTypeEnum

| Name | Value |
|---- | -----|
| IP | &quot;ip&quot; |
| DOMAIN | &quot;domain&quot; |
| HASH | &quot;hash&quot; |



