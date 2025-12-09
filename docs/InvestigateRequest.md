

# InvestigateRequest

Request for comprehensive AI-powered threat investigation. Analyzes indicators and returns verdict, timeline, and recommendations.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicator** | **String** | The indicator to investigate (IP address, domain name, or file hash) |  |
|**indicatorType** | [**IndicatorTypeEnum**](#IndicatorTypeEnum) | Type of indicator being investigated |  |
|**depth** | [**DepthEnum**](#DepthEnum) | Investigation depth level. &#39;quick&#39; (30-60s) for basic checks, &#39;standard&#39; (60-120s) for typical investigations, &#39;comprehensive&#39; (120-300s) for deep analysis. |  [optional] |
|**context** | [**InvestigateContext**](InvestigateContext.md) | Optional context object to guide the investigation. NOT a string - must be an object with fields like hypothesis, relatedIndicators, timeRange. |  [optional] |



## Enum: IndicatorTypeEnum

| Name | Value |
|---- | -----|
| IP | &quot;ip&quot; |
| DOMAIN | &quot;domain&quot; |
| HASH | &quot;hash&quot; |



## Enum: DepthEnum

| Name | Value |
|---- | -----|
| QUICK | &quot;quick&quot; |
| STANDARD | &quot;standard&quot; |
| COMPREHENSIVE | &quot;comprehensive&quot; |



