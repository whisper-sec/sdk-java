# AiIntelligenceApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**aiAttribute**](AiIntelligenceApi.md#aiAttribute) | **POST** /v1/ops/ai/attribute | Threat Actor Attribution (Asynchronous) |
| [**aiCorrelate**](AiIntelligenceApi.md#aiCorrelate) | **POST** /v1/ops/ai/correlate | Global Indicator Correlation (Asynchronous) |
| [**aiInvestigate**](AiIntelligenceApi.md#aiInvestigate) | **POST** /v1/ops/ai/investigate | AI Threat Investigation (Asynchronous) |
| [**aiPivot**](AiIntelligenceApi.md#aiPivot) | **POST** /v1/ops/ai/pivot | AI Infrastructure Pivot (Asynchronous) |
| [**findSimilarCases**](AiIntelligenceApi.md#findSimilarCases) | **POST** /v1/ops/ai/similar-cases | Find Similar Cases (Asynchronous) |
| [**getIndustryBenchmark**](AiIntelligenceApi.md#getIndustryBenchmark) | **GET** /v1/ops/ai/benchmark/{industry} | Get Industry Security Benchmark (Synchronous) |



## aiAttribute

> AttributeResult aiAttribute(attributeRequest)

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
import io.github.whispersec.api.AiIntelligenceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        AiIntelligenceApi apiInstance = new AiIntelligenceApi(defaultClient);
        AttributeRequest attributeRequest = new AttributeRequest(); // AttributeRequest | Attribution request
        try {
            AttributeResult result = apiInstance.aiAttribute(attributeRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AiIntelligenceApi#aiAttribute");
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

[**AttributeResult**](AttributeResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Attribution analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results. |  -  |
| **200** | Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes) |  -  |
| **400** | Invalid request or exceeds 500 indicator limit. |  -  |
| **401** | Authentication failed. |  -  |


## aiCorrelate

> CorrelateResult aiCorrelate(correlateRequest)

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
import io.github.whispersec.api.AiIntelligenceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        AiIntelligenceApi apiInstance = new AiIntelligenceApi(defaultClient);
        CorrelateRequest correlateRequest = new CorrelateRequest(); // CorrelateRequest | Correlation request
        try {
            CorrelateResult result = apiInstance.aiCorrelate(correlateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AiIntelligenceApi#aiCorrelate");
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

[**CorrelateResult**](CorrelateResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Correlation job accepted. Poll GET /v1/ops/jobs/{jobId} for results. |  -  |
| **200** | Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes) |  -  |
| **400** | Invalid request or exceeds 100 indicator limit. |  -  |
| **401** | Authentication failed. |  -  |


## aiInvestigate

> InvestigateResult aiInvestigate(investigateRequest)

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
import io.github.whispersec.api.AiIntelligenceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        AiIntelligenceApi apiInstance = new AiIntelligenceApi(defaultClient);
        InvestigateRequest investigateRequest = new InvestigateRequest(); // InvestigateRequest | Investigation request. Required fields: - **indicator**: The IP, domain, or hash to investigate - **indicatorType**: Must be \"ip\", \"domain\", or \"hash\"  Optional fields: - **depth**: Investigation depth (\"quick\", \"standard\", \"comprehensive\"). Default: \"standard\" - **context**: Object with optional fields: hypothesis (string), relatedIndicators (array), timeRange (string) 
        try {
            InvestigateResult result = apiInstance.aiInvestigate(investigateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AiIntelligenceApi#aiInvestigate");
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
| **investigateRequest** | [**InvestigateRequest**](InvestigateRequest.md)| Investigation request. Required fields: - **indicator**: The IP, domain, or hash to investigate - **indicatorType**: Must be \&quot;ip\&quot;, \&quot;domain\&quot;, or \&quot;hash\&quot;  Optional fields: - **depth**: Investigation depth (\&quot;quick\&quot;, \&quot;standard\&quot;, \&quot;comprehensive\&quot;). Default: \&quot;standard\&quot; - **context**: Object with optional fields: hypothesis (string), relatedIndicators (array), timeRange (string)  | |

### Return type

[**InvestigateResult**](InvestigateResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Investigation job accepted. Poll GET /v1/ops/jobs/{jobId} for results. |  -  |
| **200** | Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes) |  -  |
| **400** | Invalid request. |  -  |
| **401** | Authentication failed. |  -  |


## aiPivot

> PivotResult aiPivot(pivotRequest)

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
import io.github.whispersec.api.AiIntelligenceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        AiIntelligenceApi apiInstance = new AiIntelligenceApi(defaultClient);
        PivotRequest pivotRequest = new PivotRequest(); // PivotRequest | Pivot request
        try {
            PivotResult result = apiInstance.aiPivot(pivotRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AiIntelligenceApi#aiPivot");
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

[**PivotResult**](PivotResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Pivot analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results. |  -  |
| **200** | Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes) |  -  |
| **400** | Invalid request. |  -  |
| **401** | Authentication failed. |  -  |


## findSimilarCases

> SimilarCasesResult findSimilarCases(similarCasesRequest)

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
import io.github.whispersec.api.AiIntelligenceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        AiIntelligenceApi apiInstance = new AiIntelligenceApi(defaultClient);
        SimilarCasesRequest similarCasesRequest = new SimilarCasesRequest(); // SimilarCasesRequest | Similar cases request
        try {
            SimilarCasesResult result = apiInstance.findSimilarCases(similarCasesRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AiIntelligenceApi#findSimilarCases");
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

[**SimilarCasesResult**](SimilarCasesResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Similar cases search job accepted. Poll GET /v1/ops/jobs/{jobId} for results. |  -  |
| **200** | Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes) |  -  |
| **400** | Invalid request. |  -  |
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
import io.github.whispersec.api.AiIntelligenceApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        AiIntelligenceApi apiInstance = new AiIntelligenceApi(defaultClient);
        String industry = "financial_services"; // String | Industry vertical code
        String size = "small"; // String | Organization size filter. Compares against organizations of similar size.
        String region = "global"; // String | Geographic region filter. Compares against organizations in the same region.
        try {
            BenchmarkResponse result = apiInstance.getIndustryBenchmark(industry, size, region);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AiIntelligenceApi#getIndustryBenchmark");
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
| **size** | **String**| Organization size filter. Compares against organizations of similar size. | [optional] [enum: small, medium, large, enterprise] |
| **region** | **String**| Geographic region filter. Compares against organizations in the same region. | [optional] [enum: global, north_america, europe, asia_pacific, latin_america, middle_east, africa] |

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

