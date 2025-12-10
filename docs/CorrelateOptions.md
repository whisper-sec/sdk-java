

# CorrelateOptions

Configuration options for correlation analysis. This is an OBJECT, not a string. All fields are optional. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timeWindow** | **String** | Time window for temporal correlation. Format: number + unit (d&#x3D;days, w&#x3D;weeks, m&#x3D;months). Examples: 7d, 2w, 3m |  [optional] |
|**correlationTypes** | **List&lt;String&gt;** | Types of correlation to analyze. Possible values: infrastructure, campaign, actor, malware, technique |  [optional] |
|**minConfidence** | **Double** | Minimum confidence threshold for correlations (0.0 to 1.0). Higher values return fewer but more confident results. |  [optional] |
|**includeIndustryBreakdown** | **Boolean** | Include breakdown of indicator prevalence by industry sector in the response. |  [optional] |



