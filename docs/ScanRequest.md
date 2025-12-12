

# ScanRequest

Request for initiating a domain infrastructure scan

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domain** | **String** | The target domain to scan |  |
|**type** | [**TypeEnum**](#TypeEnum) | Type of scan to perform. Determines which scanning module to use. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| COMPREHENSIVE | &quot;comprehensive&quot; |
| SUBDOMAINS | &quot;subdomains&quot; |
| SSL | &quot;ssl&quot; |
| DNS | &quot;dns&quot; |
| TECHNOLOGIES | &quot;technologies&quot; |
| WHOIS | &quot;whois&quot; |
| VULNERABILITY | &quot;vulnerability&quot; |



