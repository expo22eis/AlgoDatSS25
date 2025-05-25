package de.ostfalia.aud.ss25.a4;

import de.ostfalia.aud.ss25.a2.AlgoArrayList;
import de.ostfalia.aud.ss25.base.IAlgoCollection;
import de.ostfalia.aud.ss25.base.IMember;
import de.ostfalia.aud.ss25.comparator.ComparatorGroup;
import de.ostfalia.aud.ss25.comparator.ComparatorId;
import de.ostfalia.aud.ss25.comparator.ComparatorName;

import java.util.Comparator;

public class AlgoHashMap implements IAlgoCollection<IMember> {

    private Bucket<Integer, IAlgoCollection<IMember>>[] bucketList;
    private final Comparator<IMember> comparator;
    private int capacity;

    public AlgoHashMap(Comparator<IMember> comparator, int size) {
        this.comparator = comparator;
        this.bucketList = new Bucket[size];
        this.capacity = 0;
    }

    @Override
    public boolean add(IMember m) {
        if ((double) capacity / bucketList.length > 0.8) {
            resizeArray();
        }

        int hash = computeHashCode(m);
        int index = probeForIndex(hash, m, false);

        if (index == -1) {
            return false;
        }

        Bucket<Integer, IAlgoCollection<IMember>> bucket = bucketList[index];
        if (bucket == null) {
            bucket = new Bucket<>(hash);
            bucketList[index] = bucket;
        } else if (bucket.indexOf(m) >= 0) {
            return false;
        }

        bucket.add(m);
        capacity++;
        return true;
    }

    @Override
    public boolean remove(IMember m) {
        int hash = computeHashCode(m);
        int index = probeForIndex(hash, m, true);
        if (index == -1) {
            return false;
        }

        Bucket<Integer, IAlgoCollection<IMember>> bucket = bucketList[index];
        if (bucket != null && bucket.remove(m)) {
            capacity--;
            return true;
        }
        return false;
    }

    @Override
    public IMember get(IMember m) {
        int hash = computeHashCode(m);
        int index = probeForIndex(hash, m, true);
        return (index != -1) ? bucketList[index].get(m) : null;
    }

    @Override
    public IAlgoCollection<IMember> getAll(Comparator<IMember> c, IMember m) {
        int hash = computeHashCode(m);
        int index = probeForIndex(hash, m, true);

        if (index != -1) {
            return bucketList[index].getValues();
        }
        return new AlgoArrayList();
    }

    @Override
    public int indexOf(IMember m) {
        int hash = computeHashCode(m);
        return probeForIndex(hash, m, true);
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public int size(Comparator<IMember> c, IMember m) {
        int hash = computeHashCode(m);
        int index = probeForIndex(hash, m, true);
        if (index != -1) {
            return bucketList[index].size(c, m);
        }
        return 0;
    }

    @Override
    public IMember[] toArray() {
        AlgoArrayList all = new AlgoArrayList();
        for (Bucket<Integer, IAlgoCollection<IMember>> bucket : bucketList) {
            if (bucket != null) {
                for (IMember m : bucket.toArray()) {
                    all.add(m);
                }
            }
        }
        return all.toArray();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bucketList.length; i++) {
            Bucket<Integer, IAlgoCollection<IMember>> bucket = bucketList[i];
            if (bucket != null) {
                sb.append(String.format(
                        "Hashcode: %d. Erwartet an: %d, tatsächlich an: %d. Enthält:\n%s\n",
                        bucket.getKey(),
                        (bucket.getKey() & Integer.MAX_VALUE) % bucketList.length,
                        i,
                        bucket.getValues()
                ));
            }
        }
        return sb.toString();
    }


    private int computeHashCode(IMember m) {
        if (m == null) {
            return 0;
        }
        if (comparator instanceof ComparatorId) {
            return m.getId().hashCode();
        } else if (comparator instanceof ComparatorGroup) {
            return m.getGroup().toString().hashCode();
        } else if (comparator instanceof ComparatorName) {
            return (m.getSurname() + m.getForename()).hashCode();
        }
        return 0;
    }

    private void resizeArray() {
        Bucket<Integer, IAlgoCollection<IMember>>[] oldBuckets = bucketList;
        bucketList = new Bucket[oldBuckets.length * 2];
        capacity = 0;

        for (Bucket<Integer, IAlgoCollection<IMember>> bucket : oldBuckets) {
            if (bucket != null) {
                for (IMember m : bucket.getValues().toArray()) {
                    this.add(m);
                }
            }
        }
    }

    private int probeForIndex(int hash, IMember m, boolean expectExistence) {
        int index = (hash & Integer.MAX_VALUE) % bucketList.length;
        int startIndex = index;

        while (true) {
            Bucket<Integer, IAlgoCollection<IMember>> bucket = bucketList[index];
            if (bucket == null) {
                if (expectExistence) {
                    return -1;
                }
                else{
                    return index;
                }
            }
            if (bucket.getKey().equals(hash)) {
                return index;
            }

            index = (index + 1) % bucketList.length;
            if (index == startIndex) {
                break;
            }
        }
        return -1;
    }
}
