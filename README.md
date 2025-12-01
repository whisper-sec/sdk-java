<div align="center">
  <img src="Whisper_Logo.png" alt="Whisper Logo" width="400"/>

  # Whisper API SDK - Java

[![Build](https://github.com/whisper-sec/sdk-java/actions/workflows/ci.yml/badge.svg)](https://github.com/whisper-sec/sdk-java/actions/workflows/ci.yml)
[![Publish](https://github.com/whisper-sec/sdk-java/actions/workflows/publish.yml/badge.svg)](https://github.com/whisper-sec/sdk-java/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.whisper-sec/whisper-api-sdk.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.whisper-sec%22%20AND%20a:%22whisper-api-sdk%22)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

> **Official Java SDK for Whisper API** - Comprehensive intelligence and monitoring capabilities for domains, IPs, and web infrastructure.

**[Website](https://www.whisper.security)** • **[Documentation](https://docs.whisper.security)** • **[API Reference](https://developer.whisper.security)** • **[API Playground](https://dash.whisper.security/playground)** • **[Contact Us](https://www.whisper.security/contactus)**

</div>

## Whisper API v1 - Java SDK

**The Foundational Intelligence Layer for the Internet**

Gain deep visibility into any internet asset with Whisper's comprehensive intelligence platform. Access powerful APIs for threat intelligence, domain monitoring, network security analysis, WHOIS data, DNS records, geolocation, BGP routing, and more - all through a single, unified interface.

The Whisper API provides comprehensive, real-time intelligence on any internet asset. By connecting billions of data points across live internet routing, historical registration records, and deep resolution data, our API moves beyond simple enrichment to deliver predictive, context-rich insights.

This Java SDK provides a type-safe, reactive client for the Whisper API v1, designed for security experts, developers, and automated systems.

---

## 🚀 Quick Start

### 1. Add Dependency

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

### 2. Get Your API Key

Sign up at [dash.whisper.security](https://dash.whisper.security) to get your API key. Visit our [API Playground](https://dash.whisper.security/playground) to test the API interactively.

### 3. Make Your First Request

```java
import io.github.whispersec.*;
import io.github.whispersec.auth.*;
import io.github.whispersec.api.*;

public class Example {
    public static void main(String[] args) {
        // Configure Bearer token authentication
        ApiClient client = new ApiClient();
        client.setBearerToken("YOUR_API_KEY");

        // Create API instance
        IndicatorsApi api = new IndicatorsApi(client);

        try {
            // Enrich an IP address
            IndicatorResponse response = api.getIndicator("ip", "8.8.8.8", null);
            System.out.println("Organization: " + response.getSummary().getOrganization());
            System.out.println("Location: " + response.getSummary().getLocation());
            System.out.println("Risk Score: " + response.getReputation().getRiskScore());
        } catch (ApiException e) {
            System.err.println("API Error: " + e.getMessage());
        }
    }
}
```

---

## 🎯 Key Features

- **Unified & Simple**: Small set of powerful, resource-oriented endpoints
- **Performant by Design**: Asynchronous-first with strategic caching (<500ms typical response)
- **Workflow-Oriented**: Built for real-world security operations, not just data dumps
- **Comprehensive**: IP, Domain, DNS, WHOIS, Routing, Geolocation, Screenshots, Monitoring
- **Type-Safe**: Fully typed models with validation
- **Reactive**: WebClient-based for non-blocking I/O

---

## 📋 API Categories

### Indicators API
Comprehensive threat intelligence and enrichment for IP addresses and domains. Designed for rapid investigation, incident response, and proactive threat hunting.

**Examples:**
```java
// Enrich a single indicator
IndicatorResponse ipData = api.getIndicator("ip", "8.8.8.8", "routing,rpki");
IndicatorResponse domainData = api.getIndicator("domain", "example.com", "whois,dns_details");

// Search for indicators
SearchRequest searchReq = new SearchRequest().query("registrantCompany:Google");
JobResponse searchJob = api.searchIndicators(searchReq);

// Bulk enrichment
BulkRequest bulkReq = new BulkRequest()
    .addIndicatorsItem("8.8.8.8")
    .addIndicatorsItem("google.com")
    .addIncludeItem("whois");
JobResponse bulkJob = api.bulkEnrichment(bulkReq);
```

### Location API
Geolocation and ASN intelligence for IP addresses and networks.

**Examples:**
```java
LocationApi locationApi = new LocationApi(client);

// Single IP lookup
LocationResponse location = locationApi.getIpLocation("8.8.8.8");

// Network/CIDR lookup
LocationResponse network = locationApi.getNetworkLocation("8.8.8.0/24");

// Search by criteria
List<LocationResponse> results = locationApi.searchLocation("city", "San Francisco", 100);
```

### Operations API
Operational security tools for active analysis and monitoring. Includes screenshots, infrastructure scanning, and asynchronous job tracking.

**Examples:**
```java
OperationsApi opsApi = new OperationsApi(client);

// Capture screenshot
ScreenshotRequest screenshotReq = new ScreenshotRequest()
    .url("https://example.com")
    .options(new ScreenshotOptions().fullPage(true).format("png"));
JobResponse screenshotJob = opsApi.createScreenshot(screenshotReq);

// Infrastructure scan
InfraScanRequest scanReq = new InfraScanRequest()
    .target("example.com")
    .targetType("domain")
    .scanDepth("medium");
JobResponse scanJob = opsApi.createInfrastructureScan(scanReq);

// Check job status
Job job = opsApi.getJob(screenshotJob.getJobId());
if (job.getStatus() == JobStatus.COMPLETED) {
    System.out.println("Result: " + job.getResult());
}
```

---

## 🔐 Authentication

All endpoints require Bearer token authentication:

```java
ApiClient client = new ApiClient();
client.setBearerToken("wsk_live_your_api_key_here");
```

**Security Best Practices:**
- Never commit API keys to source control
- Use environment variables: `System.getenv("WHISPER_API_KEY")`
- Rotate keys regularly from your dashboard

---

## 📊 Rate Limits

| Category | Limit |
|----------|-------|
| Standard Enrichment | 100 req/min |
| Bulk Operations | 10 req/min |
| Search/Discovery | 5 req/min |
| Screenshots | 10 req/min |

Rate limits return HTTP 429. Retry after the time specified in the `Retry-After` header.

---

## 📚 Documentation

- **Website**: [whisper.security](https://www.whisper.security)
- **Full Documentation**: [docs.whisper.security](https://docs.whisper.security)
- **API Reference**: [developer.whisper.security](https://developer.whisper.security)
- **API Playground**: [dash.whisper.security/playground](https://dash.whisper.security/playground)
- **Quick Start Guide**: [docs.whisper.security/quickstart](https://docs.whisper.security/quickstart)
- **Code Examples**: [docs.whisper.security/examples](https://docs.whisper.security/examples)

---

## 📦 API Endpoints

All URIs are relative to *https://api.whisper.security*



### Available APIs

#### IndicatorsApi
- **GET /v1/indicators/{type}/{value}**: Enrich a Single Indicator (IP or Domain)
- **GET /v1/indicators/{type}/{value}/graph**: Get Infrastructure Relationship Graph
- **GET /v1/indicators/{type}/{value}/history**: Get Historical Data for Indicator
- **GET /v1/indicators/domain/{domain}/subdomains**: Get Domain Subdomains

#### LocationApi
- **POST /v1/location/ips/bulk**: Bulk IP Geolocation Lookup
- **GET /v1/location/ip/{ip}**: Get IP Geolocation and ASN Data
- **GET /v1/location/stats**: Get Geolocation Database Statistics
- **GET /v1/location/network/{*network}**: Get Network/CIDR Geolocation Data
- **GET /v1/location/search**: Search Geolocation Database by Field

#### OperationsApi
- **POST /v1/ops/enrichment/bulk**: Bulk Indicator Enrichment (Asynchronous)
- **POST /v1/ops/scans/map**: Map Infrastructure Relationships (Asynchronous)
- **POST /v1/ops/scans/infrastructure**: Infrastructure Security Scan (Asynchronous)
- **POST /v1/ops/monitoring**: Create Monitoring Check
- **POST /v1/ops/monitoring/{target}/alert**: Configure Monitoring Alerts (Asynchronous)
- **POST /v1/ops/screenshots/capture**: Capture a Website Screenshot (Asynchronous)
- **DELETE /v1/ops/monitoring/{checkId}**: Delete Monitoring Check
- **GET /v1/ops/tracking/{type}/{value}**: Get Detected Changes
- **GET /v1/ops/jobs/{jobId}**: Get Asynchronous Job Status and Results
- **GET /v1/ops/monitoring/{checkId}**: Get Monitoring Check
- **GET /v1/ops/monitoring/dashboard**: Get Monitoring Dashboard
- **GET /v1/ops/monitoring/{checkId}/results**: Get Check Results
- **GET /v1/ops/monitoring/status/{target}**: Get Monitoring Status and Metrics
- **GET /v1/ops/screenshots/history**: Get Screenshot History
- **GET /v1/ops/jobs/list**: List Recent Jobs
- **GET /v1/ops/monitoring**: List Monitoring Checks
- **GET /v1/ops/tracking**: List Tracked Indicators
- **POST /v1/ops/screenshots/schedule**: Schedule Recurring Screenshots (Asynchronous)
- **POST /v1/ops/enrichment/search**: Search Indicators (Asynchronous)
- **POST /v1/ops/enrichment/similar-domains**: Find Similar Domains (Asynchronous)
- **POST /v1/ops/tracking/{type}/{value}**: Start Change Tracking
- **DELETE /v1/ops/tracking/{type}/{value}**: Stop Change Tracking
- **POST /v1/ops/tracking/{type}/{value}/check**: Trigger Immediate Check
- **POST /v1/ops/monitoring/{checkId}/trigger**: Trigger Manual Check
- **PUT /v1/ops/monitoring/{checkId}**: Update Monitoring Check


---

## 🛠 Building

```bash
mvn clean install
```

## 🧪 Testing

```bash
mvn test
```

---

## 📄 License

MIT License - See [LICENSE](LICENSE) file for details

---

## 🤝 Support

- **Email**: [support@whisper.security](mailto:support@whisper.security)
- **Website**: [whisper.security](https://www.whisper.security)
- **Documentation**: [docs.whisper.security](https://docs.whisper.security)
- **Contact Us**: [whisper.security/contactus](https://www.whisper.security/contactus)

---

*Generated with ❤️ by Whisper Security*
