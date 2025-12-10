package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.JobResponse;
import io.github.whispersec.model.ScreenshotHistoryResponse;
import io.github.whispersec.model.ScreenshotRequest;
import io.github.whispersec.model.ScreenshotSchedule;
import io.github.whispersec.model.ScreenshotScheduleListResponse;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-10T22:42:39.717340328Z[Etc/UTC]", comments = "Generator version: 7.17.0")
public class ScreenshotsApi {
    private ApiClient apiClient;

    public ScreenshotsApi() {
        this(new ApiClient());
    }

    public ScreenshotsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Clear Screenshot History
     * &lt;p&gt;Delete all captured screenshots for a schedule while keeping the schedule active.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All screenshots will be permanently deleted.&lt;/p&gt; 
     * <p><b>200</b> - Screenshot history successfully cleared.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec clearScreenshotHistoryRequestCreation(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'scheduleId' is set
        if (scheduleId == null) {
            throw new WebClientResponseException("Missing the required parameter 'scheduleId' when calling clearScreenshotHistory", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("scheduleId", scheduleId);

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

        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/v1/ops/screenshots/schedules/{scheduleId}/history", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Clear Screenshot History
     * &lt;p&gt;Delete all captured screenshots for a schedule while keeping the schedule active.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All screenshots will be permanently deleted.&lt;/p&gt; 
     * <p><b>200</b> - Screenshot history successfully cleared.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Object> clearScreenshotHistory(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return clearScreenshotHistoryRequestCreation(scheduleId).bodyToMono(localVarReturnType);
    }

    /**
     * Clear Screenshot History
     * &lt;p&gt;Delete all captured screenshots for a schedule while keeping the schedule active.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All screenshots will be permanently deleted.&lt;/p&gt; 
     * <p><b>200</b> - Screenshot history successfully cleared.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID
     * @return ResponseEntity&lt;Object&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Object>> clearScreenshotHistoryWithHttpInfo(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return clearScreenshotHistoryRequestCreation(scheduleId).toEntity(localVarReturnType);
    }

    /**
     * Clear Screenshot History
     * &lt;p&gt;Delete all captured screenshots for a schedule while keeping the schedule active.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All screenshots will be permanently deleted.&lt;/p&gt; 
     * <p><b>200</b> - Screenshot history successfully cleared.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec clearScreenshotHistoryWithResponseSpec(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        return clearScreenshotHistoryRequestCreation(scheduleId);
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
     * Delete Screenshot Schedule
     * &lt;p&gt;Delete a scheduled screenshot configuration and optionally all its captured screenshots.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All associated screenshots will be permanently deleted.&lt;/p&gt; 
     * <p><b>200</b> - Schedule successfully deleted.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID to delete
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteScreenshotScheduleRequestCreation(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'scheduleId' is set
        if (scheduleId == null) {
            throw new WebClientResponseException("Missing the required parameter 'scheduleId' when calling deleteScreenshotSchedule", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("scheduleId", scheduleId);

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

        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/v1/ops/screenshots/schedules/{scheduleId}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete Screenshot Schedule
     * &lt;p&gt;Delete a scheduled screenshot configuration and optionally all its captured screenshots.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All associated screenshots will be permanently deleted.&lt;/p&gt; 
     * <p><b>200</b> - Schedule successfully deleted.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID to delete
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Object> deleteScreenshotSchedule(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return deleteScreenshotScheduleRequestCreation(scheduleId).bodyToMono(localVarReturnType);
    }

    /**
     * Delete Screenshot Schedule
     * &lt;p&gt;Delete a scheduled screenshot configuration and optionally all its captured screenshots.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All associated screenshots will be permanently deleted.&lt;/p&gt; 
     * <p><b>200</b> - Schedule successfully deleted.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID to delete
     * @return ResponseEntity&lt;Object&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Object>> deleteScreenshotScheduleWithHttpInfo(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return deleteScreenshotScheduleRequestCreation(scheduleId).toEntity(localVarReturnType);
    }

    /**
     * Delete Screenshot Schedule
     * &lt;p&gt;Delete a scheduled screenshot configuration and optionally all its captured screenshots.&lt;/p&gt; &lt;p&gt;&lt;b&gt;Warning:&lt;/b&gt; This action cannot be undone. All associated screenshots will be permanently deleted.&lt;/p&gt; 
     * <p><b>200</b> - Schedule successfully deleted.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID to delete
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteScreenshotScheduleWithResponseSpec(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        return deleteScreenshotScheduleRequestCreation(scheduleId);
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
     * @return ScreenshotHistoryResponse
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

        ParameterizedTypeReference<ScreenshotHistoryResponse> localVarReturnType = new ParameterizedTypeReference<ScreenshotHistoryResponse>() {};
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
     * @return ScreenshotHistoryResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ScreenshotHistoryResponse> getScreenshotHistory(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<ScreenshotHistoryResponse> localVarReturnType = new ParameterizedTypeReference<ScreenshotHistoryResponse>() {};
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
     * @return ResponseEntity&lt;ScreenshotHistoryResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ScreenshotHistoryResponse>> getScreenshotHistoryWithHttpInfo(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<ScreenshotHistoryResponse> localVarReturnType = new ParameterizedTypeReference<ScreenshotHistoryResponse>() {};
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
     * Get Screenshot Schedule Details
     * &lt;p&gt;Retrieve details for a specific screenshot schedule including configuration and capture history.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved schedule details.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID
     * @return ScreenshotSchedule
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getScreenshotScheduleRequestCreation(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'scheduleId' is set
        if (scheduleId == null) {
            throw new WebClientResponseException("Missing the required parameter 'scheduleId' when calling getScreenshotSchedule", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("scheduleId", scheduleId);

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

        ParameterizedTypeReference<ScreenshotSchedule> localVarReturnType = new ParameterizedTypeReference<ScreenshotSchedule>() {};
        return apiClient.invokeAPI("/v1/ops/screenshots/schedules/{scheduleId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Screenshot Schedule Details
     * &lt;p&gt;Retrieve details for a specific screenshot schedule including configuration and capture history.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved schedule details.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID
     * @return ScreenshotSchedule
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ScreenshotSchedule> getScreenshotSchedule(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        ParameterizedTypeReference<ScreenshotSchedule> localVarReturnType = new ParameterizedTypeReference<ScreenshotSchedule>() {};
        return getScreenshotScheduleRequestCreation(scheduleId).bodyToMono(localVarReturnType);
    }

    /**
     * Get Screenshot Schedule Details
     * &lt;p&gt;Retrieve details for a specific screenshot schedule including configuration and capture history.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved schedule details.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID
     * @return ResponseEntity&lt;ScreenshotSchedule&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ScreenshotSchedule>> getScreenshotScheduleWithHttpInfo(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        ParameterizedTypeReference<ScreenshotSchedule> localVarReturnType = new ParameterizedTypeReference<ScreenshotSchedule>() {};
        return getScreenshotScheduleRequestCreation(scheduleId).toEntity(localVarReturnType);
    }

    /**
     * Get Screenshot Schedule Details
     * &lt;p&gt;Retrieve details for a specific screenshot schedule including configuration and capture history.&lt;/p&gt; 
     * <p><b>200</b> - Successfully retrieved schedule details.
     * <p><b>404</b> - Schedule not found or does not belong to your API key.
     * @param scheduleId The schedule ID
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getScreenshotScheduleWithResponseSpec(@jakarta.annotation.Nonnull String scheduleId) throws WebClientResponseException {
        return getScreenshotScheduleRequestCreation(scheduleId);
    }

    /**
     * List Screenshot Schedules
     * &lt;p&gt;Retrieve all scheduled screenshot configurations for your API key. Each API key can have a maximum of 3 active schedules.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Schedule ID:&lt;/b&gt; Unique identifier for the schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;URL:&lt;/b&gt; Target website being captured&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency:&lt;/b&gt; How often screenshots are taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Next Capture:&lt;/b&gt; When the next screenshot will be taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Count:&lt;/b&gt; Total screenshots taken by this schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Status:&lt;/b&gt; Whether the schedule is enabled or paused&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved schedule list.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @return ScreenshotScheduleListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listScreenshotSchedulesRequestCreation() throws WebClientResponseException {
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

        ParameterizedTypeReference<ScreenshotScheduleListResponse> localVarReturnType = new ParameterizedTypeReference<ScreenshotScheduleListResponse>() {};
        return apiClient.invokeAPI("/v1/ops/screenshots/schedules", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Screenshot Schedules
     * &lt;p&gt;Retrieve all scheduled screenshot configurations for your API key. Each API key can have a maximum of 3 active schedules.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Schedule ID:&lt;/b&gt; Unique identifier for the schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;URL:&lt;/b&gt; Target website being captured&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency:&lt;/b&gt; How often screenshots are taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Next Capture:&lt;/b&gt; When the next screenshot will be taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Count:&lt;/b&gt; Total screenshots taken by this schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Status:&lt;/b&gt; Whether the schedule is enabled or paused&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved schedule list.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @return ScreenshotScheduleListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ScreenshotScheduleListResponse> listScreenshotSchedules() throws WebClientResponseException {
        ParameterizedTypeReference<ScreenshotScheduleListResponse> localVarReturnType = new ParameterizedTypeReference<ScreenshotScheduleListResponse>() {};
        return listScreenshotSchedulesRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * List Screenshot Schedules
     * &lt;p&gt;Retrieve all scheduled screenshot configurations for your API key. Each API key can have a maximum of 3 active schedules.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Schedule ID:&lt;/b&gt; Unique identifier for the schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;URL:&lt;/b&gt; Target website being captured&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency:&lt;/b&gt; How often screenshots are taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Next Capture:&lt;/b&gt; When the next screenshot will be taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Count:&lt;/b&gt; Total screenshots taken by this schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Status:&lt;/b&gt; Whether the schedule is enabled or paused&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved schedule list.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @return ResponseEntity&lt;ScreenshotScheduleListResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ScreenshotScheduleListResponse>> listScreenshotSchedulesWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<ScreenshotScheduleListResponse> localVarReturnType = new ParameterizedTypeReference<ScreenshotScheduleListResponse>() {};
        return listScreenshotSchedulesRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * List Screenshot Schedules
     * &lt;p&gt;Retrieve all scheduled screenshot configurations for your API key. Each API key can have a maximum of 3 active schedules.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Schedule ID:&lt;/b&gt; Unique identifier for the schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;URL:&lt;/b&gt; Target website being captured&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency:&lt;/b&gt; How often screenshots are taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Next Capture:&lt;/b&gt; When the next screenshot will be taken&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Capture Count:&lt;/b&gt; Total screenshots taken by this schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Status:&lt;/b&gt; Whether the schedule is enabled or paused&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved schedule list.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec listScreenshotSchedulesWithResponseSpec() throws WebClientResponseException {
        return listScreenshotSchedulesRequestCreation();
    }

    /**
     * Schedule Recurring Screenshots (Asynchronous)
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, every_6_hours, every_12_hours, twice_daily, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling (default: UTC)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;First Screenshot:&lt;/h4&gt; &lt;p&gt;The &lt;b&gt;first screenshot is captured immediately&lt;/b&gt; when a schedule is created. Subsequent screenshots follow the configured schedule. This ensures you have baseline data right away.&lt;/p&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Retention:&lt;/b&gt; Individual screenshots expire after 14 days&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First Screenshot:&lt;/b&gt; Triggered immediately on schedule creation&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Management:&lt;/h4&gt; &lt;p&gt;Use &lt;code&gt;GET /v1/ops/screenshots/schedules&lt;/code&gt; to list schedules, &lt;code&gt;DELETE /v1/ops/screenshots/schedules/{id}&lt;/code&gt; to delete.&lt;/p&gt; 
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, every_6_hours, every_12_hours, twice_daily, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling (default: UTC)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;First Screenshot:&lt;/h4&gt; &lt;p&gt;The &lt;b&gt;first screenshot is captured immediately&lt;/b&gt; when a schedule is created. Subsequent screenshots follow the configured schedule. This ensures you have baseline data right away.&lt;/p&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Retention:&lt;/b&gt; Individual screenshots expire after 14 days&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First Screenshot:&lt;/b&gt; Triggered immediately on schedule creation&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Management:&lt;/h4&gt; &lt;p&gt;Use &lt;code&gt;GET /v1/ops/screenshots/schedules&lt;/code&gt; to list schedules, &lt;code&gt;DELETE /v1/ops/screenshots/schedules/{id}&lt;/code&gt; to delete.&lt;/p&gt; 
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, every_6_hours, every_12_hours, twice_daily, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling (default: UTC)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;First Screenshot:&lt;/h4&gt; &lt;p&gt;The &lt;b&gt;first screenshot is captured immediately&lt;/b&gt; when a schedule is created. Subsequent screenshots follow the configured schedule. This ensures you have baseline data right away.&lt;/p&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Retention:&lt;/b&gt; Individual screenshots expire after 14 days&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First Screenshot:&lt;/b&gt; Triggered immediately on schedule creation&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Management:&lt;/h4&gt; &lt;p&gt;Use &lt;code&gt;GET /v1/ops/screenshots/schedules&lt;/code&gt; to list schedules, &lt;code&gt;DELETE /v1/ops/screenshots/schedules/{id}&lt;/code&gt; to delete.&lt;/p&gt; 
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * &lt;p&gt;Create a recurring job to capture website screenshots at regular intervals. Essential for monitoring website changes, detecting defacements, and tracking competitor updates.&lt;/p&gt; &lt;h4&gt;Schedule Options:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Cron Expression:&lt;/b&gt; Full cron syntax support (e.g., &#x60;0 0 * * * *&#x60; &#x3D; hourly)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Frequency Presets:&lt;/b&gt; hourly, every_6_hours, every_12_hours, twice_daily, daily, weekly, monthly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Timezone:&lt;/b&gt; Specify timezone for accurate scheduling (default: UTC)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;First Screenshot:&lt;/h4&gt; &lt;p&gt;The &lt;b&gt;first screenshot is captured immediately&lt;/b&gt; when a schedule is created. Subsequent screenshots follow the configured schedule. This ensures you have baseline data right away.&lt;/p&gt; &lt;h4&gt;Limits:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Max Schedules:&lt;/b&gt; 3 per API key&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Max Screenshots:&lt;/b&gt; 50 retained per schedule (oldest deleted automatically)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Schedule Expiration:&lt;/b&gt; Schedules auto-expire after 90 days of inactivity&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Retention:&lt;/b&gt; Individual screenshots expire after 14 days&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Performance:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;Setup Time:&lt;/b&gt; ~2 seconds to create schedule&lt;/li&gt;     &lt;li&gt;&lt;b&gt;First Screenshot:&lt;/b&gt; Triggered immediately on schedule creation&lt;/li&gt;     &lt;li&gt;&lt;b&gt;Screenshot Time:&lt;/b&gt; 10-30 seconds per capture&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Use Cases:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Automated defacement detection&lt;/li&gt;     &lt;li&gt;Compliance monitoring and archival&lt;/li&gt;     &lt;li&gt;Competitor website tracking&lt;/li&gt;     &lt;li&gt;Visual regression testing&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Management:&lt;/h4&gt; &lt;p&gt;Use &lt;code&gt;GET /v1/ops/screenshots/schedules&lt;/code&gt; to list schedules, &lt;code&gt;DELETE /v1/ops/screenshots/schedules/{id}&lt;/code&gt; to delete.&lt;/p&gt; 
     * <p><b>202</b> - Schedule successfully created. Poll &#x60;/v1/ops/jobs/{jobId}&#x60; for status.
     * <p><b>400</b> - Invalid schedule configuration or missing required fields.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param screenshotRequest Schedule configuration including URL, schedule timing, and screenshot options.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec scheduleScreenshotWithResponseSpec(@jakarta.annotation.Nonnull ScreenshotRequest screenshotRequest) throws WebClientResponseException {
        return scheduleScreenshotRequestCreation(screenshotRequest);
    }
}
