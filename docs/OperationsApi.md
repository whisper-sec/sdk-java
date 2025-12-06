# OperationsApi

All URIs are relative to *http://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**aiAttribute**](OperationsApi.md#aiAttribute) | **POST** /v1/ops/ai/attribute | Threat Actor Attribution (Asynchronous) |
| [**aiCorrelate**](OperationsApi.md#aiCorrelate) | **POST** /v1/ops/ai/correlate | Global Indicator Correlation (Asynchronous) |
| [**aiInvestigate**](OperationsApi.md#aiInvestigate) | **POST** /v1/ops/ai/investigate | AI Threat Investigation (Asynchronous) |
| [**aiPivot**](OperationsApi.md#aiPivot) | **POST** /v1/ops/ai/pivot | AI Infrastructure Pivot (Asynchronous) |
| [**bulkEnrichment**](OperationsApi.md#bulkEnrichment) | **POST** /v1/ops/enrichment/bulk | Bulk Indicator Enrichment (Asynchronous) |
| [**createInfrastructureMap**](OperationsApi.md#createInfrastructureMap) | **POST** /v1/ops/scans/map | Map Infrastructure Relationships (Asynchronous) |
| [**createInfrastructureScan**](OperationsApi.md#createInfrastructureScan) | **POST** /v1/ops/scans/infrastructure | Infrastructure Security Scan (Asynchronous) |
| [**createMonitorCheck**](OperationsApi.md#createMonitorCheck) | **POST** /v1/ops/monitoring | Create Monitoring Check |
| [**createMonitoringAlert**](OperationsApi.md#createMonitoringAlert) | **POST** /v1/ops/monitoring/{target}/alert | Configure Monitoring Alerts (Asynchronous) |
| [**createScreenshot**](OperationsApi.md#createScreenshot) | **POST** /v1/ops/screenshots/capture | Capture a Website Screenshot (Asynchronous) |
| [**deleteMonitorCheck**](OperationsApi.md#deleteMonitorCheck) | **DELETE** /v1/ops/monitoring/{checkId} | Delete Monitoring Check |
| [**findSimilarCases**](OperationsApi.md#findSimilarCases) | **POST** /v1/ops/ai/similar-cases | Find Similar Cases (Asynchronous) |
| [**getChanges**](OperationsApi.md#getChanges) | **GET** /v1/ops/tracking/{type}/{value} | Get Detected Changes |
| [**getIndustryBenchmark**](OperationsApi.md#getIndustryBenchmark) | **GET** /v1/ops/ai/benchmark/{industry} | Get Industry Security Benchmark (Synchronous) |
| [**getJob**](OperationsApi.md#getJob) | **GET** /v1/ops/jobs/{jobId} | Get Asynchronous Job Status and Results |
| [**getMonitorCheck**](OperationsApi.md#getMonitorCheck) | **GET** /v1/ops/monitoring/{checkId} | Get Monitoring Check |
| [**getMonitorDashboard**](OperationsApi.md#getMonitorDashboard) | **GET** /v1/ops/monitoring/dashboard | Get Monitoring Dashboard |
| [**getMonitorResults**](OperationsApi.md#getMonitorResults) | **GET** /v1/ops/monitoring/{checkId}/results | Get Check Results |
| [**getMonitoringStatus**](OperationsApi.md#getMonitoringStatus) | **GET** /v1/ops/monitoring/status/{target} | Get Monitoring Status and Metrics |
| [**getScreenshotHistory**](OperationsApi.md#getScreenshotHistory) | **GET** /v1/ops/screenshots/history | Get Screenshot History |
| [**listJobs**](OperationsApi.md#listJobs) | **GET** /v1/ops/jobs/list | List Recent Jobs |
| [**listMonitorChecks**](OperationsApi.md#listMonitorChecks) | **GET** /v1/ops/monitoring | List Monitoring Checks |
| [**listTrackedIndicators**](OperationsApi.md#listTrackedIndicators) | **GET** /v1/ops/tracking | List Tracked Indicators |
| [**scheduleScreenshot**](OperationsApi.md#scheduleScreenshot) | **POST** /v1/ops/screenshots/schedule | Schedule Recurring Screenshots (Asynchronous) |
| [**searchIndicators**](OperationsApi.md#searchIndicators) | **POST** /v1/ops/enrichment/search | Search Indicators (Asynchronous) |
| [**similarDomains**](OperationsApi.md#similarDomains) | **POST** /v1/ops/enrichment/similar-domains | Find Similar Domains (Asynchronous) |
| [**startChangeTracking**](OperationsApi.md#startChangeTracking) | **POST** /v1/ops/tracking/{type}/{value} | Start Change Tracking |
| [**stopChangeTracking**](OperationsApi.md#stopChangeTracking) | **DELETE** /v1/ops/tracking/{type}/{value} | Stop Change Tracking |
| [**triggerCheck**](OperationsApi.md#triggerCheck) | **POST** /v1/ops/tracking/{type}/{value}/check | Trigger Immediate Check |
| [**triggerMonitorCheck**](OperationsApi.md#triggerMonitorCheck) | **POST** /v1/ops/monitoring/{checkId}/trigger | Trigger Manual Check |
| [**updateMonitorCheck**](OperationsApi.md#updateMonitorCheck) | **PUT** /v1/ops/monitoring/{checkId} | Update Monitoring Check |



## aiAttribute

> JobResponse aiAttribute(attributeRequest)

Threat Actor Attribution (Asynchronous)

&lt;p&gt;Analyzes indicators and context to identify potential threat actors and campaigns. Uses ML clustering and TTP matching against known threat actor profiles.&lt;/p&gt; &lt;h4&gt;Attribution Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Actor Identification:&lt;/b&gt; Potential threat actor matches with confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Clustering:&lt;/b&gt; Groups indicators into potential campaigns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;TTP Mapping:&lt;/b&gt; MITRE ATT&amp;CK technique mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Historical Context:&lt;/b&gt; Known actor activity patterns&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 500 indicators per request. Attribution is probabilistic and should be validated.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Campaign clustering and analysis. Expected: 60-300 seconds.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        AttributeRequest attributeRequest = new AttributeRequest(); // AttributeRequest | Attribution request
        try {
            JobResponse result = apiInstance.aiAttribute(attributeRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#aiAttribute");
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
| **attributeRequest** | [**AttributeRequest**](AttributeRequest.md)| Attribution request | |

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
| **202** | Attribution analysis job accepted. |  -  |
| **400** | Invalid request or exceeds 500 indicator limit. |  -  |
| **401** | Authentication failed. |  -  |


## aiCorrelate

> JobResponse aiCorrelate(correlateRequest)

Global Indicator Correlation (Asynchronous)

&lt;p&gt;Correlates your indicators against anonymized global threat data from all customers. Identifies shared campaigns, widespread threats, and prevalence across industries.&lt;/p&gt; &lt;h4&gt;Correlation Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Prevalence:&lt;/b&gt; How common are these indicators across our customer base&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Industry Breakdown:&lt;/b&gt; Which industries are seeing these indicators&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Detection:&lt;/b&gt; Are these part of a broader campaign&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First/Last Seen:&lt;/b&gt; Global timeline of indicator activity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Co-occurrence:&lt;/b&gt; Indicators frequently seen together&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 100 indicators per request.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Cross-customer correlation. Expected: 10-60 seconds.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        CorrelateRequest correlateRequest = new CorrelateRequest(); // CorrelateRequest | Correlation request
        try {
            JobResponse result = apiInstance.aiCorrelate(correlateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#aiCorrelate");
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
| **correlateRequest** | [**CorrelateRequest**](CorrelateRequest.md)| Correlation request | |

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
| **400** | Invalid request or exceeds 100 indicator limit. |  -  |
| **202** | Correlation job accepted. |  -  |
| **401** | Authentication failed. |  -  |


## aiInvestigate

> JobResponse aiInvestigate(investigateRequest)

AI Threat Investigation (Asynchronous)

&lt;p&gt;Initiates a comprehensive AI-powered threat investigation for an indicator. Uses large language models to analyze threat intelligence, generate insights, and provide actionable recommendations.&lt;/p&gt; &lt;h4&gt;Investigation Output:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Verdict:&lt;/b&gt; Threat assessment with confidence score&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timeline:&lt;/b&gt; Activity timeline reconstruction&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Analysis:&lt;/b&gt; Detailed findings from multiple data sources&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Related Indicators:&lt;/b&gt; Discovered related infrastructure&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Recommendations:&lt;/b&gt; Suggested response actions&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;LLM-based analysis. Expected completion: 30-180 seconds depending on complexity.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        InvestigateRequest investigateRequest = new InvestigateRequest(); // InvestigateRequest | Investigation request
        try {
            JobResponse result = apiInstance.aiInvestigate(investigateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#aiInvestigate");
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
| **investigateRequest** | [**InvestigateRequest**](InvestigateRequest.md)| Investigation request | |

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
| **400** | Invalid request. |  -  |
| **202** | Investigation job accepted. |  -  |
| **401** | Authentication failed. |  -  |


## aiPivot

> JobResponse aiPivot(pivotRequest)

AI Infrastructure Pivot (Asynchronous)

&lt;p&gt;Performs intelligent infrastructure pivoting starting from an indicator. Uses ML to identify the most relevant relationships and suggest investigation paths.&lt;/p&gt; &lt;h4&gt;Pivot Strategies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;infrastructure:&lt;/b&gt; Shared hosting, nameservers, certificates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;registration:&lt;/b&gt; Same registrant, registration patterns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;behavioral:&lt;/b&gt; Similar traffic patterns, communication&lt;/li&gt;     &lt;li&gt;&lt;b&gt;temporal:&lt;/b&gt; Co-occurrence within time windows&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Discovered related indicators with relevance scores&lt;/li&gt;     &lt;li&gt;Suggested investigation paths ranked by priority&lt;/li&gt;     &lt;li&gt;Relationship graph data&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Graph traversal with ML ranking. Expected: 10-120 seconds based on depth.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        PivotRequest pivotRequest = new PivotRequest(); // PivotRequest | Pivot request
        try {
            JobResponse result = apiInstance.aiPivot(pivotRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#aiPivot");
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
| **pivotRequest** | [**PivotRequest**](PivotRequest.md)| Pivot request | |

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
| **202** | Pivot analysis job accepted. |  -  |
| **400** | Invalid request. |  -  |
| **401** | Authentication failed. |  -  |


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
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        BulkRequest bulkRequest = new BulkRequest(); // BulkRequest | List of indicators and processing options.
        try {
            JobResponse result = apiInstance.bulkEnrichment(bulkRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#bulkEnrichment");
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
| **429** | Rate limit exceeded for bulk operations. |  -  |
| **400** | Invalid request. Empty indicator list or exceeds 100 indicator limit. |  -  |


## createInfrastructureMap

> JobResponse createInfrastructureMap(infrastructureMapRequest)

Map Infrastructure Relationships (Asynchronous)

&lt;p&gt;Creates a comprehensive map of infrastructure relationships starting from a domain or IP. Discovers connected assets through shared hosting, DNS, certificates, and network relationships.&lt;/p&gt; &lt;h4&gt;Mapping Depth Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Depth 1:&lt;/b&gt; Direct relationships only (~30 seconds, 10-50 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 2:&lt;/b&gt; 2 hops out (~2-5 minutes, 50-500 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 3:&lt;/b&gt; 3 hops out (~10-30 minutes, 500-5000 assets)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Relationship Types Discovered:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Domains on same IP&lt;/li&gt;     &lt;li&gt;Domains sharing nameservers&lt;/li&gt;     &lt;li&gt;Domains with same SSL certificate&lt;/li&gt;     &lt;li&gt;IPs in same ASN&lt;/li&gt;     &lt;li&gt;Domains with same registrant&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Results returned as graph data compatible with visualization libraries (nodes and edges).&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Threat actor infrastructure mapping&lt;/li&gt;     &lt;li&gt;Discovering related phishing domains&lt;/li&gt;     &lt;li&gt;Finding shadow IT and forgotten assets&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        InfrastructureMapRequest infrastructureMapRequest = new InfrastructureMapRequest(); // InfrastructureMapRequest | Mapping configuration. Example: ```json {   \"startPoint\": \"example.com\",   \"depth\": 2 } ``` 
        try {
            JobResponse result = apiInstance.createInfrastructureMap(infrastructureMapRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#createInfrastructureMap");
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
| **infrastructureMapRequest** | [**InfrastructureMapRequest**](InfrastructureMapRequest.md)| Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60;  | |

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
| **202** | Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid starting point or depth (must be 1-3). |  -  |


## createInfrastructureScan

> JobResponse createInfrastructureScan(scanRequest)

Infrastructure Security Scan (Asynchronous)

&lt;p&gt;Initiates a comprehensive security scan of a domain&#39;s infrastructure. Performs reconnaissance, port scanning, service detection, and vulnerability assessment.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (recommended for complete assessment)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration only&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ports:&lt;/b&gt; Port scanning and service detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerabilities:&lt;/b&gt; Known vulnerability checks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS configuration and certificate analysis&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS configuration and zone transfer tests&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration and ownership information&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 30-60 seconds (subdomains, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 5-15 minutes depending on infrastructure size&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;Infrastructure inventory and mapping&lt;/li&gt;     &lt;li&gt;Vulnerability management&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        ScanRequest scanRequest = new ScanRequest(); // ScanRequest | Scan configuration including target domain and scan type.
        try {
            JobResponse result = apiInstance.createInfrastructureScan(scanRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#createInfrastructureScan");
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
| **scanRequest** | [**ScanRequest**](ScanRequest.md)| Scan configuration including target domain and scan type. | |

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
| **202** | Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results. |  -  |
| **400** | Invalid domain or scan type. |  -  |


## createMonitorCheck

> MonitorCheckResponse createMonitorCheck(monitorCheckRequest)

Create Monitoring Check

&lt;p&gt;Create a new monitoring check to track uptime and performance of a URL or endpoint.&lt;/p&gt; &lt;h4&gt;Check Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;api:&lt;/b&gt; HTTP/HTTPS endpoint monitoring - checks status code, response time, content&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL certificate monitoring - validates certificate and tracks expiry&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record monitoring - validates DNS resolution and record values&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequency Options:&lt;/h4&gt; &lt;p&gt;Check frequency in minutes: 1, 5, 10, 15, 30, 60, 1440 (daily)&lt;/p&gt; &lt;h4&gt;Locations:&lt;/h4&gt; &lt;p&gt;Checks can run from multiple global locations: us-east-1, us-west-1, eu-west-1, ap-southeast-1&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        MonitorCheckRequest monitorCheckRequest = new MonitorCheckRequest(); // MonitorCheckRequest | Monitoring check configuration
        try {
            MonitorCheckResponse result = apiInstance.createMonitorCheck(monitorCheckRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#createMonitorCheck");
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
| **monitorCheckRequest** | [**MonitorCheckRequest**](MonitorCheckRequest.md)| Monitoring check configuration | |

### Return type

[**MonitorCheckResponse**](MonitorCheckResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Monitoring check created successfully. |  -  |
| **400** | Invalid request - missing name or URL. |  -  |
| **401** | Authentication failed. |  -  |


## createMonitoringAlert

> JobResponse createMonitoringAlert(target, monitoringAlertRequest)

Configure Monitoring Alerts (Asynchronous)

&lt;p&gt;Create alert rules for a monitored asset. Get notified via webhook, email, or Slack when specific conditions are met.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Site becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; DNS records modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Registration details updated&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Certificate expires soon (7, 14, 30 days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Page content modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Tech stack changes detected&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Webhook (POST to your endpoint)&lt;/li&gt;     &lt;li&gt;Email&lt;/li&gt;     &lt;li&gt;Slack&lt;/li&gt;     &lt;li&gt;PagerDuty&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Example Configuration:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;type\&quot;: \&quot;ssl_expiring\&quot;,   \&quot;threshold_days\&quot;: 14,   \&quot;channels\&quot;: [\&quot;email\&quot;, \&quot;slack\&quot;],   \&quot;email\&quot;: \&quot;alerts@example.com\&quot;,   \&quot;slack_webhook\&quot;: \&quot;https://hooks.slack.com/...\&quot; }&lt;/code&gt;&lt;/pre&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String target = "example.com"; // String | The domain or IP address to configure alerts for.
        MonitoringAlertRequest monitoringAlertRequest = new MonitoringAlertRequest(); // MonitoringAlertRequest | Alert configuration including type, thresholds, and notification channels.
        try {
            JobResponse result = apiInstance.createMonitoringAlert(target, monitoringAlertRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#createMonitoringAlert");
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
| **target** | **String**| The domain or IP address to configure alerts for. | |
| **monitoringAlertRequest** | [**MonitoringAlertRequest**](MonitoringAlertRequest.md)| Alert configuration including type, thresholds, and notification channels. | |

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
| **202** | Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status. |  -  |
| **400** | Invalid alert configuration. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |


## createScreenshot

> JobResponse createScreenshot(screenshotRequest)

Capture a Website Screenshot (Asynchronous)

&lt;p&gt;Initiates an asynchronous job to capture a screenshot of a website. Supports various viewport sizes, full-page captures, and JavaScript rendering.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; A typical screenshot capture takes 10-30 seconds. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve the URL of the final image.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Output:&lt;/b&gt; The job result will contain a URL to download the screenshot image in the specified format (PNG, JPEG, or WebP).&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        ScreenshotRequest screenshotRequest = new ScreenshotRequest(); // ScreenshotRequest | The URL and options for the screenshot capture.
        try {
            JobResponse result = apiInstance.createScreenshot(screenshotRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#createScreenshot");
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
| **screenshotRequest** | [**ScreenshotRequest**](ScreenshotRequest.md)| The URL and options for the screenshot capture. | |

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
| **202** | Screenshot job successfully accepted. |  -  |
| **400** | Invalid URL or options provided. |  -  |
| **429** | Rate limit exceeded. |  -  |


## deleteMonitorCheck

> deleteMonitorCheck(checkId)

Delete Monitoring Check

Delete a monitoring check and stop all monitoring for the target.

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        try {
            apiInstance.deleteMonitorCheck(checkId);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#deleteMonitorCheck");
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
| **checkId** | **String**| Check ID | |

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
| **404** | Check not found or access denied. |  -  |
| **204** | Check deleted successfully. |  -  |
| **401** | Authentication failed. |  -  |


## findSimilarCases

> JobResponse findSimilarCases(similarCasesRequest)

Find Similar Cases (Asynchronous)

&lt;p&gt;Uses ML to find historical threat cases similar to the current investigation. Helps analysts understand attack patterns and expected outcomes.&lt;/p&gt; &lt;h4&gt;Matching Criteria:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Indicator overlap and relationships&lt;/li&gt;     &lt;li&gt;Behavioral patterns and TTPs&lt;/li&gt;     &lt;li&gt;Infrastructure characteristics&lt;/li&gt;     &lt;li&gt;Attack progression similarities&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;Case outcomes and verdicts&lt;/li&gt;     &lt;li&gt;Common patterns across matches&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;ML similarity matching. Expected completion: 5-30 seconds.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        SimilarCasesRequest similarCasesRequest = new SimilarCasesRequest(); // SimilarCasesRequest | Similar cases request
        try {
            JobResponse result = apiInstance.findSimilarCases(similarCasesRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#findSimilarCases");
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
| **similarCasesRequest** | [**SimilarCasesRequest**](SimilarCasesRequest.md)| Similar cases request | |

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
| **400** | Invalid request. |  -  |
| **202** | Similar cases search job accepted. |  -  |
| **401** | Authentication failed. |  -  |


## getChanges

> ChangeTrackingResponse getChanges(type, value, since)

Get Detected Changes

&lt;p&gt;Retrieve detected changes for a tracked indicator. Returns the current tracking configuration, baseline snapshot, and list of all detected changes.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;tracking:&lt;/b&gt; Current tracking configuration (enabled, frequency, fields, next check)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;baseline:&lt;/b&gt; The stored baseline snapshot data&lt;/li&gt;     &lt;li&gt;&lt;b&gt;changes:&lt;/b&gt; Array of detected changes with timestamps, old/new values&lt;/li&gt;     &lt;li&gt;&lt;b&gt;totalChanges:&lt;/b&gt; Total number of changes detected&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String type = "domain"; // String | Indicator type: ip or domain
        String value = "google.com"; // String | Indicator value
        String since = "2025-01-01T00:00:00Z"; // String | ISO 8601 timestamp to get changes from
        try {
            ChangeTrackingResponse result = apiInstance.getChanges(type, value, since);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#getChanges");
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
| **type** | **String**| Indicator type: ip or domain | |
| **value** | **String**| Indicator value | |
| **since** | **String**| ISO 8601 timestamp to get changes from | [optional] |

### Return type

[**ChangeTrackingResponse**](ChangeTrackingResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | Indicator is not being tracked. |  -  |
| **200** | Successfully retrieved changes. |  -  |
| **401** | Authentication failed. |  -  |


## getIndustryBenchmark

> BenchmarkResponse getIndustryBenchmark(industry, size, region)

Get Industry Security Benchmark (Synchronous)

&lt;p&gt;Returns anonymized, aggregated security metrics for your industry vertical. Compare your security posture against peers.&lt;/p&gt; &lt;h4&gt;Available Industries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;financial_services, healthcare, technology, retail, manufacturing&lt;/li&gt;     &lt;li&gt;energy, telecommunications, government, education, media&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Risk Scores:&lt;/b&gt; Average risk score, percentiles (25th, 50th, 75th, 90th)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Response Metrics:&lt;/b&gt; Mean time to detect (MTTD), mean time to respond (MTTR)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Detection Metrics:&lt;/b&gt; Detection rate, false positive rate&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Threat Profile:&lt;/b&gt; Top threats, common attack vectors, targeted assets&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trends:&lt;/b&gt; 30-day risk trend direction and change percentage&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-aggregated data. Response time typically under 500ms with 1-hour cache.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String industry = "financial_services"; // String | Industry vertical code
        String size = "enterprise"; // String | Organization size filter
        String region = "north_america"; // String | Geographic region filter
        try {
            BenchmarkResponse result = apiInstance.getIndustryBenchmark(industry, size, region);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#getIndustryBenchmark");
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
| **industry** | **String**| Industry vertical code | [enum: financial_services, healthcare, technology, retail, manufacturing, energy, telecommunications, government, education, media] |
| **size** | **String**| Organization size filter | [optional] |
| **region** | **String**| Geographic region filter | [optional] |

### Return type

[**BenchmarkResponse**](BenchmarkResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved industry benchmark. |  -  |
| **400** | Invalid industry code. |  -  |
| **401** | Authentication failed. |  -  |


## getJob

> Job getJob(jobId)

Get Asynchronous Job Status and Results

&lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String jobId = "f6250320-9ed4-442b-a389-acfda52d9375"; // String | The unique ID of the job, returned from a `POST` operation.
        try {
            Job result = apiInstance.getJob(jobId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#getJob");
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
| **jobId** | **String**| The unique ID of the job, returned from a &#x60;POST&#x60; operation. | |

### Return type

[**Job**](Job.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Job ID not found. |  -  |
| **200** | Job status and results retrieved successfully. |  -  |


## getMonitorCheck

> MonitorCheckResponse getMonitorCheck(checkId)

Get Monitoring Check

Get details of a specific monitoring check including uptime metrics.

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        try {
            MonitorCheckResponse result = apiInstance.getMonitorCheck(checkId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#getMonitorCheck");
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
| **checkId** | **String**| Check ID | |

### Return type

[**MonitorCheckResponse**](MonitorCheckResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | Check not found or access denied. |  -  |
| **200** | Check details. |  -  |
| **401** | Authentication failed. |  -  |


## getMonitorDashboard

> MonitorDashboardResponse getMonitorDashboard()

Get Monitoring Dashboard

&lt;p&gt;Get aggregated dashboard statistics for all monitoring checks.&lt;/p&gt; &lt;h4&gt;Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Total, passing, failing, and degraded check counts&lt;/li&gt;     &lt;li&gt;Average uptime percentages (24h, 7d, 30d)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;Checks grouped by type and status&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        try {
            MonitorDashboardResponse result = apiInstance.getMonitorDashboard();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#getMonitorDashboard");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**MonitorDashboardResponse**](MonitorDashboardResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Dashboard summary. |  -  |
| **401** | Authentication failed. |  -  |


## getMonitorResults

> getMonitorResults(checkId, limit)

Get Check Results

&lt;p&gt;Get the execution history for a monitoring check.&lt;/p&gt; &lt;h4&gt;Response includes for each result:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Timestamp of execution&lt;/li&gt;     &lt;li&gt;Success/failure status&lt;/li&gt;     &lt;li&gt;Response time&lt;/li&gt;     &lt;li&gt;HTTP status code (for API checks)&lt;/li&gt;     &lt;li&gt;Error message (if failed)&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        Integer limit = 10; // Integer | Maximum number of results to return
        try {
            apiInstance.getMonitorResults(checkId, limit);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#getMonitorResults");
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
| **checkId** | **String**| Check ID | |
| **limit** | **Integer**| Maximum number of results to return | [optional] [default to 10] |

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
| **200** | Check execution history. |  -  |
| **404** | Check not found or access denied. |  -  |
| **401** | Authentication failed. |  -  |


## getMonitoringStatus

> getMonitoringStatus(target)

Get Monitoring Status and Metrics

&lt;p&gt;Retrieves current monitoring configuration and historical metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Status Information:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Monitoring State:&lt;/b&gt; Active, paused, or not monitored&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Check Frequency:&lt;/b&gt; How often checks are performed&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Active Alerts:&lt;/b&gt; Currently triggered alert conditions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Last Check:&lt;/b&gt; Timestamp of most recent check&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String target = "example.com"; // String | The domain or IP address to check monitoring status for.
        try {
            apiInstance.getMonitoringStatus(target);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#getMonitoringStatus");
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
| **target** | **String**| The domain or IP address to check monitoring status for. | |

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
| **200** | Successfully retrieved monitoring status. |  -  |
| **404** | Target is not being monitored. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |


## getScreenshotHistory

> getScreenshotHistory(target, limit)

Get Screenshot History

&lt;p&gt;Retrieve all previously captured screenshots for a specific URL, ordered by capture time (newest first). Includes download URLs and metadata for each capture.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Download URL:&lt;/b&gt; Direct link to screenshot image&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Time:&lt;/b&gt; Timestamp when screenshot was taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Dimensions:&lt;/b&gt; Image width and height&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Format:&lt;/b&gt; Image format (PNG, JPEG, WebP)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;File Size:&lt;/b&gt; Size in bytes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Review website evolution over time&lt;/li&gt;     &lt;li&gt;Compare screenshots for change detection&lt;/li&gt;     &lt;li&gt;Download historical screenshots for reporting&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String target = "example.com"; // String | The target domain or URL to retrieve screenshot history for.
        Integer limit = 10; // Integer | Maximum number of screenshots to return.
        try {
            apiInstance.getScreenshotHistory(target, limit);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#getScreenshotHistory");
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
| **target** | **String**| The target domain or URL to retrieve screenshot history for. | |
| **limit** | **Integer**| Maximum number of screenshots to return. | [optional] [default to 10] |

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
| **400** | Invalid URL parameter. |  -  |
| **200** | Successfully retrieved screenshot history. |  -  |
| **404** | No screenshots found for the specified URL. |  -  |


## listJobs

> listJobs(status, limit, offset)

List Recent Jobs

&lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String status = "status_example"; // String | Filter by job status
        Integer limit = 50; // Integer | Maximum number of jobs to return
        Integer offset = 0; // Integer | Number of jobs to skip
        try {
            apiInstance.listJobs(status, limit, offset);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#listJobs");
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
| **status** | **String**| Filter by job status | [optional] |
| **limit** | **Integer**| Maximum number of jobs to return | [optional] [default to 50] |
| **offset** | **Integer**| Number of jobs to skip | [optional] [default to 0] |

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
| **200** | Successfully retrieved job list. |  -  |


## listMonitorChecks

> MonitorListResponse listMonitorChecks(type, status)

List Monitoring Checks

&lt;p&gt;Get a list of all monitoring checks created by the authenticated user.&lt;/p&gt; &lt;h4&gt;Filtering:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;type:&lt;/b&gt; Filter by check type (api, ssl, dns)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by status (passing, failing, degraded, pending)&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String type = "api"; // String | Filter by check type
        String status = "passing"; // String | Filter by status
        try {
            MonitorListResponse result = apiInstance.listMonitorChecks(type, status);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#listMonitorChecks");
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
| **type** | **String**| Filter by check type | [optional] |
| **status** | **String**| Filter by status | [optional] |

### Return type

[**MonitorListResponse**](MonitorListResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of monitoring checks. |  -  |
| **401** | Authentication failed. |  -  |


## listTrackedIndicators

> listTrackedIndicators()

List Tracked Indicators

&lt;p&gt;Get a list of all indicators currently being tracked for changes by the authenticated user.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        try {
            apiInstance.listTrackedIndicators();
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#listTrackedIndicators");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **401** | Authentication failed. |  -  |
| **200** | List of tracked indicators. |  -  |


## scheduleScreenshot

> JobResponse scheduleScreenshot(screenshotRequest)

Schedule Recurring Screenshots (Asynchronous)

&lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Retention:&lt;/b&gt; Auto-cleanup old screenshots (default: keep last 30)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        ScreenshotRequest screenshotRequest = new ScreenshotRequest(); // ScreenshotRequest | Schedule configuration including URL, schedule timing, and screenshot options.
        try {
            JobResponse result = apiInstance.scheduleScreenshot(screenshotRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#scheduleScreenshot");
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
| **screenshotRequest** | [**ScreenshotRequest**](ScreenshotRequest.md)| Schedule configuration including URL, schedule timing, and screenshot options. | |

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
| **202** | Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid schedule configuration or missing required fields. |  -  |


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
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        SearchRequest searchRequest = new SearchRequest(); // SearchRequest | The search query and configuration.
        try {
            JobResponse result = apiInstance.searchIndicators(searchRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#searchIndicators");
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
| **400** | Invalid search query or parameters. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **429** | Rate limit exceeded for search operations. |  -  |
| **202** | Search job successfully accepted. |  -  |


## similarDomains

> JobResponse similarDomains(similarDomainsOpsRequest)

Find Similar Domains (Asynchronous)

&lt;p&gt;Generates potential lookalike, typosquatting, and homoglyph domains for brand protection and threat hunting.&lt;/p&gt; &lt;h4&gt;Detection Methods:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Typosquatting (keyboard proximity)&lt;/li&gt;     &lt;li&gt;Homoglyph attacks (visually similar characters)&lt;/li&gt;     &lt;li&gt;Combosquatting (brand + keyword)&lt;/li&gt;     &lt;li&gt;TLD variations&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds depending on options.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        SimilarDomainsOpsRequest similarDomainsOpsRequest = new SimilarDomainsOpsRequest(); // SimilarDomainsOpsRequest | Similar domains request with domain and options.
        try {
            JobResponse result = apiInstance.similarDomains(similarDomainsOpsRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#similarDomains");
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

[**JobResponse**](JobResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | Invalid domain or options. |  -  |
| **202** | Similar domains job created successfully. |  -  |
| **401** | Authentication failed. |  -  |


## startChangeTracking

> JobResponse startChangeTracking(type, value, changeTrackingRequest)

Start Change Tracking

&lt;p&gt;Start tracking changes for an IP or domain. When tracking is started, a baseline snapshot is captured. Subsequent checks will compare against this baseline and record any detected changes.&lt;/p&gt; &lt;h4&gt;Trackable Fields for Domains:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT, CNAME records&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, dates, nameservers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate issuer, expiry, SAN&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Discovered subdomains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ips:&lt;/b&gt; Resolved IP addresses&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Trackable Fields for IPs:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;geolocation:&lt;/b&gt; Country, city, coordinates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;asn:&lt;/b&gt; ASN number, organization&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;rpki:&lt;/b&gt; RPKI validation status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reverse_dns:&lt;/b&gt; PTR records&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequencies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;hourly:&lt;/b&gt; Check every hour&lt;/li&gt;     &lt;li&gt;&lt;b&gt;daily:&lt;/b&gt; Check once per day (default)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;weekly:&lt;/b&gt; Check once per week&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String type = "domain"; // String | Indicator type: ip or domain
        String value = "google.com"; // String | Indicator value (IP address or domain name)
        ChangeTrackingRequest changeTrackingRequest = new ChangeTrackingRequest(); // ChangeTrackingRequest | Tracking configuration
        try {
            JobResponse result = apiInstance.startChangeTracking(type, value, changeTrackingRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#startChangeTracking");
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
| **type** | **String**| Indicator type: ip or domain | |
| **value** | **String**| Indicator value (IP address or domain name) | |
| **changeTrackingRequest** | [**ChangeTrackingRequest**](ChangeTrackingRequest.md)| Tracking configuration | |

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
| **400** | Invalid indicator type or fields. |  -  |
| **202** | Tracking started. Job ID returned for baseline capture. |  -  |
| **401** | Authentication failed. |  -  |


## stopChangeTracking

> stopChangeTracking(type, value, deleteHistory)

Stop Change Tracking

&lt;p&gt;Stop tracking changes for an indicator. Optionally delete all change history.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String type = "type_example"; // String | Indicator type: ip or domain
        String value = "value_example"; // String | Indicator value
        Boolean deleteHistory = false; // Boolean | Delete change history as well
        try {
            apiInstance.stopChangeTracking(type, value, deleteHistory);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#stopChangeTracking");
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
| **type** | **String**| Indicator type: ip or domain | |
| **value** | **String**| Indicator value | |
| **deleteHistory** | **Boolean**| Delete change history as well | [optional] [default to false] |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **401** | Authentication failed. |  -  |
| **204** | Tracking stopped successfully. |  -  |


## triggerCheck

> JobResponse triggerCheck(type, value)

Trigger Immediate Check

&lt;p&gt;Trigger an immediate check for changes on a tracked indicator. Creates a job to compare current data against the stored baseline.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String type = "type_example"; // String | Indicator type
        String value = "value_example"; // String | Indicator value
        try {
            JobResponse result = apiInstance.triggerCheck(type, value);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#triggerCheck");
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
| **type** | **String**| Indicator type | |
| **value** | **String**| Indicator value | |

### Return type

[**JobResponse**](JobResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **401** | Authentication failed. |  -  |
| **202** | Check triggered. Job ID returned. |  -  |
| **404** | Indicator is not being tracked. |  -  |


## triggerMonitorCheck

> triggerMonitorCheck(checkId)

Trigger Manual Check

Trigger an immediate execution of a monitoring check.

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        try {
            apiInstance.triggerMonitorCheck(checkId);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#triggerMonitorCheck");
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
| **checkId** | **String**| Check ID | |

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
| **404** | Check not found or access denied. |  -  |
| **202** | Check triggered successfully. |  -  |
| **401** | Authentication failed. |  -  |


## updateMonitorCheck

> MonitorCheckResponse updateMonitorCheck(checkId, monitorCheckRequest)

Update Monitoring Check

Update an existing monitoring check configuration.

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.OperationsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        MonitorCheckRequest monitorCheckRequest = new MonitorCheckRequest(); // MonitorCheckRequest | Updated check configuration
        try {
            MonitorCheckResponse result = apiInstance.updateMonitorCheck(checkId, monitorCheckRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#updateMonitorCheck");
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
| **checkId** | **String**| Check ID | |
| **monitorCheckRequest** | [**MonitorCheckRequest**](MonitorCheckRequest.md)| Updated check configuration | |

### Return type

[**MonitorCheckResponse**](MonitorCheckResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Check updated successfully. |  -  |
| **404** | Check not found or access denied. |  -  |
| **401** | Authentication failed. |  -  |

