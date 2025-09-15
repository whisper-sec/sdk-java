# DomainManagementApi

All URIs are relative to *https://spider.noctisnet.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**findSubdomains**](DomainManagementApi.md#findSubdomains) | **GET** /domainer/api/domains/subdomains/{baseDomain} | Find subdomains |



## findSubdomains

> DomainerStringListResponse findSubdomains(baseDomain, limit, level)

Find subdomains

Finds domains that are subdomains of the given base domain (e.g., finding &#39;www.example.com&#39; for base &#39;example.com&#39;). Allows filtering by absolute domain level (dot count). NOTE: This differs from relative depth filtering.

### Example

```java
// Import classes:
import com.noctisfrontgraph.sdk.invoker.ApiClient;
import com.noctisfrontgraph.sdk.invoker.ApiException;
import com.noctisfrontgraph.sdk.invoker.Configuration;
import com.noctisfrontgraph.sdk.invoker.auth.*;
import com.noctisfrontgraph.sdk.invoker.models.*;
import com.noctisfrontgraph.sdk.api.DomainManagementApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://spider.noctisnet.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        DomainManagementApi apiInstance = new DomainManagementApi(defaultClient);
        String baseDomain = "example.com"; // String | Base domain name (e.g., example.com)
        Integer limit = 100; // Integer | Maximum number of results
        String level = "ALL"; // String | Level of subdomains to find relative to the base domain (ALL, IMMEDIATE=one level deeper, MAX_DEPTH=deepest found relative to base).
        try {
            DomainerStringListResponse result = apiInstance.findSubdomains(baseDomain, limit, level);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DomainManagementApi#findSubdomains");
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
| **baseDomain** | **String**| Base domain name (e.g., example.com) | |
| **limit** | **Integer**| Maximum number of results | [optional] [default to 100] |
| **level** | **String**| Level of subdomains to find relative to the base domain (ALL, IMMEDIATE&#x3D;one level deeper, MAX_DEPTH&#x3D;deepest found relative to base). | [optional] [enum: ALL, IMMEDIATE, MAX_DEPTH] |

### Return type

[**DomainerStringListResponse**](DomainerStringListResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Subdomains found |  -  |
| **400** | Invalid base domain name |  -  |

