

# MonitorAssertions

Assertions to validate check results

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**headers** | **Map&lt;String, String&gt;** | Expected response headers |  [optional] |
|**statusCode** | **Integer** | Expected HTTP status code |  [optional] |
|**maxResponseTime** | **Long** | Maximum response time in milliseconds |  [optional] |
|**containsText** | **String** | Text that must be present in response body |  [optional] |
|**notContainsText** | **String** | Text that must NOT be present in response body |  [optional] |
|**sslDaysUntilExpiry** | **Integer** | Minimum SSL certificate days until expiry (for ssl checks) |  [optional] |
|**dnsRecordValue** | **String** | Expected DNS record value (for dns checks) |  [optional] |
|**dnsRecordType** | [**DnsRecordTypeEnum**](#DnsRecordTypeEnum) | DNS record type (for dns checks) |  [optional] |



## Enum: DnsRecordTypeEnum

| Name | Value |
|---- | -----|
| A | &quot;A&quot; |
| AAAA | &quot;AAAA&quot; |
| CNAME | &quot;CNAME&quot; |
| MX | &quot;MX&quot; |
| TXT | &quot;TXT&quot; |
| NS | &quot;NS&quot; |



