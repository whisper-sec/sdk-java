

# AttributionContext

Context information to improve threat actor attribution accuracy. This is an OBJECT, not a string. All fields are optional but provide better results. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**observedTTPs** | **List&lt;String&gt;** | Observed MITRE ATT&amp;CK technique IDs. See https://attack.mitre.org for reference. |  [optional] |
|**targetedSector** | **String** | Targeted industry sector. Common values: financial, healthcare, government, technology, energy, retail, manufacturing |  [optional] |
|**targetRegion** | **String** | Geographic region of targets. Use ISO country codes or region names. |  [optional] |
|**timeframe** | **String** | Campaign timeframe for attribution. Format: &#39;YYYY-MM-DD to YYYY-MM-DD&#39; or descriptive like &#39;Q1 2024&#39; |  [optional] |
|**malwareFamilies** | **List&lt;String&gt;** | Known malware families observed in the campaign. Helps narrow down threat actor candidates. |  [optional] |



