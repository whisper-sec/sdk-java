# OperationsApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createInfrastructureMap**](OperationsApi.md#createInfrastructureMap) | **POST** /v1/ops/map | Map Infrastructure Relationships (Asynchronous) |
| [**createInfrastructureScan**](OperationsApi.md#createInfrastructureScan) | **POST** /v1/ops/scan | Infrastructure Security Scan (Asynchronous) |
| [**createMonitoringAlert**](OperationsApi.md#createMonitoringAlert) | **POST** /v1/ops/monitor/{target}/alert | Configure Monitoring Alerts (Asynchronous) |
| [**createScreenshot**](OperationsApi.md#createScreenshot) | **POST** /v1/ops/screenshot | Capture a Website Screenshot (Asynchronous) |
| [**getChangeDetection**](OperationsApi.md#getChangeDetection) | **GET** /v1/ops/changes/{target} | Get Infrastructure Change History |
| [**getJob**](OperationsApi.md#getJob) | **GET** /v1/ops/jobs/{jobId} | Get Asynchronous Job Status and Results |
| [**getMonitoringStatus**](OperationsApi.md#getMonitoringStatus) | **GET** /v1/ops/monitor/{target} | Get Monitoring Status and Metrics |
| [**getScreenshotHistory**](OperationsApi.md#getScreenshotHistory) | **GET** /v1/ops/screenshot/history | Get Screenshot History |
| [**listJobs**](OperationsApi.md#listJobs) | **GET** /v1/ops/jobs/list | List Recent Jobs |
| [**scheduleScreenshot**](OperationsApi.md#scheduleScreenshot) | **POST** /v1/ops/screenshot/schedule | Schedule Recurring Screenshots (Asynchronous) |
| [**similarDomains**](OperationsApi.md#similarDomains) | **POST** /v1/ops/similar-domains | Find Similar Domains (Asynchronous) |



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
        defaultClient.setBasePath("https://api.whisper.security");
        
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
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid starting point or depth (must be 1-3). |  -  |
| **202** | Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results. |  -  |


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
        defaultClient.setBasePath("https://api.whisper.security");
        
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
| **400** | Invalid domain or scan type. |  -  |
| **202** | Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results. |  -  |


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
        defaultClient.setBasePath("https://api.whisper.security");
        
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
| **400** | Invalid alert configuration. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **202** | Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status. |  -  |


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
        defaultClient.setBasePath("https://api.whisper.security");
        
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
| **429** | Rate limit exceeded. |  -  |
| **400** | Invalid URL or options provided. |  -  |


## getChangeDetection

> getChangeDetection(target, type, since)

Get Infrastructure Change History

&lt;p&gt;Retrieves detected changes in infrastructure configuration for a domain or IP over time. Essential for security monitoring and compliance auditing.&lt;/p&gt; &lt;h4&gt;Change Types Tracked:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT record changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, nameserver changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate replacements and expirations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ip:&lt;/b&gt; IP address changes for domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content:&lt;/b&gt; Homepage content modifications&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology:&lt;/b&gt; Tech stack changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Timeline of changes with before/after values:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;changes\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:30:00Z\&quot;,       \&quot;type\&quot;: \&quot;dns\&quot;,       \&quot;field\&quot;: \&quot;A_RECORD\&quot;,       \&quot;old_value\&quot;: \&quot;8.8.8.8\&quot;,       \&quot;new_value\&quot;: \&quot;1.1.1.1\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Security incident investigation&lt;/li&gt;     &lt;li&gt;Compliance and audit trails&lt;/li&gt;     &lt;li&gt;Detecting unauthorized changes&lt;/li&gt;     &lt;li&gt;Infrastructure change management&lt;/li&gt; &lt;/ul&gt; 

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
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String target = "example.com"; // String | The domain or IP address to check for changes.
        String type = "all"; // String | Type of changes to retrieve.
        String since = "2025-01-01T00:00:00Z"; // String | ISO 8601 timestamp to retrieve changes from. Omit to get all changes.
        try {
            apiInstance.getChangeDetection(target, type, since);
        } catch (ApiException e) {
            System.err.println("Exception when calling OperationsApi#getChangeDetection");
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
| **target** | **String**| The domain or IP address to check for changes. | |
| **type** | **String**| Type of changes to retrieve. | [optional] [enum: all, dns, whois, ssl, ip, content, technology] |
| **since** | **String**| ISO 8601 timestamp to retrieve changes from. Omit to get all changes. | [optional] |

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
| **200** | Successfully retrieved change history. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid change type or date format. |  -  |
| **404** | No changes found for the specified target. |  -  |


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
        defaultClient.setBasePath("https://api.whisper.security");
        
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
| **200** | Job status and results retrieved successfully. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Job ID not found. |  -  |


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
        defaultClient.setBasePath("https://api.whisper.security");
        
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
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **200** | Successfully retrieved monitoring status. |  -  |
| **404** | Target is not being monitored. |  -  |


## getScreenshotHistory

> getScreenshotHistory(url, limit)

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
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        OperationsApi apiInstance = new OperationsApi(defaultClient);
        String url = "https://example.com"; // String | The URL to retrieve screenshot history for.
        Integer limit = 10; // Integer | Maximum number of screenshots to return.
        try {
            apiInstance.getScreenshotHistory(url, limit);
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
| **url** | **String**| The URL to retrieve screenshot history for. | |
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
| **404** | No screenshots found for the specified URL. |  -  |
| **200** | Successfully retrieved screenshot history. |  -  |
| **400** | Invalid URL parameter. |  -  |


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
        defaultClient.setBasePath("https://api.whisper.security");
        
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
| **200** | Successfully retrieved job list. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |


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
        defaultClient.setBasePath("https://api.whisper.security");
        
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
        defaultClient.setBasePath("https://api.whisper.security");
        
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
| **401** | Authentication failed. |  -  |
| **202** | Similar domains job created successfully. |  -  |

