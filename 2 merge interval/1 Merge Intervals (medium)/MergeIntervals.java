import java.util.*;
import java.util.stream.Collectors;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return start;
  }

  public String toString() {
    return "["+start+", "+ end+ "]";
  }
};

class MergeIntervals {

  public static List<Interval> mergeIntervals(List<Interval> intervals) {
    List<Interval> sortedList = 
        intervals.stream().sorted(Comparator.comparingInt(Interval::getStart)).collect(Collectors.toList());
    Interval prev = sortedList.get(0);
    for(int i=1;i<sortedList.size();i++) {
      Interval curr = sortedList.get(i);
      if(prev.start < curr.start && prev.end < curr.start) {
        prev = curr;
        continue;
      }
     int newStart = prev.start;
     int newEnd = Math.max(prev.end, curr.end);
     curr.start = newStart;
     curr.end = newEnd;
     sortedList.remove(prev);
     prev = curr;
     i--;
    } 
    return sortedList;
  }

  public static void main(String[] args) {
    List<Interval> intervals= new ArrayList<Interval>();
    intervals.add(new Interval(1, 4));
    intervals.add(new Interval(2, 5));
    intervals.add(new Interval(7, 9));
    System.out.print("Output: ");
    List<Interval> interval = MergeIntervals.mergeIntervals(intervals);
    System.out.println(interval);
  }
}
