package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.BulkIpLocationRequest;
import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.IpGeolocationResponse;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-10T23:03:52.806666455Z[Etc/UTC]", comments = "Generator version: 7.17.0")
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
     * &lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON object with an &lt;code&gt;ips&lt;/code&gt; array:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{\&quot;ips\&quot;: [\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]}&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 2-5 seconds for small batches (1-10 IPs), 5-15 seconds for larger batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with concurrency of 10&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects, one for each requested IP:&lt;/p&gt; &lt;p&gt;&lt;b&gt;Successful lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;queriedIp&lt;/code&gt;: The IP address that was looked up (for correlation)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;country&lt;/code&gt;: Object with &lt;code&gt;isoCode&lt;/code&gt; (e.g., \&quot;US\&quot;), &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;United States\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;city&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;Mountain View\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;location&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt;, &lt;code&gt;timeZone&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt;, &lt;code&gt;organization&lt;/code&gt;, &lt;code&gt;asn&lt;/code&gt;, &lt;code&gt;asnOrganization&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;coordinates&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt; (convenience field)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;traits&lt;/code&gt;: Object with &lt;code&gt;userType&lt;/code&gt; (e.g., \&quot;hosting\&quot;, \&quot;residential\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;p&gt;&lt;b&gt;Failed lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;ip&lt;/code&gt;: The IP address that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: Always &lt;code&gt;true&lt;/code&gt; for failed lookups&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description (e.g., \&quot;Invalid IP address format\&quot;, \&quot;Location data not available for private IP addresses\&quot;, \&quot;Location data not available for reserved/bogon IP addresses\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved bulk geolocation data. Returns an array of geolocation objects or error objects for each IP.
     * <p><b>400</b> - Invalid request format. Missing or empty &#39;ips&#39; field, or array exceeds 1000 IP limit.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkIpLocationRequest List of IP addresses to lookup. Maximum 1000 IPs per request.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getBulkIpLocationRequestCreation(@jakarta.annotation.Nonnull BulkIpLocationRequest bulkIpLocationRequest) throws WebClientResponseException {
        Object postBody = bulkIpLocationRequest;
        // verify the required parameter 'bulkIpLocationRequest' is set
        if (bulkIpLocationRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'bulkIpLocationRequest' when calling getBulkIpLocation", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
     * &lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON object with an &lt;code&gt;ips&lt;/code&gt; array:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{\&quot;ips\&quot;: [\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]}&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 2-5 seconds for small batches (1-10 IPs), 5-15 seconds for larger batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with concurrency of 10&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects, one for each requested IP:&lt;/p&gt; &lt;p&gt;&lt;b&gt;Successful lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;queriedIp&lt;/code&gt;: The IP address that was looked up (for correlation)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;country&lt;/code&gt;: Object with &lt;code&gt;isoCode&lt;/code&gt; (e.g., \&quot;US\&quot;), &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;United States\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;city&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;Mountain View\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;location&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt;, &lt;code&gt;timeZone&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt;, &lt;code&gt;organization&lt;/code&gt;, &lt;code&gt;asn&lt;/code&gt;, &lt;code&gt;asnOrganization&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;coordinates&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt; (convenience field)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;traits&lt;/code&gt;: Object with &lt;code&gt;userType&lt;/code&gt; (e.g., \&quot;hosting\&quot;, \&quot;residential\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;p&gt;&lt;b&gt;Failed lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;ip&lt;/code&gt;: The IP address that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: Always &lt;code&gt;true&lt;/code&gt; for failed lookups&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description (e.g., \&quot;Invalid IP address format\&quot;, \&quot;Location data not available for private IP addresses\&quot;, \&quot;Location data not available for reserved/bogon IP addresses\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved bulk geolocation data. Returns an array of geolocation objects or error objects for each IP.
     * <p><b>400</b> - Invalid request format. Missing or empty &#39;ips&#39; field, or array exceeds 1000 IP limit.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkIpLocationRequest List of IP addresses to lookup. Maximum 1000 IPs per request.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getBulkIpLocation(@jakarta.annotation.Nonnull BulkIpLocationRequest bulkIpLocationRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getBulkIpLocationRequestCreation(bulkIpLocationRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Bulk IP Geolocation Lookup
     * &lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON object with an &lt;code&gt;ips&lt;/code&gt; array:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{\&quot;ips\&quot;: [\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]}&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 2-5 seconds for small batches (1-10 IPs), 5-15 seconds for larger batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with concurrency of 10&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects, one for each requested IP:&lt;/p&gt; &lt;p&gt;&lt;b&gt;Successful lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;queriedIp&lt;/code&gt;: The IP address that was looked up (for correlation)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;country&lt;/code&gt;: Object with &lt;code&gt;isoCode&lt;/code&gt; (e.g., \&quot;US\&quot;), &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;United States\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;city&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;Mountain View\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;location&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt;, &lt;code&gt;timeZone&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt;, &lt;code&gt;organization&lt;/code&gt;, &lt;code&gt;asn&lt;/code&gt;, &lt;code&gt;asnOrganization&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;coordinates&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt; (convenience field)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;traits&lt;/code&gt;: Object with &lt;code&gt;userType&lt;/code&gt; (e.g., \&quot;hosting\&quot;, \&quot;residential\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;p&gt;&lt;b&gt;Failed lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;ip&lt;/code&gt;: The IP address that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: Always &lt;code&gt;true&lt;/code&gt; for failed lookups&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description (e.g., \&quot;Invalid IP address format\&quot;, \&quot;Location data not available for private IP addresses\&quot;, \&quot;Location data not available for reserved/bogon IP addresses\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved bulk geolocation data. Returns an array of geolocation objects or error objects for each IP.
     * <p><b>400</b> - Invalid request format. Missing or empty &#39;ips&#39; field, or array exceeds 1000 IP limit.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkIpLocationRequest List of IP addresses to lookup. Maximum 1000 IPs per request.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getBulkIpLocationWithHttpInfo(@jakarta.annotation.Nonnull BulkIpLocationRequest bulkIpLocationRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getBulkIpLocationRequestCreation(bulkIpLocationRequest).toEntity(localVarReturnType);
    }

    /**
     * Bulk IP Geolocation Lookup
     * &lt;p&gt;Retrieve geolocation data for up to 1000 IP addresses in a single request. Optimized for batch processing with parallel lookups.&lt;/p&gt; &lt;h4&gt;Request Format:&lt;/h4&gt; &lt;p&gt;Send a JSON object with an &lt;code&gt;ips&lt;/code&gt; array:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{\&quot;ips\&quot;: [\&quot;8.8.8.8\&quot;, \&quot;1.1.1.1\&quot;, \&quot;208.67.222.222\&quot;]}&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 2-5 seconds for small batches (1-10 IPs), 5-15 seconds for larger batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Processing:&lt;/b&gt; Parallel lookups with concurrency of 10&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Limit:&lt;/b&gt; Maximum 1000 IPs per request&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 10 requests per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns an array of geolocation objects, one for each requested IP:&lt;/p&gt; &lt;p&gt;&lt;b&gt;Successful lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;queriedIp&lt;/code&gt;: The IP address that was looked up (for correlation)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;country&lt;/code&gt;: Object with &lt;code&gt;isoCode&lt;/code&gt; (e.g., \&quot;US\&quot;), &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;United States\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;city&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt; (e.g., \&quot;Mountain View\&quot;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;location&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt;, &lt;code&gt;timeZone&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: Object with &lt;code&gt;name&lt;/code&gt;, &lt;code&gt;organization&lt;/code&gt;, &lt;code&gt;asn&lt;/code&gt;, &lt;code&gt;asnOrganization&lt;/code&gt;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;coordinates&lt;/code&gt;: Object with &lt;code&gt;latitude&lt;/code&gt;, &lt;code&gt;longitude&lt;/code&gt; (convenience field)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;traits&lt;/code&gt;: Object with &lt;code&gt;userType&lt;/code&gt; (e.g., \&quot;hosting\&quot;, \&quot;residential\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;p&gt;&lt;b&gt;Failed lookup fields:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;ip&lt;/code&gt;: The IP address that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: Always &lt;code&gt;true&lt;/code&gt; for failed lookups&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description (e.g., \&quot;Invalid IP address format\&quot;, \&quot;Location data not available for private IP addresses\&quot;, \&quot;Location data not available for reserved/bogon IP addresses\&quot;)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Batch enrichment of access logs&lt;/li&gt;     &lt;li&gt;Bulk fraud scoring&lt;/li&gt;     &lt;li&gt;Geographic distribution analysis&lt;/li&gt;     &lt;li&gt;Network infrastructure mapping&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved bulk geolocation data. Returns an array of geolocation objects or error objects for each IP.
     * <p><b>400</b> - Invalid request format. Missing or empty &#39;ips&#39; field, or array exceeds 1000 IP limit.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkIpLocationRequest List of IP addresses to lookup. Maximum 1000 IPs per request.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getBulkIpLocationWithResponseSpec(@jakarta.annotation.Nonnull BulkIpLocationRequest bulkIpLocationRequest) throws WebClientResponseException {
        return getBulkIpLocationRequestCreation(bulkIpLocationRequest);
    }

    /**
     * Get IP Geolocation and ASN Data
     * &lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; IPv6 addresses are not currently supported. Please use IPv4 addresses only.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved geolocation data.
     * <p><b>400</b> - Invalid IP address format. The provided value is not a valid IPv4 or IPv6 address.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - IP address not found in geolocation database. This may occur for reserved or private IP ranges.
     * <p><b>429</b> - Rate limit exceeded. Standard limit is 100 requests per minute.
     * @param ip The IPv4 address to lookup. IPv6 is not currently supported.
     * @return IpGeolocationResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIpLocationRequestCreation(@jakarta.annotation.Nonnull String ip) throws WebClientResponseException {
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

        ParameterizedTypeReference<IpGeolocationResponse> localVarReturnType = new ParameterizedTypeReference<IpGeolocationResponse>() {};
        return apiClient.invokeAPI("/v1/location/ip/{ip}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get IP Geolocation and ASN Data
     * &lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; IPv6 addresses are not currently supported. Please use IPv4 addresses only.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved geolocation data.
     * <p><b>400</b> - Invalid IP address format. The provided value is not a valid IPv4 or IPv6 address.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - IP address not found in geolocation database. This may occur for reserved or private IP ranges.
     * <p><b>429</b> - Rate limit exceeded. Standard limit is 100 requests per minute.
     * @param ip The IPv4 address to lookup. IPv6 is not currently supported.
     * @return IpGeolocationResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<IpGeolocationResponse> getIpLocation(@jakarta.annotation.Nonnull String ip) throws WebClientResponseException {
        ParameterizedTypeReference<IpGeolocationResponse> localVarReturnType = new ParameterizedTypeReference<IpGeolocationResponse>() {};
        return getIpLocationRequestCreation(ip).bodyToMono(localVarReturnType);
    }

    /**
     * Get IP Geolocation and ASN Data
     * &lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; IPv6 addresses are not currently supported. Please use IPv4 addresses only.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved geolocation data.
     * <p><b>400</b> - Invalid IP address format. The provided value is not a valid IPv4 or IPv6 address.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - IP address not found in geolocation database. This may occur for reserved or private IP ranges.
     * <p><b>429</b> - Rate limit exceeded. Standard limit is 100 requests per minute.
     * @param ip The IPv4 address to lookup. IPv6 is not currently supported.
     * @return ResponseEntity&lt;IpGeolocationResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<IpGeolocationResponse>> getIpLocationWithHttpInfo(@jakarta.annotation.Nonnull String ip) throws WebClientResponseException {
        ParameterizedTypeReference<IpGeolocationResponse> localVarReturnType = new ParameterizedTypeReference<IpGeolocationResponse>() {};
        return getIpLocationRequestCreation(ip).toEntity(localVarReturnType);
    }

    /**
     * Get IP Geolocation and ASN Data
     * &lt;p&gt;Returns comprehensive geolocation and network information for any IPv4 address. This is one of the fastest endpoints in the API, optimized for real-time fraud detection and access control.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; IPv6 addresses are not currently supported. Please use IPv4 addresses only.&lt;/p&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region, postal code, coordinates, timezone&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, ISP/organization name, network range&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Connection type (residential, datacenter, VPN, proxy, hosting)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Reputation:&lt;/b&gt; Risk indicators and abuse scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; Typically &amp;lt;150ms&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Cache:&lt;/b&gt; Results cached for 6 hours by default&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Real-time fraud detection in payment flows&lt;/li&gt;     &lt;li&gt;Geographic access control and compliance&lt;/li&gt;     &lt;li&gt;Bot and VPN detection&lt;/li&gt;     &lt;li&gt;Threat intelligence enrichment&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved geolocation data.
     * <p><b>400</b> - Invalid IP address format. The provided value is not a valid IPv4 or IPv6 address.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - IP address not found in geolocation database. This may occur for reserved or private IP ranges.
     * <p><b>429</b> - Rate limit exceeded. Standard limit is 100 requests per minute.
     * @param ip The IPv4 address to lookup. IPv6 is not currently supported.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIpLocationWithResponseSpec(@jakarta.annotation.Nonnull String ip) throws WebClientResponseException {
        return getIpLocationRequestCreation(ip);
    }

    /**
     * Get Geolocation Database Statistics
     * &lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; This endpoint aggregates data from the entire database and may take 5-10 seconds to respond. Consider caching results on your end for repeated access.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved database statistics.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * &lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; This endpoint aggregates data from the entire database and may take 5-10 seconds to respond. Consider caching results on your end for repeated access.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved database statistics.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getLocationStats() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getLocationStatsRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Get Geolocation Database Statistics
     * &lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; This endpoint aggregates data from the entire database and may take 5-10 seconds to respond. Consider caching results on your end for repeated access.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved database statistics.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getLocationStatsWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getLocationStatsRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Get Geolocation Database Statistics
     * &lt;p&gt;Returns metadata and statistics about the geolocation database, including coverage, update frequency, and data quality metrics.&lt;/p&gt; &lt;h4&gt;Statistics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Coverage:&lt;/b&gt; Total IP addresses, networks, and ASNs covered&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Number of countries, cities, and regions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Freshness:&lt;/b&gt; Last update timestamp and update frequency&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Data Sources:&lt;/b&gt; Providers and data collection methods&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Accuracy:&lt;/b&gt; Quality metrics and confidence scores&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;&lt;b&gt;Note:&lt;/b&gt; This endpoint aggregates data from the entire database and may take 5-10 seconds to respond. Consider caching results on your end for repeated access.&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Verifying database coverage for your use case&lt;/li&gt;     &lt;li&gt;Monitoring data freshness&lt;/li&gt;     &lt;li&gt;Understanding data quality and accuracy&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved database statistics.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getLocationStatsWithResponseSpec() throws WebClientResponseException {
        return getLocationStatsRequestCreation();
    }

    /**
     * Get Network/CIDR Geolocation Data
     * &lt;p&gt;Returns geolocation and network information for an entire network range specified in CIDR notation. Useful for analyzing network blocks, ranges, and subnets.&lt;/p&gt; &lt;h4&gt;Supported Formats:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPv4 CIDR:&lt;/b&gt; 192.168.1.0/24&lt;/li&gt;     &lt;li&gt;&lt;b&gt;IPv6 CIDR:&lt;/b&gt; 2001:db8::/32&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Network Details:&lt;/b&gt; CIDR range, first/last IP, total addresses&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region for the network block&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, organization, ISP information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Network type and usage category&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Analyzing suspicious network ranges&lt;/li&gt;     &lt;li&gt;Bulk geolocation for network blocks&lt;/li&gt;     &lt;li&gt;Infrastructure mapping and reconnaissance&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved network geolocation data.
     * <p><b>400</b> - Invalid CIDR format or network specification.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Network not found in geolocation database.
     * @param cidr The network range in CIDR notation (e.g., 8.8.8.0/24 or 2001:db8::/32).
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getNetworkLocationRequestCreation(@jakarta.annotation.Nonnull String cidr) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'cidr' is set
        if (cidr == null) {
            throw new WebClientResponseException("Missing the required parameter 'cidr' when calling getNetworkLocation", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "cidr", cidr));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/location/network", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Network/CIDR Geolocation Data
     * &lt;p&gt;Returns geolocation and network information for an entire network range specified in CIDR notation. Useful for analyzing network blocks, ranges, and subnets.&lt;/p&gt; &lt;h4&gt;Supported Formats:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPv4 CIDR:&lt;/b&gt; 192.168.1.0/24&lt;/li&gt;     &lt;li&gt;&lt;b&gt;IPv6 CIDR:&lt;/b&gt; 2001:db8::/32&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Network Details:&lt;/b&gt; CIDR range, first/last IP, total addresses&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region for the network block&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, organization, ISP information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Network type and usage category&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Analyzing suspicious network ranges&lt;/li&gt;     &lt;li&gt;Bulk geolocation for network blocks&lt;/li&gt;     &lt;li&gt;Infrastructure mapping and reconnaissance&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved network geolocation data.
     * <p><b>400</b> - Invalid CIDR format or network specification.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Network not found in geolocation database.
     * @param cidr The network range in CIDR notation (e.g., 8.8.8.0/24 or 2001:db8::/32).
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getNetworkLocation(@jakarta.annotation.Nonnull String cidr) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getNetworkLocationRequestCreation(cidr).bodyToMono(localVarReturnType);
    }

    /**
     * Get Network/CIDR Geolocation Data
     * &lt;p&gt;Returns geolocation and network information for an entire network range specified in CIDR notation. Useful for analyzing network blocks, ranges, and subnets.&lt;/p&gt; &lt;h4&gt;Supported Formats:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPv4 CIDR:&lt;/b&gt; 192.168.1.0/24&lt;/li&gt;     &lt;li&gt;&lt;b&gt;IPv6 CIDR:&lt;/b&gt; 2001:db8::/32&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Network Details:&lt;/b&gt; CIDR range, first/last IP, total addresses&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region for the network block&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, organization, ISP information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Network type and usage category&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Analyzing suspicious network ranges&lt;/li&gt;     &lt;li&gt;Bulk geolocation for network blocks&lt;/li&gt;     &lt;li&gt;Infrastructure mapping and reconnaissance&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved network geolocation data.
     * <p><b>400</b> - Invalid CIDR format or network specification.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Network not found in geolocation database.
     * @param cidr The network range in CIDR notation (e.g., 8.8.8.0/24 or 2001:db8::/32).
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getNetworkLocationWithHttpInfo(@jakarta.annotation.Nonnull String cidr) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getNetworkLocationRequestCreation(cidr).toEntity(localVarReturnType);
    }

    /**
     * Get Network/CIDR Geolocation Data
     * &lt;p&gt;Returns geolocation and network information for an entire network range specified in CIDR notation. Useful for analyzing network blocks, ranges, and subnets.&lt;/p&gt; &lt;h4&gt;Supported Formats:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPv4 CIDR:&lt;/b&gt; 192.168.1.0/24&lt;/li&gt;     &lt;li&gt;&lt;b&gt;IPv6 CIDR:&lt;/b&gt; 2001:db8::/32&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Network Details:&lt;/b&gt; CIDR range, first/last IP, total addresses&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; Country, city, region for the network block&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; ASN, organization, ISP information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Classification:&lt;/b&gt; Network type and usage category&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Analyzing suspicious network ranges&lt;/li&gt;     &lt;li&gt;Bulk geolocation for network blocks&lt;/li&gt;     &lt;li&gt;Infrastructure mapping and reconnaissance&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved network geolocation data.
     * <p><b>400</b> - Invalid CIDR format or network specification.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Network not found in geolocation database.
     * @param cidr The network range in CIDR notation (e.g., 8.8.8.0/24 or 2001:db8::/32).
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getNetworkLocationWithResponseSpec(@jakarta.annotation.Nonnull String cidr) throws WebClientResponseException {
        return getNetworkLocationRequestCreation(cidr);
    }

    /**
     * Search Geolocation Database by Field
     * &lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Limiting:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Use the &lt;code&gt;limit&lt;/code&gt; parameter to control the number of results (max 1000, default 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Note:&lt;/b&gt; Pagination is not currently supported. Use smaller &lt;code&gt;limit&lt;/code&gt; values for faster responses.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;totalHits&lt;/code&gt;: Total number of matching records in the database&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of matching IP records (up to &lt;code&gt;limit&lt;/code&gt;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;timeTakenMs&lt;/code&gt;: Query execution time in milliseconds&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved search results.
     * <p><b>400</b> - Invalid search field or parameters.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * @param field The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude
     * @param value The value to search for in the specified field.
     * @param limit Maximum number of results to return (1-1000). Default: 100. Note: Pagination is not currently supported - use smaller limits for faster responses.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec searchLocationRequestCreation(@jakarta.annotation.Nonnull String field, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String limit) throws WebClientResponseException {
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
     * &lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Limiting:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Use the &lt;code&gt;limit&lt;/code&gt; parameter to control the number of results (max 1000, default 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Note:&lt;/b&gt; Pagination is not currently supported. Use smaller &lt;code&gt;limit&lt;/code&gt; values for faster responses.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;totalHits&lt;/code&gt;: Total number of matching records in the database&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of matching IP records (up to &lt;code&gt;limit&lt;/code&gt;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;timeTakenMs&lt;/code&gt;: Query execution time in milliseconds&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved search results.
     * <p><b>400</b> - Invalid search field or parameters.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * @param field The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude
     * @param value The value to search for in the specified field.
     * @param limit Maximum number of results to return (1-1000). Default: 100. Note: Pagination is not currently supported - use smaller limits for faster responses.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> searchLocation(@jakarta.annotation.Nonnull String field, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return searchLocationRequestCreation(field, value, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Search Geolocation Database by Field
     * &lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Limiting:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Use the &lt;code&gt;limit&lt;/code&gt; parameter to control the number of results (max 1000, default 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Note:&lt;/b&gt; Pagination is not currently supported. Use smaller &lt;code&gt;limit&lt;/code&gt; values for faster responses.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;totalHits&lt;/code&gt;: Total number of matching records in the database&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of matching IP records (up to &lt;code&gt;limit&lt;/code&gt;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;timeTakenMs&lt;/code&gt;: Query execution time in milliseconds&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved search results.
     * <p><b>400</b> - Invalid search field or parameters.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * @param field The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude
     * @param value The value to search for in the specified field.
     * @param limit Maximum number of results to return (1-1000). Default: 100. Note: Pagination is not currently supported - use smaller limits for faster responses.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> searchLocationWithHttpInfo(@jakarta.annotation.Nonnull String field, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return searchLocationRequestCreation(field, value, limit).toEntity(localVarReturnType);
    }

    /**
     * Search Geolocation Database by Field
     * &lt;p&gt;Search the geolocation database by specific fields to find all IP addresses matching your criteria. Powerful for threat hunting, infrastructure discovery, and pattern analysis.&lt;/p&gt; &lt;h4&gt;Searchable Fields:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Geographic:&lt;/b&gt; city, country, country_code, region, postal_code, continent, continent_code&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Network:&lt;/b&gt; asn, as_number, organization, isp, isp_name&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Coordinates:&lt;/b&gt; latitude, longitude&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Query Examples:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in a city:&lt;/b&gt; field&#x3D;city&amp;value&#x3D;London&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ASN:&lt;/b&gt; field&#x3D;asn&amp;value&#x3D;15169&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs for an ISP:&lt;/b&gt; field&#x3D;isp_name&amp;value&#x3D;Google&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Find all IPs in country:&lt;/b&gt; field&#x3D;country_code&amp;value&#x3D;US&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Limiting:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Use the &lt;code&gt;limit&lt;/code&gt; parameter to control the number of results (max 1000, default 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Note:&lt;/b&gt; Pagination is not currently supported. Use smaller &lt;code&gt;limit&lt;/code&gt; values for faster responses.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Response Time:&lt;/b&gt; 200-500ms depending on result size&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Rate Limit:&lt;/b&gt; 5 searches per minute&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;totalHits&lt;/code&gt;: Total number of matching records in the database&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of matching IP records (up to &lt;code&gt;limit&lt;/code&gt;)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;timeTakenMs&lt;/code&gt;: Query execution time in milliseconds&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Infrastructure mapping for threat actors&lt;/li&gt;     &lt;li&gt;Finding all IPs in a specific region for compliance&lt;/li&gt;     &lt;li&gt;Discovering VPN/proxy exit nodes&lt;/li&gt;     &lt;li&gt;Threat hunting by ISP or ASN&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved search results.
     * <p><b>400</b> - Invalid search field or parameters.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * @param field The field to search. Valid fields: city, country, country_code, isp_name, isp, asn, as_number, organization, continent, continent_code, region, postal_code, latitude, longitude
     * @param value The value to search for in the specified field.
     * @param limit Maximum number of results to return (1-1000). Default: 100. Note: Pagination is not currently supported - use smaller limits for faster responses.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec searchLocationWithResponseSpec(@jakarta.annotation.Nonnull String field, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String limit) throws WebClientResponseException {
        return searchLocationRequestCreation(field, value, limit);
    }
}
