package kr.pe.kwonnam.jsp.inheritance;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Author: KwonNam Son(kwon37xi@gmail.com)
 */
public class PutTagTest {

    private PutTag putTag;

    @Before
    public void setUp() throws Exception {
        putTag = new PutTag();
    }

    @Test
    public void getPutType_uppercase() throws Exception {
        for (PutType putType : PutType.values()) {
            putTag.setType(putType.name().toUpperCase());
            assertThat(putTag.getPutType(), is(putType));
        }
    }

    @Test
    public void getPutType_lowercase() throws Exception {
        for (PutType putType : PutType.values()) {
            putTag.setType(putType.name().toLowerCase());
            assertThat(putTag.getPutType(), is(putType));
        }
    }
}
