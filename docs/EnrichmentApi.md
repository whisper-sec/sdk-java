# EnrichmentApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**bulkEnrichment**](EnrichmentApi.md#bulkEnrichment) | **POST** /v1/ops/enrichment/bulk | Bulk Indicator Enrichment (Asynchronous) |
| [**getIndicator**](EnrichmentApi.md#getIndicator) | **GET** /v1/indicators/{type}/{value} | Enrich a Single Indicator (IP or Domain) |
| [**getIndicatorGraph**](EnrichmentApi.md#getIndicatorGraph) | **GET** /v1/indicators/{type}/{value}/graph | Get Infrastructure Relationship Graph |
| [**getIndicatorHistory**](EnrichmentApi.md#getIndicatorHistory) | **GET** /v1/indicators/{type}/{value}/history | Get Historical Data for Indicator |
| [**getPredictiveRisk**](EnrichmentApi.md#getPredictiveRisk) | **GET** /v1/indicators/{type}/{value}/predictive-risk | Get AI Predictive Risk Score |
| [**getSubdomains**](EnrichmentApi.md#getSubdomains) | **GET** /v1/indicators/domain/{domain}/subdomains | Get Domain Subdomains |
| [**searchIndicators**](EnrichmentApi.md#searchIndicators) | **POST** /v1/ops/enrichment/search | Search WHOIS and Geolocation Records (Asynchronous) |
| [**similarDomains**](EnrichmentApi.md#similarDomains) | **POST** /v1/ops/enrichment/similar-domains | Find Similar Domains (Asynchronous) |



## bulkEnrichment

> BulkEnrichmentResult bulkEnrichment(bulkRequest)

Bulk Indicator Enrichment (Asynchronous)

&lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt;  &lt;h4&gt;Performance&lt;/h4&gt; &lt;p&gt;Processing time depends on batch size and indicator types. IP enrichment is faster than domain enrichment.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPs only:&lt;/b&gt; 2-10 seconds for typical batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Domains only:&lt;/b&gt; 10-30 seconds (WHOIS lookups are slower)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Mixed:&lt;/b&gt; 5-30 seconds depending on ratio&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Rate Limits&lt;/h4&gt; &lt;p&gt;Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt;  &lt;h4&gt;Response Structure&lt;/h4&gt; &lt;p&gt;When the job completes, the &lt;code&gt;result&lt;/code&gt; field contains:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;status&lt;/code&gt;: \&quot;completed\&quot; or \&quot;failed\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of enriched indicator objects (see below)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;errors&lt;/code&gt;: Array of failed enrichments with error details&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalProcessed&lt;/code&gt;: Number of indicators processed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalFailed&lt;/code&gt;: Number of failed enrichments&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalIndicators&lt;/code&gt;: Total indicators in request&lt;/li&gt;     &lt;li&gt;&lt;code&gt;successRate&lt;/code&gt;: Percentage of successful enrichments (0-100)&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Result Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;results&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The original indicator value&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;query&lt;/code&gt;: Request metadata (type, value, timestamp, response_time_ms)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;summary&lt;/code&gt;: Key information summary&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For IP indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;geolocation&lt;/code&gt;: Country, city, coordinates, ISP, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;network&lt;/code&gt;: BGP routing data, prefix visibility, origins&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: ISP name, organization, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Risk score, blacklist scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, shared infrastructure&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For domain indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;registration&lt;/code&gt;: WHOIS data (registrar, dates, nameservers, status)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;dns&lt;/code&gt;: DNS records (A, AAAA, MX, NS, TXT, CNAME)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Domain reputation, infrastructure scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, incoming/outgoing links&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Error Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;errors&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The indicator that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: true&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.EnrichmentApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        EnrichmentApi apiInstance = new EnrichmentApi(defaultClient);
        BulkRequest bulkRequest = new BulkRequest(); // BulkRequest | List of indicators and processing options.
        try {
            BulkEnrichmentResult result = apiInstance.bulkEnrichment(bulkRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnrichmentApi#bulkEnrichment");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **bulkRequest** | [**BulkRequest**](BulkRequest.md)| List of indicators and processing options. | |

### Return type

[**BulkEnrichmentResult**](BulkEnrichmentResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Bulk job successfully accepted for processing. Poll GET /v1/ops/jobs/{jobId} for results. |  -  |
| **200** | Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes). See endpoint description for detailed result structure. |  -  |
| **400** | Invalid request. Empty indicator list or exceeds 100 indicator limit. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **429** | Rate limit exceeded for bulk operations. |  -  |


## getIndicator

> IndicatorResponse getIndicator(type, value, include)

Enrich a Single Indicator (IP or Domain)

&lt;p&gt;Retrieves comprehensive intelligence for a single IP address or domain. This is the primary, high-performance endpoint for synchronous enrichment.&lt;/p&gt; &lt;p&gt;It aggregates data from multiple sources, including geolocation, WHOIS, DNS, reputation scoring, and relationship mapping. Use the &#x60;include&#x60; parameter to request additional, deeper data sets that may have higher latency.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Base Response:&lt;/b&gt; Typically under 500ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;routing&#x60;:&lt;/b&gt; First request may take up to 5 seconds; subsequent requests are cached for 5 minutes and respond in &amp;lt;200ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;ip_intelligence&#x60;:&lt;/b&gt; Adds 200-500ms of latency for each IP address resolved from the domain.&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.EnrichmentApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        EnrichmentApi apiInstance = new EnrichmentApi(defaultClient);
        String type = "ip"; // String | The type of indicator to enrich.
        String value = "8.8.8.8"; // String | The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
        String include = "routing"; // String | A comma-separated list of additional data modules to include in the response. Note: WHOIS and DNS data are included by default for domains. Requesting more modules may increase latency.
        try {
            IndicatorResponse result = apiInstance.getIndicator(type, value, include);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnrichmentApi#getIndicator");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | **String**| The type of indicator to enrich. | [enum: ip, domain] |
| **value** | **String**| The value of the indicator (e.g., an IPv4/IPv6 address or a domain name). | |
| **include** | **String**| A comma-separated list of additional data modules to include in the response. Note: WHOIS and DNS data are included by default for domains. Requesting more modules may increase latency. | [optional] [enum: routing, rpki, ip_intelligence] |

### Return type

[**IndicatorResponse**](IndicatorResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved intelligence data. |  -  |
| **400** | Invalid indicator format or unsupported type. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | The requested indicator was not found in our datasets. |  -  |
| **429** | Rate limit exceeded. |  -  |


## getIndicatorGraph

> GraphResponse getIndicatorGraph(type, value, limit)

Get Infrastructure Relationship Graph

&lt;p&gt;Returns graph visualization data showing relationships between the indicator and related infrastructure. Perfect for interactive network diagrams and threat actor infrastructure mapping.&lt;/p&gt; &lt;h4&gt;Relationship Types Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;For Domains:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Resolves to IPs&lt;/li&gt;             &lt;li&gt;Shares nameservers with&lt;/li&gt;             &lt;li&gt;Same SSL certificate as&lt;/li&gt;             &lt;li&gt;Same registrant as&lt;/li&gt;             &lt;li&gt;Links to/from other domains&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt;     &lt;li&gt;&lt;b&gt;For IPs:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Hosts domains&lt;/li&gt;             &lt;li&gt;Same ASN as&lt;/li&gt;             &lt;li&gt;Same network block as&lt;/li&gt;             &lt;li&gt;Connected via routing&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Compatible with react-force-graph, vis.js, cytoscape.js:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;nodes\&quot;: [     {\&quot;id\&quot;: \&quot;example.com\&quot;, \&quot;type\&quot;: \&quot;domain\&quot;, \&quot;label\&quot;: \&quot;example.com\&quot;},     {\&quot;id\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;ip\&quot;, \&quot;label\&quot;: \&quot;8.8.8.8\&quot;}   ],   \&quot;links\&quot;: [     {\&quot;source\&quot;: \&quot;example.com\&quot;, \&quot;target\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;resolves_to\&quot;}   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Response Time: 500ms-2s depending on graph complexity&lt;/li&gt;     &lt;li&gt;Default: 100 nodes maximum (adjustable)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Interactive threat actor infrastructure visualization&lt;/li&gt;     &lt;li&gt;Discovering related phishing campaigns&lt;/li&gt;     &lt;li&gt;Mapping shadow IT and sprawl&lt;/li&gt;     &lt;li&gt;Network topology visualization&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.EnrichmentApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        EnrichmentApi apiInstance = new EnrichmentApi(defaultClient);
        String type = "ip"; // String | Type of indicator
        String value = "example.com"; // String | The indicator value (IP address or domain)
        Integer limit = 100; // Integer | Maximum number of nodes to return in the graph
        try {
            GraphResponse result = apiInstance.getIndicatorGraph(type, value, limit);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnrichmentApi#getIndicatorGraph");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | **String**| Type of indicator | [enum: ip, domain] |
| **value** | **String**| The indicator value (IP address or domain) | |
| **limit** | **Integer**| Maximum number of nodes to return in the graph | [optional] [default to 100] |

### Return type

[**GraphResponse**](GraphResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved graph data. Compatible with react-force-graph, vis.js, and cytoscape.js. |  -  |
| **400** | Invalid indicator type or limit parameter. Type must be &#39;ip&#39; or &#39;domain&#39;, limit must be 1-500. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Indicator not found or no relationships discovered. |  -  |


## getIndicatorHistory

> HistoryResponse getIndicatorHistory(type, value, historyType)

Get Historical Data for Indicator

&lt;p&gt;Retrieves time-series historical data for an IP address or domain. Track how infrastructure changes over time for threat intelligence and forensic analysis.&lt;/p&gt; &lt;h4&gt;History Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration history - registrant changes, expiration updates, transfers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing history - prefix announcements, ASN changes, route hijacks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS resolution history - IP address changes, nameserver updates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate history - cert replacements, CA changes, expiration events&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reputation:&lt;/b&gt; Risk score history - blacklist appearances, reputation changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Format:&lt;/h4&gt; &lt;p&gt;Timeline with dated snapshots showing what changed and when:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;history\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:00:00Z\&quot;,       \&quot;field\&quot;: \&quot;registrant_company\&quot;,       \&quot;old_value\&quot;: \&quot;Evil Corp\&quot;,       \&quot;new_value\&quot;: \&quot;Legitimate LLC\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Tracking domain ownership changes&lt;/li&gt;     &lt;li&gt;Investigating IP reputation degradation&lt;/li&gt;     &lt;li&gt;Forensic timeline reconstruction&lt;/li&gt;     &lt;li&gt;Detecting infrastructure pivots by threat actors&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.EnrichmentApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        EnrichmentApi apiInstance = new EnrichmentApi(defaultClient);
        String type = "ip"; // String | Type of indicator
        String value = "example.com"; // String | The indicator value (IP address or domain)
        String historyType = "whois"; // String | Type of historical data to retrieve
        try {
            HistoryResponse result = apiInstance.getIndicatorHistory(type, value, historyType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnrichmentApi#getIndicatorHistory");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | **String**| Type of indicator | [enum: ip, domain] |
| **value** | **String**| The indicator value (IP address or domain) | |
| **historyType** | **String**| Type of historical data to retrieve | [optional] [enum: whois, routing, dns, ssl, reputation] |

### Return type

[**HistoryResponse**](HistoryResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved historical data. |  -  |
| **400** | Invalid indicator type or history type. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | No historical data found for this indicator. |  -  |


## getPredictiveRisk

> PredictiveRiskResponse getPredictiveRisk(type, value)

Get AI Predictive Risk Score

&lt;p&gt;Returns ML-based predictive risk assessment for an IP address or domain. Provides current risk scoring, 7-day and 30-day predictions, risk trajectory analysis, and contributing factors.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Current Assessment:&lt;/b&gt; Risk score (0-100), risk level, and confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Predictions:&lt;/b&gt; 7-day and 30-day risk forecasts with confidence intervals&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trajectory:&lt;/b&gt; Trend direction (improving/stable/worsening), velocity, stability&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Risk Factors:&lt;/b&gt; Contributing factors with weights and descriptions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Early Warnings:&lt;/b&gt; Signals indicating potential future risk changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Similar Cases:&lt;/b&gt; Historical indicators with similar profiles and their outcomes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Risk Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;low:&lt;/b&gt; Score 0-30 - Minimal observed risk&lt;/li&gt;     &lt;li&gt;&lt;b&gt;medium:&lt;/b&gt; Score 31-60 - Moderate risk, warrants monitoring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;high:&lt;/b&gt; Score 61-80 - Elevated risk, investigation recommended&lt;/li&gt;     &lt;li&gt;&lt;b&gt;critical:&lt;/b&gt; Score 81-100 - Severe risk, immediate action advised&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-computed ML predictions. Response time typically under 500ms with 15-minute cache.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.EnrichmentApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        EnrichmentApi apiInstance = new EnrichmentApi(defaultClient);
        String type = "ip"; // String | Type of indicator
        String value = "8.8.8.8"; // String | The indicator value (IP address or domain)
        try {
            PredictiveRiskResponse result = apiInstance.getPredictiveRisk(type, value);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnrichmentApi#getPredictiveRisk");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | **String**| Type of indicator | [enum: ip, domain] |
| **value** | **String**| The indicator value (IP address or domain) | |

### Return type

[**PredictiveRiskResponse**](PredictiveRiskResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved predictive risk assessment. |  -  |
| **400** | Invalid indicator type or value. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Indicator not found in AI model data. |  -  |


## getSubdomains

> SubdomainResponse getSubdomains(domain, limit)

Get Domain Subdomains

Retrieves a list of discovered subdomains for a given root domain, based on passive DNS and other enumeration techniques.

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.EnrichmentApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        EnrichmentApi apiInstance = new EnrichmentApi(defaultClient);
        String domain = "google.com"; // String | The root domain to query for subdomains.
        Integer limit = 100; // Integer | The maximum number of subdomains to return.
        try {
            SubdomainResponse result = apiInstance.getSubdomains(domain, limit);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnrichmentApi#getSubdomains");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **domain** | **String**| The root domain to query for subdomains. | |
| **limit** | **Integer**| The maximum number of subdomains to return. | [optional] [default to 100] |

### Return type

[**SubdomainResponse**](SubdomainResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved subdomains. |  -  |
| **400** | Invalid domain format. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Domain not found or no subdomains discovered. |  -  |


## searchIndicators

> SearchResponse searchIndicators(searchRequest)

Search WHOIS and Geolocation Records (Asynchronous)

            &lt;p&gt;Initiates an asynchronous job to search domain registration (WHOIS) or IP geolocation records. This endpoint is extremely powerful for infrastructure discovery, threat hunting, and brand protection.&lt;/p&gt;             &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; WHOIS searches are data-intensive and can take over 50 seconds to complete. Geolocation searches are faster (5-10 seconds). This endpoint is asynchronous by design. Poll the &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; endpoint to retrieve results.&lt;/p&gt;              &lt;h4&gt;Search Types:&lt;/h4&gt;             &lt;p&gt;The endpoint automatically routes to the appropriate backend based on the fields provided:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;WHOIS Search:&lt;/b&gt; Use registrant fields (registrantCompany, registrantEmail, etc.) or domain-related fields (tld, nameServer, etc.)&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation Search:&lt;/b&gt; Use IP geolocation fields (city, country, asn, isp, etc.) to find IPs matching criteria&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;WHOIS Search Fields:&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Type&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;tld&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Top-level domain (e.g., \&quot;com\&quot;, \&quot;org\&quot;, \&quot;net\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain registrar name&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarIanaId&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;IANA registrar ID&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain registrant name (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCompany&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant organization/company (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantEmail&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant email address (supports *@domain.com wildcards)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantPhone&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant phone number&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCountry&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;2-letter country code (e.g., \&quot;US\&quot;, \&quot;DE\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCity&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant city&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;nameServer&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Name server hostname&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;domainStatus&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain status flag (e.g., \&quot;clientTransferProhibited\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;createdDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain creation date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;updatedDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain last update date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;expiryDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain expiry date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Geolocation Search Fields (query string syntax):&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;th&gt;Example&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;city&lt;/code&gt;&lt;/td&gt;&lt;td&gt;City name&lt;/td&gt;&lt;td&gt;&lt;code&gt;city:London&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;country&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Country name&lt;/td&gt;&lt;td&gt;&lt;code&gt;country:Germany&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;asn&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Autonomous System Number&lt;/td&gt;&lt;td&gt;&lt;code&gt;asn:15169&lt;/code&gt; (Google)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;isp&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Internet Service Provider name&lt;/td&gt;&lt;td&gt;&lt;code&gt;isp:Cloudflare&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;organization&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Organization name&lt;/td&gt;&lt;td&gt;&lt;code&gt;organization:Amazon&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;region&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Region/State&lt;/td&gt;&lt;td&gt;&lt;code&gt;region:California&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;postal_code&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Postal/ZIP code&lt;/td&gt;&lt;td&gt;&lt;code&gt;postal_code:94043&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;continent&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Continent&lt;/td&gt;&lt;td&gt;&lt;code&gt;continent:Europe&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Example Requests:&lt;/h4&gt;             &lt;p&gt;&lt;b&gt;WHOIS search (field-based):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;registrantCompany\&quot;: \&quot;Google\&quot;,   \&quot;registrantCountry\&quot;: \&quot;US\&quot;,   \&quot;limit\&quot;: 100,   \&quot;page\&quot;: 0 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by ASN):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;asn:15169\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by city):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;city:Mountain View\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Date-based domain search:&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;createdDate\&quot;: \&quot;2024-01-15\&quot;,   \&quot;tld\&quot;: \&quot;com\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;              &lt;h4&gt;Pagination:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;code&gt;limit&lt;/code&gt;: Maximum 100 results per page (default: 100)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;page&lt;/code&gt;: 0-indexed page number (default: 0)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;offset&lt;/code&gt;: Alternative to page - number of results to skip&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Use Cases:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;Threat hunting:&lt;/b&gt; Find domains/IPs registered by known malicious actors&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Infrastructure mapping:&lt;/b&gt; Find all IPs in a specific ASN or organization&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Brand protection:&lt;/b&gt; Monitor for domains similar to your brand&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation analysis:&lt;/b&gt; Find IPs in specific geographic regions&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Investigation:&lt;/b&gt; Track domains created on specific dates or IPs from specific ISPs&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Security:&lt;/h4&gt;             &lt;p&gt;All search parameters are validated for:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;SQL injection prevention&lt;/li&gt;                 &lt;li&gt;Command injection prevention&lt;/li&gt;                 &lt;li&gt;Input length limits&lt;/li&gt;                 &lt;li&gt;Format validation (dates, emails, country codes, etc.)&lt;/li&gt;             &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.EnrichmentApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        EnrichmentApi apiInstance = new EnrichmentApi(defaultClient);
        SearchRequest searchRequest = new SearchRequest(); // SearchRequest | The search query and configuration.
        try {
            SearchResponse result = apiInstance.searchIndicators(searchRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnrichmentApi#searchIndicators");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **searchRequest** | [**SearchRequest**](SearchRequest.md)| The search query and configuration. | |

### Return type

[**SearchResponse**](SearchResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Search job successfully accepted. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SearchResponse object. |  -  |
| **200** | Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure. |  -  |
| **400** | Invalid search query or parameters. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **429** | Rate limit exceeded for search operations. |  -  |


## similarDomains

> SimilarDomainsResponse similarDomains(similarDomainsOpsRequest)

Find Similar Domains (Asynchronous)

&lt;p&gt;Finds domains similar to the provided domain using various similarity detection techniques. This endpoint is useful for brand protection, typosquatting detection, and threat hunting.&lt;/p&gt;  &lt;h4&gt;Supported Techniques:&lt;/h4&gt; &lt;p&gt;Specify techniques in the &lt;code&gt;techniques&lt;/code&gt; array. If not specified, defaults to &lt;code&gt;typosquatting&lt;/code&gt;.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;typosquatting&lt;/b&gt; - Keyboard proximity errors and common typos (e.g., gooogle.com, gogle.com)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;homoglyph&lt;/b&gt; - Visually similar Unicode characters (e.g., gооgle.com using Cyrillic &#39;о&#39;)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;tld_variation&lt;/b&gt; - Different TLD variations (e.g., google.net, google.org)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;sounding&lt;/b&gt; - Phonetically similar domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;prefix&lt;/b&gt; - Domains starting with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;suffix&lt;/b&gt; - Domains ending with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;contains&lt;/b&gt; - Domains containing the target as a substring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;levenshtein&lt;/b&gt; - Edit distance similarity&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Example Request:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;techniques\&quot;: [\&quot;typosquatting\&quot;, \&quot;homoglyph\&quot;, \&quot;tld_variation\&quot;],   \&quot;limit\&quot;: 100 }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Poll &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; to get results. The result contains:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;status\&quot;: \&quot;completed\&quot;,   \&quot;similarDomains\&quot;: [     {\&quot;domain\&quot;: \&quot;gooogle.com\&quot;, \&quot;technique\&quot;: \&quot;TYPO\&quot;},     {\&quot;domain\&quot;: \&quot;gооgle.com\&quot;, \&quot;technique\&quot;: \&quot;UTFVARS\&quot;}   ],   \&quot;totalCount\&quot;: 200,   \&quot;analysis\&quot;: {     \&quot;techniquesUsed\&quot;: \&quot;TYPO,UTFVARS\&quot;,     \&quot;baseDomain\&quot;: \&quot;google.com\&quot;,     \&quot;searchLimit\&quot;: 100   } }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds. Multiple techniques run in parallel.&lt;/p&gt;  &lt;h4&gt;Note:&lt;/h4&gt; &lt;p&gt;The &lt;code&gt;check_registration&lt;/code&gt;, &lt;code&gt;include_dns&lt;/code&gt;, and &lt;code&gt;include_risk_score&lt;/code&gt; options are not currently supported by the backend service and will be ignored.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.EnrichmentApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        EnrichmentApi apiInstance = new EnrichmentApi(defaultClient);
        SimilarDomainsOpsRequest similarDomainsOpsRequest = new SimilarDomainsOpsRequest(); // SimilarDomainsOpsRequest | Similar domains request with domain and options.
        try {
            SimilarDomainsResponse result = apiInstance.similarDomains(similarDomainsOpsRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnrichmentApi#similarDomains");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **similarDomainsOpsRequest** | [**SimilarDomainsOpsRequest**](SimilarDomainsOpsRequest.md)| Similar domains request with domain and options. | |

### Return type

[**SimilarDomainsResponse**](SimilarDomainsResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Similar domains job created successfully. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SimilarDomainsResponse object. |  -  |
| **200** | Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure. |  -  |
| **400** | Invalid domain or options. |  -  |
| **401** | Authentication failed. |  -  |

