

# BulkEnrichmentResult

Result of a bulk indicator enrichment job. Contains enriched data for all successfully processed indicators.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) | Status of the bulk enrichment |  [optional] |
|**results** | **List&lt;Object&gt;** | Array of successfully enriched indicator results. Each item contains: - &#x60;indicator&#x60;: The original indicator value (e.g., \&quot;8.8.8.8\&quot; or \&quot;google.com\&quot;) - &#x60;type&#x60;: \&quot;ip\&quot; or \&quot;domain\&quot; - &#x60;query&#x60;: Request metadata with type, value, timestamp, and response_time_ms - &#x60;summary&#x60;: Key information summary (organization, location, ASN, risk_score, etc.)  For IP indicators: - &#x60;geolocation&#x60;: Country, city, coordinates, ISP details - &#x60;network&#x60;: BGP routing data if requested (visibility, origins, prefix info) - &#x60;isp&#x60;: ISP name, organization, ASN - &#x60;reputation&#x60;: Risk score and blacklist scores - &#x60;relationships&#x60;: Related domains and shared infrastructure  For domain indicators: - &#x60;registration&#x60;: WHOIS data (registrar, dates, nameservers, status, registrant info) - &#x60;dns&#x60;: DNS records (A, AAAA, MX, NS, TXT, CNAME) - &#x60;reputation&#x60;: Domain reputation with infrastructure scores - &#x60;relationships&#x60;: Related domains, incoming/outgoing links  |  [optional] |
|**errors** | **List&lt;Object&gt;** | Array of failed enrichment attempts. Each item contains: - &#x60;indicator&#x60;: The indicator that failed enrichment - &#x60;type&#x60;: \&quot;ip\&quot; or \&quot;domain\&quot; - &#x60;error&#x60;: true (boolean flag indicating this is an error entry) - &#x60;message&#x60;: Human-readable error description (e.g., \&quot;Timeout or error during enrichment\&quot;)  |  [optional] |
|**totalProcessed** | **Integer** | Total number of indicators processed |  [optional] |
|**totalFailed** | **Integer** | Total number of failed enrichments |  [optional] |
|**totalIndicators** | **Integer** | Total number of indicators in the request |  [optional] |
|**successRate** | **Double** | Percentage of successful enrichments |  [optional] |
|**message** | **String** | Error message if the entire job failed |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |



