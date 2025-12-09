

# InvestigateContext

Additional context to guide and enhance the investigation. This is an OBJECT, not a string. All fields are optional. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**relatedIndicators** | **List&lt;String&gt;** | Related indicators (IPs, domains, hashes) to include in the investigation scope. Helps identify connections between indicators. |  [optional] |
|**hypothesis** | **String** | Initial hypothesis or suspicion to focus the investigation. The AI will attempt to prove or disprove this theory. |  [optional] |
|**timeRange** | **String** | Time range for historical analysis. Format: number + unit (d&#x3D;days, w&#x3D;weeks, m&#x3D;months). Examples: 7d, 2w, 3m, 90d |  [optional] |



