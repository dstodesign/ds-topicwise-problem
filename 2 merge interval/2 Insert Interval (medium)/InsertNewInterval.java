import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class InsertNewInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> mergedIntervals = new ArrayList<>();
    if(intervals.size() == 0) {
      mergedIntervals.add(newInterval);
      return mergedIntervals;
    }
    int start = 0;
    int end = intervals.size()-1;
    while(start < intervals.size() && intervals.get(start).end < newInterval.start){
      start++;
    }
    while(end >= 0 && intervals.get(end).start > newInterval.end){
      end--;
    }
    Interval mergedInterval = newInterval;
    if(start <= end)
      mergedInterval = new Interval(
        Math.min(intervals.get(start).start, newInterval.start),
        Math.max(intervals.get(end).end, newInterval.end)
      );
    int i=0;
    while(i<start && i<intervals.size()) {
      mergedIntervals.add(intervals.get(i));
      i++;
    }
    mergedIntervals.add(mergedInterval);
    i = end +1;
    while(i<intervals.size()) {
      mergedIntervals.add(intervals.get(i));
      i++;
    }
    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Output: ");
    for (Interval interval : InsertNewInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
  }
}
