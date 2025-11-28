

# SimilarDomainRequest

Configuration for generating similar domain variations for brand protection and threat hunting

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**techniques** | **Set&lt;String&gt;** | Types of domain variations to generate |  [optional] |
|**limit** | **Integer** | Maximum number of similar domains to generate |  [optional] |
|**checkRegistration** | **Boolean** | Check if generated domains are registered |  [optional] |
|**includeDns** | **Boolean** | Include DNS resolution data for registered domains |  [optional] |
|**includeRiskScore** | **Boolean** | Calculate risk scores for each variation |  [optional] |
|**techniqueConfig** | [**TechniqueConfig**](TechniqueConfig.md) |  |  [optional] |



