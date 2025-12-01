package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.BulkRequest;
import io.github.whispersec.model.ChangeTrackingRequest;
import io.github.whispersec.model.ChangeTrackingResponse;
import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.InfrastructureMapRequest;
import io.github.whispersec.model.Job;
import io.github.whispersec.model.JobResponse;
import io.github.whispersec.model.MonitorCheckRequest;
import io.github.whispersec.model.MonitorCheckResponse;
import io.github.whispersec.model.MonitorDashboardResponse;
import io.github.whispersec.model.MonitorListResponse;
import io.github.whispersec.model.MonitoringAlertRequest;
import io.github.whispersec.model.ScanRequest;
import io.github.whispersec.model.ScreenshotRequest;
import io.github.whispersec.model.SearchRequest;
import io.github.whispersec.model.SimilarDomainsOpsRequest;
import io.github.whispersec.model.TrackingConfig;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-01T14:38:21.899985563Z[Etc/UTC]", comments = "Generator version: 7.17.0")
public class OperationsApi {
    private ApiClient apiClient;

    public OperationsApi() {
        this(new ApiClient());
    }

    public OperationsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance:&lt;/b&gt; Processing time depends on batch size and requested data modules. Expect 5-30 seconds for typical batches.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Rate Limits:&lt;/b&gt; Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt; 
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Bulk job successfully accepted for processing.
     * @param bulkRequest List of indicators and processing options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec bulkEnrichmentRequestCreation(@jakarta.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        Object postBody = bulkRequest;
        // verify the required parameter 'bulkRequest' is set
        if (bulkRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'bulkRequest' when calling bulkEnrichment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/enrichment/bulk", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance:&lt;/b&gt; Processing time depends on batch size and requested data modules. Expect 5-30 seconds for typical batches.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Rate Limits:&lt;/b&gt; Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt; 
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Bulk job successfully accepted for processing.
     * @param bulkRequest List of indicators and processing options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> bulkEnrichment(@jakarta.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return bulkEnrichmentRequestCreation(bulkRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance:&lt;/b&gt; Processing time depends on batch size and requested data modules. Expect 5-30 seconds for typical batches.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Rate Limits:&lt;/b&gt; Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt; 
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Bulk job successfully accepted for processing.
     * @param bulkRequest List of indicators and processing options.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> bulkEnrichmentWithHttpInfo(@jakarta.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return bulkEnrichmentRequestCreation(bulkRequest).toEntity(localVarReturnType);
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance:&lt;/b&gt; Processing time depends on batch size and requested data modules. Expect 5-30 seconds for typical batches.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Rate Limits:&lt;/b&gt; Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt; 
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Bulk job successfully accepted for processing.
     * @param bulkRequest List of indicators and processing options.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec bulkEnrichmentWithResponseSpec(@jakarta.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        return bulkEnrichmentRequestCreation(bulkRequest);
    }

    /**
     * Map Infrastructure Relationships (Asynchronous)
     * &lt;p&gt;Creates a comprehensive map of infrastructure relationships starting from a domain or IP. Discovers connected assets through shared hosting, DNS, certificates, and network relationships.&lt;/p&gt; &lt;h4&gt;Mapping Depth Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Depth 1:&lt;/b&gt; Direct relationships only (~30 seconds, 10-50 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 2:&lt;/b&gt; 2 hops out (~2-5 minutes, 50-500 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 3:&lt;/b&gt; 3 hops out (~10-30 minutes, 500-5000 assets)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Relationship Types Discovered:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Domains on same IP&lt;/li&gt;     &lt;li&gt;Domains sharing nameservers&lt;/li&gt;     &lt;li&gt;Domains with same SSL certificate&lt;/li&gt;     &lt;li&gt;IPs in same ASN&lt;/li&gt;     &lt;li&gt;Domains with same registrant&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Results returned as graph data compatible with visualization libraries (nodes and edges).&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Threat actor infrastructure mapping&lt;/li&gt;     &lt;li&gt;Discovering related phishing domains&lt;/li&gt;     &lt;li&gt;Finding shadow IT and forgotten assets&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * @param infrastructureMapRequest Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60; 
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createInfrastructureMapRequestCreation(@jakarta.annotation.Nonnull InfrastructureMapRequest infrastructureMapRequest) throws WebClientResponseException {
        Object postBody = infrastructureMapRequest;
        // verify the required parameter 'infrastructureMapRequest' is set
        if (infrastructureMapRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'infrastructureMapRequest' when calling createInfrastructureMap", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/scans/map", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Map Infrastructure Relationships (Asynchronous)
     * &lt;p&gt;Creates a comprehensive map of infrastructure relationships starting from a domain or IP. Discovers connected assets through shared hosting, DNS, certificates, and network relationships.&lt;/p&gt; &lt;h4&gt;Mapping Depth Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Depth 1:&lt;/b&gt; Direct relationships only (~30 seconds, 10-50 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 2:&lt;/b&gt; 2 hops out (~2-5 minutes, 50-500 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 3:&lt;/b&gt; 3 hops out (~10-30 minutes, 500-5000 assets)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Relationship Types Discovered:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Domains on same IP&lt;/li&gt;     &lt;li&gt;Domains sharing nameservers&lt;/li&gt;     &lt;li&gt;Domains with same SSL certificate&lt;/li&gt;     &lt;li&gt;IPs in same ASN&lt;/li&gt;     &lt;li&gt;Domains with same registrant&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Results returned as graph data compatible with visualization libraries (nodes and edges).&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Threat actor infrastructure mapping&lt;/li&gt;     &lt;li&gt;Discovering related phishing domains&lt;/li&gt;     &lt;li&gt;Finding shadow IT and forgotten assets&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * @param infrastructureMapRequest Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60; 
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> createInfrastructureMap(@jakarta.annotation.Nonnull InfrastructureMapRequest infrastructureMapRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createInfrastructureMapRequestCreation(infrastructureMapRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Map Infrastructure Relationships (Asynchronous)
     * &lt;p&gt;Creates a comprehensive map of infrastructure relationships starting from a domain or IP. Discovers connected assets through shared hosting, DNS, certificates, and network relationships.&lt;/p&gt; &lt;h4&gt;Mapping Depth Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Depth 1:&lt;/b&gt; Direct relationships only (~30 seconds, 10-50 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 2:&lt;/b&gt; 2 hops out (~2-5 minutes, 50-500 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 3:&lt;/b&gt; 3 hops out (~10-30 minutes, 500-5000 assets)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Relationship Types Discovered:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Domains on same IP&lt;/li&gt;     &lt;li&gt;Domains sharing nameservers&lt;/li&gt;     &lt;li&gt;Domains with same SSL certificate&lt;/li&gt;     &lt;li&gt;IPs in same ASN&lt;/li&gt;     &lt;li&gt;Domains with same registrant&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Results returned as graph data compatible with visualization libraries (nodes and edges).&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Threat actor infrastructure mapping&lt;/li&gt;     &lt;li&gt;Discovering related phishing domains&lt;/li&gt;     &lt;li&gt;Finding shadow IT and forgotten assets&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * @param infrastructureMapRequest Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60; 
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> createInfrastructureMapWithHttpInfo(@jakarta.annotation.Nonnull InfrastructureMapRequest infrastructureMapRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createInfrastructureMapRequestCreation(infrastructureMapRequest).toEntity(localVarReturnType);
    }

    /**
     * Map Infrastructure Relationships (Asynchronous)
     * &lt;p&gt;Creates a comprehensive map of infrastructure relationships starting from a domain or IP. Discovers connected assets through shared hosting, DNS, certificates, and network relationships.&lt;/p&gt; &lt;h4&gt;Mapping Depth Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Depth 1:&lt;/b&gt; Direct relationships only (~30 seconds, 10-50 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 2:&lt;/b&gt; 2 hops out (~2-5 minutes, 50-500 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 3:&lt;/b&gt; 3 hops out (~10-30 minutes, 500-5000 assets)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Relationship Types Discovered:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Domains on same IP&lt;/li&gt;     &lt;li&gt;Domains sharing nameservers&lt;/li&gt;     &lt;li&gt;Domains with same SSL certificate&lt;/li&gt;     &lt;li&gt;IPs in same ASN&lt;/li&gt;     &lt;li&gt;Domains with same registrant&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Results returned as graph data compatible with visualization libraries (nodes and edges).&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Threat actor infrastructure mapping&lt;/li&gt;     &lt;li&gt;Discovering related phishing domains&lt;/li&gt;     &lt;li&gt;Finding shadow IT and forgotten assets&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * @param infrastructureMapRequest Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60; 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createInfrastructureMapWithResponseSpec(@jakarta.annotation.Nonnull InfrastructureMapRequest infrastructureMapRequest) throws WebClientResponseException {
        return createInfrastructureMapRequestCreation(infrastructureMapRequest);
    }

    /**
     * Infrastructure Security Scan (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive security scan of a domain&#39;s infrastructure. Performs reconnaissance, port scanning, service detection, and vulnerability assessment.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (recommended for complete assessment)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration only&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ports:&lt;/b&gt; Port scanning and service detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerabilities:&lt;/b&gt; Known vulnerability checks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS configuration and certificate analysis&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS configuration and zone transfer tests&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration and ownership information&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 30-60 seconds (subdomains, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 5-15 minutes depending on infrastructure size&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;Infrastructure inventory and mapping&lt;/li&gt;     &lt;li&gt;Vulnerability management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain or scan type.
     * @param scanRequest Scan configuration including target domain and scan type.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createInfrastructureScanRequestCreation(@jakarta.annotation.Nonnull ScanRequest scanRequest) throws WebClientResponseException {
        Object postBody = scanRequest;
        // verify the required parameter 'scanRequest' is set
        if (scanRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'scanRequest' when calling createInfrastructureScan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/scans/infrastructure", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Infrastructure Security Scan (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive security scan of a domain&#39;s infrastructure. Performs reconnaissance, port scanning, service detection, and vulnerability assessment.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (recommended for complete assessment)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration only&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ports:&lt;/b&gt; Port scanning and service detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerabilities:&lt;/b&gt; Known vulnerability checks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS configuration and certificate analysis&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS configuration and zone transfer tests&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration and ownership information&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 30-60 seconds (subdomains, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 5-15 minutes depending on infrastructure size&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;Infrastructure inventory and mapping&lt;/li&gt;     &lt;li&gt;Vulnerability management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain or scan type.
     * @param scanRequest Scan configuration including target domain and scan type.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> createInfrastructureScan(@jakarta.annotation.Nonnull ScanRequest scanRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createInfrastructureScanRequestCreation(scanRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Infrastructure Security Scan (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive security scan of a domain&#39;s infrastructure. Performs reconnaissance, port scanning, service detection, and vulnerability assessment.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (recommended for complete assessment)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration only&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ports:&lt;/b&gt; Port scanning and service detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerabilities:&lt;/b&gt; Known vulnerability checks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS configuration and certificate analysis&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS configuration and zone transfer tests&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration and ownership information&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 30-60 seconds (subdomains, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 5-15 minutes depending on infrastructure size&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;Infrastructure inventory and mapping&lt;/li&gt;     &lt;li&gt;Vulnerability management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain or scan type.
     * @param scanRequest Scan configuration including target domain and scan type.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> createInfrastructureScanWithHttpInfo(@jakarta.annotation.Nonnull ScanRequest scanRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createInfrastructureScanRequestCreation(scanRequest).toEntity(localVarReturnType);
    }

    /**
     * Infrastructure Security Scan (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive security scan of a domain&#39;s infrastructure. Performs reconnaissance, port scanning, service detection, and vulnerability assessment.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (recommended for complete assessment)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration only&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ports:&lt;/b&gt; Port scanning and service detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerabilities:&lt;/b&gt; Known vulnerability checks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS configuration and certificate analysis&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS configuration and zone transfer tests&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration and ownership information&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 30-60 seconds (subdomains, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 5-15 minutes depending on infrastructure size&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;Infrastructure inventory and mapping&lt;/li&gt;     &lt;li&gt;Vulnerability management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain or scan type.
     * @param scanRequest Scan configuration including target domain and scan type.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createInfrastructureScanWithResponseSpec(@jakarta.annotation.Nonnull ScanRequest scanRequest) throws WebClientResponseException {
        return createInfrastructureScanRequestCreation(scanRequest);
    }

    /**
     * Create Monitoring Check
     * &lt;p&gt;Create a new monitoring check to track uptime and performance of a URL or endpoint.&lt;/p&gt; &lt;h4&gt;Check Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;api:&lt;/b&gt; HTTP/HTTPS endpoint monitoring - checks status code, response time, content&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL certificate monitoring - validates certificate and tracks expiry&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record monitoring - validates DNS resolution and record values&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequency Options:&lt;/h4&gt; &lt;p&gt;Check frequency in minutes: 1, 5, 10, 15, 30, 60, 1440 (daily)&lt;/p&gt; &lt;h4&gt;Locations:&lt;/h4&gt; &lt;p&gt;Checks can run from multiple global locations: us-east-1, us-west-1, eu-west-1, ap-southeast-1&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>201</b> - Monitoring check created successfully.
     * <p><b>400</b> - Invalid request - missing name or URL.
     * @param monitorCheckRequest Monitoring check configuration
     * @return MonitorCheckResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createMonitorCheckRequestCreation(@jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        Object postBody = monitorCheckRequest;
        // verify the required parameter 'monitorCheckRequest' is set
        if (monitorCheckRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'monitorCheckRequest' when calling createMonitorCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<MonitorCheckResponse> localVarReturnType = new ParameterizedTypeReference<MonitorCheckResponse>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Monitoring Check
     * &lt;p&gt;Create a new monitoring check to track uptime and performance of a URL or endpoint.&lt;/p&gt; &lt;h4&gt;Check Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;api:&lt;/b&gt; HTTP/HTTPS endpoint monitoring - checks status code, response time, content&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL certificate monitoring - validates certificate and tracks expiry&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record monitoring - validates DNS resolution and record values&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequency Options:&lt;/h4&gt; &lt;p&gt;Check frequency in minutes: 1, 5, 10, 15, 30, 60, 1440 (daily)&lt;/p&gt; &lt;h4&gt;Locations:&lt;/h4&gt; &lt;p&gt;Checks can run from multiple global locations: us-east-1, us-west-1, eu-west-1, ap-southeast-1&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>201</b> - Monitoring check created successfully.
     * <p><b>400</b> - Invalid request - missing name or URL.
     * @param monitorCheckRequest Monitoring check configuration
     * @return MonitorCheckResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<MonitorCheckResponse> createMonitorCheck(@jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorCheckResponse> localVarReturnType = new ParameterizedTypeReference<MonitorCheckResponse>() {};
        return createMonitorCheckRequestCreation(monitorCheckRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Create Monitoring Check
     * &lt;p&gt;Create a new monitoring check to track uptime and performance of a URL or endpoint.&lt;/p&gt; &lt;h4&gt;Check Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;api:&lt;/b&gt; HTTP/HTTPS endpoint monitoring - checks status code, response time, content&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL certificate monitoring - validates certificate and tracks expiry&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record monitoring - validates DNS resolution and record values&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequency Options:&lt;/h4&gt; &lt;p&gt;Check frequency in minutes: 1, 5, 10, 15, 30, 60, 1440 (daily)&lt;/p&gt; &lt;h4&gt;Locations:&lt;/h4&gt; &lt;p&gt;Checks can run from multiple global locations: us-east-1, us-west-1, eu-west-1, ap-southeast-1&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>201</b> - Monitoring check created successfully.
     * <p><b>400</b> - Invalid request - missing name or URL.
     * @param monitorCheckRequest Monitoring check configuration
     * @return ResponseEntity&lt;MonitorCheckResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<MonitorCheckResponse>> createMonitorCheckWithHttpInfo(@jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorCheckResponse> localVarReturnType = new ParameterizedTypeReference<MonitorCheckResponse>() {};
        return createMonitorCheckRequestCreation(monitorCheckRequest).toEntity(localVarReturnType);
    }

    /**
     * Create Monitoring Check
     * &lt;p&gt;Create a new monitoring check to track uptime and performance of a URL or endpoint.&lt;/p&gt; &lt;h4&gt;Check Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;api:&lt;/b&gt; HTTP/HTTPS endpoint monitoring - checks status code, response time, content&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL certificate monitoring - validates certificate and tracks expiry&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record monitoring - validates DNS resolution and record values&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequency Options:&lt;/h4&gt; &lt;p&gt;Check frequency in minutes: 1, 5, 10, 15, 30, 60, 1440 (daily)&lt;/p&gt; &lt;h4&gt;Locations:&lt;/h4&gt; &lt;p&gt;Checks can run from multiple global locations: us-east-1, us-west-1, eu-west-1, ap-southeast-1&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>201</b> - Monitoring check created successfully.
     * <p><b>400</b> - Invalid request - missing name or URL.
     * @param monitorCheckRequest Monitoring check configuration
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createMonitorCheckWithResponseSpec(@jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        return createMonitorCheckRequestCreation(monitorCheckRequest);
    }

    /**
     * Configure Monitoring Alerts (Asynchronous)
     * &lt;p&gt;Create alert rules for a monitored asset. Get notified via webhook, email, or Slack when specific conditions are met.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Site becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; DNS records modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Registration details updated&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Certificate expires soon (7, 14, 30 days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Page content modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Tech stack changes detected&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Webhook (POST to your endpoint)&lt;/li&gt;     &lt;li&gt;Email&lt;/li&gt;     &lt;li&gt;Slack&lt;/li&gt;     &lt;li&gt;PagerDuty&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Example Configuration:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;type\&quot;: \&quot;ssl_expiring\&quot;,   \&quot;threshold_days\&quot;: 14,   \&quot;channels\&quot;: [\&quot;email\&quot;, \&quot;slack\&quot;],   \&quot;email\&quot;: \&quot;alerts@example.com\&quot;,   \&quot;slack_webhook\&quot;: \&quot;https://hooks.slack.com/...\&quot; }&lt;/code&gt;&lt;/pre&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid alert configuration.
     * @param target The domain or IP address to configure alerts for.
     * @param monitoringAlertRequest Alert configuration including type, thresholds, and notification channels.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createMonitoringAlertRequestCreation(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nonnull MonitoringAlertRequest monitoringAlertRequest) throws WebClientResponseException {
        Object postBody = monitoringAlertRequest;
        // verify the required parameter 'target' is set
        if (target == null) {
            throw new WebClientResponseException("Missing the required parameter 'target' when calling createMonitoringAlert", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'monitoringAlertRequest' is set
        if (monitoringAlertRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'monitoringAlertRequest' when calling createMonitoringAlert", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("target", target);

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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring/{target}/alert", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Configure Monitoring Alerts (Asynchronous)
     * &lt;p&gt;Create alert rules for a monitored asset. Get notified via webhook, email, or Slack when specific conditions are met.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Site becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; DNS records modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Registration details updated&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Certificate expires soon (7, 14, 30 days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Page content modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Tech stack changes detected&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Webhook (POST to your endpoint)&lt;/li&gt;     &lt;li&gt;Email&lt;/li&gt;     &lt;li&gt;Slack&lt;/li&gt;     &lt;li&gt;PagerDuty&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Example Configuration:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;type\&quot;: \&quot;ssl_expiring\&quot;,   \&quot;threshold_days\&quot;: 14,   \&quot;channels\&quot;: [\&quot;email\&quot;, \&quot;slack\&quot;],   \&quot;email\&quot;: \&quot;alerts@example.com\&quot;,   \&quot;slack_webhook\&quot;: \&quot;https://hooks.slack.com/...\&quot; }&lt;/code&gt;&lt;/pre&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid alert configuration.
     * @param target The domain or IP address to configure alerts for.
     * @param monitoringAlertRequest Alert configuration including type, thresholds, and notification channels.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> createMonitoringAlert(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nonnull MonitoringAlertRequest monitoringAlertRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createMonitoringAlertRequestCreation(target, monitoringAlertRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Configure Monitoring Alerts (Asynchronous)
     * &lt;p&gt;Create alert rules for a monitored asset. Get notified via webhook, email, or Slack when specific conditions are met.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Site becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; DNS records modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Registration details updated&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Certificate expires soon (7, 14, 30 days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Page content modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Tech stack changes detected&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Webhook (POST to your endpoint)&lt;/li&gt;     &lt;li&gt;Email&lt;/li&gt;     &lt;li&gt;Slack&lt;/li&gt;     &lt;li&gt;PagerDuty&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Example Configuration:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;type\&quot;: \&quot;ssl_expiring\&quot;,   \&quot;threshold_days\&quot;: 14,   \&quot;channels\&quot;: [\&quot;email\&quot;, \&quot;slack\&quot;],   \&quot;email\&quot;: \&quot;alerts@example.com\&quot;,   \&quot;slack_webhook\&quot;: \&quot;https://hooks.slack.com/...\&quot; }&lt;/code&gt;&lt;/pre&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid alert configuration.
     * @param target The domain or IP address to configure alerts for.
     * @param monitoringAlertRequest Alert configuration including type, thresholds, and notification channels.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> createMonitoringAlertWithHttpInfo(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nonnull MonitoringAlertRequest monitoringAlertRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createMonitoringAlertRequestCreation(target, monitoringAlertRequest).toEntity(localVarReturnType);
    }

    /**
     * Configure Monitoring Alerts (Asynchronous)
     * &lt;p&gt;Create alert rules for a monitored asset. Get notified via webhook, email, or Slack when specific conditions are met.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Site becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; DNS records modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Registration details updated&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Certificate expires soon (7, 14, 30 days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Page content modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Tech stack changes detected&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Webhook (POST to your endpoint)&lt;/li&gt;     &lt;li&gt;Email&lt;/li&gt;     &lt;li&gt;Slack&lt;/li&gt;     &lt;li&gt;PagerDuty&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Example Configuration:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;type\&quot;: \&quot;ssl_expiring\&quot;,   \&quot;threshold_days\&quot;: 14,   \&quot;channels\&quot;: [\&quot;email\&quot;, \&quot;slack\&quot;],   \&quot;email\&quot;: \&quot;alerts@example.com\&quot;,   \&quot;slack_webhook\&quot;: \&quot;https://hooks.slack.com/...\&quot; }&lt;/code&gt;&lt;/pre&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid alert configuration.
     * @param target The domain or IP address to configure alerts for.
     * @param monitoringAlertRequest Alert configuration including type, thresholds, and notification channels.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createMonitoringAlertWithResponseSpec(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nonnull MonitoringAlertRequest monitoringAlertRequest) throws WebClientResponseException {
        return createMonitoringAlertRequestCreation(target, monitoringAlertRequest);
    }

    /**
     * Capture a Website Screenshot (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to capture a screenshot of a website. Supports various viewport sizes, full-page captures, and JavaScript rendering.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; A typical screenshot capture takes 10-30 seconds. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve the URL of the final image.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Output:&lt;/b&gt; The job result will contain a URL to download the screenshot image in the specified format (PNG, JPEG, or WebP).&lt;/p&gt; 
     * <p><b>202</b> - Screenshot job successfully accepted.
     * <p><b>400</b> - Invalid URL or options provided.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded.
     * @param screenshotRequest The URL and options for the screenshot capture.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createScreenshotRequestCreation(@jakarta.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        Object postBody = screenshotRequest;
        // verify the required parameter 'screenshotRequest' is set
        if (screenshotRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'screenshotRequest' when calling createScreenshot", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/screenshots/capture", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Capture a Website Screenshot (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to capture a screenshot of a website. Supports various viewport sizes, full-page captures, and JavaScript rendering.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; A typical screenshot capture takes 10-30 seconds. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve the URL of the final image.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Output:&lt;/b&gt; The job result will contain a URL to download the screenshot image in the specified format (PNG, JPEG, or WebP).&lt;/p&gt; 
     * <p><b>202</b> - Screenshot job successfully accepted.
     * <p><b>400</b> - Invalid URL or options provided.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded.
     * @param screenshotRequest The URL and options for the screenshot capture.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> createScreenshot(@jakarta.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createScreenshotRequestCreation(screenshotRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Capture a Website Screenshot (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to capture a screenshot of a website. Supports various viewport sizes, full-page captures, and JavaScript rendering.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; A typical screenshot capture takes 10-30 seconds. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve the URL of the final image.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Output:&lt;/b&gt; The job result will contain a URL to download the screenshot image in the specified format (PNG, JPEG, or WebP).&lt;/p&gt; 
     * <p><b>202</b> - Screenshot job successfully accepted.
     * <p><b>400</b> - Invalid URL or options provided.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded.
     * @param screenshotRequest The URL and options for the screenshot capture.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> createScreenshotWithHttpInfo(@jakarta.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createScreenshotRequestCreation(screenshotRequest).toEntity(localVarReturnType);
    }

    /**
     * Capture a Website Screenshot (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to capture a screenshot of a website. Supports various viewport sizes, full-page captures, and JavaScript rendering.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; A typical screenshot capture takes 10-30 seconds. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve the URL of the final image.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Output:&lt;/b&gt; The job result will contain a URL to download the screenshot image in the specified format (PNG, JPEG, or WebP).&lt;/p&gt; 
     * <p><b>202</b> - Screenshot job successfully accepted.
     * <p><b>400</b> - Invalid URL or options provided.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded.
     * @param screenshotRequest The URL and options for the screenshot capture.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createScreenshotWithResponseSpec(@jakarta.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        return createScreenshotRequestCreation(screenshotRequest);
    }

    /**
     * Delete Monitoring Check
     * Delete a monitoring check and stop all monitoring for the target.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>204</b> - Check deleted successfully.
     * @param checkId Check ID
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteMonitorCheckRequestCreation(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'checkId' is set
        if (checkId == null) {
            throw new WebClientResponseException("Missing the required parameter 'checkId' when calling deleteMonitorCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("checkId", checkId);

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
        return apiClient.invokeAPI("/v1/ops/monitoring/{checkId}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete Monitoring Check
     * Delete a monitoring check and stop all monitoring for the target.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>204</b> - Check deleted successfully.
     * @param checkId Check ID
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteMonitorCheck(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteMonitorCheckRequestCreation(checkId).bodyToMono(localVarReturnType);
    }

    /**
     * Delete Monitoring Check
     * Delete a monitoring check and stop all monitoring for the target.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>204</b> - Check deleted successfully.
     * @param checkId Check ID
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteMonitorCheckWithHttpInfo(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteMonitorCheckRequestCreation(checkId).toEntity(localVarReturnType);
    }

    /**
     * Delete Monitoring Check
     * Delete a monitoring check and stop all monitoring for the target.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>204</b> - Check deleted successfully.
     * @param checkId Check ID
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteMonitorCheckWithResponseSpec(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        return deleteMonitorCheckRequestCreation(checkId);
    }

    /**
     * Get Detected Changes
     * &lt;p&gt;Retrieve detected changes for a tracked indicator. Returns the current tracking configuration, baseline snapshot, and list of all detected changes.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;tracking:&lt;/b&gt; Current tracking configuration (enabled, frequency, fields, next check)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;baseline:&lt;/b&gt; The stored baseline snapshot data&lt;/li&gt;     &lt;li&gt;&lt;b&gt;changes:&lt;/b&gt; Array of detected changes with timestamps, old/new values&lt;/li&gt;     &lt;li&gt;&lt;b&gt;totalChanges:&lt;/b&gt; Total number of changes detected&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Successfully retrieved changes.
     * <p><b>404</b> - Indicator is not being tracked.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param since ISO 8601 timestamp to get changes from
     * @return ChangeTrackingResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getChangesRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String since) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling getChanges", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling getChanges", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "since", since));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<ChangeTrackingResponse> localVarReturnType = new ParameterizedTypeReference<ChangeTrackingResponse>() {};
        return apiClient.invokeAPI("/v1/ops/tracking/{type}/{value}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Detected Changes
     * &lt;p&gt;Retrieve detected changes for a tracked indicator. Returns the current tracking configuration, baseline snapshot, and list of all detected changes.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;tracking:&lt;/b&gt; Current tracking configuration (enabled, frequency, fields, next check)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;baseline:&lt;/b&gt; The stored baseline snapshot data&lt;/li&gt;     &lt;li&gt;&lt;b&gt;changes:&lt;/b&gt; Array of detected changes with timestamps, old/new values&lt;/li&gt;     &lt;li&gt;&lt;b&gt;totalChanges:&lt;/b&gt; Total number of changes detected&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Successfully retrieved changes.
     * <p><b>404</b> - Indicator is not being tracked.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param since ISO 8601 timestamp to get changes from
     * @return ChangeTrackingResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ChangeTrackingResponse> getChanges(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String since) throws WebClientResponseException {
        ParameterizedTypeReference<ChangeTrackingResponse> localVarReturnType = new ParameterizedTypeReference<ChangeTrackingResponse>() {};
        return getChangesRequestCreation(type, value, since).bodyToMono(localVarReturnType);
    }

    /**
     * Get Detected Changes
     * &lt;p&gt;Retrieve detected changes for a tracked indicator. Returns the current tracking configuration, baseline snapshot, and list of all detected changes.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;tracking:&lt;/b&gt; Current tracking configuration (enabled, frequency, fields, next check)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;baseline:&lt;/b&gt; The stored baseline snapshot data&lt;/li&gt;     &lt;li&gt;&lt;b&gt;changes:&lt;/b&gt; Array of detected changes with timestamps, old/new values&lt;/li&gt;     &lt;li&gt;&lt;b&gt;totalChanges:&lt;/b&gt; Total number of changes detected&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Successfully retrieved changes.
     * <p><b>404</b> - Indicator is not being tracked.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param since ISO 8601 timestamp to get changes from
     * @return ResponseEntity&lt;ChangeTrackingResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ChangeTrackingResponse>> getChangesWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String since) throws WebClientResponseException {
        ParameterizedTypeReference<ChangeTrackingResponse> localVarReturnType = new ParameterizedTypeReference<ChangeTrackingResponse>() {};
        return getChangesRequestCreation(type, value, since).toEntity(localVarReturnType);
    }

    /**
     * Get Detected Changes
     * &lt;p&gt;Retrieve detected changes for a tracked indicator. Returns the current tracking configuration, baseline snapshot, and list of all detected changes.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;tracking:&lt;/b&gt; Current tracking configuration (enabled, frequency, fields, next check)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;baseline:&lt;/b&gt; The stored baseline snapshot data&lt;/li&gt;     &lt;li&gt;&lt;b&gt;changes:&lt;/b&gt; Array of detected changes with timestamps, old/new values&lt;/li&gt;     &lt;li&gt;&lt;b&gt;totalChanges:&lt;/b&gt; Total number of changes detected&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Successfully retrieved changes.
     * <p><b>404</b> - Indicator is not being tracked.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param since ISO 8601 timestamp to get changes from
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getChangesWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String since) throws WebClientResponseException {
        return getChangesRequestCreation(type, value, since);
    }

    /**
     * Get Asynchronous Job Status and Results
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>404</b> - Job ID not found.
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param jobId The unique ID of the job, returned from a &#x60;POST&#x60; operation.
     * @return Job
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getJobRequestCreation(@jakarta.annotation.Nonnull String jobId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'jobId' is set
        if (jobId == null) {
            throw new WebClientResponseException("Missing the required parameter 'jobId' when calling getJob", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("jobId", jobId);

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

        ParameterizedTypeReference<Job> localVarReturnType = new ParameterizedTypeReference<Job>() {};
        return apiClient.invokeAPI("/v1/ops/jobs/{jobId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Asynchronous Job Status and Results
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>404</b> - Job ID not found.
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param jobId The unique ID of the job, returned from a &#x60;POST&#x60; operation.
     * @return Job
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Job> getJob(@jakarta.annotation.Nonnull String jobId) throws WebClientResponseException {
        ParameterizedTypeReference<Job> localVarReturnType = new ParameterizedTypeReference<Job>() {};
        return getJobRequestCreation(jobId).bodyToMono(localVarReturnType);
    }

    /**
     * Get Asynchronous Job Status and Results
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>404</b> - Job ID not found.
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param jobId The unique ID of the job, returned from a &#x60;POST&#x60; operation.
     * @return ResponseEntity&lt;Job&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Job>> getJobWithHttpInfo(@jakarta.annotation.Nonnull String jobId) throws WebClientResponseException {
        ParameterizedTypeReference<Job> localVarReturnType = new ParameterizedTypeReference<Job>() {};
        return getJobRequestCreation(jobId).toEntity(localVarReturnType);
    }

    /**
     * Get Asynchronous Job Status and Results
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>404</b> - Job ID not found.
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param jobId The unique ID of the job, returned from a &#x60;POST&#x60; operation.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getJobWithResponseSpec(@jakarta.annotation.Nonnull String jobId) throws WebClientResponseException {
        return getJobRequestCreation(jobId);
    }

    /**
     * Get Monitoring Check
     * Get details of a specific monitoring check including uptime metrics.
     * <p><b>200</b> - Check details.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * @param checkId Check ID
     * @return MonitorCheckResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getMonitorCheckRequestCreation(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'checkId' is set
        if (checkId == null) {
            throw new WebClientResponseException("Missing the required parameter 'checkId' when calling getMonitorCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("checkId", checkId);

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

        ParameterizedTypeReference<MonitorCheckResponse> localVarReturnType = new ParameterizedTypeReference<MonitorCheckResponse>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring/{checkId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Monitoring Check
     * Get details of a specific monitoring check including uptime metrics.
     * <p><b>200</b> - Check details.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * @param checkId Check ID
     * @return MonitorCheckResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<MonitorCheckResponse> getMonitorCheck(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorCheckResponse> localVarReturnType = new ParameterizedTypeReference<MonitorCheckResponse>() {};
        return getMonitorCheckRequestCreation(checkId).bodyToMono(localVarReturnType);
    }

    /**
     * Get Monitoring Check
     * Get details of a specific monitoring check including uptime metrics.
     * <p><b>200</b> - Check details.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * @param checkId Check ID
     * @return ResponseEntity&lt;MonitorCheckResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<MonitorCheckResponse>> getMonitorCheckWithHttpInfo(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorCheckResponse> localVarReturnType = new ParameterizedTypeReference<MonitorCheckResponse>() {};
        return getMonitorCheckRequestCreation(checkId).toEntity(localVarReturnType);
    }

    /**
     * Get Monitoring Check
     * Get details of a specific monitoring check including uptime metrics.
     * <p><b>200</b> - Check details.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * @param checkId Check ID
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getMonitorCheckWithResponseSpec(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        return getMonitorCheckRequestCreation(checkId);
    }

    /**
     * Get Monitoring Dashboard
     * &lt;p&gt;Get aggregated dashboard statistics for all monitoring checks.&lt;/p&gt; &lt;h4&gt;Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Total, passing, failing, and degraded check counts&lt;/li&gt;     &lt;li&gt;Average uptime percentages (24h, 7d, 30d)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;Checks grouped by type and status&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Dashboard summary.
     * @return MonitorDashboardResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getMonitorDashboardRequestCreation() throws WebClientResponseException {
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

        ParameterizedTypeReference<MonitorDashboardResponse> localVarReturnType = new ParameterizedTypeReference<MonitorDashboardResponse>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring/dashboard", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Monitoring Dashboard
     * &lt;p&gt;Get aggregated dashboard statistics for all monitoring checks.&lt;/p&gt; &lt;h4&gt;Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Total, passing, failing, and degraded check counts&lt;/li&gt;     &lt;li&gt;Average uptime percentages (24h, 7d, 30d)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;Checks grouped by type and status&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Dashboard summary.
     * @return MonitorDashboardResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<MonitorDashboardResponse> getMonitorDashboard() throws WebClientResponseException {
        ParameterizedTypeReference<MonitorDashboardResponse> localVarReturnType = new ParameterizedTypeReference<MonitorDashboardResponse>() {};
        return getMonitorDashboardRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Get Monitoring Dashboard
     * &lt;p&gt;Get aggregated dashboard statistics for all monitoring checks.&lt;/p&gt; &lt;h4&gt;Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Total, passing, failing, and degraded check counts&lt;/li&gt;     &lt;li&gt;Average uptime percentages (24h, 7d, 30d)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;Checks grouped by type and status&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Dashboard summary.
     * @return ResponseEntity&lt;MonitorDashboardResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<MonitorDashboardResponse>> getMonitorDashboardWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<MonitorDashboardResponse> localVarReturnType = new ParameterizedTypeReference<MonitorDashboardResponse>() {};
        return getMonitorDashboardRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Get Monitoring Dashboard
     * &lt;p&gt;Get aggregated dashboard statistics for all monitoring checks.&lt;/p&gt; &lt;h4&gt;Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Total, passing, failing, and degraded check counts&lt;/li&gt;     &lt;li&gt;Average uptime percentages (24h, 7d, 30d)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;Checks grouped by type and status&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Dashboard summary.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getMonitorDashboardWithResponseSpec() throws WebClientResponseException {
        return getMonitorDashboardRequestCreation();
    }

    /**
     * Get Check Results
     * &lt;p&gt;Get the execution history for a monitoring check.&lt;/p&gt; &lt;h4&gt;Response includes for each result:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Timestamp of execution&lt;/li&gt;     &lt;li&gt;Success/failure status&lt;/li&gt;     &lt;li&gt;Response time&lt;/li&gt;     &lt;li&gt;HTTP status code (for API checks)&lt;/li&gt;     &lt;li&gt;Error message (if failed)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>200</b> - Check execution history.
     * @param checkId Check ID
     * @param limit Maximum number of results to return
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getMonitorResultsRequestCreation(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'checkId' is set
        if (checkId == null) {
            throw new WebClientResponseException("Missing the required parameter 'checkId' when calling getMonitorResults", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("checkId", checkId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring/{checkId}/results", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Check Results
     * &lt;p&gt;Get the execution history for a monitoring check.&lt;/p&gt; &lt;h4&gt;Response includes for each result:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Timestamp of execution&lt;/li&gt;     &lt;li&gt;Success/failure status&lt;/li&gt;     &lt;li&gt;Response time&lt;/li&gt;     &lt;li&gt;HTTP status code (for API checks)&lt;/li&gt;     &lt;li&gt;Error message (if failed)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>200</b> - Check execution history.
     * @param checkId Check ID
     * @param limit Maximum number of results to return
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getMonitorResults(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getMonitorResultsRequestCreation(checkId, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Get Check Results
     * &lt;p&gt;Get the execution history for a monitoring check.&lt;/p&gt; &lt;h4&gt;Response includes for each result:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Timestamp of execution&lt;/li&gt;     &lt;li&gt;Success/failure status&lt;/li&gt;     &lt;li&gt;Response time&lt;/li&gt;     &lt;li&gt;HTTP status code (for API checks)&lt;/li&gt;     &lt;li&gt;Error message (if failed)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>200</b> - Check execution history.
     * @param checkId Check ID
     * @param limit Maximum number of results to return
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getMonitorResultsWithHttpInfo(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getMonitorResultsRequestCreation(checkId, limit).toEntity(localVarReturnType);
    }

    /**
     * Get Check Results
     * &lt;p&gt;Get the execution history for a monitoring check.&lt;/p&gt; &lt;h4&gt;Response includes for each result:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Timestamp of execution&lt;/li&gt;     &lt;li&gt;Success/failure status&lt;/li&gt;     &lt;li&gt;Response time&lt;/li&gt;     &lt;li&gt;HTTP status code (for API checks)&lt;/li&gt;     &lt;li&gt;Error message (if failed)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>200</b> - Check execution history.
     * @param checkId Check ID
     * @param limit Maximum number of results to return
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getMonitorResultsWithResponseSpec(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        return getMonitorResultsRequestCreation(checkId, limit);
    }

    /**
     * Get Monitoring Status and Metrics
     * &lt;p&gt;Retrieves current monitoring configuration and historical metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Status Information:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Monitoring State:&lt;/b&gt; Active, paused, or not monitored&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Check Frequency:&lt;/b&gt; How often checks are performed&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Active Alerts:&lt;/b&gt; Currently triggered alert conditions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Last Check:&lt;/b&gt; Timestamp of most recent check&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>404</b> - Target is not being monitored.
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param target The domain or IP address to check monitoring status for.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getMonitoringStatusRequestCreation(@jakarta.annotation.Nonnull String target) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'target' is set
        if (target == null) {
            throw new WebClientResponseException("Missing the required parameter 'target' when calling getMonitoringStatus", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("target", target);

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
        return apiClient.invokeAPI("/v1/ops/monitoring/status/{target}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Monitoring Status and Metrics
     * &lt;p&gt;Retrieves current monitoring configuration and historical metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Status Information:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Monitoring State:&lt;/b&gt; Active, paused, or not monitored&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Check Frequency:&lt;/b&gt; How often checks are performed&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Active Alerts:&lt;/b&gt; Currently triggered alert conditions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Last Check:&lt;/b&gt; Timestamp of most recent check&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>404</b> - Target is not being monitored.
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param target The domain or IP address to check monitoring status for.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getMonitoringStatus(@jakarta.annotation.Nonnull String target) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getMonitoringStatusRequestCreation(target).bodyToMono(localVarReturnType);
    }

    /**
     * Get Monitoring Status and Metrics
     * &lt;p&gt;Retrieves current monitoring configuration and historical metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Status Information:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Monitoring State:&lt;/b&gt; Active, paused, or not monitored&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Check Frequency:&lt;/b&gt; How often checks are performed&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Active Alerts:&lt;/b&gt; Currently triggered alert conditions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Last Check:&lt;/b&gt; Timestamp of most recent check&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>404</b> - Target is not being monitored.
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param target The domain or IP address to check monitoring status for.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getMonitoringStatusWithHttpInfo(@jakarta.annotation.Nonnull String target) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getMonitoringStatusRequestCreation(target).toEntity(localVarReturnType);
    }

    /**
     * Get Monitoring Status and Metrics
     * &lt;p&gt;Retrieves current monitoring configuration and historical metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Status Information:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Monitoring State:&lt;/b&gt; Active, paused, or not monitored&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Check Frequency:&lt;/b&gt; How often checks are performed&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Active Alerts:&lt;/b&gt; Currently triggered alert conditions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Last Check:&lt;/b&gt; Timestamp of most recent check&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>404</b> - Target is not being monitored.
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param target The domain or IP address to check monitoring status for.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getMonitoringStatusWithResponseSpec(@jakarta.annotation.Nonnull String target) throws WebClientResponseException {
        return getMonitoringStatusRequestCreation(target);
    }

    /**
     * Get Screenshot History
     * &lt;p&gt;Retrieve all previously captured screenshots for a specific URL, ordered by capture time (newest first). Includes download URLs and metadata for each capture.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Download URL:&lt;/b&gt; Direct link to screenshot image&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Time:&lt;/b&gt; Timestamp when screenshot was taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Dimensions:&lt;/b&gt; Image width and height&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Format:&lt;/b&gt; Image format (PNG, JPEG, WebP)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;File Size:&lt;/b&gt; Size in bytes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Review website evolution over time&lt;/li&gt;     &lt;li&gt;Compare screenshots for change detection&lt;/li&gt;     &lt;li&gt;Download historical screenshots for reporting&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved screenshot history.
     * <p><b>400</b> - Invalid URL parameter.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No screenshots found for the specified URL.
     * @param target The target domain or URL to retrieve screenshot history for.
     * @param limit Maximum number of screenshots to return.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getScreenshotHistoryRequestCreation(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'target' is set
        if (target == null) {
            throw new WebClientResponseException("Missing the required parameter 'target' when calling getScreenshotHistory", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "target", target));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/ops/screenshots/history", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Screenshot History
     * &lt;p&gt;Retrieve all previously captured screenshots for a specific URL, ordered by capture time (newest first). Includes download URLs and metadata for each capture.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Download URL:&lt;/b&gt; Direct link to screenshot image&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Time:&lt;/b&gt; Timestamp when screenshot was taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Dimensions:&lt;/b&gt; Image width and height&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Format:&lt;/b&gt; Image format (PNG, JPEG, WebP)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;File Size:&lt;/b&gt; Size in bytes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Review website evolution over time&lt;/li&gt;     &lt;li&gt;Compare screenshots for change detection&lt;/li&gt;     &lt;li&gt;Download historical screenshots for reporting&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved screenshot history.
     * <p><b>400</b> - Invalid URL parameter.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No screenshots found for the specified URL.
     * @param target The target domain or URL to retrieve screenshot history for.
     * @param limit Maximum number of screenshots to return.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getScreenshotHistory(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getScreenshotHistoryRequestCreation(target, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Get Screenshot History
     * &lt;p&gt;Retrieve all previously captured screenshots for a specific URL, ordered by capture time (newest first). Includes download URLs and metadata for each capture.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Download URL:&lt;/b&gt; Direct link to screenshot image&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Time:&lt;/b&gt; Timestamp when screenshot was taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Dimensions:&lt;/b&gt; Image width and height&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Format:&lt;/b&gt; Image format (PNG, JPEG, WebP)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;File Size:&lt;/b&gt; Size in bytes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Review website evolution over time&lt;/li&gt;     &lt;li&gt;Compare screenshots for change detection&lt;/li&gt;     &lt;li&gt;Download historical screenshots for reporting&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved screenshot history.
     * <p><b>400</b> - Invalid URL parameter.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No screenshots found for the specified URL.
     * @param target The target domain or URL to retrieve screenshot history for.
     * @param limit Maximum number of screenshots to return.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getScreenshotHistoryWithHttpInfo(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getScreenshotHistoryRequestCreation(target, limit).toEntity(localVarReturnType);
    }

    /**
     * Get Screenshot History
     * &lt;p&gt;Retrieve all previously captured screenshots for a specific URL, ordered by capture time (newest first). Includes download URLs and metadata for each capture.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Download URL:&lt;/b&gt; Direct link to screenshot image&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Time:&lt;/b&gt; Timestamp when screenshot was taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Dimensions:&lt;/b&gt; Image width and height&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Format:&lt;/b&gt; Image format (PNG, JPEG, WebP)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;File Size:&lt;/b&gt; Size in bytes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Review website evolution over time&lt;/li&gt;     &lt;li&gt;Compare screenshots for change detection&lt;/li&gt;     &lt;li&gt;Download historical screenshots for reporting&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved screenshot history.
     * <p><b>400</b> - Invalid URL parameter.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No screenshots found for the specified URL.
     * @param target The target domain or URL to retrieve screenshot history for.
     * @param limit Maximum number of screenshots to return.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getScreenshotHistoryWithResponseSpec(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        return getScreenshotHistoryRequestCreation(target, limit);
    }

    /**
     * List Recent Jobs
     * &lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved job list.
     * @param status Filter by job status
     * @param limit Maximum number of jobs to return
     * @param offset Number of jobs to skip
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listJobsRequestCreation(@jakarta.annotation.Nullable String status, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable Integer offset) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/ops/jobs/list", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Recent Jobs
     * &lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved job list.
     * @param status Filter by job status
     * @param limit Maximum number of jobs to return
     * @param offset Number of jobs to skip
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> listJobs(@jakarta.annotation.Nullable String status, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable Integer offset) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return listJobsRequestCreation(status, limit, offset).bodyToMono(localVarReturnType);
    }

    /**
     * List Recent Jobs
     * &lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved job list.
     * @param status Filter by job status
     * @param limit Maximum number of jobs to return
     * @param offset Number of jobs to skip
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> listJobsWithHttpInfo(@jakarta.annotation.Nullable String status, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable Integer offset) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return listJobsRequestCreation(status, limit, offset).toEntity(localVarReturnType);
    }

    /**
     * List Recent Jobs
     * &lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved job list.
     * @param status Filter by job status
     * @param limit Maximum number of jobs to return
     * @param offset Number of jobs to skip
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec listJobsWithResponseSpec(@jakarta.annotation.Nullable String status, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable Integer offset) throws WebClientResponseException {
        return listJobsRequestCreation(status, limit, offset);
    }

    /**
     * List Monitoring Checks
     * &lt;p&gt;Get a list of all monitoring checks created by the authenticated user.&lt;/p&gt; &lt;h4&gt;Filtering:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;type:&lt;/b&gt; Filter by check type (api, ssl, dns)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by status (passing, failing, degraded, pending)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - List of monitoring checks.
     * <p><b>401</b> - Authentication failed.
     * @param type Filter by check type
     * @param status Filter by status
     * @return MonitorListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listMonitorChecksRequestCreation(@jakarta.annotation.Nullable String type, @jakarta.annotation.Nullable String status) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<MonitorListResponse> localVarReturnType = new ParameterizedTypeReference<MonitorListResponse>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Monitoring Checks
     * &lt;p&gt;Get a list of all monitoring checks created by the authenticated user.&lt;/p&gt; &lt;h4&gt;Filtering:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;type:&lt;/b&gt; Filter by check type (api, ssl, dns)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by status (passing, failing, degraded, pending)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - List of monitoring checks.
     * <p><b>401</b> - Authentication failed.
     * @param type Filter by check type
     * @param status Filter by status
     * @return MonitorListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<MonitorListResponse> listMonitorChecks(@jakarta.annotation.Nullable String type, @jakarta.annotation.Nullable String status) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorListResponse> localVarReturnType = new ParameterizedTypeReference<MonitorListResponse>() {};
        return listMonitorChecksRequestCreation(type, status).bodyToMono(localVarReturnType);
    }

    /**
     * List Monitoring Checks
     * &lt;p&gt;Get a list of all monitoring checks created by the authenticated user.&lt;/p&gt; &lt;h4&gt;Filtering:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;type:&lt;/b&gt; Filter by check type (api, ssl, dns)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by status (passing, failing, degraded, pending)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - List of monitoring checks.
     * <p><b>401</b> - Authentication failed.
     * @param type Filter by check type
     * @param status Filter by status
     * @return ResponseEntity&lt;MonitorListResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<MonitorListResponse>> listMonitorChecksWithHttpInfo(@jakarta.annotation.Nullable String type, @jakarta.annotation.Nullable String status) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorListResponse> localVarReturnType = new ParameterizedTypeReference<MonitorListResponse>() {};
        return listMonitorChecksRequestCreation(type, status).toEntity(localVarReturnType);
    }

    /**
     * List Monitoring Checks
     * &lt;p&gt;Get a list of all monitoring checks created by the authenticated user.&lt;/p&gt; &lt;h4&gt;Filtering:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;type:&lt;/b&gt; Filter by check type (api, ssl, dns)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by status (passing, failing, degraded, pending)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - List of monitoring checks.
     * <p><b>401</b> - Authentication failed.
     * @param type Filter by check type
     * @param status Filter by status
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec listMonitorChecksWithResponseSpec(@jakarta.annotation.Nullable String type, @jakarta.annotation.Nullable String status) throws WebClientResponseException {
        return listMonitorChecksRequestCreation(type, status);
    }

    /**
     * List Tracked Indicators
     * &lt;p&gt;Get a list of all indicators currently being tracked for changes by the authenticated user.&lt;/p&gt; 
     * <p><b>200</b> - List of tracked indicators.
     * <p><b>401</b> - Authentication failed.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listTrackedIndicatorsRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/ops/tracking", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Tracked Indicators
     * &lt;p&gt;Get a list of all indicators currently being tracked for changes by the authenticated user.&lt;/p&gt; 
     * <p><b>200</b> - List of tracked indicators.
     * <p><b>401</b> - Authentication failed.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> listTrackedIndicators() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return listTrackedIndicatorsRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * List Tracked Indicators
     * &lt;p&gt;Get a list of all indicators currently being tracked for changes by the authenticated user.&lt;/p&gt; 
     * <p><b>200</b> - List of tracked indicators.
     * <p><b>401</b> - Authentication failed.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> listTrackedIndicatorsWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return listTrackedIndicatorsRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * List Tracked Indicators
     * &lt;p&gt;Get a list of all indicators currently being tracked for changes by the authenticated user.&lt;/p&gt; 
     * <p><b>200</b> - List of tracked indicators.
     * <p><b>401</b> - Authentication failed.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec listTrackedIndicatorsWithResponseSpec() throws WebClientResponseException {
        return listTrackedIndicatorsRequestCreation();
    }

    /**
     * Schedule Recurring Screenshots (Asynchronous)
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Retention:&lt;/b&gt; Auto-cleanup old screenshots (default: keep last 30)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * @param screenshotRequest Schedule configuration including URL, schedule timing, and screenshot options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec scheduleScreenshotRequestCreation(@jakarta.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        Object postBody = screenshotRequest;
        // verify the required parameter 'screenshotRequest' is set
        if (screenshotRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'screenshotRequest' when calling scheduleScreenshot", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/screenshots/schedule", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Schedule Recurring Screenshots (Asynchronous)
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Retention:&lt;/b&gt; Auto-cleanup old screenshots (default: keep last 30)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * @param screenshotRequest Schedule configuration including URL, schedule timing, and screenshot options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> scheduleScreenshot(@jakarta.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return scheduleScreenshotRequestCreation(screenshotRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Schedule Recurring Screenshots (Asynchronous)
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Retention:&lt;/b&gt; Auto-cleanup old screenshots (default: keep last 30)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * @param screenshotRequest Schedule configuration including URL, schedule timing, and screenshot options.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> scheduleScreenshotWithHttpInfo(@jakarta.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return scheduleScreenshotRequestCreation(screenshotRequest).toEntity(localVarReturnType);
    }

    /**
     * Schedule Recurring Screenshots (Asynchronous)
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Retention:&lt;/b&gt; Auto-cleanup old screenshots (default: keep last 30)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * @param screenshotRequest Schedule configuration including URL, schedule timing, and screenshot options.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec scheduleScreenshotWithResponseSpec(@jakarta.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        return scheduleScreenshotRequestCreation(screenshotRequest);
    }

    /**
     * Search Indicators (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to search for indicators matching specific criteria. This endpoint is extremely powerful for infrastructure discovery and threat hunting.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; Searches on WHOIS fields (like &#x60;registrantCompany&#x60;) are data-intensive and can take over 50 seconds to complete. This endpoint is therefore asynchronous by design. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve results.&lt;/p&gt; &lt;h4&gt;Example Search Queries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&#x60;registrantCompany:EvilCorp&#x60; - Find all domains registered by EvilCorp&lt;/li&gt;     &lt;li&gt;&#x60;asn:15169&#x60; - Find all IPs in Google&#39;s ASN&lt;/li&gt;     &lt;li&gt;&#x60;city:\&quot;San Francisco\&quot;&#x60; - Find all IPs geolocated to San Francisco&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Search job successfully accepted.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>400</b> - Invalid search query or parameters.
     * @param searchRequest The search query and configuration.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec searchIndicatorsRequestCreation(@jakarta.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        Object postBody = searchRequest;
        // verify the required parameter 'searchRequest' is set
        if (searchRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'searchRequest' when calling searchIndicators", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/enrichment/search", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Search Indicators (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to search for indicators matching specific criteria. This endpoint is extremely powerful for infrastructure discovery and threat hunting.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; Searches on WHOIS fields (like &#x60;registrantCompany&#x60;) are data-intensive and can take over 50 seconds to complete. This endpoint is therefore asynchronous by design. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve results.&lt;/p&gt; &lt;h4&gt;Example Search Queries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&#x60;registrantCompany:EvilCorp&#x60; - Find all domains registered by EvilCorp&lt;/li&gt;     &lt;li&gt;&#x60;asn:15169&#x60; - Find all IPs in Google&#39;s ASN&lt;/li&gt;     &lt;li&gt;&#x60;city:\&quot;San Francisco\&quot;&#x60; - Find all IPs geolocated to San Francisco&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Search job successfully accepted.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>400</b> - Invalid search query or parameters.
     * @param searchRequest The search query and configuration.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> searchIndicators(@jakarta.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return searchIndicatorsRequestCreation(searchRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Search Indicators (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to search for indicators matching specific criteria. This endpoint is extremely powerful for infrastructure discovery and threat hunting.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; Searches on WHOIS fields (like &#x60;registrantCompany&#x60;) are data-intensive and can take over 50 seconds to complete. This endpoint is therefore asynchronous by design. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve results.&lt;/p&gt; &lt;h4&gt;Example Search Queries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&#x60;registrantCompany:EvilCorp&#x60; - Find all domains registered by EvilCorp&lt;/li&gt;     &lt;li&gt;&#x60;asn:15169&#x60; - Find all IPs in Google&#39;s ASN&lt;/li&gt;     &lt;li&gt;&#x60;city:\&quot;San Francisco\&quot;&#x60; - Find all IPs geolocated to San Francisco&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Search job successfully accepted.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>400</b> - Invalid search query or parameters.
     * @param searchRequest The search query and configuration.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> searchIndicatorsWithHttpInfo(@jakarta.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return searchIndicatorsRequestCreation(searchRequest).toEntity(localVarReturnType);
    }

    /**
     * Search Indicators (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to search for indicators matching specific criteria. This endpoint is extremely powerful for infrastructure discovery and threat hunting.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; Searches on WHOIS fields (like &#x60;registrantCompany&#x60;) are data-intensive and can take over 50 seconds to complete. This endpoint is therefore asynchronous by design. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve results.&lt;/p&gt; &lt;h4&gt;Example Search Queries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&#x60;registrantCompany:EvilCorp&#x60; - Find all domains registered by EvilCorp&lt;/li&gt;     &lt;li&gt;&#x60;asn:15169&#x60; - Find all IPs in Google&#39;s ASN&lt;/li&gt;     &lt;li&gt;&#x60;city:\&quot;San Francisco\&quot;&#x60; - Find all IPs geolocated to San Francisco&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Search job successfully accepted.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>400</b> - Invalid search query or parameters.
     * @param searchRequest The search query and configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec searchIndicatorsWithResponseSpec(@jakarta.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        return searchIndicatorsRequestCreation(searchRequest);
    }

    /**
     * Find Similar Domains (Asynchronous)
     * &lt;p&gt;Generates potential lookalike, typosquatting, and homoglyph domains for brand protection and threat hunting.&lt;/p&gt; &lt;h4&gt;Detection Methods:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Typosquatting (keyboard proximity)&lt;/li&gt;     &lt;li&gt;Homoglyph attacks (visually similar characters)&lt;/li&gt;     &lt;li&gt;Combosquatting (brand + keyword)&lt;/li&gt;     &lt;li&gt;TLD variations&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds depending on options.&lt;/p&gt; 
     * <p><b>400</b> - Invalid domain or options.
     * <p><b>401</b> - Authentication failed.
     * <p><b>202</b> - Similar domains job created successfully.
     * @param similarDomainsOpsRequest Similar domains request with domain and options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec similarDomainsRequestCreation(@jakarta.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
        Object postBody = similarDomainsOpsRequest;
        // verify the required parameter 'similarDomainsOpsRequest' is set
        if (similarDomainsOpsRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'similarDomainsOpsRequest' when calling similarDomains", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/enrichment/similar-domains", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Find Similar Domains (Asynchronous)
     * &lt;p&gt;Generates potential lookalike, typosquatting, and homoglyph domains for brand protection and threat hunting.&lt;/p&gt; &lt;h4&gt;Detection Methods:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Typosquatting (keyboard proximity)&lt;/li&gt;     &lt;li&gt;Homoglyph attacks (visually similar characters)&lt;/li&gt;     &lt;li&gt;Combosquatting (brand + keyword)&lt;/li&gt;     &lt;li&gt;TLD variations&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds depending on options.&lt;/p&gt; 
     * <p><b>400</b> - Invalid domain or options.
     * <p><b>401</b> - Authentication failed.
     * <p><b>202</b> - Similar domains job created successfully.
     * @param similarDomainsOpsRequest Similar domains request with domain and options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> similarDomains(@jakarta.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return similarDomainsRequestCreation(similarDomainsOpsRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Find Similar Domains (Asynchronous)
     * &lt;p&gt;Generates potential lookalike, typosquatting, and homoglyph domains for brand protection and threat hunting.&lt;/p&gt; &lt;h4&gt;Detection Methods:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Typosquatting (keyboard proximity)&lt;/li&gt;     &lt;li&gt;Homoglyph attacks (visually similar characters)&lt;/li&gt;     &lt;li&gt;Combosquatting (brand + keyword)&lt;/li&gt;     &lt;li&gt;TLD variations&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds depending on options.&lt;/p&gt; 
     * <p><b>400</b> - Invalid domain or options.
     * <p><b>401</b> - Authentication failed.
     * <p><b>202</b> - Similar domains job created successfully.
     * @param similarDomainsOpsRequest Similar domains request with domain and options.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> similarDomainsWithHttpInfo(@jakarta.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return similarDomainsRequestCreation(similarDomainsOpsRequest).toEntity(localVarReturnType);
    }

    /**
     * Find Similar Domains (Asynchronous)
     * &lt;p&gt;Generates potential lookalike, typosquatting, and homoglyph domains for brand protection and threat hunting.&lt;/p&gt; &lt;h4&gt;Detection Methods:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Typosquatting (keyboard proximity)&lt;/li&gt;     &lt;li&gt;Homoglyph attacks (visually similar characters)&lt;/li&gt;     &lt;li&gt;Combosquatting (brand + keyword)&lt;/li&gt;     &lt;li&gt;TLD variations&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds depending on options.&lt;/p&gt; 
     * <p><b>400</b> - Invalid domain or options.
     * <p><b>401</b> - Authentication failed.
     * <p><b>202</b> - Similar domains job created successfully.
     * @param similarDomainsOpsRequest Similar domains request with domain and options.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec similarDomainsWithResponseSpec(@jakarta.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
        return similarDomainsRequestCreation(similarDomainsOpsRequest);
    }

    /**
     * Start Change Tracking
     * &lt;p&gt;Start tracking changes for an IP or domain. When tracking is started, a baseline snapshot is captured. Subsequent checks will compare against this baseline and record any detected changes.&lt;/p&gt; &lt;h4&gt;Trackable Fields for Domains:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT, CNAME records&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, dates, nameservers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate issuer, expiry, SAN&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Discovered subdomains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ips:&lt;/b&gt; Resolved IP addresses&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Trackable Fields for IPs:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;geolocation:&lt;/b&gt; Country, city, coordinates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;asn:&lt;/b&gt; ASN number, organization&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;rpki:&lt;/b&gt; RPKI validation status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reverse_dns:&lt;/b&gt; PTR records&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequencies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;hourly:&lt;/b&gt; Check every hour&lt;/li&gt;     &lt;li&gt;&lt;b&gt;daily:&lt;/b&gt; Check once per day (default)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;weekly:&lt;/b&gt; Check once per week&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Tracking started. Job ID returned for baseline capture.
     * <p><b>401</b> - Authentication failed.
     * <p><b>400</b> - Invalid indicator type or fields.
     * @param type Indicator type: ip or domain
     * @param value Indicator value (IP address or domain name)
     * @param changeTrackingRequest Tracking configuration
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec startChangeTrackingRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nonnull ChangeTrackingRequest changeTrackingRequest) throws WebClientResponseException {
        Object postBody = changeTrackingRequest;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling startChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling startChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'changeTrackingRequest' is set
        if (changeTrackingRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'changeTrackingRequest' when calling startChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/tracking/{type}/{value}", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Start Change Tracking
     * &lt;p&gt;Start tracking changes for an IP or domain. When tracking is started, a baseline snapshot is captured. Subsequent checks will compare against this baseline and record any detected changes.&lt;/p&gt; &lt;h4&gt;Trackable Fields for Domains:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT, CNAME records&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, dates, nameservers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate issuer, expiry, SAN&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Discovered subdomains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ips:&lt;/b&gt; Resolved IP addresses&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Trackable Fields for IPs:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;geolocation:&lt;/b&gt; Country, city, coordinates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;asn:&lt;/b&gt; ASN number, organization&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;rpki:&lt;/b&gt; RPKI validation status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reverse_dns:&lt;/b&gt; PTR records&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequencies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;hourly:&lt;/b&gt; Check every hour&lt;/li&gt;     &lt;li&gt;&lt;b&gt;daily:&lt;/b&gt; Check once per day (default)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;weekly:&lt;/b&gt; Check once per week&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Tracking started. Job ID returned for baseline capture.
     * <p><b>401</b> - Authentication failed.
     * <p><b>400</b> - Invalid indicator type or fields.
     * @param type Indicator type: ip or domain
     * @param value Indicator value (IP address or domain name)
     * @param changeTrackingRequest Tracking configuration
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> startChangeTracking(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nonnull ChangeTrackingRequest changeTrackingRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return startChangeTrackingRequestCreation(type, value, changeTrackingRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Start Change Tracking
     * &lt;p&gt;Start tracking changes for an IP or domain. When tracking is started, a baseline snapshot is captured. Subsequent checks will compare against this baseline and record any detected changes.&lt;/p&gt; &lt;h4&gt;Trackable Fields for Domains:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT, CNAME records&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, dates, nameservers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate issuer, expiry, SAN&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Discovered subdomains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ips:&lt;/b&gt; Resolved IP addresses&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Trackable Fields for IPs:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;geolocation:&lt;/b&gt; Country, city, coordinates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;asn:&lt;/b&gt; ASN number, organization&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;rpki:&lt;/b&gt; RPKI validation status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reverse_dns:&lt;/b&gt; PTR records&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequencies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;hourly:&lt;/b&gt; Check every hour&lt;/li&gt;     &lt;li&gt;&lt;b&gt;daily:&lt;/b&gt; Check once per day (default)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;weekly:&lt;/b&gt; Check once per week&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Tracking started. Job ID returned for baseline capture.
     * <p><b>401</b> - Authentication failed.
     * <p><b>400</b> - Invalid indicator type or fields.
     * @param type Indicator type: ip or domain
     * @param value Indicator value (IP address or domain name)
     * @param changeTrackingRequest Tracking configuration
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> startChangeTrackingWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nonnull ChangeTrackingRequest changeTrackingRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return startChangeTrackingRequestCreation(type, value, changeTrackingRequest).toEntity(localVarReturnType);
    }

    /**
     * Start Change Tracking
     * &lt;p&gt;Start tracking changes for an IP or domain. When tracking is started, a baseline snapshot is captured. Subsequent checks will compare against this baseline and record any detected changes.&lt;/p&gt; &lt;h4&gt;Trackable Fields for Domains:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT, CNAME records&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, dates, nameservers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate issuer, expiry, SAN&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Discovered subdomains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ips:&lt;/b&gt; Resolved IP addresses&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Trackable Fields for IPs:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;geolocation:&lt;/b&gt; Country, city, coordinates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;asn:&lt;/b&gt; ASN number, organization&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;rpki:&lt;/b&gt; RPKI validation status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reverse_dns:&lt;/b&gt; PTR records&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequencies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;hourly:&lt;/b&gt; Check every hour&lt;/li&gt;     &lt;li&gt;&lt;b&gt;daily:&lt;/b&gt; Check once per day (default)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;weekly:&lt;/b&gt; Check once per week&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Tracking started. Job ID returned for baseline capture.
     * <p><b>401</b> - Authentication failed.
     * <p><b>400</b> - Invalid indicator type or fields.
     * @param type Indicator type: ip or domain
     * @param value Indicator value (IP address or domain name)
     * @param changeTrackingRequest Tracking configuration
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec startChangeTrackingWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nonnull ChangeTrackingRequest changeTrackingRequest) throws WebClientResponseException {
        return startChangeTrackingRequestCreation(type, value, changeTrackingRequest);
    }

    /**
     * Stop Change Tracking
     * &lt;p&gt;Stop tracking changes for an indicator. Optionally delete all change history.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>204</b> - Tracking stopped successfully.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param deleteHistory Delete change history as well
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec stopChangeTrackingRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Boolean deleteHistory) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling stopChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling stopChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "deleteHistory", deleteHistory));

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/ops/tracking/{type}/{value}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Stop Change Tracking
     * &lt;p&gt;Stop tracking changes for an indicator. Optionally delete all change history.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>204</b> - Tracking stopped successfully.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param deleteHistory Delete change history as well
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> stopChangeTracking(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Boolean deleteHistory) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return stopChangeTrackingRequestCreation(type, value, deleteHistory).bodyToMono(localVarReturnType);
    }

    /**
     * Stop Change Tracking
     * &lt;p&gt;Stop tracking changes for an indicator. Optionally delete all change history.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>204</b> - Tracking stopped successfully.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param deleteHistory Delete change history as well
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> stopChangeTrackingWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Boolean deleteHistory) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return stopChangeTrackingRequestCreation(type, value, deleteHistory).toEntity(localVarReturnType);
    }

    /**
     * Stop Change Tracking
     * &lt;p&gt;Stop tracking changes for an indicator. Optionally delete all change history.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>204</b> - Tracking stopped successfully.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param deleteHistory Delete change history as well
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec stopChangeTrackingWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Boolean deleteHistory) throws WebClientResponseException {
        return stopChangeTrackingRequestCreation(type, value, deleteHistory);
    }

    /**
     * Trigger Immediate Check
     * &lt;p&gt;Trigger an immediate check for changes on a tracked indicator. Creates a job to compare current data against the stored baseline.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>202</b> - Check triggered. Job ID returned.
     * <p><b>404</b> - Indicator is not being tracked.
     * @param type Indicator type
     * @param value Indicator value
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec triggerCheckRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling triggerCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling triggerCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/tracking/{type}/{value}/check", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Trigger Immediate Check
     * &lt;p&gt;Trigger an immediate check for changes on a tracked indicator. Creates a job to compare current data against the stored baseline.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>202</b> - Check triggered. Job ID returned.
     * <p><b>404</b> - Indicator is not being tracked.
     * @param type Indicator type
     * @param value Indicator value
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> triggerCheck(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return triggerCheckRequestCreation(type, value).bodyToMono(localVarReturnType);
    }

    /**
     * Trigger Immediate Check
     * &lt;p&gt;Trigger an immediate check for changes on a tracked indicator. Creates a job to compare current data against the stored baseline.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>202</b> - Check triggered. Job ID returned.
     * <p><b>404</b> - Indicator is not being tracked.
     * @param type Indicator type
     * @param value Indicator value
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> triggerCheckWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return triggerCheckRequestCreation(type, value).toEntity(localVarReturnType);
    }

    /**
     * Trigger Immediate Check
     * &lt;p&gt;Trigger an immediate check for changes on a tracked indicator. Creates a job to compare current data against the stored baseline.&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed.
     * <p><b>202</b> - Check triggered. Job ID returned.
     * <p><b>404</b> - Indicator is not being tracked.
     * @param type Indicator type
     * @param value Indicator value
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec triggerCheckWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        return triggerCheckRequestCreation(type, value);
    }

    /**
     * Trigger Manual Check
     * Trigger an immediate execution of a monitoring check.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>202</b> - Check triggered successfully.
     * @param checkId Check ID
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec triggerMonitorCheckRequestCreation(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'checkId' is set
        if (checkId == null) {
            throw new WebClientResponseException("Missing the required parameter 'checkId' when calling triggerMonitorCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("checkId", checkId);

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
        return apiClient.invokeAPI("/v1/ops/monitoring/{checkId}/trigger", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Trigger Manual Check
     * Trigger an immediate execution of a monitoring check.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>202</b> - Check triggered successfully.
     * @param checkId Check ID
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> triggerMonitorCheck(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return triggerMonitorCheckRequestCreation(checkId).bodyToMono(localVarReturnType);
    }

    /**
     * Trigger Manual Check
     * Trigger an immediate execution of a monitoring check.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>202</b> - Check triggered successfully.
     * @param checkId Check ID
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> triggerMonitorCheckWithHttpInfo(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return triggerMonitorCheckRequestCreation(checkId).toEntity(localVarReturnType);
    }

    /**
     * Trigger Manual Check
     * Trigger an immediate execution of a monitoring check.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>202</b> - Check triggered successfully.
     * @param checkId Check ID
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec triggerMonitorCheckWithResponseSpec(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        return triggerMonitorCheckRequestCreation(checkId);
    }

    /**
     * Update Monitoring Check
     * Update an existing monitoring check configuration.
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Check updated successfully.
     * <p><b>404</b> - Check not found or access denied.
     * @param checkId Check ID
     * @param monitorCheckRequest Updated check configuration
     * @return MonitorCheckResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateMonitorCheckRequestCreation(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        Object postBody = monitorCheckRequest;
        // verify the required parameter 'checkId' is set
        if (checkId == null) {
            throw new WebClientResponseException("Missing the required parameter 'checkId' when calling updateMonitorCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'monitorCheckRequest' is set
        if (monitorCheckRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'monitorCheckRequest' when calling updateMonitorCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("checkId", checkId);

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

        ParameterizedTypeReference<MonitorCheckResponse> localVarReturnType = new ParameterizedTypeReference<MonitorCheckResponse>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring/{checkId}", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update Monitoring Check
     * Update an existing monitoring check configuration.
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Check updated successfully.
     * <p><b>404</b> - Check not found or access denied.
     * @param checkId Check ID
     * @param monitorCheckRequest Updated check configuration
     * @return MonitorCheckResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<MonitorCheckResponse> updateMonitorCheck(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorCheckResponse> localVarReturnType = new ParameterizedTypeReference<MonitorCheckResponse>() {};
        return updateMonitorCheckRequestCreation(checkId, monitorCheckRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Update Monitoring Check
     * Update an existing monitoring check configuration.
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Check updated successfully.
     * <p><b>404</b> - Check not found or access denied.
     * @param checkId Check ID
     * @param monitorCheckRequest Updated check configuration
     * @return ResponseEntity&lt;MonitorCheckResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<MonitorCheckResponse>> updateMonitorCheckWithHttpInfo(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorCheckResponse> localVarReturnType = new ParameterizedTypeReference<MonitorCheckResponse>() {};
        return updateMonitorCheckRequestCreation(checkId, monitorCheckRequest).toEntity(localVarReturnType);
    }

    /**
     * Update Monitoring Check
     * Update an existing monitoring check configuration.
     * <p><b>401</b> - Authentication failed.
     * <p><b>200</b> - Check updated successfully.
     * <p><b>404</b> - Check not found or access denied.
     * @param checkId Check ID
     * @param monitorCheckRequest Updated check configuration
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateMonitorCheckWithResponseSpec(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        return updateMonitorCheckRequestCreation(checkId, monitorCheckRequest);
    }
}
