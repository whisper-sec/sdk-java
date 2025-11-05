

# SummaryInfo

Executive summary with the most important facts for quick decision-making

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**organization** | **String** | Primary organization name |  [optional] |
|**location** | **String** | Primary location |  [optional] |
|**network** | **String** | Network range or CIDR |  [optional] |
|**registrar** | **String** | Domain registrar |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Domain status |  [optional] |
|**asnPrimary** | **String** | Primary ASN |  [optional] |
|**riskScore** | **Double** | Composite risk score (0-10, higher is riskier) |  [optional] |
|**ipType** | [**IpTypeEnum**](#IpTypeEnum) | IP classification |  [optional] |
|**totalDomains** | **Integer** | Total number of domains resolving to this IP |  [optional] |
|**domainName** | **String** | The domain name |  [optional] |
|**registrationDate** | **String** | Domain registration date |  [optional] |
|**expirationDate** | **String** | Domain expiration date |  [optional] |
|**dnsProvider** | **String** | Primary DNS provider |  [optional] |
|**totalLinksIn** | **Integer** | Number of incoming links/backlinks |  [optional] |
|**totalLinksOut** | **Integer** | Number of outgoing links |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;active&quot; |
| EXPIRED | &quot;expired&quot; |
| PENDING | &quot;pending&quot; |
| SUSPENDED | &quot;suspended&quot; |
| DELETED | &quot;deleted&quot; |



## Enum: IpTypeEnum

| Name | Value |
|---- | -----|
| RESIDENTIAL | &quot;residential&quot; |
| BUSINESS | &quot;business&quot; |
| DATACENTER | &quot;datacenter&quot; |
| HOSTING | &quot;hosting&quot; |
| VPN | &quot;vpn&quot; |
| PROXY | &quot;proxy&quot; |
| TOR | &quot;tor&quot; |
| MOBILE | &quot;mobile&quot; |



