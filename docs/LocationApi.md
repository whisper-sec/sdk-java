# LocationApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getBulkIpLocation**](LocationApi.md#getBulkIpLocation) | **POST** /v1/location/ips/bulk | Bulk IP Geolocation Lookup |
| [**getIpLocation**](LocationApi.md#getIpLocation) | **GET** /v1/location/ip/{ip} | Get IP Geolocation and ASN Data |
| [**getLocationStats**](LocationApi.md#getLocationStats) | **GET** /v1/location/stats | Get Geolocation Database Statistics |
| [**getNetworkLocation**](LocationApi.md#getNetworkLocation) | **GET** /v1/location/network | Get Network/CIDR Geolocation Data |
| [**searchLocation**](LocationApi.md#searchLocation) | **GET** /v1/location/search | Search Geolocation Database by Field |



## getBulkIpLocation

> getBulkIpLocation(bulkIpLocationRequest)

Bulk IP Geolocation Lookup

&lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON object with an &lt;code&gt;ips&lt;/code&gt; array:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{\&quot;ips\&quot;: [\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]}&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 2-5 seconds for small batches (1-10 IPs), 5-15 seconds for larger batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with concurrency of 10&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects, one for each requested IP:&lt;/p&gt; &lt;p&gt;&lt;b&gt;Successful lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;queriedIp&lt;/code&gt;: The IP address that was looked up (for correlation)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;country&lt;/code&gt;: Object with &lt;code&gt;isoCode&lt;/code&gt; (e.g., \&quot;US\&quot;), &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;United States\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;city&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;Mountain View\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;location&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt;, &lt;code&gt;timeZone&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt;, &lt;code&gt;organization&lt;/code&gt;, &lt;code&gt;asn&lt;/code&gt;, &lt;code&gt;asnOrganization&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;coordinates&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt; (convenience field)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;traits&lt;/code&gt;: Object with &lt;code&gt;userType&lt;/code&gt; (e.g., \&quot;hosting\&quot;, \&quot;residential\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;p&gt;&lt;b&gt;Failed lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;ip&lt;/code&gt;: The IP address that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: Always &lt;code&gt;true&lt;/code&gt; for failed lookups&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description (e.g., \&quot;Invalid IP address format\&quot;, \&quot;Location data not available for private IP addresses\&quot;, \&quot;Location data not available for reserved/bogon IP addresses\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 

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
        BulkIpLocationRequest bulkIpLocationRequest = new BulkIpLocationRequest(); // BulkIpLocationRequest | List of IP addresses to lookup. Maximum 1000 IPs per request.
        try {
            apiInstance.getBulkIpLocation(bulkIpLocationRequest);
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
| **bulkIpLocationRequest** | [**BulkIpLocationRequest**](BulkIpLocationRequest.md)| List of IP addresses to lookup. Maximum 1000 IPs per request. | |

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
| **200** | Successfully retrieved bulk geolocation data. Returns an array of geolocation objects or error objects for each IP. |  -  |
| **400** | Invalid request format. Missing or empty &#39;ips&#39; field, or array exceeds 1000 IP limit. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **429** | Rate limit exceeded for bulk operations. |  -  |


## getIpLocation

> IpGeolocationResponse getIpLocation(ip)

Get IP Geolocation and ASN Data

&lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; IPv6 addresses are not currently supported. Please use IPv4 addresses only.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 

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
        String ip = "8.8.8.8"; // String | The IPv4 address to lookup. IPv6 is not currently supported.
        try {
            IpGeolocationResponse result = apiInstance.getIpLocation(ip);
            System.out.println(result);
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
| **ip** | **String**| The IPv4 address to lookup. IPv6 is not currently supported. | |

### Return type

[**IpGeolocationResponse**](IpGeolocationResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved geolocation data. |  -  |
| **400** | Invalid IP address format. The provided value is not a valid IPv4 or IPv6 address. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | IP address not found in geolocation database. This may occur for reserved or private IP ranges. |  -  |
| **429** | Rate limit exceeded. Standard limit is 100 requests per minute. |  -  |


## getLocationStats

> getLocationStats()

Get Geolocation Database Statistics

&lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; This endpoint aggregates data from the entire database and may take 5-10 seconds to respond. Consider caching results on your end for repeated access.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 

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
| **200** | Successfully retrieved database statistics. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |


## getNetworkLocation

> getNetworkLocation(cidr)

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
        String cidr = "8.8.8.0/24"; // String | The network range in CIDR notation (e.g., 8.8.8.0/24 or 2001:db8::/32).
        try {
            apiInstance.getNetworkLocation(cidr);
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
| **cidr** | **String**| The network range in CIDR notation (e.g., 8.8.8.0/24 or 2001:db8::/32). | |

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
| **200** | Successfully retrieved network geolocation data. |  -  |
| **400** | Invalid CIDR format or network specification. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Network not found in geolocation database. |  -  |


## searchLocation

> searchLocation(field, value, limit)

Search Geolocation Database by Field

&lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Limiting:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Use the &lt;code&gt;limit&lt;/code&gt; parameter to control the number of results (max 1000, default 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Note:&lt;/b&gt; Pagination is not currently supported. Use smaller &lt;code&gt;limit&lt;/code&gt; values for faster responses.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;totalHits&lt;/code&gt;: Total number of matching records in the database&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of matching IP records (up to &lt;code&gt;limit&lt;/code&gt;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;timeTakenMs&lt;/code&gt;: Query execution time in milliseconds&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 

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
        String limit = "100"; // String | Maximum number of results to return (1-1000). Default: 100. Note: Pagination is not currently supported - use smaller limits for faster responses.
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
| **limit** | **String**| Maximum number of results to return (1-1000). Default: 100. Note: Pagination is not currently supported - use smaller limits for faster responses. | [optional] |

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
| **200** | Successfully retrieved search results. |  -  |
| **400** | Invalid search field or parameters. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **429** | Rate limit exceeded for search operations. |  -  |

