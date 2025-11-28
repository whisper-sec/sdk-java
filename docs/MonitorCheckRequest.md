

# MonitorCheckRequest

Request to create or update a monitoring check

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the monitoring check |  |
|**url** | **String** | URL to monitor |  |
|**type** | [**TypeEnum**](#TypeEnum) | Type of check: api, ssl, or dns |  [optional] |
|**frequency** | **Integer** | Check frequency in minutes |  [optional] |
|**locations** | **List&lt;String&gt;** | Locations to run checks from |  [optional] |
|**assertions** | [**MonitorAssertions**](MonitorAssertions.md) |  |  [optional] |
|**enabled** | **Boolean** | Whether the check is enabled |  [optional] |
|**method** | [**MethodEnum**](#MethodEnum) | HTTP method for API checks |  [optional] |
|**headers** | **Map&lt;String, String&gt;** | Request headers for API checks |  [optional] |
|**body** | **String** | Request body for POST/PUT API checks |  [optional] |
|**valid** | **Boolean** |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| API | &quot;api&quot; |
| SSL | &quot;ssl&quot; |
| DNS | &quot;dns&quot; |



## Enum: MethodEnum

| Name | Value |
|---- | -----|
| GET | &quot;GET&quot; |
| POST | &quot;POST&quot; |
| PUT | &quot;PUT&quot; |
| DELETE | &quot;DELETE&quot; |
| HEAD | &quot;HEAD&quot; |
| OPTIONS | &quot;OPTIONS&quot; |



