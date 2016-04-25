package org.javatraining.collectionstest;

import org.javatraining.collections.LinkedList;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexander on 4/25/16.
 */
public class LinkedListTest {



    @Test
    public void removeFirstElementFromListByIndex() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(new Integer(1), list.remove(0));
        /*
        System.out.println(list.remove(0));
        System.out.println(list.remove(0));
        Object[] array = new Integer[0];
        array = list.toArray(array);
        for(int i=0;i<array.length;i++){
            System.out.println("d["+i+"]="+array[i]);
        }
*/

      //  assertArrayEquals(new Integer[]{2, 3, 4}, array);
      //  assertEquals(new Integer(2), list.remove(0));
    //    array = list.toArray(array);
     //   assertArrayEquals(new Integer[]{3, 4}, array);
    }


    @Test
    public void removeElementFromListIfUnsuccessful() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertFalse(list.remove(new Integer(8)));
    }

    @Test
    public void removeLastElementFromListIfSuccessful() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertTrue(list.remove(new Integer(4)));
        assertArrayEquals(new Integer[]{1, 2, 3}, list.toArray());
        list.add(5);
        assertArrayEquals(new Integer[]{1, 2, 3, 5}, list.toArray());
    }

    @Test
    public void removeFirstElementFromListIfSuccessful() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertTrue(list.remove(new Integer(1)));
        assertArrayEquals(new Integer[]{2, 3, 4}, list.toArray());
        list.add(5);
        assertArrayEquals(new Integer[]{2, 3, 4, 5}, list.toArray());
    }

    @Test
    public void removeElementFromListIfSuccessful() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertTrue(list.remove(new Integer(3)));
    }

    @Test
    public void removeElementFromListCheckListContent() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(new Integer(3));
        assertArrayEquals(new Integer[]{1, 2, 4}, list.toArray());
    }

    @Test(expected = NullPointerException.class)
    public void removeArgumentIsNull() throws Exception {
        list.add(2);
        list.remove(null);
    }

    @Test
    public void testToArrayListSizeGreaterThanArrayLength() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] array = new Integer[0];
        array = list.toArray(array);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    public void testToArrayListSizeLessThanArrayLength() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] array = new Integer[5];
        array = list.toArray(array);
        assertArrayEquals(new Integer[]{1, 2, 3, null, null}, array);
    }

    @Test
    public void testToArrayListFitsInSpecifiedArray() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer[] array = new Integer[4];
        array = list.toArray(array);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, array);
    }

    @Ignore
    @Test(expected = ArrayStoreException.class)
    public void toArrayDifferentTypes() throws Exception {
        Integer[] o = new Integer[5];
        Integer[] array;
        array = (Integer[]) list.toArray(o);
    }

    @Test(expected = NullPointerException.class)
    public void toArraySpecifiedArrayIsNull() throws Exception {
        list.toArray(null);
    }

    @Test
    public void testToArrayEmptyListIfSafe() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] array = list.toArray();
        list.add(4);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    public void testToArrayEmptyList() throws Exception {
        Object[] array = list.toArray();
        assertArrayEquals(new Integer[0], array);
    }

    @Test
    public void testToArray() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Object[] array = list.toArray();
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, array);
    }

    @Test(expected = NullPointerException.class)
    public void testIndexOfNull() throws Exception {
        list.indexOf(null);
    }

    @Test(expected = ClassCastException.class)
    public void testIndexOfIllegalArgument() throws Exception {
        Object object = "Test";
        list.indexOf((Integer) object);
    }

    @Test
    public void testIndexOfElementInEmptyList() throws Exception {
        assertEquals(-1, list.indexOf(0));
    }

    @Test
    public void testIndexOfElementIsAbsent() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(-1, list.indexOf(8));
    }

    @Test
    public void testIndexOfOnlyOneElement() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.indexOf(2));
    }

    @Test
    public void testIndexOf() throws Exception {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(1, list.indexOf(2));
    }

    @Test
    public void testLastIndexOfElementInEmptyList() throws Exception {
        assertEquals(-1, list.lastIndexOf(0));
    }

    @Test
    public void testLastIndexOfElementIsAbsent() throws Exception {
        list.add(5);
        list.add(2);
        list.add(5);
        list.add(2);
        assertEquals(-1, list.lastIndexOf(8));
    }

    @Test
    public void testLastIndexOfOnlyOneElement() throws Exception {
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(2);
        assertEquals(0, list.lastIndexOf(5));
    }

    @Test
    public void testLastIndexOf() throws Exception {
        list.add(5);
        list.add(2);
        list.add(5);
        list.add(2);
        assertEquals(2, list.lastIndexOf(5));
    }

    @Test(expected = NullPointerException.class)
    public void testLastIndexOfNull() throws Exception {
        list.lastIndexOf(null);
    }

    @Test(expected = ClassCastException.class)
    public void testLastIndexOfIllegalArgument() throws Exception {
        Object object = "Test";
        list.lastIndexOf((Integer) object);
    }

    @Test
    public void testContainsElementIsAbsent() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertFalse(list.contains(5));
    }

    @Test
    public void testContainsElementIsPresent() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.contains(2));
    }

    @Test(expected = ClassCastException.class)
    public void testContainsIllegalTypeOfArgument() throws Exception {
        Object o = "Test";
        list.contains((Integer) o);
    }

    @Test(expected = NullPointerException.class)
    public void testContainsNull() throws Exception {
        list.contains(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullIntoSpecifiedPosition() throws Exception {
        list.add(0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddElementIntoWrongPosition() throws Exception {
        list.add(5, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddElementIntoSpecifiedPositionNegativeIndex() throws Exception {
        list.add(-1, 2);
    }

    @Test
    public void testAddElementIntoSpecifiedPositionMemoryAllocation() throws Exception {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(5, 2);
        assertEquals(2, (Object) list.get(5));
    }

    @Test
    public void testAddElementIntoSpecifiedPosition() throws Exception {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.add(75, 17);
        assertEquals(17, (Object) list.get(75));
    }

    @Test(expected = ClassCastException.class)
    public void AddWrongTypeElementIntoIndex() throws Exception {
        Object text = "Test";
        list.add(0, (Integer) text);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullElementIntoIndex() throws Exception {
        list.add(0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddElementIntoNegativeIndex() throws Exception {
        list.add(-1, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddElementIntoWrongIndex() throws Exception {
        list.add(2, 8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfRangeIndex() throws Exception {
        list.get(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegativeIndex() throws Exception {
        list.get(-2);
    }

    @Test(expected = NullPointerException.class)
    public void testGetNull() throws Exception {
        Integer object = null;
        list.get(object);
    }

    @Test
    public void testGet() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, (Object) list.get(1));
    }


    @Test
    public void testClear() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test(expected = ClassCastException.class)
    public void testAddWrongTypeElement() throws Exception {
        Object text = "Test";
        list.add((Integer) text);
    }

    @Test
    public void testAddManyElements() throws Exception {
        for (int i = 0; i < 100; i++) {
            assertTrue(list.add(i));
        }
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullElement() throws Exception {
        list.add(null);
    }

    @Test
    public void testAddElement() throws Exception {
        assertTrue(list.add(2));
    }

    @Test
    public void testSizeIsZero() throws Exception {
        assertEquals(0, list.size());
    }

    @Test
    public void testSizeIsNotZero() throws Exception {
        list.add(5);
        list.add(9);
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(list.isEmpty());
    }

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<Integer>();
    }

    LinkedList<Integer> list;
}