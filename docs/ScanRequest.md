

# ScanRequest

Request for initiating a domain infrastructure scan

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domain** | **String** | The target domain to scan |  |
|**type** | [**TypeEnum**](#TypeEnum) | Type of scan to perform. Determines the depth and modules used in the scan. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| COMPREHENSIVE | &quot;comprehensive&quot; |
| SUBDOMAINS | &quot;subdomains&quot; |
| PORTS | &quot;ports&quot; |
| TECHNOLOGIES | &quot;technologies&quot; |
| VULNERABILITIES | &quot;vulnerabilities&quot; |
| SSL | &quot;ssl&quot; |
| DNS | &quot;dns&quot; |
| WHOIS | &quot;whois&quot; |



