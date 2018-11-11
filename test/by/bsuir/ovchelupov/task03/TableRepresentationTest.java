package by.bsuir.ovchelupov.task03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Tests for TableRepresentation class
 */
class TableRepresentationTest {

    /**
     * Tests TableRepresentation.getTableRepresentation() method
     */
    @Test
    void checkRepresentation() {
        // check number of lines
        double values[][] = TableOfTangents.getTangentList(5, 5, 0.5);
        var list = TableRepresentation.getTableRepresentation(values);
        Assertions.assertEquals(3, list.size());

        double values2[][] = TableOfTangents.getTangentList(5, 7, 0.5);
        var list2 = TableRepresentation.getTableRepresentation(values2);
        Assertions.assertEquals(7, list2.size());

        double values3[][] = TableOfTangents.getTangentList(5, 7.10, 0.5);
        var list3 = TableRepresentation.getTableRepresentation(values3);
        Assertions.assertEquals(8, list3.size());

        // check table width
        for (var v : list3) {
            Assertions.assertEquals(list3.get(0).length(), v.length());
        }
    }
}