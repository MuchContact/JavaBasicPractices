package com.string;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Created by dan on 15-5-27.
 */
public class StringTest {

    private final String s;

    public StringTest() {
        s = "你";
    }

    @Test
    public void shouldChineseCharacterOccupies1Count() throws Exception {
        Assert.assertEquals(1, Character.charCount('叱'));
        Assert.assertEquals(1, Character.charCount('中'));
        Assert.assertEquals(1, s.length());
    }

    @Test
    public void shouldEveryChineseCharacterInGBKOccupies2Bytes() throws Exception {
        Assert.assertEquals(2, s.getBytes("gbk").length);
    }

    @Test
    public void shouldEveryChineseCharacterInUTF8Occupies3Bytes() throws Exception {
        Assert.assertEquals(3, s.getBytes("utf-8").length);
    }

    @Test
    public void shouldChineseCharacterCodePointUnextended() throws Exception {
        String s = "你好";
        Assert.assertTrue(s.charAt(0)==s.codePointAt(0));
    }

    @Test
    public void shouldSystemEncodeTypeBeUTF8() throws Exception {
        Assert.assertEquals(3, s.getBytes().length);
        Assert.assertEquals("UTF-8", Charset.defaultCharset().name());
    }
}
