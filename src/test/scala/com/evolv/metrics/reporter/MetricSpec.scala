package com.evolv.metrics.reporter

import com.evolv.metrics.UnitSpec

class MetricSpec extends UnitSpec {

  "Metric" should "return all parameters in the case class when timestamp is None" in {
    val metric = Metric("test.measurement", Map[String, String](), "123456", None)

    metric.timestamp shouldBe None
    metric.metricName shouldBe "test.measurement"
    metric.value shouldBe "123456"
    metric.tags shouldBe Map[String, String]()
  }

  it should "return all parameters in the case class when timestamp is Some" in {
    val metric = Metric("test.measurement", Map[String, String]("sampleKey" -> "sampleValue"), "123456", Some("123456"))

    metric.timestamp shouldBe Some("123456")
    metric.metricName shouldBe "test.measurement"
    metric.value shouldBe "123456"
    metric.tags shouldBe Map[String, String]("sampleKey" -> "sampleValue")
  }
}
