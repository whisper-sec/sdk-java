# GraphDatabaseApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**executeCypherQuery**](GraphDatabaseApi.md#executeCypherQuery) | **POST** /v1/ops/graph/cypher | Execute Cypher Query |
| [**executeGraphQL**](GraphDatabaseApi.md#executeGraphQL) | **POST** /v1/ops/graph/graphql | Execute GraphQL Query |
| [**getGraphiQL**](GraphDatabaseApi.md#getGraphiQL) | **GET** /v1/ops/graph/graphiql | GraphiQL Interactive Explorer |
| [**getHealth**](GraphDatabaseApi.md#getHealth) | **GET** /v1/ops/graph/health | Graph Database Health Check |
| [**getSchema**](GraphDatabaseApi.md#getSchema) | **GET** /v1/ops/graph/schema | Get Graph Schema |



## executeCypherQuery

> CypherQueryResponse executeCypherQuery(authorization, cypherQueryRequest)

Execute Cypher Query

Execute a read-only Cypher query against the FalkorDB graph database.  **Security:** Only read operations (MATCH, RETURN) are allowed. Write operations are blocked.  **Example Queries:** &#x60;&#x60;&#x60;cypher // Find all IPs for a domain MATCH (d:DomainName {name: $domain})-[:hasIP]-&gt;(ip:A_ADDRESS) RETURN ip.name AS ip  // Find domains on blocklists MATCH (d:DomainName)-[:isListed]-&gt;(l:LIST) RETURN d.name, l.name LIMIT 10  // Get ASN and announced prefixes MATCH (asn:ASN {number: 15169})-[:announces]-&gt;(p:ANNOUNCED_PREFIX_4) RETURN p.name AS prefix &#x60;&#x60;&#x60;  **Performance Tips:** - Always use LIMIT to restrict result size - Use parameters for variable values - Filter early in the query with WHERE clauses 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.GraphDatabaseApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        GraphDatabaseApi apiInstance = new GraphDatabaseApi(defaultClient);
        String authorization = "authorization_example"; // String | 
        CypherQueryRequest cypherQueryRequest = new CypherQueryRequest(); // CypherQueryRequest | 
        try {
            CypherQueryResponse result = apiInstance.executeCypherQuery(authorization, cypherQueryRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GraphDatabaseApi#executeCypherQuery");
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
| **authorization** | **String**|  | |
| **cypherQueryRequest** | [**CypherQueryRequest**](CypherQueryRequest.md)|  | |

### Return type

[**CypherQueryResponse**](CypherQueryResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Query executed successfully |  -  |
| **400** | Invalid query syntax |  -  |
| **401** | Authentication required |  -  |
| **500** | Query execution failed |  -  |


## executeGraphQL

> executeGraphQL(authorization, graphQLRequest)

Execute GraphQL Query

Execute a GraphQL query against the graph database.  GraphQL provides a type-safe, structured alternative to Cypher for querying the graph data.  **Available Query Operations:** - &#x60;domain(name: String!)&#x60; - Look up domain information - &#x60;ipv4(address: String!)&#x60; - Look up IPv4 address information - &#x60;ipv6(address: String!)&#x60; - Look up IPv6 address information - &#x60;asn(number: Int!)&#x60; - Look up ASN information - &#x60;searchDomains(pattern: String!, limit: Int)&#x60; - Search domains by pattern - &#x60;domainsOnIP(address: String!)&#x60; - Find domains on an IP - &#x60;domainsOnASN(asnNumber: Int!, limit: Int)&#x60; - Find domains on an ASN - &#x60;checkIndicator(indicator: String!)&#x60; - Check if indicator is listed  **Example Query:** &#x60;&#x60;&#x60;graphql {   domain(name: \&quot;google.com\&quot;) {     name     ipAddresses {       address       country { code }     }     nameservers { name }     asns { number }   } } &#x60;&#x60;&#x60;  Use the &#x60;/v1/ops/graph/graphiql&#x60; endpoint for an interactive query explorer with schema documentation. 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.GraphDatabaseApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        GraphDatabaseApi apiInstance = new GraphDatabaseApi(defaultClient);
        String authorization = "authorization_example"; // String | 
        GraphQLRequest graphQLRequest = new GraphQLRequest(); // GraphQLRequest | 
        try {
            apiInstance.executeGraphQL(authorization, graphQLRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling GraphDatabaseApi#executeGraphQL");
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
| **authorization** | **String**|  | |
| **graphQLRequest** | [**GraphQLRequest**](GraphQLRequest.md)|  | |

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
| **200** | Query executed successfully |  -  |
| **400** | Invalid query syntax |  -  |
| **401** | Authentication required |  -  |


## getGraphiQL

> getGraphiQL()

GraphiQL Interactive Explorer

Access the GraphiQL interactive query explorer.  GraphiQL provides: - Interactive query editor with syntax highlighting - Auto-complete for types and fields - Schema documentation browser - Query history  **No authentication required** - the UI itself is public, but queries still require a valid API key. 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.GraphDatabaseApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        GraphDatabaseApi apiInstance = new GraphDatabaseApi(defaultClient);
        try {
            apiInstance.getGraphiQL();
        } catch (ApiException e) {
            System.err.println("Exception when calling GraphDatabaseApi#getGraphiQL");
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
- **Accept**: text/html


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | GraphiQL HTML page |  -  |


## getHealth

> Object getHealth()

Graph Database Health Check

Check the health and connectivity of the graph database.  **No authentication required** - this is a public health endpoint.  Returns database status, connection info, and basic statistics. 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.GraphDatabaseApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        GraphDatabaseApi apiInstance = new GraphDatabaseApi(defaultClient);
        try {
            Object result = apiInstance.getHealth();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GraphDatabaseApi#getHealth");
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

**Object**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Health status retrieved |  -  |


## getSchema

> CypherSchemaResponse getSchema(authorization)

Get Graph Schema

Retrieve the graph database schema including available node labels, relationship types, and their properties.  Use this to discover what data is available for querying before writing Cypher or GraphQL queries.  **Response includes:** - Node labels (e.g., DomainName, A_ADDRESS, ASN) - Relationship types (e.g., hasIP, isListed, announces) - Properties available on each node and relationship type - Graph statistics (node and relationship counts) 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.GraphDatabaseApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        GraphDatabaseApi apiInstance = new GraphDatabaseApi(defaultClient);
        String authorization = "authorization_example"; // String | 
        try {
            CypherSchemaResponse result = apiInstance.getSchema(authorization);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GraphDatabaseApi#getSchema");
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
| **authorization** | **String**|  | |

### Return type

[**CypherSchemaResponse**](CypherSchemaResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Schema retrieved successfully |  -  |
| **401** | Authentication required |  -  |
| **500** | Failed to retrieve schema |  -  |

