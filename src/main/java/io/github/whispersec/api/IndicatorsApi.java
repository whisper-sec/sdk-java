package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.BulkRequest;
import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.HistoryResponse;
import io.github.whispersec.model.IndicatorResponse;
import io.github.whispersec.model.JobResponse;
import io.github.whispersec.model.SearchRequest;
import io.github.whispersec.model.SimilarDomainRequest;
import io.github.whispersec.model.SubdomainResponse;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-11-05T20:31:50.571465974Z[Etc/UTC]", comments = "Generator version: 7.16.0")
public class IndicatorsApi {
    private ApiClient apiClient;

    public IndicatorsApi() {
        this(new ApiClient());
    }

    public IndicatorsApi(ApiClient apiClient) {
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
     * <p><b>202</b> - Bulk job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkRequest List of indicators and processing options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec bulkEnrichmentRequestCreation(@javax.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
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
        return apiClient.invokeAPI("/v1/indicators/bulk", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance:&lt;/b&gt; Processing time depends on batch size and requested data modules. Expect 5-30 seconds for typical batches.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Rate Limits:&lt;/b&gt; Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt; 
     * <p><b>202</b> - Bulk job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkRequest List of indicators and processing options.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> bulkEnrichment(@javax.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return bulkEnrichmentRequestCreation(bulkRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance:&lt;/b&gt; Processing time depends on batch size and requested data modules. Expect 5-30 seconds for typical batches.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Rate Limits:&lt;/b&gt; Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt; 
     * <p><b>202</b> - Bulk job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkRequest List of indicators and processing options.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> bulkEnrichmentWithHttpInfo(@javax.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return bulkEnrichmentRequestCreation(bulkRequest).toEntity(localVarReturnType);
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance:&lt;/b&gt; Processing time depends on batch size and requested data modules. Expect 5-30 seconds for typical batches.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Rate Limits:&lt;/b&gt; Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt; 
     * <p><b>202</b> - Bulk job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkRequest List of indicators and processing options.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec bulkEnrichmentWithResponseSpec(@javax.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        return bulkEnrichmentRequestCreation(bulkRequest);
    }

    /**
     * Generate Similar Domains - GET (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains using default options. This GET variant is provided for convenience.&lt;/p&gt; &lt;p&gt;For custom options (algorithms, limits, etc.), use the POST version of this endpoint.&lt;/p&gt; &lt;p&gt;The API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when complete.&lt;/p&gt; 
     * <p><b>202</b> - Job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain format in path.
     * @param domain The domain to generate variations for.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec generateSimilarDomainsGetRequestCreation(@javax.annotation.Nonnull String domain) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'domain' is set
        if (domain == null) {
            throw new WebClientResponseException("Missing the required parameter 'domain' when calling generateSimilarDomainsGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/indicators/domain/{domain}/similar", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Generate Similar Domains - GET (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains using default options. This GET variant is provided for convenience.&lt;/p&gt; &lt;p&gt;For custom options (algorithms, limits, etc.), use the POST version of this endpoint.&lt;/p&gt; &lt;p&gt;The API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when complete.&lt;/p&gt; 
     * <p><b>202</b> - Job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain format in path.
     * @param domain The domain to generate variations for.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> generateSimilarDomainsGet(@javax.annotation.Nonnull String domain) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return generateSimilarDomainsGetRequestCreation(domain).bodyToMono(localVarReturnType);
    }

    /**
     * Generate Similar Domains - GET (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains using default options. This GET variant is provided for convenience.&lt;/p&gt; &lt;p&gt;For custom options (algorithms, limits, etc.), use the POST version of this endpoint.&lt;/p&gt; &lt;p&gt;The API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when complete.&lt;/p&gt; 
     * <p><b>202</b> - Job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain format in path.
     * @param domain The domain to generate variations for.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> generateSimilarDomainsGetWithHttpInfo(@javax.annotation.Nonnull String domain) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return generateSimilarDomainsGetRequestCreation(domain).toEntity(localVarReturnType);
    }

    /**
     * Generate Similar Domains - GET (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains using default options. This GET variant is provided for convenience.&lt;/p&gt; &lt;p&gt;For custom options (algorithms, limits, etc.), use the POST version of this endpoint.&lt;/p&gt; &lt;p&gt;The API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when complete.&lt;/p&gt; 
     * <p><b>202</b> - Job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain format in path.
     * @param domain The domain to generate variations for.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec generateSimilarDomainsGetWithResponseSpec(@javax.annotation.Nonnull String domain) throws WebClientResponseException {
        return generateSimilarDomainsGetRequestCreation(domain);
    }

    /**
     * Generate Similar Domains - POST (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains for typosquatting, homoglyph, and brand protection analysis. This is a powerful tool for proactive threat hunting.&lt;/p&gt; &lt;p&gt;Because this can be a long-running process, the API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when the job is complete.&lt;/p&gt; &lt;p&gt;Use this POST version to specify custom options like algorithms, limits, or filters.&lt;/p&gt; 
     * <p><b>202</b> - Job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain format in path.
     * @param domain The domain to generate variations for.
     * @param similarDomainRequest Configuration for the similarity generation.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec generateSimilarDomainsPostRequestCreation(@javax.annotation.Nonnull String domain, @javax.annotation.Nullable SimilarDomainRequest similarDomainRequest) throws WebClientResponseException {
        Object postBody = similarDomainRequest;
        // verify the required parameter 'domain' is set
        if (domain == null) {
            throw new WebClientResponseException("Missing the required parameter 'domain' when calling generateSimilarDomainsPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/indicators/domain/{domain}/similar", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Generate Similar Domains - POST (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains for typosquatting, homoglyph, and brand protection analysis. This is a powerful tool for proactive threat hunting.&lt;/p&gt; &lt;p&gt;Because this can be a long-running process, the API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when the job is complete.&lt;/p&gt; &lt;p&gt;Use this POST version to specify custom options like algorithms, limits, or filters.&lt;/p&gt; 
     * <p><b>202</b> - Job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain format in path.
     * @param domain The domain to generate variations for.
     * @param similarDomainRequest Configuration for the similarity generation.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> generateSimilarDomainsPost(@javax.annotation.Nonnull String domain, @javax.annotation.Nullable SimilarDomainRequest similarDomainRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return generateSimilarDomainsPostRequestCreation(domain, similarDomainRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Generate Similar Domains - POST (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains for typosquatting, homoglyph, and brand protection analysis. This is a powerful tool for proactive threat hunting.&lt;/p&gt; &lt;p&gt;Because this can be a long-running process, the API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when the job is complete.&lt;/p&gt; &lt;p&gt;Use this POST version to specify custom options like algorithms, limits, or filters.&lt;/p&gt; 
     * <p><b>202</b> - Job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain format in path.
     * @param domain The domain to generate variations for.
     * @param similarDomainRequest Configuration for the similarity generation.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> generateSimilarDomainsPostWithHttpInfo(@javax.annotation.Nonnull String domain, @javax.annotation.Nullable SimilarDomainRequest similarDomainRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return generateSimilarDomainsPostRequestCreation(domain, similarDomainRequest).toEntity(localVarReturnType);
    }

    /**
     * Generate Similar Domains - POST (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to generate potential lookalike domains for typosquatting, homoglyph, and brand protection analysis. This is a powerful tool for proactive threat hunting.&lt;/p&gt; &lt;p&gt;Because this can be a long-running process, the API immediately returns a &#x60;jobId&#x60;. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to get the results when the job is complete.&lt;/p&gt; &lt;p&gt;Use this POST version to specify custom options like algorithms, limits, or filters.&lt;/p&gt; 
     * <p><b>202</b> - Job successfully accepted for processing.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid domain format in path.
     * @param domain The domain to generate variations for.
     * @param similarDomainRequest Configuration for the similarity generation.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec generateSimilarDomainsPostWithResponseSpec(@javax.annotation.Nonnull String domain, @javax.annotation.Nullable SimilarDomainRequest similarDomainRequest) throws WebClientResponseException {
        return generateSimilarDomainsPostRequestCreation(domain, similarDomainRequest);
    }

    /**
     * Enrich a Single Indicator (IP or Domain)
     * &lt;p&gt;Retrieves comprehensive intelligence for a single IP address or domain. This is the primary, high-performance endpoint for synchronous enrichment.&lt;/p&gt; &lt;p&gt;It aggregates data from multiple sources, including geolocation, WHOIS, DNS, reputation scoring, and relationship mapping. Use the &#x60;include&#x60; parameter to request additional, deeper data sets that may have higher latency.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Base Response:&lt;/b&gt; Typically under 500ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;routing&#x60;:&lt;/b&gt; First request may take up to 5 seconds; subsequent requests are cached for 5 minutes and respond in &amp;lt;200ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;ip_intelligence&#x60;:&lt;/b&gt; Adds 200-500ms of latency for each IP address resolved from the domain.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - The requested indicator was not found in our datasets.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>400</b> - Invalid indicator format or unsupported type.
     * <p><b>200</b> - Successfully retrieved intelligence data.
     * @param type The type of indicator to enrich.
     * @param value The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
     * @param include A comma-separated list of additional data modules to include in the response. Requesting more modules may increase latency.
     * @return IndicatorResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIndicatorRequestCreation(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable String include) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling getIndicator", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling getIndicator", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include", include));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<IndicatorResponse> localVarReturnType = new ParameterizedTypeReference<IndicatorResponse>() {};
        return apiClient.invokeAPI("/v1/indicators/{type}/{value}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Enrich a Single Indicator (IP or Domain)
     * &lt;p&gt;Retrieves comprehensive intelligence for a single IP address or domain. This is the primary, high-performance endpoint for synchronous enrichment.&lt;/p&gt; &lt;p&gt;It aggregates data from multiple sources, including geolocation, WHOIS, DNS, reputation scoring, and relationship mapping. Use the &#x60;include&#x60; parameter to request additional, deeper data sets that may have higher latency.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Base Response:&lt;/b&gt; Typically under 500ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;routing&#x60;:&lt;/b&gt; First request may take up to 5 seconds; subsequent requests are cached for 5 minutes and respond in &amp;lt;200ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;ip_intelligence&#x60;:&lt;/b&gt; Adds 200-500ms of latency for each IP address resolved from the domain.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - The requested indicator was not found in our datasets.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>400</b> - Invalid indicator format or unsupported type.
     * <p><b>200</b> - Successfully retrieved intelligence data.
     * @param type The type of indicator to enrich.
     * @param value The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
     * @param include A comma-separated list of additional data modules to include in the response. Requesting more modules may increase latency.
     * @return IndicatorResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<IndicatorResponse> getIndicator(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable String include) throws WebClientResponseException {
        ParameterizedTypeReference<IndicatorResponse> localVarReturnType = new ParameterizedTypeReference<IndicatorResponse>() {};
        return getIndicatorRequestCreation(type, value, include).bodyToMono(localVarReturnType);
    }

    /**
     * Enrich a Single Indicator (IP or Domain)
     * &lt;p&gt;Retrieves comprehensive intelligence for a single IP address or domain. This is the primary, high-performance endpoint for synchronous enrichment.&lt;/p&gt; &lt;p&gt;It aggregates data from multiple sources, including geolocation, WHOIS, DNS, reputation scoring, and relationship mapping. Use the &#x60;include&#x60; parameter to request additional, deeper data sets that may have higher latency.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Base Response:&lt;/b&gt; Typically under 500ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;routing&#x60;:&lt;/b&gt; First request may take up to 5 seconds; subsequent requests are cached for 5 minutes and respond in &amp;lt;200ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;ip_intelligence&#x60;:&lt;/b&gt; Adds 200-500ms of latency for each IP address resolved from the domain.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - The requested indicator was not found in our datasets.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>400</b> - Invalid indicator format or unsupported type.
     * <p><b>200</b> - Successfully retrieved intelligence data.
     * @param type The type of indicator to enrich.
     * @param value The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
     * @param include A comma-separated list of additional data modules to include in the response. Requesting more modules may increase latency.
     * @return ResponseEntity&lt;IndicatorResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<IndicatorResponse>> getIndicatorWithHttpInfo(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable String include) throws WebClientResponseException {
        ParameterizedTypeReference<IndicatorResponse> localVarReturnType = new ParameterizedTypeReference<IndicatorResponse>() {};
        return getIndicatorRequestCreation(type, value, include).toEntity(localVarReturnType);
    }

    /**
     * Enrich a Single Indicator (IP or Domain)
     * &lt;p&gt;Retrieves comprehensive intelligence for a single IP address or domain. This is the primary, high-performance endpoint for synchronous enrichment.&lt;/p&gt; &lt;p&gt;It aggregates data from multiple sources, including geolocation, WHOIS, DNS, reputation scoring, and relationship mapping. Use the &#x60;include&#x60; parameter to request additional, deeper data sets that may have higher latency.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Base Response:&lt;/b&gt; Typically under 500ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;routing&#x60;:&lt;/b&gt; First request may take up to 5 seconds; subsequent requests are cached for 5 minutes and respond in &amp;lt;200ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;ip_intelligence&#x60;:&lt;/b&gt; Adds 200-500ms of latency for each IP address resolved from the domain.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - The requested indicator was not found in our datasets.
     * <p><b>429</b> - Rate limit exceeded.
     * <p><b>400</b> - Invalid indicator format or unsupported type.
     * <p><b>200</b> - Successfully retrieved intelligence data.
     * @param type The type of indicator to enrich.
     * @param value The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
     * @param include A comma-separated list of additional data modules to include in the response. Requesting more modules may increase latency.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIndicatorWithResponseSpec(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable String include) throws WebClientResponseException {
        return getIndicatorRequestCreation(type, value, include);
    }

    /**
     * Get Infrastructure Relationship Graph
     * &lt;p&gt;Returns graph visualization data showing relationships between the indicator and related infrastructure. Perfect for interactive network diagrams and threat actor infrastructure mapping.&lt;/p&gt; &lt;h4&gt;Relationship Types Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;For Domains:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Resolves to IPs&lt;/li&gt;             &lt;li&gt;Shares nameservers with&lt;/li&gt;             &lt;li&gt;Same SSL certificate as&lt;/li&gt;             &lt;li&gt;Same registrant as&lt;/li&gt;             &lt;li&gt;Links to/from other domains&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt;     &lt;li&gt;&lt;b&gt;For IPs:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Hosts domains&lt;/li&gt;             &lt;li&gt;Same ASN as&lt;/li&gt;             &lt;li&gt;Same network block as&lt;/li&gt;             &lt;li&gt;Connected via routing&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Compatible with react-force-graph, vis.js, cytoscape.js:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;nodes\&quot;: [     {\&quot;id\&quot;: \&quot;example.com\&quot;, \&quot;type\&quot;: \&quot;domain\&quot;, \&quot;label\&quot;: \&quot;example.com\&quot;},     {\&quot;id\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;ip\&quot;, \&quot;label\&quot;: \&quot;8.8.8.8\&quot;}   ],   \&quot;links\&quot;: [     {\&quot;source\&quot;: \&quot;example.com\&quot;, \&quot;target\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;resolves_to\&quot;}   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Response Time: 500ms-2s depending on graph complexity&lt;/li&gt;     &lt;li&gt;Default: 100 nodes maximum (adjustable)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Interactive threat actor infrastructure visualization&lt;/li&gt;     &lt;li&gt;Discovering related phishing campaigns&lt;/li&gt;     &lt;li&gt;Mapping shadow IT and sprawl&lt;/li&gt;     &lt;li&gt;Network topology visualization&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found or no relationships discovered.
     * <p><b>400</b> - Invalid indicator type or limit parameter.
     * <p><b>200</b> - Successfully retrieved graph data.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param limit Maximum number of nodes to return in the graph
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIndicatorGraphRequestCreation(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling getIndicatorGraph", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling getIndicatorGraph", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

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
        return apiClient.invokeAPI("/v1/indicators/{type}/{value}/graph", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Infrastructure Relationship Graph
     * &lt;p&gt;Returns graph visualization data showing relationships between the indicator and related infrastructure. Perfect for interactive network diagrams and threat actor infrastructure mapping.&lt;/p&gt; &lt;h4&gt;Relationship Types Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;For Domains:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Resolves to IPs&lt;/li&gt;             &lt;li&gt;Shares nameservers with&lt;/li&gt;             &lt;li&gt;Same SSL certificate as&lt;/li&gt;             &lt;li&gt;Same registrant as&lt;/li&gt;             &lt;li&gt;Links to/from other domains&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt;     &lt;li&gt;&lt;b&gt;For IPs:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Hosts domains&lt;/li&gt;             &lt;li&gt;Same ASN as&lt;/li&gt;             &lt;li&gt;Same network block as&lt;/li&gt;             &lt;li&gt;Connected via routing&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Compatible with react-force-graph, vis.js, cytoscape.js:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;nodes\&quot;: [     {\&quot;id\&quot;: \&quot;example.com\&quot;, \&quot;type\&quot;: \&quot;domain\&quot;, \&quot;label\&quot;: \&quot;example.com\&quot;},     {\&quot;id\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;ip\&quot;, \&quot;label\&quot;: \&quot;8.8.8.8\&quot;}   ],   \&quot;links\&quot;: [     {\&quot;source\&quot;: \&quot;example.com\&quot;, \&quot;target\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;resolves_to\&quot;}   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Response Time: 500ms-2s depending on graph complexity&lt;/li&gt;     &lt;li&gt;Default: 100 nodes maximum (adjustable)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Interactive threat actor infrastructure visualization&lt;/li&gt;     &lt;li&gt;Discovering related phishing campaigns&lt;/li&gt;     &lt;li&gt;Mapping shadow IT and sprawl&lt;/li&gt;     &lt;li&gt;Network topology visualization&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found or no relationships discovered.
     * <p><b>400</b> - Invalid indicator type or limit parameter.
     * <p><b>200</b> - Successfully retrieved graph data.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param limit Maximum number of nodes to return in the graph
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getIndicatorGraph(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getIndicatorGraphRequestCreation(type, value, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Get Infrastructure Relationship Graph
     * &lt;p&gt;Returns graph visualization data showing relationships between the indicator and related infrastructure. Perfect for interactive network diagrams and threat actor infrastructure mapping.&lt;/p&gt; &lt;h4&gt;Relationship Types Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;For Domains:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Resolves to IPs&lt;/li&gt;             &lt;li&gt;Shares nameservers with&lt;/li&gt;             &lt;li&gt;Same SSL certificate as&lt;/li&gt;             &lt;li&gt;Same registrant as&lt;/li&gt;             &lt;li&gt;Links to/from other domains&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt;     &lt;li&gt;&lt;b&gt;For IPs:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Hosts domains&lt;/li&gt;             &lt;li&gt;Same ASN as&lt;/li&gt;             &lt;li&gt;Same network block as&lt;/li&gt;             &lt;li&gt;Connected via routing&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Compatible with react-force-graph, vis.js, cytoscape.js:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;nodes\&quot;: [     {\&quot;id\&quot;: \&quot;example.com\&quot;, \&quot;type\&quot;: \&quot;domain\&quot;, \&quot;label\&quot;: \&quot;example.com\&quot;},     {\&quot;id\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;ip\&quot;, \&quot;label\&quot;: \&quot;8.8.8.8\&quot;}   ],   \&quot;links\&quot;: [     {\&quot;source\&quot;: \&quot;example.com\&quot;, \&quot;target\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;resolves_to\&quot;}   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Response Time: 500ms-2s depending on graph complexity&lt;/li&gt;     &lt;li&gt;Default: 100 nodes maximum (adjustable)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Interactive threat actor infrastructure visualization&lt;/li&gt;     &lt;li&gt;Discovering related phishing campaigns&lt;/li&gt;     &lt;li&gt;Mapping shadow IT and sprawl&lt;/li&gt;     &lt;li&gt;Network topology visualization&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found or no relationships discovered.
     * <p><b>400</b> - Invalid indicator type or limit parameter.
     * <p><b>200</b> - Successfully retrieved graph data.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param limit Maximum number of nodes to return in the graph
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getIndicatorGraphWithHttpInfo(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getIndicatorGraphRequestCreation(type, value, limit).toEntity(localVarReturnType);
    }

    /**
     * Get Infrastructure Relationship Graph
     * &lt;p&gt;Returns graph visualization data showing relationships between the indicator and related infrastructure. Perfect for interactive network diagrams and threat actor infrastructure mapping.&lt;/p&gt; &lt;h4&gt;Relationship Types Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;For Domains:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Resolves to IPs&lt;/li&gt;             &lt;li&gt;Shares nameservers with&lt;/li&gt;             &lt;li&gt;Same SSL certificate as&lt;/li&gt;             &lt;li&gt;Same registrant as&lt;/li&gt;             &lt;li&gt;Links to/from other domains&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt;     &lt;li&gt;&lt;b&gt;For IPs:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Hosts domains&lt;/li&gt;             &lt;li&gt;Same ASN as&lt;/li&gt;             &lt;li&gt;Same network block as&lt;/li&gt;             &lt;li&gt;Connected via routing&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Compatible with react-force-graph, vis.js, cytoscape.js:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;nodes\&quot;: [     {\&quot;id\&quot;: \&quot;example.com\&quot;, \&quot;type\&quot;: \&quot;domain\&quot;, \&quot;label\&quot;: \&quot;example.com\&quot;},     {\&quot;id\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;ip\&quot;, \&quot;label\&quot;: \&quot;8.8.8.8\&quot;}   ],   \&quot;links\&quot;: [     {\&quot;source\&quot;: \&quot;example.com\&quot;, \&quot;target\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;resolves_to\&quot;}   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Response Time: 500ms-2s depending on graph complexity&lt;/li&gt;     &lt;li&gt;Default: 100 nodes maximum (adjustable)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Interactive threat actor infrastructure visualization&lt;/li&gt;     &lt;li&gt;Discovering related phishing campaigns&lt;/li&gt;     &lt;li&gt;Mapping shadow IT and sprawl&lt;/li&gt;     &lt;li&gt;Network topology visualization&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found or no relationships discovered.
     * <p><b>400</b> - Invalid indicator type or limit parameter.
     * <p><b>200</b> - Successfully retrieved graph data.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param limit Maximum number of nodes to return in the graph
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIndicatorGraphWithResponseSpec(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        return getIndicatorGraphRequestCreation(type, value, limit);
    }

    /**
     * Get Historical Data for Indicator
     * &lt;p&gt;Retrieves time-series historical data for an IP address or domain. Track how infrastructure changes over time for threat intelligence and forensic analysis.&lt;/p&gt; &lt;h4&gt;History Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration history - registrant changes, expiration updates, transfers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing history - prefix announcements, ASN changes, route hijacks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS resolution history - IP address changes, nameserver updates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate history - cert replacements, CA changes, expiration events&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reputation:&lt;/b&gt; Risk score history - blacklist appearances, reputation changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Format:&lt;/h4&gt; &lt;p&gt;Timeline with dated snapshots showing what changed and when:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;history\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:00:00Z\&quot;,       \&quot;field\&quot;: \&quot;registrant_company\&quot;,       \&quot;old_value\&quot;: \&quot;Evil Corp\&quot;,       \&quot;new_value\&quot;: \&quot;Legitimate LLC\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Tracking domain ownership changes&lt;/li&gt;     &lt;li&gt;Investigating IP reputation degradation&lt;/li&gt;     &lt;li&gt;Forensic timeline reconstruction&lt;/li&gt;     &lt;li&gt;Detecting infrastructure pivots by threat actors&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid indicator type or history type.
     * <p><b>200</b> - Successfully retrieved historical data.
     * <p><b>404</b> - No historical data found for this indicator.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param historyType Type of historical data to retrieve
     * @return HistoryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIndicatorHistoryRequestCreation(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable String historyType) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling getIndicatorHistory", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling getIndicatorHistory", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "historyType", historyType));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<HistoryResponse> localVarReturnType = new ParameterizedTypeReference<HistoryResponse>() {};
        return apiClient.invokeAPI("/v1/indicators/{type}/{value}/history", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Historical Data for Indicator
     * &lt;p&gt;Retrieves time-series historical data for an IP address or domain. Track how infrastructure changes over time for threat intelligence and forensic analysis.&lt;/p&gt; &lt;h4&gt;History Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration history - registrant changes, expiration updates, transfers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing history - prefix announcements, ASN changes, route hijacks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS resolution history - IP address changes, nameserver updates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate history - cert replacements, CA changes, expiration events&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reputation:&lt;/b&gt; Risk score history - blacklist appearances, reputation changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Format:&lt;/h4&gt; &lt;p&gt;Timeline with dated snapshots showing what changed and when:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;history\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:00:00Z\&quot;,       \&quot;field\&quot;: \&quot;registrant_company\&quot;,       \&quot;old_value\&quot;: \&quot;Evil Corp\&quot;,       \&quot;new_value\&quot;: \&quot;Legitimate LLC\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Tracking domain ownership changes&lt;/li&gt;     &lt;li&gt;Investigating IP reputation degradation&lt;/li&gt;     &lt;li&gt;Forensic timeline reconstruction&lt;/li&gt;     &lt;li&gt;Detecting infrastructure pivots by threat actors&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid indicator type or history type.
     * <p><b>200</b> - Successfully retrieved historical data.
     * <p><b>404</b> - No historical data found for this indicator.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param historyType Type of historical data to retrieve
     * @return HistoryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<HistoryResponse> getIndicatorHistory(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable String historyType) throws WebClientResponseException {
        ParameterizedTypeReference<HistoryResponse> localVarReturnType = new ParameterizedTypeReference<HistoryResponse>() {};
        return getIndicatorHistoryRequestCreation(type, value, historyType).bodyToMono(localVarReturnType);
    }

    /**
     * Get Historical Data for Indicator
     * &lt;p&gt;Retrieves time-series historical data for an IP address or domain. Track how infrastructure changes over time for threat intelligence and forensic analysis.&lt;/p&gt; &lt;h4&gt;History Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration history - registrant changes, expiration updates, transfers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing history - prefix announcements, ASN changes, route hijacks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS resolution history - IP address changes, nameserver updates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate history - cert replacements, CA changes, expiration events&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reputation:&lt;/b&gt; Risk score history - blacklist appearances, reputation changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Format:&lt;/h4&gt; &lt;p&gt;Timeline with dated snapshots showing what changed and when:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;history\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:00:00Z\&quot;,       \&quot;field\&quot;: \&quot;registrant_company\&quot;,       \&quot;old_value\&quot;: \&quot;Evil Corp\&quot;,       \&quot;new_value\&quot;: \&quot;Legitimate LLC\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Tracking domain ownership changes&lt;/li&gt;     &lt;li&gt;Investigating IP reputation degradation&lt;/li&gt;     &lt;li&gt;Forensic timeline reconstruction&lt;/li&gt;     &lt;li&gt;Detecting infrastructure pivots by threat actors&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid indicator type or history type.
     * <p><b>200</b> - Successfully retrieved historical data.
     * <p><b>404</b> - No historical data found for this indicator.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param historyType Type of historical data to retrieve
     * @return ResponseEntity&lt;HistoryResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<HistoryResponse>> getIndicatorHistoryWithHttpInfo(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable String historyType) throws WebClientResponseException {
        ParameterizedTypeReference<HistoryResponse> localVarReturnType = new ParameterizedTypeReference<HistoryResponse>() {};
        return getIndicatorHistoryRequestCreation(type, value, historyType).toEntity(localVarReturnType);
    }

    /**
     * Get Historical Data for Indicator
     * &lt;p&gt;Retrieves time-series historical data for an IP address or domain. Track how infrastructure changes over time for threat intelligence and forensic analysis.&lt;/p&gt; &lt;h4&gt;History Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration history - registrant changes, expiration updates, transfers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing history - prefix announcements, ASN changes, route hijacks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS resolution history - IP address changes, nameserver updates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate history - cert replacements, CA changes, expiration events&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reputation:&lt;/b&gt; Risk score history - blacklist appearances, reputation changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Format:&lt;/h4&gt; &lt;p&gt;Timeline with dated snapshots showing what changed and when:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;history\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:00:00Z\&quot;,       \&quot;field\&quot;: \&quot;registrant_company\&quot;,       \&quot;old_value\&quot;: \&quot;Evil Corp\&quot;,       \&quot;new_value\&quot;: \&quot;Legitimate LLC\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Tracking domain ownership changes&lt;/li&gt;     &lt;li&gt;Investigating IP reputation degradation&lt;/li&gt;     &lt;li&gt;Forensic timeline reconstruction&lt;/li&gt;     &lt;li&gt;Detecting infrastructure pivots by threat actors&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid indicator type or history type.
     * <p><b>200</b> - Successfully retrieved historical data.
     * <p><b>404</b> - No historical data found for this indicator.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param historyType Type of historical data to retrieve
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIndicatorHistoryWithResponseSpec(@javax.annotation.Nonnull String type, @javax.annotation.Nonnull String value, @javax.annotation.Nullable String historyType) throws WebClientResponseException {
        return getIndicatorHistoryRequestCreation(type, value, historyType);
    }

    /**
     * Get Domain Subdomains
     * Retrieves a list of discovered subdomains for a given root domain, based on passive DNS and other enumeration techniques.
     * <p><b>400</b> - Invalid domain format.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Domain not found or no subdomains discovered.
     * <p><b>200</b> - Successfully retrieved subdomains.
     * @param domain The root domain to query for subdomains.
     * @param limit The maximum number of subdomains to return.
     * @return SubdomainResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSubdomainsRequestCreation(@javax.annotation.Nonnull String domain, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'domain' is set
        if (domain == null) {
            throw new WebClientResponseException("Missing the required parameter 'domain' when calling getSubdomains", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("domain", domain);

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

        ParameterizedTypeReference<SubdomainResponse> localVarReturnType = new ParameterizedTypeReference<SubdomainResponse>() {};
        return apiClient.invokeAPI("/v1/indicators/domain/{domain}/subdomains", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Domain Subdomains
     * Retrieves a list of discovered subdomains for a given root domain, based on passive DNS and other enumeration techniques.
     * <p><b>400</b> - Invalid domain format.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Domain not found or no subdomains discovered.
     * <p><b>200</b> - Successfully retrieved subdomains.
     * @param domain The root domain to query for subdomains.
     * @param limit The maximum number of subdomains to return.
     * @return SubdomainResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubdomainResponse> getSubdomains(@javax.annotation.Nonnull String domain, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<SubdomainResponse> localVarReturnType = new ParameterizedTypeReference<SubdomainResponse>() {};
        return getSubdomainsRequestCreation(domain, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Get Domain Subdomains
     * Retrieves a list of discovered subdomains for a given root domain, based on passive DNS and other enumeration techniques.
     * <p><b>400</b> - Invalid domain format.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Domain not found or no subdomains discovered.
     * <p><b>200</b> - Successfully retrieved subdomains.
     * @param domain The root domain to query for subdomains.
     * @param limit The maximum number of subdomains to return.
     * @return ResponseEntity&lt;SubdomainResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<SubdomainResponse>> getSubdomainsWithHttpInfo(@javax.annotation.Nonnull String domain, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<SubdomainResponse> localVarReturnType = new ParameterizedTypeReference<SubdomainResponse>() {};
        return getSubdomainsRequestCreation(domain, limit).toEntity(localVarReturnType);
    }

    /**
     * Get Domain Subdomains
     * Retrieves a list of discovered subdomains for a given root domain, based on passive DNS and other enumeration techniques.
     * <p><b>400</b> - Invalid domain format.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Domain not found or no subdomains discovered.
     * <p><b>200</b> - Successfully retrieved subdomains.
     * @param domain The root domain to query for subdomains.
     * @param limit The maximum number of subdomains to return.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getSubdomainsWithResponseSpec(@javax.annotation.Nonnull String domain, @javax.annotation.Nullable Integer limit) throws WebClientResponseException {
        return getSubdomainsRequestCreation(domain, limit);
    }

    /**
     * Search Indicators (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to search for indicators matching specific criteria. This endpoint is extremely powerful for infrastructure discovery and threat hunting.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; Searches on WHOIS fields (like &#x60;registrantCompany&#x60;) are data-intensive and can take over 50 seconds to complete. This endpoint is therefore asynchronous by design. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve results.&lt;/p&gt; &lt;h4&gt;Example Search Queries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&#x60;registrantCompany:EvilCorp&#x60; - Find all domains registered by EvilCorp&lt;/li&gt;     &lt;li&gt;&#x60;asn:15169&#x60; - Find all IPs in Google&#39;s ASN&lt;/li&gt;     &lt;li&gt;&#x60;city:\&quot;San Francisco\&quot;&#x60; - Find all IPs geolocated to San Francisco&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid search query or parameters.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>202</b> - Search job successfully accepted.
     * @param searchRequest The search query and configuration.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec searchIndicatorsRequestCreation(@javax.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
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
        return apiClient.invokeAPI("/v1/indicators/search", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Search Indicators (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to search for indicators matching specific criteria. This endpoint is extremely powerful for infrastructure discovery and threat hunting.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; Searches on WHOIS fields (like &#x60;registrantCompany&#x60;) are data-intensive and can take over 50 seconds to complete. This endpoint is therefore asynchronous by design. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve results.&lt;/p&gt; &lt;h4&gt;Example Search Queries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&#x60;registrantCompany:EvilCorp&#x60; - Find all domains registered by EvilCorp&lt;/li&gt;     &lt;li&gt;&#x60;asn:15169&#x60; - Find all IPs in Google&#39;s ASN&lt;/li&gt;     &lt;li&gt;&#x60;city:\&quot;San Francisco\&quot;&#x60; - Find all IPs geolocated to San Francisco&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid search query or parameters.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>202</b> - Search job successfully accepted.
     * @param searchRequest The search query and configuration.
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> searchIndicators(@javax.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return searchIndicatorsRequestCreation(searchRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Search Indicators (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to search for indicators matching specific criteria. This endpoint is extremely powerful for infrastructure discovery and threat hunting.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; Searches on WHOIS fields (like &#x60;registrantCompany&#x60;) are data-intensive and can take over 50 seconds to complete. This endpoint is therefore asynchronous by design. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve results.&lt;/p&gt; &lt;h4&gt;Example Search Queries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&#x60;registrantCompany:EvilCorp&#x60; - Find all domains registered by EvilCorp&lt;/li&gt;     &lt;li&gt;&#x60;asn:15169&#x60; - Find all IPs in Google&#39;s ASN&lt;/li&gt;     &lt;li&gt;&#x60;city:\&quot;San Francisco\&quot;&#x60; - Find all IPs geolocated to San Francisco&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid search query or parameters.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>202</b> - Search job successfully accepted.
     * @param searchRequest The search query and configuration.
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> searchIndicatorsWithHttpInfo(@javax.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return searchIndicatorsRequestCreation(searchRequest).toEntity(localVarReturnType);
    }

    /**
     * Search Indicators (Asynchronous)
     * &lt;p&gt;Initiates an asynchronous job to search for indicators matching specific criteria. This endpoint is extremely powerful for infrastructure discovery and threat hunting.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; Searches on WHOIS fields (like &#x60;registrantCompany&#x60;) are data-intensive and can take over 50 seconds to complete. This endpoint is therefore asynchronous by design. Poll the &#x60;/v1/ops/jobs/{jobId}&#x60; endpoint to retrieve results.&lt;/p&gt; &lt;h4&gt;Example Search Queries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&#x60;registrantCompany:EvilCorp&#x60; - Find all domains registered by EvilCorp&lt;/li&gt;     &lt;li&gt;&#x60;asn:15169&#x60; - Find all IPs in Google&#39;s ASN&lt;/li&gt;     &lt;li&gt;&#x60;city:\&quot;San Francisco\&quot;&#x60; - Find all IPs geolocated to San Francisco&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>400</b> - Invalid search query or parameters.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * <p><b>202</b> - Search job successfully accepted.
     * @param searchRequest The search query and configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec searchIndicatorsWithResponseSpec(@javax.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        return searchIndicatorsRequestCreation(searchRequest);
    }
}
