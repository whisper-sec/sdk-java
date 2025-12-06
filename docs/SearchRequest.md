

# SearchRequest

Search query for finding indicators matching specific criteria. Powerful for threat hunting and infrastructure discovery.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**query** | **String** | Search query using field:value syntax. Supports multiple fields combined with logical operators.  **Supported Fields:** - WHOIS: &#x60;registrantCompany&#x60;, &#x60;registrantName&#x60;, &#x60;registrantEmail&#x60;, &#x60;registrar&#x60; - Network: &#x60;asn&#x60;, &#x60;network&#x60;, &#x60;country_code&#x60;, &#x60;city&#x60; - Domain: &#x60;tld&#x60;, &#x60;domain_length&#x60;, &#x60;creation_date&#x60;  **Examples:** - &#x60;registrantCompany:EvilCorp&#x60; - Find domains by registrant - &#x60;asn:15169 AND country_code:US&#x60; - Complex query with AND - &#x60;registrantEmail:admin@example.com&#x60; - Find domains by email  |  |
|**field** | **String** | Specific field to search in. If provided, the query is interpreted as a value for this field. |  [optional] |
|**filters** | **Map&lt;String, String&gt;** | Additional filters to narrow down search results. Applied after query matching. |  [optional] |
|**limit** | **Integer** | Maximum number of results to return per page |  [optional] |
|**offset** | **Integer** | Number of results to skip for pagination. Use with limit for paginated results. |  [optional] |
|**sortBy** | [**SortByEnum**](#SortByEnum) | Field to sort results by |  [optional] |
|**sortOrder** | [**SortOrderEnum**](#SortOrderEnum) | Sort order |  [optional] |



## Enum: SortByEnum

| Name | Value |
|---- | -----|
| REGISTRATION_DATE | &quot;registration_date&quot; |
| EXPIRATION_DATE | &quot;expiration_date&quot; |
| RISK_SCORE | &quot;risk_score&quot; |
| DOMAIN_NAME | &quot;domain_name&quot; |
| ASN | &quot;asn&quot; |



## Enum: SortOrderEnum

| Name | Value |
|---- | -----|
| ASC | &quot;asc&quot; |
| DESC | &quot;desc&quot; |



