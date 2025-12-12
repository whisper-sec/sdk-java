

# InvestigateResult

Result of an AI-powered threat investigation

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicator** | **String** | The indicator that was investigated |  [optional] |
|**indicatorType** | [**IndicatorTypeEnum**](#IndicatorTypeEnum) | Type of the indicator |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the investigation |  [optional] |
|**error** | **Boolean** | Whether an error occurred during investigation |  [optional] |
|**message** | **String** | Error message if the investigation failed |  [optional] |
|**investigation** | **Object** |  |  [optional] |



## Enum: IndicatorTypeEnum

| Name | Value |
|---- | -----|
| IP | &quot;ip&quot; |
| DOMAIN | &quot;domain&quot; |
| HASH | &quot;hash&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |



