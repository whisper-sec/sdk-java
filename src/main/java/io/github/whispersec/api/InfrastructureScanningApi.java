package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.InfrastructureMapRequest;
import io.github.whispersec.model.JobResponse;
import io.github.whispersec.model.ScanRequest;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-09T22:14:53.714678089Z[Etc/UTC]", comments = "Generator version: 7.17.0")
public class InfrastructureScanningApi {
    private ApiClient apiClient;

    public InfrastructureScanningApi() {
        this(new ApiClient());
    }

    public InfrastructureScanningApi(ApiClient apiClient) {
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
     * <p><b>202</b> - Mapping job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * <p><b>400</b> - Invalid starting point or depth (must be 1-3).
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param infrastructureMapRequest Mapping configuration. Example: &#x60;&#x60;&#x60;json {   \&quot;startPoint\&quot;: \&quot;example.com\&quot;,   \&quot;depth\&quot;: 2 } &#x60;&#x60;&#x60; 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createInfrastructureMapWithResponseSpec(@jakarta.annotation.Nonnull InfrastructureMapRequest infrastructureMapRequest) throws WebClientResponseException {
        return createInfrastructureMapRequestCreation(infrastructureMapRequest);
    }

    /**
     * Infrastructure Security Scan (Asynchronous)
     * &lt;p&gt;Initiates a security scan of a domain&#39;s infrastructure. Performs reconnaissance and configuration analysis.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (subdomains, dns, ssl, technologies, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration and discovery&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS certificate analysis (issuer, validity, expiration, protocol)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record analysis and configuration&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection via headers and NoctisEyes scan&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Domain registration and ownership information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerability:&lt;/b&gt; Dedicated vulnerability scan using NoctisEyes (detects security misconfigurations, exposed services, known CVEs)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 10-30 seconds (ssl, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Medium scans:&lt;/b&gt; 30-60 seconds (subdomains)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Technologies scan:&lt;/b&gt; 2-5 minutes (includes NoctisEyes vulnerability scan)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Vulnerability scan:&lt;/b&gt; 2-5 minutes (dedicated NoctisEyes security scan with severity breakdown)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 3-5 minutes (all modules in parallel)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;SSL certificate monitoring&lt;/li&gt;     &lt;li&gt;Infrastructure inventory&lt;/li&gt;     &lt;li&gt;Vulnerability assessment and security audits&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>400</b> - Invalid domain or scan type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * &lt;p&gt;Initiates a security scan of a domain&#39;s infrastructure. Performs reconnaissance and configuration analysis.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (subdomains, dns, ssl, technologies, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration and discovery&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS certificate analysis (issuer, validity, expiration, protocol)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record analysis and configuration&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection via headers and NoctisEyes scan&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Domain registration and ownership information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerability:&lt;/b&gt; Dedicated vulnerability scan using NoctisEyes (detects security misconfigurations, exposed services, known CVEs)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 10-30 seconds (ssl, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Medium scans:&lt;/b&gt; 30-60 seconds (subdomains)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Technologies scan:&lt;/b&gt; 2-5 minutes (includes NoctisEyes vulnerability scan)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Vulnerability scan:&lt;/b&gt; 2-5 minutes (dedicated NoctisEyes security scan with severity breakdown)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 3-5 minutes (all modules in parallel)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;SSL certificate monitoring&lt;/li&gt;     &lt;li&gt;Infrastructure inventory&lt;/li&gt;     &lt;li&gt;Vulnerability assessment and security audits&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>400</b> - Invalid domain or scan type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * &lt;p&gt;Initiates a security scan of a domain&#39;s infrastructure. Performs reconnaissance and configuration analysis.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (subdomains, dns, ssl, technologies, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration and discovery&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS certificate analysis (issuer, validity, expiration, protocol)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record analysis and configuration&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection via headers and NoctisEyes scan&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Domain registration and ownership information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerability:&lt;/b&gt; Dedicated vulnerability scan using NoctisEyes (detects security misconfigurations, exposed services, known CVEs)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 10-30 seconds (ssl, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Medium scans:&lt;/b&gt; 30-60 seconds (subdomains)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Technologies scan:&lt;/b&gt; 2-5 minutes (includes NoctisEyes vulnerability scan)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Vulnerability scan:&lt;/b&gt; 2-5 minutes (dedicated NoctisEyes security scan with severity breakdown)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 3-5 minutes (all modules in parallel)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;SSL certificate monitoring&lt;/li&gt;     &lt;li&gt;Infrastructure inventory&lt;/li&gt;     &lt;li&gt;Vulnerability assessment and security audits&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>400</b> - Invalid domain or scan type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * &lt;p&gt;Initiates a security scan of a domain&#39;s infrastructure. Performs reconnaissance and configuration analysis.&lt;/p&gt; &lt;h4&gt;Scan Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;comprehensive:&lt;/b&gt; Full scan including all modules (subdomains, dns, ssl, technologies, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Subdomain enumeration and discovery&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL/TLS certificate analysis (issuer, validity, expiration, protocol)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record analysis and configuration&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technologies:&lt;/b&gt; Technology stack detection via headers and NoctisEyes scan&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Domain registration and ownership information&lt;/li&gt;     &lt;li&gt;&lt;b&gt;vulnerability:&lt;/b&gt; Dedicated vulnerability scan using NoctisEyes (detects security misconfigurations, exposed services, known CVEs)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Quick scans:&lt;/b&gt; 10-30 seconds (ssl, dns, whois)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Medium scans:&lt;/b&gt; 30-60 seconds (subdomains)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Technologies scan:&lt;/b&gt; 2-5 minutes (includes NoctisEyes vulnerability scan)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Vulnerability scan:&lt;/b&gt; 2-5 minutes (dedicated NoctisEyes security scan with severity breakdown)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Comprehensive scan:&lt;/b&gt; 3-5 minutes (all modules in parallel)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Pre-engagement reconnaissance for penetration testing&lt;/li&gt;     &lt;li&gt;Attack surface assessment&lt;/li&gt;     &lt;li&gt;SSL certificate monitoring&lt;/li&gt;     &lt;li&gt;Infrastructure inventory&lt;/li&gt;     &lt;li&gt;Vulnerability assessment and security audits&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Scan job successfully accepted. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for results.
     * <p><b>400</b> - Invalid domain or scan type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param scanRequest Scan configuration including target domain and scan type.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createInfrastructureScanWithResponseSpec(@jakarta.annotation.Nonnull ScanRequest scanRequest) throws WebClientResponseException {
        return createInfrastructureScanRequestCreation(scanRequest);
    }
}
