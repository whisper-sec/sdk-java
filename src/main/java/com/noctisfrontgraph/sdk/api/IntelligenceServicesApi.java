package com.noctisfrontgraph.sdk.api;

import com.noctisfrontgraph.sdk.invoker.ApiClient;

import com.noctisfrontgraph.sdk.model.DomainIntelligenceResponse;
import com.noctisfrontgraph.sdk.model.ErrorResponse;
import com.noctisfrontgraph.sdk.model.IpIntelligenceResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-09-15T11:53:44.371328345Z[Etc/UTC]", comments = "Generator version: 7.13.0")
public class IntelligenceServicesApi {
    private ApiClient apiClient;

    public IntelligenceServicesApi() {
        this(new ApiClient());
    }

    @Autowired
    public IntelligenceServicesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    
    /**
     * Get comprehensive domain intelligence with streaming support
     * Analyzes a domain name and returns comprehensive intelligence data from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-5 seconds - **Streaming Mode**: Server-Sent Events with 200ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - WHOIS registration data with ownership history - Complete DNS record enumeration (A, AAAA, MX, NS, TXT, CNAME, SOA) - Subdomain discovery and enumeration - Link analysis showing connected domains - IP intelligence for all resolved addresses - Trademark and brand protection status - Infrastructure relationships and shared hosting  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/domain/example.com &#x60;&#x60;&#x60;  **Streaming Events:** - &#x60;whois&#x60;: Domain registration info - &#x60;dns&#x60;: DNS records - &#x60;subdomains&#x60;: Discovered subdomains - &#x60;ip_intelligence&#x60;: Intelligence for each resolved IP - &#x60;complete&#x60;: Final aggregated data  **Input Processing:** - Automatically strips protocols (http://, https://) - Removes www prefix if present - Validates domain format before processing  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.
     * <p><b>200</b> - Domain intelligence data successfully retrieved
     * <p><b>400</b> - Invalid domain name format
     * <p><b>401</b> - Authentication required
     * <p><b>404</b> - Domain not found or unregistered
     * <p><b>429</b> - Rate limit exceeded
     * <p><b>500</b> - Internal server error during intelligence aggregation
     * @param domain Domain name to analyze. Can be a root domain or subdomain. Protocol and www prefix are automatically removed.
     * @return DomainIntelligenceResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getDomainIntelligenceRequestCreation(@javax.annotation.Nonnull String domain) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'domain' is set
        if (domain == null) {
            throw new WebClientResponseException("Missing the required parameter 'domain' when calling getDomainIntelligence", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("domain", domain);

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

        ParameterizedTypeReference<DomainIntelligenceResponse> localVarReturnType = new ParameterizedTypeReference<DomainIntelligenceResponse>() {};
        return apiClient.invokeAPI("/intelligence/v1/domain/{domain}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get comprehensive domain intelligence with streaming support
     * Analyzes a domain name and returns comprehensive intelligence data from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-5 seconds - **Streaming Mode**: Server-Sent Events with 200ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - WHOIS registration data with ownership history - Complete DNS record enumeration (A, AAAA, MX, NS, TXT, CNAME, SOA) - Subdomain discovery and enumeration - Link analysis showing connected domains - IP intelligence for all resolved addresses - Trademark and brand protection status - Infrastructure relationships and shared hosting  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/domain/example.com &#x60;&#x60;&#x60;  **Streaming Events:** - &#x60;whois&#x60;: Domain registration info - &#x60;dns&#x60;: DNS records - &#x60;subdomains&#x60;: Discovered subdomains - &#x60;ip_intelligence&#x60;: Intelligence for each resolved IP - &#x60;complete&#x60;: Final aggregated data  **Input Processing:** - Automatically strips protocols (http://, https://) - Removes www prefix if present - Validates domain format before processing  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.
     * <p><b>200</b> - Domain intelligence data successfully retrieved
     * <p><b>400</b> - Invalid domain name format
     * <p><b>401</b> - Authentication required
     * <p><b>404</b> - Domain not found or unregistered
     * <p><b>429</b> - Rate limit exceeded
     * <p><b>500</b> - Internal server error during intelligence aggregation
     * @param domain Domain name to analyze. Can be a root domain or subdomain. Protocol and www prefix are automatically removed.
     * @return DomainIntelligenceResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DomainIntelligenceResponse> getDomainIntelligence(@javax.annotation.Nonnull String domain) throws WebClientResponseException {
        ParameterizedTypeReference<DomainIntelligenceResponse> localVarReturnType = new ParameterizedTypeReference<DomainIntelligenceResponse>() {};
        return getDomainIntelligenceRequestCreation(domain).bodyToMono(localVarReturnType);
    }

    /**
     * Get comprehensive domain intelligence with streaming support
     * Analyzes a domain name and returns comprehensive intelligence data from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-5 seconds - **Streaming Mode**: Server-Sent Events with 200ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - WHOIS registration data with ownership history - Complete DNS record enumeration (A, AAAA, MX, NS, TXT, CNAME, SOA) - Subdomain discovery and enumeration - Link analysis showing connected domains - IP intelligence for all resolved addresses - Trademark and brand protection status - Infrastructure relationships and shared hosting  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/domain/example.com &#x60;&#x60;&#x60;  **Streaming Events:** - &#x60;whois&#x60;: Domain registration info - &#x60;dns&#x60;: DNS records - &#x60;subdomains&#x60;: Discovered subdomains - &#x60;ip_intelligence&#x60;: Intelligence for each resolved IP - &#x60;complete&#x60;: Final aggregated data  **Input Processing:** - Automatically strips protocols (http://, https://) - Removes www prefix if present - Validates domain format before processing  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.
     * <p><b>200</b> - Domain intelligence data successfully retrieved
     * <p><b>400</b> - Invalid domain name format
     * <p><b>401</b> - Authentication required
     * <p><b>404</b> - Domain not found or unregistered
     * <p><b>429</b> - Rate limit exceeded
     * <p><b>500</b> - Internal server error during intelligence aggregation
     * @param domain Domain name to analyze. Can be a root domain or subdomain. Protocol and www prefix are automatically removed.
     * @return ResponseEntity&lt;DomainIntelligenceResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<DomainIntelligenceResponse>> getDomainIntelligenceWithHttpInfo(@javax.annotation.Nonnull String domain) throws WebClientResponseException {
        ParameterizedTypeReference<DomainIntelligenceResponse> localVarReturnType = new ParameterizedTypeReference<DomainIntelligenceResponse>() {};
        return getDomainIntelligenceRequestCreation(domain).toEntity(localVarReturnType);
    }

    /**
     * Get comprehensive domain intelligence with streaming support
     * Analyzes a domain name and returns comprehensive intelligence data from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-5 seconds - **Streaming Mode**: Server-Sent Events with 200ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - WHOIS registration data with ownership history - Complete DNS record enumeration (A, AAAA, MX, NS, TXT, CNAME, SOA) - Subdomain discovery and enumeration - Link analysis showing connected domains - IP intelligence for all resolved addresses - Trademark and brand protection status - Infrastructure relationships and shared hosting  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/domain/example.com &#x60;&#x60;&#x60;  **Streaming Events:** - &#x60;whois&#x60;: Domain registration info - &#x60;dns&#x60;: DNS records - &#x60;subdomains&#x60;: Discovered subdomains - &#x60;ip_intelligence&#x60;: Intelligence for each resolved IP - &#x60;complete&#x60;: Final aggregated data  **Input Processing:** - Automatically strips protocols (http://, https://) - Removes www prefix if present - Validates domain format before processing  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.
     * <p><b>200</b> - Domain intelligence data successfully retrieved
     * <p><b>400</b> - Invalid domain name format
     * <p><b>401</b> - Authentication required
     * <p><b>404</b> - Domain not found or unregistered
     * <p><b>429</b> - Rate limit exceeded
     * <p><b>500</b> - Internal server error during intelligence aggregation
     * @param domain Domain name to analyze. Can be a root domain or subdomain. Protocol and www prefix are automatically removed.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getDomainIntelligenceWithResponseSpec(@javax.annotation.Nonnull String domain) throws WebClientResponseException {
        return getDomainIntelligenceRequestCreation(domain);
    }

    /**
     * Get comprehensive IP address intelligence with streaming support
     * Analyzes an IP address and returns comprehensive intelligence data aggregated from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-3 seconds - **Streaming Mode**: Server-Sent Events with 150ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - Geolocation with city-level precision and confidence scores - Network topology including ASN, BGP prefixes, and routing visibility - ISP and organization identification - DNS relationships showing associated domains - Risk scoring based on threat intelligence feeds - RPKI validation and routing security assessment - Historical routing data and stability metrics  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/ip/8.8.8.8 &#x60;&#x60;&#x60;  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.
     * <p><b>200</b> - IP intelligence data successfully retrieved
     * <p><b>400</b> - Invalid IP address format
     * <p><b>401</b> - Authentication required
     * <p><b>404</b> - IP address not found or private/reserved
     * <p><b>429</b> - Rate limit exceeded
     * <p><b>500</b> - Internal server error during intelligence aggregation
     * @param address IPv4 or IPv6 address to analyze. Supports standard notation (e.g., 192.168.1.1 or 2001:db8::1)
     * @return IpIntelligenceResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIpIntelligenceRequestCreation(@javax.annotation.Nonnull String address) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'address' is set
        if (address == null) {
            throw new WebClientResponseException("Missing the required parameter 'address' when calling getIpIntelligence", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("address", address);

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

        ParameterizedTypeReference<IpIntelligenceResponse> localVarReturnType = new ParameterizedTypeReference<IpIntelligenceResponse>() {};
        return apiClient.invokeAPI("/intelligence/v1/ip/{address}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get comprehensive IP address intelligence with streaming support
     * Analyzes an IP address and returns comprehensive intelligence data aggregated from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-3 seconds - **Streaming Mode**: Server-Sent Events with 150ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - Geolocation with city-level precision and confidence scores - Network topology including ASN, BGP prefixes, and routing visibility - ISP and organization identification - DNS relationships showing associated domains - Risk scoring based on threat intelligence feeds - RPKI validation and routing security assessment - Historical routing data and stability metrics  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/ip/8.8.8.8 &#x60;&#x60;&#x60;  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.
     * <p><b>200</b> - IP intelligence data successfully retrieved
     * <p><b>400</b> - Invalid IP address format
     * <p><b>401</b> - Authentication required
     * <p><b>404</b> - IP address not found or private/reserved
     * <p><b>429</b> - Rate limit exceeded
     * <p><b>500</b> - Internal server error during intelligence aggregation
     * @param address IPv4 or IPv6 address to analyze. Supports standard notation (e.g., 192.168.1.1 or 2001:db8::1)
     * @return IpIntelligenceResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<IpIntelligenceResponse> getIpIntelligence(@javax.annotation.Nonnull String address) throws WebClientResponseException {
        ParameterizedTypeReference<IpIntelligenceResponse> localVarReturnType = new ParameterizedTypeReference<IpIntelligenceResponse>() {};
        return getIpIntelligenceRequestCreation(address).bodyToMono(localVarReturnType);
    }

    /**
     * Get comprehensive IP address intelligence with streaming support
     * Analyzes an IP address and returns comprehensive intelligence data aggregated from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-3 seconds - **Streaming Mode**: Server-Sent Events with 150ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - Geolocation with city-level precision and confidence scores - Network topology including ASN, BGP prefixes, and routing visibility - ISP and organization identification - DNS relationships showing associated domains - Risk scoring based on threat intelligence feeds - RPKI validation and routing security assessment - Historical routing data and stability metrics  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/ip/8.8.8.8 &#x60;&#x60;&#x60;  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.
     * <p><b>200</b> - IP intelligence data successfully retrieved
     * <p><b>400</b> - Invalid IP address format
     * <p><b>401</b> - Authentication required
     * <p><b>404</b> - IP address not found or private/reserved
     * <p><b>429</b> - Rate limit exceeded
     * <p><b>500</b> - Internal server error during intelligence aggregation
     * @param address IPv4 or IPv6 address to analyze. Supports standard notation (e.g., 192.168.1.1 or 2001:db8::1)
     * @return ResponseEntity&lt;IpIntelligenceResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<IpIntelligenceResponse>> getIpIntelligenceWithHttpInfo(@javax.annotation.Nonnull String address) throws WebClientResponseException {
        ParameterizedTypeReference<IpIntelligenceResponse> localVarReturnType = new ParameterizedTypeReference<IpIntelligenceResponse>() {};
        return getIpIntelligenceRequestCreation(address).toEntity(localVarReturnType);
    }

    /**
     * Get comprehensive IP address intelligence with streaming support
     * Analyzes an IP address and returns comprehensive intelligence data aggregated from multiple sources.  **🚀 Response Modes:** - **Batch Mode** (Default): Complete JSON response in 2-3 seconds - **Streaming Mode**: Server-Sent Events with 150ms time-to-first-byte   - Accept: &#x60;application/json&#x60; for batch mode   - Accept: &#x60;text/event-stream&#x60; for streaming mode  **Key Features:** - Geolocation with city-level precision and confidence scores - Network topology including ASN, BGP prefixes, and routing visibility - ISP and organization identification - DNS relationships showing associated domains - Risk scoring based on threat intelligence feeds - RPKI validation and routing security assessment - Historical routing data and stability metrics  **Streaming Example:** &#x60;&#x60;&#x60;bash curl -N -H &#39;Accept: text/event-stream&#39; \\      -H &#39;Authorization: Bearer {token}&#39; \\      https://api.example.com/intelligence/v1/ip/8.8.8.8 &#x60;&#x60;&#x60;  **Note:** Swagger UI only displays batch mode. Use curl or EventSource for streaming.
     * <p><b>200</b> - IP intelligence data successfully retrieved
     * <p><b>400</b> - Invalid IP address format
     * <p><b>401</b> - Authentication required
     * <p><b>404</b> - IP address not found or private/reserved
     * <p><b>429</b> - Rate limit exceeded
     * <p><b>500</b> - Internal server error during intelligence aggregation
     * @param address IPv4 or IPv6 address to analyze. Supports standard notation (e.g., 192.168.1.1 or 2001:db8::1)
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIpIntelligenceWithResponseSpec(@javax.annotation.Nonnull String address) throws WebClientResponseException {
        return getIpIntelligenceRequestCreation(address);
    }
}
