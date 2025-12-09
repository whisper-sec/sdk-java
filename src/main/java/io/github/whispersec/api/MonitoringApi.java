package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.GenericSuccessResponse;
import io.github.whispersec.model.JobResponse;
import io.github.whispersec.model.MonitorCheckRequest;
import io.github.whispersec.model.MonitorCheckResponse;
import io.github.whispersec.model.MonitorDashboardResponse;
import io.github.whispersec.model.MonitorListResponse;
import io.github.whispersec.model.MonitorResultListResponse;
import io.github.whispersec.model.MonitoringAlertRequest;
import io.github.whispersec.model.MonitoringStatusResponse;

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
public class MonitoringApi {
    private ApiClient apiClient;

    public MonitoringApi() {
        this(new ApiClient());
    }

    public MonitoringApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Monitoring Check
     * &lt;p&gt;Create a new monitoring check to track uptime and performance of a URL or endpoint.&lt;/p&gt; &lt;h4&gt;Check Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;api:&lt;/b&gt; HTTP/HTTPS endpoint monitoring - checks status code, response time, content&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; SSL certificate monitoring - validates certificate and tracks expiry&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; DNS record monitoring - validates DNS resolution and record values&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequency Options:&lt;/h4&gt; &lt;p&gt;Check frequency in minutes: 1, 5, 10, 15, 30, 60, 1440 (daily)&lt;/p&gt; &lt;h4&gt;Locations:&lt;/h4&gt; &lt;p&gt;Checks can run from multiple global locations: us-east-1, us-west-1, eu-west-1, ap-southeast-1&lt;/p&gt; 
     * <p><b>201</b> - Monitoring check created successfully.
     * <p><b>400</b> - Invalid request - missing name or URL.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>201</b> - Monitoring check created successfully.
     * <p><b>400</b> - Invalid request - missing name or URL.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>201</b> - Monitoring check created successfully.
     * <p><b>400</b> - Invalid request - missing name or URL.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>201</b> - Monitoring check created successfully.
     * <p><b>400</b> - Invalid request - missing name or URL.
     * <p><b>401</b> - Authentication failed.
     * @param monitorCheckRequest Monitoring check configuration
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createMonitorCheckWithResponseSpec(@jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        return createMonitorCheckRequestCreation(monitorCheckRequest);
    }

    /**
     * Configure Monitoring Alert
     * &lt;p&gt;Configure alert notifications for a monitored target. Set up notifications for downtime, SSL expiry, DNS changes, and more.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Alert when target becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; Alert when DNS records change&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Alert when WHOIS data changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Alert when SSL certificate is expiring (within threshold days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Alert when page content changes significantly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Alert when detected technologies change&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;email:&lt;/b&gt; Send alerts via email&lt;/li&gt;     &lt;li&gt;&lt;b&gt;slack:&lt;/b&gt; Post to Slack webhook&lt;/li&gt;     &lt;li&gt;&lt;b&gt;webhook:&lt;/b&gt; POST to custom webhook URL&lt;/li&gt;     &lt;li&gt;&lt;b&gt;pagerduty:&lt;/b&gt; Create PagerDuty incident&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Alert configuration job accepted.
     * <p><b>400</b> - Invalid alert configuration.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * Configure Monitoring Alert
     * &lt;p&gt;Configure alert notifications for a monitored target. Set up notifications for downtime, SSL expiry, DNS changes, and more.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Alert when target becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; Alert when DNS records change&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Alert when WHOIS data changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Alert when SSL certificate is expiring (within threshold days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Alert when page content changes significantly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Alert when detected technologies change&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;email:&lt;/b&gt; Send alerts via email&lt;/li&gt;     &lt;li&gt;&lt;b&gt;slack:&lt;/b&gt; Post to Slack webhook&lt;/li&gt;     &lt;li&gt;&lt;b&gt;webhook:&lt;/b&gt; POST to custom webhook URL&lt;/li&gt;     &lt;li&gt;&lt;b&gt;pagerduty:&lt;/b&gt; Create PagerDuty incident&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Alert configuration job accepted.
     * <p><b>400</b> - Invalid alert configuration.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * Configure Monitoring Alert
     * &lt;p&gt;Configure alert notifications for a monitored target. Set up notifications for downtime, SSL expiry, DNS changes, and more.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Alert when target becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; Alert when DNS records change&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Alert when WHOIS data changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Alert when SSL certificate is expiring (within threshold days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Alert when page content changes significantly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Alert when detected technologies change&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;email:&lt;/b&gt; Send alerts via email&lt;/li&gt;     &lt;li&gt;&lt;b&gt;slack:&lt;/b&gt; Post to Slack webhook&lt;/li&gt;     &lt;li&gt;&lt;b&gt;webhook:&lt;/b&gt; POST to custom webhook URL&lt;/li&gt;     &lt;li&gt;&lt;b&gt;pagerduty:&lt;/b&gt; Create PagerDuty incident&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Alert configuration job accepted.
     * <p><b>400</b> - Invalid alert configuration.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
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
     * Configure Monitoring Alert
     * &lt;p&gt;Configure alert notifications for a monitored target. Set up notifications for downtime, SSL expiry, DNS changes, and more.&lt;/p&gt; &lt;h4&gt;Alert Types:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;downtime:&lt;/b&gt; Alert when target becomes unreachable&lt;/li&gt;     &lt;li&gt;&lt;b&gt;dns_change:&lt;/b&gt; Alert when DNS records change&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois_change:&lt;/b&gt; Alert when WHOIS data changes&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl_expiring:&lt;/b&gt; Alert when SSL certificate is expiring (within threshold days)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;content_change:&lt;/b&gt; Alert when page content changes significantly&lt;/li&gt;     &lt;li&gt;&lt;b&gt;technology_change:&lt;/b&gt; Alert when detected technologies change&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Notification Channels:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;email:&lt;/b&gt; Send alerts via email&lt;/li&gt;     &lt;li&gt;&lt;b&gt;slack:&lt;/b&gt; Post to Slack webhook&lt;/li&gt;     &lt;li&gt;&lt;b&gt;webhook:&lt;/b&gt; POST to custom webhook URL&lt;/li&gt;     &lt;li&gt;&lt;b&gt;pagerduty:&lt;/b&gt; Create PagerDuty incident&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Alert configuration job accepted.
     * <p><b>400</b> - Invalid alert configuration.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * @param target The domain or IP address to configure alerts for.
     * @param monitoringAlertRequest Alert configuration including type, thresholds, and notification channels.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createMonitoringAlertWithResponseSpec(@jakarta.annotation.Nonnull String target, @jakarta.annotation.Nonnull MonitoringAlertRequest monitoringAlertRequest) throws WebClientResponseException {
        return createMonitoringAlertRequestCreation(target, monitoringAlertRequest);
    }

    /**
     * Delete Monitoring Check
     * Delete a monitoring check and stop all monitoring for the target.
     * <p><b>204</b> - Check deleted successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @return Object
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
            "*/*", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring/{checkId}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete Monitoring Check
     * Delete a monitoring check and stop all monitoring for the target.
     * <p><b>204</b> - Check deleted successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @return Object
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Object> deleteMonitorCheck(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return deleteMonitorCheckRequestCreation(checkId).bodyToMono(localVarReturnType);
    }

    /**
     * Delete Monitoring Check
     * Delete a monitoring check and stop all monitoring for the target.
     * <p><b>204</b> - Check deleted successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @return ResponseEntity&lt;Object&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Object>> deleteMonitorCheckWithHttpInfo(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<Object> localVarReturnType = new ParameterizedTypeReference<Object>() {};
        return deleteMonitorCheckRequestCreation(checkId).toEntity(localVarReturnType);
    }

    /**
     * Delete Monitoring Check
     * Delete a monitoring check and stop all monitoring for the target.
     * <p><b>204</b> - Check deleted successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteMonitorCheckWithResponseSpec(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        return deleteMonitorCheckRequestCreation(checkId);
    }

    /**
     * Get Monitoring Check
     * Get details of a specific monitoring check including uptime metrics.
     * <p><b>200</b> - Check details.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>200</b> - Dashboard summary.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>200</b> - Dashboard summary.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>200</b> - Dashboard summary.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>200</b> - Dashboard summary.
     * <p><b>401</b> - Authentication failed.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getMonitorDashboardWithResponseSpec() throws WebClientResponseException {
        return getMonitorDashboardRequestCreation();
    }

    /**
     * Get Check Results
     * &lt;p&gt;Get the execution history for a monitoring check.&lt;/p&gt; &lt;h4&gt;Response includes for each result:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Timestamp of execution&lt;/li&gt;     &lt;li&gt;Success/failure status&lt;/li&gt;     &lt;li&gt;Response time&lt;/li&gt;     &lt;li&gt;HTTP status code (for API checks)&lt;/li&gt;     &lt;li&gt;Error message (if failed)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Check execution history.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @param limit Maximum number of results to return
     * @return MonitorResultListResponse
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

        ParameterizedTypeReference<MonitorResultListResponse> localVarReturnType = new ParameterizedTypeReference<MonitorResultListResponse>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring/{checkId}/results", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Check Results
     * &lt;p&gt;Get the execution history for a monitoring check.&lt;/p&gt; &lt;h4&gt;Response includes for each result:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Timestamp of execution&lt;/li&gt;     &lt;li&gt;Success/failure status&lt;/li&gt;     &lt;li&gt;Response time&lt;/li&gt;     &lt;li&gt;HTTP status code (for API checks)&lt;/li&gt;     &lt;li&gt;Error message (if failed)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Check execution history.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @param limit Maximum number of results to return
     * @return MonitorResultListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<MonitorResultListResponse> getMonitorResults(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorResultListResponse> localVarReturnType = new ParameterizedTypeReference<MonitorResultListResponse>() {};
        return getMonitorResultsRequestCreation(checkId, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Get Check Results
     * &lt;p&gt;Get the execution history for a monitoring check.&lt;/p&gt; &lt;h4&gt;Response includes for each result:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Timestamp of execution&lt;/li&gt;     &lt;li&gt;Success/failure status&lt;/li&gt;     &lt;li&gt;Response time&lt;/li&gt;     &lt;li&gt;HTTP status code (for API checks)&lt;/li&gt;     &lt;li&gt;Error message (if failed)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Check execution history.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @param limit Maximum number of results to return
     * @return ResponseEntity&lt;MonitorResultListResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<MonitorResultListResponse>> getMonitorResultsWithHttpInfo(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<MonitorResultListResponse> localVarReturnType = new ParameterizedTypeReference<MonitorResultListResponse>() {};
        return getMonitorResultsRequestCreation(checkId, limit).toEntity(localVarReturnType);
    }

    /**
     * Get Check Results
     * &lt;p&gt;Get the execution history for a monitoring check.&lt;/p&gt; &lt;h4&gt;Response includes for each result:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Timestamp of execution&lt;/li&gt;     &lt;li&gt;Success/failure status&lt;/li&gt;     &lt;li&gt;Response time&lt;/li&gt;     &lt;li&gt;HTTP status code (for API checks)&lt;/li&gt;     &lt;li&gt;Error message (if failed)&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Check execution history.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @param limit Maximum number of results to return
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getMonitorResultsWithResponseSpec(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nullable Integer limit) throws WebClientResponseException {
        return getMonitorResultsRequestCreation(checkId, limit);
    }

    /**
     * Get Monitoring Status
     * &lt;p&gt;Get the current monitoring status and metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Metrics Returned:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Target is not being monitored.
     * @param target The domain or IP address to check monitoring status for.
     * @return MonitoringStatusResponse
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

        ParameterizedTypeReference<MonitoringStatusResponse> localVarReturnType = new ParameterizedTypeReference<MonitoringStatusResponse>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring/status/{target}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Monitoring Status
     * &lt;p&gt;Get the current monitoring status and metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Metrics Returned:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Target is not being monitored.
     * @param target The domain or IP address to check monitoring status for.
     * @return MonitoringStatusResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<MonitoringStatusResponse> getMonitoringStatus(@jakarta.annotation.Nonnull String target) throws WebClientResponseException {
        ParameterizedTypeReference<MonitoringStatusResponse> localVarReturnType = new ParameterizedTypeReference<MonitoringStatusResponse>() {};
        return getMonitoringStatusRequestCreation(target).bodyToMono(localVarReturnType);
    }

    /**
     * Get Monitoring Status
     * &lt;p&gt;Get the current monitoring status and metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Metrics Returned:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Target is not being monitored.
     * @param target The domain or IP address to check monitoring status for.
     * @return ResponseEntity&lt;MonitoringStatusResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<MonitoringStatusResponse>> getMonitoringStatusWithHttpInfo(@jakarta.annotation.Nonnull String target) throws WebClientResponseException {
        ParameterizedTypeReference<MonitoringStatusResponse> localVarReturnType = new ParameterizedTypeReference<MonitoringStatusResponse>() {};
        return getMonitoringStatusRequestCreation(target).toEntity(localVarReturnType);
    }

    /**
     * Get Monitoring Status
     * &lt;p&gt;Get the current monitoring status and metrics for a domain or IP address.&lt;/p&gt; &lt;h4&gt;Metrics Returned:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;Uptime percentage (last 30 days)&lt;/li&gt;     &lt;li&gt;Average response time&lt;/li&gt;     &lt;li&gt;SSL certificate expiration countdown&lt;/li&gt;     &lt;li&gt;DNS change events&lt;/li&gt;     &lt;li&gt;WHOIS change events&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved monitoring status.
     * <p><b>401</b> - Authentication failed. Missing or invalid API key.
     * <p><b>404</b> - Target is not being monitored.
     * @param target The domain or IP address to check monitoring status for.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getMonitoringStatusWithResponseSpec(@jakarta.annotation.Nonnull String target) throws WebClientResponseException {
        return getMonitoringStatusRequestCreation(target);
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
     * Trigger Manual Check
     * Trigger an immediate execution of a monitoring check.
     * <p><b>202</b> - Check triggered successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @return GenericSuccessResponse
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

        ParameterizedTypeReference<GenericSuccessResponse> localVarReturnType = new ParameterizedTypeReference<GenericSuccessResponse>() {};
        return apiClient.invokeAPI("/v1/ops/monitoring/{checkId}/trigger", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Trigger Manual Check
     * Trigger an immediate execution of a monitoring check.
     * <p><b>202</b> - Check triggered successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @return GenericSuccessResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GenericSuccessResponse> triggerMonitorCheck(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<GenericSuccessResponse> localVarReturnType = new ParameterizedTypeReference<GenericSuccessResponse>() {};
        return triggerMonitorCheckRequestCreation(checkId).bodyToMono(localVarReturnType);
    }

    /**
     * Trigger Manual Check
     * Trigger an immediate execution of a monitoring check.
     * <p><b>202</b> - Check triggered successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @return ResponseEntity&lt;GenericSuccessResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GenericSuccessResponse>> triggerMonitorCheckWithHttpInfo(@jakarta.annotation.Nonnull String checkId) throws WebClientResponseException {
        ParameterizedTypeReference<GenericSuccessResponse> localVarReturnType = new ParameterizedTypeReference<GenericSuccessResponse>() {};
        return triggerMonitorCheckRequestCreation(checkId).toEntity(localVarReturnType);
    }

    /**
     * Trigger Manual Check
     * Trigger an immediate execution of a monitoring check.
     * <p><b>202</b> - Check triggered successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>200</b> - Check updated successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>200</b> - Check updated successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>200</b> - Check updated successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
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
     * <p><b>200</b> - Check updated successfully.
     * <p><b>404</b> - Check not found or access denied.
     * <p><b>401</b> - Authentication failed.
     * @param checkId Check ID
     * @param monitorCheckRequest Updated check configuration
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateMonitorCheckWithResponseSpec(@jakarta.annotation.Nonnull String checkId, @jakarta.annotation.Nonnull MonitorCheckRequest monitorCheckRequest) throws WebClientResponseException {
        return updateMonitorCheckRequestCreation(checkId, monitorCheckRequest);
    }
}
