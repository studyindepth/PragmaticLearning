package effectivejava.chapter06;

import java.util.Comparator;

import com.google.common.collect.Ordering;

public enum MemberComparator implements Comparator<Member> {

    AGE_COMPARATOR {
        @Override
        public int compare(Member o1, Member o2) {
            return o1.getAge() - o2.getAge();
        }
    },
    NAME_COMPARATOR {

        @Override
        public int compare(Member o1, Member o2) {
            return STRING_NULL_LAST.compare(o1.getName(), o2.getName());
        }
    };

    private static Comparator<String> STRING_NULL_LAST = Ordering.natural().nullsLast();

}
