

# SearchRequest

Search query for finding domains matching WHOIS registration criteria.  **Query Modes:** 1. **Field-based (recommended):** Specify individual fields like `registrantCompany`, `tld`, etc. 2. **Query string:** Use `query` field with `field:value` syntax for compatibility.  Multiple criteria are combined with AND logic. Results are paginated with a maximum of 100 results per page.  **Use Cases:** - Threat hunting: Find domains registered by known malicious actors - Brand protection: Monitor for domains similar to your brand - Infrastructure discovery: Map domains sharing registrants or nameservers - Investigation: Track domains created on specific dates 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**effectivePage** | **Integer** |  |  [optional] |
|**query** | **String** | Search query using field:value syntax (alternative to individual field parameters). If individual field parameters are provided, they take precedence.  **Supported Syntax:** - Single field: &#x60;registrantCompany:Google&#x60; - Multiple fields: &#x60;registrantCompany:Google registrantCountry:US&#x60;  **Note:** For new integrations, prefer using individual field parameters instead of query syntax.  |  [optional] |
|**field** | [**FieldEnum**](#FieldEnum) | Field to search in when using simple query mode. Use with &#x60;query&#x60; parameter. |  [optional] |
|**tld** | **String** | Top-Level Domain to filter by (exact match). Examples: com, org, net, io |  [optional] |
|**registrarName** | **String** | Domain registrar name to filter by (exact match) |  [optional] |
|**registrarIanaId** | **String** | IANA registrar ID to filter by (exact match) |  [optional] |
|**registrantName** | **String** | Registrant name to search for (text search, partial match) |  [optional] |
|**registrantCompany** | **String** | Registrant company/organization to search for (text search, partial match) |  [optional] |
|**registrantEmail** | **String** | Registrant email to search for (text search). Supports wildcards like *@example.com |  [optional] |
|**registrantPhone** | **String** | Registrant phone number to search for (text search) |  [optional] |
|**registrantCountry** | **String** | Registrant country code to filter by (2-letter ISO code) |  [optional] |
|**registrantCity** | **String** | Registrant city to search for (text search) |  [optional] |
|**nameServer** | **String** | Name server hostname to search for (text search) |  [optional] |
|**domainStatus** | **String** | Domain status flag to search for (text search). E.g., clientTransferProhibited |  [optional] |
|**createdDate** | **String** | Domain creation date to filter by (exact match, format: YYYY-MM-DD) |  [optional] |
|**updatedDate** | **String** | Domain last update date to filter by (exact match, format: YYYY-MM-DD) |  [optional] |
|**expiryDate** | **String** | Domain expiry date to filter by (exact match, format: YYYY-MM-DD) |  [optional] |
|**limit** | **Integer** | Maximum number of results to return per page (max 100 for WHOIS searches) |  [optional] |
|**page** | **Integer** | Page number for pagination (0-indexed). Alternative to offset. |  [optional] |
|**offset** | **Integer** | Number of results to skip for pagination. Converted to page internally. |  [optional] |



## Enum: FieldEnum

| Name | Value |
|---- | -----|
| REGISTRANT_NAME | &quot;registrantName&quot; |
| REGISTRANT_COMPANY | &quot;registrantCompany&quot; |
| REGISTRANT_EMAIL | &quot;registrantEmail&quot; |
| REGISTRANT_PHONE | &quot;registrantPhone&quot; |
| REGISTRANT_COUNTRY | &quot;registrantCountry&quot; |
| REGISTRANT_CITY | &quot;registrantCity&quot; |
| NAME_SERVER | &quot;nameServer&quot; |
| REGISTRAR_NAME | &quot;registrarName&quot; |
| REGISTRAR_IANA_ID | &quot;registrarIanaId&quot; |
| TLD | &quot;tld&quot; |
| DOMAIN_STATUS | &quot;domainStatus&quot; |
| CREATED_DATE | &quot;createdDate&quot; |
| UPDATED_DATE | &quot;updatedDate&quot; |
| EXPIRY_DATE | &quot;expiryDate&quot; |



