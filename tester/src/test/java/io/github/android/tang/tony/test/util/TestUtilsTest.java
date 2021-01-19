package io.github.android.tang.tony.test.util;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;

public class TestUtilsTest {

  @Rule public TestResourcesRule resource = new TestResourcesRule("gson.json");

  @Test
  public void content() {

    String json = resource.content();
    Type type = new TypeToken<Map<String, Integer>>() {}.getType();
    Map<String, Integer> actual = new Gson().fromJson(json, type);
    assertThat(actual).isEqualTo(expected());
  }

  @Test
  public void inputStream() {

    InputStream inputStream = resource.inputStream();
    assertThat(inputStream).isNotNull();
  }

  @Test
  public void couldParseTheInputStreamToMap() {
    Type type = new TypeToken<Map<String, Integer>>() {}.getType();

    InputStream inputStream = resource.inputStream();
    JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
    Map<String, Integer> actual = new Gson().fromJson(jsonReader, type);
    assertThat(actual).isEqualTo(expected());
  }

  private Object expected() {
    Map<String, Integer> result = new HashMap<>();
    result.put("key", 1);
    return result;
  }
}
