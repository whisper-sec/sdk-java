# IndicatorsApi

All URIs are relative to *http://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getIndicator**](IndicatorsApi.md#getIndicator) | **GET** /v1/indicators/{type}/{value} | Enrich a Single Indicator (IP or Domain) |
| [**getIndicatorGraph**](IndicatorsApi.md#getIndicatorGraph) | **GET** /v1/indicators/{type}/{value}/graph | Get Infrastructure Relationship Graph |
| [**getIndicatorHistory**](IndicatorsApi.md#getIndicatorHistory) | **GET** /v1/indicators/{type}/{value}/history | Get Historical Data for Indicator |
| [**getPredictiveRisk**](IndicatorsApi.md#getPredictiveRisk) | **GET** /v1/indicators/{type}/{value}/predictive-risk | Get AI Predictive Risk Score |
| [**getSubdomains**](IndicatorsApi.md#getSubdomains) | **GET** /v1/indicators/domain/{domain}/subdomains | Get Domain Subdomains |



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
        defaultClient.setBasePath("http://api.whisper.security");
        
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
| **200** | Successfully retrieved intelligence data. |  -  |
| **400** | Invalid indicator format or unsupported type. |  -  |
| **404** | The requested indicator was not found in our datasets. |  -  |
| **429** | Rate limit exceeded. |  -  |


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
        defaultClient.setBasePath("http://api.whisper.security");
        
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
| **404** | Indicator not found or no relationships discovered. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
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
        defaultClient.setBasePath("http://api.whisper.security");
        
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
| **400** | Invalid indicator type or history type. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **200** | Successfully retrieved historical data. |  -  |
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
import io.github.whispersec.api.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String type = "ip"; // String | Type of indicator
        String value = "8.8.8.8"; // String | The indicator value (IP address or domain)
        try {
            PredictiveRiskResponse result = apiInstance.getPredictiveRisk(type, value);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getPredictiveRisk");
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
| **400** | Invalid indicator type or value. |  -  |
| **404** | Indicator not found in AI model data. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **200** | Successfully retrieved predictive risk assessment. |  -  |


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
        defaultClient.setBasePath("http://api.whisper.security");
        
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
| **200** | Successfully retrieved subdomains. |  -  |
| **404** | Domain not found or no subdomains discovered. |  -  |

