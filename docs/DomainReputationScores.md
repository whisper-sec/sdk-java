

# DomainReputationScores

Domain reputation calculated from infrastructure IP scores

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**overallScore** | **Double** | Overall reputation score (0-100, higher &#x3D; more suspicious) |  [optional] |
|**riskLevel** | [**RiskLevelEnum**](#RiskLevelEnum) | Risk classification based on overall score |  [optional] |
|**domainIpScore** | **Double** | Average IP reputation score for domain&#39;s A records |  [optional] |
|**nameserverIpScore** | **Double** | Average IP reputation score for nameserver IPs |  [optional] |
|**mailserverIpScore** | **Double** | Average IP reputation score for mail server IPs |  [optional] |
|**details** | [**DomainReputationDetails**](DomainReputationDetails.md) |  |  [optional] |
|**scoringMethod** | **String** | Scoring methodology used |  [optional] |
|**weights** | **Map&lt;String, Double&gt;** | Weighting strategy applied to infrastructure components |  [optional] |



## Enum: RiskLevelEnum

| Name | Value |
|---- | -----|
| CLEAN | &quot;clean&quot; |
| LOW_RISK | &quot;low_risk&quot; |
| MEDIUM_RISK | &quot;medium_risk&quot; |
| HIGH_RISK | &quot;high_risk&quot; |
| MALICIOUS | &quot;malicious&quot; |



