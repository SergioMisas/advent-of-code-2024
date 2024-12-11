package dev.sergiomisas.adventofcode2024.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {
    @Test
    void readFileTest() {
        String content = Utils.readFile("src/test/java/dev/sergiomisas/adventofcode2024/utils/test.txt");
        String expected = """
                Ande ande ande
                la marimorena
                ande ande ande
                que la noche
                es buena""";
        assertEquals(expected, content);
    }
}
