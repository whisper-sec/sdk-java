package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.InfrastructureMapRequest;
import io.github.whispersec.model.Job;
import io.github.whispersec.model.JobResponse;
import io.github.whispersec.model.MonitoringAlertRequest;
import io.github.whispersec.model.ScanRequest;
import io.github.whispersec.model.ScreenshotRequest;
import io.github.whispersec.model.SimilarDomainsOpsRequest;

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
     * Map Infrastructure Relationships (Asynchronous)
     * &lt;p&gt;Creates a comprehensive map of infrastructure relationships starting from a domain or IP. Discovers connected assets through shared hosting, DNS, certificates, and network relationships.&lt;/p&gt; &lt;h4&gt;Mapping Depth Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Depth 1:&lt;/b&gt; Direct relationships only (~30 seconds, 10-50 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 2:&lt;/b&gt; 2 hops out (~2-5 minutes, 50-500 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 3:&lt;/b&gt; 3 hops out (~10-30 minutes, 500-5000 assets)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Relationship Types Discovered:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Domains on same IP&lt;/li&gt;     &lt;li&gt;Domains sharing nameservers&lt;/li&gt;     &lt;li&gt;Domains with same SSL certificate&lt;/li&gt;     &lt;li&gt;IPs in same ASN&lt;/li&gt;     &lt;li&gt;Domains with same registrant&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Results returned as graph data compatible with visualization libraries (nodes and edges).&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Threat actor infrastructure mapping&lt;/li&gt;     &lt;li&gt;Discovering related phishing domains&lt;/li&gt;     &lt;li&gt;Finding shadow IT and forgotten assets&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * <p><b>202</b> - Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * @param infrastructureMapRequest Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60; 
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createInfrastructureMapRequestCreation(@javax.annotation.Nonnull InfrastructureMapRequest infrastructureMapRequest) throws WebClientResponseException {
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
        return apiClient.invokeAPI("/v1/ops/map", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Map Infrastructure Relationships (Asynchronous)
     * &lt;p&gt;Creates a comprehensive map of infrastructure relationships starting from a domain or IP. Discovers connected assets through shared hosting, DNS, certificates, and network relationships.&lt;/p&gt; &lt;h4&gt;Mapping Depth Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Depth 1:&lt;/b&gt; Direct relationships only (~30 seconds, 10-50 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 2:&lt;/b&gt; 2 hops out (~2-5 minutes, 50-500 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 3:&lt;/b&gt; 3 hops out (~10-30 minutes, 500-5000 assets)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Relationship Types Discovered:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Domains on same IP&lt;/li&gt;     &lt;li&gt;Domains sharing nameservers&lt;/li&gt;     &lt;li&gt;Domains with same SSL certificate&lt;/li&gt;     &lt;li&gt;IPs in same ASN&lt;/li&gt;     &lt;li&gt;Domains with same registrant&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Results returned as graph data compatible with visualization libraries (nodes and edges).&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Threat actor infrastructure mapping&lt;/li&gt;     &lt;li&gt;Discovering related phishing domains&lt;/li&gt;     &lt;li&gt;Finding shadow IT and forgotten assets&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * <p><b>202</b> - Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * @param infrastructureMapRequest Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60; 
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> createInfrastructureMap(@javax.annotation.Nonnull InfrastructureMapRequest infrastructureMapRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createInfrastructureMapRequestCreation(infrastructureMapRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Map Infrastructure Relationships (Asynchronous)
     * &lt;p&gt;Creates a comprehensive map of infrastructure relationships starting from a domain or IP. Discovers connected assets through shared hosting, DNS, certificates, and network relationships.&lt;/p&gt; &lt;h4&gt;Mapping Depth Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Depth 1:&lt;/b&gt; Direct relationships only (~30 seconds, 10-50 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 2:&lt;/b&gt; 2 hops out (~2-5 minutes, 50-500 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 3:&lt;/b&gt; 3 hops out (~10-30 minutes, 500-5000 assets)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Relationship Types Discovered:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Domains on same IP&lt;/li&gt;     &lt;li&gt;Domains sharing nameservers&lt;/li&gt;     &lt;li&gt;Domains with same SSL certificate&lt;/li&gt;     &lt;li&gt;IPs in same ASN&lt;/li&gt;     &lt;li&gt;Domains with same registrant&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Results returned as graph data compatible with visualization libraries (nodes and edges).&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Threat actor infrastructure mapping&lt;/li&gt;     &lt;li&gt;Discovering related phishing domains&lt;/li&gt;     &lt;li&gt;Finding shadow IT and forgotten assets&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * <p><b>202</b> - Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * @param infrastructureMapRequest Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60; 
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> createInfrastructureMapWithHttpInfo(@javax.annotation.Nonnull InfrastructureMapRequest infrastructureMapRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createInfrastructureMapRequestCreation(infrastructureMapRequest).toEntity(localVarReturnType);
    }

    /**
     * Map Infrastructure Relationships (Asynchronous)
     * &lt;p&gt;Creates a comprehensive map of infrastructure relationships starting from a domain or IP. Discovers connected assets through shared hosting, DNS, certificates, and network relationships.&lt;/p&gt; &lt;h4&gt;Mapping Depth Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Depth 1:&lt;/b&gt; Direct relationships only (~30 seconds, 10-50 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 2:&lt;/b&gt; 2 hops out (~2-5 minutes, 50-500 assets)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Depth 3:&lt;/b&gt; 3 hops out (~10-30 minutes, 500-5000 assets)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Relationship Types Discovered:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Domains on same IP&lt;/li&gt;     &lt;li&gt;Domains sharing nameservers&lt;/li&gt;     &lt;li&gt;Domains with same SSL certificate&lt;/li&gt;     &lt;li&gt;IPs in same ASN&lt;/li&gt;     &lt;li&gt;Domains with same registrant&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Results returned as graph data compatible with visualization libraries (nodes and edges).&lt;/p&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Threat actor infrastructure mapping&lt;/li&gt;     &lt;li&gt;Discovering related phishing domains&lt;/li&gt;     &lt;li&gt;Finding shadow IT and forgotten assets&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * <p><b>202</b> - Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * @param infrastructureMapRequest Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60; 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createInfrastructureMapWithResponseSpec(@javax.annotation.Nonnull InfrastructureMapRequest infrastructureMapRequest) throws WebClientResponseException {
        return createInfrastructureMapRequestCreation(infrastructureMapRequest);
    }

    /**
     * Infrastructure Security Scan (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive security scan of a domain&#39;s infrastructure. Performs reconnaissance, port scanning, service detection, and vulnerability assessment.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (recommended for complete assessment)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration only&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ports:&lt;/b&gt; Port scanning and service detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerabilities:&lt;/b&gt; Known vulnerability checks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS configuration and certificate analysis&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS configuration and zone transfer tests&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration and ownership information&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 30-60 seconds (subdomains, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 5-15 minutes depending on infrastructure size&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;Infrastructure inventory and mapping&lt;/li&gt;     &lt;li&gt;Vulnerability management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain or scan type.
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * @param scanRequest Scan configuration including target domain and scan type.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createInfrastructureScanRequestCreation(@javax.annotation.Nonnull ScanRequest scanRequest) throws WebClientResponseException {
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
        return apiClient.invokeAPI("/v1/ops/scan", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Infrastructure Security Scan (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive security scan of a domain&#39;s infrastructure. Performs reconnaissance, port scanning, service detection, and vulnerability assessment.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (recommended for complete assessment)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration only&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ports:&lt;/b&gt; Port scanning and service detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerabilities:&lt;/b&gt; Known vulnerability checks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS configuration and certificate analysis&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS configuration and zone transfer tests&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration and ownership information&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 30-60 seconds (subdomains, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 5-15 minutes depending on infrastructure size&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;Infrastructure inventory and mapping&lt;/li&gt;     &lt;li&gt;Vulnerability management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain or scan type.
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * @param scanRequest Scan configuration including target domain and scan type.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> createInfrastructureScan(@javax.annotation.Nonnull ScanRequest scanRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createInfrastructureScanRequestCreation(scanRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Infrastructure Security Scan (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive security scan of a domain&#39;s infrastructure. Performs reconnaissance, port scanning, service detection, and vulnerability assessment.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (recommended for complete assessment)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration only&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ports:&lt;/b&gt; Port scanning and service detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerabilities:&lt;/b&gt; Known vulnerability checks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS configuration and certificate analysis&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS configuration and zone transfer tests&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration and ownership information&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 30-60 seconds (subdomains, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 5-15 minutes depending on infrastructure size&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;Infrastructure inventory and mapping&lt;/li&gt;     &lt;li&gt;Vulnerability management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain or scan type.
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * @param scanRequest Scan configuration including target domain and scan type.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> createInfrastructureScanWithHttpInfo(@javax.annotation.Nonnull ScanRequest scanRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createInfrastructureScanRequestCreation(scanRequest).toEntity(localVarReturnType);
    }

    /**
     * Infrastructure Security Scan (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive security scan of a domain&#39;s infrastructure. Performs reconnaissance, port scanning, service detection, and vulnerability assessment.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (recommended for complete assessment)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration only&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ports:&lt;/b&gt; Port scanning and service detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerabilities:&lt;/b&gt; Known vulnerability checks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS configuration and certificate analysis&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS configuration and zone transfer tests&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration and ownership information&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 30-60 seconds (subdomains, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 5-15 minutes depending on infrastructure size&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;Infrastructure inventory and mapping&lt;/li&gt;     &lt;li&gt;Vulnerability management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain or scan type.
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * @param scanRequest Scan configuration including target domain and scan type.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createInfrastructureScanWithResponseSpec(@javax.annotation.Nonnull ScanRequest scanRequest) throws WebClientResponseException {
        return createInfrastructureScanRequestCreation(scanRequest);
    }

    /**
     * Configure Monitoring Alerts (Asynchronous)
     * &lt;p&gt;Create alert rules for a monitored asset. Get notified via webhook, email, or Slack when specific conditions are met.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Site becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; DNS records modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Registration details updated&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Certificate expires soon (7, 14, 30 days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Page content modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Tech stack changes detected&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Webhook (POST to your endpoint)&lt;/li&gt;     &lt;li&gt;Email&lt;/li&gt;     &lt;li&gt;Slack&lt;/li&gt;     &lt;li&gt;PagerDuty&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Example Configuration:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;type\&quot;: \&quot;ssl_expiring\&quot;,   \&quot;threshold_days\&quot;: 14,   \&quot;channels\&quot;: [\&quot;email\&quot;, \&quot;slack\&quot;],   \&quot;email\&quot;: \&quot;alerts@example.com\&quot;,   \&quot;slack_webhook\&quot;: \&quot;https://hooks.slack.com/...\&quot; }&lt;/code&gt;&lt;/pre&gt; 
     * <p><b>400</b> - Invalid alert configuration.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * @param target The domain or IP address to configure alerts for.
     * @param monitoringAlertRequest Alert configuration including type, thresholds, and notification channels.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createMonitoringAlertRequestCreation(@javax.annotation.Nonnull String target, @javax.annotation.Nonnull MonitoringAlertRequest monitoringAlertRequest) throws WebClientResponseException {
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
        return apiClient.invokeAPI("/v1/ops/monitor/{target}/alert", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Configure Monitoring Alerts (Asynchronous)
     * &lt;p&gt;Create alert rules for a monitored asset. Get notified via webhook, email, or Slack when specific conditions are met.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Site becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; DNS records modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Registration details updated&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Certificate expires soon (7, 14, 30 days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Page content modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Tech stack changes detected&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Webhook (POST to your endpoint)&lt;/li&gt;     &lt;li&gt;Email&lt;/li&gt;     &lt;li&gt;Slack&lt;/li&gt;     &lt;li&gt;PagerDuty&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Example Configuration:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;type\&quot;: \&quot;ssl_expiring\&quot;,   \&quot;threshold_days\&quot;: 14,   \&quot;channels\&quot;: [\&quot;email\&quot;, \&quot;slack\&quot;],   \&quot;email\&quot;: \&quot;alerts@example.com\&quot;,   \&quot;slack_webhook\&quot;: \&quot;https://hooks.slack.com/...\&quot; }&lt;/code&gt;&lt;/pre&gt; 
     * <p><b>400</b> - Invalid alert configuration.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * @param target The domain or IP address to configure alerts for.
     * @param monitoringAlertRequest Alert configuration including type, thresholds, and notification channels.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> createMonitoringAlert(@javax.annotation.Nonnull String target, @javax.annotation.Nonnull MonitoringAlertRequest monitoringAlertRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createMonitoringAlertRequestCreation(target, monitoringAlertRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Configure Monitoring Alerts (Asynchronous)
     * &lt;p&gt;Create alert rules for a monitored asset. Get notified via webhook, email, or Slack when specific conditions are met.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Site becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; DNS records modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Registration details updated&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Certificate expires soon (7, 14, 30 days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Page content modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Tech stack changes detected&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Webhook (POST to your endpoint)&lt;/li&gt;     &lt;li&gt;Email&lt;/li&gt;     &lt;li&gt;Slack&lt;/li&gt;     &lt;li&gt;PagerDuty&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Example Configuration:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;type\&quot;: \&quot;ssl_expiring\&quot;,   \&quot;threshold_days\&quot;: 14,   \&quot;channels\&quot;: [\&quot;email\&quot;, \&quot;slack\&quot;],   \&quot;email\&quot;: \&quot;alerts@example.com\&quot;,   \&quot;slack_webhook\&quot;: \&quot;https://hooks.slack.com/...\&quot; }&lt;/code&gt;&lt;/pre&gt; 
     * <p><b>400</b> - Invalid alert configuration.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * @param target The domain or IP address to configure alerts for.
     * @param monitoringAlertRequest Alert configuration including type, thresholds, and notification channels.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> createMonitoringAlertWithHttpInfo(@javax.annotation.Nonnull String target, @javax.annotation.Nonnull MonitoringAlertRequest monitoringAlertRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createMonitoringAlertRequestCreation(target, monitoringAlertRequest).toEntity(localVarReturnType);
    }

    /**
     * Configure Monitoring Alerts (Asynchronous)
     * &lt;p&gt;Create alert rules for a monitored asset. Get notified via webhook, email, or Slack when specific conditions are met.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Site becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; DNS records modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Registration details updated&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Certificate expires soon (7, 14, 30 days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Page content modified&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Tech stack changes detected&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Webhook (POST to your endpoint)&lt;/li&gt;     &lt;li&gt;Email&lt;/li&gt;     &lt;li&gt;Slack&lt;/li&gt;     &lt;li&gt;PagerDuty&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Example Configuration:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;type\&quot;: \&quot;ssl_expiring\&quot;,   \&quot;threshold_days\&quot;: 14,   \&quot;channels\&quot;: [\&quot;email\&quot;, \&quot;slack\&quot;],   \&quot;email\&quot;: \&quot;alerts@example.com\&quot;,   \&quot;slack_webhook\&quot;: \&quot;https://hooks.slack.com/...\&quot; }&lt;/code&gt;&lt;/pre&gt; 
     * <p><b>400</b> - Invalid alert configuration.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Alert configuration job accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * @param target The domain or IP address to configure alerts for.
     * @param monitoringAlertRequest Alert configuration including type, thresholds, and notification channels.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createMonitoringAlertWithResponseSpec(@javax.annotation.Nonnull String target, @javax.annotation.Nonnull MonitoringAlertRequest monitoringAlertRequest) throws WebClientResponseException {
        return createMonitoringAlertRequestCreation(target, monitoringAlertRequest);
    }

    /**
     * Capture a Website Screenshot (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to capture a screenshot of a website. Supports various viewport sizes, full-page captures, and JavaScript rendering.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; A typical screenshot capture takes 10-30 seconds. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve the URL of the final image.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Output:&lt;/b&gt; The job result will contain a URL to download the screenshot image in the specified format (PNG, JPEG, or WebP).&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Screenshot job successfully accepted.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>400</b> - Invalid URL or options provided.
     * @param screenshotRequest The URL and options for the screenshot capture.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createScreenshotRequestCreation(@javax.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
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
        return apiClient.invokeAPI("/v1/ops/screenshot", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Capture a Website Screenshot (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to capture a screenshot of a website. Supports various viewport sizes, full-page captures, and JavaScript rendering.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; A typical screenshot capture takes 10-30 seconds. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve the URL of the final image.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Output:&lt;/b&gt; The job result will contain a URL to download the screenshot image in the specified format (PNG, JPEG, or WebP).&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Screenshot job successfully accepted.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>400</b> - Invalid URL or options provided.
     * @param screenshotRequest The URL and options for the screenshot capture.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> createScreenshot(@javax.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createScreenshotRequestCreation(screenshotRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Capture a Website Screenshot (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to capture a screenshot of a website. Supports various viewport sizes, full-page captures, and JavaScript rendering.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; A typical screenshot capture takes 10-30 seconds. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve the URL of the final image.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Output:&lt;/b&gt; The job result will contain a URL to download the screenshot image in the specified format (PNG, JPEG, or WebP).&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Screenshot job successfully accepted.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>400</b> - Invalid URL or options provided.
     * @param screenshotRequest The URL and options for the screenshot capture.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> createScreenshotWithHttpInfo(@javax.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return createScreenshotRequestCreation(screenshotRequest).toEntity(localVarReturnType);
    }

    /**
     * Capture a Website Screenshot (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to capture a screenshot of a website. Supports various viewport sizes, full-page captures, and JavaScript rendering.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; A typical screenshot capture takes 10-30 seconds. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve the URL of the final image.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Output:&lt;/b&gt; The job result will contain a URL to download the screenshot image in the specified format (PNG, JPEG, or WebP).&lt;/p&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>202</b> - Screenshot job successfully accepted.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>400</b> - Invalid URL or options provided.
     * @param screenshotRequest The URL and options for the screenshot capture.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createScreenshotWithResponseSpec(@javax.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        return createScreenshotRequestCreation(screenshotRequest);
    }

    /**
     * Get Infrastructure Change History
     * &lt;p&gt;Retrieves detected changes in infrastructure configuration for a domain or IP over time. Essential for security monitoring and compliance auditing.&lt;/p&gt; &lt;h4&gt;Change Types Tracked:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT record changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, nameserver changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate replacements and expirations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ip:&lt;/b&gt; IP address changes for domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content:&lt;/b&gt; Homepage content modifications&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology:&lt;/b&gt; Tech stack changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Timeline of changes with before/after values:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;changes\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:30:00Z\&quot;,       \&quot;type\&quot;: \&quot;dns\&quot;,       \&quot;field\&quot;: \&quot;A_RECORD\&quot;,       \&quot;old_value\&quot;: \&quot;8.8.8.8\&quot;,       \&quot;new_value\&quot;: \&quot;1.1.1.1\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Security incident investigation&lt;/li&gt;     &lt;li&gt;Compliance and audit trails&lt;/li&gt;     &lt;li&gt;Detecting unauthorized changes&lt;/li&gt;     &lt;li&gt;Infrastructure change management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved change history.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid change type or date format.
     * <p><b>404</b> - No changes found for the specified target.
     * @param target The domain or IP address to check for changes.
     * @param type Type of changes to retrieve.
     * @param since ISO 8601 timestamp to retrieve changes from. Omit to get all changes.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getChangeDetectionRequestCreation(@javax.annotation.Nonnull String target, @javax.annotation.Nullable String type, @javax.annotation.Nullable String since) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'target' is set
        if (target == null) {
            throw new WebClientResponseException("Missing the required parameter 'target' when calling getChangeDetection", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("target", target);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "since", since));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/ops/changes/{target}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Infrastructure Change History
     * &lt;p&gt;Retrieves detected changes in infrastructure configuration for a domain or IP over time. Essential for security monitoring and compliance auditing.&lt;/p&gt; &lt;h4&gt;Change Types Tracked:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT record changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, nameserver changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate replacements and expirations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ip:&lt;/b&gt; IP address changes for domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content:&lt;/b&gt; Homepage content modifications&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology:&lt;/b&gt; Tech stack changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Timeline of changes with before/after values:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;changes\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:30:00Z\&quot;,       \&quot;type\&quot;: \&quot;dns\&quot;,       \&quot;field\&quot;: \&quot;A_RECORD\&quot;,       \&quot;old_value\&quot;: \&quot;8.8.8.8\&quot;,       \&quot;new_value\&quot;: \&quot;1.1.1.1\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Security incident investigation&lt;/li&gt;     &lt;li&gt;Compliance and audit trails&lt;/li&gt;     &lt;li&gt;Detecting unauthorized changes&lt;/li&gt;     &lt;li&gt;Infrastructure change management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved change history.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid change type or date format.
     * <p><b>404</b> - No changes found for the specified target.
     * @param target The domain or IP address to check for changes.
     * @param type Type of changes to retrieve.
     * @param since ISO 8601 timestamp to retrieve changes from. Omit to get all changes.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getChangeDetection(@javax.annotation.Nonnull String target, @javax.annotation.Nullable String type, @javax.annotation.Nullable String since) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getChangeDetectionRequestCreation(target, type, since).bodyToMono(localVarReturnType);
    }

    /**
     * Get Infrastructure Change History
     * &lt;p&gt;Retrieves detected changes in infrastructure configuration for a domain or IP over time. Essential for security monitoring and compliance auditing.&lt;/p&gt; &lt;h4&gt;Change Types Tracked:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT record changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, nameserver changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate replacements and expirations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ip:&lt;/b&gt; IP address changes for domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content:&lt;/b&gt; Homepage content modifications&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology:&lt;/b&gt; Tech stack changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Timeline of changes with before/after values:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;changes\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:30:00Z\&quot;,       \&quot;type\&quot;: \&quot;dns\&quot;,       \&quot;field\&quot;: \&quot;A_RECORD\&quot;,       \&quot;old_value\&quot;: \&quot;8.8.8.8\&quot;,       \&quot;new_value\&quot;: \&quot;1.1.1.1\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Security incident investigation&lt;/li&gt;     &lt;li&gt;Compliance and audit trails&lt;/li&gt;     &lt;li&gt;Detecting unauthorized changes&lt;/li&gt;     &lt;li&gt;Infrastructure change management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved change history.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid change type or date format.
     * <p><b>404</b> - No changes found for the specified target.
     * @param target The domain or IP address to check for changes.
     * @param type Type of changes to retrieve.
     * @param since ISO 8601 timestamp to retrieve changes from. Omit to get all changes.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getChangeDetectionWithHttpInfo(@javax.annotation.Nonnull String target, @javax.annotation.Nullable String type, @javax.annotation.Nullable String since) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getChangeDetectionRequestCreation(target, type, since).toEntity(localVarReturnType);
    }

    /**
     * Get Infrastructure Change History
     * &lt;p&gt;Retrieves detected changes in infrastructure configuration for a domain or IP over time. Essential for security monitoring and compliance auditing.&lt;/p&gt; &lt;h4&gt;Change Types Tracked:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT record changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, nameserver changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate replacements and expirations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ip:&lt;/b&gt; IP address changes for domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content:&lt;/b&gt; Homepage content modifications&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology:&lt;/b&gt; Tech stack changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Timeline of changes with before/after values:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;changes\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:30:00Z\&quot;,       \&quot;type\&quot;: \&quot;dns\&quot;,       \&quot;field\&quot;: \&quot;A_RECORD\&quot;,       \&quot;old_value\&quot;: \&quot;8.8.8.8\&quot;,       \&quot;new_value\&quot;: \&quot;1.1.1.1\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Security incident investigation&lt;/li&gt;     &lt;li&gt;Compliance and audit trails&lt;/li&gt;     &lt;li&gt;Detecting unauthorized changes&lt;/li&gt;     &lt;li&gt;Infrastructure change management&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved change history.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid change type or date format.
     * <p><b>404</b> - No changes found for the specified target.
     * @param target The domain or IP address to check for changes.
     * @param type Type of changes to retrieve.
     * @param since ISO 8601 timestamp to retrieve changes from. Omit to get all changes.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getChangeDetectionWithResponseSpec(@javax.annotation.Nonnull String target, @javax.annotation.Nullable String type, @javax.annotation.Nullable String since) throws WebClientResponseException {
        return getChangeDetectionRequestCreation(target, type, since);
    }

    /**
     * Get Asynchronous Job Status and Results
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Job ID not found.
     * @param jobId The unique ID of the job, returned from a &#x60;POST&#x60; operation.
     * @return Job
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getJobRequestCreation(@javax.annotation.Nonnull String jobId) throws WebClientResponseException {
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
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Job ID not found.
     * @param jobId The unique ID of the job, returned from a &#x60;POST&#x60; operation.
     * @return Job
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Job> getJob(@javax.annotation.Nonnull String jobId) throws WebClientResponseException {
        ParameterizedTypeReference<Job> localVarReturnType = new ParameterizedTypeReference<Job>() {};
        return getJobRequestCreation(jobId).bodyToMono(localVarReturnType);
    }

    /**
     * Get Asynchronous Job Status and Results
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Job ID not found.
     * @param jobId The unique ID of the job, returned from a &#x60;POST&#x60; operation.
     * @return ResponseEntity&lt;Job&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Job>> getJobWithHttpInfo(@javax.annotation.Nonnull String jobId) throws WebClientResponseException {
        ParameterizedTypeReference<Job> localVarReturnType = new ParameterizedTypeReference<Job>() {};
        return getJobRequestCreation(jobId).toEntity(localVarReturnType);
    }

    /**
     * Get Asynchronous Job Status and Results
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Job ID not found.
     * @param jobId The unique ID of the job, returned from a &#x60;POST&#x60; operation.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getJobWithResponseSpec(@javax.annotation.Nonnull String jobId) throws WebClientResponseException {
        return getJobRequestCreation(jobId);
    }

    /**
     * Get Monitoring Status and Metrics
     * &lt;p&gt;Retrieves current monitoring configuration and historical metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Status Information:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Monitoring State:&lt;/b&gt; Active, paused, or not monitored&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Check Frequency:&lt;/b&gt; How often checks are performed&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Active Alerts:&lt;/b&gt; Currently triggered alert conditions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Last Check:&lt;/b&gt; Timestamp of most recent check&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>404</b> - Target is not being monitored.
     * @param target The domain or IP address to check monitoring status for.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getMonitoringStatusRequestCreation(@javax.annotation.Nonnull String target) throws WebClientResponseException {
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
        return apiClient.invokeAPI("/v1/ops/monitor/{target}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Monitoring Status and Metrics
     * &lt;p&gt;Retrieves current monitoring configuration and historical metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Status Information:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Monitoring State:&lt;/b&gt; Active, paused, or not monitored&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Check Frequency:&lt;/b&gt; How often checks are performed&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Active Alerts:&lt;/b&gt; Currently triggered alert conditions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Last Check:&lt;/b&gt; Timestamp of most recent check&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>404</b> - Target is not being monitored.
     * @param target The domain or IP address to check monitoring status for.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getMonitoringStatus(@javax.annotation.Nonnull String target) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getMonitoringStatusRequestCreation(target).bodyToMono(localVarReturnType);
    }

    /**
     * Get Monitoring Status and Metrics
     * &lt;p&gt;Retrieves current monitoring configuration and historical metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Status Information:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Monitoring State:&lt;/b&gt; Active, paused, or not monitored&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Check Frequency:&lt;/b&gt; How often checks are performed&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Active Alerts:&lt;/b&gt; Currently triggered alert conditions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Last Check:&lt;/b&gt; Timestamp of most recent check&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>404</b> - Target is not being monitored.
     * @param target The domain or IP address to check monitoring status for.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getMonitoringStatusWithHttpInfo(@javax.annotation.Nonnull String target) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getMonitoringStatusRequestCreation(target).toEntity(localVarReturnType);
    }

    /**
     * Get Monitoring Status and Metrics
     * &lt;p&gt;Retrieves current monitoring configuration and historical metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Status Information:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Monitoring State:&lt;/b&gt; Active, paused, or not monitored&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Check Frequency:&lt;/b&gt; How often checks are performed&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Active Alerts:&lt;/b&gt; Currently triggered alert conditions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Last Check:&lt;/b&gt; Timestamp of most recent check&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>404</b> - Target is not being monitored.
     * @param target The domain or IP address to check monitoring status for.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getMonitoringStatusWithResponseSpec(@javax.annotation.Nonnull String target) throws WebClientResponseException {
        return getMonitoringStatusRequestCreation(target);
    }

    /**
     * Get Screenshot History
     * &lt;p&gt;Retrieve all previously captured screenshots for a specific URL, ordered by capture time (newest first). Includes download URLs and metadata for each capture.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Download URL:&lt;/b&gt; Direct link to screenshot image&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Time:&lt;/b&gt; Timestamp when screenshot was taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Dimensions:&lt;/b&gt; Image width and height&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Format:&lt;/b&gt; Image format (PNG, JPEG, WebP)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;File Size:&lt;/b&gt; Size in bytes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Review website evolution over time&lt;/li&gt;     &lt;li&gt;Compare screenshots for change detection&lt;/li&gt;     &lt;li&gt;Download historical screenshots for reporting&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No screenshots found for the specified URL.
     * <p><b>200</b> - Successfully retrieved screenshot history.
     * <p><b>400</b> - Invalid URL parameter.
     * @param url The URL to retrieve screenshot history for.
     * @param limit Maximum number of screenshots to return.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getScreenshotHistoryRequestCreation(@javax.annotation.Nonnull String url, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'url' is set
        if (url == null) {
            throw new WebClientResponseException("Missing the required parameter 'url' when calling getScreenshotHistory", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "url", url));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/ops/screenshot/history", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Screenshot History
     * &lt;p&gt;Retrieve all previously captured screenshots for a specific URL, ordered by capture time (newest first). Includes download URLs and metadata for each capture.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Download URL:&lt;/b&gt; Direct link to screenshot image&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Time:&lt;/b&gt; Timestamp when screenshot was taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Dimensions:&lt;/b&gt; Image width and height&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Format:&lt;/b&gt; Image format (PNG, JPEG, WebP)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;File Size:&lt;/b&gt; Size in bytes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Review website evolution over time&lt;/li&gt;     &lt;li&gt;Compare screenshots for change detection&lt;/li&gt;     &lt;li&gt;Download historical screenshots for reporting&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No screenshots found for the specified URL.
     * <p><b>200</b> - Successfully retrieved screenshot history.
     * <p><b>400</b> - Invalid URL parameter.
     * @param url The URL to retrieve screenshot history for.
     * @param limit Maximum number of screenshots to return.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getScreenshotHistory(@javax.annotation.Nonnull String url, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getScreenshotHistoryRequestCreation(url, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Get Screenshot History
     * &lt;p&gt;Retrieve all previously captured screenshots for a specific URL, ordered by capture time (newest first). Includes download URLs and metadata for each capture.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Download URL:&lt;/b&gt; Direct link to screenshot image&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Time:&lt;/b&gt; Timestamp when screenshot was taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Dimensions:&lt;/b&gt; Image width and height&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Format:&lt;/b&gt; Image format (PNG, JPEG, WebP)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;File Size:&lt;/b&gt; Size in bytes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Review website evolution over time&lt;/li&gt;     &lt;li&gt;Compare screenshots for change detection&lt;/li&gt;     &lt;li&gt;Download historical screenshots for reporting&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No screenshots found for the specified URL.
     * <p><b>200</b> - Successfully retrieved screenshot history.
     * <p><b>400</b> - Invalid URL parameter.
     * @param url The URL to retrieve screenshot history for.
     * @param limit Maximum number of screenshots to return.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getScreenshotHistoryWithHttpInfo(@javax.annotation.Nonnull String url, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getScreenshotHistoryRequestCreation(url, limit).toEntity(localVarReturnType);
    }

    /**
     * Get Screenshot History
     * &lt;p&gt;Retrieve all previously captured screenshots for a specific URL, ordered by capture time (newest first). Includes download URLs and metadata for each capture.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Download URL:&lt;/b&gt; Direct link to screenshot image&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Time:&lt;/b&gt; Timestamp when screenshot was taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Dimensions:&lt;/b&gt; Image width and height&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Format:&lt;/b&gt; Image format (PNG, JPEG, WebP)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;File Size:&lt;/b&gt; Size in bytes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Review website evolution over time&lt;/li&gt;     &lt;li&gt;Compare screenshots for change detection&lt;/li&gt;     &lt;li&gt;Download historical screenshots for reporting&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No screenshots found for the specified URL.
     * <p><b>200</b> - Successfully retrieved screenshot history.
     * <p><b>400</b> - Invalid URL parameter.
     * @param url The URL to retrieve screenshot history for.
     * @param limit Maximum number of screenshots to return.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getScreenshotHistoryWithResponseSpec(@javax.annotation.Nonnull String url, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        return getScreenshotHistoryRequestCreation(url, limit);
    }

    /**
     * List Recent Jobs
     * &lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved job list.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param status Filter by job status
     * @param limit Maximum number of jobs to return
     * @param offset Number of jobs to skip
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listJobsRequestCreation(@javax.annotation.Nullable String status, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable Integer offset) throws WebClientResponseException {
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
     * <p><b>200</b> - Successfully retrieved job list.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param status Filter by job status
     * @param limit Maximum number of jobs to return
     * @param offset Number of jobs to skip
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> listJobs(@javax.annotation.Nullable String status, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable Integer offset) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return listJobsRequestCreation(status, limit, offset).bodyToMono(localVarReturnType);
    }

    /**
     * List Recent Jobs
     * &lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved job list.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param status Filter by job status
     * @param limit Maximum number of jobs to return
     * @param offset Number of jobs to skip
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> listJobsWithHttpInfo(@javax.annotation.Nullable String status, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable Integer offset) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return listJobsRequestCreation(status, limit, offset).toEntity(localVarReturnType);
    }

    /**
     * List Recent Jobs
     * &lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved job list.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param status Filter by job status
     * @param limit Maximum number of jobs to return
     * @param offset Number of jobs to skip
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec listJobsWithResponseSpec(@javax.annotation.Nullable String status, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable Integer offset) throws WebClientResponseException {
        return listJobsRequestCreation(status, limit, offset);
    }

    /**
     * Schedule Recurring Screenshots (Asynchronous)
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Retention:&lt;/b&gt; Auto-cleanup old screenshots (default: keep last 30)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * @param screenshotRequest Schedule configuration including URL, schedule timing, and screenshot options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec scheduleScreenshotRequestCreation(@javax.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
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
        return apiClient.invokeAPI("/v1/ops/screenshot/schedule", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Schedule Recurring Screenshots (Asynchronous)
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Retention:&lt;/b&gt; Auto-cleanup old screenshots (default: keep last 30)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * @param screenshotRequest Schedule configuration including URL, schedule timing, and screenshot options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> scheduleScreenshot(@javax.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return scheduleScreenshotRequestCreation(screenshotRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Schedule Recurring Screenshots (Asynchronous)
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Retention:&lt;/b&gt; Auto-cleanup old screenshots (default: keep last 30)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * @param screenshotRequest Schedule configuration including URL, schedule timing, and screenshot options.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> scheduleScreenshotWithHttpInfo(@javax.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return scheduleScreenshotRequestCreation(screenshotRequest).toEntity(localVarReturnType);
    }

    /**
     * Schedule Recurring Screenshots (Asynchronous)
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Retention:&lt;/b&gt; Auto-cleanup old screenshots (default: keep last 30)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * @param screenshotRequest Schedule configuration including URL, schedule timing, and screenshot options.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec scheduleScreenshotWithResponseSpec(@javax.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        return scheduleScreenshotRequestCreation(screenshotRequest);
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
    private ResponseSpec similarDomainsRequestCreation(@javax.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
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
        return apiClient.invokeAPI("/v1/ops/similar-domains", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
    public Mono<JobResponse> similarDomains(@javax.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
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
    public Mono<ResponseEntity<JobResponse>> similarDomainsWithHttpInfo(@javax.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
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
    public ResponseSpec similarDomainsWithResponseSpec(@javax.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
        return similarDomainsRequestCreation(similarDomainsOpsRequest);
    }
}
