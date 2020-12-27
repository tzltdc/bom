package io.github.android.tang.tony.test.util;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;

public class MockTest {

  @Test
  public void verify_register() {

    Student student = mock(Student.class);
    Admin admin = new Admin(student);
    admin.registerStudent();
    verify(student).register();
  }

  @Test
  public void verify_no_more() {

    Student student = mock(Student.class);
    Admin admin = new Admin(student);
    admin.registerStudent();
    verify(student).register();
    verifyNoMoreInteractions(student);
  }
}
