<div align="center">
  <img src="Whisper_Logo.png" alt="Whisper Logo" width="400"/>

  # Whisper API SDK - Java

[![CI](https://github.com/whisper-sec/sdk-java/actions/workflows/ci.yml/badge.svg)](https://github.com/whisper-sec/sdk-java/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.whisper-sec/whisper-api-sdk.svg)](https://search.maven.org/artifact/io.github.whisper-sec/whisper-api-sdk)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

> **Official Java SDK for Whisper API** - Comprehensive threat intelligence and security operations for domains, IPs, and web infrastructure.

**[Website](https://www.whisper.security)** | **[Documentation](https://docs.whisper.security)** | **[API Reference](https://developer.whisper.security)** | **[API Playground](https://dash.whisper.security/playground)** | **[Contact Us](https://www.whisper.security/contactus)**

</div>

---

## Quick Start

### Installation

**Maven:**
```xml
<dependency>
    <groupId>io.github.whisper-sec</groupId>
    <artifactId>whisper-api-sdk</artifactId>
    <version>0.1.0</version>
</dependency>
```

**Gradle:**
```groovy
implementation 'io.github.whisper-sec:whisper-api-sdk:0.1.0'
```

### Get Your API Key

Sign up at [dash.whisper.security](https://dash.whisper.security) to get your API key.

### First Request

```java
import io.github.whispersec.*;
import io.github.whispersec.api.*;

public class Example {
    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setBearerToken("YOUR_API_KEY");

        IndicatorsApi api = new IndicatorsApi(client);

        // Enrich an IP address
        var response = api.getIndicator("ip", "8.8.8.8", null);
        System.out.println(response);
    }
}
```

---

## Key Features

- **Async Support** - Built on WebClient for non-blocking reactive operations
- **Type Safe** - Strongly typed models with full IDE support
- **Comprehensive** - IP, Domain, DNS, WHOIS, Routing, Geolocation, Screenshots, AI/ML
- **Fast** - Sub-500ms typical response times with strategic caching
- **Java 17+** - Modern Java with Jakarta EE support

---

## API Overview

### Indicators API
Enrich IPs and domains with comprehensive threat intelligence.

```java
IndicatorsApi api = new IndicatorsApi(client);

// Basic enrichment
var ipData = api.getIndicator("ip", "8.8.8.8", null);

// With additional data modules
var domainData = api.getIndicator("domain", "example.com", "whois,dns_details");

// Get relationship graph
var graph = api.getIndicatorGraph("ip", "8.8.8.8");

// Historical data
var history = api.getIndicatorHistory("domain", "example.com", 10);

// Predictive risk score (AI-powered)
var risk = api.getPredictiveRisk("ip", "8.8.8.8");

// Subdomain discovery
var subdomains = api.getSubdomains("example.com", 100);
```

### Location API
Geolocation lookups and network analysis.

```java
LocationApi api = new LocationApi(client);

// Single IP geolocation
var location = api.getIpLocation("8.8.8.8");

// Bulk geolocation (up to 1000 IPs)
var bulkResult = api.getBulkIpLocation(bulkRequest);

// Network/CIDR lookup
var network = api.getNetworkLocation("8.8.8.0/24");

// Search by attributes
var results = api.searchLocation("city", "San Francisco", 100);
```

### Operations API
Async operations for scanning, monitoring, and AI-powered analysis.

```java
OperationsApi api = new OperationsApi(client);

// Screenshot capture (returns job ID)
var job = api.createScreenshot(screenshotRequest);

// Infrastructure scan
var scanJob = api.createInfrastructureScan(scanRequest);

// Check job status
var status = api.getJob(job.getJobId());

// AI-powered investigation
var investigation = api.aiInvestigate(investigateRequest);

// Similar threat cases
var cases = api.aiSimilarCases(similarCasesRequest);
```

---

## Authentication

All endpoints require Bearer token authentication:

```java
ApiClient client = new ApiClient();
client.setBearerToken(System.getenv("WHISPER_API_KEY"));
```

---

## Rate Limits

| Category | Limit |
|----------|-------|
| Standard Enrichment | 100 req/min |
| Bulk Operations | 10 req/min |
| Search/Discovery | 5 req/min |
| Screenshots | 10 req/min |

Rate limits return HTTP 429 with a `Retry-After` header.

---

## Documentation

- **API Documentation**: [docs.whisper.security](https://docs.whisper.security)
- **API Reference**: [developer.whisper.security](https://developer.whisper.security)
- **Javadoc**: See the `docs/` directory

---

## Support

- **Email**: [support@whisper.security](mailto:support@whisper.security)
- **Issues**: [github.com/whisper-sec/sdk-java/issues](https://github.com/whisper-sec/sdk-java/issues)

---

## License

MIT License - See [LICENSE](LICENSE) file for details.

---

*Built with Java by Whisper Security*
