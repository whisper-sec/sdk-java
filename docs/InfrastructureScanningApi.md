# InfrastructureScanningApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createInfrastructureMap**](InfrastructureScanningApi.md#createInfrastructureMap) | **POST** /v1/ops/scans/map | Map Infrastructure Relationships (Asynchronous) |
| [**createInfrastructureScan**](InfrastructureScanningApi.md#createInfrastructureScan) | **POST** /v1/ops/scans/infrastructure | Infrastructure Security Scan (Asynchronous) |



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
import io.github.whispersec.api.InfrastructureScanningApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        InfrastructureScanningApi apiInstance = new InfrastructureScanningApi(defaultClient);
        InfrastructureMapRequest infrastructureMapRequest = new InfrastructureMapRequest(); // InfrastructureMapRequest | Mapping configuration. Example: ```json {   \"startPoint\": \"example.com\",   \"depth\": 2 } ``` 
        try {
            JobResponse result = apiInstance.createInfrastructureMap(infrastructureMapRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InfrastructureScanningApi#createInfrastructureMap");
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
| **400** | Invalid starting point or depth (must be 1-3). |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |


## createInfrastructureScan

> JobResponse createInfrastructureScan(scanRequest)

Infrastructure Security Scan (Asynchronous)

&lt;p&gt;Initiates a security scan of a domain&#39;s infrastructure. Performs reconnaissance and configuration analysis.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (subdomains, dns, ssl, technologies, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration and discovery&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS certificate analysis (issuer, validity, expiration, protocol)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record analysis and configuration&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection via headers and NoctisEyes scan&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Domain registration and ownership information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerability:&lt;/b&gt; Dedicated vulnerability scan using NoctisEyes (detects security misconfigurations, exposed services, known CVEs)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 10-30 seconds (ssl, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Medium scans:&lt;/b&gt; 30-60 seconds (subdomains)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Technologies scan:&lt;/b&gt; 2-5 minutes (includes NoctisEyes vulnerability scan)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Vulnerability scan:&lt;/b&gt; 2-5 minutes (dedicated NoctisEyes security scan with severity breakdown)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 3-5 minutes (all modules in parallel)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;SSL certificate monitoring&lt;/li&gt;     &lt;li&gt;Infrastructure inventory&lt;/li&gt;     &lt;li&gt;Vulnerability assessment and security audits&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.InfrastructureScanningApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        InfrastructureScanningApi apiInstance = new InfrastructureScanningApi(defaultClient);
        ScanRequest scanRequest = new ScanRequest(); // ScanRequest | Scan configuration including target domain and scan type.
        try {
            JobResponse result = apiInstance.createInfrastructureScan(scanRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InfrastructureScanningApi#createInfrastructureScan");
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
| **202** | Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results. |  -  |
| **400** | Invalid domain or scan type. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |

