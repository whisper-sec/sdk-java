# LocationApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getBulkIpLocation**](LocationApi.md#getBulkIpLocation) | **POST** /v1/location/ips/bulk | Bulk IP Geolocation Lookup |
| [**getIpLocation**](LocationApi.md#getIpLocation) | **GET** /v1/location/ip/{ip} | Get IP Geolocation and ASN Data |
| [**getLocationStats**](LocationApi.md#getLocationStats) | **GET** /v1/location/stats | Get Geolocation Database Statistics |
| [**getNetworkLocation**](LocationApi.md#getNetworkLocation) | **GET** /v1/location/network/{*network} | Get Network/CIDR Geolocation Data |
| [**searchLocation**](LocationApi.md#searchLocation) | **GET** /v1/location/search | Search Geolocation Database by Field |



## getBulkIpLocation

> getBulkIpLocation(requestBody)

Bulk IP Geolocation Lookup

&lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON array of IP addresses (IPv4 or IPv6):&lt;/p&gt; &lt;pre&gt;&lt;code&gt;[\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 500-2000ms for typical batches (10-100 IPs)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with automatic batching&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects matching the order of input IPs. Failed lookups are indicated with error objects.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.LocationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        LocationApi apiInstance = new LocationApi(defaultClient);
        List<String> requestBody = Arrays.asList(); // List<String> | JSON array of IP addresses to lookup. Maximum 1000 IPs per request.
        try {
            apiInstance.getBulkIpLocation(requestBody);
        } catch (ApiException e) {
            System.err.println("Exception when calling LocationApi#getBulkIpLocation");
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
| **requestBody** | [**List&lt;String&gt;**](String.md)| JSON array of IP addresses to lookup. Maximum 1000 IPs per request. | |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid request format. Expected JSON array of IP addresses, or array exceeds 1000 IP limit. |  -  |
| **200** | Successfully retrieved bulk geolocation data. |  -  |
| **429** | Rate limit exceeded for bulk operations. |  -  |


## getIpLocation

> getIpLocation(ip)

Get IP Geolocation and ASN Data

&lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 or IPv6 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.LocationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        LocationApi apiInstance = new LocationApi(defaultClient);
        String ip = "8.8.8.8"; // String | The IPv4 or IPv6 address to lookup.
        try {
            apiInstance.getIpLocation(ip);
        } catch (ApiException e) {
            System.err.println("Exception when calling LocationApi#getIpLocation");
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
| **ip** | **String**| The IPv4 or IPv6 address to lookup. | |

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
| **200** | Successfully retrieved geolocation data. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **400** | Invalid IP address format. |  -  |
| **429** | Rate limit exceeded. |  -  |
| **404** | IP address not found in geolocation database. |  -  |


## getLocationStats

> getLocationStats()

Get Geolocation Database Statistics

&lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.LocationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        LocationApi apiInstance = new LocationApi(defaultClient);
        try {
            apiInstance.getLocationStats();
        } catch (ApiException e) {
            System.err.println("Exception when calling LocationApi#getLocationStats");
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
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **200** | Successfully retrieved database statistics. |  -  |


## getNetworkLocation

> getNetworkLocation(network)

Get Network/CIDR Geolocation Data

&lt;p&gt;Returns geolocation and network information for an entire network range specified in CIDR notation. Useful for analyzing network blocks, ranges, and subnets.&lt;/p&gt; &lt;h4&gt;Supported Formats:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPv4 CIDR:&lt;/b&gt; 192.168.1.0/24&lt;/li&gt;     &lt;li&gt;&lt;b&gt;IPv6 CIDR:&lt;/b&gt; 2001:db8::/32&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Network Details:&lt;/b&gt; CIDR range, first/last IP, total addresses&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region for the network block&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, organization, ISP information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Network type and usage category&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Analyzing suspicious network ranges&lt;/li&gt;     &lt;li&gt;Bulk geolocation for network blocks&lt;/li&gt;     &lt;li&gt;Infrastructure mapping and reconnaissance&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.LocationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        LocationApi apiInstance = new LocationApi(defaultClient);
        String network = "8.8.8.0/24"; // String | The network range in CIDR notation (e.g., 192.168.1.0/24 or 2001:db8::/32).
        try {
            apiInstance.getNetworkLocation(network);
        } catch (ApiException e) {
            System.err.println("Exception when calling LocationApi#getNetworkLocation");
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
| **network** | **String**| The network range in CIDR notation (e.g., 192.168.1.0/24 or 2001:db8::/32). | |

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
| **400** | Invalid CIDR format or network specification. |  -  |
| **404** | Network not found in geolocation database. |  -  |
| **200** | Successfully retrieved network geolocation data. |  -  |


## searchLocation

> searchLocation(field, value, limit)

Search Geolocation Database by Field

&lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.LocationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        LocationApi apiInstance = new LocationApi(defaultClient);
        String field = "city"; // String | The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude
        String value = "San Francisco"; // String | The value to search for in the specified field.
        Integer limit = 100; // Integer | Maximum number of results to return.
        try {
            apiInstance.searchLocation(field, value, limit);
        } catch (ApiException e) {
            System.err.println("Exception when calling LocationApi#searchLocation");
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
| **field** | **String**| The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude | |
| **value** | **String**| The value to search for in the specified field. | |
| **limit** | **Integer**| Maximum number of results to return. | [optional] [default to 100] |

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
| **429** | Rate limit exceeded for search operations. |  -  |
| **200** | Successfully retrieved search results. |  -  |
| **400** | Invalid search field or parameters. |  -  |

