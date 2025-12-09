# ChangeTrackingApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getChanges**](ChangeTrackingApi.md#getChanges) | **GET** /v1/ops/tracking/{type}/{value} | Get Detected Changes |
| [**listTrackedIndicators**](ChangeTrackingApi.md#listTrackedIndicators) | **GET** /v1/ops/tracking | List Tracked Indicators |
| [**startChangeTracking**](ChangeTrackingApi.md#startChangeTracking) | **POST** /v1/ops/tracking/{type}/{value} | Start Change Tracking |
| [**stopChangeTracking**](ChangeTrackingApi.md#stopChangeTracking) | **DELETE** /v1/ops/tracking/{type}/{value} | Stop Change Tracking |
| [**triggerCheck**](ChangeTrackingApi.md#triggerCheck) | **POST** /v1/ops/tracking/{type}/{value}/check | Trigger Immediate Check |



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
import io.github.whispersec.api.ChangeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ChangeTrackingApi apiInstance = new ChangeTrackingApi(defaultClient);
        String type = "domain"; // String | Indicator type: ip or domain
        String value = "google.com"; // String | Indicator value
        String since = "2025-01-01T00:00:00Z"; // String | ISO 8601 timestamp to get changes from
        try {
            ChangeTrackingResponse result = apiInstance.getChanges(type, value, since);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChangeTrackingApi#getChanges");
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
| **200** | Successfully retrieved changes. |  -  |
| **404** | Indicator is not being tracked. |  -  |
| **401** | Authentication failed. |  -  |


## listTrackedIndicators

> TrackedIndicatorsResponse listTrackedIndicators()

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
import io.github.whispersec.api.ChangeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ChangeTrackingApi apiInstance = new ChangeTrackingApi(defaultClient);
        try {
            TrackedIndicatorsResponse result = apiInstance.listTrackedIndicators();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChangeTrackingApi#listTrackedIndicators");
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

[**TrackedIndicatorsResponse**](TrackedIndicatorsResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of tracked indicators. |  -  |
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
import io.github.whispersec.api.ChangeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ChangeTrackingApi apiInstance = new ChangeTrackingApi(defaultClient);
        String type = "domain"; // String | Indicator type: ip or domain
        String value = "google.com"; // String | Indicator value (IP address or domain name)
        ChangeTrackingRequest changeTrackingRequest = new ChangeTrackingRequest(); // ChangeTrackingRequest | Tracking configuration
        try {
            JobResponse result = apiInstance.startChangeTracking(type, value, changeTrackingRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChangeTrackingApi#startChangeTracking");
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
| **202** | Tracking started. Job ID returned for baseline capture. |  -  |
| **400** | Invalid indicator type or fields. |  -  |
| **401** | Authentication failed. |  -  |


## stopChangeTracking

> GenericSuccessResponse stopChangeTracking(type, value, deleteHistory)

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
import io.github.whispersec.api.ChangeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ChangeTrackingApi apiInstance = new ChangeTrackingApi(defaultClient);
        String type = "type_example"; // String | Indicator type: ip or domain
        String value = "value_example"; // String | Indicator value
        Boolean deleteHistory = false; // Boolean | Delete change history as well
        try {
            GenericSuccessResponse result = apiInstance.stopChangeTracking(type, value, deleteHistory);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChangeTrackingApi#stopChangeTracking");
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

[**GenericSuccessResponse**](GenericSuccessResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tracking stopped successfully. |  -  |
| **401** | Authentication failed. |  -  |
| **500** | Internal server error. |  -  |


## triggerCheck

> GenericSuccessResponse triggerCheck(type, value)

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
import io.github.whispersec.api.ChangeTrackingApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ChangeTrackingApi apiInstance = new ChangeTrackingApi(defaultClient);
        String type = "domain"; // String | Indicator type
        String value = "google.com"; // String | Indicator value
        try {
            GenericSuccessResponse result = apiInstance.triggerCheck(type, value);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChangeTrackingApi#triggerCheck");
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
| **400** | Invalid indicator type. |  -  |
| **404** | Indicator is not being tracked. |  -  |
| **401** | Authentication failed. |  -  |

