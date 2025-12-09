package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.AttributeRequest;
import io.github.whispersec.model.AttributeResult;
import io.github.whispersec.model.BenchmarkResponse;
import io.github.whispersec.model.CorrelateRequest;
import io.github.whispersec.model.CorrelateResult;
import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.InvestigateRequest;
import io.github.whispersec.model.InvestigateResult;
import io.github.whispersec.model.JobResponse;
import io.github.whispersec.model.PivotRequest;
import io.github.whispersec.model.PivotResult;
import io.github.whispersec.model.SimilarCasesRequest;
import io.github.whispersec.model.SimilarCasesResult;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-09T20:30:47.422237154Z[Etc/UTC]", comments = "Generator version: 7.17.0")
public class AiIntelligenceApi {
    private ApiClient apiClient;

    public AiIntelligenceApi() {
        this(new ApiClient());
    }

    public AiIntelligenceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Threat Actor Attribution (Asynchronous)
     * &lt;p&gt;Analyzes indicators and context to identify potential threat actors and campaigns. Uses ML clustering and TTP matching against known threat actor profiles.&lt;/p&gt; &lt;h4&gt;Attribution Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Actor Identification:&lt;/b&gt; Potential threat actor matches with confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Clustering:&lt;/b&gt; Groups indicators into potential campaigns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;TTP Mapping:&lt;/b&gt; MITRE ATT&amp;CK technique mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Historical Context:&lt;/b&gt; Known actor activity patterns&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 500 indicators per request. Attribution is probabilistic and should be validated.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Campaign clustering and analysis. Expected: 60-300 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Attribution analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request or exceeds 500 indicator limit.
     * <p><b>401</b> - Authentication failed.
     * @param attributeRequest Attribution request
     * @return AttributeResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec aiAttributeRequestCreation(@jakarta.annotation.Nonnull AttributeRequest attributeRequest) throws WebClientResponseException {
        Object postBody = attributeRequest;
        // verify the required parameter 'attributeRequest' is set
        if (attributeRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'attributeRequest' when calling aiAttribute", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<AttributeResult> localVarReturnType = new ParameterizedTypeReference<AttributeResult>() {};
        return apiClient.invokeAPI("/v1/ops/ai/attribute", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Threat Actor Attribution (Asynchronous)
     * &lt;p&gt;Analyzes indicators and context to identify potential threat actors and campaigns. Uses ML clustering and TTP matching against known threat actor profiles.&lt;/p&gt; &lt;h4&gt;Attribution Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Actor Identification:&lt;/b&gt; Potential threat actor matches with confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Clustering:&lt;/b&gt; Groups indicators into potential campaigns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;TTP Mapping:&lt;/b&gt; MITRE ATT&amp;CK technique mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Historical Context:&lt;/b&gt; Known actor activity patterns&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 500 indicators per request. Attribution is probabilistic and should be validated.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Campaign clustering and analysis. Expected: 60-300 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Attribution analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request or exceeds 500 indicator limit.
     * <p><b>401</b> - Authentication failed.
     * @param attributeRequest Attribution request
     * @return AttributeResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<AttributeResult> aiAttribute(@jakarta.annotation.Nonnull AttributeRequest attributeRequest) throws WebClientResponseException {
        ParameterizedTypeReference<AttributeResult> localVarReturnType = new ParameterizedTypeReference<AttributeResult>() {};
        return aiAttributeRequestCreation(attributeRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Threat Actor Attribution (Asynchronous)
     * &lt;p&gt;Analyzes indicators and context to identify potential threat actors and campaigns. Uses ML clustering and TTP matching against known threat actor profiles.&lt;/p&gt; &lt;h4&gt;Attribution Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Actor Identification:&lt;/b&gt; Potential threat actor matches with confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Clustering:&lt;/b&gt; Groups indicators into potential campaigns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;TTP Mapping:&lt;/b&gt; MITRE ATT&amp;CK technique mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Historical Context:&lt;/b&gt; Known actor activity patterns&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 500 indicators per request. Attribution is probabilistic and should be validated.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Campaign clustering and analysis. Expected: 60-300 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Attribution analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request or exceeds 500 indicator limit.
     * <p><b>401</b> - Authentication failed.
     * @param attributeRequest Attribution request
     * @return ResponseEntity&lt;AttributeResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<AttributeResult>> aiAttributeWithHttpInfo(@jakarta.annotation.Nonnull AttributeRequest attributeRequest) throws WebClientResponseException {
        ParameterizedTypeReference<AttributeResult> localVarReturnType = new ParameterizedTypeReference<AttributeResult>() {};
        return aiAttributeRequestCreation(attributeRequest).toEntity(localVarReturnType);
    }

    /**
     * Threat Actor Attribution (Asynchronous)
     * &lt;p&gt;Analyzes indicators and context to identify potential threat actors and campaigns. Uses ML clustering and TTP matching against known threat actor profiles.&lt;/p&gt; &lt;h4&gt;Attribution Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Actor Identification:&lt;/b&gt; Potential threat actor matches with confidence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Clustering:&lt;/b&gt; Groups indicators into potential campaigns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;TTP Mapping:&lt;/b&gt; MITRE ATT&amp;CK technique mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Historical Context:&lt;/b&gt; Known actor activity patterns&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 500 indicators per request. Attribution is probabilistic and should be validated.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Campaign clustering and analysis. Expected: 60-300 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Attribution analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request or exceeds 500 indicator limit.
     * <p><b>401</b> - Authentication failed.
     * @param attributeRequest Attribution request
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec aiAttributeWithResponseSpec(@jakarta.annotation.Nonnull AttributeRequest attributeRequest) throws WebClientResponseException {
        return aiAttributeRequestCreation(attributeRequest);
    }

    /**
     * Global Indicator Correlation (Asynchronous)
     * &lt;p&gt;Correlates your indicators against anonymized global threat data from all customers. Identifies shared campaigns, widespread threats, and prevalence across industries.&lt;/p&gt; &lt;h4&gt;Correlation Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Prevalence:&lt;/b&gt; How common are these indicators across our customer base&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Industry Breakdown:&lt;/b&gt; Which industries are seeing these indicators&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Detection:&lt;/b&gt; Are these part of a broader campaign&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First/Last Seen:&lt;/b&gt; Global timeline of indicator activity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Co-occurrence:&lt;/b&gt; Indicators frequently seen together&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 100 indicators per request.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Cross-customer correlation. Expected: 10-60 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Correlation job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request or exceeds 100 indicator limit.
     * <p><b>401</b> - Authentication failed.
     * @param correlateRequest Correlation request
     * @return CorrelateResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec aiCorrelateRequestCreation(@jakarta.annotation.Nonnull CorrelateRequest correlateRequest) throws WebClientResponseException {
        Object postBody = correlateRequest;
        // verify the required parameter 'correlateRequest' is set
        if (correlateRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'correlateRequest' when calling aiCorrelate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<CorrelateResult> localVarReturnType = new ParameterizedTypeReference<CorrelateResult>() {};
        return apiClient.invokeAPI("/v1/ops/ai/correlate", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Global Indicator Correlation (Asynchronous)
     * &lt;p&gt;Correlates your indicators against anonymized global threat data from all customers. Identifies shared campaigns, widespread threats, and prevalence across industries.&lt;/p&gt; &lt;h4&gt;Correlation Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Prevalence:&lt;/b&gt; How common are these indicators across our customer base&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Industry Breakdown:&lt;/b&gt; Which industries are seeing these indicators&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Detection:&lt;/b&gt; Are these part of a broader campaign&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First/Last Seen:&lt;/b&gt; Global timeline of indicator activity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Co-occurrence:&lt;/b&gt; Indicators frequently seen together&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 100 indicators per request.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Cross-customer correlation. Expected: 10-60 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Correlation job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request or exceeds 100 indicator limit.
     * <p><b>401</b> - Authentication failed.
     * @param correlateRequest Correlation request
     * @return CorrelateResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CorrelateResult> aiCorrelate(@jakarta.annotation.Nonnull CorrelateRequest correlateRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CorrelateResult> localVarReturnType = new ParameterizedTypeReference<CorrelateResult>() {};
        return aiCorrelateRequestCreation(correlateRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Global Indicator Correlation (Asynchronous)
     * &lt;p&gt;Correlates your indicators against anonymized global threat data from all customers. Identifies shared campaigns, widespread threats, and prevalence across industries.&lt;/p&gt; &lt;h4&gt;Correlation Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Prevalence:&lt;/b&gt; How common are these indicators across our customer base&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Industry Breakdown:&lt;/b&gt; Which industries are seeing these indicators&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Detection:&lt;/b&gt; Are these part of a broader campaign&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First/Last Seen:&lt;/b&gt; Global timeline of indicator activity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Co-occurrence:&lt;/b&gt; Indicators frequently seen together&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 100 indicators per request.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Cross-customer correlation. Expected: 10-60 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Correlation job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request or exceeds 100 indicator limit.
     * <p><b>401</b> - Authentication failed.
     * @param correlateRequest Correlation request
     * @return ResponseEntity&lt;CorrelateResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<CorrelateResult>> aiCorrelateWithHttpInfo(@jakarta.annotation.Nonnull CorrelateRequest correlateRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CorrelateResult> localVarReturnType = new ParameterizedTypeReference<CorrelateResult>() {};
        return aiCorrelateRequestCreation(correlateRequest).toEntity(localVarReturnType);
    }

    /**
     * Global Indicator Correlation (Asynchronous)
     * &lt;p&gt;Correlates your indicators against anonymized global threat data from all customers. Identifies shared campaigns, widespread threats, and prevalence across industries.&lt;/p&gt; &lt;h4&gt;Correlation Analysis:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Prevalence:&lt;/b&gt; How common are these indicators across our customer base&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Industry Breakdown:&lt;/b&gt; Which industries are seeing these indicators&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Campaign Detection:&lt;/b&gt; Are these part of a broader campaign&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First/Last Seen:&lt;/b&gt; Global timeline of indicator activity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Co-occurrence:&lt;/b&gt; Indicators frequently seen together&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limitations:&lt;/h4&gt; &lt;p&gt;Maximum 100 indicators per request.&lt;/p&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Cross-customer correlation. Expected: 10-60 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Correlation job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request or exceeds 100 indicator limit.
     * <p><b>401</b> - Authentication failed.
     * @param correlateRequest Correlation request
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec aiCorrelateWithResponseSpec(@jakarta.annotation.Nonnull CorrelateRequest correlateRequest) throws WebClientResponseException {
        return aiCorrelateRequestCreation(correlateRequest);
    }

    /**
     * AI Threat Investigation (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive AI-powered threat investigation for an indicator. Uses large language models to analyze threat intelligence, generate insights, and provide actionable recommendations.&lt;/p&gt; &lt;h4&gt;Investigation Output:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Verdict:&lt;/b&gt; Threat assessment with confidence score&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timeline:&lt;/b&gt; Activity timeline reconstruction&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Analysis:&lt;/b&gt; Detailed findings from multiple data sources&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Related Indicators:&lt;/b&gt; Discovered related infrastructure&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Recommendations:&lt;/b&gt; Suggested response actions&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;LLM-based analysis. Expected completion: 30-180 seconds depending on complexity.&lt;/p&gt; 
     * <p><b>202</b> - Investigation job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param investigateRequest Investigation request. Required fields: - **indicator**: The IP, domain, or hash to investigate - **indicatorType**: Must be \&quot;ip\&quot;, \&quot;domain\&quot;, or \&quot;hash\&quot;  Optional fields: - **depth**: Investigation depth (\&quot;quick\&quot;, \&quot;standard\&quot;, \&quot;comprehensive\&quot;). Default: \&quot;standard\&quot; - **context**: Object with optional fields: hypothesis (string), relatedIndicators (array), timeRange (string) 
     * @return InvestigateResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec aiInvestigateRequestCreation(@jakarta.annotation.Nonnull InvestigateRequest investigateRequest) throws WebClientResponseException {
        Object postBody = investigateRequest;
        // verify the required parameter 'investigateRequest' is set
        if (investigateRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'investigateRequest' when calling aiInvestigate", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<InvestigateResult> localVarReturnType = new ParameterizedTypeReference<InvestigateResult>() {};
        return apiClient.invokeAPI("/v1/ops/ai/investigate", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * AI Threat Investigation (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive AI-powered threat investigation for an indicator. Uses large language models to analyze threat intelligence, generate insights, and provide actionable recommendations.&lt;/p&gt; &lt;h4&gt;Investigation Output:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Verdict:&lt;/b&gt; Threat assessment with confidence score&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timeline:&lt;/b&gt; Activity timeline reconstruction&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Analysis:&lt;/b&gt; Detailed findings from multiple data sources&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Related Indicators:&lt;/b&gt; Discovered related infrastructure&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Recommendations:&lt;/b&gt; Suggested response actions&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;LLM-based analysis. Expected completion: 30-180 seconds depending on complexity.&lt;/p&gt; 
     * <p><b>202</b> - Investigation job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param investigateRequest Investigation request. Required fields: - **indicator**: The IP, domain, or hash to investigate - **indicatorType**: Must be \&quot;ip\&quot;, \&quot;domain\&quot;, or \&quot;hash\&quot;  Optional fields: - **depth**: Investigation depth (\&quot;quick\&quot;, \&quot;standard\&quot;, \&quot;comprehensive\&quot;). Default: \&quot;standard\&quot; - **context**: Object with optional fields: hypothesis (string), relatedIndicators (array), timeRange (string) 
     * @return InvestigateResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvestigateResult> aiInvestigate(@jakarta.annotation.Nonnull InvestigateRequest investigateRequest) throws WebClientResponseException {
        ParameterizedTypeReference<InvestigateResult> localVarReturnType = new ParameterizedTypeReference<InvestigateResult>() {};
        return aiInvestigateRequestCreation(investigateRequest).bodyToMono(localVarReturnType);
    }

    /**
     * AI Threat Investigation (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive AI-powered threat investigation for an indicator. Uses large language models to analyze threat intelligence, generate insights, and provide actionable recommendations.&lt;/p&gt; &lt;h4&gt;Investigation Output:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Verdict:&lt;/b&gt; Threat assessment with confidence score&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timeline:&lt;/b&gt; Activity timeline reconstruction&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Analysis:&lt;/b&gt; Detailed findings from multiple data sources&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Related Indicators:&lt;/b&gt; Discovered related infrastructure&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Recommendations:&lt;/b&gt; Suggested response actions&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;LLM-based analysis. Expected completion: 30-180 seconds depending on complexity.&lt;/p&gt; 
     * <p><b>202</b> - Investigation job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param investigateRequest Investigation request. Required fields: - **indicator**: The IP, domain, or hash to investigate - **indicatorType**: Must be \&quot;ip\&quot;, \&quot;domain\&quot;, or \&quot;hash\&quot;  Optional fields: - **depth**: Investigation depth (\&quot;quick\&quot;, \&quot;standard\&quot;, \&quot;comprehensive\&quot;). Default: \&quot;standard\&quot; - **context**: Object with optional fields: hypothesis (string), relatedIndicators (array), timeRange (string) 
     * @return ResponseEntity&lt;InvestigateResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<InvestigateResult>> aiInvestigateWithHttpInfo(@jakarta.annotation.Nonnull InvestigateRequest investigateRequest) throws WebClientResponseException {
        ParameterizedTypeReference<InvestigateResult> localVarReturnType = new ParameterizedTypeReference<InvestigateResult>() {};
        return aiInvestigateRequestCreation(investigateRequest).toEntity(localVarReturnType);
    }

    /**
     * AI Threat Investigation (Asynchronous)
     * &lt;p&gt;Initiates a comprehensive AI-powered threat investigation for an indicator. Uses large language models to analyze threat intelligence, generate insights, and provide actionable recommendations.&lt;/p&gt; &lt;h4&gt;Investigation Output:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Verdict:&lt;/b&gt; Threat assessment with confidence score&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timeline:&lt;/b&gt; Activity timeline reconstruction&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Analysis:&lt;/b&gt; Detailed findings from multiple data sources&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Related Indicators:&lt;/b&gt; Discovered related infrastructure&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Recommendations:&lt;/b&gt; Suggested response actions&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;LLM-based analysis. Expected completion: 30-180 seconds depending on complexity.&lt;/p&gt; 
     * <p><b>202</b> - Investigation job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param investigateRequest Investigation request. Required fields: - **indicator**: The IP, domain, or hash to investigate - **indicatorType**: Must be \&quot;ip\&quot;, \&quot;domain\&quot;, or \&quot;hash\&quot;  Optional fields: - **depth**: Investigation depth (\&quot;quick\&quot;, \&quot;standard\&quot;, \&quot;comprehensive\&quot;). Default: \&quot;standard\&quot; - **context**: Object with optional fields: hypothesis (string), relatedIndicators (array), timeRange (string) 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec aiInvestigateWithResponseSpec(@jakarta.annotation.Nonnull InvestigateRequest investigateRequest) throws WebClientResponseException {
        return aiInvestigateRequestCreation(investigateRequest);
    }

    /**
     * AI Infrastructure Pivot (Asynchronous)
     * &lt;p&gt;Performs intelligent infrastructure pivoting starting from an indicator. Uses ML to identify the most relevant relationships and suggest investigation paths.&lt;/p&gt; &lt;h4&gt;Pivot Strategies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;infrastructure:&lt;/b&gt; Shared hosting, nameservers, certificates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;registration:&lt;/b&gt; Same registrant, registration patterns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;behavioral:&lt;/b&gt; Similar traffic patterns, communication&lt;/li&gt;     &lt;li&gt;&lt;b&gt;temporal:&lt;/b&gt; Co-occurrence within time windows&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Discovered related indicators with relevance scores&lt;/li&gt;     &lt;li&gt;Suggested investigation paths ranked by priority&lt;/li&gt;     &lt;li&gt;Relationship graph data&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Graph traversal with ML ranking. Expected: 10-120 seconds based on depth.&lt;/p&gt; 
     * <p><b>202</b> - Pivot analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param pivotRequest Pivot request
     * @return PivotResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec aiPivotRequestCreation(@jakarta.annotation.Nonnull PivotRequest pivotRequest) throws WebClientResponseException {
        Object postBody = pivotRequest;
        // verify the required parameter 'pivotRequest' is set
        if (pivotRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'pivotRequest' when calling aiPivot", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PivotResult> localVarReturnType = new ParameterizedTypeReference<PivotResult>() {};
        return apiClient.invokeAPI("/v1/ops/ai/pivot", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * AI Infrastructure Pivot (Asynchronous)
     * &lt;p&gt;Performs intelligent infrastructure pivoting starting from an indicator. Uses ML to identify the most relevant relationships and suggest investigation paths.&lt;/p&gt; &lt;h4&gt;Pivot Strategies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;infrastructure:&lt;/b&gt; Shared hosting, nameservers, certificates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;registration:&lt;/b&gt; Same registrant, registration patterns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;behavioral:&lt;/b&gt; Similar traffic patterns, communication&lt;/li&gt;     &lt;li&gt;&lt;b&gt;temporal:&lt;/b&gt; Co-occurrence within time windows&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Discovered related indicators with relevance scores&lt;/li&gt;     &lt;li&gt;Suggested investigation paths ranked by priority&lt;/li&gt;     &lt;li&gt;Relationship graph data&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Graph traversal with ML ranking. Expected: 10-120 seconds based on depth.&lt;/p&gt; 
     * <p><b>202</b> - Pivot analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param pivotRequest Pivot request
     * @return PivotResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PivotResult> aiPivot(@jakarta.annotation.Nonnull PivotRequest pivotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PivotResult> localVarReturnType = new ParameterizedTypeReference<PivotResult>() {};
        return aiPivotRequestCreation(pivotRequest).bodyToMono(localVarReturnType);
    }

    /**
     * AI Infrastructure Pivot (Asynchronous)
     * &lt;p&gt;Performs intelligent infrastructure pivoting starting from an indicator. Uses ML to identify the most relevant relationships and suggest investigation paths.&lt;/p&gt; &lt;h4&gt;Pivot Strategies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;infrastructure:&lt;/b&gt; Shared hosting, nameservers, certificates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;registration:&lt;/b&gt; Same registrant, registration patterns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;behavioral:&lt;/b&gt; Similar traffic patterns, communication&lt;/li&gt;     &lt;li&gt;&lt;b&gt;temporal:&lt;/b&gt; Co-occurrence within time windows&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Discovered related indicators with relevance scores&lt;/li&gt;     &lt;li&gt;Suggested investigation paths ranked by priority&lt;/li&gt;     &lt;li&gt;Relationship graph data&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Graph traversal with ML ranking. Expected: 10-120 seconds based on depth.&lt;/p&gt; 
     * <p><b>202</b> - Pivot analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param pivotRequest Pivot request
     * @return ResponseEntity&lt;PivotResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PivotResult>> aiPivotWithHttpInfo(@jakarta.annotation.Nonnull PivotRequest pivotRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PivotResult> localVarReturnType = new ParameterizedTypeReference<PivotResult>() {};
        return aiPivotRequestCreation(pivotRequest).toEntity(localVarReturnType);
    }

    /**
     * AI Infrastructure Pivot (Asynchronous)
     * &lt;p&gt;Performs intelligent infrastructure pivoting starting from an indicator. Uses ML to identify the most relevant relationships and suggest investigation paths.&lt;/p&gt; &lt;h4&gt;Pivot Strategies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;infrastructure:&lt;/b&gt; Shared hosting, nameservers, certificates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;registration:&lt;/b&gt; Same registrant, registration patterns&lt;/li&gt;     &lt;li&gt;&lt;b&gt;behavioral:&lt;/b&gt; Similar traffic patterns, communication&lt;/li&gt;     &lt;li&gt;&lt;b&gt;temporal:&lt;/b&gt; Co-occurrence within time windows&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Discovered related indicators with relevance scores&lt;/li&gt;     &lt;li&gt;Suggested investigation paths ranked by priority&lt;/li&gt;     &lt;li&gt;Relationship graph data&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Graph traversal with ML ranking. Expected: 10-120 seconds based on depth.&lt;/p&gt; 
     * <p><b>202</b> - Pivot analysis job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param pivotRequest Pivot request
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec aiPivotWithResponseSpec(@jakarta.annotation.Nonnull PivotRequest pivotRequest) throws WebClientResponseException {
        return aiPivotRequestCreation(pivotRequest);
    }

    /**
     * Find Similar Cases (Asynchronous)
     * &lt;p&gt;Uses ML to find historical threat cases similar to the current investigation. Helps analysts understand attack patterns and expected outcomes.&lt;/p&gt; &lt;h4&gt;Matching Criteria:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Indicator overlap and relationships&lt;/li&gt;     &lt;li&gt;Behavioral patterns and TTPs&lt;/li&gt;     &lt;li&gt;Infrastructure characteristics&lt;/li&gt;     &lt;li&gt;Attack progression similarities&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;Case outcomes and verdicts&lt;/li&gt;     &lt;li&gt;Common patterns across matches&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;ML similarity matching. Expected completion: 5-30 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Similar cases search job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param similarCasesRequest Similar cases request
     * @return SimilarCasesResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec findSimilarCasesRequestCreation(@jakarta.annotation.Nonnull SimilarCasesRequest similarCasesRequest) throws WebClientResponseException {
        Object postBody = similarCasesRequest;
        // verify the required parameter 'similarCasesRequest' is set
        if (similarCasesRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'similarCasesRequest' when calling findSimilarCases", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<SimilarCasesResult> localVarReturnType = new ParameterizedTypeReference<SimilarCasesResult>() {};
        return apiClient.invokeAPI("/v1/ops/ai/similar-cases", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Find Similar Cases (Asynchronous)
     * &lt;p&gt;Uses ML to find historical threat cases similar to the current investigation. Helps analysts understand attack patterns and expected outcomes.&lt;/p&gt; &lt;h4&gt;Matching Criteria:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Indicator overlap and relationships&lt;/li&gt;     &lt;li&gt;Behavioral patterns and TTPs&lt;/li&gt;     &lt;li&gt;Infrastructure characteristics&lt;/li&gt;     &lt;li&gt;Attack progression similarities&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;Case outcomes and verdicts&lt;/li&gt;     &lt;li&gt;Common patterns across matches&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;ML similarity matching. Expected completion: 5-30 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Similar cases search job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param similarCasesRequest Similar cases request
     * @return SimilarCasesResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SimilarCasesResult> findSimilarCases(@jakarta.annotation.Nonnull SimilarCasesRequest similarCasesRequest) throws WebClientResponseException {
        ParameterizedTypeReference<SimilarCasesResult> localVarReturnType = new ParameterizedTypeReference<SimilarCasesResult>() {};
        return findSimilarCasesRequestCreation(similarCasesRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Find Similar Cases (Asynchronous)
     * &lt;p&gt;Uses ML to find historical threat cases similar to the current investigation. Helps analysts understand attack patterns and expected outcomes.&lt;/p&gt; &lt;h4&gt;Matching Criteria:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Indicator overlap and relationships&lt;/li&gt;     &lt;li&gt;Behavioral patterns and TTPs&lt;/li&gt;     &lt;li&gt;Infrastructure characteristics&lt;/li&gt;     &lt;li&gt;Attack progression similarities&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;Case outcomes and verdicts&lt;/li&gt;     &lt;li&gt;Common patterns across matches&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;ML similarity matching. Expected completion: 5-30 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Similar cases search job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param similarCasesRequest Similar cases request
     * @return ResponseEntity&lt;SimilarCasesResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<SimilarCasesResult>> findSimilarCasesWithHttpInfo(@jakarta.annotation.Nonnull SimilarCasesRequest similarCasesRequest) throws WebClientResponseException {
        ParameterizedTypeReference<SimilarCasesResult> localVarReturnType = new ParameterizedTypeReference<SimilarCasesResult>() {};
        return findSimilarCasesRequestCreation(similarCasesRequest).toEntity(localVarReturnType);
    }

    /**
     * Find Similar Cases (Asynchronous)
     * &lt;p&gt;Uses ML to find historical threat cases similar to the current investigation. Helps analysts understand attack patterns and expected outcomes.&lt;/p&gt; &lt;h4&gt;Matching Criteria:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Indicator overlap and relationships&lt;/li&gt;     &lt;li&gt;Behavioral patterns and TTPs&lt;/li&gt;     &lt;li&gt;Infrastructure characteristics&lt;/li&gt;     &lt;li&gt;Attack progression similarities&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;Case outcomes and verdicts&lt;/li&gt;     &lt;li&gt;Common patterns across matches&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;ML similarity matching. Expected completion: 5-30 seconds.&lt;/p&gt; 
     * <p><b>202</b> - Similar cases search job accepted. Poll GET /v1/ops/jobs/{jobId} for results.
     * <p><b>200</b> - Job result schema (returned via GET /v1/ops/jobs/{jobId} when job completes)
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Authentication failed.
     * @param similarCasesRequest Similar cases request
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec findSimilarCasesWithResponseSpec(@jakarta.annotation.Nonnull SimilarCasesRequest similarCasesRequest) throws WebClientResponseException {
        return findSimilarCasesRequestCreation(similarCasesRequest);
    }

    /**
     * Get Industry Security Benchmark (Synchronous)
     * &lt;p&gt;Returns anonymized, aggregated security metrics for your industry vertical. Compare your security posture against peers.&lt;/p&gt; &lt;h4&gt;Available Industries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;financial_services, healthcare, technology, retail, manufacturing&lt;/li&gt;     &lt;li&gt;energy, telecommunications, government, education, media&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Risk Scores:&lt;/b&gt; Average risk score, percentiles (25th, 50th, 75th, 90th)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Response Metrics:&lt;/b&gt; Mean time to detect (MTTD), mean time to respond (MTTR)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Detection Metrics:&lt;/b&gt; Detection rate, false positive rate&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Threat Profile:&lt;/b&gt; Top threats, common attack vectors, targeted assets&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trends:&lt;/b&gt; 30-day risk trend direction and change percentage&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-aggregated data. Response time typically under 500ms with 1-hour cache.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved industry benchmark.
     * <p><b>400</b> - Invalid industry code.
     * <p><b>401</b> - Authentication failed.
     * @param industry Industry vertical code
     * @param size Organization size filter. Compares against organizations of similar size.
     * @param region Geographic region filter. Compares against organizations in the same region.
     * @return BenchmarkResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getIndustryBenchmarkRequestCreation(@jakarta.annotation.Nonnull String industry, @jakarta.annotation.Nullable String size, @jakarta.annotation.Nullable String region) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'industry' is set
        if (industry == null) {
            throw new WebClientResponseException("Missing the required parameter 'industry' when calling getIndustryBenchmark", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("industry", industry);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "region", region));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<BenchmarkResponse> localVarReturnType = new ParameterizedTypeReference<BenchmarkResponse>() {};
        return apiClient.invokeAPI("/v1/ops/ai/benchmark/{industry}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Industry Security Benchmark (Synchronous)
     * &lt;p&gt;Returns anonymized, aggregated security metrics for your industry vertical. Compare your security posture against peers.&lt;/p&gt; &lt;h4&gt;Available Industries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;financial_services, healthcare, technology, retail, manufacturing&lt;/li&gt;     &lt;li&gt;energy, telecommunications, government, education, media&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Risk Scores:&lt;/b&gt; Average risk score, percentiles (25th, 50th, 75th, 90th)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Response Metrics:&lt;/b&gt; Mean time to detect (MTTD), mean time to respond (MTTR)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Detection Metrics:&lt;/b&gt; Detection rate, false positive rate&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Threat Profile:&lt;/b&gt; Top threats, common attack vectors, targeted assets&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trends:&lt;/b&gt; 30-day risk trend direction and change percentage&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-aggregated data. Response time typically under 500ms with 1-hour cache.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved industry benchmark.
     * <p><b>400</b> - Invalid industry code.
     * <p><b>401</b> - Authentication failed.
     * @param industry Industry vertical code
     * @param size Organization size filter. Compares against organizations of similar size.
     * @param region Geographic region filter. Compares against organizations in the same region.
     * @return BenchmarkResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<BenchmarkResponse> getIndustryBenchmark(@jakarta.annotation.Nonnull String industry, @jakarta.annotation.Nullable String size, @jakarta.annotation.Nullable String region) throws WebClientResponseException {
        ParameterizedTypeReference<BenchmarkResponse> localVarReturnType = new ParameterizedTypeReference<BenchmarkResponse>() {};
        return getIndustryBenchmarkRequestCreation(industry, size, region).bodyToMono(localVarReturnType);
    }

    /**
     * Get Industry Security Benchmark (Synchronous)
     * &lt;p&gt;Returns anonymized, aggregated security metrics for your industry vertical. Compare your security posture against peers.&lt;/p&gt; &lt;h4&gt;Available Industries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;financial_services, healthcare, technology, retail, manufacturing&lt;/li&gt;     &lt;li&gt;energy, telecommunications, government, education, media&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Risk Scores:&lt;/b&gt; Average risk score, percentiles (25th, 50th, 75th, 90th)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Response Metrics:&lt;/b&gt; Mean time to detect (MTTD), mean time to respond (MTTR)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Detection Metrics:&lt;/b&gt; Detection rate, false positive rate&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Threat Profile:&lt;/b&gt; Top threats, common attack vectors, targeted assets&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trends:&lt;/b&gt; 30-day risk trend direction and change percentage&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-aggregated data. Response time typically under 500ms with 1-hour cache.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved industry benchmark.
     * <p><b>400</b> - Invalid industry code.
     * <p><b>401</b> - Authentication failed.
     * @param industry Industry vertical code
     * @param size Organization size filter. Compares against organizations of similar size.
     * @param region Geographic region filter. Compares against organizations in the same region.
     * @return ResponseEntity&lt;BenchmarkResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<BenchmarkResponse>> getIndustryBenchmarkWithHttpInfo(@jakarta.annotation.Nonnull String industry, @jakarta.annotation.Nullable String size, @jakarta.annotation.Nullable String region) throws WebClientResponseException {
        ParameterizedTypeReference<BenchmarkResponse> localVarReturnType = new ParameterizedTypeReference<BenchmarkResponse>() {};
        return getIndustryBenchmarkRequestCreation(industry, size, region).toEntity(localVarReturnType);
    }

    /**
     * Get Industry Security Benchmark (Synchronous)
     * &lt;p&gt;Returns anonymized, aggregated security metrics for your industry vertical. Compare your security posture against peers.&lt;/p&gt; &lt;h4&gt;Available Industries:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;financial_services, healthcare, technology, retail, manufacturing&lt;/li&gt;     &lt;li&gt;energy, telecommunications, government, education, media&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Metrics Included:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Risk Scores:&lt;/b&gt; Average risk score, percentiles (25th, 50th, 75th, 90th)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Response Metrics:&lt;/b&gt; Mean time to detect (MTTD), mean time to respond (MTTR)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Detection Metrics:&lt;/b&gt; Detection rate, false positive rate&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Threat Profile:&lt;/b&gt; Top threats, common attack vectors, targeted assets&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Trends:&lt;/b&gt; 30-day risk trend direction and change percentage&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;p&gt;Pre-aggregated data. Response time typically under 500ms with 1-hour cache.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved industry benchmark.
     * <p><b>400</b> - Invalid industry code.
     * <p><b>401</b> - Authentication failed.
     * @param industry Industry vertical code
     * @param size Organization size filter. Compares against organizations of similar size.
     * @param region Geographic region filter. Compares against organizations in the same region.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getIndustryBenchmarkWithResponseSpec(@jakarta.annotation.Nonnull String industry, @jakarta.annotation.Nullable String size, @jakarta.annotation.Nullable String region) throws WebClientResponseException {
        return getIndustryBenchmarkRequestCreation(industry, size, region);
    }
}
