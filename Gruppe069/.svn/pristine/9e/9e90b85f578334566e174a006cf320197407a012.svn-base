package de.ostfalia.aud.ss25.a2;

import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.comparator.ComparatorId;

import java.util.Comparator;

public class AlgoArrayList implements IAlgoCollection<IMember> {

    private int arrayLastIndex = 0;
    private IMember[] array = new IMember[1];
    private boolean isSorted = false;
    private Comparator<IMember> sortCriteria = new ComparatorId();

    public boolean add(IMember m) {
        if (m == null) {
            return false;
        }
        if (arrayLastIndex >= array.length) {
            doubleSize();
        }
        array[arrayLastIndex++] = m;
        isSorted = false;
        return true;
    }

    @Override
    public boolean remove(IMember m) {
        ensureSortedBy(new ComparatorId());
        int targetIndex = findElement(m, sortCriteria);
        if (targetIndex == -1) {
            return false;
        }
        fillGap(targetIndex);
        return true;
    }

    @Override
    public IMember get(IMember m) {
        if (m == null) {
            return null;
        }
        ensureSortedBy(new ComparatorId());
        int index = findElement(m, sortCriteria);
        return index == -1 ? null : array[index];
    }

    @Override
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        ensureSortedBy(c);
        IMember[] found = findAllElements(m, c);
        IAlgoCollection<IMember> result = new AlgoArrayList();
        for (IMember e : found) {
            result.add(e);
        }
        return result;
    }

    @Override
    public int indexOf(IMember m) {
        ensureSortedBy(new ComparatorId());
        return findElement(m, sortCriteria);
    }

    @Override
    public int size() {
        return arrayLastIndex;
    }

    @Override
    public int size(Comparator<IMember> c, IMember m) {
        ensureSortedBy(c);
        return findAllElementsCount(m, c);
    }

    @Override
    public void sort(Comparator<IMember> c) {
        if (arrayLastIndex < 2) {
            return;
        }
        mergeSortInPlace(array, 0, arrayLastIndex - 1, c);
        isSorted = true;
        sortCriteria = c;
    }

    @Override
    public IMember[] toArray() {
        ensureSortedBy(new ComparatorId());
        IMember[] result = new IMember[arrayLastIndex];
        System.arraycopy(array, 0, result, 0, arrayLastIndex);
        return result;
    }

    private void ensureSortedBy(Comparator<IMember> c) {
        if (!isSorted || !sortCriteria.getClass().equals(c.getClass())) {
            sort(c);
        }
    }

    private void doubleSize() {
        IMember[] tmp = new IMember[array.length * 2];
        System.arraycopy(array, 0, tmp, 0, arrayLastIndex);
        array = tmp;
    }

    private void fillGap(int index) {
        for (int i = index; i < arrayLastIndex - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--arrayLastIndex] = null;
    }

    private int findElement(IMember m, Comparator<IMember> c) {
        int left = 0, right = arrayLastIndex - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = c.compare(array[mid], m);
            if (cmp == 0) {
                return mid;
            }
            if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findFirstIndex(IMember m, Comparator<IMember> c) {
        int left = 0, right = arrayLastIndex - 1, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = c.compare(array[mid], m);
            if (cmp == 0) {
                result = mid;
                right = mid - 1;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private int findLastIndex(IMember m, Comparator<IMember> c) {
        int left = 0, right = arrayLastIndex - 1, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = c.compare(array[mid], m);
            if (cmp == 0) {
                result = mid;
                left = mid + 1;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private IMember[] findAllElements(IMember m, Comparator<IMember> c) {
        int first = findFirstIndex(m, c);
        if (first == -1) {
            return new IMember[0];
        }
        int last = findLastIndex(m, c);
        int count = last - first + 1;
        IMember[] result = new IMember[count];
        System.arraycopy(array, first, result, 0, count);
        return result;
    }

    private int findAllElementsCount(IMember m, Comparator<IMember> c) {
        int first = findFirstIndex(m, c);
        if (first == -1) {
            return 0;
        }
        int last = findLastIndex(m, c);
        return last - first + 1;
    }

    private void mergeSortInPlace(IMember[] arr, int left, int right, Comparator<IMember> c) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSortInPlace(arr, left, mid, c);
        mergeSortInPlace(arr, mid + 1, right, c);
        mergeInPlace(arr, left, mid, right, c);
    }

    private void mergeInPlace(IMember[] arr, int left, int mid, int right, Comparator<IMember> c) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        IMember[] l = new IMember[n1];
        IMember[] r = new IMember[n2];

        for (int i = 0; i < n1; i++) {
            l[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            r[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (c.compare(l[i], r[j]) <= 0) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }

        while (i < n1) {
            arr[k++] = l[i++];
        }
        while (j < n2) {
            arr[k++] = r[j++];
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arrayLastIndex; i++) {
            s.append(array[i].toString()).append("\n");
        }
        return s.toString();
    }
}
