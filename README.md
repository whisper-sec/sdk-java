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

        EnrichmentApi api = new EnrichmentApi(client);

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

### Enrichment API
Enrich IPs and domains with comprehensive threat intelligence.

```java
EnrichmentApi api = new EnrichmentApi(client);

// Basic enrichment
var ipData = api.getIndicator("ip", "8.8.8.8", null);

// With additional data modules
var domainData = api.getIndicator("domain", "example.com", "whois,dns_details,routing,rpki");

// Get relationship graph
var graph = api.getIndicatorGraph("ip", "8.8.8.8");

// Historical data
var history = api.getIndicatorHistory("domain", "example.com", 10);

// Predictive risk score (AI-powered)
var risk = api.getPredictiveRisk("ip", "8.8.8.8");

// Subdomain discovery
var subdomains = api.getSubdomains("example.com", 100);

// Bulk enrichment (async job)
var job = api.bulkEnrichment(bulkRequest);

// Search by WHOIS fields
var searchJob = api.searchIndicators(searchRequest);

// Similar/typosquat domain generation
var similarJob = api.similarDomains(similarRequest);
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

// Location statistics
var stats = api.getLocationStats();
```

### Screenshots API
Capture and schedule website screenshots.

```java
ScreenshotsApi api = new ScreenshotsApi(client);

// Screenshot capture (returns job ID)
var job = api.createScreenshot(screenshotRequest);

// Schedule recurring screenshots
var schedule = api.scheduleScreenshot(scheduleRequest);

// Get screenshot history
var history = api.getScreenshotHistory("https://example.com", null, null);

// List scheduled screenshots
var schedules = api.listScreenshotSchedules();
```

### AI Intelligence API
AI-powered threat investigation and analysis.

```java
AiIntelligenceApi api = new AiIntelligenceApi(client);

// Industry security benchmark (synchronous)
var benchmark = api.getIndustryBenchmark("financial_services", "enterprise", null);

// AI-powered investigation (async job)
var investigation = api.aiInvestigate(investigateRequest);

// Find similar threat cases
var cases = api.findSimilarCases(similarCasesRequest);

// Infrastructure pivoting
var pivot = api.aiPivot(pivotRequest);

// Threat actor attribution
var attribution = api.aiAttribute(attributeRequest);

// Global indicator correlation
var correlation = api.aiCorrelate(correlateRequest);
```

### Infrastructure Scanning API
Discover and analyze infrastructure.

```java
InfrastructureScanningApi api = new InfrastructureScanningApi(client);

// Infrastructure scan (SSL, technologies, subdomains, ports)
var scanJob = api.createInfrastructureScan(scanRequest);

// Infrastructure relationship mapping
var mapJob = api.createInfrastructureMap(mapRequest);
```

### Monitoring API
Uptime and availability monitoring.

```java
MonitoringApi api = new MonitoringApi(client);

// Create monitoring check
var check = api.createMonitorCheck(monitorRequest);

// List monitoring checks
var checks = api.listMonitorChecks();

// Get dashboard summary
var dashboard = api.getMonitorDashboard();

// Configure alerts
api.createMonitoringAlert(checkId, alertRequest);
```

### Change Tracking API
Monitor indicators for changes.

```java
ChangeTrackingApi api = new ChangeTrackingApi(client);

// Start tracking an indicator
api.startChangeTracking("domain", "example.com", trackingRequest);

// Get detected changes
var changes = api.getChanges("domain", "example.com");

// List tracked indicators
var tracked = api.listTrackedIndicators();

// Trigger immediate check
api.triggerCheck("domain", "example.com");
```

### Graph Database API
Direct access to the threat intelligence graph.

```java
GraphDatabaseApi api = new GraphDatabaseApi(client);

// Execute Cypher query
var result = api.executeCypherQuery(cypherRequest);

// Execute GraphQL query
var graphqlResult = api.executeGraphQL(graphqlRequest);

// Get graph schema
var schema = api.getSchema();
```

### Jobs API
Manage async operations.

```java
JobsApi api = new JobsApi(client);

// Get job status and results
var job = api.getJob(jobId);

// List your jobs
var jobs = api.listJobs();
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
| Indicators (`/v1/indicators/*`) | 100 req/sec |
| Location (`/v1/location/*`) | 100 req/sec |
| Jobs (`/v1/ops/jobs/*`) | 100 req/sec |
| Bulk Operations | 10 req/sec |
| Screenshots | 10 req/sec |
| Scans | 10 req/sec |
| Monitoring | 10 req/sec |
| Change Tracking | 10 req/sec |
| AI Operations | 5 req/min |

Rate limits return HTTP 429 with a `Retry-After` header.

---

## Documentation

- **API Documentation**: [docs.whisper.security](https://docs.whisper.security)
- **API Reference**: [developer.whisper.security](https://developer.whisper.security)
- **Javadoc**: See the `docs/` directory

---

## Other SDKs

- **Python**: [github.com/whisper-sec/sdk-python](https://github.com/whisper-sec/sdk-python)
- **TypeScript/JavaScript**: [github.com/whisper-sec/sdk-typescript](https://github.com/whisper-sec/sdk-typescript)
- **C#/.NET**: [github.com/whisper-sec/sdk-csharp](https://github.com/whisper-sec/sdk-csharp)
- **Rust**: [github.com/whisper-sec/sdk-rust](https://github.com/whisper-sec/sdk-rust)

---

## Support

- **Email**: [support@whisper.security](mailto:support@whisper.security)
- **Issues**: [github.com/whisper-sec/sdk-java/issues](https://github.com/whisper-sec/sdk-java/issues)

---

## License

MIT License - See [LICENSE](LICENSE) file for details.

---

*Built with Java by Whisper Security*
