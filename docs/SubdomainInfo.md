

# SubdomainInfo

Detailed information about a discovered subdomain

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**subdomain** | **String** | The full subdomain name |  |
|**ipAddresses** | **List&lt;String&gt;** | IP addresses associated with the subdomain |  [optional] |
|**firstSeen** | **OffsetDateTime** | First time this subdomain was observed |  [optional] |
|**lastSeen** | **OffsetDateTime** | Last time this subdomain was observed |  [optional] |
|**recordType** | [**RecordTypeEnum**](#RecordTypeEnum) | Type of subdomain record |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Current status of the subdomain |  [optional] |
|**technologies** | **List&lt;String&gt;** | Technology stack detected on this subdomain |  [optional] |
|**riskScore** | **Integer** | Risk score for this subdomain (0-100) |  [optional] |



## Enum: RecordTypeEnum

| Name | Value |
|---- | -----|
| A | &quot;A&quot; |
| AAAA | &quot;AAAA&quot; |
| CNAME | &quot;CNAME&quot; |
| MX | &quot;MX&quot; |
| TXT | &quot;TXT&quot; |
| NS | &quot;NS&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;active&quot; |
| INACTIVE | &quot;inactive&quot; |
| PARKED | &quot;parked&quot; |



