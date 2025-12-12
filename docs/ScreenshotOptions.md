

# ScreenshotOptions

Configuration options for screenshot capture including viewport size, format, and behavior settings.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**width** | **Integer** | Viewport width in pixels |  [optional] |
|**height** | **Integer** | Viewport height in pixels |  [optional] |
|**fullPage** | **Boolean** | Capture the full page height (scrolling screenshot) |  [optional] |
|**waitTime** | **Integer** | Wait time in milliseconds before taking screenshot |  [optional] |
|**format** | [**FormatEnum**](#FormatEnum) | Image format for the screenshot |  [optional] |
|**quality** | **Integer** | Image quality (1-100, only for jpeg/webp) |  [optional] |
|**userAgent** | **String** | User agent string to use for the request |  [optional] |
|**javascript** | **Boolean** | Enable JavaScript execution |  [optional] |
|**blockAds** | **Boolean** | Block ads and trackers |  [optional] |
|**acceptCookies** | **Boolean** | Accept cookies consent if prompted |  [optional] |



## Enum: FormatEnum

| Name | Value |
|---- | -----|
| PNG | &quot;png&quot; |
| JPEG | &quot;jpeg&quot; |
| WEBP | &quot;webp&quot; |



