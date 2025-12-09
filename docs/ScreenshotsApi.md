# ScreenshotsApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**clearScreenshotHistory**](ScreenshotsApi.md#clearScreenshotHistory) | **DELETE** /v1/ops/screenshots/schedules/{scheduleId}/history | Clear Screenshot History |
| [**createScreenshot**](ScreenshotsApi.md#createScreenshot) | **POST** /v1/ops/screenshots/capture | Capture a Website Screenshot (Asynchronous) |
| [**deleteScreenshotSchedule**](ScreenshotsApi.md#deleteScreenshotSchedule) | **DELETE** /v1/ops/screenshots/schedules/{scheduleId} | Delete Screenshot Schedule |
| [**getScreenshotHistory**](ScreenshotsApi.md#getScreenshotHistory) | **GET** /v1/ops/screenshots/history | Get Screenshot History |
| [**getScreenshotSchedule**](ScreenshotsApi.md#getScreenshotSchedule) | **GET** /v1/ops/screenshots/schedules/{scheduleId} | Get Screenshot Schedule Details |
| [**listScreenshotSchedules**](ScreenshotsApi.md#listScreenshotSchedules) | **GET** /v1/ops/screenshots/schedules | List Screenshot Schedules |
| [**scheduleScreenshot**](ScreenshotsApi.md#scheduleScreenshot) | **POST** /v1/ops/screenshots/schedule | Schedule Recurring Screenshots (Asynchronous) |



## clearScreenshotHistory

> Object clearScreenshotHistory(scheduleId)

Clear Screenshot History

&lt;p&gt;Delete all captured screenshots for a schedule while keeping the schedule active.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All screenshots will be permanently deleted.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.ScreenshotsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ScreenshotsApi apiInstance = new ScreenshotsApi(defaultClient);
        String scheduleId = "sched_abc123"; // String | The schedule ID
        try {
            Object result = apiInstance.clearScreenshotHistory(scheduleId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenshotsApi#clearScreenshotHistory");
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
| **scheduleId** | **String**| The schedule ID | |

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
| **200** | Screenshot history successfully cleared. |  -  |
| **404** | Schedule not found or does not belong to your API key. |  -  |


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
import io.github.whispersec.api.ScreenshotsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ScreenshotsApi apiInstance = new ScreenshotsApi(defaultClient);
        ScreenshotRequest screenshotRequest = new ScreenshotRequest(); // ScreenshotRequest | The URL and options for the screenshot capture.
        try {
            JobResponse result = apiInstance.createScreenshot(screenshotRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenshotsApi#createScreenshot");
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
| **202** | Screenshot job successfully accepted. |  -  |
| **400** | Invalid URL or options provided. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **429** | Rate limit exceeded. |  -  |


## deleteScreenshotSchedule

> Object deleteScreenshotSchedule(scheduleId)

Delete Screenshot Schedule

&lt;p&gt;Delete a scheduled screenshot configuration and optionally all its captured screenshots.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All associated screenshots will be permanently deleted.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.ScreenshotsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ScreenshotsApi apiInstance = new ScreenshotsApi(defaultClient);
        String scheduleId = "sched_abc123"; // String | The schedule ID to delete
        try {
            Object result = apiInstance.deleteScreenshotSchedule(scheduleId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenshotsApi#deleteScreenshotSchedule");
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
| **scheduleId** | **String**| The schedule ID to delete | |

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
| **200** | Schedule successfully deleted. |  -  |
| **404** | Schedule not found or does not belong to your API key. |  -  |


## getScreenshotHistory

> ScreenshotHistoryResponse getScreenshotHistory(target, limit)

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
import io.github.whispersec.api.ScreenshotsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ScreenshotsApi apiInstance = new ScreenshotsApi(defaultClient);
        String target = "example.com"; // String | The target domain or URL to retrieve screenshot history for.
        Integer limit = 10; // Integer | Maximum number of screenshots to return.
        try {
            ScreenshotHistoryResponse result = apiInstance.getScreenshotHistory(target, limit);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenshotsApi#getScreenshotHistory");
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

[**ScreenshotHistoryResponse**](ScreenshotHistoryResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved screenshot history. |  -  |
| **400** | Invalid URL parameter. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | No screenshots found for the specified URL. |  -  |


## getScreenshotSchedule

> ScreenshotSchedule getScreenshotSchedule(scheduleId)

Get Screenshot Schedule Details

&lt;p&gt;Retrieve details for a specific screenshot schedule including configuration and capture history.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.ScreenshotsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ScreenshotsApi apiInstance = new ScreenshotsApi(defaultClient);
        String scheduleId = "sched_abc123"; // String | The schedule ID
        try {
            ScreenshotSchedule result = apiInstance.getScreenshotSchedule(scheduleId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenshotsApi#getScreenshotSchedule");
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
| **scheduleId** | **String**| The schedule ID | |

### Return type

[**ScreenshotSchedule**](ScreenshotSchedule.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved schedule details. |  -  |
| **404** | Schedule not found or does not belong to your API key. |  -  |


## listScreenshotSchedules

> ScreenshotScheduleListResponse listScreenshotSchedules()

List Screenshot Schedules

&lt;p&gt;Retrieve all scheduled screenshot configurations for your API key. Each API key can have a maximum of 3 active schedules.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Schedule ID:&lt;/b&gt; Unique identifier for the schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;URL:&lt;/b&gt; Target website being captured&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency:&lt;/b&gt; How often screenshots are taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Next Capture:&lt;/b&gt; When the next screenshot will be taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Count:&lt;/b&gt; Total screenshots taken by this schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Status:&lt;/b&gt; Whether the schedule is enabled or paused&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.ScreenshotsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ScreenshotsApi apiInstance = new ScreenshotsApi(defaultClient);
        try {
            ScreenshotScheduleListResponse result = apiInstance.listScreenshotSchedules();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenshotsApi#listScreenshotSchedules");
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

[**ScreenshotScheduleListResponse**](ScreenshotScheduleListResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved schedule list. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |


## scheduleScreenshot

> JobResponse scheduleScreenshot(screenshotRequest)

Schedule Recurring Screenshots (Asynchronous)

&lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, every_6_hours, every_12_hours, twice_daily, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling (default: UTC)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;First Screenshot:&lt;/h4&gt; &lt;p&gt;The &lt;b&gt;first screenshot is captured immediately&lt;/b&gt; when a schedule is created. Subsequent screenshots follow the configured schedule. This ensures you have baseline data right away.&lt;/p&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Retention:&lt;/b&gt; Individual screenshots expire after 14 days&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First Screenshot:&lt;/b&gt; Triggered immediately on schedule creation&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Management:&lt;/h4&gt; &lt;p&gt;Use &lt;code&gt;GET /v1/ops/screenshots/schedules&lt;/code&gt; to list schedules, &lt;code&gt;DELETE /v1/ops/screenshots/schedules/{id}&lt;/code&gt; to delete.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.ScreenshotsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ScreenshotsApi apiInstance = new ScreenshotsApi(defaultClient);
        ScreenshotRequest screenshotRequest = new ScreenshotRequest(); // ScreenshotRequest | Schedule configuration including URL, schedule timing, and screenshot options.
        try {
            JobResponse result = apiInstance.scheduleScreenshot(screenshotRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenshotsApi#scheduleScreenshot");
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
| **400** | Invalid schedule configuration or missing required fields. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |

