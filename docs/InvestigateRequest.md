

# InvestigateRequest

Request for comprehensive AI threat investigation

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicator** | **String** | The indicator to investigate |  |
|**indicatorType** | [**IndicatorTypeEnum**](#IndicatorTypeEnum) | Type of indicator |  |
|**depth** | [**DepthEnum**](#DepthEnum) | Investigation depth level |  [optional] |
|**context** | [**InvestigateContext**](InvestigateContext.md) |  |  [optional] |



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



