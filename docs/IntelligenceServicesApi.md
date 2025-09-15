# IntelligenceServicesApi

All URIs are relative to *https://spider.noctisnet.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getDomainIntelligence**](IntelligenceServicesApi.md#getDomainIntelligence) | **GET** /intelligence/v1/domain/{domain} | Get comprehensive domain intelligence with streaming support |
| [**getIpIntelligence**](IntelligenceServicesApi.md#getIpIntelligence) | **GET** /intelligence/v1/ip/{address} | Get comprehensive IP address intelligence with streaming support |



## getDomainIntelligence

> DomainIntelligenceResponse getDomainIntelligence(domain)

Get comprehensive domain intelligence with streaming support

Analyzes a domain name and returns comprehensive intelligence data from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-5 seconds - **Streaming Mode**: Server-Sent Events with 200ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - WHOIS registration data with ownership history - Complete DNS record enumeration (A, AAAA, MX, NS, TXT, CNAME, SOA) - Subdomain discovery and enumeration - Link analysis showing connected domains - IP intelligence for all resolved addresses - Trademark and brand protection status - Infrastructure relationships and shared hosting  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/domain/example.com &#x60;&#x60;&#x60;  **Streaming Events:** - &#x60;whois&#x60;: Domain registration info - &#x60;dns&#x60;: DNS records - &#x60;subdomains&#x60;: Discovered subdomains - &#x60;ip_intelligence&#x60;: Intelligence for each resolved IP - &#x60;complete&#x60;: Final aggregated data  **Input Processing:** - Automatically strips protocols (http://, https://) - Removes www prefix if present - Validates domain format before processing  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.

### Example

```java
// Import classes:
import com.noctisfrontgraph.sdk.invoker.ApiClient;
import com.noctisfrontgraph.sdk.invoker.ApiException;
import com.noctisfrontgraph.sdk.invoker.Configuration;
import com.noctisfrontgraph.sdk.invoker.auth.*;
import com.noctisfrontgraph.sdk.invoker.models.*;
import com.noctisfrontgraph.sdk.api.IntelligenceServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://spider.noctisnet.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IntelligenceServicesApi apiInstance = new IntelligenceServicesApi(defaultClient);
        String domain = "domain_example"; // String | Domain name to analyze. Can be a root domain or subdomain. Protocol and www prefix are automatically removed.
        try {
            DomainIntelligenceResponse result = apiInstance.getDomainIntelligence(domain);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IntelligenceServicesApi#getDomainIntelligence");
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
| **domain** | **String**| Domain name to analyze. Can be a root domain or subdomain. Protocol and www prefix are automatically removed. | |

### Return type

[**DomainIntelligenceResponse**](DomainIntelligenceResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Domain intelligence data successfully retrieved |  * X-RateLimit-Limit - Number of requests allowed per hour <br>  |
| **400** | Invalid domain name format |  -  |
| **401** | Authentication required |  -  |
| **404** | Domain not found or unregistered |  -  |
| **429** | Rate limit exceeded |  -  |
| **500** | Internal server error during intelligence aggregation |  -  |


## getIpIntelligence

> IpIntelligenceResponse getIpIntelligence(address)

Get comprehensive IP address intelligence with streaming support

Analyzes an IP address and returns comprehensive intelligence data aggregated from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-3 seconds - **Streaming Mode**: Server-Sent Events with 150ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - Geolocation with city-level precision and confidence scores - Network topology including ASN, BGP prefixes, and routing visibility - ISP and organization identification - DNS relationships showing associated domains - Risk scoring based on threat intelligence feeds - RPKI validation and routing security assessment - Historical routing data and stability metrics  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/ip/8.8.8.8 &#x60;&#x60;&#x60;  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.

### Example

```java
// Import classes:
import com.noctisfrontgraph.sdk.invoker.ApiClient;
import com.noctisfrontgraph.sdk.invoker.ApiException;
import com.noctisfrontgraph.sdk.invoker.Configuration;
import com.noctisfrontgraph.sdk.invoker.auth.*;
import com.noctisfrontgraph.sdk.invoker.models.*;
import com.noctisfrontgraph.sdk.api.IntelligenceServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://spider.noctisnet.com");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        IntelligenceServicesApi apiInstance = new IntelligenceServicesApi(defaultClient);
        String address = "address_example"; // String | IPv4 or IPv6 address to analyze. Supports standard notation (e.g., 192.168.1.1 or 2001:db8::1)
        try {
            IpIntelligenceResponse result = apiInstance.getIpIntelligence(address);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IntelligenceServicesApi#getIpIntelligence");
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
| **address** | **String**| IPv4 or IPv6 address to analyze. Supports standard notation (e.g., 192.168.1.1 or 2001:db8::1) | |

### Return type

[**IpIntelligenceResponse**](IpIntelligenceResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | IP intelligence data successfully retrieved |  * X-RateLimit-Limit - Number of requests allowed per hour <br>  * X-RateLimit-Remaining - Number of requests remaining <br>  |
| **400** | Invalid IP address format |  -  |
| **401** | Authentication required |  -  |
| **404** | IP address not found or private/reserved |  -  |
| **429** | Rate limit exceeded |  * Retry-After - Number of seconds to wait before retrying <br>  |
| **500** | Internal server error during intelligence aggregation |  -  |

