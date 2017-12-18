package com.capgemini.devonfw.starter.reporting;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.capgemini.devonfw.module.reporting.common.api.Reporting;
import com.capgemini.devonfw.module.reporting.common.api.dataType.ReportFormat;
import com.capgemini.devonfw.module.reporting.common.api.entity.Report;

import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author vapadwal
 *
 */
@SpringBootTest(classes = ReportingTestApp.class)

public class ReportingAutoConfigurationTest extends ComponentTest {
  private Resource template = new ClassPathResource("reportingtest.jrxml");

  @SuppressWarnings("rawtypes")
  private Report report = null;

  @SuppressWarnings("rawtypes")
  @Inject
  private Reporting<Map> reportManager;

  private HashMap<String, Object> params = new HashMap<>();

  private static Random rnd = new Random();

  OutputStream stream = null;

  @SuppressWarnings({ "javadoc", "rawtypes", "unchecked" })
  @Before
  public void init() throws IOException {

    this.report = new Report();

    this.params.put("ReportTitle", "Test");
    this.params.put("ReportDescription", "This is a Test File Report");

    this.report.setName("Test");
    this.report.setData(createList());
    this.report.setParams(this.params);
    this.report.setTemplatePath(this.template.getURI().getPath());

  }

  /**
   * Test that checks the creation of a report file in pdf format.
   *
   * @throws IOException if the temp file can not be created.
   */
  @Test
  public void generateReportPdfFile() throws IOException {

    File pdf = File.createTempFile("tst", ".pdf");
    this.reportManager.generateReport(this.report, pdf, ReportFormat.PDF);
    assertThat(pdf.length()).isGreaterThan(0);
  }

  @SuppressWarnings({ "javadoc", "rawtypes", "unchecked" })
  public static List<HashMap> createList() {

    List lst = new ArrayList();
    lst.add(createItem("Tom Waits", 92));
    lst.add(createItem("Nick Cave", 97));
    lst.add(createItem("PJ Harvey", 95));
    return lst;
  }

  @SuppressWarnings({ "javadoc", "rawtypes", "unchecked" })
  public static Object createItem(String name, int rating) {

    Map map = new HashMap();
    map.put("ID", rnd.nextLong());
    map.put("Name", name);
    map.put("Rating", rating);
    return map;
  }

}
