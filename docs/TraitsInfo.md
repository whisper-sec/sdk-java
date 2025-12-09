

# TraitsInfo

IP classification and behavioral traits

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**userType** | [**UserTypeEnum**](#UserTypeEnum) | Classification of the IP address based on its typical use |  [optional] |
|**isAnonymousProxy** | **Boolean** | Whether this IP is associated with anonymous proxy services |  [optional] |
|**isTorExitNode** | **Boolean** | Whether this IP is a known Tor exit node |  [optional] |
|**isVpn** | **Boolean** | Whether this IP is associated with a VPN service |  [optional] |



## Enum: UserTypeEnum

| Name | Value |
|---- | -----|
| RESIDENTIAL | &quot;residential&quot; |
| BUSINESS | &quot;business&quot; |
| HOSTING | &quot;hosting&quot; |
| ISP | &quot;isp&quot; |
| CELLULAR | &quot;cellular&quot; |
| EDUCATION | &quot;education&quot; |
| GOVERNMENT | &quot;government&quot; |
| MILITARY | &quot;military&quot; |



