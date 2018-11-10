package by.bsuir.ovchelupov.lab1.task3;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class TableRepresentationTest {
    @Test
    void checkRepresentation() {
        // check number of lines
        double values[][] = TableOfTangents.getTangentList(5, 5, 0.5);
        var list = TableRepresentation.getTableRepresentation(values);
        Assertions.assertEquals(3, list.size());

        double values2[][] = TableOfTangents.getTangentList(5, 6, 0.5);
        var list2 = TableRepresentation.getTableRepresentation(values2);
        Assertions.assertEquals(5, list2.size());

        double values3[][] = TableOfTangents.getTangentList(5, 6.10, 0.5);
        var list3 = TableRepresentation.getTableRepresentation(values3);
        Assertions.assertEquals(6, list3.size());

        // check table width
        Assertions.assertEquals(list3.get(1).length(), list3.get(0).length());
        Assertions.assertEquals(list3.get(2).length(), list3.get(0).length());
        Assertions.assertEquals(list3.get(3).length(), list3.get(0).length());
        Assertions.assertEquals(list3.get(4).length(), list3.get(0).length());
        Assertions.assertEquals(list3.get(5).length(), list3.get(0).length());
    }
}