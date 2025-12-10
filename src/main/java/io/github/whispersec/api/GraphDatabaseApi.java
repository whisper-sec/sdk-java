package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.CypherQueryRequest;
import io.github.whispersec.model.CypherQueryResponse;
import io.github.whispersec.model.CypherSchemaResponse;
import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.GraphQLRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-10T22:42:39.717340328Z[Etc/UTC]", comments = "Generator version: 7.17.0")
public class GraphDatabaseApi {
    private ApiClient apiClient;

    public GraphDatabaseApi() {
        this(new ApiClient());
    }

    public GraphDatabaseApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Execute Cypher Query
     * Execute a read-only Cypher query against the FalkorDB graph database.  **Security:** Only read operations (MATCH, RETURN) are allowed. Write operations are blocked.  **Example Queries:** &#x60;&#x60;&#x60;cypher // Find all IPs for a domain MATCH (d:DomainName {name: $domain})-[:hasIP]-&gt;(ip:A_ADDRESS) RETURN ip.name AS ip  // Find domains on blocklists MATCH (d:DomainName)-[:isListed]-&gt;(l:LIST) RETURN d.name, l.name LIMIT 10  // Get ASN and announced prefixes MATCH (asn:ASN {number: 15169})-[:announces]-&gt;(p:ANNOUNCED_PREFIX_4) RETURN p.name AS prefix &#x60;&#x60;&#x60;  **Performance Tips:** - Always use LIMIT to restrict result size - Use parameters for variable values - Filter early in the query with WHERE clauses 
     * <p><b>200</b> - Query executed successfully
     * <p><b>400</b> - Invalid query syntax
     * <p><b>401</b> - Authentication required
     * <p><b>500</b> - Query execution failed
     * @param authorization The authorization parameter
     * @param cypherQueryRequest The cypherQueryRequest parameter
     * @return CypherQueryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec executeCypherQueryRequestCreation(@jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull CypherQueryRequest cypherQueryRequest) throws WebClientResponseException {
        Object postBody = cypherQueryRequest;
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new WebClientResponseException("Missing the required parameter 'authorization' when calling executeCypherQuery", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'cypherQueryRequest' is set
        if (cypherQueryRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'cypherQueryRequest' when calling executeCypherQuery", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<CypherQueryResponse> localVarReturnType = new ParameterizedTypeReference<CypherQueryResponse>() {};
        return apiClient.invokeAPI("/v1/ops/graph/cypher", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Execute Cypher Query
     * Execute a read-only Cypher query against the FalkorDB graph database.  **Security:** Only read operations (MATCH, RETURN) are allowed. Write operations are blocked.  **Example Queries:** &#x60;&#x60;&#x60;cypher // Find all IPs for a domain MATCH (d:DomainName {name: $domain})-[:hasIP]-&gt;(ip:A_ADDRESS) RETURN ip.name AS ip  // Find domains on blocklists MATCH (d:DomainName)-[:isListed]-&gt;(l:LIST) RETURN d.name, l.name LIMIT 10  // Get ASN and announced prefixes MATCH (asn:ASN {number: 15169})-[:announces]-&gt;(p:ANNOUNCED_PREFIX_4) RETURN p.name AS prefix &#x60;&#x60;&#x60;  **Performance Tips:** - Always use LIMIT to restrict result size - Use parameters for variable values - Filter early in the query with WHERE clauses 
     * <p><b>200</b> - Query executed successfully
     * <p><b>400</b> - Invalid query syntax
     * <p><b>401</b> - Authentication required
     * <p><b>500</b> - Query execution failed
     * @param authorization The authorization parameter
     * @param cypherQueryRequest The cypherQueryRequest parameter
     * @return CypherQueryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CypherQueryResponse> executeCypherQuery(@jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull CypherQueryRequest cypherQueryRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CypherQueryResponse> localVarReturnType = new ParameterizedTypeReference<CypherQueryResponse>() {};
        return executeCypherQueryRequestCreation(authorization, cypherQueryRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Execute Cypher Query
     * Execute a read-only Cypher query against the FalkorDB graph database.  **Security:** Only read operations (MATCH, RETURN) are allowed. Write operations are blocked.  **Example Queries:** &#x60;&#x60;&#x60;cypher // Find all IPs for a domain MATCH (d:DomainName {name: $domain})-[:hasIP]-&gt;(ip:A_ADDRESS) RETURN ip.name AS ip  // Find domains on blocklists MATCH (d:DomainName)-[:isListed]-&gt;(l:LIST) RETURN d.name, l.name LIMIT 10  // Get ASN and announced prefixes MATCH (asn:ASN {number: 15169})-[:announces]-&gt;(p:ANNOUNCED_PREFIX_4) RETURN p.name AS prefix &#x60;&#x60;&#x60;  **Performance Tips:** - Always use LIMIT to restrict result size - Use parameters for variable values - Filter early in the query with WHERE clauses 
     * <p><b>200</b> - Query executed successfully
     * <p><b>400</b> - Invalid query syntax
     * <p><b>401</b> - Authentication required
     * <p><b>500</b> - Query execution failed
     * @param authorization The authorization parameter
     * @param cypherQueryRequest The cypherQueryRequest parameter
     * @return ResponseEntity&lt;CypherQueryResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<CypherQueryResponse>> executeCypherQueryWithHttpInfo(@jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull CypherQueryRequest cypherQueryRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CypherQueryResponse> localVarReturnType = new ParameterizedTypeReference<CypherQueryResponse>() {};
        return executeCypherQueryRequestCreation(authorization, cypherQueryRequest).toEntity(localVarReturnType);
    }

    /**
     * Execute Cypher Query
     * Execute a read-only Cypher query against the FalkorDB graph database.  **Security:** Only read operations (MATCH, RETURN) are allowed. Write operations are blocked.  **Example Queries:** &#x60;&#x60;&#x60;cypher // Find all IPs for a domain MATCH (d:DomainName {name: $domain})-[:hasIP]-&gt;(ip:A_ADDRESS) RETURN ip.name AS ip  // Find domains on blocklists MATCH (d:DomainName)-[:isListed]-&gt;(l:LIST) RETURN d.name, l.name LIMIT 10  // Get ASN and announced prefixes MATCH (asn:ASN {number: 15169})-[:announces]-&gt;(p:ANNOUNCED_PREFIX_4) RETURN p.name AS prefix &#x60;&#x60;&#x60;  **Performance Tips:** - Always use LIMIT to restrict result size - Use parameters for variable values - Filter early in the query with WHERE clauses 
     * <p><b>200</b> - Query executed successfully
     * <p><b>400</b> - Invalid query syntax
     * <p><b>401</b> - Authentication required
     * <p><b>500</b> - Query execution failed
     * @param authorization The authorization parameter
     * @param cypherQueryRequest The cypherQueryRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec executeCypherQueryWithResponseSpec(@jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull CypherQueryRequest cypherQueryRequest) throws WebClientResponseException {
        return executeCypherQueryRequestCreation(authorization, cypherQueryRequest);
    }

    /**
     * Execute GraphQL Query
     * Execute a GraphQL query against the graph database.  GraphQL provides a type-safe, structured alternative to Cypher for querying the graph data.  **Available Query Operations:** - &#x60;domain(name: String!)&#x60; - Look up domain information - &#x60;ipv4(address: String!)&#x60; - Look up IPv4 address information - &#x60;ipv6(address: String!)&#x60; - Look up IPv6 address information - &#x60;asn(number: Int!)&#x60; - Look up ASN information - &#x60;searchDomains(pattern: String!, limit: Int)&#x60; - Search domains by pattern - &#x60;domainsOnIP(address: String!)&#x60; - Find domains on an IP - &#x60;domainsOnASN(asnNumber: Int!, limit: Int)&#x60; - Find domains on an ASN - &#x60;checkIndicator(indicator: String!)&#x60; - Check if indicator is listed  **Example Query:** &#x60;&#x60;&#x60;graphql {   domain(name: \&quot;google.com\&quot;) {     name     ipAddresses {       address       country { code }     }     nameservers { name }     asns { number }   } } &#x60;&#x60;&#x60;  Use the &#x60;/v1/ops/graph/graphiql&#x60; endpoint for an interactive query explorer with schema documentation. 
     * <p><b>200</b> - Query executed successfully
     * <p><b>400</b> - Invalid query syntax
     * <p><b>401</b> - Authentication required
     * @param authorization The authorization parameter
     * @param graphQLRequest The graphQLRequest parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec executeGraphQLRequestCreation(@jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull GraphQLRequest graphQLRequest) throws WebClientResponseException {
        Object postBody = graphQLRequest;
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new WebClientResponseException("Missing the required parameter 'authorization' when calling executeGraphQL", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'graphQLRequest' is set
        if (graphQLRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'graphQLRequest' when calling executeGraphQL", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/ops/graph/graphql", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Execute GraphQL Query
     * Execute a GraphQL query against the graph database.  GraphQL provides a type-safe, structured alternative to Cypher for querying the graph data.  **Available Query Operations:** - &#x60;domain(name: String!)&#x60; - Look up domain information - &#x60;ipv4(address: String!)&#x60; - Look up IPv4 address information - &#x60;ipv6(address: String!)&#x60; - Look up IPv6 address information - &#x60;asn(number: Int!)&#x60; - Look up ASN information - &#x60;searchDomains(pattern: String!, limit: Int)&#x60; - Search domains by pattern - &#x60;domainsOnIP(address: String!)&#x60; - Find domains on an IP - &#x60;domainsOnASN(asnNumber: Int!, limit: Int)&#x60; - Find domains on an ASN - &#x60;checkIndicator(indicator: String!)&#x60; - Check if indicator is listed  **Example Query:** &#x60;&#x60;&#x60;graphql {   domain(name: \&quot;google.com\&quot;) {     name     ipAddresses {       address       country { code }     }     nameservers { name }     asns { number }   } } &#x60;&#x60;&#x60;  Use the &#x60;/v1/ops/graph/graphiql&#x60; endpoint for an interactive query explorer with schema documentation. 
     * <p><b>200</b> - Query executed successfully
     * <p><b>400</b> - Invalid query syntax
     * <p><b>401</b> - Authentication required
     * @param authorization The authorization parameter
     * @param graphQLRequest The graphQLRequest parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> executeGraphQL(@jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull GraphQLRequest graphQLRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return executeGraphQLRequestCreation(authorization, graphQLRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Execute GraphQL Query
     * Execute a GraphQL query against the graph database.  GraphQL provides a type-safe, structured alternative to Cypher for querying the graph data.  **Available Query Operations:** - &#x60;domain(name: String!)&#x60; - Look up domain information - &#x60;ipv4(address: String!)&#x60; - Look up IPv4 address information - &#x60;ipv6(address: String!)&#x60; - Look up IPv6 address information - &#x60;asn(number: Int!)&#x60; - Look up ASN information - &#x60;searchDomains(pattern: String!, limit: Int)&#x60; - Search domains by pattern - &#x60;domainsOnIP(address: String!)&#x60; - Find domains on an IP - &#x60;domainsOnASN(asnNumber: Int!, limit: Int)&#x60; - Find domains on an ASN - &#x60;checkIndicator(indicator: String!)&#x60; - Check if indicator is listed  **Example Query:** &#x60;&#x60;&#x60;graphql {   domain(name: \&quot;google.com\&quot;) {     name     ipAddresses {       address       country { code }     }     nameservers { name }     asns { number }   } } &#x60;&#x60;&#x60;  Use the &#x60;/v1/ops/graph/graphiql&#x60; endpoint for an interactive query explorer with schema documentation. 
     * <p><b>200</b> - Query executed successfully
     * <p><b>400</b> - Invalid query syntax
     * <p><b>401</b> - Authentication required
     * @param authorization The authorization parameter
     * @param graphQLRequest The graphQLRequest parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> executeGraphQLWithHttpInfo(@jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull GraphQLRequest graphQLRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return executeGraphQLRequestCreation(authorization, graphQLRequest).toEntity(localVarReturnType);
    }

    /**
     * Execute GraphQL Query
     * Execute a GraphQL query against the graph database.  GraphQL provides a type-safe, structured alternative to Cypher for querying the graph data.  **Available Query Operations:** - &#x60;domain(name: String!)&#x60; - Look up domain information - &#x60;ipv4(address: String!)&#x60; - Look up IPv4 address information - &#x60;ipv6(address: String!)&#x60; - Look up IPv6 address information - &#x60;asn(number: Int!)&#x60; - Look up ASN information - &#x60;searchDomains(pattern: String!, limit: Int)&#x60; - Search domains by pattern - &#x60;domainsOnIP(address: String!)&#x60; - Find domains on an IP - &#x60;domainsOnASN(asnNumber: Int!, limit: Int)&#x60; - Find domains on an ASN - &#x60;checkIndicator(indicator: String!)&#x60; - Check if indicator is listed  **Example Query:** &#x60;&#x60;&#x60;graphql {   domain(name: \&quot;google.com\&quot;) {     name     ipAddresses {       address       country { code }     }     nameservers { name }     asns { number }   } } &#x60;&#x60;&#x60;  Use the &#x60;/v1/ops/graph/graphiql&#x60; endpoint for an interactive query explorer with schema documentation. 
     * <p><b>200</b> - Query executed successfully
     * <p><b>400</b> - Invalid query syntax
     * <p><b>401</b> - Authentication required
     * @param authorization The authorization parameter
     * @param graphQLRequest The graphQLRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec executeGraphQLWithResponseSpec(@jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull GraphQLRequest graphQLRequest) throws WebClientResponseException {
        return executeGraphQLRequestCreation(authorization, graphQLRequest);
    }

    /**
     * GraphiQL Interactive Explorer
     * Access the GraphiQL interactive query explorer.  GraphiQL provides: - Interactive query editor with syntax highlighting - Auto-complete for types and fields - Schema documentation browser - Query history  **No authentication required** - the UI itself is public, but queries still require a valid API key. 
     * <p><b>200</b> - GraphiQL HTML page
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getGraphiQLRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "text/html"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/ops/graph/graphiql", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * GraphiQL Interactive Explorer
     * Access the GraphiQL interactive query explorer.  GraphiQL provides: - Interactive query editor with syntax highlighting - Auto-complete for types and fields - Schema documentation browser - Query history  **No authentication required** - the UI itself is public, but queries still require a valid API key. 
     * <p><b>200</b> - GraphiQL HTML page
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getGraphiQL() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getGraphiQLRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * GraphiQL Interactive Explorer
     * Access the GraphiQL interactive query explorer.  GraphiQL provides: - Interactive query editor with syntax highlighting - Auto-complete for types and fields - Schema documentation browser - Query history  **No authentication required** - the UI itself is public, but queries still require a valid API key. 
     * <p><b>200</b> - GraphiQL HTML page
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getGraphiQLWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getGraphiQLRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * GraphiQL Interactive Explorer
     * Access the GraphiQL interactive query explorer.  GraphiQL provides: - Interactive query editor with syntax highlighting - Auto-complete for types and fields - Schema documentation browser - Query history  **No authentication required** - the UI itself is public, but queries still require a valid API key. 
     * <p><b>200</b> - GraphiQL HTML page
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getGraphiQLWithResponseSpec() throws WebClientResponseException {
        return getGraphiQLRequestCreation();
    }

    /**
     * Graph Database Health Check
     * Check the health and connectivity of the graph database.  **No authentication required** - this is a public health endpoint.  Returns database status, connection info, and basic statistics. 
     * <p><b>200</b> - Health status retrieved
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getHealthRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/v1/ops/graph/health", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Graph Database Health Check
     * Check the health and connectivity of the graph database.  **No authentication required** - this is a public health endpoint.  Returns database status, connection info, and basic statistics. 
     * <p><b>200</b> - Health status retrieved
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Object> getHealth() throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return getHealthRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Graph Database Health Check
     * Check the health and connectivity of the graph database.  **No authentication required** - this is a public health endpoint.  Returns database status, connection info, and basic statistics. 
     * <p><b>200</b> - Health status retrieved
     * @return ResponseEntity&lt;Object&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Object>> getHealthWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return getHealthRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Graph Database Health Check
     * Check the health and connectivity of the graph database.  **No authentication required** - this is a public health endpoint.  Returns database status, connection info, and basic statistics. 
     * <p><b>200</b> - Health status retrieved
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getHealthWithResponseSpec() throws WebClientResponseException {
        return getHealthRequestCreation();
    }

    /**
     * Get Graph Schema
     * Retrieve the graph database schema including available node labels, relationship types, and their properties.  Use this to discover what data is available for querying before writing Cypher or GraphQL queries.  **Response includes:** - Node labels (e.g., DomainName, A_ADDRESS, ASN) - Relationship types (e.g., hasIP, isListed, announces) - Properties available on each node and relationship type - Graph statistics (node and relationship counts) 
     * <p><b>200</b> - Schema retrieved successfully
     * <p><b>401</b> - Authentication required
     * <p><b>500</b> - Failed to retrieve schema
     * @param authorization The authorization parameter
     * @return CypherSchemaResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSchemaRequestCreation(@jakarta.annotation.Nonnull String authorization) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new WebClientResponseException("Missing the required parameter 'authorization' when calling getSchema", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<CypherSchemaResponse> localVarReturnType = new ParameterizedTypeReference<CypherSchemaResponse>() {};
        return apiClient.invokeAPI("/v1/ops/graph/schema", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Graph Schema
     * Retrieve the graph database schema including available node labels, relationship types, and their properties.  Use this to discover what data is available for querying before writing Cypher or GraphQL queries.  **Response includes:** - Node labels (e.g., DomainName, A_ADDRESS, ASN) - Relationship types (e.g., hasIP, isListed, announces) - Properties available on each node and relationship type - Graph statistics (node and relationship counts) 
     * <p><b>200</b> - Schema retrieved successfully
     * <p><b>401</b> - Authentication required
     * <p><b>500</b> - Failed to retrieve schema
     * @param authorization The authorization parameter
     * @return CypherSchemaResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CypherSchemaResponse> getSchema(@jakarta.annotation.Nonnull String authorization) throws WebClientResponseException {
        ParameterizedTypeReference<CypherSchemaResponse> localVarReturnType = new ParameterizedTypeReference<CypherSchemaResponse>() {};
        return getSchemaRequestCreation(authorization).bodyToMono(localVarReturnType);
    }

    /**
     * Get Graph Schema
     * Retrieve the graph database schema including available node labels, relationship types, and their properties.  Use this to discover what data is available for querying before writing Cypher or GraphQL queries.  **Response includes:** - Node labels (e.g., DomainName, A_ADDRESS, ASN) - Relationship types (e.g., hasIP, isListed, announces) - Properties available on each node and relationship type - Graph statistics (node and relationship counts) 
     * <p><b>200</b> - Schema retrieved successfully
     * <p><b>401</b> - Authentication required
     * <p><b>500</b> - Failed to retrieve schema
     * @param authorization The authorization parameter
     * @return ResponseEntity&lt;CypherSchemaResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<CypherSchemaResponse>> getSchemaWithHttpInfo(@jakarta.annotation.Nonnull String authorization) throws WebClientResponseException {
        ParameterizedTypeReference<CypherSchemaResponse> localVarReturnType = new ParameterizedTypeReference<CypherSchemaResponse>() {};
        return getSchemaRequestCreation(authorization).toEntity(localVarReturnType);
    }

    /**
     * Get Graph Schema
     * Retrieve the graph database schema including available node labels, relationship types, and their properties.  Use this to discover what data is available for querying before writing Cypher or GraphQL queries.  **Response includes:** - Node labels (e.g., DomainName, A_ADDRESS, ASN) - Relationship types (e.g., hasIP, isListed, announces) - Properties available on each node and relationship type - Graph statistics (node and relationship counts) 
     * <p><b>200</b> - Schema retrieved successfully
     * <p><b>401</b> - Authentication required
     * <p><b>500</b> - Failed to retrieve schema
     * @param authorization The authorization parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getSchemaWithResponseSpec(@jakarta.annotation.Nonnull String authorization) throws WebClientResponseException {
        return getSchemaRequestCreation(authorization);
    }
}
