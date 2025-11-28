

# BulkRequest

Request payload for bulk enrichment of multiple IP addresses and domains

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicators** | **List&lt;String&gt;** | List of indicators (IP addresses or domains) to enrich. Mix of IPs and domains is supported. |  |
|**include** | [**Set&lt;IncludeEnum&gt;**](#Set&lt;IncludeEnum&gt;) | Additional data modules to include for each indicator. Same options as single indicator endpoint. |  [optional] |
|**options** | [**BulkOptions**](BulkOptions.md) |  |  [optional] |



## Enum: Set&lt;IncludeEnum&gt;

| Name | Value |
|---- | -----|
| ROUTING | &quot;routing&quot; |
| RPKI | &quot;rpki&quot; |
| WHOIS | &quot;whois&quot; |
| DNS_DETAILS | &quot;dns_details&quot; |
| IP_INTELLIGENCE | &quot;ip_intelligence&quot; |



