import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> insertInterval = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentEnd < newStart) {
                insertInterval.add(intervals[i]);
            } else if (currentStart > newEnd) {
                insertInterval.add(new int[] {newStart, newEnd});
                newStart = currentStart;
                newEnd = currentEnd;
            } else {
                newStart = Math.min(newStart, currentStart);
                newEnd = Math.max(newEnd, currentEnd);
            }
        }
        insertInterval.add(new int[] {newStart, newEnd});

        return insertInterval.toArray(new int[insertInterval.size()][2]);
    }
}
