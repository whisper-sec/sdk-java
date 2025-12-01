

# ChangeTrackingResponse

Change tracking response with configuration and detected changes

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicator** | **String** | The indicator value (IP or domain) |  [optional] |
|**type** | **String** | Indicator type: ip or domain |  [optional] |
|**tracking** | [**TrackingConfig**](TrackingConfig.md) |  |  [optional] |
|**changes** | [**List&lt;ChangeEvent&gt;**](ChangeEvent.md) | List of detected changes |  [optional] |
|**baseline** | **Object** |  |  [optional] |
|**baselineCapturedAt** | **OffsetDateTime** | When the baseline was captured |  [optional] |
|**totalChanges** | **Integer** | Total number of changes detected |  [optional] |
|**error** | **String** | Error message if operation failed |  [optional] |
|**success** | **Boolean** | Whether the operation was successful |  [optional] |



