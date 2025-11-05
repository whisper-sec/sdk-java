package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.ErrorResponse;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-11-05T22:48:22.416555488Z[Etc/UTC]", comments = "Generator version: 7.16.0")
public class LocationApi {
    private ApiClient apiClient;

    public LocationApi() {
        this(new ApiClient());
    }

    public LocationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Bulk IP Geolocation Lookup
     * &lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON array of IP addresses (IPv4 or IPv6):&lt;/p&gt; &lt;pre&gt;&lt;code&gt;[\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 500-2000ms for typical batches (10-100 IPs)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with automatic batching&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects matching the order of input IPs. Failed lookups are indicated with error objects.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid request format. Expected JSON array of IP addresses, or array exceeds 1000 IP limit.
     * <p><b>200</b> - Successfully retrieved bulk geolocation data.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param requestBody JSON array of IP addresses to lookup. Maximum 1000 IPs per request.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getBulkIpLocationRequestCreation(@javax.annotation.Nonnull List<String> requestBody) throws WebClientResponseException {
        Object postBody = requestBody;
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new WebClientResponseException("Missing the required parameter 'requestBody' when calling getBulkIpLocation", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

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
        return apiClient.invokeAPI("/v1/location/ips/bulk", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Bulk IP Geolocation Lookup
     * &lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON array of IP addresses (IPv4 or IPv6):&lt;/p&gt; &lt;pre&gt;&lt;code&gt;[\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 500-2000ms for typical batches (10-100 IPs)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with automatic batching&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects matching the order of input IPs. Failed lookups are indicated with error objects.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid request format. Expected JSON array of IP addresses, or array exceeds 1000 IP limit.
     * <p><b>200</b> - Successfully retrieved bulk geolocation data.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param requestBody JSON array of IP addresses to lookup. Maximum 1000 IPs per request.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getBulkIpLocation(@javax.annotation.Nonnull List<String> requestBody) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getBulkIpLocationRequestCreation(requestBody).bodyToMono(localVarReturnType);
    }

    /**
     * Bulk IP Geolocation Lookup
     * &lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON array of IP addresses (IPv4 or IPv6):&lt;/p&gt; &lt;pre&gt;&lt;code&gt;[\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 500-2000ms for typical batches (10-100 IPs)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with automatic batching&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects matching the order of input IPs. Failed lookups are indicated with error objects.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid request format. Expected JSON array of IP addresses, or array exceeds 1000 IP limit.
     * <p><b>200</b> - Successfully retrieved bulk geolocation data.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param requestBody JSON array of IP addresses to lookup. Maximum 1000 IPs per request.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getBulkIpLocationWithHttpInfo(@javax.annotation.Nonnull List<String> requestBody) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getBulkIpLocationRequestCreation(requestBody).toEntity(localVarReturnType);
    }

    /**
     * Bulk IP Geolocation Lookup
     * &lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON array of IP addresses (IPv4 or IPv6):&lt;/p&gt; &lt;pre&gt;&lt;code&gt;[\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 500-2000ms for typical batches (10-100 IPs)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with automatic batching&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects matching the order of input IPs. Failed lookups are indicated with error objects.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid request format. Expected JSON array of IP addresses, or array exceeds 1000 IP limit.
     * <p><b>200</b> - Successfully retrieved bulk geolocation data.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param requestBody JSON array of IP addresses to lookup. Maximum 1000 IPs per request.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getBulkIpLocationWithResponseSpec(@javax.annotation.Nonnull List<String> requestBody) throws WebClientResponseException {
        return getBulkIpLocationRequestCreation(requestBody);
    }

    /**
     * Get IP Geolocation and ASN Data
     * &lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 or IPv6 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved geolocation data.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid IP address format.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>404</b> - IP address not found in geolocation database.
     * @param ip The IPv4 or IPv6 address to lookup.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIpLocationRequestCreation(@javax.annotation.Nonnull String ip) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'ip' is set
        if (ip == null) {
            throw new WebClientResponseException("Missing the required parameter 'ip' when calling getIpLocation", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("ip", ip);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/location/ip/{ip}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get IP Geolocation and ASN Data
     * &lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 or IPv6 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved geolocation data.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid IP address format.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>404</b> - IP address not found in geolocation database.
     * @param ip The IPv4 or IPv6 address to lookup.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getIpLocation(@javax.annotation.Nonnull String ip) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getIpLocationRequestCreation(ip).bodyToMono(localVarReturnType);
    }

    /**
     * Get IP Geolocation and ASN Data
     * &lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 or IPv6 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved geolocation data.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid IP address format.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>404</b> - IP address not found in geolocation database.
     * @param ip The IPv4 or IPv6 address to lookup.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getIpLocationWithHttpInfo(@javax.annotation.Nonnull String ip) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getIpLocationRequestCreation(ip).toEntity(localVarReturnType);
    }

    /**
     * Get IP Geolocation and ASN Data
     * &lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 or IPv6 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved geolocation data.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid IP address format.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>404</b> - IP address not found in geolocation database.
     * @param ip The IPv4 or IPv6 address to lookup.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIpLocationWithResponseSpec(@javax.annotation.Nonnull String ip) throws WebClientResponseException {
        return getIpLocationRequestCreation(ip);
    }

    /**
     * Get Geolocation Database Statistics
     * &lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved database statistics.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getLocationStatsRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/location/stats", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Geolocation Database Statistics
     * &lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved database statistics.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getLocationStats() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getLocationStatsRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Get Geolocation Database Statistics
     * &lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved database statistics.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getLocationStatsWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getLocationStatsRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Get Geolocation Database Statistics
     * &lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved database statistics.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getLocationStatsWithResponseSpec() throws WebClientResponseException {
        return getLocationStatsRequestCreation();
    }

    /**
     * Get Network/CIDR Geolocation Data
     * &lt;p&gt;Returns geolocation and network information for an entire network range specified in CIDR notation. Useful for analyzing network blocks, ranges, and subnets.&lt;/p&gt; &lt;h4&gt;Supported Formats:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPv4 CIDR:&lt;/b&gt; 192.168.1.0/24&lt;/li&gt;     &lt;li&gt;&lt;b&gt;IPv6 CIDR:&lt;/b&gt; 2001:db8::/32&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Network Details:&lt;/b&gt; CIDR range, first/last IP, total addresses&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region for the network block&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, organization, ISP information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Network type and usage category&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Analyzing suspicious network ranges&lt;/li&gt;     &lt;li&gt;Bulk geolocation for network blocks&lt;/li&gt;     &lt;li&gt;Infrastructure mapping and reconnaissance&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid CIDR format or network specification.
     * <p><b>404</b> - Network not found in geolocation database.
     * <p><b>200</b> - Successfully retrieved network geolocation data.
     * @param network The network range in CIDR notation (e.g., 192.168.1.0/24 or 2001:db8::/32).
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getNetworkLocationRequestCreation(@javax.annotation.Nonnull String network) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'network' is set
        if (network == null) {
            throw new WebClientResponseException("Missing the required parameter 'network' when calling getNetworkLocation", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("network", network);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/location/network/{*network}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Network/CIDR Geolocation Data
     * &lt;p&gt;Returns geolocation and network information for an entire network range specified in CIDR notation. Useful for analyzing network blocks, ranges, and subnets.&lt;/p&gt; &lt;h4&gt;Supported Formats:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPv4 CIDR:&lt;/b&gt; 192.168.1.0/24&lt;/li&gt;     &lt;li&gt;&lt;b&gt;IPv6 CIDR:&lt;/b&gt; 2001:db8::/32&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Network Details:&lt;/b&gt; CIDR range, first/last IP, total addresses&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region for the network block&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, organization, ISP information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Network type and usage category&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Analyzing suspicious network ranges&lt;/li&gt;     &lt;li&gt;Bulk geolocation for network blocks&lt;/li&gt;     &lt;li&gt;Infrastructure mapping and reconnaissance&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid CIDR format or network specification.
     * <p><b>404</b> - Network not found in geolocation database.
     * <p><b>200</b> - Successfully retrieved network geolocation data.
     * @param network The network range in CIDR notation (e.g., 192.168.1.0/24 or 2001:db8::/32).
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getNetworkLocation(@javax.annotation.Nonnull String network) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getNetworkLocationRequestCreation(network).bodyToMono(localVarReturnType);
    }

    /**
     * Get Network/CIDR Geolocation Data
     * &lt;p&gt;Returns geolocation and network information for an entire network range specified in CIDR notation. Useful for analyzing network blocks, ranges, and subnets.&lt;/p&gt; &lt;h4&gt;Supported Formats:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPv4 CIDR:&lt;/b&gt; 192.168.1.0/24&lt;/li&gt;     &lt;li&gt;&lt;b&gt;IPv6 CIDR:&lt;/b&gt; 2001:db8::/32&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Network Details:&lt;/b&gt; CIDR range, first/last IP, total addresses&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region for the network block&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, organization, ISP information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Network type and usage category&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Analyzing suspicious network ranges&lt;/li&gt;     &lt;li&gt;Bulk geolocation for network blocks&lt;/li&gt;     &lt;li&gt;Infrastructure mapping and reconnaissance&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid CIDR format or network specification.
     * <p><b>404</b> - Network not found in geolocation database.
     * <p><b>200</b> - Successfully retrieved network geolocation data.
     * @param network The network range in CIDR notation (e.g., 192.168.1.0/24 or 2001:db8::/32).
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getNetworkLocationWithHttpInfo(@javax.annotation.Nonnull String network) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getNetworkLocationRequestCreation(network).toEntity(localVarReturnType);
    }

    /**
     * Get Network/CIDR Geolocation Data
     * &lt;p&gt;Returns geolocation and network information for an entire network range specified in CIDR notation. Useful for analyzing network blocks, ranges, and subnets.&lt;/p&gt; &lt;h4&gt;Supported Formats:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPv4 CIDR:&lt;/b&gt; 192.168.1.0/24&lt;/li&gt;     &lt;li&gt;&lt;b&gt;IPv6 CIDR:&lt;/b&gt; 2001:db8::/32&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Network Details:&lt;/b&gt; CIDR range, first/last IP, total addresses&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region for the network block&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, organization, ISP information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Network type and usage category&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Analyzing suspicious network ranges&lt;/li&gt;     &lt;li&gt;Bulk geolocation for network blocks&lt;/li&gt;     &lt;li&gt;Infrastructure mapping and reconnaissance&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid CIDR format or network specification.
     * <p><b>404</b> - Network not found in geolocation database.
     * <p><b>200</b> - Successfully retrieved network geolocation data.
     * @param network The network range in CIDR notation (e.g., 192.168.1.0/24 or 2001:db8::/32).
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getNetworkLocationWithResponseSpec(@javax.annotation.Nonnull String network) throws WebClientResponseException {
        return getNetworkLocationRequestCreation(network);
    }

    /**
     * Search Geolocation Database by Field
     * &lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>200</b> - Successfully retrieved search results.
     * <p><b>400</b> - Invalid search field or parameters.
     * @param field The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude
     * @param value The value to search for in the specified field.
     * @param limit Maximum number of results to return.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec searchLocationRequestCreation(@javax.annotation.Nonnull String field, @javax.annotation.Nonnull String value, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'field' is set
        if (field == null) {
            throw new WebClientResponseException("Missing the required parameter 'field' when calling searchLocation", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling searchLocation", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "value", value));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/location/search", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Search Geolocation Database by Field
     * &lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>200</b> - Successfully retrieved search results.
     * <p><b>400</b> - Invalid search field or parameters.
     * @param field The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude
     * @param value The value to search for in the specified field.
     * @param limit Maximum number of results to return.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> searchLocation(@javax.annotation.Nonnull String field, @javax.annotation.Nonnull String value, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return searchLocationRequestCreation(field, value, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Search Geolocation Database by Field
     * &lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>200</b> - Successfully retrieved search results.
     * <p><b>400</b> - Invalid search field or parameters.
     * @param field The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude
     * @param value The value to search for in the specified field.
     * @param limit Maximum number of results to return.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> searchLocationWithHttpInfo(@javax.annotation.Nonnull String field, @javax.annotation.Nonnull String value, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return searchLocationRequestCreation(field, value, limit).toEntity(localVarReturnType);
    }

    /**
     * Search Geolocation Database by Field
     * &lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>200</b> - Successfully retrieved search results.
     * <p><b>400</b> - Invalid search field or parameters.
     * @param field The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude
     * @param value The value to search for in the specified field.
     * @param limit Maximum number of results to return.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec searchLocationWithResponseSpec(@javax.annotation.Nonnull String field, @javax.annotation.Nonnull String value, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        return searchLocationRequestCreation(field, value, limit);
    }
}
