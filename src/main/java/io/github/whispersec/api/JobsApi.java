package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.Job;
import io.github.whispersec.model.JobListResponse;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-12T20:10:38.516211554Z[Etc/UTC]", comments = "Generator version: 7.17.0")
public class JobsApi {
    private ApiClient apiClient;

    public JobsApi() {
        this(new ApiClient());
    }

    public JobsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Asynchronous Job Status and Results
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Schemas by Job Type:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;ai-investigate:&lt;/b&gt; InvestigateResult - verdict, timeline, analysis, recommendations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-pivot:&lt;/b&gt; PivotResult - related indicators, investigation paths, relationship graph&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-attribute:&lt;/b&gt; AttributeResult - actor identification, campaign clustering, TTP mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-correlate:&lt;/b&gt; CorrelateResult - prevalence, industry breakdown, co-occurrence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-similar-cases:&lt;/b&gt; SimilarCasesResult - similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;&lt;b&gt;screenshot:&lt;/b&gt; ScreenshotResult - screenshot URL, ID, capture time, metadata&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Job ID not found.
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
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Schemas by Job Type:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;ai-investigate:&lt;/b&gt; InvestigateResult - verdict, timeline, analysis, recommendations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-pivot:&lt;/b&gt; PivotResult - related indicators, investigation paths, relationship graph&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-attribute:&lt;/b&gt; AttributeResult - actor identification, campaign clustering, TTP mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-correlate:&lt;/b&gt; CorrelateResult - prevalence, industry breakdown, co-occurrence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-similar-cases:&lt;/b&gt; SimilarCasesResult - similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;&lt;b&gt;screenshot:&lt;/b&gt; ScreenshotResult - screenshot URL, ID, capture time, metadata&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Job ID not found.
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
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Schemas by Job Type:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;ai-investigate:&lt;/b&gt; InvestigateResult - verdict, timeline, analysis, recommendations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-pivot:&lt;/b&gt; PivotResult - related indicators, investigation paths, relationship graph&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-attribute:&lt;/b&gt; AttributeResult - actor identification, campaign clustering, TTP mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-correlate:&lt;/b&gt; CorrelateResult - prevalence, industry breakdown, co-occurrence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-similar-cases:&lt;/b&gt; SimilarCasesResult - similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;&lt;b&gt;screenshot:&lt;/b&gt; ScreenshotResult - screenshot URL, ID, capture time, metadata&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Job ID not found.
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
     * &lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Schemas by Job Type:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;ai-investigate:&lt;/b&gt; InvestigateResult - verdict, timeline, analysis, recommendations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-pivot:&lt;/b&gt; PivotResult - related indicators, investigation paths, relationship graph&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-attribute:&lt;/b&gt; AttributeResult - actor identification, campaign clustering, TTP mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-correlate:&lt;/b&gt; CorrelateResult - prevalence, industry breakdown, co-occurrence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-similar-cases:&lt;/b&gt; SimilarCasesResult - similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;&lt;b&gt;screenshot:&lt;/b&gt; ScreenshotResult - screenshot URL, ID, capture time, metadata&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Job status and results retrieved successfully.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Job ID not found.
     * @param jobId The unique ID of the job, returned from a &#x60;POST&#x60; operation.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getJobWithResponseSpec(@jakarta.annotation.Nonnull String jobId) throws WebClientResponseException {
        return getJobRequestCreation(jobId);
    }

    /**
     * List Recent Jobs
     * &lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved job list.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param status Filter by job status
     * @param limit Maximum number of jobs to return
     * @param offset Number of jobs to skip
     * @return JobListResponse
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

        ParameterizedTypeReference<JobListResponse> localVarReturnType = new ParameterizedTypeReference<JobListResponse>() {};
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
     * @return JobListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobListResponse> listJobs(@jakarta.annotation.Nullable String status, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable Integer offset) throws WebClientResponseException {
        ParameterizedTypeReference<JobListResponse> localVarReturnType = new ParameterizedTypeReference<JobListResponse>() {};
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
     * @return ResponseEntity&lt;JobListResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobListResponse>> listJobsWithHttpInfo(@jakarta.annotation.Nullable String status, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable Integer offset) throws WebClientResponseException {
        ParameterizedTypeReference<JobListResponse> localVarReturnType = new ParameterizedTypeReference<JobListResponse>() {};
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
    public ResponseSpec listJobsWithResponseSpec(@jakarta.annotation.Nullable String status, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable Integer offset) throws WebClientResponseException {
        return listJobsRequestCreation(status, limit, offset);
    }
}
