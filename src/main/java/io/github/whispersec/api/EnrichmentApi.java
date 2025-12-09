package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.BulkEnrichmentResult;
import io.github.whispersec.model.BulkRequest;
import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.GraphResponse;
import io.github.whispersec.model.HistoryResponse;
import io.github.whispersec.model.IndicatorResponse;
import io.github.whispersec.model.JobResponse;
import io.github.whispersec.model.PredictiveRiskResponse;
import io.github.whispersec.model.SearchRequest;
import io.github.whispersec.model.SearchResponse;
import io.github.whispersec.model.SimilarDomainsOpsRequest;
import io.github.whispersec.model.SimilarDomainsResponse;
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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-09T22:14:53.714678089Z[Etc/UTC]", comments = "Generator version: 7.17.0")
public class EnrichmentApi {
    private ApiClient apiClient;

    public EnrichmentApi() {
        this(new ApiClient());
    }

    public EnrichmentApi(ApiClient apiClient) {
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
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt;  &lt;h4&gt;Performance&lt;/h4&gt; &lt;p&gt;Processing time depends on batch size and indicator types. IP enrichment is faster than domain enrichment.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPs only:&lt;/b&gt; 2-10 seconds for typical batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Domains only:&lt;/b&gt; 10-30 seconds (WHOIS lookups are slower)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Mixed:&lt;/b&gt; 5-30 seconds depending on ratio&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Rate Limits&lt;/h4&gt; &lt;p&gt;Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt;  &lt;h4&gt;Response Structure&lt;/h4&gt; &lt;p&gt;When the job completes, the &lt;code&gt;result&lt;/code&gt; field contains:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;status&lt;/code&gt;: \&quot;completed\&quot; or \&quot;failed\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of enriched indicator objects (see below)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;errors&lt;/code&gt;: Array of failed enrichments with error details&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalProcessed&lt;/code&gt;: Number of indicators processed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalFailed&lt;/code&gt;: Number of failed enrichments&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalIndicators&lt;/code&gt;: Total indicators in request&lt;/li&gt;     &lt;li&gt;&lt;code&gt;successRate&lt;/code&gt;: Percentage of successful enrichments (0-100)&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Result Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;results&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The original indicator value&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;query&lt;/code&gt;: Request metadata (type, value, timestamp, response_time_ms)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;summary&lt;/code&gt;: Key information summary&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For IP indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;geolocation&lt;/code&gt;: Country, city, coordinates, ISP, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;network&lt;/code&gt;: BGP routing data, prefix visibility, origins&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: ISP name, organization, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Risk score, blacklist scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, shared infrastructure&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For domain indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;registration&lt;/code&gt;: WHOIS data (registrar, dates, nameservers, status)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;dns&lt;/code&gt;: DNS records (A, AAAA, MX, NS, TXT, CNAME)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Domain reputation, infrastructure scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, incoming/outgoing links&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Error Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;errors&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The indicator that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: true&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Bulk job successfully accepted for processing. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes). See endpoint description for detailed result structure.
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkRequest List of indicators and processing options.
     * @return BulkEnrichmentResult
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

        ParameterizedTypeReference<BulkEnrichmentResult> localVarReturnType = new ParameterizedTypeReference<BulkEnrichmentResult>() {};
        return apiClient.invokeAPI("/v1/ops/enrichment/bulk", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt;  &lt;h4&gt;Performance&lt;/h4&gt; &lt;p&gt;Processing time depends on batch size and indicator types. IP enrichment is faster than domain enrichment.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPs only:&lt;/b&gt; 2-10 seconds for typical batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Domains only:&lt;/b&gt; 10-30 seconds (WHOIS lookups are slower)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Mixed:&lt;/b&gt; 5-30 seconds depending on ratio&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Rate Limits&lt;/h4&gt; &lt;p&gt;Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt;  &lt;h4&gt;Response Structure&lt;/h4&gt; &lt;p&gt;When the job completes, the &lt;code&gt;result&lt;/code&gt; field contains:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;status&lt;/code&gt;: \&quot;completed\&quot; or \&quot;failed\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of enriched indicator objects (see below)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;errors&lt;/code&gt;: Array of failed enrichments with error details&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalProcessed&lt;/code&gt;: Number of indicators processed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalFailed&lt;/code&gt;: Number of failed enrichments&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalIndicators&lt;/code&gt;: Total indicators in request&lt;/li&gt;     &lt;li&gt;&lt;code&gt;successRate&lt;/code&gt;: Percentage of successful enrichments (0-100)&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Result Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;results&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The original indicator value&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;query&lt;/code&gt;: Request metadata (type, value, timestamp, response_time_ms)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;summary&lt;/code&gt;: Key information summary&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For IP indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;geolocation&lt;/code&gt;: Country, city, coordinates, ISP, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;network&lt;/code&gt;: BGP routing data, prefix visibility, origins&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: ISP name, organization, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Risk score, blacklist scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, shared infrastructure&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For domain indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;registration&lt;/code&gt;: WHOIS data (registrar, dates, nameservers, status)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;dns&lt;/code&gt;: DNS records (A, AAAA, MX, NS, TXT, CNAME)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Domain reputation, infrastructure scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, incoming/outgoing links&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Error Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;errors&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The indicator that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: true&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Bulk job successfully accepted for processing. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes). See endpoint description for detailed result structure.
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkRequest List of indicators and processing options.
     * @return BulkEnrichmentResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<BulkEnrichmentResult> bulkEnrichment(@jakarta.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        ParameterizedTypeReference<BulkEnrichmentResult> localVarReturnType = new ParameterizedTypeReference<BulkEnrichmentResult>() {};
        return bulkEnrichmentRequestCreation(bulkRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt;  &lt;h4&gt;Performance&lt;/h4&gt; &lt;p&gt;Processing time depends on batch size and indicator types. IP enrichment is faster than domain enrichment.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPs only:&lt;/b&gt; 2-10 seconds for typical batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Domains only:&lt;/b&gt; 10-30 seconds (WHOIS lookups are slower)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Mixed:&lt;/b&gt; 5-30 seconds depending on ratio&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Rate Limits&lt;/h4&gt; &lt;p&gt;Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt;  &lt;h4&gt;Response Structure&lt;/h4&gt; &lt;p&gt;When the job completes, the &lt;code&gt;result&lt;/code&gt; field contains:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;status&lt;/code&gt;: \&quot;completed\&quot; or \&quot;failed\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of enriched indicator objects (see below)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;errors&lt;/code&gt;: Array of failed enrichments with error details&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalProcessed&lt;/code&gt;: Number of indicators processed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalFailed&lt;/code&gt;: Number of failed enrichments&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalIndicators&lt;/code&gt;: Total indicators in request&lt;/li&gt;     &lt;li&gt;&lt;code&gt;successRate&lt;/code&gt;: Percentage of successful enrichments (0-100)&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Result Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;results&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The original indicator value&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;query&lt;/code&gt;: Request metadata (type, value, timestamp, response_time_ms)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;summary&lt;/code&gt;: Key information summary&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For IP indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;geolocation&lt;/code&gt;: Country, city, coordinates, ISP, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;network&lt;/code&gt;: BGP routing data, prefix visibility, origins&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: ISP name, organization, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Risk score, blacklist scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, shared infrastructure&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For domain indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;registration&lt;/code&gt;: WHOIS data (registrar, dates, nameservers, status)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;dns&lt;/code&gt;: DNS records (A, AAAA, MX, NS, TXT, CNAME)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Domain reputation, infrastructure scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, incoming/outgoing links&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Error Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;errors&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The indicator that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: true&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Bulk job successfully accepted for processing. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes). See endpoint description for detailed result structure.
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkRequest List of indicators and processing options.
     * @return ResponseEntity&lt;BulkEnrichmentResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<BulkEnrichmentResult>> bulkEnrichmentWithHttpInfo(@jakarta.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        ParameterizedTypeReference<BulkEnrichmentResult> localVarReturnType = new ParameterizedTypeReference<BulkEnrichmentResult>() {};
        return bulkEnrichmentRequestCreation(bulkRequest).toEntity(localVarReturnType);
    }

    /**
     * Bulk Indicator Enrichment (Asynchronous)
     * &lt;p&gt;Process multiple indicators (IPs and/or domains) in a single request. This endpoint is optimized for batch processing and can handle up to 100 indicators per request.&lt;/p&gt;  &lt;h4&gt;Performance&lt;/h4&gt; &lt;p&gt;Processing time depends on batch size and indicator types. IP enrichment is faster than domain enrichment.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;IPs only:&lt;/b&gt; 2-10 seconds for typical batches&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Domains only:&lt;/b&gt; 10-30 seconds (WHOIS lookups are slower)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Mixed:&lt;/b&gt; 5-30 seconds depending on ratio&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Rate Limits&lt;/h4&gt; &lt;p&gt;Limited to 10 requests per minute due to the resource-intensive nature of bulk operations.&lt;/p&gt;  &lt;h4&gt;Response Structure&lt;/h4&gt; &lt;p&gt;When the job completes, the &lt;code&gt;result&lt;/code&gt; field contains:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;status&lt;/code&gt;: \&quot;completed\&quot; or \&quot;failed\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;results&lt;/code&gt;: Array of enriched indicator objects (see below)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;errors&lt;/code&gt;: Array of failed enrichments with error details&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalProcessed&lt;/code&gt;: Number of indicators processed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalFailed&lt;/code&gt;: Number of failed enrichments&lt;/li&gt;     &lt;li&gt;&lt;code&gt;totalIndicators&lt;/code&gt;: Total indicators in request&lt;/li&gt;     &lt;li&gt;&lt;code&gt;successRate&lt;/code&gt;: Percentage of successful enrichments (0-100)&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Result Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;results&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The original indicator value&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;query&lt;/code&gt;: Request metadata (type, value, timestamp, response_time_ms)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;summary&lt;/code&gt;: Key information summary&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For IP indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;geolocation&lt;/code&gt;: Country, city, coordinates, ISP, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;network&lt;/code&gt;: BGP routing data, prefix visibility, origins&lt;/li&gt;     &lt;li&gt;&lt;code&gt;isp&lt;/code&gt;: ISP name, organization, ASN&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Risk score, blacklist scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, shared infrastructure&lt;/li&gt; &lt;/ul&gt;  &lt;p&gt;&lt;b&gt;For domain indicators:&lt;/b&gt;&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;registration&lt;/code&gt;: WHOIS data (registrar, dates, nameservers, status)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;dns&lt;/code&gt;: DNS records (A, AAAA, MX, NS, TXT, CNAME)&lt;/li&gt;     &lt;li&gt;&lt;code&gt;reputation&lt;/code&gt;: Domain reputation, infrastructure scores&lt;/li&gt;     &lt;li&gt;&lt;code&gt;relationships&lt;/code&gt;: Related domains, incoming/outgoing links&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Error Item Structure&lt;/h4&gt; &lt;p&gt;Each item in the &lt;code&gt;errors&lt;/code&gt; array includes:&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;code&gt;indicator&lt;/code&gt;: The indicator that failed&lt;/li&gt;     &lt;li&gt;&lt;code&gt;type&lt;/code&gt;: \&quot;ip\&quot; or \&quot;domain\&quot;&lt;/li&gt;     &lt;li&gt;&lt;code&gt;error&lt;/code&gt;: true&lt;/li&gt;     &lt;li&gt;&lt;code&gt;message&lt;/code&gt;: Error description&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Bulk job successfully accepted for processing. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes). See endpoint description for detailed result structure.
     * <p><b>400</b> - Invalid request. Empty indicator list or exceeds 100 indicator limit.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for bulk operations.
     * @param bulkRequest List of indicators and processing options.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec bulkEnrichmentWithResponseSpec(@jakarta.annotation.Nonnull BulkRequest bulkRequest) throws WebClientResponseException {
        return bulkEnrichmentRequestCreation(bulkRequest);
    }

    /**
     * Enrich a Single Indicator (IP or Domain)
     * &lt;p&gt;Retrieves comprehensive intelligence for a single IP address or domain. This is the primary, high-performance endpoint for synchronous enrichment.&lt;/p&gt; &lt;p&gt;It aggregates data from multiple sources, including geolocation, WHOIS, DNS, reputation scoring, and relationship mapping. Use the &#x60;include&#x60; parameter to request additional, deeper data sets that may have higher latency.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Base Response:&lt;/b&gt; Typically under 500ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;routing&#x60;:&lt;/b&gt; First request may take up to 5 seconds; subsequent requests are cached for 5 minutes and respond in &amp;lt;200ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;ip_intelligence&#x60;:&lt;/b&gt; Adds 200-500ms of latency for each IP address resolved from the domain.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved intelligence data.
     * <p><b>400</b> - Invalid indicator format or unsupported type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - The requested indicator was not found in our datasets.
     * <p><b>429</b> - Rate limit exceeded.
     * @param type The type of indicator to enrich.
     * @param value The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
     * @param include A comma-separated list of additional data modules to include in the response. Note: WHOIS and DNS data are included by default for domains. Requesting more modules may increase latency.
     * @return IndicatorResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIndicatorRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String include) throws WebClientResponseException {
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
     * <p><b>200</b> - Successfully retrieved intelligence data.
     * <p><b>400</b> - Invalid indicator format or unsupported type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - The requested indicator was not found in our datasets.
     * <p><b>429</b> - Rate limit exceeded.
     * @param type The type of indicator to enrich.
     * @param value The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
     * @param include A comma-separated list of additional data modules to include in the response. Note: WHOIS and DNS data are included by default for domains. Requesting more modules may increase latency.
     * @return IndicatorResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<IndicatorResponse> getIndicator(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String include) throws WebClientResponseException {
        ParameterizedTypeReference<IndicatorResponse> localVarReturnType = new ParameterizedTypeReference<IndicatorResponse>() {};
        return getIndicatorRequestCreation(type, value, include).bodyToMono(localVarReturnType);
    }

    /**
     * Enrich a Single Indicator (IP or Domain)
     * &lt;p&gt;Retrieves comprehensive intelligence for a single IP address or domain. This is the primary, high-performance endpoint for synchronous enrichment.&lt;/p&gt; &lt;p&gt;It aggregates data from multiple sources, including geolocation, WHOIS, DNS, reputation scoring, and relationship mapping. Use the &#x60;include&#x60; parameter to request additional, deeper data sets that may have higher latency.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Base Response:&lt;/b&gt; Typically under 500ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;routing&#x60;:&lt;/b&gt; First request may take up to 5 seconds; subsequent requests are cached for 5 minutes and respond in &amp;lt;200ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;ip_intelligence&#x60;:&lt;/b&gt; Adds 200-500ms of latency for each IP address resolved from the domain.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved intelligence data.
     * <p><b>400</b> - Invalid indicator format or unsupported type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - The requested indicator was not found in our datasets.
     * <p><b>429</b> - Rate limit exceeded.
     * @param type The type of indicator to enrich.
     * @param value The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
     * @param include A comma-separated list of additional data modules to include in the response. Note: WHOIS and DNS data are included by default for domains. Requesting more modules may increase latency.
     * @return ResponseEntity&lt;IndicatorResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<IndicatorResponse>> getIndicatorWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String include) throws WebClientResponseException {
        ParameterizedTypeReference<IndicatorResponse> localVarReturnType = new ParameterizedTypeReference<IndicatorResponse>() {};
        return getIndicatorRequestCreation(type, value, include).toEntity(localVarReturnType);
    }

    /**
     * Enrich a Single Indicator (IP or Domain)
     * &lt;p&gt;Retrieves comprehensive intelligence for a single IP address or domain. This is the primary, high-performance endpoint for synchronous enrichment.&lt;/p&gt; &lt;p&gt;It aggregates data from multiple sources, including geolocation, WHOIS, DNS, reputation scoring, and relationship mapping. Use the &#x60;include&#x60; parameter to request additional, deeper data sets that may have higher latency.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Base Response:&lt;/b&gt; Typically under 500ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;routing&#x60;:&lt;/b&gt; First request may take up to 5 seconds; subsequent requests are cached for 5 minutes and respond in &amp;lt;200ms.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;With &#x60;include&#x3D;ip_intelligence&#x60;:&lt;/b&gt; Adds 200-500ms of latency for each IP address resolved from the domain.&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved intelligence data.
     * <p><b>400</b> - Invalid indicator format or unsupported type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - The requested indicator was not found in our datasets.
     * <p><b>429</b> - Rate limit exceeded.
     * @param type The type of indicator to enrich.
     * @param value The value of the indicator (e.g., an IPv4/IPv6 address or a domain name).
     * @param include A comma-separated list of additional data modules to include in the response. Note: WHOIS and DNS data are included by default for domains. Requesting more modules may increase latency.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIndicatorWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String include) throws WebClientResponseException {
        return getIndicatorRequestCreation(type, value, include);
    }

    /**
     * Get Infrastructure Relationship Graph
     * &lt;p&gt;Returns graph visualization data showing relationships between the indicator and related infrastructure. Perfect for interactive network diagrams and threat actor infrastructure mapping.&lt;/p&gt; &lt;h4&gt;Relationship Types Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;For Domains:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Resolves to IPs&lt;/li&gt;             &lt;li&gt;Shares nameservers with&lt;/li&gt;             &lt;li&gt;Same SSL certificate as&lt;/li&gt;             &lt;li&gt;Same registrant as&lt;/li&gt;             &lt;li&gt;Links to/from other domains&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt;     &lt;li&gt;&lt;b&gt;For IPs:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Hosts domains&lt;/li&gt;             &lt;li&gt;Same ASN as&lt;/li&gt;             &lt;li&gt;Same network block as&lt;/li&gt;             &lt;li&gt;Connected via routing&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Compatible with react-force-graph, vis.js, cytoscape.js:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;nodes\&quot;: [     {\&quot;id\&quot;: \&quot;example.com\&quot;, \&quot;type\&quot;: \&quot;domain\&quot;, \&quot;label\&quot;: \&quot;example.com\&quot;},     {\&quot;id\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;ip\&quot;, \&quot;label\&quot;: \&quot;8.8.8.8\&quot;}   ],   \&quot;links\&quot;: [     {\&quot;source\&quot;: \&quot;example.com\&quot;, \&quot;target\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;resolves_to\&quot;}   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Response Time: 500ms-2s depending on graph complexity&lt;/li&gt;     &lt;li&gt;Default: 100 nodes maximum (adjustable)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Interactive threat actor infrastructure visualization&lt;/li&gt;     &lt;li&gt;Discovering related phishing campaigns&lt;/li&gt;     &lt;li&gt;Mapping shadow IT and sprawl&lt;/li&gt;     &lt;li&gt;Network topology visualization&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved graph data. Compatible with react-force-graph, vis.js, and cytoscape.js.
     * <p><b>400</b> - Invalid indicator type or limit parameter. Type must be &#39;ip&#39; or &#39;domain&#39;, limit must be 1-500.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found or no relationships discovered.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param limit Maximum number of nodes to return in the graph
     * @return GraphResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIndicatorGraphRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
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

        ParameterizedTypeReference<GraphResponse> localVarReturnType = new ParameterizedTypeReference<GraphResponse>() {};
        return apiClient.invokeAPI("/v1/indicators/{type}/{value}/graph", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Infrastructure Relationship Graph
     * &lt;p&gt;Returns graph visualization data showing relationships between the indicator and related infrastructure. Perfect for interactive network diagrams and threat actor infrastructure mapping.&lt;/p&gt; &lt;h4&gt;Relationship Types Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;For Domains:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Resolves to IPs&lt;/li&gt;             &lt;li&gt;Shares nameservers with&lt;/li&gt;             &lt;li&gt;Same SSL certificate as&lt;/li&gt;             &lt;li&gt;Same registrant as&lt;/li&gt;             &lt;li&gt;Links to/from other domains&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt;     &lt;li&gt;&lt;b&gt;For IPs:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Hosts domains&lt;/li&gt;             &lt;li&gt;Same ASN as&lt;/li&gt;             &lt;li&gt;Same network block as&lt;/li&gt;             &lt;li&gt;Connected via routing&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Compatible with react-force-graph, vis.js, cytoscape.js:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;nodes\&quot;: [     {\&quot;id\&quot;: \&quot;example.com\&quot;, \&quot;type\&quot;: \&quot;domain\&quot;, \&quot;label\&quot;: \&quot;example.com\&quot;},     {\&quot;id\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;ip\&quot;, \&quot;label\&quot;: \&quot;8.8.8.8\&quot;}   ],   \&quot;links\&quot;: [     {\&quot;source\&quot;: \&quot;example.com\&quot;, \&quot;target\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;resolves_to\&quot;}   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Response Time: 500ms-2s depending on graph complexity&lt;/li&gt;     &lt;li&gt;Default: 100 nodes maximum (adjustable)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Interactive threat actor infrastructure visualization&lt;/li&gt;     &lt;li&gt;Discovering related phishing campaigns&lt;/li&gt;     &lt;li&gt;Mapping shadow IT and sprawl&lt;/li&gt;     &lt;li&gt;Network topology visualization&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved graph data. Compatible with react-force-graph, vis.js, and cytoscape.js.
     * <p><b>400</b> - Invalid indicator type or limit parameter. Type must be &#39;ip&#39; or &#39;domain&#39;, limit must be 1-500.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found or no relationships discovered.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param limit Maximum number of nodes to return in the graph
     * @return GraphResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GraphResponse> getIndicatorGraph(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<GraphResponse> localVarReturnType = new ParameterizedTypeReference<GraphResponse>() {};
        return getIndicatorGraphRequestCreation(type, value, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Get Infrastructure Relationship Graph
     * &lt;p&gt;Returns graph visualization data showing relationships between the indicator and related infrastructure. Perfect for interactive network diagrams and threat actor infrastructure mapping.&lt;/p&gt; &lt;h4&gt;Relationship Types Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;For Domains:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Resolves to IPs&lt;/li&gt;             &lt;li&gt;Shares nameservers with&lt;/li&gt;             &lt;li&gt;Same SSL certificate as&lt;/li&gt;             &lt;li&gt;Same registrant as&lt;/li&gt;             &lt;li&gt;Links to/from other domains&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt;     &lt;li&gt;&lt;b&gt;For IPs:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Hosts domains&lt;/li&gt;             &lt;li&gt;Same ASN as&lt;/li&gt;             &lt;li&gt;Same network block as&lt;/li&gt;             &lt;li&gt;Connected via routing&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Compatible with react-force-graph, vis.js, cytoscape.js:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;nodes\&quot;: [     {\&quot;id\&quot;: \&quot;example.com\&quot;, \&quot;type\&quot;: \&quot;domain\&quot;, \&quot;label\&quot;: \&quot;example.com\&quot;},     {\&quot;id\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;ip\&quot;, \&quot;label\&quot;: \&quot;8.8.8.8\&quot;}   ],   \&quot;links\&quot;: [     {\&quot;source\&quot;: \&quot;example.com\&quot;, \&quot;target\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;resolves_to\&quot;}   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Response Time: 500ms-2s depending on graph complexity&lt;/li&gt;     &lt;li&gt;Default: 100 nodes maximum (adjustable)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Interactive threat actor infrastructure visualization&lt;/li&gt;     &lt;li&gt;Discovering related phishing campaigns&lt;/li&gt;     &lt;li&gt;Mapping shadow IT and sprawl&lt;/li&gt;     &lt;li&gt;Network topology visualization&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved graph data. Compatible with react-force-graph, vis.js, and cytoscape.js.
     * <p><b>400</b> - Invalid indicator type or limit parameter. Type must be &#39;ip&#39; or &#39;domain&#39;, limit must be 1-500.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found or no relationships discovered.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param limit Maximum number of nodes to return in the graph
     * @return ResponseEntity&lt;GraphResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GraphResponse>> getIndicatorGraphWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<GraphResponse> localVarReturnType = new ParameterizedTypeReference<GraphResponse>() {};
        return getIndicatorGraphRequestCreation(type, value, limit).toEntity(localVarReturnType);
    }

    /**
     * Get Infrastructure Relationship Graph
     * &lt;p&gt;Returns graph visualization data showing relationships between the indicator and related infrastructure. Perfect for interactive network diagrams and threat actor infrastructure mapping.&lt;/p&gt; &lt;h4&gt;Relationship Types Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;For Domains:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Resolves to IPs&lt;/li&gt;             &lt;li&gt;Shares nameservers with&lt;/li&gt;             &lt;li&gt;Same SSL certificate as&lt;/li&gt;             &lt;li&gt;Same registrant as&lt;/li&gt;             &lt;li&gt;Links to/from other domains&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt;     &lt;li&gt;&lt;b&gt;For IPs:&lt;/b&gt;         &lt;ul&gt;             &lt;li&gt;Hosts domains&lt;/li&gt;             &lt;li&gt;Same ASN as&lt;/li&gt;             &lt;li&gt;Same network block as&lt;/li&gt;             &lt;li&gt;Connected via routing&lt;/li&gt;         &lt;/ul&gt;     &lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Output Format:&lt;/h4&gt; &lt;p&gt;Compatible with react-force-graph, vis.js, cytoscape.js:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;nodes\&quot;: [     {\&quot;id\&quot;: \&quot;example.com\&quot;, \&quot;type\&quot;: \&quot;domain\&quot;, \&quot;label\&quot;: \&quot;example.com\&quot;},     {\&quot;id\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;ip\&quot;, \&quot;label\&quot;: \&quot;8.8.8.8\&quot;}   ],   \&quot;links\&quot;: [     {\&quot;source\&quot;: \&quot;example.com\&quot;, \&quot;target\&quot;: \&quot;8.8.8.8\&quot;, \&quot;type\&quot;: \&quot;resolves_to\&quot;}   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Response Time: 500ms-2s depending on graph complexity&lt;/li&gt;     &lt;li&gt;Default: 100 nodes maximum (adjustable)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Interactive threat actor infrastructure visualization&lt;/li&gt;     &lt;li&gt;Discovering related phishing campaigns&lt;/li&gt;     &lt;li&gt;Mapping shadow IT and sprawl&lt;/li&gt;     &lt;li&gt;Network topology visualization&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved graph data. Compatible with react-force-graph, vis.js, and cytoscape.js.
     * <p><b>400</b> - Invalid indicator type or limit parameter. Type must be &#39;ip&#39; or &#39;domain&#39;, limit must be 1-500.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found or no relationships discovered.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param limit Maximum number of nodes to return in the graph
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIndicatorGraphWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        return getIndicatorGraphRequestCreation(type, value, limit);
    }

    /**
     * Get Historical Data for Indicator
     * &lt;p&gt;Retrieves time-series historical data for an IP address or domain. Track how infrastructure changes over time for threat intelligence and forensic analysis.&lt;/p&gt; &lt;h4&gt;History Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration history - registrant changes, expiration updates, transfers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing history - prefix announcements, ASN changes, route hijacks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS resolution history - IP address changes, nameserver updates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate history - cert replacements, CA changes, expiration events&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reputation:&lt;/b&gt; Risk score history - blacklist appearances, reputation changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Format:&lt;/h4&gt; &lt;p&gt;Timeline with dated snapshots showing what changed and when:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;history\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:00:00Z\&quot;,       \&quot;field\&quot;: \&quot;registrant_company\&quot;,       \&quot;old_value\&quot;: \&quot;Evil Corp\&quot;,       \&quot;new_value\&quot;: \&quot;Legitimate LLC\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Tracking domain ownership changes&lt;/li&gt;     &lt;li&gt;Investigating IP reputation degradation&lt;/li&gt;     &lt;li&gt;Forensic timeline reconstruction&lt;/li&gt;     &lt;li&gt;Detecting infrastructure pivots by threat actors&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved historical data.
     * <p><b>400</b> - Invalid indicator type or history type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No historical data found for this indicator.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param historyType Type of historical data to retrieve
     * @return HistoryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIndicatorHistoryRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String historyType) throws WebClientResponseException {
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
     * <p><b>200</b> - Successfully retrieved historical data.
     * <p><b>400</b> - Invalid indicator type or history type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No historical data found for this indicator.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param historyType Type of historical data to retrieve
     * @return HistoryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<HistoryResponse> getIndicatorHistory(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String historyType) throws WebClientResponseException {
        ParameterizedTypeReference<HistoryResponse> localVarReturnType = new ParameterizedTypeReference<HistoryResponse>() {};
        return getIndicatorHistoryRequestCreation(type, value, historyType).bodyToMono(localVarReturnType);
    }

    /**
     * Get Historical Data for Indicator
     * &lt;p&gt;Retrieves time-series historical data for an IP address or domain. Track how infrastructure changes over time for threat intelligence and forensic analysis.&lt;/p&gt; &lt;h4&gt;History Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration history - registrant changes, expiration updates, transfers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing history - prefix announcements, ASN changes, route hijacks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS resolution history - IP address changes, nameserver updates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate history - cert replacements, CA changes, expiration events&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reputation:&lt;/b&gt; Risk score history - blacklist appearances, reputation changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Format:&lt;/h4&gt; &lt;p&gt;Timeline with dated snapshots showing what changed and when:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;history\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:00:00Z\&quot;,       \&quot;field\&quot;: \&quot;registrant_company\&quot;,       \&quot;old_value\&quot;: \&quot;Evil Corp\&quot;,       \&quot;new_value\&quot;: \&quot;Legitimate LLC\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Tracking domain ownership changes&lt;/li&gt;     &lt;li&gt;Investigating IP reputation degradation&lt;/li&gt;     &lt;li&gt;Forensic timeline reconstruction&lt;/li&gt;     &lt;li&gt;Detecting infrastructure pivots by threat actors&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved historical data.
     * <p><b>400</b> - Invalid indicator type or history type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No historical data found for this indicator.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param historyType Type of historical data to retrieve
     * @return ResponseEntity&lt;HistoryResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<HistoryResponse>> getIndicatorHistoryWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String historyType) throws WebClientResponseException {
        ParameterizedTypeReference<HistoryResponse> localVarReturnType = new ParameterizedTypeReference<HistoryResponse>() {};
        return getIndicatorHistoryRequestCreation(type, value, historyType).toEntity(localVarReturnType);
    }

    /**
     * Get Historical Data for Indicator
     * &lt;p&gt;Retrieves time-series historical data for an IP address or domain. Track how infrastructure changes over time for threat intelligence and forensic analysis.&lt;/p&gt; &lt;h4&gt;History Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registration history - registrant changes, expiration updates, transfers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing history - prefix announcements, ASN changes, route hijacks&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS resolution history - IP address changes, nameserver updates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate history - cert replacements, CA changes, expiration events&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reputation:&lt;/b&gt; Risk score history - blacklist appearances, reputation changes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Data Format:&lt;/h4&gt; &lt;p&gt;Timeline with dated snapshots showing what changed and when:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;history\&quot;: [     {       \&quot;timestamp\&quot;: \&quot;2025-01-15T10:00:00Z\&quot;,       \&quot;field\&quot;: \&quot;registrant_company\&quot;,       \&quot;old_value\&quot;: \&quot;Evil Corp\&quot;,       \&quot;new_value\&quot;: \&quot;Legitimate LLC\&quot;     }   ] }&lt;/code&gt;&lt;/pre&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Tracking domain ownership changes&lt;/li&gt;     &lt;li&gt;Investigating IP reputation degradation&lt;/li&gt;     &lt;li&gt;Forensic timeline reconstruction&lt;/li&gt;     &lt;li&gt;Detecting infrastructure pivots by threat actors&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved historical data.
     * <p><b>400</b> - Invalid indicator type or history type.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - No historical data found for this indicator.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @param historyType Type of historical data to retrieve
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIndicatorHistoryWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String historyType) throws WebClientResponseException {
        return getIndicatorHistoryRequestCreation(type, value, historyType);
    }

    /**
     * Get AI Predictive Risk Score
     * &lt;p&gt;Returns ML-based predictive risk assessment for an IP address or domain. Provides current risk scoring, 7-day and 30-day predictions, risk trajectory analysis, and contributing factors.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Current Assessment:&lt;/b&gt; Risk score (0-100), risk level, and confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Predictions:&lt;/b&gt; 7-day and 30-day risk forecasts with confidence intervals&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trajectory:&lt;/b&gt; Trend direction (improving/stable/worsening), velocity, stability&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Risk Factors:&lt;/b&gt; Contributing factors with weights and descriptions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Early Warnings:&lt;/b&gt; Signals indicating potential future risk changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Similar Cases:&lt;/b&gt; Historical indicators with similar profiles and their outcomes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Risk Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;low:&lt;/b&gt; Score 0-30 - Minimal observed risk&lt;/li&gt;     &lt;li&gt;&lt;b&gt;medium:&lt;/b&gt; Score 31-60 - Moderate risk, warrants monitoring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;high:&lt;/b&gt; Score 61-80 - Elevated risk, investigation recommended&lt;/li&gt;     &lt;li&gt;&lt;b&gt;critical:&lt;/b&gt; Score 81-100 - Severe risk, immediate action advised&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-computed ML predictions. Response time typically under 500ms with 15-minute cache.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved predictive risk assessment.
     * <p><b>400</b> - Invalid indicator type or value.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found in AI model data.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @return PredictiveRiskResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getPredictiveRiskRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling getPredictiveRisk", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling getPredictiveRisk", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<PredictiveRiskResponse> localVarReturnType = new ParameterizedTypeReference<PredictiveRiskResponse>() {};
        return apiClient.invokeAPI("/v1/indicators/{type}/{value}/predictive-risk", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get AI Predictive Risk Score
     * &lt;p&gt;Returns ML-based predictive risk assessment for an IP address or domain. Provides current risk scoring, 7-day and 30-day predictions, risk trajectory analysis, and contributing factors.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Current Assessment:&lt;/b&gt; Risk score (0-100), risk level, and confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Predictions:&lt;/b&gt; 7-day and 30-day risk forecasts with confidence intervals&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trajectory:&lt;/b&gt; Trend direction (improving/stable/worsening), velocity, stability&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Risk Factors:&lt;/b&gt; Contributing factors with weights and descriptions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Early Warnings:&lt;/b&gt; Signals indicating potential future risk changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Similar Cases:&lt;/b&gt; Historical indicators with similar profiles and their outcomes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Risk Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;low:&lt;/b&gt; Score 0-30 - Minimal observed risk&lt;/li&gt;     &lt;li&gt;&lt;b&gt;medium:&lt;/b&gt; Score 31-60 - Moderate risk, warrants monitoring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;high:&lt;/b&gt; Score 61-80 - Elevated risk, investigation recommended&lt;/li&gt;     &lt;li&gt;&lt;b&gt;critical:&lt;/b&gt; Score 81-100 - Severe risk, immediate action advised&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-computed ML predictions. Response time typically under 500ms with 15-minute cache.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved predictive risk assessment.
     * <p><b>400</b> - Invalid indicator type or value.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found in AI model data.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @return PredictiveRiskResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PredictiveRiskResponse> getPredictiveRisk(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        ParameterizedTypeReference<PredictiveRiskResponse> localVarReturnType = new ParameterizedTypeReference<PredictiveRiskResponse>() {};
        return getPredictiveRiskRequestCreation(type, value).bodyToMono(localVarReturnType);
    }

    /**
     * Get AI Predictive Risk Score
     * &lt;p&gt;Returns ML-based predictive risk assessment for an IP address or domain. Provides current risk scoring, 7-day and 30-day predictions, risk trajectory analysis, and contributing factors.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Current Assessment:&lt;/b&gt; Risk score (0-100), risk level, and confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Predictions:&lt;/b&gt; 7-day and 30-day risk forecasts with confidence intervals&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trajectory:&lt;/b&gt; Trend direction (improving/stable/worsening), velocity, stability&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Risk Factors:&lt;/b&gt; Contributing factors with weights and descriptions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Early Warnings:&lt;/b&gt; Signals indicating potential future risk changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Similar Cases:&lt;/b&gt; Historical indicators with similar profiles and their outcomes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Risk Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;low:&lt;/b&gt; Score 0-30 - Minimal observed risk&lt;/li&gt;     &lt;li&gt;&lt;b&gt;medium:&lt;/b&gt; Score 31-60 - Moderate risk, warrants monitoring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;high:&lt;/b&gt; Score 61-80 - Elevated risk, investigation recommended&lt;/li&gt;     &lt;li&gt;&lt;b&gt;critical:&lt;/b&gt; Score 81-100 - Severe risk, immediate action advised&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-computed ML predictions. Response time typically under 500ms with 15-minute cache.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved predictive risk assessment.
     * <p><b>400</b> - Invalid indicator type or value.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found in AI model data.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @return ResponseEntity&lt;PredictiveRiskResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PredictiveRiskResponse>> getPredictiveRiskWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        ParameterizedTypeReference<PredictiveRiskResponse> localVarReturnType = new ParameterizedTypeReference<PredictiveRiskResponse>() {};
        return getPredictiveRiskRequestCreation(type, value).toEntity(localVarReturnType);
    }

    /**
     * Get AI Predictive Risk Score
     * &lt;p&gt;Returns ML-based predictive risk assessment for an IP address or domain. Provides current risk scoring, 7-day and 30-day predictions, risk trajectory analysis, and contributing factors.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Current Assessment:&lt;/b&gt; Risk score (0-100), risk level, and confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Predictions:&lt;/b&gt; 7-day and 30-day risk forecasts with confidence intervals&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trajectory:&lt;/b&gt; Trend direction (improving/stable/worsening), velocity, stability&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Risk Factors:&lt;/b&gt; Contributing factors with weights and descriptions&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Early Warnings:&lt;/b&gt; Signals indicating potential future risk changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Similar Cases:&lt;/b&gt; Historical indicators with similar profiles and their outcomes&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Risk Levels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;low:&lt;/b&gt; Score 0-30 - Minimal observed risk&lt;/li&gt;     &lt;li&gt;&lt;b&gt;medium:&lt;/b&gt; Score 31-60 - Moderate risk, warrants monitoring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;high:&lt;/b&gt; Score 61-80 - Elevated risk, investigation recommended&lt;/li&gt;     &lt;li&gt;&lt;b&gt;critical:&lt;/b&gt; Score 81-100 - Severe risk, immediate action advised&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-computed ML predictions. Response time typically under 500ms with 15-minute cache.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved predictive risk assessment.
     * <p><b>400</b> - Invalid indicator type or value.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Indicator not found in AI model data.
     * @param type Type of indicator
     * @param value The indicator value (IP address or domain)
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getPredictiveRiskWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        return getPredictiveRiskRequestCreation(type, value);
    }

    /**
     * Get Domain Subdomains
     * Retrieves a list of discovered subdomains for a given root domain, based on passive DNS and other enumeration techniques.
     * <p><b>200</b> - Successfully retrieved subdomains.
     * <p><b>400</b> - Invalid domain format.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Domain not found or no subdomains discovered.
     * @param domain The root domain to query for subdomains.
     * @param limit The maximum number of subdomains to return.
     * @return SubdomainResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSubdomainsRequestCreation(@jakarta.annotation.Nonnull String domain, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
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
     * <p><b>200</b> - Successfully retrieved subdomains.
     * <p><b>400</b> - Invalid domain format.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Domain not found or no subdomains discovered.
     * @param domain The root domain to query for subdomains.
     * @param limit The maximum number of subdomains to return.
     * @return SubdomainResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubdomainResponse> getSubdomains(@jakarta.annotation.Nonnull String domain, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<SubdomainResponse> localVarReturnType = new ParameterizedTypeReference<SubdomainResponse>() {};
        return getSubdomainsRequestCreation(domain, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Get Domain Subdomains
     * Retrieves a list of discovered subdomains for a given root domain, based on passive DNS and other enumeration techniques.
     * <p><b>200</b> - Successfully retrieved subdomains.
     * <p><b>400</b> - Invalid domain format.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Domain not found or no subdomains discovered.
     * @param domain The root domain to query for subdomains.
     * @param limit The maximum number of subdomains to return.
     * @return ResponseEntity&lt;SubdomainResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<SubdomainResponse>> getSubdomainsWithHttpInfo(@jakarta.annotation.Nonnull String domain, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<SubdomainResponse> localVarReturnType = new ParameterizedTypeReference<SubdomainResponse>() {};
        return getSubdomainsRequestCreation(domain, limit).toEntity(localVarReturnType);
    }

    /**
     * Get Domain Subdomains
     * Retrieves a list of discovered subdomains for a given root domain, based on passive DNS and other enumeration techniques.
     * <p><b>200</b> - Successfully retrieved subdomains.
     * <p><b>400</b> - Invalid domain format.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Domain not found or no subdomains discovered.
     * @param domain The root domain to query for subdomains.
     * @param limit The maximum number of subdomains to return.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getSubdomainsWithResponseSpec(@jakarta.annotation.Nonnull String domain, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        return getSubdomainsRequestCreation(domain, limit);
    }

    /**
     * Search WHOIS and Geolocation Records (Asynchronous)
     *             &lt;p&gt;Initiates an asynchronous job to search domain registration (WHOIS) or IP geolocation records. This endpoint is extremely powerful for infrastructure discovery, threat hunting, and brand protection.&lt;/p&gt;             &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; WHOIS searches are data-intensive and can take over 50 seconds to complete. Geolocation searches are faster (5-10 seconds). This endpoint is asynchronous by design. Poll the &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; endpoint to retrieve results.&lt;/p&gt;              &lt;h4&gt;Search Types:&lt;/h4&gt;             &lt;p&gt;The endpoint automatically routes to the appropriate backend based on the fields provided:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;WHOIS Search:&lt;/b&gt; Use registrant fields (registrantCompany, registrantEmail, etc.) or domain-related fields (tld, nameServer, etc.)&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation Search:&lt;/b&gt; Use IP geolocation fields (city, country, asn, isp, etc.) to find IPs matching criteria&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;WHOIS Search Fields:&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Type&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;tld&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Top-level domain (e.g., \&quot;com\&quot;, \&quot;org\&quot;, \&quot;net\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain registrar name&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarIanaId&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;IANA registrar ID&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain registrant name (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCompany&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant organization/company (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantEmail&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant email address (supports *@domain.com wildcards)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantPhone&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant phone number&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCountry&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;2-letter country code (e.g., \&quot;US\&quot;, \&quot;DE\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCity&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant city&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;nameServer&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Name server hostname&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;domainStatus&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain status flag (e.g., \&quot;clientTransferProhibited\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;createdDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain creation date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;updatedDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain last update date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;expiryDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain expiry date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Geolocation Search Fields (query string syntax):&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;th&gt;Example&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;city&lt;/code&gt;&lt;/td&gt;&lt;td&gt;City name&lt;/td&gt;&lt;td&gt;&lt;code&gt;city:London&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;country&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Country name&lt;/td&gt;&lt;td&gt;&lt;code&gt;country:Germany&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;asn&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Autonomous System Number&lt;/td&gt;&lt;td&gt;&lt;code&gt;asn:15169&lt;/code&gt; (Google)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;isp&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Internet Service Provider name&lt;/td&gt;&lt;td&gt;&lt;code&gt;isp:Cloudflare&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;organization&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Organization name&lt;/td&gt;&lt;td&gt;&lt;code&gt;organization:Amazon&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;region&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Region/State&lt;/td&gt;&lt;td&gt;&lt;code&gt;region:California&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;postal_code&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Postal/ZIP code&lt;/td&gt;&lt;td&gt;&lt;code&gt;postal_code:94043&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;continent&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Continent&lt;/td&gt;&lt;td&gt;&lt;code&gt;continent:Europe&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Example Requests:&lt;/h4&gt;             &lt;p&gt;&lt;b&gt;WHOIS search (field-based):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;registrantCompany\&quot;: \&quot;Google\&quot;,   \&quot;registrantCountry\&quot;: \&quot;US\&quot;,   \&quot;limit\&quot;: 100,   \&quot;page\&quot;: 0 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by ASN):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;asn:15169\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by city):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;city:Mountain View\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Date-based domain search:&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;createdDate\&quot;: \&quot;2024-01-15\&quot;,   \&quot;tld\&quot;: \&quot;com\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;              &lt;h4&gt;Pagination:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;code&gt;limit&lt;/code&gt;: Maximum 100 results per page (default: 100)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;page&lt;/code&gt;: 0-indexed page number (default: 0)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;offset&lt;/code&gt;: Alternative to page - number of results to skip&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Use Cases:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;Threat hunting:&lt;/b&gt; Find domains/IPs registered by known malicious actors&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Infrastructure mapping:&lt;/b&gt; Find all IPs in a specific ASN or organization&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Brand protection:&lt;/b&gt; Monitor for domains similar to your brand&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation analysis:&lt;/b&gt; Find IPs in specific geographic regions&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Investigation:&lt;/b&gt; Track domains created on specific dates or IPs from specific ISPs&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Security:&lt;/h4&gt;             &lt;p&gt;All search parameters are validated for:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;SQL injection prevention&lt;/li&gt;                 &lt;li&gt;Command injection prevention&lt;/li&gt;                 &lt;li&gt;Input length limits&lt;/li&gt;                 &lt;li&gt;Format validation (dates, emails, country codes, etc.)&lt;/li&gt;             &lt;/ul&gt; 
     * <p><b>202</b> - Search job successfully accepted. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SearchResponse object.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure.
     * <p><b>400</b> - Invalid search query or parameters.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * @param searchRequest The search query and configuration.
     * @return SearchResponse
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

        ParameterizedTypeReference<SearchResponse> localVarReturnType = new ParameterizedTypeReference<SearchResponse>() {};
        return apiClient.invokeAPI("/v1/ops/enrichment/search", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Search WHOIS and Geolocation Records (Asynchronous)
     *             &lt;p&gt;Initiates an asynchronous job to search domain registration (WHOIS) or IP geolocation records. This endpoint is extremely powerful for infrastructure discovery, threat hunting, and brand protection.&lt;/p&gt;             &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; WHOIS searches are data-intensive and can take over 50 seconds to complete. Geolocation searches are faster (5-10 seconds). This endpoint is asynchronous by design. Poll the &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; endpoint to retrieve results.&lt;/p&gt;              &lt;h4&gt;Search Types:&lt;/h4&gt;             &lt;p&gt;The endpoint automatically routes to the appropriate backend based on the fields provided:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;WHOIS Search:&lt;/b&gt; Use registrant fields (registrantCompany, registrantEmail, etc.) or domain-related fields (tld, nameServer, etc.)&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation Search:&lt;/b&gt; Use IP geolocation fields (city, country, asn, isp, etc.) to find IPs matching criteria&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;WHOIS Search Fields:&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Type&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;tld&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Top-level domain (e.g., \&quot;com\&quot;, \&quot;org\&quot;, \&quot;net\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain registrar name&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarIanaId&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;IANA registrar ID&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain registrant name (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCompany&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant organization/company (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantEmail&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant email address (supports *@domain.com wildcards)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantPhone&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant phone number&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCountry&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;2-letter country code (e.g., \&quot;US\&quot;, \&quot;DE\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCity&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant city&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;nameServer&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Name server hostname&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;domainStatus&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain status flag (e.g., \&quot;clientTransferProhibited\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;createdDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain creation date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;updatedDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain last update date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;expiryDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain expiry date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Geolocation Search Fields (query string syntax):&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;th&gt;Example&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;city&lt;/code&gt;&lt;/td&gt;&lt;td&gt;City name&lt;/td&gt;&lt;td&gt;&lt;code&gt;city:London&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;country&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Country name&lt;/td&gt;&lt;td&gt;&lt;code&gt;country:Germany&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;asn&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Autonomous System Number&lt;/td&gt;&lt;td&gt;&lt;code&gt;asn:15169&lt;/code&gt; (Google)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;isp&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Internet Service Provider name&lt;/td&gt;&lt;td&gt;&lt;code&gt;isp:Cloudflare&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;organization&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Organization name&lt;/td&gt;&lt;td&gt;&lt;code&gt;organization:Amazon&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;region&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Region/State&lt;/td&gt;&lt;td&gt;&lt;code&gt;region:California&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;postal_code&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Postal/ZIP code&lt;/td&gt;&lt;td&gt;&lt;code&gt;postal_code:94043&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;continent&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Continent&lt;/td&gt;&lt;td&gt;&lt;code&gt;continent:Europe&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Example Requests:&lt;/h4&gt;             &lt;p&gt;&lt;b&gt;WHOIS search (field-based):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;registrantCompany\&quot;: \&quot;Google\&quot;,   \&quot;registrantCountry\&quot;: \&quot;US\&quot;,   \&quot;limit\&quot;: 100,   \&quot;page\&quot;: 0 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by ASN):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;asn:15169\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by city):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;city:Mountain View\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Date-based domain search:&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;createdDate\&quot;: \&quot;2024-01-15\&quot;,   \&quot;tld\&quot;: \&quot;com\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;              &lt;h4&gt;Pagination:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;code&gt;limit&lt;/code&gt;: Maximum 100 results per page (default: 100)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;page&lt;/code&gt;: 0-indexed page number (default: 0)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;offset&lt;/code&gt;: Alternative to page - number of results to skip&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Use Cases:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;Threat hunting:&lt;/b&gt; Find domains/IPs registered by known malicious actors&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Infrastructure mapping:&lt;/b&gt; Find all IPs in a specific ASN or organization&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Brand protection:&lt;/b&gt; Monitor for domains similar to your brand&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation analysis:&lt;/b&gt; Find IPs in specific geographic regions&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Investigation:&lt;/b&gt; Track domains created on specific dates or IPs from specific ISPs&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Security:&lt;/h4&gt;             &lt;p&gt;All search parameters are validated for:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;SQL injection prevention&lt;/li&gt;                 &lt;li&gt;Command injection prevention&lt;/li&gt;                 &lt;li&gt;Input length limits&lt;/li&gt;                 &lt;li&gt;Format validation (dates, emails, country codes, etc.)&lt;/li&gt;             &lt;/ul&gt; 
     * <p><b>202</b> - Search job successfully accepted. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SearchResponse object.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure.
     * <p><b>400</b> - Invalid search query or parameters.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * @param searchRequest The search query and configuration.
     * @return SearchResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SearchResponse> searchIndicators(@jakarta.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<SearchResponse> localVarReturnType = new ParameterizedTypeReference<SearchResponse>() {};
        return searchIndicatorsRequestCreation(searchRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Search WHOIS and Geolocation Records (Asynchronous)
     *             &lt;p&gt;Initiates an asynchronous job to search domain registration (WHOIS) or IP geolocation records. This endpoint is extremely powerful for infrastructure discovery, threat hunting, and brand protection.&lt;/p&gt;             &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; WHOIS searches are data-intensive and can take over 50 seconds to complete. Geolocation searches are faster (5-10 seconds). This endpoint is asynchronous by design. Poll the &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; endpoint to retrieve results.&lt;/p&gt;              &lt;h4&gt;Search Types:&lt;/h4&gt;             &lt;p&gt;The endpoint automatically routes to the appropriate backend based on the fields provided:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;WHOIS Search:&lt;/b&gt; Use registrant fields (registrantCompany, registrantEmail, etc.) or domain-related fields (tld, nameServer, etc.)&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation Search:&lt;/b&gt; Use IP geolocation fields (city, country, asn, isp, etc.) to find IPs matching criteria&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;WHOIS Search Fields:&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Type&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;tld&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Top-level domain (e.g., \&quot;com\&quot;, \&quot;org\&quot;, \&quot;net\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain registrar name&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarIanaId&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;IANA registrar ID&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain registrant name (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCompany&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant organization/company (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantEmail&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant email address (supports *@domain.com wildcards)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantPhone&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant phone number&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCountry&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;2-letter country code (e.g., \&quot;US\&quot;, \&quot;DE\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCity&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant city&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;nameServer&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Name server hostname&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;domainStatus&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain status flag (e.g., \&quot;clientTransferProhibited\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;createdDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain creation date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;updatedDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain last update date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;expiryDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain expiry date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Geolocation Search Fields (query string syntax):&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;th&gt;Example&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;city&lt;/code&gt;&lt;/td&gt;&lt;td&gt;City name&lt;/td&gt;&lt;td&gt;&lt;code&gt;city:London&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;country&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Country name&lt;/td&gt;&lt;td&gt;&lt;code&gt;country:Germany&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;asn&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Autonomous System Number&lt;/td&gt;&lt;td&gt;&lt;code&gt;asn:15169&lt;/code&gt; (Google)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;isp&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Internet Service Provider name&lt;/td&gt;&lt;td&gt;&lt;code&gt;isp:Cloudflare&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;organization&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Organization name&lt;/td&gt;&lt;td&gt;&lt;code&gt;organization:Amazon&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;region&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Region/State&lt;/td&gt;&lt;td&gt;&lt;code&gt;region:California&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;postal_code&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Postal/ZIP code&lt;/td&gt;&lt;td&gt;&lt;code&gt;postal_code:94043&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;continent&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Continent&lt;/td&gt;&lt;td&gt;&lt;code&gt;continent:Europe&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Example Requests:&lt;/h4&gt;             &lt;p&gt;&lt;b&gt;WHOIS search (field-based):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;registrantCompany\&quot;: \&quot;Google\&quot;,   \&quot;registrantCountry\&quot;: \&quot;US\&quot;,   \&quot;limit\&quot;: 100,   \&quot;page\&quot;: 0 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by ASN):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;asn:15169\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by city):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;city:Mountain View\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Date-based domain search:&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;createdDate\&quot;: \&quot;2024-01-15\&quot;,   \&quot;tld\&quot;: \&quot;com\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;              &lt;h4&gt;Pagination:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;code&gt;limit&lt;/code&gt;: Maximum 100 results per page (default: 100)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;page&lt;/code&gt;: 0-indexed page number (default: 0)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;offset&lt;/code&gt;: Alternative to page - number of results to skip&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Use Cases:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;Threat hunting:&lt;/b&gt; Find domains/IPs registered by known malicious actors&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Infrastructure mapping:&lt;/b&gt; Find all IPs in a specific ASN or organization&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Brand protection:&lt;/b&gt; Monitor for domains similar to your brand&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation analysis:&lt;/b&gt; Find IPs in specific geographic regions&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Investigation:&lt;/b&gt; Track domains created on specific dates or IPs from specific ISPs&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Security:&lt;/h4&gt;             &lt;p&gt;All search parameters are validated for:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;SQL injection prevention&lt;/li&gt;                 &lt;li&gt;Command injection prevention&lt;/li&gt;                 &lt;li&gt;Input length limits&lt;/li&gt;                 &lt;li&gt;Format validation (dates, emails, country codes, etc.)&lt;/li&gt;             &lt;/ul&gt; 
     * <p><b>202</b> - Search job successfully accepted. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SearchResponse object.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure.
     * <p><b>400</b> - Invalid search query or parameters.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * @param searchRequest The search query and configuration.
     * @return ResponseEntity&lt;SearchResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<SearchResponse>> searchIndicatorsWithHttpInfo(@jakarta.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<SearchResponse> localVarReturnType = new ParameterizedTypeReference<SearchResponse>() {};
        return searchIndicatorsRequestCreation(searchRequest).toEntity(localVarReturnType);
    }

    /**
     * Search WHOIS and Geolocation Records (Asynchronous)
     *             &lt;p&gt;Initiates an asynchronous job to search domain registration (WHOIS) or IP geolocation records. This endpoint is extremely powerful for infrastructure discovery, threat hunting, and brand protection.&lt;/p&gt;             &lt;p&gt;&lt;b&gt;Performance Note:&lt;/b&gt; WHOIS searches are data-intensive and can take over 50 seconds to complete. Geolocation searches are faster (5-10 seconds). This endpoint is asynchronous by design. Poll the &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; endpoint to retrieve results.&lt;/p&gt;              &lt;h4&gt;Search Types:&lt;/h4&gt;             &lt;p&gt;The endpoint automatically routes to the appropriate backend based on the fields provided:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;WHOIS Search:&lt;/b&gt; Use registrant fields (registrantCompany, registrantEmail, etc.) or domain-related fields (tld, nameServer, etc.)&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation Search:&lt;/b&gt; Use IP geolocation fields (city, country, asn, isp, etc.) to find IPs matching criteria&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;WHOIS Search Fields:&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Type&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;tld&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Top-level domain (e.g., \&quot;com\&quot;, \&quot;org\&quot;, \&quot;net\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain registrar name&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrarIanaId&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;IANA registrar ID&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantName&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain registrant name (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCompany&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant organization/company (partial match)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantEmail&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant email address (supports *@domain.com wildcards)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantPhone&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant phone number&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCountry&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;2-letter country code (e.g., \&quot;US\&quot;, \&quot;DE\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;registrantCity&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Registrant city&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;nameServer&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Name server hostname&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;domainStatus&lt;/code&gt;&lt;/td&gt;&lt;td&gt;text&lt;/td&gt;&lt;td&gt;Domain status flag (e.g., \&quot;clientTransferProhibited\&quot;)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;createdDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain creation date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;updatedDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain last update date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;expiryDate&lt;/code&gt;&lt;/td&gt;&lt;td&gt;exact&lt;/td&gt;&lt;td&gt;Domain expiry date (YYYY-MM-DD format)&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Geolocation Search Fields (query string syntax):&lt;/h4&gt;             &lt;table&gt;                 &lt;tr&gt;&lt;th&gt;Field&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;th&gt;Example&lt;/th&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;city&lt;/code&gt;&lt;/td&gt;&lt;td&gt;City name&lt;/td&gt;&lt;td&gt;&lt;code&gt;city:London&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;country&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Country name&lt;/td&gt;&lt;td&gt;&lt;code&gt;country:Germany&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;asn&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Autonomous System Number&lt;/td&gt;&lt;td&gt;&lt;code&gt;asn:15169&lt;/code&gt; (Google)&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;isp&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Internet Service Provider name&lt;/td&gt;&lt;td&gt;&lt;code&gt;isp:Cloudflare&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;organization&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Organization name&lt;/td&gt;&lt;td&gt;&lt;code&gt;organization:Amazon&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;region&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Region/State&lt;/td&gt;&lt;td&gt;&lt;code&gt;region:California&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;postal_code&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Postal/ZIP code&lt;/td&gt;&lt;td&gt;&lt;code&gt;postal_code:94043&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;                 &lt;tr&gt;&lt;td&gt;&lt;code&gt;continent&lt;/code&gt;&lt;/td&gt;&lt;td&gt;Continent&lt;/td&gt;&lt;td&gt;&lt;code&gt;continent:Europe&lt;/code&gt;&lt;/td&gt;&lt;/tr&gt;             &lt;/table&gt;              &lt;h4&gt;Example Requests:&lt;/h4&gt;             &lt;p&gt;&lt;b&gt;WHOIS search (field-based):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;registrantCompany\&quot;: \&quot;Google\&quot;,   \&quot;registrantCountry\&quot;: \&quot;US\&quot;,   \&quot;limit\&quot;: 100,   \&quot;page\&quot;: 0 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by ASN):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;asn:15169\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Geolocation search (find IPs by city):&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;query\&quot;: \&quot;city:Mountain View\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;             &lt;p&gt;&lt;b&gt;Date-based domain search:&lt;/b&gt;&lt;/p&gt;             &lt;pre&gt;{   \&quot;createdDate\&quot;: \&quot;2024-01-15\&quot;,   \&quot;tld\&quot;: \&quot;com\&quot;,   \&quot;limit\&quot;: 100 }&lt;/pre&gt;              &lt;h4&gt;Pagination:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;code&gt;limit&lt;/code&gt;: Maximum 100 results per page (default: 100)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;page&lt;/code&gt;: 0-indexed page number (default: 0)&lt;/li&gt;                 &lt;li&gt;&lt;code&gt;offset&lt;/code&gt;: Alternative to page - number of results to skip&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Use Cases:&lt;/h4&gt;             &lt;ul&gt;                 &lt;li&gt;&lt;b&gt;Threat hunting:&lt;/b&gt; Find domains/IPs registered by known malicious actors&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Infrastructure mapping:&lt;/b&gt; Find all IPs in a specific ASN or organization&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Brand protection:&lt;/b&gt; Monitor for domains similar to your brand&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Geolocation analysis:&lt;/b&gt; Find IPs in specific geographic regions&lt;/li&gt;                 &lt;li&gt;&lt;b&gt;Investigation:&lt;/b&gt; Track domains created on specific dates or IPs from specific ISPs&lt;/li&gt;             &lt;/ul&gt;              &lt;h4&gt;Security:&lt;/h4&gt;             &lt;p&gt;All search parameters are validated for:&lt;/p&gt;             &lt;ul&gt;                 &lt;li&gt;SQL injection prevention&lt;/li&gt;                 &lt;li&gt;Command injection prevention&lt;/li&gt;                 &lt;li&gt;Input length limits&lt;/li&gt;                 &lt;li&gt;Format validation (dates, emails, country codes, etc.)&lt;/li&gt;             &lt;/ul&gt; 
     * <p><b>202</b> - Search job successfully accepted. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SearchResponse object.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure.
     * <p><b>400</b> - Invalid search query or parameters.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>429</b> - Rate limit exceeded for search operations.
     * @param searchRequest The search query and configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec searchIndicatorsWithResponseSpec(@jakarta.annotation.Nonnull SearchRequest searchRequest) throws WebClientResponseException {
        return searchIndicatorsRequestCreation(searchRequest);
    }

    /**
     * Find Similar Domains (Asynchronous)
     * &lt;p&gt;Finds domains similar to the provided domain using various similarity detection techniques. This endpoint is useful for brand protection, typosquatting detection, and threat hunting.&lt;/p&gt;  &lt;h4&gt;Supported Techniques:&lt;/h4&gt; &lt;p&gt;Specify techniques in the &lt;code&gt;techniques&lt;/code&gt; array. If not specified, defaults to &lt;code&gt;typosquatting&lt;/code&gt;.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;typosquatting&lt;/b&gt; - Keyboard proximity errors and common typos (e.g., gooogle.com, gogle.com)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;homoglyph&lt;/b&gt; - Visually similar Unicode characters (e.g., gооgle.com using Cyrillic &#39;о&#39;)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;tld_variation&lt;/b&gt; - Different TLD variations (e.g., google.net, google.org)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;sounding&lt;/b&gt; - Phonetically similar domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;prefix&lt;/b&gt; - Domains starting with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;suffix&lt;/b&gt; - Domains ending with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;contains&lt;/b&gt; - Domains containing the target as a substring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;levenshtein&lt;/b&gt; - Edit distance similarity&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Example Request:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;techniques\&quot;: [\&quot;typosquatting\&quot;, \&quot;homoglyph\&quot;, \&quot;tld_variation\&quot;],   \&quot;limit\&quot;: 100 }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Poll &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; to get results. The result contains:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;status\&quot;: \&quot;completed\&quot;,   \&quot;similarDomains\&quot;: [     {\&quot;domain\&quot;: \&quot;gooogle.com\&quot;, \&quot;technique\&quot;: \&quot;TYPO\&quot;},     {\&quot;domain\&quot;: \&quot;gооgle.com\&quot;, \&quot;technique\&quot;: \&quot;UTFVARS\&quot;}   ],   \&quot;totalCount\&quot;: 200,   \&quot;analysis\&quot;: {     \&quot;techniquesUsed\&quot;: \&quot;TYPO,UTFVARS\&quot;,     \&quot;baseDomain\&quot;: \&quot;google.com\&quot;,     \&quot;searchLimit\&quot;: 100   } }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds. Multiple techniques run in parallel.&lt;/p&gt;  &lt;h4&gt;Note:&lt;/h4&gt; &lt;p&gt;The &lt;code&gt;check_registration&lt;/code&gt;, &lt;code&gt;include_dns&lt;/code&gt;, and &lt;code&gt;include_risk_score&lt;/code&gt; options are not currently supported by the backend service and will be ignored.&lt;/p&gt; 
     * <p><b>202</b> - Similar domains job created successfully. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SimilarDomainsResponse object.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure.
     * <p><b>400</b> - Invalid domain or options.
     * <p><b>401</b> - Authentication failed.
     * @param similarDomainsOpsRequest Similar domains request with domain and options.
     * @return SimilarDomainsResponse
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

        ParameterizedTypeReference<SimilarDomainsResponse> localVarReturnType = new ParameterizedTypeReference<SimilarDomainsResponse>() {};
        return apiClient.invokeAPI("/v1/ops/enrichment/similar-domains", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Find Similar Domains (Asynchronous)
     * &lt;p&gt;Finds domains similar to the provided domain using various similarity detection techniques. This endpoint is useful for brand protection, typosquatting detection, and threat hunting.&lt;/p&gt;  &lt;h4&gt;Supported Techniques:&lt;/h4&gt; &lt;p&gt;Specify techniques in the &lt;code&gt;techniques&lt;/code&gt; array. If not specified, defaults to &lt;code&gt;typosquatting&lt;/code&gt;.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;typosquatting&lt;/b&gt; - Keyboard proximity errors and common typos (e.g., gooogle.com, gogle.com)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;homoglyph&lt;/b&gt; - Visually similar Unicode characters (e.g., gооgle.com using Cyrillic &#39;о&#39;)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;tld_variation&lt;/b&gt; - Different TLD variations (e.g., google.net, google.org)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;sounding&lt;/b&gt; - Phonetically similar domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;prefix&lt;/b&gt; - Domains starting with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;suffix&lt;/b&gt; - Domains ending with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;contains&lt;/b&gt; - Domains containing the target as a substring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;levenshtein&lt;/b&gt; - Edit distance similarity&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Example Request:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;techniques\&quot;: [\&quot;typosquatting\&quot;, \&quot;homoglyph\&quot;, \&quot;tld_variation\&quot;],   \&quot;limit\&quot;: 100 }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Poll &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; to get results. The result contains:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;status\&quot;: \&quot;completed\&quot;,   \&quot;similarDomains\&quot;: [     {\&quot;domain\&quot;: \&quot;gooogle.com\&quot;, \&quot;technique\&quot;: \&quot;TYPO\&quot;},     {\&quot;domain\&quot;: \&quot;gооgle.com\&quot;, \&quot;technique\&quot;: \&quot;UTFVARS\&quot;}   ],   \&quot;totalCount\&quot;: 200,   \&quot;analysis\&quot;: {     \&quot;techniquesUsed\&quot;: \&quot;TYPO,UTFVARS\&quot;,     \&quot;baseDomain\&quot;: \&quot;google.com\&quot;,     \&quot;searchLimit\&quot;: 100   } }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds. Multiple techniques run in parallel.&lt;/p&gt;  &lt;h4&gt;Note:&lt;/h4&gt; &lt;p&gt;The &lt;code&gt;check_registration&lt;/code&gt;, &lt;code&gt;include_dns&lt;/code&gt;, and &lt;code&gt;include_risk_score&lt;/code&gt; options are not currently supported by the backend service and will be ignored.&lt;/p&gt; 
     * <p><b>202</b> - Similar domains job created successfully. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SimilarDomainsResponse object.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure.
     * <p><b>400</b> - Invalid domain or options.
     * <p><b>401</b> - Authentication failed.
     * @param similarDomainsOpsRequest Similar domains request with domain and options.
     * @return SimilarDomainsResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SimilarDomainsResponse> similarDomains(@jakarta.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
        ParameterizedTypeReference<SimilarDomainsResponse> localVarReturnType = new ParameterizedTypeReference<SimilarDomainsResponse>() {};
        return similarDomainsRequestCreation(similarDomainsOpsRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Find Similar Domains (Asynchronous)
     * &lt;p&gt;Finds domains similar to the provided domain using various similarity detection techniques. This endpoint is useful for brand protection, typosquatting detection, and threat hunting.&lt;/p&gt;  &lt;h4&gt;Supported Techniques:&lt;/h4&gt; &lt;p&gt;Specify techniques in the &lt;code&gt;techniques&lt;/code&gt; array. If not specified, defaults to &lt;code&gt;typosquatting&lt;/code&gt;.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;typosquatting&lt;/b&gt; - Keyboard proximity errors and common typos (e.g., gooogle.com, gogle.com)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;homoglyph&lt;/b&gt; - Visually similar Unicode characters (e.g., gооgle.com using Cyrillic &#39;о&#39;)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;tld_variation&lt;/b&gt; - Different TLD variations (e.g., google.net, google.org)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;sounding&lt;/b&gt; - Phonetically similar domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;prefix&lt;/b&gt; - Domains starting with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;suffix&lt;/b&gt; - Domains ending with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;contains&lt;/b&gt; - Domains containing the target as a substring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;levenshtein&lt;/b&gt; - Edit distance similarity&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Example Request:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;techniques\&quot;: [\&quot;typosquatting\&quot;, \&quot;homoglyph\&quot;, \&quot;tld_variation\&quot;],   \&quot;limit\&quot;: 100 }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Poll &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; to get results. The result contains:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;status\&quot;: \&quot;completed\&quot;,   \&quot;similarDomains\&quot;: [     {\&quot;domain\&quot;: \&quot;gooogle.com\&quot;, \&quot;technique\&quot;: \&quot;TYPO\&quot;},     {\&quot;domain\&quot;: \&quot;gооgle.com\&quot;, \&quot;technique\&quot;: \&quot;UTFVARS\&quot;}   ],   \&quot;totalCount\&quot;: 200,   \&quot;analysis\&quot;: {     \&quot;techniquesUsed\&quot;: \&quot;TYPO,UTFVARS\&quot;,     \&quot;baseDomain\&quot;: \&quot;google.com\&quot;,     \&quot;searchLimit\&quot;: 100   } }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds. Multiple techniques run in parallel.&lt;/p&gt;  &lt;h4&gt;Note:&lt;/h4&gt; &lt;p&gt;The &lt;code&gt;check_registration&lt;/code&gt;, &lt;code&gt;include_dns&lt;/code&gt;, and &lt;code&gt;include_risk_score&lt;/code&gt; options are not currently supported by the backend service and will be ignored.&lt;/p&gt; 
     * <p><b>202</b> - Similar domains job created successfully. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SimilarDomainsResponse object.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure.
     * <p><b>400</b> - Invalid domain or options.
     * <p><b>401</b> - Authentication failed.
     * @param similarDomainsOpsRequest Similar domains request with domain and options.
     * @return ResponseEntity&lt;SimilarDomainsResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<SimilarDomainsResponse>> similarDomainsWithHttpInfo(@jakarta.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
        ParameterizedTypeReference<SimilarDomainsResponse> localVarReturnType = new ParameterizedTypeReference<SimilarDomainsResponse>() {};
        return similarDomainsRequestCreation(similarDomainsOpsRequest).toEntity(localVarReturnType);
    }

    /**
     * Find Similar Domains (Asynchronous)
     * &lt;p&gt;Finds domains similar to the provided domain using various similarity detection techniques. This endpoint is useful for brand protection, typosquatting detection, and threat hunting.&lt;/p&gt;  &lt;h4&gt;Supported Techniques:&lt;/h4&gt; &lt;p&gt;Specify techniques in the &lt;code&gt;techniques&lt;/code&gt; array. If not specified, defaults to &lt;code&gt;typosquatting&lt;/code&gt;.&lt;/p&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;typosquatting&lt;/b&gt; - Keyboard proximity errors and common typos (e.g., gooogle.com, gogle.com)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;homoglyph&lt;/b&gt; - Visually similar Unicode characters (e.g., gооgle.com using Cyrillic &#39;о&#39;)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;tld_variation&lt;/b&gt; - Different TLD variations (e.g., google.net, google.org)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;sounding&lt;/b&gt; - Phonetically similar domains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;prefix&lt;/b&gt; - Domains starting with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;suffix&lt;/b&gt; - Domains ending with the target&lt;/li&gt;     &lt;li&gt;&lt;b&gt;contains&lt;/b&gt; - Domains containing the target as a substring&lt;/li&gt;     &lt;li&gt;&lt;b&gt;levenshtein&lt;/b&gt; - Edit distance similarity&lt;/li&gt; &lt;/ul&gt;  &lt;h4&gt;Example Request:&lt;/h4&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;techniques\&quot;: [\&quot;typosquatting\&quot;, \&quot;homoglyph\&quot;, \&quot;tld_variation\&quot;],   \&quot;limit\&quot;: 100 }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Poll &lt;code&gt;/v1/ops/jobs/{jobId}&lt;/code&gt; to get results. The result contains:&lt;/p&gt; &lt;pre&gt;&lt;code&gt;{   \&quot;domain\&quot;: \&quot;google.com\&quot;,   \&quot;status\&quot;: \&quot;completed\&quot;,   \&quot;similarDomains\&quot;: [     {\&quot;domain\&quot;: \&quot;gooogle.com\&quot;, \&quot;technique\&quot;: \&quot;TYPO\&quot;},     {\&quot;domain\&quot;: \&quot;gооgle.com\&quot;, \&quot;technique\&quot;: \&quot;UTFVARS\&quot;}   ],   \&quot;totalCount\&quot;: 200,   \&quot;analysis\&quot;: {     \&quot;techniquesUsed\&quot;: \&quot;TYPO,UTFVARS\&quot;,     \&quot;baseDomain\&quot;: \&quot;google.com\&quot;,     \&quot;searchLimit\&quot;: 100   } }&lt;/code&gt;&lt;/pre&gt;  &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Typically completes in 5-15 seconds. Multiple techniques run in parallel.&lt;/p&gt;  &lt;h4&gt;Note:&lt;/h4&gt; &lt;p&gt;The &lt;code&gt;check_registration&lt;/code&gt;, &lt;code&gt;include_dns&lt;/code&gt;, and &lt;code&gt;include_risk_score&lt;/code&gt; options are not currently supported by the backend service and will be ignored.&lt;/p&gt; 
     * <p><b>202</b> - Similar domains job created successfully. Poll GET /v1/ops/jobs/{jobId} to retrieve results. When completed, the job&#39;s &#x60;result&#x60; field contains a SimilarDomainsResponse object.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when status&#x3D;COMPLETED). This is NOT returned by this endpoint directly, but documents the final result structure.
     * <p><b>400</b> - Invalid domain or options.
     * <p><b>401</b> - Authentication failed.
     * @param similarDomainsOpsRequest Similar domains request with domain and options.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec similarDomainsWithResponseSpec(@jakarta.annotation.Nonnull SimilarDomainsOpsRequest similarDomainsOpsRequest) throws WebClientResponseException {
        return similarDomainsRequestCreation(similarDomainsOpsRequest);
    }
}
