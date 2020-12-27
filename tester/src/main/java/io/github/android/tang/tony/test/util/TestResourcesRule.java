package io.github.android.tang.tony.test.util;

import java.io.InputStream;
import org.junit.rules.ExternalResource;

public class TestResourcesRule extends ExternalResource {

  String resourceFilePath;

  public TestResourcesRule(String resourceFilePath) {
    this.resourceFilePath = resourceFilePath;
  }

  public String content() {
    return content("utf-8");
  }

  public String content(String charSet) {
    return TestUtil.content(resourceFilePath, charSet, this);
  }

  public InputStream inputStream() {
    return getClass().getResourceAsStream(resourceFilePath);
  }
}
