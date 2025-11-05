# IndicatorsApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**bulkEnrichment**](IndicatorsApi.md#bulkEnrichment) | **POST** /v1/indicators/bulk | Bulk Indicator Enrichment (Asynchronous) |
| [**generateSimilarDomainsGet**](IndicatorsApi.md#generateSimilarDomainsGet) | **GET** /v1/indicators/domain/{domain}/similar | Generate Similar Domains - GET (Asynchronous) |
| [**generateSimilarDomainsPost**](IndicatorsApi.md#generateSimilarDomainsPost) | **POST** /v1/indicators/domain/{domain}/similar | Generate Similar Domains - POST (Asynchronous) |
| [**getIndicator**](IndicatorsApi.md#getIndicator) | **GET** /v1/indicators/{type}/{value} | Enrich a Single Indicator (IP or Domain) |
| [**getIndicatorGraph**](IndicatorsApi.md#getIndicatorGraph) | **GET** /v1/indicators/{type}/{value}/graph | Get Infrastructure Relationship Graph |
| [**getIndicatorHistory**](IndicatorsApi.md#getIndicatorHistory) | **GET** /v1/indicators/{type}/{value}/history | Get Historical Data for Indicator |
| [**getSubdomains**](IndicatorsApi.md#getSubdomains) | **GET** /v1/indicators/domain/{domain}/subdomains | Get Domain Subdomains |
| [**searchIndicators**](IndicatorsApi.md#searchIndicators) | **POST** /v1/indicators/search | Search Indicators (Asynchronous) |



## bulkEnrichment

> JobResponse bulkEnrichment(bulkRequest)

Bulk Indicator Enrichment (Asynchronous)

&lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance:&lt;/b&gt; Processing time depends on batch size and requested data modules. Expect 5-30 seconds for typical batches.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Rate Limits:&lt;/b&gt; Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        BulkRequest bulkRequest = new BulkRequest(); // BulkRequest | List of indicators and processing options.
        try {
            JobResponse result = apiInstance.bulkEnrichment(bulkRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#bulkEnrichment");
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

[**JobResponse**](JobResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Bulk job successfully accepted for processing. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid request. Empty indicator list or exceeds 100 indicator limit. |  -  |
| **429** | Rate limit exceeded for bulk operations. |  -  |


## generateSimilarDomainsGet

> JobResponse generateSimilarDomainsGet(domain)

Generate Similar Domains - GET (Asynchronous)

&lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains using default options. This GET variant is provided for convenience.&lt;/p&gt; &lt;p&gt;For custom options (algorithms, limits, etc.), use the POST version of this endpoint.&lt;/p&gt; &lt;p&gt;The API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when complete.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String domain = "mybrand.com"; // String | The domain to generate variations for.
        try {
            JobResponse result = apiInstance.generateSimilarDomainsGet(domain);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#generateSimilarDomainsGet");
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
| **domain** | **String**| The domain to generate variations for. | |

### Return type

[**JobResponse**](JobResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Job successfully accepted for processing. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid domain format in path. |  -  |


## generateSimilarDomainsPost

> JobResponse generateSimilarDomainsPost(domain, similarDomainRequest)

Generate Similar Domains - POST (Asynchronous)

&lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains for typosquatting, homoglyph, and brand protection analysis. This is a powerful tool for proactive threat hunting.&lt;/p&gt; &lt;p&gt;Because this can be a long-running process, the API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when the job is complete.&lt;/p&gt; &lt;p&gt;Use this POST version to specify custom options like algorithms, limits, or filters.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String domain = "mybrand.com"; // String | The domain to generate variations for.
        SimilarDomainRequest similarDomainRequest = new SimilarDomainRequest(); // SimilarDomainRequest | Configuration for the similarity generation.
        try {
            JobResponse result = apiInstance.generateSimilarDomainsPost(domain, similarDomainRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#generateSimilarDomainsPost");
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
| **domain** | **String**| The domain to generate variations for. | |
| **similarDomainRequest** | [**SimilarDomainRequest**](SimilarDomainRequest.md)| Configuration for the similarity generation. | [optional] |

### Return type

[**JobResponse**](JobResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Job successfully accepted for processing. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid domain format in path. |  -  |


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
import io.github.whispersec.api.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String type = "ip"; // String | The type of indicator to enrich.
        String value = "8.8.8.8"; // String | The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
        String include = "routing"; // String | A comma-separated list of additional data modules to include in the response. Requesting more modules may increase latency.
        try {
            IndicatorResponse result = apiInstance.getIndicator(type, value, include);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicator");
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
| **include** | **String**| A comma-separated list of additional data modules to include in the response. Requesting more modules may increase latency. | [optional] [enum: routing, rpki, whois, dns_details, ip_intelligence] |

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
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | The requested indicator was not found in our datasets. |  -  |
| **429** | Rate limit exceeded. |  -  |
| **400** | Invalid indicator format or unsupported type. |  -  |
| **200** | Successfully retrieved intelligence data. |  -  |


## getIndicatorGraph

> getIndicatorGraph(type, value, limit)

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
import io.github.whispersec.api.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String type = "ip"; // String | Type of indicator
        String value = "example.com"; // String | The indicator value (IP address or domain)
        Integer limit = 100; // Integer | Maximum number of nodes to return in the graph
        try {
            apiInstance.getIndicatorGraph(type, value, limit);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicatorGraph");
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

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Indicator not found or no relationships discovered. |  -  |
| **400** | Invalid indicator type or limit parameter. |  -  |
| **200** | Successfully retrieved graph data. |  -  |


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
import io.github.whispersec.api.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String type = "ip"; // String | Type of indicator
        String value = "example.com"; // String | The indicator value (IP address or domain)
        String historyType = "whois"; // String | Type of historical data to retrieve
        try {
            HistoryResponse result = apiInstance.getIndicatorHistory(type, value, historyType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicatorHistory");
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
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid indicator type or history type. |  -  |
| **200** | Successfully retrieved historical data. |  -  |
| **404** | No historical data found for this indicator. |  -  |


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
import io.github.whispersec.api.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String domain = "google.com"; // String | The root domain to query for subdomains.
        Integer limit = 100; // Integer | The maximum number of subdomains to return.
        try {
            SubdomainResponse result = apiInstance.getSubdomains(domain, limit);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getSubdomains");
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
| **400** | Invalid domain format. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Domain not found or no subdomains discovered. |  -  |
| **200** | Successfully retrieved subdomains. |  -  |


## searchIndicators

> JobResponse searchIndicators(searchRequest)

Search Indicators (Asynchronous)

&lt;p&gt;Initiates an asynchronous job to search for indicators matching specific criteria. This endpoint is extremely powerful for infrastructure discovery and threat hunting.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; Searches on WHOIS fields (like &#x60;registrantCompany&#x60;) are data-intensive and can take over 50 seconds to complete. This endpoint is therefore asynchronous by design. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve results.&lt;/p&gt; &lt;h4&gt;Example Search Queries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&#x60;registrantCompany:EvilCorp&#x60; - Find all domains registered by EvilCorp&lt;/li&gt;     &lt;li&gt;&#x60;asn:15169&#x60; - Find all IPs in Google&#39;s ASN&lt;/li&gt;     &lt;li&gt;&#x60;city:\&quot;San Francisco\&quot;&#x60; - Find all IPs geolocated to San Francisco&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        SearchRequest searchRequest = new SearchRequest(); // SearchRequest | The search query and configuration.
        try {
            JobResponse result = apiInstance.searchIndicators(searchRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#searchIndicators");
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

[**JobResponse**](JobResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid search query or parameters. |  -  |
| **429** | Rate limit exceeded for search operations. |  -  |
| **202** | Search job successfully accepted. |  -  |

