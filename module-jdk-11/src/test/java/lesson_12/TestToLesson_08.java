package lesson_12;

import lesson_08.ObjectCollection;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class TestToLesson_08 {

    @Mock
    ObjectCollection sObjCol = new ObjectCollection();

    @Test
    public void TestAdd() {
        assertTrue(sObjCol.add("1"));
        assertEquals(sObjCol.size(), 1);
    }

    @Test
    public void TestGet() {
        sObjCol.add("1");
        sObjCol.add("2");
        assertEquals(sObjCol.get(0), "1");
        assertEquals(sObjCol.get(1), "2");
        assertNull(sObjCol.get(3));
    }

    @Test
    public void TestInsert() {
        sObjCol.add("2");
        assertTrue(sObjCol.add(0,"1"));
        assertEquals(sObjCol.size(), 2);
        assertEquals(sObjCol.get(0), "1");
    }

    @Test
    public void Delete() {
        sObjCol.add("1");
        sObjCol.add("2");
        assertTrue(sObjCol.delete("2"));
        assertFalse(sObjCol.delete("3"));
        assertEquals(sObjCol.size(), 1);
    }

    @Test
    public void TestContain(){
        sObjCol.add("1");
        assertTrue(sObjCol.contain("1"));
        assertFalse(sObjCol.contain("2"));
    }

    @Test
    public void Clear(){
        sObjCol.add("1");
        assertTrue(sObjCol.clear());
        assertEquals(sObjCol.size(), 0);
    }

    @Test
    public void TestEqual() {
        sObjCol.add("1");
        sObjCol.add("2");
        ObjectCollection testColl = new ObjectCollection(2);
        testColl.add("1");
        testColl.add("2");
        assertTrue(sObjCol.equals(testColl));
        testColl.clear();
        testColl.add("2");
        testColl.add("1");
        assertFalse(sObjCol.equals(testColl));
    }
}
