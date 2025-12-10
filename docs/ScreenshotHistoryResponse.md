

# ScreenshotHistoryResponse

Response containing screenshot history for a target URL

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**target** | **String** | The target domain or URL queried |  [optional] |
|**schedules** | [**List&lt;ScheduleWithScreenshots&gt;**](ScheduleWithScreenshots.md) | List of schedules that captured screenshots of this target |  [optional] |
|**totalScreenshots** | **Integer** | Total number of screenshots available for this target |  [optional] |
|**limit** | **Integer** | Maximum number of screenshots returned (limit parameter) |  [optional] |



