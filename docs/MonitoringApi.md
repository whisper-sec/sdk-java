# MonitoringApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createMonitorCheck**](MonitoringApi.md#createMonitorCheck) | **POST** /v1/ops/monitoring | Create Monitoring Check |
| [**createMonitoringAlert**](MonitoringApi.md#createMonitoringAlert) | **POST** /v1/ops/monitoring/{target}/alert | Configure Monitoring Alert |
| [**deleteMonitorCheck**](MonitoringApi.md#deleteMonitorCheck) | **DELETE** /v1/ops/monitoring/{checkId} | Delete Monitoring Check |
| [**getMonitorCheck**](MonitoringApi.md#getMonitorCheck) | **GET** /v1/ops/monitoring/{checkId} | Get Monitoring Check |
| [**getMonitorDashboard**](MonitoringApi.md#getMonitorDashboard) | **GET** /v1/ops/monitoring/dashboard | Get Monitoring Dashboard |
| [**getMonitorResults**](MonitoringApi.md#getMonitorResults) | **GET** /v1/ops/monitoring/{checkId}/results | Get Check Results |
| [**getMonitoringStatus**](MonitoringApi.md#getMonitoringStatus) | **GET** /v1/ops/monitoring/status/{target} | Get Monitoring Status |
| [**listMonitorChecks**](MonitoringApi.md#listMonitorChecks) | **GET** /v1/ops/monitoring | List Monitoring Checks |
| [**triggerMonitorCheck**](MonitoringApi.md#triggerMonitorCheck) | **POST** /v1/ops/monitoring/{checkId}/trigger | Trigger Manual Check |
| [**updateMonitorCheck**](MonitoringApi.md#updateMonitorCheck) | **PUT** /v1/ops/monitoring/{checkId} | Update Monitoring Check |



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
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        MonitorCheckRequest monitorCheckRequest = new MonitorCheckRequest(); // MonitorCheckRequest | Monitoring check configuration
        try {
            MonitorCheckResponse result = apiInstance.createMonitorCheck(monitorCheckRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#createMonitorCheck");
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

Configure Monitoring Alert

&lt;p&gt;Configure alert notifications for a monitored target. Set up notifications for downtime, SSL expiry, DNS changes, and more.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Alert when target becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; Alert when DNS records change&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Alert when WHOIS data changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Alert when SSL certificate is expiring (within threshold days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Alert when page content changes significantly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Alert when detected technologies change&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;email:&lt;/b&gt; Send alerts via email&lt;/li&gt;     &lt;li&gt;&lt;b&gt;slack:&lt;/b&gt; Post to Slack webhook&lt;/li&gt;     &lt;li&gt;&lt;b&gt;webhook:&lt;/b&gt; POST to custom webhook URL&lt;/li&gt;     &lt;li&gt;&lt;b&gt;pagerduty:&lt;/b&gt; Create PagerDuty incident&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        String target = "example.com"; // String | The domain or IP address to configure alerts for.
        MonitoringAlertRequest monitoringAlertRequest = new MonitoringAlertRequest(); // MonitoringAlertRequest | Alert configuration including type, thresholds, and notification channels.
        try {
            JobResponse result = apiInstance.createMonitoringAlert(target, monitoringAlertRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#createMonitoringAlert");
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
| **202** | Alert configuration job accepted. |  -  |
| **400** | Invalid alert configuration. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |


## deleteMonitorCheck

> Object deleteMonitorCheck(checkId)

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
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        try {
            Object result = apiInstance.deleteMonitorCheck(checkId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#deleteMonitorCheck");
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

**Object**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Check deleted successfully. |  -  |
| **404** | Check not found or access denied. |  -  |
| **401** | Authentication failed. |  -  |


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
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        try {
            MonitorCheckResponse result = apiInstance.getMonitorCheck(checkId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#getMonitorCheck");
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
| **200** | Check details. |  -  |
| **404** | Check not found or access denied. |  -  |
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
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        try {
            MonitorDashboardResponse result = apiInstance.getMonitorDashboard();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#getMonitorDashboard");
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

> MonitorResultListResponse getMonitorResults(checkId, limit)

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
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        Integer limit = 10; // Integer | Maximum number of results to return
        try {
            MonitorResultListResponse result = apiInstance.getMonitorResults(checkId, limit);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#getMonitorResults");
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

[**MonitorResultListResponse**](MonitorResultListResponse.md)

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

> MonitoringStatusResponse getMonitoringStatus(target)

Get Monitoring Status

&lt;p&gt;Get the current monitoring status and metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Metrics Returned:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        String target = "example.com"; // String | The domain or IP address to check monitoring status for.
        try {
            MonitoringStatusResponse result = apiInstance.getMonitoringStatus(target);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#getMonitoringStatus");
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

[**MonitoringStatusResponse**](MonitoringStatusResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved monitoring status. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Target is not being monitored. |  -  |


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
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        String type = "api"; // String | Filter by check type
        String status = "passing"; // String | Filter by status
        try {
            MonitorListResponse result = apiInstance.listMonitorChecks(type, status);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#listMonitorChecks");
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


## triggerMonitorCheck

> GenericSuccessResponse triggerMonitorCheck(checkId)

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
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        try {
            GenericSuccessResponse result = apiInstance.triggerMonitorCheck(checkId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#triggerMonitorCheck");
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

[**GenericSuccessResponse**](GenericSuccessResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Check triggered successfully. |  -  |
| **404** | Check not found or access denied. |  -  |
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
import io.github.whispersec.api.MonitoringApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        MonitoringApi apiInstance = new MonitoringApi(defaultClient);
        String checkId = "abc123"; // String | Check ID
        MonitorCheckRequest monitorCheckRequest = new MonitorCheckRequest(); // MonitorCheckRequest | Updated check configuration
        try {
            MonitorCheckResponse result = apiInstance.updateMonitorCheck(checkId, monitorCheckRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonitoringApi#updateMonitorCheck");
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

