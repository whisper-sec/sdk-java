

# CorrelateOptions

Configuration options for correlation analysis. All fields are optional and provide fine-grained control over correlation behavior. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timeWindow** | **String** | Time window for temporal correlation. Format: number + unit (d&#x3D;days, w&#x3D;weeks, m&#x3D;months). Examples: 7d, 2w, 3m |  [optional] |
|**correlationTypes** | **List&lt;String&gt;** | Types of correlation to analyze. Possible values: infrastructure, campaign, actor, malware, technique |  [optional] |
|**minConfidence** | **Double** | Minimum confidence threshold for correlations (0.0 to 1.0). Higher values return fewer but more confident results. |  [optional] |
|**includeIndustryBreakdown** | **Boolean** | Include breakdown of indicator prevalence by industry sector in the response. |  [optional] |
|**includeCampaignDetection** | **Boolean** | Include campaign detection analysis to identify coordinated threat activity. |  [optional] |
|**includeGeographicSpread** | **Boolean** | Include geographic spread analysis showing indicator distribution across regions. |  [optional] |
|**includeAttackPatterns** | **Boolean** | Include attack pattern analysis based on MITRE ATT&amp;CK framework. |  [optional] |
|**anonymizationLevel** | [**AnonymizationLevelEnum**](#AnonymizationLevelEnum) | Level of data anonymization. Values: none, standard, strict |  [optional] |



## Enum: AnonymizationLevelEnum

| Name | Value |
|---- | -----|
| NONE | &quot;none&quot; |
| STANDARD | &quot;standard&quot; |
| STRICT | &quot;strict&quot; |



