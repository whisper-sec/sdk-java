

# InvestigateContext

Additional context to guide and enhance the investigation. All fields are optional but providing context improves investigation quality. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**hypothesis** | **String** | Initial hypothesis or suspicion to focus the investigation. The AI will attempt to prove or disprove this theory. |  [optional] |
|**relatedIndicators** | **List&lt;String&gt;** | Related indicators (IPs, domains, hashes) to include in the investigation scope. Helps identify connections between indicators. |  [optional] |
|**timeRange** | **String** | Time range for historical analysis. Format: number + unit (d&#x3D;days, w&#x3D;weeks, m&#x3D;months). Examples: 7d, 2w, 3m, 90d |  [optional] |
|**industry** | **String** | Industry sector for contextualized threat analysis. Helps identify industry-specific threats and attack patterns. |  [optional] |
|**region** | **String** | Geographic region for localized threat intelligence. Helps identify region-specific threats. |  [optional] |



