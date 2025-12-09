

# ReputationInfo

Reputation scoring and blacklist information for threat assessment

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**riskScore** | **Double** | Composite risk score (0-10, higher &#x3D; riskier) |  [optional] |
|**blacklists** | [**BlacklistScores**](BlacklistScores.md) | Blacklist presence scores across various threat feeds |  [optional] |
|**domainReputation** | [**DomainReputationScores**](DomainReputationScores.md) | Domain reputation based on infrastructure IP scoring (domains only) |  [optional] |



